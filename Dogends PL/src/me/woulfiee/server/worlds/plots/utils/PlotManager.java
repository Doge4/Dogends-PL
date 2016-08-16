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
	
	private Set<Plot> plots;

    public PlotManager() {
        plots = new HashSet<>();
    }

    public void createPlot(Plot plot) {
        plots.add(plot);
    }

    public void removePlot(Plot plot) {
        plots.remove(plot);
    }

}
