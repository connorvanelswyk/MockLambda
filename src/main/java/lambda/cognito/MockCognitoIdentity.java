package lambda.cognito;

import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MockCognitoIdentity implements CognitoIdentity {

	String identityId, identityPoolId;

}