package nl.sodeso.cubicex.dialog;

import java.util.Map;

import nl.sodeso.cubicex.util.ArgumentUtils;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>storeAlert</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreAlert implements ICustomTestStep {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, final IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final long _timeoutToUse = ArgumentUtils.getTimeout(arguments);
		final String _variable = ArgumentUtils.getVariable(arguments);
		
		new Wait() {
		  public boolean until() {
			 boolean isExpectedAlertPresent = false;
			 if (selenium.isAlertPresent()) {
				 String _alertMessage = selenium.getAlert();
				 context.put(_variable, _alertMessage);

				 isExpectedAlertPresent = true;
			 }
			 
			 return isExpectedAlertPresent;
		  }
		}.wait("Alert window did not appear within " + _timeoutToUse + " milliseconds.", _timeoutToUse);
	}

}
