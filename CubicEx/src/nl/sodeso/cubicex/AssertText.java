package nl.sodeso.cubicex;

import java.util.Map;

import junit.framework.Assert;
import nl.sodeso.cubicex.util.ArgumentUtils;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>VerifyText</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class AssertText implements ICustomTestStep {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = ArgumentUtils.getTarget(arguments);
		final String _valueToCompareTo = ArgumentUtils.getValue(arguments, context);
		
		// Retrieve the field value.
		String _valueOfField = selenium.getValue(_locator);
		
		Assert.assertEquals(_valueToCompareTo, _valueOfField);
	}

}
