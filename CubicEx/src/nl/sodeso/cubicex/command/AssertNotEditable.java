package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>AssertNotEditable</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.2
 */
public class AssertNotEditable extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(AssertNotEditable.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getArgTarget();
		
		if (log.isInfoEnabled()) {
			log.info("AssertNotEditable: target '" + _locator + "'.");
		}

		assertFalse(selenium.isEditable(_locator));	
	}

}
