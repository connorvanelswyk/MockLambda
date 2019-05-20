package lambda.logger;

import com.amazonaws.services.lambda.runtime.LambdaLogger;


public class MockLambdaLogger implements LambdaLogger {

	public void log(String s) {
		System.out.println(s);
	}

	public void log(byte[] bytes) {
		log(new String(bytes));
	}
}