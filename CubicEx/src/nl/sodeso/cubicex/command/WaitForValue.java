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

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>waitForValue</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @since 0.0.1
 */
public class WaitForValue extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final String _valueToCompareTo = getArgValue();
		final long _timeoutToUse = getArgTimeout();

		new Wait() {
		  public boolean until() {
		     boolean isValuePresent = false;
			 if (selenium.isElementPresent(_locator)) {
				 String _actualValue = selenium.getValue(_locator);
				 if (_actualValue.equals(_valueToCompareTo)) {
					 isValuePresent = true;
				 }
		     }
			 
			 return isValuePresent;
		  }
		}.wait("Value not found as expected target = '" + _locator + "', value = '" + _valueToCompareTo + "'", _timeoutToUse);
	}

}
