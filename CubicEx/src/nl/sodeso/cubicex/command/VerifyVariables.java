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
package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * The <code>VerifyVariables</code> command
 * 
 * @author r.mathies
 * @since 0.0.2
 */
public class VerifyVariables extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(VerifyVariables.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _variable = getArgVariable();
		final String _value = getArgValue();
		
		if (log.isInfoEnabled()) {
			log.info("VerifyVariables: variable '" + _variable + "', value '" + _value + "'.");
		}
		
		// Retrieve the field value.
		String _valueOfVariable = getVariableAsString(_variable);
		
		verifyEquals(_valueOfVariable, _value);
	}

}
