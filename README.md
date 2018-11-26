
# Run Standalone

    java -jar stub-runner.jar --server.port=8101 --stubrunner.stubsMode=LOCAL --stubrunner.ids=com.example:contract-rest-service:0.0.1-SNAPSHOT:stubs:8100

# Using a @Rule

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
		.downloadStub("com.example", "contract-rest-service", "0.0.1-SNAPSHOT", "stubs")
		.withPort(8100)
		.stubsMode(StubRunnerProperties.StubsMode.LOCAL);