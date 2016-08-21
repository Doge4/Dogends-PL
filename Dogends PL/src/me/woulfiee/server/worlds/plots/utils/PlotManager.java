/**
 * 
 */
package me.woulfiee.server.worlds.plots.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Woulfiee
 *
 */
public class PlotManager {
	
	private static Set<Plot> plots;

    public PlotManager() {
        plots = new HashSet<>();
    }

    public static void createPlot(Plot plot) {
        plots.add(plot);
    }

    public static void removePlot(Plot plot) {
        plots.remove(plot);
    }

}
