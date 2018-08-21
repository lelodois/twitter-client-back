package br.com.lelodois;

import br.com.lelo.twclient.controller.SearchController;
import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.domain.Tweet;
import br.com.lelo.twclient.service.search.SearchCommandService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
public class SearchRestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private SearchController controller;

    @Mock
    private SearchCommandService command;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    public void whenSearchIsCorrect() throws Exception {
        Search search = new Search("#partiu");
        search.setId(1L);
        search.getTweets().add(new Tweet(1L, "Vamos todos #partiu"));
        search.getTweets().add(new Tweet(1L, "Vou agora #partiu"));
        when(command.newSearch(search.getHashtag())).thenReturn(search);

        JSONObject json = new JSONObject();
        json.put("hashtag", search.getHashtag());

        mockMvc.perform(post("/v1/api/search/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString()))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.hashtag").value("#partiu"))
                .andExpect(jsonPath("$.creationDate").isNotEmpty())
                .andExpect(jsonPath("$.tweets").isArray())
                .andExpect(jsonPath("$.tweets[0].id").isNotEmpty())
                .andExpect(jsonPath("$.tweets[0].text").isNotEmpty())
                .andExpect(jsonPath("$.tweets[1].id").isNotEmpty())
                .andExpect(jsonPath("$.tweets[1].text").isNotEmpty());
    }

    @Test
    public void whenSearchIsNull() throws Exception {
        JSONObject json = new JSONObject();

        mockMvc.perform(post("/v1/api/search/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenSearchIsNotFound() throws Exception {
        JSONObject json = new JSONObject();

        mockMvc.perform(post("/v1/api/search2/")
                .content(json.toString()))
                .andExpect(status().isNotFound());
    }
}
