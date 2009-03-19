package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>StoreAttribute</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreAttribute extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(StoreAttribute.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _attributeLocator = getArgTarget();
		final String _variable = getArgVariable();
		
		if (log.isInfoEnabled()) {
			log.info("StoreAttribute: target '" + _attributeLocator + "', variable '" + _variable + "'.");
		}
		
		// Retrieve the value.
		String _value = selenium.getAttribute(_attributeLocator);
		
		// Store the value.
		context.put(_variable, _value);
	}

}
