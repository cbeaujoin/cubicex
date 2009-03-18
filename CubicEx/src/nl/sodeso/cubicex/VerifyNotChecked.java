package nl.sodeso.cubicex;

import java.util.Map;

import junit.framework.Assert;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>VerifyText</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class VerifyNotChecked extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getTarget();
		
		// Retrieve the field value.
		String _valueOfField = selenium.getValue(_locator);
		
		// Check if the value is "on"
		Assert.assertEquals("off", _valueOfField);
	}

}
