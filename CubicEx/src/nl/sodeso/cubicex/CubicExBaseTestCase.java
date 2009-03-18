package nl.sodeso.cubicex;

import java.util.Map;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

/**
 * Base class for all commands.
 * 
 * @author r.mathies
 * @version 0.0.2
 */
public abstract class CubicExBaseTestCase extends SeleneseTestCase implements ICustomTestStep {

	private Map<String, String> arguments = null;
	private IElementContext context = null;
	private Selenium selenium = null;
	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context, Selenium selenium) throws Exception {
		this.arguments = arguments;
		this.context = context;
		this.selenium = selenium;
	}
	
	/**
	 * Retrieves the <code>timeout</code> property.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the timout or 30000 when no value entered.
	 */
	public long getTimeout() {
		String _timeout = arguments.get("timeout");
		
		long _timeoutToUse = 30000l;
		if (_timeout != null && _timeout.length() > 0) {
			_timeoutToUse = Long.parseLong(_timeout);
		}
		
		return _timeoutToUse;
	}
	
	/**
	 * Retrieves the <code>value</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the <code>value</code> property 
	 */
	public String getValue() {
		String _value = arguments.get("value");
		if (_value != null && _value.length() > 0) {
			_value = parseString(_value);
		} else {
			_value = "";
		}
		
		return _value;
	}
	
	/**
	 * Retrieves the <code>format</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the <code>format</code> property 
	 */
	public String getFormat() {
		String _format = arguments.get("format");
		if (_format != null && _format.length() > 0) {
			_format = parseString(_format);
		} else {
			_format = "";
		}
		
		return _format;
	}
	
	/**
	 * Retrieves the <code>deviation</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the <code>deviation</code> property 
	 */
	public int getDeviation() {
		String _deviation = arguments.get("deviation");
		Integer _deviationToUse = 0;
		if (_deviation != null && _deviation.length() > 0) {
			_deviationToUse = Integer.valueOf(parseString(_deviation));
		}
		
		return _deviationToUse;
	}
	
	/**
	 * Retrieves the <code>variable</code> property.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the <code>variable</code> property.
	 */
	public String getVariable() {
		String _variable = arguments.get("variable");
		return _variable;
	}
	
	/**
	 * Retrieves the <code>target</code> property.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the <code>target</code> property.
	 */
	public String getTarget() {
		String _target = arguments.get("target");
		return _target;
	}
	
	/**
	 * Retrieves the <code>url</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the <code>url</code> property 
	 */
	public String getUrl() {
		String _url = arguments.get("URL");
		if (_url != null && _url.length() > 0) {
			_url = parseString(_url);
		} else {
			_url = "";
		}
		return _url;
	}
	
	/**
	 * Retrieves a String variable from the context.
	 * 
	 * @param variable the name of the variable
	 * 
	 * @return the value stored in the context
	 */
	public String getStringVariable(String variable) {
		String result = null;
		
		if (variable != null && variable.length() > 0) {
			result = (String)context.get(variable);
		}
		
		return (result != null ? result : "");
	}
	
	/**
	 * Stores a value in the context where the key is the name of the variable.
	 * 
	 * @param variable the name of the variable
	 * @param value the value to store in the context.
	 */
	public void setStringVariable(String variable, String value) {
		if (variable != null && variable.length() > 0) {
			context.put(variable, value);
		}
	}
	
	/**
	 * Parses a String containing variables and returns the parsed string.
	 * 
	 * @param value the value to parse
	 * 
	 * @return the parsed string
	 */
	public String parseString(String value) {
		int startIndex = 0;
		String result = value;
		while ((startIndex = value.indexOf("${", startIndex)) >= 0) {
			
			// Calculate the ending index.
			int endIndex = value.indexOf("}", startIndex);
			
			// Retrieve the variable name.
			String variable = value.substring(startIndex + "${".length(), endIndex);
			
			// Retrieve the variable value from the context.
			String varValue = getStringVariable(variable);
			
			// Replace the variable with the value from the context.
			result = result.replace("${" + variable + "}", varValue);
			
			// Reset the startIndex.
			startIndex = endIndex;
		}
		
		return result;
	}
}
