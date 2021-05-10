package geekTrust;

import java.io.File;
import geekTrust.Family;
import geekTrust.ProcessFiles;

/**
 * 
 * @author nvinchhi
 *
 */
public class Geektrust {

	public static void main(String[] args) {

		// Take argument1 and process initial file.
		Geektrust geek = new Geektrust();
		Family f = new Family();
		try {
			geek.processFile("initInput.txt", false, f);
			geek.processFile(args[0], true, f);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Provide Init and test file both.");
		}

	}

	private void processFile(String fileName, boolean isInputFile, Family f) {
		File file = new File(fileName);
		ProcessFiles fileProcessor = new ProcessFiles(file);
		if (isInputFile) {
			fileProcessor.processInputFile(f);
		} else {
			fileProcessor.processInitFile(f);
		}
	}

}
