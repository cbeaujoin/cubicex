package nl.sodeso.cubicex;

import java.util.Map;

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
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getTarget();
		final String _valueToCompareTo = getValue();
		final long _timeoutToUse = getTimeout();
		
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
