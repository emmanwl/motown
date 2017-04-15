package net.mowitnow.mower.command.move;

import net.mowitnow.mower.OrientedPosition;
import net.mowitnow.mower.Position;
import net.mowitnow.mower.Surface;

public final class MoveEast extends Move {

	public OrientedPosition move(OrientedPosition orientedPosition, Surface surface) {
		Position position = orientedPosition.getPosition();
		int horizontalPosition = surface.getMaxHorizontalPosition() == position.getHorizontalPosition() ? 
				position.getHorizontalPosition() : position.getHorizontalPosition() + 1;
		return new OrientedPosition(horizontalPosition, position.getVerticalPosition(), orientedPosition.getOrientation());
	}

}
