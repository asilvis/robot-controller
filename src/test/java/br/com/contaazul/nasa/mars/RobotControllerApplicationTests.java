package br.com.contaazul.nasa.mars;

import br.com.contaazul.nasa.mars.entity.Position;
import br.com.contaazul.nasa.mars.enums.Orientation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RobotControllerApplicationTests {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void invalidMove() throws Exception {
        moveWithError("AAA");
    }

    @Test
    public void invalidMove2() throws Exception {
        moveWithError("MMMMMMMMMMMMMMMMMMMMMMMM");
    }

    @Test
    public void moveWithRightRotation() throws Exception {
        move("MMRMMRMM", new Position(0, 2, Orientation.SOUTH));
    }

    @Test
    public void moveWithLeftRotation() throws Exception {
        moveWithError("MMLMMLMM");
    }

    @Test
    public void moveRight() throws Exception {
        move("MML", new Position(2, 0, Orientation.WEST));
    }

    @Test
    public void moveRightWithRepetition() throws Exception {
        move("MML", new Position(2, 0, Orientation.WEST));
        move("MML", new Position(2, 0, Orientation.WEST));
    }

    @Test
    public void moveLeft() throws Exception {
        move("MMR", new Position(2, 0, Orientation.EAST));
    }

    private void move(String command, Position expectedPosition) throws Exception {
        Position current = this.restTemplate.postForObject("http://localhost:" + port + "/rest/mars/" + command, null, Position.class);
        assertEquals("Wrong Orientation", expectedPosition.getOrientation(), current.getOrientation());
        assertEquals("Wrong X", expectedPosition.getX(), current.getX());
        assertEquals("Wrong Y", expectedPosition.getY(), current.getY());
    }

    private void moveWithError(String command) throws Exception {
        ResponseEntity<Position> current = this.restTemplate.exchange("http://localhost:" + port + "/rest/mars/" + command, HttpMethod.POST, null, Position.class);
        assertEquals("Expected Failure!", HttpStatus.BAD_REQUEST.value(), current.getStatusCodeValue());
    }

}
