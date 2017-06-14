package br.com.contaazul.nasa.mars.service;

import br.com.contaazul.nasa.mars.entity.Position;
import br.com.contaazul.nasa.mars.entity.Robot;
import br.com.contaazul.nasa.mars.entity.Terrain;
import br.com.contaazul.nasa.mars.enums.MovingCommand;
import br.com.contaazul.nasa.mars.enums.Orientation;
import br.com.contaazul.nasa.mars.exception.OrientationException;
import br.com.contaazul.nasa.mars.exception.OutOfBoundsException;
import javafx.geometry.Pos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.contaazul.nasa.mars.enums.Orientation.*;

/**
 * Created by maveco on 08/06/17.
 */
@Service
public class MoveServiceImpl implements MoveService {

    private Orientation newOrientation;

    @Override
    public Robot move(Robot robot, String commands) {
        List<MovingCommand> movingCommands = commands.chars()
                .mapToObj(i -> (char) i)
                .map(letter -> MovingCommand.valueOf(letter.toString()))
                .collect(Collectors.toList());

        movingCommands.forEach(mc -> {

            Position newPosition = getNewPosition(robot.getCurrentPosition(), mc);
            if(robot.getTerrain().isValidLocation(newPosition.getX(), newPosition.getY())) {
                robot.setCurrentPosition(newPosition);
            } else {
              throw new OutOfBoundsException("Robot is out of bounds! " + newPosition.toString());
            }

        });

        return robot;
    }

    public Position getNewPosition(Position current, MovingCommand movingCommand) {
        Position position = new Position();

        position.setOrientation(getNewOrientation(current.getOrientation(), movingCommand));
        position.setX(current.getX());
        position.setY(current.getY());

        if (movingCommand.isChangingDirection()) {
            return position;
        }

        switch (current.getOrientation()) {
            case NORTH:
                position.setX(position.getX()+1);
                break;
            case EAST:
                position.setY(position.getY()+1);
                break;
            case SOUTH:
                position.setX(position.getX()-1);
                break;
            case WEST:
                position.setY(position.getY()-1);
                break;
        }

        return position;
    }

    public Orientation getNewOrientation(Orientation current, MovingCommand movingCommand) {
        if (!movingCommand.isChangingDirection()) {
            return current;
        }

        switch (current) {
            case NORTH:
                return movingCommand.getSideUnits() < 0 ? WEST : EAST;
            case EAST:
                return movingCommand.getSideUnits() < 0 ? NORTH : SOUTH;
            case SOUTH:
                return movingCommand.getSideUnits() < 0 ? EAST : WEST;
            case WEST:
                return movingCommand.getSideUnits() < 0 ? SOUTH : NORTH;
        }

        throw new OrientationException("Can not calculate next orientation! current: " + current + " MovingCommand: " + movingCommand);
    }
}
