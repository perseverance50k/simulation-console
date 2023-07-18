package org.chernikov.simulation;

import org.chernikov.simulation.map.MapRenderer;
import org.chernikov.simulation.util.EntityEmoji;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("\n");
        MapRenderer mapRenderer = new MapRenderer();
        mapRenderer.renderInitialMap();
        mapRenderer.printMap();
    }
}