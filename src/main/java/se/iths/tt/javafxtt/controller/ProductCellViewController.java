package se.iths.tt.javafxtt.controller;

import javafx.scene.control.Label;
import se.iths.tt.javafxtt.inventory.Product;

public class ProductCellViewController {


    public Label name;
    public Label ean;
    public Label price;
    public Label category;

    //This is our model for one cell
    Product product;

    public void setProduct(Product product) {
        this.product = product;
        name.setText(product.getProductName());
        ean.setText(product.getEanCode());
        price.setText(product.getPrice().toString());
        category.setText(product.getCategory().getCategoryName());

    }
}
