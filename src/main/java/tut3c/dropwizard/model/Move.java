package tut3c.dropwizard.model;

public class Move {

    private int row;
    private int column;
    private String mark;

    protected Move() {
    }

    public Move(int row, int column, String mark) {
        this.row = row;
        this.column = column;
        this.mark = mark;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getMark() {
        return mark;
    }
}
