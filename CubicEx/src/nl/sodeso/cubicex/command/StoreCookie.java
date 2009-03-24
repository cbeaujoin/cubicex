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
 * Replaces the <code>StoreCookie</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @since 0.0.3
 */
public class StoreCookie extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(StoreCookie.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _variable = getArgVariable();
		
		if (log.isInfoEnabled()) {
			log.info("StoreCookie: variable '" + _variable + "'.");
		}
		
		// Retrieve the value.
		String _value = selenium.getCookie();
		
		// Store the value.
		context.put(_variable, _value);
	}

}