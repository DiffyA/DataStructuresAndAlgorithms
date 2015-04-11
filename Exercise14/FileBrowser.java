package fileBrowser;

import java.io.File;

public class FileBrowser {
	// Attributes
	File root;
	int counterFiles = 0;
	int counterDir = 0;
	
	// Method
	/**
	 * 
	 * @param name : a string representation of the path we want to analyze.
	 * @return A list containing all files and directories inside of the directory given
	 * as a parameter. Includes if the element is a file or a directory, it's individual size
	 * and the total amount of elements and size of each grouping.
	 */
	public String returnAll(String name){
		root = new File(name);
		File[] parentContains = root.listFiles(); //Creates an array of files of all the directories and files in root.
		long totalMemDir = 0;
		long totalMemFile = 0;
		
		for (int ii = 0; ii < parentContains.length; ii++){  //Runs through parentContains, counting the amount of files and directories, then adding them to our dynamic arrayList. If it runs into another directory, it calls the method again.
			if (parentContains[ii].isFile()){
				this.counterFiles++;
			}
			if (parentContains[ii].isDirectory()){
				this.counterDir++;
				returnAll(parentContains[ii].getPath()); //Calls the function again, giving as a parameter the path of the found directory.
			}	
			
		}
		
		for (int ii = 0; ii < parentContains.length; ii++){ //Prints the contents of parentContains.
			if (parentContains[ii].isFile()){
				long memUsed = parentContains[ii].length(); //Memory used by the file.
				totalMemFile = totalMemFile + memUsed; //Adds to the total memory used by files.
				System.out.printf("%-25s", parentContains[ii].getName()); //Formats the string, pads it on the left, 25 char total.
				System.out.println( "<FIL> \t \t" + memUsed + " bytes");
			}
			if (parentContains[ii].isDirectory()){
				long memUsed = parentContains[ii].length(); //Memory used by the directory.
				totalMemDir = totalMemDir + memUsed; //Adds to the total memory used by directories.
				System.out.printf("%-25s", parentContains[ii].getName()); //Formats the string, pads it on the gith, 25 char total.
				System.out.println( "<DIR> \t \t" + memUsed + " bytes");
			}
		
		}
		
		return "\n" + "Directories found: " + counterDir + "\n" + "DIR memory: " + totalMemDir + " bytes" + "\n" + "Files found: " + counterFiles + "\n" + "FILE memory: " + totalMemFile + " bytes";
	}
}
