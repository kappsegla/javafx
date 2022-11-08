package se.iths.tt.javafxtt.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PizzaPlace {

    public static void main(String[] args) {

        Pizza pizza;
        pizza = new FarmHouse();

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());

        Pizza decorated = new PineappleDecorator(new BaconDecorator(pizza));

        System.out.println(decorated.getDescription());
        System.out.println(decorated.getPrice());
    }

    public static Pizza addPineApple(Pizza pizza){
        return new PineappleDecorator(pizza);
    }
}
