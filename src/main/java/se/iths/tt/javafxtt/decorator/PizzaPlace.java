package se.iths.tt.javafxtt.decorator;

public class PizzaPlace {

    public static void main(String[] args) {
        Pizza pizza;
        pizza = new FarmHouse();

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());

    }
}
