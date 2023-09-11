package fr.mowltnow.model.enums;

import fr.mowltnow.exception.AppException;
import fr.mowltnow.utils.Constants;
import lombok.Getter;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
@Getter
public enum Orientation {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");
    private final String value;

    Orientation(String value) {

        this.value = value;
    }
    public static Orientation getOrientationByLabel(String label) {
        Orientation orientation;

        switch (label) {
            case "N":
                orientation = Orientation.NORTH;
                break;
            case "E":
                orientation = Orientation.EAST;
                break;
            case "S":
                orientation = Orientation.SOUTH;
                break;
            case "W":
                orientation = Orientation.WEST;
                break;
            default:
                throw new AppException(Constants.MOWER_WRONG_ORIENTATION);
        }

        return orientation;
    }
}
