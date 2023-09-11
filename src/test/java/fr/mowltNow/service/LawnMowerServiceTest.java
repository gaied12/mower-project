package fr.mowltNow.service;

import static org.junit.Assert.*;

import fr.mowltnow.exception.AppException;
import fr.mowltnow.model.Lawn;
import fr.mowltnow.model.Mower;
import fr.mowltnow.model.Position;
import fr.mowltnow.model.enums.Command;
import fr.mowltnow.model.enums.Orientation;
import fr.mowltnow.service.impl.LawnMowerServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LawnMowerServiceTest {

    private LawnMowerServiceImpl lawnMowerService;

    @Before
    public void setUp() {
        lawnMowerService = LawnMowerServiceImpl.getInstance();
    }

    @Test
    public void testGetGridSize() {
        String gridSize = "5 5";
        Lawn lawn  = lawnMowerService.getGridSize(gridSize,Lawn.getInstance());
        assertNotNull(lawn);
        assertEquals(5, lawn.getGridMaxSize().getX());
        assertEquals(5, lawn.getGridMaxSize().getY());
    }
    @Test
    public void testCreateMowerFromInput() {
        String mowerInput = "3 4 N";
        Mower mower = lawnMowerService.createMowerFromInput(mowerInput);

        assertEquals(3, mower.getPosition().getX());
        assertEquals(4, mower.getPosition().getY());
        assertEquals(Orientation.NORTH, mower.getPosition().getOrientation());
    }



    @Test
    public void testValidateAndConvertCommands() {
        String commands = "GAGAGAA";
        List<Command> commandList = lawnMowerService.validateAndConvertCommands(commands);
        assertNotNull(commandList);
        assertEquals(7, commandList.size());
    }
}
