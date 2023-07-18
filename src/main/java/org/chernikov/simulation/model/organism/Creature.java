package org.chernikov.simulation.model.organism;

public abstract class Creature {

    protected int speed = 0;
    protected int hp = 0;

    public abstract void makeMove();
}
