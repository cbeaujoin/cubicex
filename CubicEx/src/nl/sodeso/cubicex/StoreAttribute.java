package nl.sodeso.cubicex;

import java.util.Map;

import nl.sodeso.cubicex.util.ArgumentUtils;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>StoreAttribute</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreAttribute implements ICustomTestStep {

	/**
	 * {@inheritDoc}
	 */
	public void execute(Map<String, String> arguments, IElementContext context,
			Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _attributeLocator = ArgumentUtils.getTarget(arguments);
		final String _variable = ArgumentUtils.getVariable(arguments);
		
		// Retrieve the value.
		String _value = selenium.getAttribute(_attributeLocator);
		
		// Store the value.
		context.put(_variable, _value);
	}

}
