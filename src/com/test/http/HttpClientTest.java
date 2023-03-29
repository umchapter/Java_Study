package com.test.http;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;

import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.Map;

public class HttpClientTest {
    
    public static void main(String[] args) throws Exception {
        
        String address = "http://127.0.0.1/jdbctest_memberRegistry";
        String address_get = "http://127.0.0.1/jdbctest_oracle.jsp";

        Map<String, String> params = new HashMap<>();
        params.put("userid", "DarkNecessity");
        params.put("username", "김갑생");
        params.put("age", "79");

        String[] headers = {"content-type", "application/x-www-form-urlencoded"};
        String[] headers_get = {"content-type", "text/html"};

        HttpClientRun.post(address, params, headers);
        HttpClientRun.get(address_get, headers_get);
    }
}

class HttpClientRun {

    // Get
    public static void get(String address_get, String[] headers_get) throws Exception {

        HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();
        String result = client.sendAsync(
                                        HttpRequest.newBuilder(new URI(address_get))
                                                                        .GET()
                                                                        .headers(headers_get).build(),
                                        HttpResponse.BodyHandlers.ofString()                                
                                        ).thenApply(HttpResponse::body).get();
        System.out.println(result);
    }

      // Post
    public static void post(String address, Map<String, String> params, String[] headers) throws Exception {

        BodyPublisher body = BodyPublishers.ofString(getFormDataAsString(params));
        HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();

        HttpResponse<String> response = client.send(
                                                    HttpRequest.newBuilder(new URI(address))
                                                                                    .POST(body)
                                                                                    .headers(headers).build(),
                                                    HttpResponse.BodyHandlers.ofString()
                                                    ); // Response 상태 코드만 받아옴.
        System.out.println(response);
    }

    // Map으로 받은 값을 String으로 변환해주는 메소드
    public static String getFormDataAsString(Map<String, String> formData) {

        StringBuilder formBodyBuilder = new StringBuilder();
        // 맵의 종류와 무관하게 작동 가능
        for(Map.Entry<String, String> singleEntry : formData.entrySet()) {

            if(formBodyBuilder.length() > 0) {
                formBodyBuilder.append("&");
            }
            formBodyBuilder.append(URLEncoder.encode(singleEntry.getKey(), StandardCharsets.UTF_8));
            formBodyBuilder.append("=");
            formBodyBuilder.append(URLEncoder.encode(singleEntry.getValue(), StandardCharsets.UTF_8));
        }
        return formBodyBuilder.toString();
        
        
    }
}