package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return all users"

	request {
		url "/users"
		method POST()
        headers {
            contentType applicationJson()
        }
		body (
			"id": 4,
			"name": "Patricia Lebsack",
			"username": "Karianne",
			"email": "Julianne.OConner@kory.org",
			"phone": "493-170-9623 x156",
			"website": "kale.biz"
		)
	}

	response {
		status 201
		headers {
			contentType applicationJson()
		}
		body (
			anyUuid()
		)
	}
}