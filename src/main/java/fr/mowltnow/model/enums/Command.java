package fr.mowltnow.model.enums;

import fr.mowltnow.utils.Constants;
import lombok.Getter;

import fr.mowltnow.exception.AppException;



/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
@Getter

public enum Command {
    FORWARD("A"), RIGHT("D"), LEFT("G");
    private final String value;

    Command(String value) {
        this.value = value;

    }

    public static Command getCommandByLabel(String label) {
        Command command;

        switch (label) {
            case "A":
                command = Command.FORWARD;
                break;
            case "D":
                command = Command.RIGHT;
                break;
            case "G":
                command = Command.LEFT;
                break;
            default:
                throw new AppException(Constants.MOWER_WRONG_COMMAND);
        }

        return command;
    }


}
