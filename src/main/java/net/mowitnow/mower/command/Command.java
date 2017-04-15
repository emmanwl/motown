package net.mowitnow.mower.command;

import net.mowitnow.mower.OrientedPosition;
import net.mowitnow.mower.Surface;

public interface Command {

	OrientedPosition move(OrientedPosition orientedPosition, Surface surface);
}
