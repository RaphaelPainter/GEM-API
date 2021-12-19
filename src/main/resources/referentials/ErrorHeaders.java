package main.resources.referentials;

import org.springframework.http.HttpHeaders;

public class ErrorHeaders {
    public static HttpHeaders getErrorHeader( String value){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("GEM_API_ERROR", value);
        return responseHeaders;
    }

    public static HttpHeaders Auth = getErrorHeader("Invalid Auth");
    public static HttpHeaders Role = getErrorHeader("a higher Role is needed");
}
