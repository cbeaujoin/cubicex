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
public class AssertText extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _locator = getTarget();
		final String _valueToCompareTo = getValue();
		
		// Retrieve the field value.
		String _valueOfField = selenium.getValue(_locator);
		
		Assert.assertEquals(_valueToCompareTo, _valueOfField);
	}

}
