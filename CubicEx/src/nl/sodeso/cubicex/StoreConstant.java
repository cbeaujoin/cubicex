package nl.sodeso.cubicex;

import java.util.Map;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Store a value as a variable.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreConstant extends CubicExBaseTestCase {

	public void execute(Map<String, String> arguments, IElementContext context,
			Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _variable = getVariable();
		final String _textToStore = getValue();
		
		setStringVariable(_variable, _textToStore);
	}

}
