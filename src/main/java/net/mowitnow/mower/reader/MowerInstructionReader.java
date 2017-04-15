package net.mowitnow.mower.reader;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MowerInstructionReader implements Iterator<MowerInstructionSet> {

	private Iterator<MowerInstructionSet> iterator;
		
	private static Iterator<MowerInstructionSet> getIterator(LineNumberReader lineNumberReader) throws MowerException {
		List<MowerInstructionSet> instructions = new ArrayList<MowerInstructionSet>();
		String[] array = new String[3];
		
		try {
			String line;
			while ((line = lineNumberReader.readLine()) != null) {
				if (lineNumberReader.getLineNumber() == 1)
					array[0] = line;
				else if (lineNumberReader.getLineNumber() % 2 == 0)
					array[1] = line;
				else {
					array[2] = line;
					instructions.add(MowerInstructionParser.getMowerInstructionSet(array));
				}
			}
		} catch (MowerException me) {
	    	throw me;
		} catch (Exception e) {
			throw new MowerException(e.getMessage(), e.getCause());
		}
		return instructions.iterator();
	}

	public MowerInstructionReader(String filePath) throws MowerException {
		LineNumberReader lineNumberReader = null; 
		try {
			lineNumberReader = new LineNumberReader(new FileReader(new File(filePath)));
			this.iterator = getIterator(lineNumberReader);
		} catch (MowerException me) {
			throw me;
		} catch (Exception e) {
			throw new MowerException(e.getMessage(), e.getCause());
		} finally {
			try {
				if (lineNumberReader != null)
					lineNumberReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public MowerInstructionSet next() {
		return iterator.next();
	}

	public void remove() {
		iterator.remove();
	}
	
}
