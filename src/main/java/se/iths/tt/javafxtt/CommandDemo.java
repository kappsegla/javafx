package se.iths.tt.javafxtt;

import java.util.*;

public class CommandDemo {

    static Deque<Command> undoStack = new ArrayDeque<>();

    public static void main(String[] args) {
        List<MutableItem> items = new ArrayList<>();

        items.forEach(System.out::println);
        System.out.println("------------");

        MutableItem message = new MutableItem(1, "Hej");
        items.add(message);
        Command undo1 = () -> items.remove(message);
        undoStack.push(undo1);

        items.forEach(System.out::println);
        System.out.println("------------");

        MutableItem message2 = new MutableItem(2, "Då");
        items.add(message2);
        Command undo2 = () -> items.remove(message2);
        undoStack.push(undo2);

        items.forEach(System.out::println);
        System.out.println("------------");

        MutableItem message3 = items.get(1);
        String oldTextValue = message3.getText();
        message3.setText("Welcome");
        Command undo3 = () -> message3.setText(oldTextValue);
        undoStack.push(undo3);

        items.forEach(System.out::println);
        System.out.println("------------");

        Command undoToExecute = undoStack.pop();
        undoToExecute.execute();

        items.forEach(System.out::println);
        System.out.println("------------");

        undoToExecute = undoStack.pop();
        undoToExecute.execute();

        items.forEach(System.out::println);
        System.out.println("------------");
        undoToExecute = undoStack.pop();

        undoToExecute.execute();

        items.forEach(System.out::println);
        System.out.println("------------");


    }
}

class MutableItem {
    final int number;
    String text;

    public MutableItem(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableItem that = (MutableItem) o;
        return number == that.number && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, text);
    }

    @Override
    public String toString() {
        return "MutableItem{" +
                "number=" + number +
                ", text='" + text + '\'' +
                '}';
    }
}

@FunctionalInterface
interface Command {
    void execute();
}