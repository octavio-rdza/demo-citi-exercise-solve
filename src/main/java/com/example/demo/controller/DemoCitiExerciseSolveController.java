package com.example.demo.controller;

import com.example.demo.utilities.RequestHeadersUtility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Simple controller to test the method as a service.
 *
 * @author erick.rodriguez@globant.com
 * @since 30/Ago/2020
 */
@RestController
public class DemoCitiExerciseSolveController {

    /**
     * Endpoint to get all the headers mapping the name with the list of headers values.
     *
     * @param request Request which want to get the headers.
     * @return Map with all headers and its values.
     */
    @GetMapping(path = "/getHeadersOfRequest")
    public Map<String, List<String>> getHeadersOfRequest(HttpServletRequest request) {
        return RequestHeadersUtility.getHeadersOfRequest(request);
    }

    /**
     * Endpoint to get all the headers filtered by a list names mapping the name with the list of headers values.
     * <p>
     * For the lost of names need to add in the request param.
     * <blockquote>
     * For example:
     * <pre>{@code ?headersName=name1,name2,name3}</pre>
     * </blockquote>
     *
     * @param request     Request which want to get the headers.
     * @param headersName Name of headers want to get of the request.
     * @return Map with all headers and its values filtered by list.
     */
    @GetMapping(path = "/getHeadersOfRequestFiltered")
    public Map<String, List<String>> getHeadersOfRequestFiltered(HttpServletRequest request,
                                                                 @RequestParam List<String> headersName) {
        return RequestHeadersUtility.getHeadersOfRequest(request, headersName);
    }

}
