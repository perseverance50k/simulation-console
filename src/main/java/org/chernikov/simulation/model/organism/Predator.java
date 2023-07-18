package org.chernikov.simulation.model.organism;

import org.chernikov.simulation.model.Coordinate;
import org.chernikov.simulation.util.EntityEmoji;

public class Predator extends Creature {

    private final int attackPower;

    public Predator(int speed, int hp, int attackPower, Coordinate coordinates) {
        this.speed = speed;
        this.hp = hp;
        this.attackPower = attackPower;
        this.coordinates = coordinates;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String getEmojiRepresentation() {
        return EntityEmoji.PREDATOR;
    }
}
