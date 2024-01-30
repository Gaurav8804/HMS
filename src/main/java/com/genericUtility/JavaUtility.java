package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is used to generate the random numbers and return the number to
	 * the caller.
	 * 
	 * @return
	 */

	public int randomNum(int number) {
		Random rm = new Random();
		int num = rm.nextInt(number);
		return num;
	}
	
    /**
     * This method is used to return the System date with time in format to the caller
     * @return
     */
	public String getSystemDateFormat() {
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyy HH-mm-ss");
		Date dt = new Date();
		String date = dt.toString();
		String SysdINFORMAT = SDF.format(date);
		return SysdINFORMAT;
	}
    
	
	/**
	 * This method is used to return the current date to the caller.
	 * @return
	 */
	public String getSystemDate() {
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	
	
	 

}
