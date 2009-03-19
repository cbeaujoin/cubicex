package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>VerifyText</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class AssertChecked extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(AssertChecked.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getArgTarget();
		
		if (log.isInfoEnabled()) {
			log.info("VerifyChecked: target '" + _locator + "'.");
		}
		
		// Retrieve the field value.
		String _valueOfField = selenium.getValue(_locator);
		
		// Check if the value is "on"
		assertEquals("on", _valueOfField);
	}

}
