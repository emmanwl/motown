package net.mowitnow.mower.enums;

public enum CommandType {

	FORWARD("A"), LEFT("G"), RIGHT("D");

	private final String type;

	CommandType(String type) {
		this.type = type;
	}

	private String getCommandType() {
		return type;
	}

	public static CommandType getCommand(String command) {
		for (CommandType c : CommandType.values()) {
			if (c.getCommandType().equals(command))
				return c;
		}
		return null;
	}

	@Override
	public String toString() {
		return type;
	}
}
