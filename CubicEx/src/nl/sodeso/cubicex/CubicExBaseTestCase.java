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
	
	private Log log = LogFactory.getLog(CubicExBaseTestCase.class);
	
	private Map<String, String> arguments = null;
	private IElementContext context = null;
	
	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context, Selenium selenium) throws Exception {
		this.arguments = arguments;
		this.context = context;

		// Logging information
		if (log.isInfoEnabled()) {
			StringBuilder argumentsBuilder = new StringBuilder(this.getClass().getName() + ": ");
			for (String key : arguments.keySet()) {
				argumentsBuilder.append(key).append("='").append(arguments.get(key)).append("' ");
			}
			
			log.info(argumentsBuilder.toString());
		}
		
		// Retrieve the parameters.
		final String _condition = getArgCondition();
		
		boolean _performStep = true;
		if (isNotEmpty(_condition)) {
			
			// Evaluate the condiation.
			String _result = selenium.getExpression(_condition);
			
			// If the result is not true or not 1 then we won't perform this step and just continue
			// to the next step.
			if (!_result.equals("true") || !_result.equals("1")) {
				_performStep = false;
			}
		}
		
		if (_performStep) {
			executeTest(arguments, context, selenium);
		} else {
			if (log.isInfoEnabled()) {
				log.info(this.getClass().getName() + ": Is skipped.");
			}
		}
	}
	
	/**
	 * @see ICustomTestStep#execute(Map, IElementContext, Selenium)
	 */
	public abstract void executeTest(Map<String, String> arguments, IElementContext context, Selenium selenium) throws Exception;
	
	
	/**
	 * Retrieves the <code>condition</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>condition</code> property 
	 */
	public String getArgCondition() {
		String _condition = arguments.get("condition");
		
		if (isNotEmpty(_condition)) {
			_condition = parseString(_condition);
		} else {
			_condition = "";
		}
		
		return _condition;
	}
	
	/**
	 * Retrieves the <code>timeout</code> property.
	 * 
	 * @return the value of the timout or 30000 when no value entered.
	 */
	public long getArgTimeout() {
		String _timeout = arguments.get("timeout");
		
		long _timeoutToUse = 30000l;
		if (isNotEmpty(_timeout)) {
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
		if (isNotEmpty(_value)) {
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
		if (isNotEmpty(_format)) {
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
		if (isNotEmpty(_deviation)) {
			try {
				_deviationToUse = Integer.valueOf(parseString(_deviation));
			} catch (NumberFormatException numberFormatException) {
				log.error(numberFormatException);
			}
		}
		
		return _deviationToUse;
	}
	
	/**
	 * Retrieves the <code>action</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>action</code> property 
	 */
	public String getArgAction() {
		String _action = arguments.get("action");
		if (isNotEmpty(_action)) {
			_action = parseString(_action);
		} else {
			_action = "";
		}
		
		return _action;
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
		if (isNotEmpty(_url)) {
			_url = parseString(_url);
		} else {
			_url = "";
		}
		return _url;
	}
	
	/**
	 * Retrieves the <code>coordx</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>coordx</code> property 
	 */
	public String getArgCoordX() {
		String _coordX = arguments.get("coordx");
		if (isNotEmpty(_coordX)) {
			_coordX = parseString(_coordX);
		} else {
			_coordX = "";
		}
		return _coordX;
	}
	
	/**
	 * Retrieves the <code>coordy</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>coordy</code> property 
	 */
	public String getArgCoordY() {
		String _coordY = arguments.get("coordy");
		if (isNotEmpty(_coordY)) {
			_coordY = parseString(_coordY);
		} else {
			_coordY = "";
		}
		return _coordY;
	}
	
	/**
	 * Retrieves the <code>filename</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>filename</code> property 
	 */
	public String getArgFilename() {
		String _filename = arguments.get("filename");
		if (isNotEmpty(_filename)) {
			_filename = parseString(_filename);
		} else {
			_filename = "";
		}
		return _filename;
	}
	
	
	/**
	 * Retrieves the <code>name</code> property and it will parse it for any
	 * variables defined in the value.
	 * 
	 * @return the value of the <code>name</code> property 
	 */
	public String getArgName() {
		String _name = arguments.get("name");
		if (isNotEmpty(_name)) {
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
		
		if (isNotEmpty(variable)) {
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
		if (isNotEmpty(result)) {
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
		if (isNotEmpty(result)) {
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
		if (isNotEmpty(result)) {
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
		if (isNotEmpty(result)) {
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
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}
}
