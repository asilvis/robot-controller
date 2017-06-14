package br.com.contaazul.nasa.mars.entity;

/**
 * Created by maveco on 08/06/17.
 */
public class MarsTerrain implements Terrain {

    private Integer width;
    private Integer height;

    public MarsTerrain(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public Boolean isValidLocation(Integer x, Integer y) {
        if (x < 0 || y < 0) {
            return false;
        } else if ( x > width || y > height) {
            return false;
        }

        return true;
    }
}
