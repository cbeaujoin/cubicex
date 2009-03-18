package nl.sodeso.cubicex.util;

import java.util.Map;

import org.cubictest.selenium.custom.IElementContext;

/**
 * Replaces the <code>type</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class ArgumentUtils {

	/**
	 * Retrieves the <code>timeout</code> property.
	 * 
	 * @param arguments the arguments
	 * 
	 * @return the value of the timout or 30000 when no value entered.
	 */
	public static long getTimeout(Map<String, String> arguments) {
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
	public static String getValue(Map<String, String> arguments, IElementContext context) {
		String _value = arguments.get("value");
		if (_value != null && _value.length() > 0) {
			_value = VariableUtils.parseString(context, _value);
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
	public static String getFormat(Map<String, String> arguments, IElementContext context) {
		String _format = arguments.get("format");
		if (_format != null && _format.length() > 0) {
			_format = VariableUtils.parseString(context, _format);
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
	public static int getDeviation(Map<String, String> arguments, IElementContext context) {
		String _deviation = arguments.get("deviation");
		Integer _deviationToUse = 0;
		if (_deviation != null && _deviation.length() > 0) {
			_deviationToUse = Integer.valueOf(VariableUtils.parseString(context, _deviation));
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
	public static String getVariable(Map<String, String> arguments) {
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
	public static String getTarget(Map<String, String> arguments) {
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
	public static String getUrl(Map<String, String> arguments, IElementContext context) {
		String _url = arguments.get("URL");
		if (_url != null && _url.length() > 0) {
			_url = VariableUtils.parseString(context, _url);
		} else {
			_url = "";
		}
		return _url;
	}

}
