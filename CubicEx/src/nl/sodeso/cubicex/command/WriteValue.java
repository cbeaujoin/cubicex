package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>type</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WriteValue extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(WriteValue.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final String _textToWrite = getArgValue();
		
		if (log.isInfoEnabled()) {
			log.info("WriteValue: target '" + _locator + "', value '" + _textToWrite + "'.");
		}
		
		selenium.type(_locator, _textToWrite);
	}

}
