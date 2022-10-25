package se.iths.tt.javafxtt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static se.iths.tt.javafxtt.model.SnakeModel.TOP_EDGE;

class SnakeModelTest {
    private static final int DISTANCE_TO_GAMEBOARD_EDGE = 19;
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

    @Test
    void callingUpdateOnSnakePositionedAtPosYZeroAndDirectionUpShouldNotMovePosition() {
        //Arrange
        for (int i = 0; i < DISTANCE_TO_GAMEBOARD_EDGE; i++) {
            snake.update();
        }
        int TOP_EDGE = 0;
        assertEquals(TOP_EDGE, snake.getPosition().y());
        //Act
        snake.update();
        //Assert
        assertEquals(new Position(19,0),snake.getPosition());
    }

    @Test
    void callingUpdateOnSnakePositionedAtPosYZeroAndDirectionLeftShouldMovePosition() {
        //Arrange
        for (int i = 0; i < DISTANCE_TO_GAMEBOARD_EDGE; i++) {
            snake.update();
        }

        assertEquals(TOP_EDGE, snake.getPosition().y());
        //Act
        snake.setLeft();
        snake.update();
        //Assert
        assertEquals(new Position(18,0),snake.getPosition());
    }



}