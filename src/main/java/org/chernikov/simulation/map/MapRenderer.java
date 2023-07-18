package org.chernikov.simulation.map;

import org.chernikov.simulation.model.Coordinate;
import org.chernikov.simulation.model.Entity;
import org.chernikov.simulation.model.environment.Earth;
import org.chernikov.simulation.model.environment.Rock;
import org.chernikov.simulation.model.environment.Tree;
import org.chernikov.simulation.model.environment.resource.Grass;
import org.chernikov.simulation.model.organism.Creature;
import org.chernikov.simulation.model.organism.Herbivore;
import org.chernikov.simulation.model.organism.Predator;
import org.chernikov.simulation.util.CreatureProperties;
import org.chernikov.simulation.util.MapProperties;

import java.util.concurrent.ThreadLocalRandom;

public class MapRenderer {

    private final GameMap gameMap = new GameMap();
    private final String[][] mapSpatialRepresentation = new String[MapProperties.HEIGHT][MapProperties.WIDTH];

    // TODO: refactor this
    private Entity createRandomEnvironmentObject() {
        int entityIndex = generateRandomEntityIndex();
        Entity entity;

        if (entityIndex <= 69) entity = new Earth();
        else if (entityIndex <= 72)  entity = new Tree();
        else if (entityIndex <= 85) entity = new Grass();
        else if (entityIndex <= 95) entity = new Rock();
        else if (entityIndex <= 97) entity = new Predator(generateRandomSpeedValue(),
                                                          generateRandomHPValue(),
                                                          generateRandomAttackPowerValue(),
                                                          generateRandomCoordinates());
        else if (entityIndex <= 100) entity = new Herbivore(generateRandomSpeedValue(),
                                                            generateRandomHPValue(),
                                                            generateRandomCoordinates());
        else throw new IllegalStateException("Incorrect entity index!");

        return entity;
    }

    // TODO: implement this
    private Creature createRandomCreature() {
        return null;
    }

    // TODO: revise the name of this method
    private int generateRandomEntityIndex() {
        return ThreadLocalRandom.current().nextInt(1, 101);
    }

    private int generateRandomSpeedValue() {
        return ThreadLocalRandom.current().nextInt(CreatureProperties.SPEED_LOWER_BOUND,
                                             CreatureProperties.SPEED_UPPER_BOUND + 1);
    }

    private int generateRandomHPValue() {
        return ThreadLocalRandom.current().nextInt(CreatureProperties.HP_LOWER_BOUND,
                                                   CreatureProperties.HP_UPPER_BOUND + 1);
    }

    private int generateRandomAttackPowerValue() {
        return ThreadLocalRandom.current().nextInt(CreatureProperties.ATTACK_POWER_LOWER_BOUND,
                                                   CreatureProperties.ATTACK_POWER_UPPER_BOUND + 1);
    }

    private Coordinate generateRandomCoordinates() {
        int x = ThreadLocalRandom.current().nextInt(0, MapProperties.WIDTH + 1);
        int y = ThreadLocalRandom.current().nextInt(0, MapProperties.HEIGHT + 1);
        return new Coordinate(y, x);
    }

    public void renderInitialMap() {
        for (String[] mapRow : mapSpatialRepresentation) {
            for (int i = 0; i < mapRow.length; i++) {
                mapRow[i] = createRandomEnvironmentObject().getEmojiRepresentation();
            }
        }
    }

    private void renderMapEnvironment() {
        for (String[] mapRow : mapSpatialRepresentation) {
            for (int i = 0; i < mapRow.length; i++) {
                mapRow[i] = createRandomEnvironmentObject().getEmojiRepresentation();
            }
        }
    }

    public void printMap() {
        for (String[] mapRow : mapSpatialRepresentation) {
            for (int i = 0; i < mapRow.length; i++) {
                System.out.printf("%3s", mapRow[i]);
                if (i == mapRow.length - 1) System.out.print("\n");
            }
        }
    }
}
