package se.iths.tt.javafxtt.model;

import java.util.ArrayList;
import java.util.List;

public class SnakeModel {
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
        this.direction = Direction.UP;
        this.positionList.add(position);
    }

    public Position getPosition() {
        return position;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void update() {
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
        if (!direction.equals(Direction.DOWN))
            this.direction = Direction.UP;
    }

    public void setDown() {
        if (!direction.equals(Direction.UP))
            this.direction = Direction.DOWN;
    }

    public void setRight() {
        if (!direction.equals(Direction.LEFT))
            this.direction = Direction.RIGHT;
    }

    public void setLeft() {
        if (!direction.equals(Direction.RIGHT))
            this.direction = Direction.LEFT;
    }
    

}

