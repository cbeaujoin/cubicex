package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

/**
 * Replaces the <code>storePrompt</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StorePrompt extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final long _timeoutToUse = getArgTimeout();
		final String _variable = getArgVariable();
		
		new Wait() {
		  public boolean until() {
			 boolean isExpectedPromptPresent = false;
			 if (selenium.isPromptPresent()) {
				 String _promptMessage = selenium.getPrompt();
				 context.put(_variable, _promptMessage);
				 isExpectedPromptPresent = true;
			 }
			 
			 return isExpectedPromptPresent;
		  }
		}.wait("Prompt window did not appear within " + _timeoutToUse + " milliseconds.", _timeoutToUse);	
	}

}
