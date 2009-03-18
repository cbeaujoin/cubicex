package nl.sodeso.cubicex;

import java.util.Map;

import nl.sodeso.cubicex.util.ArgumentUtils;

import org.cubictest.selenium.custom.ICustomTestStep;
import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Command to fire a URL event.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class FireLinkEvent implements ICustomTestStep {

	public void execute(Map<String, String> arguments, IElementContext context,
			Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _url = ArgumentUtils.getUrl(arguments, context);
		
		selenium.open(_url);
	}

}
