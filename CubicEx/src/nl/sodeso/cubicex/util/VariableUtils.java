package nl.sodeso.cubicex.util;

import org.cubictest.selenium.custom.IElementContext;

/**
 * Util class for retrieving variables and parsing Strings with variables.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class VariableUtils {

	/**
	 * Retrieves a String variable from the context.
	 * 
	 * @param context the context
	 * @param variable the name of the variable
	 * 
	 * @return the value stored in the context
	 */
	public static String getStringVariable(IElementContext context, String variable) {
		String result = null;
		
		if (variable != null && variable.length() > 0) {
			result = (String)context.get(variable);
		}
		
		return (result != null ? result : "");
	}
	
	/**
	 * Stores a value in the context where the key is the name of the variable.
	 * 
	 * @param context the context
	 * @param variable the name of the variable
	 * @param value the value to store in the context.
	 */
	public static void setStringVariable(IElementContext context, String variable, String value) {
		if (variable != null && variable.length() > 0) {
			context.put(variable, value);
		}
	}
	
	/**
	 * Parses a String containing variables and returns the parsed string.
	 * 
	 * @param context the context
	 * @param value the value to parse
	 * 
	 * @return the parsed string
	 */
	public static String parseString(IElementContext context, String value) {
		int startIndex = 0;
		String result = value;
		while ((startIndex = value.indexOf("${", startIndex)) >= 0) {
			
			// Calculate the ending index.
			int endIndex = value.indexOf("}", startIndex);
			
			// Retrieve the variable name.
			String variable = value.substring(startIndex + "${".length(), endIndex);
			
			// Retrieve the variable value from the context.
			String varValue = getStringVariable(context, variable);
			
			// Replace the variable with the value from the context.
			result = result.replace("${" + variable + "}", varValue);
			
			// Reset the startIndex.
			startIndex = endIndex;
		}
		
		return result;
	}
	
}
