package com.example.demo;


import com.example.demo.utilities.RequestHeadersUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Happy path tests of the methods.
 *
 * @author erick.rodriguez@globant.com
 * @since 30/Ago/2020
 */
class DemoCitiExerciseSolveMethodTests {

    MockHttpServletRequest mockRequest;

    Map<String, List<String>> mapExpected;

    @BeforeEach
    public void setUp() {
        mockRequest = new MockHttpServletRequest();
        mockRequest.addHeader("x-test-header", "hello");
        mockRequest.addHeader("x-test-header", "world");
        mockRequest.addHeader("x-another-test-header", Arrays.asList("john", "doe"));
        mapExpected = new HashMap<>();
        mapExpected.put("x-test-header", Arrays.asList("hello, world"));
        mapExpected.put("x-another-test-header", Arrays.asList("john", "doe"));
    }


    @Test
    void testHappyPathGetHeadersOfRequest() {
        Assertions.assertEquals(
                mapExpected.toString(),
                RequestHeadersUtility.getHeadersOfRequest(mockRequest).toString(),
                "Headers obtaining failed because content of the maps are not equals");
    }

    @Test
    void testHappyPathGetHeadersOfRequestFiltered() {
        mockRequest.addHeader("x-complementary-header", "complementary-value");
        mockRequest.addHeader("x-another-complementary-header", "another-complementary-value");
        Assertions.assertEquals(
                mapExpected.toString(),
                RequestHeadersUtility.getHeadersOfRequest(mockRequest, Arrays.asList("x-test-header", "x-another-test-header")).toString(),
                "Filtered failed because content of the maps are not equals");
    }

}
