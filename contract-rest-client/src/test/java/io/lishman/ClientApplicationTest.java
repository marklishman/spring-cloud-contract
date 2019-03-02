package io.lishman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
        ids = {"com.example:contract-rest-service:+:stubs:8100"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class ClientApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void get_users() throws Exception {
        mvc.perform(get("/get-data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Leanne Graham"))
                .andExpect(jsonPath("$[1].name").value("Ervin Howell"))
                .andExpect(jsonPath("$[2].name").value("Clementine Bauch"))
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void get_user() throws Exception {
        mvc.perform(get("/get-data/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("1"))
                .andExpect(jsonPath("$.name").value("Leanne Graham"))
                .andExpect(jsonPath("$.username").value("Bret"))
                .andExpect(jsonPath("$.email").value("Sincere@april.biz"))
                .andExpect(jsonPath("$.phone").value("1-770-736-8031 x56442"))
                .andExpect(jsonPath("$.website").value("hildegard.org"));
    }

}
