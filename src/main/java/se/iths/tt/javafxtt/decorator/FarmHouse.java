package se.iths.tt.javafxtt.decorator;

public class FarmHouse extends Pizza {
    @Override
    String getDescription() {
        return "🧀🍅🍄🧅🌶";
    }

    @Override
    int getPrice() {
        return 150;
    }
}
