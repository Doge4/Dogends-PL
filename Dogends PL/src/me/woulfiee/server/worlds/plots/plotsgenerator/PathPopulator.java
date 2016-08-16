package me.woulfiee.server.worlds.plots.plotsgenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

/**
 * 
 * @author Woulfiee
 *
 */
public class PathPopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk) {
		int chunkX = chunk.getX() * 16;
		int chunkZ = chunk.getZ() * 16;
		for (int cx = 0; cx < 16; cx++) {
			for (int cz = 0; cz < 16; cz++) {
				int x = chunkX + cx;
				int y = 64;
				int z = chunkZ + cz;
				if ((x % 48 == 0) && ((z - 2) % 48 != 0) && ((z - 1) % 48 != 0) && (z % 48 != 0) && ((z + 1) % 48 != 0)
						&& ((z + 2) % 48 != 0)) {
					world.getBlockAt(x - 2, y, z).setType(Material.GRAVEL);
					world.getBlockAt(x - 1, y, z).setType(Material.GRAVEL);
					world.getBlockAt(x, y, z).setType(Material.GRAVEL);
					world.getBlockAt(x + 1, y, z).setType(Material.GRAVEL);
					world.getBlockAt(x + 2, y, z).setType(Material.GRAVEL);

					world.getBlockAt(x - 3, y, z).setType(Material.DIRT);
					world.getBlockAt(x + 3, y, z).setType(Material.DIRT);
					world.getBlockAt(x - 3, y + 1, z).setType(Material.STEP);
					world.getBlockAt(x + 3, y + 1, z).setType(Material.STEP);
				}
				if ((z % 48 == 0) && ((x - 2) % 48 != 0) && ((x - 1) % 48 != 0) && (x % 48 != 0) && ((x + 1) % 48 != 0)
						&& ((x + 2) % 48 != 0)) {
					world.getBlockAt(x, y, z - 2).setType(Material.GRAVEL);
					world.getBlockAt(x, y, z - 1).setType(Material.GRAVEL);
					world.getBlockAt(x, y, z).setType(Material.GRAVEL);
					world.getBlockAt(x, y, z + 1).setType(Material.GRAVEL);
					world.getBlockAt(x, y, z + 2).setType(Material.GRAVEL);

					world.getBlockAt(x, y, z - 3).setType(Material.DIRT);
					world.getBlockAt(x, y, z + 3).setType(Material.DIRT);
					world.getBlockAt(x, y + 1, z - 3).setType(Material.STEP);
					world.getBlockAt(x, y + 1, z + 3).setType(Material.STEP);
				}
				if ((x % 48 == 0) && (z % 48 == 0)) {
					world.getBlockAt(x, y - 1, z).setType(Material.REDSTONE_TORCH_ON);

					world.getBlockAt(x, y, z).setType(Material.REDSTONE_LAMP_ON);
					world.getBlockAt(x + 1, y, z).setType(Material.REDSTONE_LAMP_ON);
					world.getBlockAt(x - 1, y, z).setType(Material.REDSTONE_LAMP_ON);
					world.getBlockAt(x, y, z + 1).setType(Material.REDSTONE_LAMP_ON);
					world.getBlockAt(x, y, z - 1).setType(Material.REDSTONE_LAMP_ON);

					world.getBlockAt(x + 1, y, z + 1).setType(Material.GLOWSTONE);
					world.getBlockAt(x + 1, y, z - 1).setType(Material.GLOWSTONE);
					world.getBlockAt(x - 1, y, z + 1).setType(Material.GLOWSTONE);
					world.getBlockAt(x - 1, y, z - 1).setType(Material.GLOWSTONE);

					world.getBlockAt(x + 2, y, z + 2).setType(Material.GRAVEL);
					world.getBlockAt(x + 2, y, z - 2).setType(Material.GRAVEL);
					world.getBlockAt(x - 2, y, z + 2).setType(Material.GRAVEL);
					world.getBlockAt(x - 2, y, z - 2).setType(Material.GRAVEL);

					world.getBlockAt(x + 1, y, z + 2).setType(Material.GRAVEL);
					world.getBlockAt(x + 1, y, z - 2).setType(Material.GRAVEL);
					world.getBlockAt(x + 2, y, z + 1).setType(Material.GRAVEL);
					world.getBlockAt(x + 2, y, z - 1).setType(Material.GRAVEL);
					world.getBlockAt(x - 1, y, z + 2).setType(Material.GRAVEL);
					world.getBlockAt(x - 1, y, z - 2).setType(Material.GRAVEL);
					world.getBlockAt(x - 2, y, z + 1).setType(Material.GRAVEL);
					world.getBlockAt(x - 2, y, z - 1).setType(Material.GRAVEL);

					world.getBlockAt(x + 2, y, z).setType(Material.GRAVEL);
					world.getBlockAt(x - 2, y, z).setType(Material.GRAVEL);
					world.getBlockAt(x, y, z + 2).setType(Material.GRAVEL);
					world.getBlockAt(x, y, z - 2).setType(Material.GRAVEL);
				}
			}
		}
	}
}
