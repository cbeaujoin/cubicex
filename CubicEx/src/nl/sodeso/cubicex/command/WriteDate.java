package nl.sodeso.cubicex.command;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Writes a formatted date to the specified locator.
 * 
 * @author r.mathies
 * @version 0.0.1
 */
public class WriteDate extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _locator = getArgTarget();
		final String _format = getArgFormat();
		final Integer _deviation = getArgDeviation();
		
		// Process the deviation
		Calendar calendar = Calendar.getInstance();
		calendar.roll(Calendar.DAY_OF_YEAR, _deviation);
		
		// Create the formatted date.
		final String _formattedDate = new SimpleDateFormat(_format).format(calendar.getTime());
		
		selenium.type(_locator, _formattedDate);
	}

}
