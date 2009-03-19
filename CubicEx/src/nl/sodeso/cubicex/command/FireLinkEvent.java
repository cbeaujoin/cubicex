package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Command to fire a URL event.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class FireLinkEvent extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(FireLinkEvent.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _url = getArgUrl();

		if (log.isInfoEnabled()) {
			log.info("FireLinkEvent: URL '" + _url + "'.");
		}
		
		selenium.open(_url);
	}

}
