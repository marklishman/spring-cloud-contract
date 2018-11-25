package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return user with id equal to 1"

	request {
		url "/users/1"
		method GET()
	}

	response {
		status 200
		headers {
			contentType applicationJson()
		}
		body (
			"userId": 1,
			"name": "Leanne Graham",
			"username": "Bret",
			"email": "Sincere@april.biz",
			"phone": "1-770-736-8031 x56442",
			"website": "hildegard.org"
		)
	}
}