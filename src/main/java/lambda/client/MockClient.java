package lambda.client;

import com.amazonaws.services.lambda.runtime.Client;
import lombok.Data;

@Data
class MockClient implements Client {

	private String installationId;
	private String appTitle;
	private String appVersionName;
	private String appVersionCode;
	private String appPackageName;

}