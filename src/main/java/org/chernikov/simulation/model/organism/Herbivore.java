package org.chernikov.simulation.model.organism;

import org.chernikov.simulation.model.Coordinate;
import org.chernikov.simulation.util.EntityEmoji;

public class Herbivore extends Creature {

    public Herbivore(int speed, int hp, Coordinate coordinates) {
        this.speed = speed;
        this.hp = hp;
        this.coordinates = coordinates;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String getEmojiRepresentation() {
        return EntityEmoji.HERBIVORE;
    }
}
