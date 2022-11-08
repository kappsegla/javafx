package se.iths.tt.javafxtt.decorator;

public class BaconDecorator extends PizzaDecorator{

    public BaconDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + "🥓";
    }

    @Override
    int getPrice() {
        return getPizza().getPrice() + 10;
    }
}
