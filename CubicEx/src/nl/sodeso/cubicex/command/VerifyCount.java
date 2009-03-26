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
 * The <code>VerifyCouont</code> command
 * 
 * @author r.mathies
 * @since 0.0.3
 */
public class VerifyCount extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(VerifyCount.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final Integer _value = getArgValueAsInteger();
		final Integer _deviation = getArgDeviation();
		
		
		if (log.isInfoEnabled()) {
			  log.info("VerifyCount: target '" + _locator + "', value '" + _value + "', deviation '" + _deviation + "'."); 
		}
		
		Integer _countOfElement = selenium.getXpathCount(_locator).intValue(); 
		
		switch(_deviation) {
			case 0:
				verifyEquals(String.valueOf(_value == _countOfElement), "true");
				break;
             case 1:
            	 verifyEquals(String.valueOf(_countOfElement < _value), "true");
            	 break;
             case 2:
            	 verifyEquals(String.valueOf(_countOfElement > _value), "true");
            	 break;
         }
	}

}
