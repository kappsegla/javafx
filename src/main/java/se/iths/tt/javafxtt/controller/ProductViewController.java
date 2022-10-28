package se.iths.tt.javafxtt.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import se.iths.tt.javafxtt.inventory.Product;
import se.iths.tt.javafxtt.model.ProductModel;

public class ProductViewController {

    ProductModel productModel = new ProductModel();

    public TextField nameTextField;
    public TextField eanTextField;
    public TextField priceTextField;
    public TextField categoryTextField;
    public Button addButton;
    public Button saveButton;
    public ListView<Product> productListView;

    public void initialize(){



    }


    public void onAddAction(ActionEvent actionEvent) {

    }

    public void onSaveAction(ActionEvent actionEvent) {


    }
}
