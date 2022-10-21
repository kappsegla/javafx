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
}

