package handles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActionSortImpl implements ActionHandler {
	
	//user needs to declare his own paths
	 private final String sourcePath = "C://sort//"; 
	 private final String destPath = "C://sort//";

	@Override
	public String getName() {
		return "Sort";
	}

	@Override
	public void execute(String source, String dest) {
		System.out.println("I am sorting");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String currentLine = null;

		List<String> lines = new ArrayList<String>();

		try {

			reader = new BufferedReader(new FileReader(sourcePath + source + ".txt"));
			while ((currentLine = reader.readLine()) != null) {
				lines.add(currentLine);

			}

			Collections.sort(lines);
			writer = new BufferedWriter(new FileWriter(destPath + dest + ".txt"));

			for (String line : lines) {
				writer.write(line);

				writer.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (reader != null) {
					reader.close();
				}

				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
