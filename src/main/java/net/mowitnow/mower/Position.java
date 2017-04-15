package net.mowitnow.mower;


public class Position {

	private int horizontalPosition = -1;

	private int verticalPosition = -1;

	public Position(int horizontalPosition, int verticalPosition) {
		this.setHorizontalPosition(horizontalPosition);
		this.setVerticalPosition(verticalPosition);
	}

	public int getHorizontalPosition() {
		return horizontalPosition;
	}

	private void setHorizontalPosition(int horizontalPosition) {
		this.horizontalPosition = horizontalPosition;
	}

	public int getVerticalPosition() {
		return verticalPosition;
	}

	private void setVerticalPosition(int verticalPosition) {
		this.verticalPosition = verticalPosition;
	}

	@Override
	public String toString() {
		return horizontalPosition + " " + verticalPosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horizontalPosition;
		result = prime * result + verticalPosition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Position)) {
			return false;
		}
		Position other = (Position) obj;
		return horizontalPosition == other.horizontalPosition && verticalPosition == other.verticalPosition;
	}
	
}
