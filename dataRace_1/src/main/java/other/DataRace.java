package dataRace;

import java.util.*;
import java.util.Collections;


public class DataRace {
	private ArrayList list=new ArrayList();
	private static  String[] rep;
	private static int[] testIntArr;

	public static String[] Request3(){
		System.out.println("Request3 Start");
		ArrayList arr3 = new ArrayList();
		for(int i=0;i<5;i++){
			arr3.add("Request 3");
			System.out.println("Request3 End");
		}
		
		rep = new String[5];
		arr3.toArray(rep);
		testIntArr = new int[2];
		testIntArr[0] =5;
		return rep;
	}

	public static String[] Request4(){
		System.out.println("Request4 Start");
		ArrayList arr4 = new ArrayList();
		for(int i=0;i<5;i++){
			arr4.add("Request 4");
			System.out.println("Request4 End");
		}
		rep = new String[5];
		arr4.toArray(rep);
		return rep;
	}

}
