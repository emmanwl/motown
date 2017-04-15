package net.mowitnow.mower;

import net.mowitnow.mower.command.AbstractCommandProvider;
import net.mowitnow.mower.command.Command;
import net.mowitnow.mower.command.CommandProvider;
import net.mowitnow.mower.enums.CommandType;

import java.util.ArrayList;
import java.util.List;

class Mower {

    private final List<CommandType> commands = new ArrayList<CommandType>();
    private OrientedPosition orientedPosition;
    private final Surface surface;

    Mower(OrientedPosition position, Surface surface) {
        this.orientedPosition = position;
        this.surface = surface;
    }

    OrientedPosition getOrientedPosition() {
        return orientedPosition;
    }

    private void setOrientedPosition(OrientedPosition orientedPosition) {
        this.orientedPosition = orientedPosition;
    }

    void setCommands(List<CommandType> commands) {
        this.commands.addAll(commands);
    }

    private void runCommand(CommandType commandType) {
        CommandProvider<? extends Command> provider = AbstractCommandProvider.getCommandProvider(commandType);
        if (provider != null) {
            Command command = provider.getCommand(orientedPosition.getOrientation());
            if (command != null)
                setOrientedPosition(command.move(orientedPosition, surface));
        }
    }

    void run() {
        for (CommandType commandType : commands) {
            runCommand(commandType);
        }
    }

}
