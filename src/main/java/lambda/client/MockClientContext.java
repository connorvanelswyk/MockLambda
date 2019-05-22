package lambda.client;

import com.amazonaws.services.lambda.runtime.Client;
import com.amazonaws.services.lambda.runtime.ClientContext;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.Map;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MockClientContext implements ClientContext {

	Client client;

	@NonFinal
	Map<String, String>
			custom,
			environment;

	public MockClientContext() {
		client = new MockClient();
	}

}