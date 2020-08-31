package com.example.demo.utilities;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class of utility with the solution.
 *
 * @author erick.rodriguez@globant.com
 * @since 30/Ago/2020
 */
public class RequestHeadersUtility {

    /**
     * Class constructor.
     */
    private RequestHeadersUtility() {
        // This is an empty constructor to avoid instances.
    }

    /**
     * Get all the headers mapping the name with the list of headers values.
     *
     * @param request Request which want to get the headers.
     * @return Map with all headers and its values.
     */
    public static Map<String, List<String>> getHeadersOfRequest(HttpServletRequest request) {
        return Collections.list(request.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        header -> Collections.list(request.getHeaders(header))
                ));
    }

    /**
     * Get all the headers filtered by a list names mapping the name with the list of headers values.
     *
     * @param request     Request which want to get the headers.
     * @param headersName Name of headers want to get of the request.
     * @return Map with all headers and its values filtered by list.
     */
    public static Map<String, List<String>> getHeadersOfRequest(HttpServletRequest request, List<String> headersName) {
        return Collections.list(request.getHeaderNames())
                .stream()
                .filter(headersName::contains)
                .collect(Collectors.toMap(
                        Function.identity(),
                        header -> Collections.list(request.getHeaders(header))
                ));
    }

}
