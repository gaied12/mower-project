package fr.mowltnow.model;

import fr.mowltnow.model.enums.Command;
import lombok.*;

import java.util.List;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Mower {
    private  List<Command> mowerCommands;
    private  Position position;

}
