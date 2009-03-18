package nl.sodeso.cubicex.dialog;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>storeConfirmation</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreConfirmation extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, final IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final long _timeoutToUse = getTimeout();
		final String _variable = getVariable();
		
		new Wait() {
		  public boolean until() {
			 boolean isExpectedConfirmationPresent = false;
			 if (selenium.isConfirmationPresent()) {
				 String _confirmationMessage = selenium.getConfirmation();
				 context.put(_variable, _confirmationMessage);
				 isExpectedConfirmationPresent = true;
			 }
			 
			 return isExpectedConfirmationPresent;
		  }
		}.wait("Confirmation window did not appear within " + _timeoutToUse + " milliseconds.", _timeoutToUse);	
	}

}
