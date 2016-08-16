package me.woulfiee.server.ban;

/**
 * 
 * @author Woulfiee
 *
 */
public enum BanUnit {
	DAY("d", 1440), HOUR("h", 60), MINUTE("m", 1), MONTH("mo", 43200), SECOND("s", 0), WEEK("w", 10080), YEAR("y",
			518400);

	@SuppressWarnings("unused")
	public static long getTicks(String un, int time) {
		try {
			long sec = time * 60;
		} catch (NumberFormatException ex) {
			return 0L;
		}
		long sec = 0;
		BanUnit[] arrayOfBanUnit;
		int j = (arrayOfBanUnit = values()).length;
		for (int i = 0; i < j; i++) {
			BanUnit unit = arrayOfBanUnit[i];
			if (un.startsWith(unit.name)) {
				return sec *= unit.multi * 1000L;
			}
		}
		return 0L;
	}

	public int multi;

	public String name;

	private BanUnit(String name, int multi) {
		this.name = name;
		this.multi = multi;
	}
}
