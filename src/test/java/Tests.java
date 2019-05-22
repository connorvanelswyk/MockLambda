import lambda.context.MockContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Straight forward class materializing a suite of proofs to assert that our tests are correct and cover 100% of src.
 * <br/>
 * And coveralls.
 * <br/>
 * <p>Only unit tests are required to confirm that expected results meet actual results while covering every LOC.</p>
 * <p>The main requirements for this project are:
 * <ol>
 *     <li>simulate an environment identical to AWS Lambda by implementing available runtime interfaces</li>
 *     <li>create a test environment that is extendable and obvious to test AWS Lambda without an account</li>
 *     <li>provide a means to configure resources and build patterns for rapid CICD</li>
 * </ol>
 * </p>
 * <p>Each method signature is written in a "Given-When-Then" format to model
 * <a href="https://en.wikipedia.org/wiki/Behavior-driven_development">Behavior Driven Development</a>
 * and extend Test Driven Development.</p>
 * <p>Take the following for an example:
 * <b>Given</b> the integer i,
 * <b>when</b> i plus 2 equals 5,
 * <b>then</b> i equals 3 (..is true).</p>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tests {

	MockContext mockContext;

	@Before
	public void before() {
		mockContext = new MockContext();
	}

	/**
	 * Confirm that a default implementation will not throw an NPE.
	 * Default values are environment variables written into the pom.xml.
	 */
	@Test
	public void defaultMockContext_everyMethodVal_returnNotNull() {
		assertNotNull(mockContext.getInvokedFunctionArn());
		assertNotNull(mockContext.getFunctionVersion());
		assertNotNull(mockContext.getLogStreamName());
		assertNotNull(mockContext.getAwsRequestId());
		assertNotNull(mockContext.getFunctionName());
		assertNotNull(mockContext.getLogGroupName());
		assertNotNull(mockContext.getClientContext());
		assertNotNull(mockContext.getClientContext().getClient());
		assertNotNull(mockContext.getClientContext().getClient().getInstallationId());
		assertNotNull(mockContext.getClientContext().getClient().getAppTitle());
		assertNotNull(mockContext.getClientContext().getClient().getAppVersionName());
		assertNotNull(mockContext.getClientContext().getClient().getAppVersionCode());
		assertNotNull(mockContext.getClientContext().getClient().getAppPackageName());
		assertNotNull(mockContext.getClientContext().getCustom());
		assertNotNull(mockContext.getClientContext().getEnvironment());
		assertNotNull(mockContext.getIdentity());
		assertNotNull(mockContext.getIdentity().getIdentityId());
		assertNotNull(mockContext.getIdentity().getIdentityPoolId());
		assertNotNull(mockContext.getLogger());
		assertNotNull(mockContext.getThen());
	}

	/**
	 * Test that a 5 second time allowance throws an exception 1 nanosecond after the limit.
	 */
	@Test
	public void defaultMockContext_timeLimitExceeded_throwTimeLimitException() {

	}

	/**
	 * Test that a 2 minute allowance facilitates a 90 second transaction within nanosecond precision.
	 */
	@Test
	public void defaultMockContext_timeLimitSubceeded_returnRemainingTimeInMillis() {

	}

	/**
	 * You can complain about memory or you can complain about price but you can't do both at the same time.
	 * Memory is what costs money.
	 */
	@Test
	public void defaultMockContext_memoryLimitExceeded_throwMemoryLimitException() {

	}

}