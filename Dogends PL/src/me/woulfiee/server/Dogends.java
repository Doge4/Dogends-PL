package me.woulfiee.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import me.woulfiee.server.broadcast.Broadcaster;
import me.woulfiee.server.listeners.AntiGrief;
import me.woulfiee.server.motd.Appearance;
import me.woulfiee.server.startup.LoadCommands;
import me.woulfiee.server.startup.LoadListeners;
import me.woulfiee.server.tps.Lag;
import me.woulfiee.server.worlds.plots.plotsgenerator.PlotsGenerator;
import me.woulfiee.server.worlds.utils.CreateWorld;
import me.woulfiee.server.worlds.utils.LoadWorlds;

/**
 * 
 * @author Woulfiee
 *
 */
public class Dogends extends JavaPlugin {

	private static Dogends plugin;
	public static Dogends getMain() {
		return Dogends.plugin;
	}

	private Connection connection;

	@SuppressWarnings("unused")
	private void checkTable() {
		openConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("create table if not null players(");
		builder.append("name varchar(16) not null,");
		builder.append("rank varchar(10) not null,");
		builder.append("kills int not null,");
		builder.append("deaths int not null,");
		builder.append("primary key(name));");

		try {
			connection.createStatement().executeUpdate(builder.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	private synchronized void closeConnection() {
		if (isConnected()) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ChunkGenerator getDefaultWorldGenerator(String worldName) {
		return new PlotsGenerator();
	}

	public boolean isConnected() {
		try {
			return !this.connection.isClosed() || this.connection == null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void loadData() throws SQLException {
		openConnection();
		int i = 0;
		ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM `players`");
		while (rs.next()) {

		}
		Bukkit.getConsoleSender().sendMessage("Zaladowano " + i + " graczy!");
		closeConnection();
	}

	@Override
	public void onDisable() {
		// try {
		// saveData();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		saveConfig();
	}

	@Override
	public void onEnable() {
		Dogends.plugin = this;
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
		LoadCommands.load();
		LoadListeners.load();
		Appearance.setupMotD();
		Broadcaster.runBroadcast();
		AntiGrief.blockDaynightCycle();
		LoadWorlds.loadWorlds();
		CreateWorld.createPlotWorld();
		// try {
		// loadData();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}

	private synchronized void openConnection() {
		if (!isConnected()) {
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql//mysql.csrv.pl:3306/csrv_461864?user=csrv_461864&password=1ffad33c0c1d47b30ffb");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	private void saveData() throws SQLException {
		openConnection();
		int i = 0;
		Bukkit.getConsoleSender().sendMessage("Zapisano " + i + " graczy!");
		closeConnection();
	}
}
