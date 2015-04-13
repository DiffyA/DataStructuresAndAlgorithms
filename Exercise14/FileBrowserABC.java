package fileBrowser;

import java.io.File;
import java.util.ArrayList;

/**
 * 
 * @author Victor De Gouveia
 * @version 1.0
 * @WARNING This class contains an ordering method that takes a long time to execute if the given 
 * directory contains a lot of elements. Use at your own risk. This has not been optimized.
 */
public class FileBrowserABC {
	// Attributes
	File root;
	int counterFiles = 0;
	int counterDir = 0;

	// Methods
	/**
	 * 
	 * @param name Path of the directory we want to explore.
	 * @param storage An ArrayList used as a storage for the recursive nature of this method.
	 * Stores the elements found in the directory in each iteration, and sets itself as a parameter
	 * in order to keep storing in the same level.
	 * @return A dynamic ArrayList containing all elements in the directory, in no particular order.
	 */
	private ArrayList<File> returnAll(String name, ArrayList<File> storage) { //Puts all found elements into a dynamic ArrayList, in no particular order, to be ordered in other methods.
		root = new File(name);
		File[] parentContains = root.listFiles(); //Creates an array of files of all the directories and files in root.

		for (int ii = 0; ii < parentContains.length; ii++){  //Runs through parentContains, counting the amount of files and directories, then adding them to our dynamic arrayList. If it runs into another directory, it calls the method again.
			if (parentContains[ii].isFile()){
				storage.add(parentContains[ii]); //Adds the file to our dynamic ArrayList.
			}
			if (parentContains[ii].isDirectory()){
				storage.add(parentContains[ii]); //Adds the directory to our dynamic ArrayList.
				returnAll(parentContains[ii].getPath(), storage); //Calls the function again, giving as a parameter the path of the found directory.
			}
		}
	return storage;
	}
	
	/**
	 * 
	 * @param name Path of the directory we want to explore.
	 */
	public void order(String name){
		ArrayList<File> storage = new ArrayList<File>(); //Empty ArrayList used as a parameter for the returnAll method. The original storage ArrayList.
		ArrayList<File> list = returnAll(name, storage); //List returned from the method. Contains elements.
		File[] newList = new File[list.size()]; //Array of files. Will be used to alphabetize elements.
		list.toArray(newList); //Passing the elements in the dynamic array to our static array.
		int fCount = 0; //Counter for amount of files.
		int dCount = 0; //Counter for amount of directories.
		long fileMem = 0; //Memory used up by files.
		long dirMem = 0; //Memory used up by directories.

		for (int ii = 0; ii < newList.length - 1; ii++){ //Organizes the elements in alphabetical order.
			for (int kk = ii + 1; kk < newList.length; kk++){
				File aux = newList[ii];
				if (newList[kk].getName().toLowerCase().compareTo(newList[ii].getName().toLowerCase()) < 1){ //Sorts the elements in alphabetical order. Must set them all to lower case first in order for the compareTo method to work propely, since it compares UNICODE values.
					newList[ii] = newList[kk];
					newList[kk] = aux;
				}
			}
		}
		
		for (int ii = 0; ii < newList.length; ii++){ //Prints the information.
			if (newList[ii].isFile()){ //If the element found is a file.
				fileMem = fileMem + newList[ii].length(); //Adds the size of this file to the file memory counter.
				fCount++; //Adds one to the amount of files counter.
				System.out.printf("%-25s", newList[ii].getName()); //Formats the text.
				System.out.printf("%-10s", "<FILE>");
				System.out.printf("%-5s", newList[ii].length() + " bytes \n");
			}
			if (newList[ii].isDirectory()){ //If the element found is a directory.
				dirMem = dirMem + newList[ii].length(); //Adds the size of this directory to the directory memory counter.
				dCount++; //Adds one to the amount of directories counter.
				System.out.printf("%-25s", newList[ii].getName()); //Formats the text.
				System.out.printf("%-10s", "<DIR>");
				System.out.printf("%-5s", newList[ii].length() + " bytes \n");
			}
		}
		System.out.println();
		System.out.println(dCount + " directories: " + dirMem + " bytes.");
		System.out.println(fCount + " files: " + fileMem + " bytes.");
	}
}
