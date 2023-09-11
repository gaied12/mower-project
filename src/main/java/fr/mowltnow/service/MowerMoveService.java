package fr.mowltnow.service;

import fr.mowltnow.model.Mower;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
public interface MowerMoveService {
    Mower moveMower(Mower mower, int maxX, int maxY);
}
