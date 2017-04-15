package net.mowitnow.mower.command;

import net.mowitnow.mower.enums.Orientation;

public abstract class CommandProvider<C extends Command> {

	public abstract C getCommand(Orientation orientation);

}
