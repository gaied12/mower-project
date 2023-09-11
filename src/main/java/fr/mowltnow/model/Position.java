package fr.mowltnow.model;

import fr.mowltnow.model.enums.Orientation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
@Getter
@AllArgsConstructor
@Builder
@Setter
public class Position {
    private int x;
    private int y;
    private Orientation orientation;
}
