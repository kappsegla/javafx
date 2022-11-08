package se.iths.tt.javafxtt.decorator;

public class Margherita extends Pizza {
    @Override
    String getDescription() {
        return "🧀🍅";
    }

    @Override
    int getPrice() {
        return 100;
    }
}
