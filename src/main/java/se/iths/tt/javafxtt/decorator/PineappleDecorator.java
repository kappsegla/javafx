package se.iths.tt.javafxtt.decorator;

public class PineappleDecorator extends PizzaDecorator{
    public PineappleDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + "🍍";
    }

    @Override
    int getPrice() {
        return pizza.getPrice() + 20;
    }
}
