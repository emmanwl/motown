package net.mowitnow.mower;

import net.mowitnow.mower.enums.Orientation;

public class OrientedPosition {

	private final Position position;
	private Orientation orientation;

	public OrientedPosition(int horizontalPosition, int verticalPosition, Orientation orientation) {
		this.position = new Position(horizontalPosition, verticalPosition);
		this.setOrientation(orientation);
	}
		
	public OrientedPosition(Position position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}

	public Position getPosition() {
		return position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	private void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		if (position != null && orientation != null)
			return position.toString() + " " + orientation.toString();
		else
			return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orientation == null) ? 0 : orientation.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		if (!(obj instanceof OrientedPosition)) {
			return false;
		}
		OrientedPosition other = (OrientedPosition) obj;
		if (orientation != other.orientation) {
			return false;
		}
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		return true;
	}

}
