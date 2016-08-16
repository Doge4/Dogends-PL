package me.woulfiee.server.worlds.plots.utils;

import org.bukkit.Location;

/**
 * 
 * @author Woulfiee
 *
 */
public class LocationUtils {

	private int pathWidthWithSlabs = 7;
	private int plotSize = 48;
	private static int row;
	private static int maxPlotsInRow;
	private double x;
	private double z;
	private static int id;

	public static int getRow(int id) {
		return row;
	}

	public static int getMaxPlotsInRow(int row1) {
		maxPlotsInRow = 3;
		if (row1 >= 2)
			for (row = 2; row <= row1; row++) {
				maxPlotsInRow += 2;
			}
		return maxPlotsInRow;
	}

	public static int getRowByMaxPlotsQuantity(int plotsInRow) {
		return row;
	}

	public static int getIdFromLocation(Location location) {
		row = 2;
		maxPlotsInRow = 3;
		id = 0;
		return id;
	}

	public static double getMaxX(int id) {
		double maxX = 0;
		return maxX;
	}

	public static double getMaxZ(int id) {
		double maxZ = 0;
		return maxZ;
	}

	public static double getMinX(int id) {
		double minX = 0;
		return minX;
	}

	public static double getMinZ(int id) {
		double minZ = 0;
		return minZ;
	}

}
