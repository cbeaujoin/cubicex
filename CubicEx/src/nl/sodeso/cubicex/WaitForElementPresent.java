package nl.sodeso.cubicex;

import java.util.Map;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>waitForElementPresent</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WaitForElementPresent extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getTarget();
		final long _timeoutToUse = getTimeout();
		
		new Wait() {
		  public boolean until() {
			 return selenium.isElementPresent(_locator);
		  }
		}.wait("Element not found as expected target = '" + _locator + "'", _timeoutToUse);		
	}

}
