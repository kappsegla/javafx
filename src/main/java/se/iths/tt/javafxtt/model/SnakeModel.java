package se.iths.tt.javafxtt.model;

import java.util.ArrayList;
import java.util.List;

import static se.iths.tt.javafxtt.model.Direction.*;

public class SnakeModel {
    public static final int TOP_EDGE = 0;
    private Position position;
    private Direction direction;

    private List<Position> positionList = new ArrayList<>();

    public SnakeModel(Position position, Direction direction, List<Position> positionList) {
        this.position = position;
        this.direction = direction;
        this.positionList = positionList;
    }

    public SnakeModel() {
        this.position = new Position(19, 19);
        this.direction = UP;
        this.positionList.add(position);
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void update() {
        if( position.y() == TOP_EDGE && direction == UP)
            return;

        switch (direction) {
            case UP -> positionList.add(0,position = new Position(position.x(), position.y() - 1));
            case DOWN -> positionList.add(0,position = new Position(position.x(), position.y() + 1));
            case LEFT -> positionList.add(0,position = new Position(position.x() - 1, position.y()));
            case RIGHT -> positionList.add(0,position = new Position(position.x() + 1, position.y()));
        }

        //Todo: If not eating an apple, remove last segment from list.

        //Todo: If colliding with walls. Game over. Stop updating.

        //Todo: Colliding with ourself Game over.

    }

    public void setUp() {
        if (!direction.equals(DOWN))
            this.direction = UP;
    }

    public void setDown() {
        if (!direction.equals(UP))
            this.direction = DOWN;
    }

    public void setRight() {
        if (!direction.equals(LEFT))
            this.direction = RIGHT;
    }

    public void setLeft() {
        if (!direction.equals(RIGHT))
            this.direction = LEFT;
    }
}

