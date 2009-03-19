package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>ChooseOkOnNextConfirmation</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class ChooseOkOnNextConfirmation extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(ChooseOkOnNextConfirmation.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		if (log.isInfoEnabled()) {
			log.info("ChooseOkOnNextConfirmation:");
		}
		
		selenium.chooseOkOnNextConfirmation();		
	}

}
