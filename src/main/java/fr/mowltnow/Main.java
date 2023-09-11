package fr.mowltnow;

import fr.mowltnow.model.Lawn;
import fr.mowltnow.model.Mower;
import fr.mowltnow.service.impl.LawnMowerServiceImpl;
import fr.mowltnow.service.impl.MowerMoveServiceImpl;
import fr.mowltnow.service.impl.StarterImpl;
import fr.mowltnow.utils.DataParser;
import lombok.extern.slf4j.Slf4j;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
@Slf4j
public class Main {


    public static void main(String[] args) {
        StarterImpl.getInstance().start(args[0]);
    }


}
