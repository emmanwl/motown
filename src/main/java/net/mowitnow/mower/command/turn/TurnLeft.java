package net.mowitnow.mower.command.turn;

import net.mowitnow.mower.OrientedPosition;
import net.mowitnow.mower.Surface;

public class TurnLeft extends Turn {

	public OrientedPosition move(OrientedPosition orientedPosition, Surface surface) {
		return new OrientedPosition(orientedPosition.getPosition(), orientedPosition.getOrientation().left()); 
	}

}
