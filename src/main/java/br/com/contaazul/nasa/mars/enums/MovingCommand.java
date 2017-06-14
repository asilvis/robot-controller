package br.com.contaazul.nasa.mars.enums;

/**
 * Created by maveco on 27/04/17.
 */
public enum MovingCommand {

   L(-1, 0), R(1, 0), M(0, 1);

    private Integer sideUnits;
    private Integer forwardUnits;

    MovingCommand(Integer sideUnits, Integer forwardUnits) {
        this.sideUnits = sideUnits;
        this.forwardUnits = forwardUnits;
    }

    public Boolean isChangingDirection() {
        return this.getSideUnits() != 0;
    }

    public Integer getSideUnits() {
        return sideUnits;
    }

    public Integer getForwardUnits() {
        return forwardUnits;
    }
}
