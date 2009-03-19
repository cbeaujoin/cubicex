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
 * @version 0.0.1
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
