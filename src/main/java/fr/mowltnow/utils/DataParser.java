package fr.mowltnow.utils;

import fr.mowltnow.exception.AppException;
import fr.mowltnow.model.Lawn;
import fr.mowltnow.model.Mower;
import fr.mowltnow.service.LawnMowerService;
import fr.mowltnow.service.impl.LawnMowerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static fr.mowltnow.utils.ReadersUtil.getLineType;

@AllArgsConstructor
@Setter
@Getter
public class DataParser {
    private LawnMowerServiceImpl lawnMowerService;
    private static DataParser instance;

    /**
     * Reads data from a file and constructs a Lawn object with mower positions and commands.
     * This method parses the input file, validates its format, and creates a Lawn object
     * with mower information.
     *
     * @param filePath The path to the input file.
     * @return A Lawn object representing the mowing scenario.
     * @throws AppException if the file format is incorrect or data cannot be properly parsed.
     */
    public Lawn readMowingDataFromFile(String filePath) {
        lawnMowerService=LawnMowerServiceImpl.getInstance();
        Lawn lawn = Lawn.getInstance();
        Mower currentMower = new Mower();
        List<String> lines = ReadersUtil.readDataFile(filePath);
        String firstLine = lines.stream().findFirst().orElse(null);
        if (firstLine == null || !firstLine.matches(Constants.PATTERN_GRID_DIMENSION)) {
            throw new AppException(Constants.MOWER_WRONG_FORMAT);
        }
        lawnMowerService.getGridSize(firstLine, lawn);
        for (int i = 1; i < lines.size(); i++) {

            switch (getLineType(lines.get(i))) {

                case POSITION:
                    currentMower = lawnMowerService.createMowerFromInput(lines.get(i));
                    break;

                case COMMANDS:
                    currentMower.setMowerCommands(lawnMowerService.validateAndConvertCommands(lines.get(i)));
                    lawn.getMowerList().add(currentMower);

                    break;

                default:
                    throw new AppException(Constants.MOWER_WRONG_FORMAT);
            }
        }


        return lawn;
    }


      public static DataParser getInstance() {
        if (instance == null) {
            instance = new DataParser();
        }
        return instance;
    }

private DataParser()
{}
}

