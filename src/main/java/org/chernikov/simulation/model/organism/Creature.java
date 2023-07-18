package org.chernikov.simulation.model.organism;

import org.chernikov.simulation.model.Entity;

public abstract class Creature extends Entity {

    protected int speed = 0;
    protected int hp = 0;

    public abstract void makeMove();
}
