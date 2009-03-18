package nl.sodeso.cubicex;

import java.util.Map;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Command to fire a URL event.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class FireLinkEvent extends CubicExBaseTestCase {

	public void execute(Map<String, String> arguments, IElementContext context,
			Selenium selenium) throws Exception {
		// Retrieve the parameters.
		final String _url = getUrl();
		
		selenium.open(_url);
	}

}
