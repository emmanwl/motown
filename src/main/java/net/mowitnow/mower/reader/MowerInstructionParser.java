package net.mowitnow.mower.reader;

import net.mowitnow.mower.OrientedPosition;
import net.mowitnow.mower.Position;
import net.mowitnow.mower.Surface;
import net.mowitnow.mower.enums.CommandType;
import net.mowitnow.mower.enums.Orientation;

import java.util.ArrayList;
import java.util.List;

class MowerInstructionParser {

	private static final String SEPARATOR = " ";
	
	private static final String CHARACTER_SPLITTER_EXPRESSION = "(?!^)";
	
	private static Position getNorthEastPosition(String line) throws MowerException {
		Position position;
		try {
			position = new Position(Integer.parseInt(line.split(SEPARATOR)[0]), Integer.parseInt(line.split(SEPARATOR)[1]));
		} catch (Exception e) {
			throw new MowerException(e.getMessage(), e.getCause());
		}
		return position;
	}
	
	private static OrientedPosition getOrientedPosition(String line) throws MowerException {
		return new OrientedPosition(getNorthEastPosition(line), Orientation.getOrientation(line.split(SEPARATOR)[2]));
	}
	
	private static List<CommandType> getCommands(String command) {
		List<CommandType> commands = new ArrayList<CommandType>();
		CommandType commandType;
		for (String s : command.split(CHARACTER_SPLITTER_EXPRESSION)) {
			if ((commandType = CommandType.getCommand(s)) != null)
				commands.add(commandType);
		}
		return commands;
	}
	
	private static Surface getSurface(String line) throws MowerException {
		return new Surface(getNorthEastPosition(line));
	}
	
	static MowerInstructionSet getMowerInstructionSet(String[] array) throws MowerException {
		MowerInstructionSet instructionSet = new MowerInstructionSet(getSurface(array[0]));
		instructionSet.setOrientedPosition(getOrientedPosition(array[1]));
		instructionSet.setCommands(getCommands(array[2]));
		return instructionSet;
	}
	
}
