package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Adds the <code>ChooseOkOnNextPrompt</code> command
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class ChooseOkOnNextPrompt extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(ChooseOkOnNextPrompt.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		if (log.isInfoEnabled()) {
			log.info("ChooseOkOnNextPrompt:");
		}
		
		selenium.chooseOkOnNextConfirmation();		
	}

}
