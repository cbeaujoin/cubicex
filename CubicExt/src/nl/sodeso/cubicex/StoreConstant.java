package nl.sodeso.cubicex;

import java.util.Map;

import nl.sodeso.cubicex.util.ArgumentUtils;
import nl.sodeso.cubicex.util.VariableUtils;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Store a value as a variable.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class StoreConstant implements ICustomTestStep {

	public void execute(Map<String, String> arguments, IElementContext context,
			Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _variable = ArgumentUtils.getVariable(arguments);
		final String _textToStore = ArgumentUtils.getValue(arguments, context);
		
		VariableUtils.setStringVariable(context, _variable, _textToStore);
	}

}
