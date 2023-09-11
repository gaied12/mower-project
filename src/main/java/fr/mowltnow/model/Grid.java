package fr.mowltnow.model;

import lombok.*;

/**
 * @author oussama.gaied
 * @since 11/09/2023
 */
@Getter
@Setter

public class Grid {
    private int x;
    private int y;
    private static Grid instance;
    public static Grid getInstance() {
        if (instance == null) {
            instance = new Grid();
        }
        return instance;
    }

    private Grid (){}


}
