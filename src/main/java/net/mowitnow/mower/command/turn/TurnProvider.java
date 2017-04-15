package net.mowitnow.mower.command.turn;

import net.mowitnow.mower.command.CommandProvider;
import net.mowitnow.mower.enums.CommandType;
import net.mowitnow.mower.enums.Orientation;

public class TurnProvider extends CommandProvider<Turn> {
	
	private final CommandType commandType;
	
	public TurnProvider(CommandType commandType) {
		this.commandType = commandType;
	}
		
	public Turn getCommand(Orientation orientation) {
		Turn turn = null;
		switch (commandType) {
		case LEFT:
			turn = new TurnLeft();
			break;
		case RIGHT:
			turn = new TurnRight();
			break;
		default:
			break;
		}
		return turn;
	}

	

}
