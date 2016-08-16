package me.woulfiee.server.tps;

/**
 * 
 * @author Woulfiee
 *
 */
public class Lag implements Runnable {

	public static long LAST_TICK = 0L;
	public static int TICK_COUNT = 0;
	public static long[] TICKS = new long[600];

	public static long getElapsed(int tickID) {
		if (TICK_COUNT - tickID >= TICKS.length) {
		}

		long time = TICKS[(tickID % TICKS.length)];
		return System.currentTimeMillis() - time;
	}

	public static double getLagPercentage(double lag) {
		double tps = Lag.getTPS();
		lag = Math.round((1.0D - tps / 20.0D) * 100.0D);

		return lag;
	}

	public static double getTPS() {
		return getTPS(100);
	}

	public static double getTPS(int ticks) {
		if (TICK_COUNT < ticks) {
			return 20.0D;
		}
		int target = (TICK_COUNT - 1 - ticks) % TICKS.length;
		long elapsed = System.currentTimeMillis() - TICKS[target];

		return ticks / (elapsed / 1000.0D);
	}

	@Override
	public void run() {
		TICKS[(TICK_COUNT % TICKS.length)] = System.currentTimeMillis();

		TICK_COUNT += 1;
	}
}