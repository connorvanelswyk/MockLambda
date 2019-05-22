package lambda.context;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import lambda.client.MockClientContext;
import lambda.cognito.MockCognitoIdentity;
import lambda.logger.MockLambdaLogger;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * <h1>Represents a Lambda execution environment by implementing the {@link Context} interface.</h1>
 */
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MockContext implements Context {

	ClientContext clientContext;
	CognitoIdentity identity;
	LambdaLogger logger;
	Instant then;

	String invokedFunctionArn,
			functionVersion,
			logStreamName,
			awsRequestId,
			functionName,
			logGroupName;

	int remainingTimeInMillis,
			memoryLimitInMB;

	/**
	 * Creates a new {@link MockContext} object and sets <code>private final</code> fields accordingly.
	 */
	public MockContext() {
		remainingTimeInMillis = Integer.valueOf(System.getenv("TIME_LIMIT_IN_MILLIS"));
		memoryLimitInMB = Integer.valueOf(System.getenv("MEMORY_LIMIT_IN_MB"));
		invokedFunctionArn = System.getenv("INVOKED_FUNCTION_ARN");
		functionVersion = System.getenv("FUNCTION_VERSION");
		logStreamName = System.getenv("LOG_STREAM_NAME");
		awsRequestId = System.getenv("AWS_REQUEST_ID");
		functionName = System.getenv("FUNCTION_NAME");
		logGroupName = System.getenv("LOG_GROUP_NAME");
		then = Instant.now().plus(remainingTimeInMillis, ChronoUnit.MILLIS);
		clientContext = new MockClientContext();
		identity = new MockCognitoIdentity();
		logger = new MockLambdaLogger();
	}

	/**
	 * @return a signed <code>Integer</code> eq to the sum of millis remaining until theoretical system termination.
	 */
	public int getRemainingTimeInMillis() {
		return (int) ChronoUnit.MILLIS.between(Instant.now(), then);
	}

}