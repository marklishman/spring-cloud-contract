package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return all users"

	request {
		url "/users"
		method GET()
	}

	response {
		status 200
		headers {
			contentType applicationJson()
		}
		body (
			file("users-test-data.json")
		)
	}
}