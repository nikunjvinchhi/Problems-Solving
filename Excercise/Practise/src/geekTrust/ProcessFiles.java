package geekTrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessFiles implements ActionsConstants, MessageConstants {

	Scanner sc;

	public ProcessFiles(File file) {
		try {
			this.sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please give correct file.");
		}
	}

	public void processInputFile(Family f) {
		while (sc.hasNextLine()) {
			String actions = sc.nextLine();
			System.out.println(runActions(actions, f));
		}
	}

	private String runActions(String actions, Family f) {
		String[] splitActions = actions.split(" ");
		String result = "";
		switch (splitActions[0]) {
		case ADD_CHILD:
			result = f.addChild(splitActions[1], splitActions[2], splitActions[3]);
			break;
		case GET_RELATIONSHIP:
			result = f.getRelationShip(splitActions[1], splitActions[2]);
			break;
		default:
			result = INVALID_COMMAND;
			break;
		}
		return result;
	}

	public void processInitFile(Family f) {
		while (sc.hasNextLine()) {
			String command = sc.nextLine();
			initializateFamilyTree(command, f);
		}
	}

	private void initializateFamilyTree(String command, Family f) {
		String[] relations = command.split(";");
		String action = relations[0];

		switch (action) {

		case ADD_FAMILY_HEAD:
			f.addFamilyHead(relations[1], relations[2]);
			break;

		case ADD_CHILD:
			f.addChild(relations[1], relations[2], relations[3]);
			break;

		case ADD_SPOUSE:
			f.addSpouse(relations[1], relations[2], relations[2]);
			break;

		default:
			break;
		}

	}
}
