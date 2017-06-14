package br.com.contaazul.nasa.mars.service;

import br.com.contaazul.nasa.mars.entity.MarsTerrain;
import br.com.contaazul.nasa.mars.entity.Position;
import br.com.contaazul.nasa.mars.entity.Robot;
import br.com.contaazul.nasa.mars.entity.Terrain;
import br.com.contaazul.nasa.mars.enums.Orientation;
import org.springframework.stereotype.Service;

/**
 * Created by maveco on 08/06/17.
 */
@Service
public class RobotServiceImpl implements RobotService{

    public Robot initial() {
        Terrain terrain = new MarsTerrain(5,5);
        Position startingPos = new Position(0,0, Orientation.NORTH);
        return new Robot(terrain, startingPos);
    }

}
