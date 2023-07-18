package org.chernikov.simulation.model;

public abstract class Entity {
    protected Coordinate coordinates;
    public abstract String getEmojiRepresentation();
    public Coordinate getCoordinates() {
        return this.coordinates;
    };
}
