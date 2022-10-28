package se.iths.tt.javafxtt.model;

import org.junit.jupiter.api.Test;
import se.iths.tt.javafxtt.inventory.Category;
import se.iths.tt.javafxtt.inventory.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductModelTest {

    @Test
    void createNewProductAddsNewProductToProductList() {
        //arrange
        ProductModel productModel = new ProductModel();
        productModel.setProductName("Milk");
        productModel.setProductEan("123456789");
        productModel.setProductPrice(BigDecimal.TEN);
        productModel.setProductCategory("Dairy");

        //act
        productModel.createProduct();

        //assert
        assertEquals(1, productModel.getProductObservableList().size());
        assertEquals(
                new Product("Milk", "123456789", BigDecimal.TEN, Category.of("Dairy")),
                productModel.getProductObservableList().get(0));
        var product = productModel.getProductObservableList().get(0);
        assertEquals("Milk", product.getProductName());
        assertEquals(BigDecimal.TEN, product.getPrice());
        assertEquals(Category.of("Dairy"), product.getCategory());


    }

}