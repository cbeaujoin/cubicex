package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

	private Log log = LogFactory.getLog(WaitForElementPresent.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final long _timeoutToUse = getArgTimeout();
		
		if (log.isInfoEnabled()) {
			log.info("WaitForElementPresent: target '" + _locator + "', timeout '" + _timeoutToUse + "'.");
		}
		
		new Wait() {
		  public boolean until() {
			 return selenium.isElementPresent(_locator);
		  }
		}.wait("Element not found as expected target = '" + _locator + "'", _timeoutToUse);		
	}

}
