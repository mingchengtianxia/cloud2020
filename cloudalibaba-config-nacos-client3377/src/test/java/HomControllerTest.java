import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.web.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomControllerTest {

    @Test
    public void testHome() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}
