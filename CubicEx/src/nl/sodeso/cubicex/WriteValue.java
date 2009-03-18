package nl.sodeso.cubicex;

import java.util.Map;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>type</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WriteValue extends CubicExBaseTestCase {

	public void execute(Map<String, String> arguments, IElementContext context,
			Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _locator = getTarget();
		final String _textToWrite = getValue();
		
		selenium.type(_locator, _textToWrite);
	}

}
