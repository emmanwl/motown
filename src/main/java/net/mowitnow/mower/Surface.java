package net.mowitnow.mower;

public class Surface {

	private final Position northEastPosition;

	public Surface(Position northEastPosition) {
		this.northEastPosition = northEastPosition;
	}
		
	public int getMaxVerticalPosition() {
		return northEastPosition.getVerticalPosition();
	}

	public int getMaxHorizontalPosition() {
		return northEastPosition.getHorizontalPosition();
	}
}
