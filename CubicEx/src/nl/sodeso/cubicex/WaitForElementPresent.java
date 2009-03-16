package nl.sodeso.cubicex;

import java.util.Map;

import nl.sodeso.cubicex.util.ArgumentUtils;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>waitForElementPresent</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WaitForElementPresent implements ICustomTestStep {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = ArgumentUtils.getTarget(arguments);
		final long _timeoutToUse = ArgumentUtils.getTimeout(arguments);
		
		new Wait() {
		  public boolean until() {
			 return selenium.isElementPresent(_locator);
		  }
		}.wait("Element not found as expected target = '" + _locator + "'", _timeoutToUse);		
	}

}
