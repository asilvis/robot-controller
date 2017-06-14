package br.com.contaazul.nasa.mars.entity;

import br.com.contaazul.nasa.mars.enums.Orientation;

/**
 * Created by maveco on 08/06/17.
 */
public class Position {

    private Integer x;
    private Integer y;
    private Orientation orientation;

    public Position() {
    }

    public Position(Integer x, Integer y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + orientation + ')';
    }
}
