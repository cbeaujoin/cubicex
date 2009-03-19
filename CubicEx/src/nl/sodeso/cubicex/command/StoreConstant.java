package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Store a value as a variable.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreConstant extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _variable = getArgVariable();
		final String _textToStore = getArgValue();
		
		setVariable(_variable, _textToStore);
	}

}
