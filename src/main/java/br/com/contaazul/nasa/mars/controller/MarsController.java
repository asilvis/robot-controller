package br.com.contaazul.nasa.mars.controller;

import br.com.contaazul.nasa.mars.entity.MarsTerrain;
import br.com.contaazul.nasa.mars.entity.Terrain;
import br.com.contaazul.nasa.mars.enums.Orientation;
import br.com.contaazul.nasa.mars.service.MoveService;
import br.com.contaazul.nasa.mars.entity.Position;
import br.com.contaazul.nasa.mars.entity.Robot;
import br.com.contaazul.nasa.mars.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by maveco on 08/06/17.
 */
@RestController
@RequestMapping(value="/rest/mars")
public class MarsController {

    @Autowired
    private MoveService moveService;

    @Autowired
    private RobotService robotService;

    @RequestMapping(value = "/{movingCommands}", method = RequestMethod.POST)
    public Position move(@PathVariable String movingCommands) {
        Robot robot = robotService.initial();
        moveService.move(robot, movingCommands);
        return robot.getCurrentPosition();
    }
}
