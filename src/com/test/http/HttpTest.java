package com.test.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {
   
    public static void main(String[] args) {
        String targetURL = "http://127.0.0.1/jdbctest_memberRegistry";
        String parameters = "userid=RHCP&username=국명자&age=73";
        TestHttpRequest.testHttpRequest(targetURL, parameters);
    }

}

class TestHttpRequest {
    
    public static void testHttpRequest(String targetURL, String parameters) {
        
        HttpURLConnection connection = null;

        try{
            //connection 생성
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            
            // key-value 형태로 Request의 Header 작성
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //html form 형태, 데이터 주고 받는 형식
            connection.setRequestProperty("Content-Language", "ko-KR"); // locale 표기법
            connection.setUseCaches(false); // 캐쉬 생성 금지

            //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션을 정의
            connection.setDoOutput(true);

            // Request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream()); // 위에서 set한 output get으로 가져옴
            wr.write(parameters.getBytes("utf-8"));
            wr.flush();
            wr.close();

            // Response
            int responseCode = connection.getResponseCode(); // 404 등 상태 코드 받아옴
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            StringBuilder response = new StringBuilder();
            String line;
            while((line = rd.readLine()) != null) {
                response.append(line).toString();
                response.append("\r\n");
            }
            rd.close();

            System.out.println("HTTP 응답 코드 : " + responseCode);
            System.out.println("HTTP 응답 헤더 : " + connection.getHeaderFields());
            System.out.println("HTTP body : " + response.toString());

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }
}
