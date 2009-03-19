package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Store a value as a variable.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreConstant extends CubicExBaseTestCase {

	private Log log = LogFactory.getLog(StoreConstant.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _variable = getArgVariable();
		final String _textToStore = getArgValue();
		
		if (log.isInfoEnabled()) {
			log.info("StoreConstant: variable '" + _variable + "', value '" + _textToStore + "'.");
		}
		
		setVariable(_variable, _textToStore);
	}

}