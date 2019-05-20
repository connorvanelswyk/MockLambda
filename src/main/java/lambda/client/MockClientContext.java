package lambda.client;

import com.amazonaws.services.lambda.runtime.Client;
import com.amazonaws.services.lambda.runtime.ClientContext;
import lombok.Data;

import java.util.Map;

@Data
public class MockClientContext implements ClientContext {

	private Client client = new MockClient();
	private Map<String, String> custom;
	private Map<String, String> environment;

}