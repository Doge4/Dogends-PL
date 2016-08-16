package me.woulfiee.server.worlds.plots.plotsgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

/**
 * 
 * @author Woulfiee
 *
 */
public class PlotsGenerator extends ChunkGenerator {

	private static void setBlockAt(byte[][] chunk, int x, int y, int z, byte typeId) {
		if (chunk[y >> 4] == null) {
			chunk[y >> 4] = new byte[4096];
		}
		chunk[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = typeId;
	}

	@Override
	public byte[][] generateBlockSections(World world, Random random, int chunkX, int chunkZ,
			ChunkGenerator.BiomeGrid biomes) {
		byte[][] chunk = new byte[16][];
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				setBlockAt(chunk, x, 0, z, (byte) Material.BEDROCK.getId());
				for (int y = 1; y < 61; y++) {
					setBlockAt(chunk, x, y, z, (byte) Material.STONE.getId());
				}
				for (int y = 61; y <= 63; y++) {
					setBlockAt(chunk, x, y, z, (byte) Material.DIRT.getId());
				}
				setBlockAt(chunk, x, 64, z, (byte) Material.GRASS.getId());

				biomes.setBiome(x, z, Biome.PLAINS);
			}
		}
		return chunk;
	}

	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		populators.add(new PathPopulator());

		return populators;
	}

	@Override
	public Location getFixedSpawnLocation(World world, Random rand) {
		return new Location(world, 0, 64 + 1, 0);
	}

	public int getGridSize() {
		return 32;
	}
}
