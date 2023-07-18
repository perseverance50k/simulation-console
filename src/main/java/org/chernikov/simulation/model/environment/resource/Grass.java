package org.chernikov.simulation.model.environment.resource;

import org.chernikov.simulation.model.Entity;
import org.chernikov.simulation.util.EntityEmoji;

public class Grass extends Entity {
    @Override
    public String getEmojiRepresentation() {
        return EntityEmoji.GRASS;
    }
}
