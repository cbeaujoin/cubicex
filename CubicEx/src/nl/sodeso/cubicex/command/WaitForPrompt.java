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

import junit.framework.Assert;
import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>waitForPromPt</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WaitForPrompt extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(WaitForPrompt.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _valueToCompareTo = getArgValue();
		final long _timeoutToUse = getArgTimeout();
		
		if (log.isInfoEnabled()) {
			log.info("WaitForPrompt: value '" + _valueToCompareTo + "', timeout '" + _timeoutToUse + "'.");
		}
		
		new Wait() {
		  public boolean until() {
			 boolean isExpectedPromptPresent = false;
			 if (selenium.isPromptPresent()) {
				 if (_valueToCompareTo != null && _valueToCompareTo.length() > 0) {
					 String _promptMessage = selenium.getPrompt();
					 Assert.assertEquals(_valueToCompareTo, _promptMessage);
				 } else {
					 // We need to consume the prompt otherwise
					 // the next step will fail.
					 selenium.getPrompt();
				 }
				 isExpectedPromptPresent = true;
			 }
			 
			 return isExpectedPromptPresent;
		  }
		}.wait("Prompt window did not appear within " + _timeoutToUse + " milliseconds.", _timeoutToUse);		
	}

}
