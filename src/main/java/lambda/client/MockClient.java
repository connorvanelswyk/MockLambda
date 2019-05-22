package lambda.client;

import com.amazonaws.services.lambda.runtime.Client;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
class MockClient implements Client {

	String appPackageName, installationId, appVersionName, appVersionCode, appTitle;

}