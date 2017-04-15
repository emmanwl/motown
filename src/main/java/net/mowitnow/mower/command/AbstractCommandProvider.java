package net.mowitnow.mower.command;

import net.mowitnow.mower.command.move.MoveProvider;
import net.mowitnow.mower.command.turn.TurnProvider;
import net.mowitnow.mower.enums.CommandType;

import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractCommandProvider {

	private static final Map<CommandType, CommandProvider<? extends Command>> mapping = new EnumMap<CommandType, CommandProvider<? extends Command>>(
			CommandType.class);
	static {
		mapping.put(CommandType.FORWARD, new MoveProvider());
		mapping.put(CommandType.LEFT, new TurnProvider(CommandType.LEFT));
		mapping.put(CommandType.RIGHT, new TurnProvider(CommandType.RIGHT));
	}

	public static CommandProvider<? extends Command> getCommandProvider(CommandType commandType) {
		return mapping.get(commandType);
	}

}
