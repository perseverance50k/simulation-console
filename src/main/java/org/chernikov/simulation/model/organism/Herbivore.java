package org.chernikov.simulation.model.organism;

public class Herbivore extends Creature {

    private final String name;

    public Herbivore(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void makeMove() {

    }
}
