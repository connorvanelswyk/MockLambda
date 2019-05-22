package lambda.logger;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * Concrete class implementation for {@link LambdaLogger}.
 * Would love to systematically incorporate Log4j2 or the link moving forward.
 */
public class MockLambdaLogger implements LambdaLogger {

	/**
	 * Prints a String and then terminates the line by invoking {@see System.out.println(s)}.
	 *
	 * @param s <code>String</code>message to log
	 */
	public void log(String s) {
		System.out.println(s);
	}

	/**
	 * Prints an array of characters and then terminates the line by constructing a {@link String}
	 * and passing it to {@link #log(String)}.
	 * @param bytes <code>byte[]</code>message to log
	 */
	public void log(byte[] bytes) {
		log(new String(bytes));
	}
}