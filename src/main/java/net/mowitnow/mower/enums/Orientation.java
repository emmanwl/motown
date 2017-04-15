package net.mowitnow.mower.enums;


public enum Orientation {

	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");
	
	private final String orientation;

	Orientation(String orientation) {
		this.orientation = orientation;
	}

	private String getOrientation() {
		return orientation;
	}

	public static Orientation getOrientation(String orientation) {
		for (Orientation o : Orientation.values()) {
			if (o.getOrientation().equals(orientation))
				return o;
		}
		return null;
	}

	@Override
	public String toString() {
		return getOrientation();
	}

	public Orientation left() {

		Orientation o = null;
		switch (this) {
		case NORTH:
			o = WEST;
			break;
		case EAST:
			o = NORTH;
			break;
		case SOUTH:
			o = EAST;
			break;
		case WEST:
			o = SOUTH;
			break;
		default:
			break;
		}
		return o;
	}

	public Orientation right() {

		Orientation o = null;
		switch (this) {
		case NORTH:
			o = EAST;
			break;
		case EAST:
			o = SOUTH;
			break;
		case SOUTH:
			o = WEST;
			break;
		case WEST:
			o = NORTH;
			break;
		default:
			break;
		}
		return o;
	}
}
