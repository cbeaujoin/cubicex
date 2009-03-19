package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;
import nl.sodeso.cubicex.exception.VerifyException;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>VerifyText</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class VerifyText extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final String _valueToCompareTo = getArgValue();
		
		// Retrieve the field value.
		String _valueOfField = selenium.getValue(_locator);
		
		// Compare value against field value
		if (!_valueOfField.equals(_valueToCompareTo)) {
			throw new VerifyException("Value not found as expected target = '" + _locator + "', value = '" + _valueToCompareTo + "'");
		}
	}

}
