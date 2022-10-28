package se.iths.tt.javafxtt.inventory;

import java.math.BigDecimal;

public class ProductBuilder {
    private String productName;
    private String eanCode;
    private BigDecimal price;
    private Category category;

    public ProductBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder setEanCode(String eanCode) {
        this.eanCode = eanCode;
        return this;
    }

    public ProductBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Product createProduct() {
        return new Product(productName, eanCode, price, category);
    }
}