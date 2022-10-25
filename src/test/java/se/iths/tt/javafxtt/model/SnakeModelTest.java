package se.iths.tt.javafxtt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeModelTest {

    @Test
    void createNewSnakeModelPositionsSnakeAt1919(){

        SnakeModel snake = new SnakeModel();

        var expected = new Position(19,19);
        var actual = snake.getPosition();

        assertEquals(expected, actual);
    }


}