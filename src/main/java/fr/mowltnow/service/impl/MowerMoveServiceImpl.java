package fr.mowltnow.service.impl;

import fr.mowltnow.model.Mower;
import fr.mowltnow.model.Position;
import fr.mowltnow.model.enums.Command;
import fr.mowltnow.model.enums.Orientation;
import fr.mowltnow.service.MowerMoveService;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */

public class MowerMoveServiceImpl implements MowerMoveService {
    /**
     * Moves the mower according to a sequence of commands, ensuring it stays within the given boundaries.
     *
     * @param mower The Mower object to be moved.
     * @param maxX  The maximum X-coordinate (width) of the lawn.
     * @param maxY  The maximum Y-coordinate (height) of the lawn.
     * @return The updated Mower object after executing the commands.
     */
    public Mower moveMower(Mower mower, int maxX, int maxY) {
        for (Command command : mower.getMowerCommands()) {
            switch (command) {
                case FORWARD:
                    mower = moveForward(mower, maxX, maxY);
                    break;
                case RIGHT:
                    mower = turnRight(mower);
                    break;
                case LEFT:
                    mower = turnLeft(mower);
                    break;
            }
        }
        return mower;
    }
    /**
     * Moves the mower forward one step in its current orientation, staying within the specified boundaries.
     * @param mower The Mower object to move.
     * @param maxX The maximum X-coordinate (width) of the lawn.
     * @param maxY The maximum Y-coordinate (height) of the lawn.
     * @return A new Mower object with the updated position after moving forward.
     */
    private static Mower moveForward(Mower mower, int maxX, int maxY) {
        int x = mower.getPosition().getX();
        int y = mower.getPosition().getY();
        Orientation orientation = mower.getPosition().getOrientation();

        switch (orientation) {
            case NORTH:
                if (y < maxY) y++;
                break;
            case EAST:
                if (x < maxX) x++;
                break;
            case SOUTH:
                if (y > 0) y--;
                break;
            case WEST:
                if (x > 0) x--;
                break;
        }

        return Mower.builder().position(Position.builder().x(x).y(y).orientation(orientation).build()).build();
    }
    /**
     * Turns the mower to the right (clockwise) by changing its orientation.
     * @param mower The Mower object to turn.
     * @return A new Mower object with the updated orientation after turning right.
     */

    private static Mower turnRight(Mower mower) {
        Orientation orientation = mower.getPosition().getOrientation();
        int ordinal = (orientation.ordinal() + 1) % Orientation.values().length;
        return Mower.builder()
                .position(Position.builder()
                        .orientation(Orientation.values()[ordinal])
                        .x(mower.getPosition().getX())
                        .y(mower.getPosition().getY()).
                        build())
                .build();
    }
    /**
     * Turns the mower to the left (counter-clockwise) by changing its orientation.
     * @param mower The Mower object to turn.
     * @return A new Mower object with the updated orientation after turning left.
     */
    private static Mower turnLeft(Mower mower) {
        Orientation orientation = mower.getPosition().getOrientation();
        int ordinal = (orientation.ordinal() - 1 + Orientation.values().length) % Orientation.values().length;
        return Mower.builder()
                .position(Position.builder()
                        .orientation(Orientation.values()[ordinal])
                        .x(mower.getPosition().getX())
                        .y(mower.getPosition().getY()).
                        build())
                .build();
    }
    private static MowerMoveServiceImpl instance;

 public static MowerMoveServiceImpl getInstance()
 {      if (instance == null) {
     instance = new MowerMoveServiceImpl();
 }
     return instance;
 }
 private MowerMoveServiceImpl()
 {}
}
