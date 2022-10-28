package se.iths.tt.javafxtt.inventory;

import java.math.BigDecimal;
import java.util.*;

public class Inventory {

    List<Product> productList = new ArrayList<>();

    Map<Product, Integer> stock = new HashMap<>();

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.createAndAddNewProduct(scanner);
        Optional<Product> product = inventory.findProductByEanCode("1234567890123");
        Optional<Product> productByName = inventory.findProductByName("Java coding");
        List<Product> productsByPriceRange = inventory.findProductsByPriceRange(new BigDecimal("10.0"), new BigDecimal("100.0"));
    }

    public List<Product> findProductsByPriceRange(BigDecimal min, BigDecimal max) {
        return productList.stream()
                .filter(product -> product.getPrice().compareTo(min) > 0)
                .filter(product -> product.getPrice().compareTo(max) < 0) //Med andra ord kan man skriva sub istället?
                .toList();
    }

    public Optional<Product> findProductByName(String productName) {
        return productList.stream()
                .filter(product -> product.getProductName().equals(productName))
                .findAny();
    }

    public Optional<Product> findProductByEanCode(String eanCode) {
        return productList.stream()
                .filter(product -> product.getEanCode().equals(eanCode))
                .findAny();
    }

    public void createAndAddNewProduct(Scanner scanner) {

        System.out.println("Skriv in produktnamn");
        String productName = scanner.nextLine();
        System.out.println("Skriv in ean code");
        String eanCode = scanner.nextLine();
        System.out.println("Skriv in produktens pris");
        BigDecimal price = BigDecimal.valueOf(parseInput(scanner));
        System.out.println("Skriv in kategori");
        Category category = Category.of(scanner.nextLine());

        ProductBuilder productBuilder = new ProductBuilder();
        Product product = productBuilder
                .setEanCode(eanCode)
                .setProductName(productName)
                .setPrice(price)
                .setCategory(category)
                .createProduct();

//        new AProductBuilder().setEanCode(eanCode)
//                .setProductName(productName)
//                .setPrice(price)
//                .setCategory(category)
//                .createProduct();

        productList.add(product);

        //productList.add(new Product(productName, eanCode, price, category));
    }

    private Double parseInput(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Var vänlig skriv in ett tal.");
            }
        }


    }


}
