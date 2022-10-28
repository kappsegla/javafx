package se.iths.tt.javafxtt.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.iths.tt.javafxtt.inventory.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductModel {

    StringProperty productName = new SimpleStringProperty();

    StringProperty productEan = new SimpleStringProperty();

    ObjectProperty<BigDecimal> productPrice = new SimpleObjectProperty<>();

    StringProperty productCategory = new SimpleStringProperty();

    ObservableList<Product> productObservableList = FXCollections.observableArrayList();

    public ObservableList<Product> getProductObservableList() {
        return productObservableList;
    }

    public void setProductObservableList(ObservableList<Product> productObservableList) {
        this.productObservableList = productObservableList;
    }

    public String getProductName() {
        return productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public String getProductEan() {
        return productEan.get();
    }

    public StringProperty productEanProperty() {
        return productEan;
    }

    public void setProductEan(String productEan) {
        this.productEan.set(productEan);
    }

    public BigDecimal getProductPrice() {
        return productPrice.get();
    }

    public ObjectProperty<BigDecimal> productPriceProperty() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice.set(productPrice);
    }

    public String getProductCategory() {
        return productCategory.get();
    }

    public StringProperty productCategoryProperty() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory.set(productCategory);
    }

    public void createProduct() {


    }

    public void saveToFile(Path file) {
        StringBuffer outPut = new StringBuffer();
        for (Product p : productObservableList) {
            outPut.append(p.getProductName());
            outPut.append(",");
            outPut.append(p.getEanCode());
            outPut.append(",");
            outPut.append(p.getPrice());
            outPut.append(",");
            outPut.append(p.getCategory().getCategoryName());
            outPut.append("\n");
        }
        try {
            Files.writeString(file,outPut.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
