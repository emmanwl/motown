package net.mowitnow.mower;

import net.mowitnow.mower.enums.Orientation;
import net.mowitnow.mower.reader.MowerException;
import net.mowitnow.mower.reader.MowerInstructionReader;
import net.mowitnow.mower.reader.MowerInstructionSet;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class MowerTest {

		
	@Test
	public void testFileWithTwoInstructionsSet() {
		
		MowerInstructionReader reader = null; 
		try {
			reader = new MowerInstructionReader("/tmp/commands.txt");
		} catch (MowerException me) {
			fail(me.getMessage());
		}
			
		MowerInstructionSet instruction = reader.next();
		Mower mower = new Mower(instruction.getOrientedPosition(), instruction.getSurface());
		mower.setCommands(instruction.getCommands());
		mower.run();
		assertTrue(new OrientedPosition(1,3, Orientation.NORTH).equals(mower.getOrientedPosition()));
		
		if (!reader.hasNext())
			fail("Another instruction set was expected to be read!");
		else
			instruction = reader.next();
				
		mower = new Mower(instruction.getOrientedPosition(), instruction.getSurface());
		mower.setCommands(instruction.getCommands());
		mower.run();
		assertTrue(new OrientedPosition(5,1, Orientation.EAST).equals(mower.getOrientedPosition()));
	}
	
	
}
