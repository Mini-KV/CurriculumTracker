package org.ictkerala.constants;

/*
 * @author Mini
 */
public class AutomationConstants {

	public static String CONFIG_PATH = "/src/main/java/org/ictkerala/config/config.properties";	
	public static String EXCEL_PATH ="/src/main/resources/TestData.xlsx";
	
	public static String LOGIN_SUCCESS_MSG = "Success!";
	public static String LOGIN_FAILURE_MSG = "Error!";
	
	public static String LOGIN_URL = "http://143.244.139.123:3001/login";
	public static String SIGNUP_URL = "http://143.244.139.123:3001/signup";
	public static String REQ_FORM_URL = "http://143.244.139.123:3001/faculty-dashboard/Rformfaculty";
		
	public static String EXP_NAME_ERR = "Name is required and should contain only alphabets";
	public static String EXP_PH_ERR = "Phone Number is required and should be 10 digits";
	public static String EXP_EMAIL_ERR = "Email is required and should be valid";
	public static String EXP_PASS_ERR = "Should consists of alphabets, numbers and atleast 8 characters";
	public static String EXP_CONFPASS_EMPTY_ERR = "Field cannot be empty";
	public static String EXP_CONFPASS_MATCH_ERR = "Passwords do not match";	
	
	public static String EXP_REQ_ALERT = "Requirement added successfully";	
	public static String EXP_REQ_SUBMIT_ALERT = "Added successfully";
	public static String EXP_CURR_APPR_ALERT = "Aprroved successfully";

}
