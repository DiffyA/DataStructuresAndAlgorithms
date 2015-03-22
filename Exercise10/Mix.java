package exercise10;

import edalib.list.singlelink.*;

public class Mix {

	//Methods
	public SQueue<Double> mixer(SQueue<Double> q1, SQueue<Double> q2) {
		String s1 = q1.toString(); //Transforms the Single Queue to it's string equivalent.
		String s2 = q2.toString(); 
		String[] arr1 = s1.split(","); //Splits the string by the comma and places the elements in an array of strings.
		String[] arr2 = s2.split(",");
		String[] arrResult = new String[arr1.length + arr2.length]; //Creates a new String array whose size is the addition of the previous arrays' size.
		Double[] arrResultD = new Double[arrResult.length]; //Creates a double array that will hold the values.
		SQueue<Double> result = new SQueue<Double>();
		
		//Introduces the elements in s1 to the string array.
		for (int ii = 0; ii < arr1.length; ii++) {
			arrResult[ii] = arr1[ii];
		}
		
		//Introduces the elements in s2 to the string array.
		int kk = arr1.length;
		for (int ii = 0; ii < arr2.length; ii++) {
			arrResult[kk] = arr2[ii];
			kk++;
		}
		
		//Passes the elements of the string array into the double array.
		for (int ii = 0; ii < arrResult.length; ii++) {
			arrResultD[ii] = Double.valueOf(arrResult[ii]);
		}

		//Sorts the double array
		for (int ii = 0; ii < arrResultD.length; ii++) {
			for (int jj = ii + 1; jj < arrResultD.length; jj++) {
				if (arrResultD[ii] > arrResultD[jj]) {
					double aux = arrResultD[jj];
					arrResultD[jj] = arrResultD[ii];
					arrResultD[ii] = aux;
				}
			}
		}	
		
		//Enqueues the elements of the double array into the queue.
		for (int ii = 0; ii < arrResultD.length; ii++){
			result.enqueue(arrResultD[ii]);
		}
		
		return result;
	}

	
	public static void main(String[] args) {
		Mix a = new Mix();
		SQueue<Double> q1 = new SQueue<Double>();
		SQueue<Double> q2 = new SQueue<Double>();
		q1.enqueue(14.0);
		q1.enqueue(7.0);
		q1.enqueue(6.0);
		q1.enqueue(-1.0);
		q1.enqueue(4.0);
		q2.enqueue(3.0);
		q2.enqueue(17.0);
		q2.enqueue(1.0);
		System.out.println(a.mixer(q1, q2));
	}
}
