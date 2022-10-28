package se.iths.tt.javafxtt.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;

public class ProductModel {

    StringProperty productName = new SimpleStringProperty();

    StringProperty productEan = new SimpleStringProperty();

    ObjectProperty<BigDecimal> productPrice = new SimpleObjectProperty<>();

    StringProperty productCategory = new SimpleStringProperty();



}
