package net.mowitnow.mower.command.move;

import net.mowitnow.mower.command.CommandProvider;
import net.mowitnow.mower.enums.Orientation;

public class MoveProvider extends CommandProvider<Move> {
		
	public Move getCommand(Orientation orientation) {
		Move move = null;
		switch (orientation) {
		case NORTH:
			move = new MoveNorth();
			break;
		case EAST:
			move = new MoveEast();
			break;
		case SOUTH:
			move = new MoveSouth();
			break;
		case WEST:
			move = new MoveWest();
			break;
		default:
			break;
		}
		return move;
	}

	
}
