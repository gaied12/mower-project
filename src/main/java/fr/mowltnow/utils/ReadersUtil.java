package fr.mowltnow.utils;

import fr.mowltnow.exception.AppException;
import fr.mowltnow.model.enums.LineType;
import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author oussama.gaied
 * @since 11/09/2023
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ReadersUtil {
    /**
     * Reads data from a file specified by the given path and returns it as a list of strings.
     * This method opens the file, reads its contents line by line, and collects them into a list.
     *
     * @param path The path to the input file.
     * @return A list of strings representing the lines of data from the file.
     * @throws AppException if the file is empty, cannot be found, or an error occurs while reading it.
     */
    public static List<String> readDataFile(String path) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<String> dataFromFile = br.lines().collect(Collectors.toList());
            if (dataFromFile.isEmpty()) {
                throw new AppException(Constants.MOWER_EMPTY_FILE);
            }
            return dataFromFile;
        } catch (IOException e) {
            throw new AppException(Constants.MOWER_WRONG_FILE_PATH);
        }

    }
    /**
     * Determines the type of a line based on predefined patterns.
     *
     * @param line The input line to be categorized.
     * @return The LineType representing the category of the input line.
     * @throws AppException if the line does not match any predefined patterns, indicating incorrect formatting.
     */

    public static LineType getLineType(String line) {
        if (line.matches(Constants.PATTERN_POSITION)) {
            return LineType.POSITION;
        } else if (line.matches(Constants.PATTERN_COMMANDS)) {
            return LineType.COMMANDS;
        } else {
            throw new AppException(Constants.MOWER_WRONG_FORMAT);
        }
    }
}
