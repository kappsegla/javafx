package se.iths.tt.javafxtt.model;

public class SnakeModel {
    private Position position;
    private Direction direction;

    public SnakeModel(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public SnakeModel() {
        this.position = new Position(19, 19);
        this.direction = Direction.UP;
    }

    public Position getPosition() {
        return position;
    }

    public void update() {
        switch (direction) {
            case UP -> position = new Position(position.x(), position.y() - 1);
            case DOWN -> position = new Position(position.x(), position.y() + 1);
            case LEFT -> position = new Position(position.x() - 1, position.y());
            case RIGHT -> position = new Position(position.x() + 1, position.y());
        }
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

