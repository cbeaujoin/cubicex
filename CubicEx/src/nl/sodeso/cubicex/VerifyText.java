package nl.sodeso.cubicex;

import java.util.Map;

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
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getTarget();
		final String _valueToCompareTo = getValue();
		
		// Retrieve the field value.
		String _valueOfField = selenium.getValue(_locator);
		
		// Compare value against field value
		if (!_valueOfField.equals(_valueToCompareTo)) {
			throw new VerifyException("Value not found as expected target = '" + _locator + "', value = '" + _valueToCompareTo + "'");
		}
	}

}
