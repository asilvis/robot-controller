package br.com.contaazul.nasa.mars.enums;

public enum Orientation {

    NORTH("N"), WEST("W"), EAST("E"), SOUTH("S");

    private String initials;

    Orientation(String initials) {
        this.initials = initials;
    }

    public String getInitials() {
        return initials;
    }
}
