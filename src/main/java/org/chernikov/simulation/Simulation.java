package org.chernikov.simulation;

import org.chernikov.simulation.action.Action;
import org.chernikov.simulation.map.GameMap;
import org.chernikov.simulation.map.MapRenderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final GameMap gameMap = new GameMap();
    private int turnsCounter = 0;
    private final MapRenderer mapRenderer = new MapRenderer();
    private List<Action> actions = new ArrayList<>();
}
