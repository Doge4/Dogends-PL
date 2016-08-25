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

	public static void createPlot(Plot plot) {
		plots.add(plot);
	}

	public static void removePlot(Plot plot) {
		plots.remove(plot);
	}

	public PlotManager() {
		plots = new HashSet<>();
	}

}
