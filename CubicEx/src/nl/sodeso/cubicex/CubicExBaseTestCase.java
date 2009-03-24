/**
 *  Copyright 2009 Sodeso 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package nl.sodeso.cubicex;

import java.util.Map;

import nl.sodeso.cubicex.command.AssertAttribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

/**
 * Base class for all commands.
 * 
 * @author r.mathies
 * @since 0.0.2
 */
public abstract class CubicExBaseTestCase extends SeleneseTestCase implements ICustomTestStep {
	
	private Log log = LogFactory.getLog(AssertAttribute.class);
	
	private Map<String, String> arguments = null;
	private IElementContext context = null;
	
	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context, Selenium selenium) throws Exception {
		this.arguments = arguments;
		this.context = context;
		
		executeTest(arguments, context, selenium);
	}
	
	/**
	 * @see ICustomTestStep#execute(Map, IElementContext, Selenium)
	 */
	public abstract void executeTest(Map<String, String> arguments, IElementContext context, Selenium selenium) throws Exception;
	
	/**
	 * Retrieves the <code>timeout</code> property.
	 * 
	 * @return the value of the timout or 30000 when no value entered.
	 */
	public long getArgTimeout() {
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
	 * @return the value of the <code>value</code> property 
	 */
	public String getArgValue() {
		String _value = arguments.get("value");
		if (_value != null && _value.length() > 0) {
			_value = parseString(_value);
		} else {
			_value = "";
		}
		
		return _value;
	}
	
	/**
	 * Retrieves the <code>value</code> property and it will parse it for any
	 * variables defined in the value. After this it will perform a
	 * {@link Integer#valueOf(String)} to get the value as an Integer. 
	 * 
	 * @return the value of the <code>value</code> property 
	 */
	public Integer getArgValueAsInteger() {
		String _value = getArgValue();
		
		Integer _valueAsInteger = null;
		try {
			_valueAsInteger = Integer.valueOf(_value);
		} catch (NumberFormatException numberFormatException) {
			log.error(numberFormatException);
		}
		
		return _valueAsInteger;
	}
	
	/**
	 * Retrieves the <code>value</code> property and it will parse it for any
	 * variables defined in the value. After this it will perform a
	 * {@link Double#valueOf(String)} to get the value as a Double. 
	 * 
	 * @return the value of the <code>value</code> property 
	 */
	public Double getArgValueAsDouble() {
		String _value = getArgValue();
		
		Double _valueAsDouble = null;
		try {
			_valueAsDouble = Double.valueOf(_value);
		} catch (NumberFormatException numberFormatException) {
			log.error(numberFormatException);
		}
		
		return _valueAsDouble;
	}
	
	/**
	 * Retrieves the <code>value</code> property and it will parse it for any
	 * variables defined in the value. After this it will perform a
	 * {@link Float#valueOf(String)} to get the value as a Float. 
	 * 
	 * @return the value of the <code>value</code> property 
	 */
	public Float getArgValueAsFloat() {
		String _value = getArgValue();
		
		Float _valueAsFloat = null;
		try {
			_valueAsFloat = Float.valueOf(_value);
		} catch (NumberFormatException numberFormatException) {
			log.error(numberFormatException);
		}
		
		return _valueAsFloat;
	}
	
	/**
	 * Retrieves the <code>value</code> property and it will parse it for any
	 * variables defined in the value. After this it will perform a
	 * {@link Long#valueOf(String)} to get the value as a Long. 
	 * 
	 * @return the value of the <code>value</code> property 
	 */
	public Long getArgValueAsLong() {
		String _value = getArgValue();
		
		Long _valueAsLong = null;
		try {
			_valueAsLong = Long.valueOf(_value);
		} catch (NumberFormatException numberFormatException) {
			log.error(numberFormatException);
		}
		
		return _valueAsLong;
	}
	
	/**
	 * Retrieves the <code>format</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>format</code> property 
	 */
	public String getArgFormat() {
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
	 * @return the value of the <code>deviation</code> property 
	 */
	public int getArgDeviation() {
		String _deviation = arguments.get("deviation");
		Integer _deviationToUse = 0;
		if (_deviation != null && _deviation.length() > 0) {
			try {
				_deviationToUse = Integer.valueOf(parseString(_deviation));
			} catch (NumberFormatException numberFormatException) {
				log.error(numberFormatException);
			}
		}
		
		return _deviationToUse;
	}
	
	/**
	 * Retrieves the <code>variable</code> property.
	 *
	 * @return the value of the <code>variable</code> property.
	 */
	public String getArgVariable() {
		String _variable = arguments.get("variable");
		return _variable;
	}

	/**
	 * Retrieves the <code>expression</code> property.
	 * 
	 * @return the value of the <code>expression</code> property.
	 */
	public String getArgExpression() {
		String _expression = arguments.get("expression");
		return _expression;
	}
	
	/**
	 * Retrieves the <code>target</code> property.
	 * 
	 * @return the value of the <code>target</code> property.
	 */
	public String getArgTarget() {
		String _target = arguments.get("target");
		return _target;
	}
	
	/**
	 * Retrieves the <code>url</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>url</code> property 
	 */
	public String getArgUrl() {
		String _url = arguments.get("URL");
		if (_url != null && _url.length() > 0) {
			_url = parseString(_url);
		} else {
			_url = "";
		}
		return _url;
	}
	
	/**
	 * Retrieves the <code>name</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>name</code> property 
	 */
	public String getArgName() {
		String _name = arguments.get("name");
		if (_name != null && _name.length() > 0) {
			_name = parseString(_name);
		} else {
			_name = "";
		}
		return _name;
	}
	
	/**
	 * Retrieves a String variable from the context.
	 * 
	 * @param variable the name of the variable
	 * 
	 * @return the value stored in the context
	 */
	public String getVariableAsString(String variable) {
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
	public void setVariable(String variable, String value) {
		if (variable != null && variable.length() > 0) {
			context.put(variable, value);
		}
	}
	
	/**
	 * Retrieves an <code>Integer</code> variable from the context.
	 * 
	 * @param variable the name of the variable
	 * 
	 * @return the value stored in the context
	 */
	public Integer getVariableAsInteger(String variable) {
		String result = getVariableAsString(variable);
		
		Integer returnValue = null;
		if (result != null && result.length() >0) {
			try {
				returnValue = Integer.valueOf(result);
			} catch (NumberFormatException numberFormatException) {
				log.error(numberFormatException);
			}
		}
		
		return returnValue;
	}
	
	/**
	 * Retrieves an <code>Long</code> variable from the context.
	 * 
	 * @param variable the name of the variable
	 * 
	 * @return the value stored in the context
	 */
	public Long getVariableAsLong(String variable) {
		String result = getVariableAsString(variable);
		
		Long returnValue = null;
		if (result != null && result.length() >0) {
			try {
				returnValue = Long.valueOf(result);
			} catch (NumberFormatException numberFormatException) {
				log.error(numberFormatException);
			}
		}
		
		return returnValue;
	}
	
	/**
	 * Retrieves an <code>Double</code> variable from the context.
	 * 
	 * @param variable the name of the variable
	 * 
	 * @return the value stored in the context
	 */
	public Double getVariableAsDouble(String variable) {
		String result = getVariableAsString(variable);
		
		Double returnValue = null;
		if (result != null && result.length() >0) {
			try {
				returnValue = Double.valueOf(result);
			} catch (NumberFormatException numberFormatException) {
				log.error(numberFormatException);
			}
		}
		
		return returnValue;
	}
	
	/**
	 * Retrieves an <code>Float</code> variable from the context.
	 * 
	 * @param variable the name of the variable
	 * 
	 * @return the value stored in the context
	 */
	public Float getVariableAsFloat(String variable) {
		String result = getVariableAsString(variable);
		
		Float returnValue = null;
		if (result != null && result.length() >0) {
			try {
				returnValue = Float.valueOf(result);
			} catch (NumberFormatException numberFormatException) {
				log.error(numberFormatException);
			}
		}
		
		return returnValue;
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
			String varValue = getVariableAsString(variable);
			
			// Replace the variable with the value from the context.
			result = result.replace("${" + variable + "}", varValue);
			
			// Reset the startIndex.
			startIndex = endIndex;
		}
		
		return result;
	}
}
