package com.alraedah.assignment.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author FaisalMOI
 *
 */
public class TestRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String rexEx ="^list[1-9].*";
		
		String sampleText= "li22";
		
		Pattern pattern = Pattern.compile(rexEx);
		Matcher m = pattern.matcher(sampleText); 
		
		System.out.println("Regex Test:"+ m.matches());
		
		
					
	}

}
