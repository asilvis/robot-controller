package br.com.contaazul.nasa.mars.entity;

/**
 * Created by maveco on 08/06/17.
 */
public class Robot {

    private Terrain terrain;
    private Position currentPosition;

    public Robot() {
    }

    public Robot(Terrain terrain, Position currentPosition) {
        this.terrain = terrain;
        this.currentPosition = currentPosition;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}
