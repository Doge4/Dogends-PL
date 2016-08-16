package me.woulfiee.server.worlds.plots.utils;

import java.util.List;

/**
 * 
 * @author Woulfiee
 *
 */
public class Plot {

	private List<String> helpers;
	private int id;
	private boolean isFinished;
	private boolean isPublic;
	private double maxX;
	private double maxZ;
	private double minX;
	private double minZ;
	private String ownerName;
	private String plotDescription;

	public Plot(int id, double minX, double minZ, double maxX, double maxZ, String ownerName, String plotDescription,
			List<String> helpers, boolean isPublic, boolean isFinished) {
		this.id = id;
		this.minX = minX;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxZ = maxZ;
		this.ownerName = ownerName;
		this.plotDescription = plotDescription;
		this.helpers = helpers;
		this.isPublic = isPublic;
		this.isFinished = isFinished;
	}

	public List<String> getHelpers() {
		return helpers;
	}

	public int getId() {
		return id;
	}

	public double getMaxX() {
		return maxX;
	}

	public double getMaxZ() {
		return maxZ;
	}

	public double getMinX() {
		return minX;
	}

	public double getMinZ() {
		return minZ;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getPlotDescription() {
		return plotDescription;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public void setHelpers(List<String> helpers) {
		this.helpers = helpers;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public void setMaxZ(double maxZ) {
		this.maxZ = maxZ;
	}

	public void setMinX(double minX) {
		this.minX = minX;
	}

	public void setMinZ(double minZ) {
		this.minZ = minZ;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setPlotDescription(String plotDescription) {
		this.plotDescription = plotDescription;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

}
