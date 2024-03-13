package com.assignment.CourseAssignment.Checkfields;

public class CheckFields {

	public static boolean check(String type,String learn_mode) {
		if( (type.equalsIgnoreCase("personalised")||type.equalsIgnoreCase("group")) && 
			(learn_mode.equalsIgnoreCase("assisted") || learn_mode.equalsIgnoreCase("self learning")) ) {
			
			return true;
		}
		return false;
	}
	// validation that the inputed course type should be "personalised" or "group" 
	// validation that the inputed course learn mode should be "assisted" or "self learning"
}
