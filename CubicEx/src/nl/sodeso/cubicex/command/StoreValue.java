package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>storeValue</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreValue extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final String _variable = getArgVariable();
		
		// Retrieve the value.
		String _value = selenium.getValue(_locator);
		
		// Store the value.
		context.put(_variable, _value);
	}

}
