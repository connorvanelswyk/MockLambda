package lambda;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import lambda.client.MockClientContext;
import lambda.cognito.MockCognitoIdentity;
import lambda.logger.MockLambdaLogger;
import lombok.Data;

@Data
public class MockLambda implements Context {

	private String awsRequestId;
	private String logGroupName;
	private String logStreamName;
	private String functionName;
	private String functionVersion;
	private String invokedFunctionArn;
	private int remainingTimeInMillis = 15 * 1000;
	private int memoryLimitInMB = 512;

	private CognitoIdentity identity = new MockCognitoIdentity();
	private ClientContext clientContext = new MockClientContext();
	private LambdaLogger logger = new MockLambdaLogger();

}