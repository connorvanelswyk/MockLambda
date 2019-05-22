package lambda.cognito;

import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MockCognitoIdentity implements CognitoIdentity {

	String identityId, identityPoolId;

	public MockCognitoIdentity() {
		identityPoolId = System.getenv("COGNITO_IDENTITY_POOL_ID");
		identityId = System.getenv("COGNITO_IDENTITY_ID");
	}

}