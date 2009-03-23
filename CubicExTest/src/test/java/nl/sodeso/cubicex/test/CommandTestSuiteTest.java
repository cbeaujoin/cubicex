/**
 *  Copyright 2009 Sodeso 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package nl.sodeso.cubicex.test;

import junit.framework.TestCase;

import org.cubictest.exporters.selenium.SeleniumRunner;

/**
 * Base JUnit class for running all tests.
 * 
 * @author r.mathies
 * @version 0.0.3
 */
public class CommandTestSuiteTest extends TestCase {

	public void test() {
		SeleniumRunner runner = new SeleniumRunner();
		runner.runTests("/tests");
				
		//alternatively, run single tests, e.g: 
		//runner.runTest("/tests/myTest.aat");
	}
}

