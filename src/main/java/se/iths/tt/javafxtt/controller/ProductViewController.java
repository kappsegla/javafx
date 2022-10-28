package se.iths.tt.javafxtt.controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.BigDecimalStringConverter;
import se.iths.tt.javafxtt.inventory.Product;
import se.iths.tt.javafxtt.model.ProductModel;

import java.io.File;
import java.nio.file.Path;

public class ProductViewController {

    ProductModel productModel = new ProductModel();

    public TextField nameTextField;
    public TextField eanTextField;
    public TextField priceTextField;
    public TextField categoryTextField;
    public Button addButton;
    public Button saveButton;
    public ListView<Product> productListView;

    public Stage stage;

    public void initialize() {
        productListView.setItems(productModel.getProductObservableList());
        nameTextField.textProperty().bindBidirectional(productModel.productNameProperty());
        priceTextField.textProperty().bindBidirectional(productModel.productPriceProperty(),new BigDecimalStringConverter());
        eanTextField.textProperty().bindBidirectional(productModel.productEanProperty());
        categoryTextField.textProperty().bindBidirectional(productModel.productCategoryProperty());
        saveButton.disableProperty().bind(Bindings.isEmpty(productModel.getProductObservableList()));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void onAddAction(ActionEvent actionEvent) {
        productModel.createProduct();
    }

    public void onSaveAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV","*.csv"));

        File filePath = fileChooser.showSaveDialog(stage);

         if( filePath != null)
            productModel.saveToFile(filePath.toPath());
    }
}
