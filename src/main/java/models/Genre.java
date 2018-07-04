package models;

public enum Genre {
	PUZZLE(10),
	ARCADE(40),
	SIMULATION(90),
	STEALTH_SHOOTER(100);

	private int funLevel;

	Genre(int funLevel) {
		this.funLevel = funLevel;


		public int getFunLevel () {
			return funLevel;
		}
	}

}

