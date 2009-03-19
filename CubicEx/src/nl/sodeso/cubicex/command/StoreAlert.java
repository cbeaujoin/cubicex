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
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>storeAlert</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreAlert extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(StoreAlert.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final long _timeoutToUse = getArgTimeout();
		final String _variable = getArgVariable();
		
		if (log.isInfoEnabled()) {
			log.info("StoreAlert: variable '" + _variable + "', timeout '" + _timeoutToUse + "'.");
		}
		
		new Wait() {
		  public boolean until() {
			 boolean isExpectedAlertPresent = false;
			 if (selenium.isAlertPresent()) {
				 String _alertMessage = selenium.getAlert();
				 context.put(_variable, _alertMessage);

				 isExpectedAlertPresent = true;
			 }
			 
			 return isExpectedAlertPresent;
		  }
		}.wait("Alert window did not appear within " + _timeoutToUse + " milliseconds.", _timeoutToUse);
	}

}
