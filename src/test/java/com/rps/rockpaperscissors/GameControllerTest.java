package com.rps.rockpaperscissors;

import com.rps.rockpaperscissors.bean.GameReport;
import com.rps.rockpaperscissors.bean.GameResult;
import com.rps.rockpaperscissors.utils.GameUtils;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GameController.class)
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameResultsRepository gameResultsRepository;

    @MockBean
    private GameUtils gameUtils;


    String exampleResponse = "{\"memberId\": 1900100030, \"programId\": \"PL\"}";
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }
    @Test
    @DisplayName("Test Game controller")
    public void testGameController() throws Exception {
        GameReport gameReport = new GameReport();
        GameResult gameResult = new GameResult();
        gameResult.setGameId(1);
        gameReport.setGameResult(gameResult);

        Mockito.when(gameUtils.generateResult(Mockito.any(String.class))).thenReturn(gameResult);

        mockMvc.perform(get("/rps/user/R")
                .with(user("user"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        MvcResult result =
                mockMvc.perform(get("/rps/user/R")
                        .with(user("user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

    }
    @Test
    @DisplayName("Invalid Shape")
    public void testGameControllerInvalidShape() throws Exception {
        MvcResult result =
                mockMvc.perform(get("/rps/user/X")
                        .with(user("user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound())
                        .andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }
    @Test
    @DisplayName("Invalid Shape")
    public void testGameControllerInvalidUrl() throws Exception {
        MvcResult result =
                mockMvc.perform(get("/rps/user")
                        .with(user("user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound())
                        .andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }
}
