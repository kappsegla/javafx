package se.iths.tt.javafxtt.controller;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import se.iths.tt.javafxtt.model.ChatViewModel;

public class ChatViewController {

    ChatViewModel model = new ChatViewModel();
    public TextField messageField;
    public Button sendButton;
    public ListView<String> messagesListView;

    public void initialize(){
       messageField.textProperty().bindBidirectional(model.messageProperty());
       messagesListView.setItems(model.getObservableList());
       sendButton.disableProperty().bind(model.messageProperty().isEmpty());
       sendButton.textProperty().bind(Bindings.when(model.messageProperty().isEqualTo("secret"))
               .then("Hemligt")
               .otherwise("Send message"));

    }

    public void sendMessageClicked() {
        //Handle button action
        model.sendMessage();
    }

}
