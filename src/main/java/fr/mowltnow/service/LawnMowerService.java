package fr.mowltnow.service;

import fr.mowltnow.model.Lawn;
import fr.mowltnow.model.Mower;
import fr.mowltnow.model.enums.Command;

import java.util.List;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
public interface LawnMowerService {

    List<Command> validateAndConvertCommands(String input);
     Lawn getGridSize(String line, Lawn lawn);
    Mower createMowerFromInput(String input);
}
