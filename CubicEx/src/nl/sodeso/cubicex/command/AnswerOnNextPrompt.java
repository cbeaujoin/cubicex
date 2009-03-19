package nl.sodeso.cubicex.command;

import java.util.Map;

import nl.sodeso.cubicex.CubicExBaseTestCase;

import org.cubictest.selenium.custom.IElementContext;

import com.thoughtworks.selenium.Selenium;

/**
 * Replaces the <code>answerOnNextPrompt</code> command of SeleniumIDE
 * 
 * @author r.mathies
 * @version 0.0.2
 */
public class AnswerOnNextPrompt extends CubicExBaseTestCase {

	/**
	 * {@inheritDoc}
	 */
	public void executeTest(final Map<String, String> arguments, final IElementContext context, final Selenium selenium) throws Exception {

		// Retrieve the parameters.
		final String _textToWrite = getValue();
		
		selenium.answerOnNextPrompt(_textToWrite);
	}

}
