package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Happy path tests of the methods as a service.
 *
 * @author erick.rodriguez@globant.com
 * @since 30/Ago/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoCitiExerciseSolveApplicationTests {

    private final MockMvc mockMvc;

    @Autowired
    public DemoCitiExerciseSolveApplicationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void testHappyPathGetHeadersOfRequest() throws Exception {
        mockMvc.perform(
                get("/getHeadersOfRequest")
                        .header("x-test-header", "hello")
                        .header("x-test-header", "world")
                        .header("x-another-test-header", Arrays.asList("john", "doe")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x-test-header").value(Matchers.containsInAnyOrder("hello", "world")))
                .andExpect(jsonPath("$.x-another-test-header").value(Matchers.containsInAnyOrder("john", "doe")));
    }

    @Test
    void testHappyPathGetHeadersOfRequestFiltered() throws Exception {
        mockMvc.perform(
                get("/getHeadersOfRequestFiltered")
                        .param("headersName", "x-test-header, x-another-test-header")
                        .header("x-test-header", "hello")
                        .header("x-test-header", "world")
                        .header("x-another-test-header", Arrays.asList("john", "doe"))
                        .header("x-complementary-header", "complementary-value")
                        .header("x-another-complementary-header", "another-complementary-value"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x-test-header").value(Matchers.containsInAnyOrder("hello", "world")))
                .andExpect(jsonPath("$.x-another-test-header").value(Matchers.containsInAnyOrder("john", "doe")));
    }

}
