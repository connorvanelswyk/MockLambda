package lambda.logger;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * Concrete class implementation for {@link LambdaLogger}.
 * Would love to systematically incorporate Log4j2 or the link moving forward.
 */
public class MockLambdaLogger implements LambdaLogger {

	public void log(String s) {
		System.out.println(s);
	}

	public void log(byte[] bytes) {
		log(new String(bytes));
	}
}