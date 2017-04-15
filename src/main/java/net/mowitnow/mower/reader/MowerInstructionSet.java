package net.mowitnow.mower.reader;

import net.mowitnow.mower.OrientedPosition;
import net.mowitnow.mower.Surface;
import net.mowitnow.mower.enums.CommandType;

import java.util.ArrayList;
import java.util.List;

public class MowerInstructionSet {

	private OrientedPosition orientedPosition;
	
	private final List<CommandType> commands = new ArrayList<CommandType>();

	private final Surface surface;
	
	public MowerInstructionSet(Surface surface) {
		this.surface = surface;
	}
	
	public OrientedPosition getOrientedPosition() {
		return orientedPosition;
	}

	public void setOrientedPosition(OrientedPosition orientedPosition) {
		this.orientedPosition = orientedPosition;
	}

	public void setCommands(List<CommandType> commands) {
		this.commands.addAll(commands);
	}

	public List<CommandType> getCommands() {
		return commands;
	}
	
	public Surface getSurface(){
		return surface;
	}
}
