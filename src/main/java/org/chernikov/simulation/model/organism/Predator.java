package org.chernikov.simulation.model.organism;

public class Predator extends Creature {

    private final String name;
    private final int attackPower;

    public Predator(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void makeMove() {

    }
}
