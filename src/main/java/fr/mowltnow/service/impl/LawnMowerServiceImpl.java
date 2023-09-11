package fr.mowltnow.service.impl;

import fr.mowltnow.exception.AppException;
import fr.mowltnow.model.Grid;
import fr.mowltnow.model.Lawn;
import fr.mowltnow.model.Mower;
import fr.mowltnow.model.Position;
import fr.mowltnow.model.enums.Command;
import fr.mowltnow.model.enums.Orientation;
import fr.mowltnow.service.LawnMowerService;
import fr.mowltnow.utils.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
public class LawnMowerServiceImpl implements LawnMowerService {


    /**
     * Validates and converts a string of commands into a list of Command objects.
     *
     * @param commands The string containing commands to be validated and converted.
     * @return A list of Command objects representing the validated and converted commands.
     * */
    @Override
    public List<Command> validateAndConvertCommands(String commands) {
        return Arrays.stream(commands.split(Constants.WITH_OUT_SPACE))
                .map(Command::getCommandByLabel)
                .collect(Collectors.toList());


    }
    /**
     * Parses the provided input line to obtain the size of the lawn and updates the Lawn object.
     *
     * @param line The string representing the lawn's size.
     *             The format should be "X Y" where X and Y are integers
     *             representing the width and height of the lawn.
     * @param lawn The Lawn object to update with the parsed grid size.
     * @return The updated Lawn object with the grid size information.
     */

    @Override
    public Lawn getGridSize(String line, Lawn lawn) {

        List<String> dimensions = Arrays.asList(line.split(Constants.SPACE));
        int width = Integer.parseInt(dimensions.get(0));
        int height = Integer.parseInt(dimensions.get(1));
        Grid grid=Grid.getInstance();
        grid.setX(width);
        grid.setY(height);

        lawn.setGridMaxSize(grid);
        return lawn;
    }
/**
 * Creates a Mower object based on the input string.
 *
 * @param input The string representing the mower's initial position and direction.
 *              The format should be "X Y D" where X and Y are integers representing
 *              the initial coordinates, and D is a string representing the initial
 *              orientation (N, S, E, or W).
 * @return A Mower object with the specified initial position and orientation.
*/

 @Override
    public Mower createMowerFromInput(String input) {
        List<String> dataPosition = Arrays.asList(input.split(Constants.SPACE));
        int startX = Integer.parseInt(dataPosition.get(0));
        int startY = Integer.parseInt(dataPosition.get(1));
        String startDirection = dataPosition.get(2);
        return Mower.builder()
                .position(Position.builder()
                        .x(startX)
                        .y(startY)
                        .orientation(Orientation.getOrientationByLabel(startDirection)).build())
                .build();
    }


    private static LawnMowerServiceImpl instance;
    public static LawnMowerServiceImpl getInstance()
    {      if (instance == null) {
        instance = new LawnMowerServiceImpl();
    }
        return instance;
    }

    private LawnMowerServiceImpl()
    {}
}
