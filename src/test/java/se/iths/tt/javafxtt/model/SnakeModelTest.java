package se.iths.tt.javafxtt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeModelTest {
    SnakeModel snake = new SnakeModel();

    @Test
    void createNewSnakeModelPositionsSnakeAt1919() {
        var expected = new Position(19, 19);
        var actual = snake.getPosition();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("When calling setUp on Snake update will move the snake one step in the up direction.")
    void callingSetUpOnSnakeMovesSnakeInUpDirectionWhenUpdateIsCalled() {
        snake.setUp();
        snake.update();

        var expected = new Position(19, 18);
        var actual = snake.getPosition();
        assertEquals(expected, actual);
    }

    @Test
    void callingSetDownOnSnakeWhenDirectionIsUpMovesSnakeInUpDirectionWhenUpdateIsCalled() {
        snake.setDown();
        snake.update();

        var expected = new Position(19, 18);
        var actual = snake.getPosition();
        assertEquals(expected, actual);
        assertEquals(Direction.UP, snake.getDirection());
    }

    @Test
    void callingLeftUpdateLeftUpdateMovesSnake() {
        snake.setLeft();
        snake.update();
        snake.setLeft();
        snake.update();
        var expected = new Position(17, 19);
        var actual = snake.getPosition();
        assertEquals(expected, actual);
        assertEquals(Direction.LEFT, snake.getDirection());
    }


}