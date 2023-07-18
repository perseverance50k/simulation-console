package org.chernikov.simulation;

import org.chernikov.simulation.action.Action;
import org.chernikov.simulation.map.Map;
import org.chernikov.simulation.map.Renderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final Map map = new Map();
    private int turnsCounter = 0;
    private final Renderer renderer = new Renderer();
    private List<Action> actions = new ArrayList<>();
}
