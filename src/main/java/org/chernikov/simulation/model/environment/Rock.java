package org.chernikov.simulation.model.environment;

import org.chernikov.simulation.model.Entity;
import org.chernikov.simulation.util.EntityEmoji;

public class Rock extends Entity {
    @Override
    public String getEmojiRepresentation() {
        return EntityEmoji.ROCK;
    }
}
