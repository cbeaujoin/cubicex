package nl.sodeso.cubicex.dialog;

import java.util.Map;

import junit.framework.Assert;
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
public class WaitForConfirmation implements ICustomTestStep {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _valueToCompareTo = ArgumentUtils.getValue(arguments, context);
		final long _timeoutToUse = ArgumentUtils.getTimeout(arguments);
		
		new Wait() {
		  public boolean until() {
			 boolean isExpectedConfirmationPresent = false;
			 if (selenium.isConfirmationPresent()) {
				 if (_valueToCompareTo != null && _valueToCompareTo.length() > 0) {
					 String _confirmationMessage = selenium.getConfirmation();
					 Assert.assertEquals(_valueToCompareTo, _confirmationMessage);
				 } else {
					 // We need to consume the confirmation otherwise
					 // the next step will fail.
					 selenium.getConfirmation();
				 }
				 isExpectedConfirmationPresent = true;
			 }
			 
			 return isExpectedConfirmationPresent;
		  }
		}.wait("Confirmation window did not appear within " + _timeoutToUse + " milliseconds.", _timeoutToUse);		
	}

}
