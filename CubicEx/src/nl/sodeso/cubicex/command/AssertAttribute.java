package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>AssertAttribute</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.2
 */
public class AssertAttribute extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(AssertAttribute.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final String _valueToCompareTo = getArgValue();

		if (log.isInfoEnabled()) {
			log.info("AssertAttribute: target '" + _locator + "', value '" + _valueToCompareTo + "'.");
		}
		
		// Retrieve the field value.
		String _valueOfField = selenium.getAttribute(_locator);
		assertEquals(_valueOfField, _valueToCompareTo);
	}

}
