package io.lishman;

import io.lishman.controller.UserController;
import io.lishman.model.User;
import io.lishman.service.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public abstract class BaseClass {

	@Autowired
	UserController userController;

	@MockBean
	UserService userService;

	@Before public void setup() {
		RestAssuredMockMvc.standaloneSetup(userController);

		given(userService.getUser(1))
				.willReturn(new User(1L, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "hildegard.org"));

        given(userService.getUsers()).willReturn(Arrays.asList(
                new User(1L, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "hildegard.org"),
                new User(2L, "Ervin Howell", "Antonette", "Shanna@melissa.tv", "010-692-6593 x09125", "anastasia.net"),
                new User(3L, "Clementine Bauch", "Samantha", "Nathan@yesenia.net", "1-463-123-4447", "ramiro.info")));

        given(userService.saveUser(any())).willReturn(UUID.randomUUID().toString());

	}


}
