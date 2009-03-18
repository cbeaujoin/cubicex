package nl.sodeso.cubicex.dialog;

import java.util.Map;

import junit.framework.Assert;
import nl.sodeso.cubicex.util.ArgumentUtils;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>waitForPromPt</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WaitForPrompt implements ICustomTestStep {

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
			 boolean isExpectedPromptPresent = false;
			 if (selenium.isPromptPresent()) {
				 if (_valueToCompareTo != null && _valueToCompareTo.length() > 0) {
					 String _promptMessage = selenium.getPrompt();
					 Assert.assertEquals(_valueToCompareTo, _promptMessage);
				 } else {
					 // We need to consume the prompt otherwise
					 // the next step will fail.
					 selenium.getPrompt();
				 }
				 isExpectedPromptPresent = true;
			 }
			 
			 return isExpectedPromptPresent;
		  }
		}.wait("Prompt window did not appear within " + _timeoutToUse + " milliseconds.", _timeoutToUse);		
	}

}