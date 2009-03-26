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
 * The <code>AssertCount</code> command can check if the number of result
 * of an XPath expression is the same, lower then or higher then the expected result.
 * 
 * @author r.mathies
 * @since 0.0.3
 */
public class AssertCount extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(AssertCount.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final Integer _value = getArgValueAsInteger();
		final String _action = getArgAction();
		
		if (log.isInfoEnabled()) {
			  log.info("AssertCount: target '" + _locator + "', value '" + _value + "', action '" + _action + "'."); 
		}
		
		// Retrieve the count of the XPath result.
		Integer _countOfElement = selenium.getXpathCount(_locator).intValue(); 
		
		if (_action.equalsIgnoreCase("<")) {
			assertEquals(String.valueOf(_countOfElement.intValue() < _value.intValue()), "true");
		} else if (_action.equalsIgnoreCase("==")) {
			assertEquals(String.valueOf(_countOfElement.intValue() == _value.intValue()), "true");
		} else if (_action.equalsIgnoreCase(">")) {
			assertEquals(String.valueOf(_countOfElement.intValue() > _value.intValue()), "true");
		} else if (_action.equalsIgnoreCase("<=")) {
			assertEquals(String.valueOf(_countOfElement.intValue() <= _value.intValue()), "true");
		} else if (_action.equalsIgnoreCase(">=")) {
			assertEquals(String.valueOf(_countOfElement.intValue() >= _value.intValue()), "true");
		} else if (_action.equalsIgnoreCase("!=")) {
			assertEquals(String.valueOf(_countOfElement.intValue() != _value.intValue()), "true");
		}
	}

}
