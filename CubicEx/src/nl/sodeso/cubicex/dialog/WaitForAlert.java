package nl.sodeso.cubicex.dialog;

import java.util.Map;

import junit.framework.Assert;
import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>waitForElementPresent</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WaitForAlert extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _valueToCompareTo = getValue();
		final long _timeoutToUse = getTimeout();
		
		new Wait() {
		  public boolean until() {
			 boolean isExpectedAlertPresent = false;
			 if (selenium.isAlertPresent()) {
				 if (_valueToCompareTo != null && _valueToCompareTo.length() > 0) {
					 String _alertMessage = selenium.getAlert();
					 Assert.assertEquals(_valueToCompareTo, _alertMessage);
				 } else {
					 // We need to consume the alert otherwise
					 // the next step will fail.
					 selenium.getAlert();
				 }
				 isExpectedAlertPresent = true;
			 }
			 
			 return isExpectedAlertPresent;
		  }
		}.wait("Alert window did not appear within " + _timeoutToUse + " milliseconds, or did not have the correct message: '" + _valueToCompareTo + "'.", _timeoutToUse);		
	}

}
