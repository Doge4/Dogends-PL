package me.woulfiee.server.worlds.plots.utils;

import org.bukkit.Location;

/**
 * 
 * @author Woulfiee
 *
 */
public class LocationUtils {

	private static double center = 0D;
	private static int id;
	private static int maxPlotsInRow;
	private static double maxX;
	private static double maxZ;
	private static double minX;
	private static double minZ;
	private static int pathWidthWithSlabs = 7;
	private static int plotSize = 48;
	private static int row;

	public static int getIdFromLocation(Location location) {
		row = 2;
		maxPlotsInRow = 3;
		id = 0;
		return id;
	}

	public static int getMaxPlotsInRow(int row1) {
		maxPlotsInRow = 3;
		if (row1 >= 2)
			for (row = 2; row < row1; row++) {
				maxPlotsInRow += 2;
			}
		return maxPlotsInRow;
	}

	public static int getMaxRowLength(int maxPlotsInRow) {
		return (maxPlotsInRow * plotSize + ((maxPlotsInRow - 1) * pathWidthWithSlabs));
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

	public static int getRow(int id) {
		return row;
	}

	public static int getRowByMaxPlotsInRow(int maxPlotsInRow) {
		return row;
	}

	public static double getRowsMaxX(int maxPlotsInRow) {
		maxX = center + (maxPlotsInRow * (plotSize + pathWidthWithSlabs) - pathWidthWithSlabs);
		return maxX;
	}

	public static double getRowsMaxZ(int maxPlotsInRow) {
		maxZ = center + (maxPlotsInRow * (plotSize + pathWidthWithSlabs) - pathWidthWithSlabs);
		return maxZ;
	}

	public static double getRowsMinX(int maxPlotsInRow) {
		minX = center - (maxPlotsInRow * (plotSize + pathWidthWithSlabs) + pathWidthWithSlabs);
		return minX;
	}

	public static double getRowsMinZ(int maxPlotsInRow) {
		minZ = center - (maxPlotsInRow * (plotSize + pathWidthWithSlabs) + pathWidthWithSlabs);
		return minZ;
	}

}
