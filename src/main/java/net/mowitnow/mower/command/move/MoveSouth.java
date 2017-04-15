package net.mowitnow.mower.command.move;

import net.mowitnow.mower.OrientedPosition;
import net.mowitnow.mower.Position;
import net.mowitnow.mower.Surface;

public final class MoveSouth extends Move {

	public OrientedPosition move(OrientedPosition orientedPosition, Surface surface) {
		Position position = orientedPosition.getPosition();
		int verticalPosition = surface.getMaxVerticalPosition() == position.getVerticalPosition() ? 
				position.getVerticalPosition() : position.getVerticalPosition() - 1;
		return new OrientedPosition(position.getHorizontalPosition(), verticalPosition, orientedPosition.getOrientation());
	}
}
