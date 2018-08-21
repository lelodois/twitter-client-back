package br.com.lelodois;

import br.com.lelo.twclient.controller.TopController;
import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.TopType;
import br.com.lelo.twclient.service.top.TopQueryService;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
public class TopRestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TopController controller;

    @Mock
    private TopQueryService queryService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    public void whenTopHourEmpty() throws Exception {
        when(queryService.findByType(TopType.HOURS))
                .thenReturn(Lists.newArrayList());

        mockMvc.perform(get("/v1/api/top/hours"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0]").doesNotExist());
    }

    @Test
    public void whenTopHourReturnContainsResult() throws Exception {
        when(queryService.findByType(TopType.HOURS))
                .thenReturn(Lists.newArrayList(
                        new Top(1L, "Teste"),
                        new Top(2L, "Teste2")));

        mockMvc.perform(get("/v1/api/top/hours"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0].size").value("1"))
                .andExpect(jsonPath("$.[0].name").value("Teste"))
                .andExpect(jsonPath("$.[1].size").value("2"))
                .andExpect(jsonPath("$.[1].name").value("Teste2"));
    }


    @Test
    public void whenTopCountryEmpty() throws Exception {
        when(queryService.findByType(TopType.COUNTRY))
                .thenReturn(Lists.newArrayList());

        mockMvc.perform(get("/v1/api/top/country"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0]").doesNotExist());
    }

    @Test
    public void whenTopCountryReturnContainsResult() throws Exception {
        when(queryService.findByType(TopType.COUNTRY))
                .thenReturn(Lists.newArrayList(
                        new Top(1L, "Teste"),
                        new Top(2L, "Teste2")));

        mockMvc.perform(get("/v1/api/top/country"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0].size").value("1"))
                .andExpect(jsonPath("$.[0].name").value("Teste"))
                .andExpect(jsonPath("$.[1].size").value("2"))
                .andExpect(jsonPath("$.[1].name").value("Teste2"));
    }


    @Test
    public void whenTopFollowersEmpty() throws Exception {
        when(queryService.findByType(TopType.FOLLOWERS))
                .thenReturn(Lists.newArrayList());

        mockMvc.perform(get("/v1/api/top/followers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0]").doesNotExist());
    }

    @Test
    public void whenTopFollowersReturnContainsResult() throws Exception {
        when(queryService.findByType(TopType.FOLLOWERS))
                .thenReturn(Lists.newArrayList(
                        new Top(1L, "Teste"),
                        new Top(2L, "Teste2")));

        mockMvc.perform(get("/v1/api/top/followers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0].size").value("1"))
                .andExpect(jsonPath("$.[0].name").value("Teste"))
                .andExpect(jsonPath("$.[1].size").value("2"))
                .andExpect(jsonPath("$.[1].name").value("Teste2"));
    }

}