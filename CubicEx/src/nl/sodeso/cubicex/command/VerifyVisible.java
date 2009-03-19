package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>VerifyVisible</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.2
 */
public class VerifyVisible extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(VerifyVisible.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getArgTarget();
		
		if (log.isInfoEnabled()) {
			log.info("VerifyVisible: target '" + _locator + "'.");
		}

		verifyTrue(selenium.isVisible(_locator));	
	}

}
