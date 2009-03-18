package nl.sodeso.cubicex.dialog;

import java.util.Map;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Adds the <code>ChooseCancelOnNextPrompt</code> command
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class ChooseCancelOnNextPrompt implements ICustomTestStep {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		selenium.chooseCancelOnNextConfirmation();		
	}

}