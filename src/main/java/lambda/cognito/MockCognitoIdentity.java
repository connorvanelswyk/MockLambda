package lambda.cognito;

import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import lombok.Data;

@Data
public class MockCognitoIdentity implements CognitoIdentity {

	private String identityId;
	private String identityPoolId;

}