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

    private Entity createRandomEnvironmentObject() {
        int entityIndex = generateRandomEntityIndex();
        Entity entity;

        if (entityIndex <= 60) entity = new Earth();
        else if (entityIndex <= 75)  entity = new Tree();
        else if (entityIndex <= 90) entity = new Grass();
        else if (entityIndex <= 100) entity = new Rock();
        else throw new IllegalStateException("Incorrect entity index!");

        return entity;
    }

    private Creature createRandomCreature() {
        int creatureIndex = generateRandomEntityIndex();
        Creature creature;

        if (creatureIndex <= 70) creature = new Herbivore(generateRandomSpeedValue(),
                                                          generateRandomHPValue(),
                                                          generateRandomCoordinates());
        else if (creatureIndex <= 100) creature = new Predator(generateRandomSpeedValue(),
                                                          generateRandomHPValue(),
                                                          generateRandomAttackPowerValue(),
                                                          generateRandomCoordinates());
        else throw new IllegalStateException("Incorrect entity index!");

        return creature;
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
        int x = ThreadLocalRandom.current().nextInt(0, MapProperties.WIDTH);
        int y = ThreadLocalRandom.current().nextInt(0, MapProperties.HEIGHT);
        return new Coordinate(y, x);
    }

    public void renderInitialMap() {
        renderMapEnvironment();
        renderCreaturesOnMap();
    }

    private void renderMapEnvironment() {
        for (String[] mapRow : mapSpatialRepresentation) {
            for (int i = 0; i < mapRow.length; i++) {
                mapRow[i] = createRandomEnvironmentObject().getEmojiRepresentation();
            }
        }
    }

    private void renderCreaturesOnMap() {
        int numberOfCreatures = MapProperties.NUMBER_OF_CREATURES;
        int creaturesCreatedCount = 0;
        int x;
        int y;

        while (creaturesCreatedCount < numberOfCreatures) {
            Creature creature = createRandomCreature();
            x = creature.getCoordinates().getX();
            y = creature.getCoordinates().getY();
            if (mapSpatialRepresentation[y][x].equals("\uD83D\uDFEB")) {
                mapSpatialRepresentation[y][x] = creature.getEmojiRepresentation();
                gameMap.addCreature(creature);
                creaturesCreatedCount++;
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
