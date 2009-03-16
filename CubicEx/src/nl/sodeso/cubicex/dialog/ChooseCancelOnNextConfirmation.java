package nl.sodeso.cubicex.dialog;

import java.util.Map;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>chooseCancelOnNextConfirmation</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class ChooseCancelOnNextConfirmation implements ICustomTestStep {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		selenium.chooseCancelOnNextConfirmation();		
	}

}
