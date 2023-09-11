package fr.mowltNow.service;

import static org.junit.Assert.*;

import fr.mowltnow.model.Mower;
import fr.mowltnow.model.Position;
import fr.mowltnow.model.enums.Command;
import fr.mowltnow.model.enums.Orientation;
import fr.mowltnow.service.impl.MowerMoveServiceImpl;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;

public class MowerMoveServiceImplTest {
    private MowerMoveServiceImpl mowerMoveService;

    @Before
    public void setUp() {
        mowerMoveService = MowerMoveServiceImpl.getInstance();
    }

    @Test
    public void testMoveMower_ForwardNorth() {
        Mower mower = Mower.builder()
                .mowerCommands(Arrays.asList(Command.FORWARD))
                .position(Position.builder().x(2).y(2).orientation(Orientation.NORTH).build())
                .build();
        int maxX = 5;
        int maxY = 5;

        Mower result = mowerMoveService.moveMower(mower, maxX, maxY);

        assertNotNull(result);
        assertEquals(2, result.getPosition().getX());
        assertEquals(3, result.getPosition().getY());
        assertEquals(Orientation.NORTH, result.getPosition().getOrientation());
    }

    @Test
    public void testMoveMower_TurnRight() {
        Mower mower = Mower.builder()
                .mowerCommands(Arrays.asList(Command.RIGHT))
                .position(Position.builder().x(3).y(3).orientation(Orientation.EAST).build())
                .build();
        int maxX = 5;
        int maxY = 5;

        Mower result = mowerMoveService.moveMower(mower, maxX, maxY);

        assertNotNull(result);
        assertEquals(Orientation.SOUTH, result.getPosition().getOrientation());
    }

    @Test
    public void testMoveMower_TurnLeft() {
        Mower mower = Mower.builder()
                .mowerCommands(Arrays.asList(Command.LEFT))
                .position(Position.builder().x(4).y(4).orientation(Orientation.WEST).build())
                .build();
        int maxX = 5;
        int maxY = 5;

        Mower result = mowerMoveService.moveMower(mower, maxX, maxY);

        assertNotNull(result);
        assertEquals(Orientation.SOUTH, result.getPosition().getOrientation());
    }

    @Test
    public void testMoveMower_OutOfBounds_Lawn() {
        Mower mower = Mower.builder()
                .mowerCommands(Arrays.asList(Command.FORWARD))
                .position(Position.builder().x(5).y(5).orientation(Orientation.NORTH).build())
                .build();
        int maxX = 5;
        int maxY = 5;

        Mower result = mowerMoveService.moveMower(mower, maxX, maxY);

        assertNotNull(result);
        assertEquals(5, result.getPosition().getX());
        assertEquals(5, result.getPosition().getY());
        assertEquals(Orientation.NORTH, result.getPosition().getOrientation());
    }

}
