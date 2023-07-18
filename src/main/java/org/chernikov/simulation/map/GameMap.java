package org.chernikov.simulation.map;

import org.chernikov.simulation.model.Coordinate;
import org.chernikov.simulation.model.organism.Creature;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private final Map<Coordinate, Creature> creatures = new HashMap<>();

    public void addCreature(Creature creature) {
        creatures.put(creature.getCoordinates(), creature);
    }
}
