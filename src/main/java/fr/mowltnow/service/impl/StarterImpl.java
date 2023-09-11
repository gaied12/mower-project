package fr.mowltnow.service.impl;

import fr.mowltnow.model.Lawn;
import fr.mowltnow.model.Mower;
import fr.mowltnow.service.Starter;
import fr.mowltnow.utils.DataParser;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oussama.gaied
 * @since 11/09/2023
 */
@Slf4j
@Getter
public class StarterImpl implements Starter {
    private static StarterImpl instance;
    List<String> result = new ArrayList<>();

    private StarterImpl() {
    }

    public static StarterImpl getInstance() {
        if (instance == null) instance = new StarterImpl();
        return instance;
    }

    public void start(String args) {
        LawnMowerServiceImpl lawnMowerService = LawnMowerServiceImpl.getInstance();
        DataParser dataParser = DataParser.getInstance();
        dataParser.setLawnMowerService(lawnMowerService);
        MowerMoveServiceImpl mowerMoveService = MowerMoveServiceImpl.getInstance();
        Lawn lawn = dataParser.readMowingDataFromFile(args);
        lawn.getMowerList().forEach(mower -> {
            mower = mowerMoveService.moveMower(mower, lawn.getGridMaxSize().getX(), lawn.getGridMaxSize().getY());
            result.add(mower.getPosition().getX() + " " + mower.getPosition().getY() + " " + mower.getPosition().getOrientation());
            printPosition(mower);


        });


    }


    private static void printPosition(Mower mower) {
        log.info("Mower position: x = {}, y = {}, orientation = {}", mower.getPosition().getX(), mower.getPosition().getY(), mower.getPosition().getOrientation());
    }

}
