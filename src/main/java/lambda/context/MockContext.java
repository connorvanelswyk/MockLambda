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
import lombok.experimental.NonFinal;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MockContext implements Context {

	ClientContext clientContext;
	CognitoIdentity identity;
	LambdaLogger logger;
	Instant then;

	@NonFinal
	String invokedFunctionArn,
			functionVersion,
			logStreamName,
			awsRequestId,
			functionName,
			logGroupName;

	@NonFinal
	Integer remainingTimeInMillis,
			memoryLimitInMB;

	public MockContext() {
		remainingTimeInMillis = Integer.valueOf(System.getenv("TIME_LIMIT_IN_MILLIS"));
		memoryLimitInMB = Integer.valueOf(System.getenv("MEMORY_LIMIT_IN_MB"));
		then = Instant.now().plus(remainingTimeInMillis, ChronoUnit.MILLIS);
		clientContext = new MockClientContext();
		identity = new MockCognitoIdentity();
		logger = new MockLambdaLogger();
	}

	public int getRemainingTimeInMillis() {
		return (int) ChronoUnit.MILLIS.between(Instant.now(), then);
	}

}