package lambda.client;

import com.amazonaws.services.lambda.runtime.Client;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class MockClient implements Client {

	String appPackageName, installationId, appVersionName, appVersionCode, appTitle;

	public MockClient() {
		appPackageName = System.getenv("CLIENT_APP_PACKAGE_NAME");
		installationId = System.getenv("CLIENT_INSTALLATION_ID");
		appVersionName = System.getenv("CLIENT_APP_VERSION_NAME");
		appVersionCode = System.getenv("CLIENT_APP_VERSION_CODE");
		appTitle = System.getenv("CLIENT_APP_TITLE");
	}

}