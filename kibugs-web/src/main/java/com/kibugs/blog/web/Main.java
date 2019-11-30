package com.kibugs.blog.web;


import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;

/**
 * @author jannik
 * @version v1.0.0
 * @description
 * @date 2019-11-29 23:06
 **/
public class Main {

    public static void main(String[] args) throws IOException {
        String encode = Base64.getEncoder().encodeToString("sk_test_OYCEfL5xgLL+l8ZvK7QaSGGVMN73oNEpk3yz+Rxn/2bS/LCgCQZ+gw==:".getBytes("UTF-8"));
        System.out.println(encode);

        String url = "https://api.instamoney.co/p2p-customers/b9666300-7300-11e9-8373-6753d37f1b1f";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("sk_test_OYCEfL5xgLL+l8ZvK7QaSGGVMN73oNEpk3yz+Rxn/2bS/LCgCQZ+gw==",":");
        params.add(HttpHeaders.AUTHORIZATION, "Basic c2tfdGVzdF9PWUNFZkw1eGdMTCtsOFp2SzdRYVNHR1ZNTjczb05FcGszeXorUnhuLzJiUy9MQ2dDUVorZ3c9PTo=");
        params.add(HttpHeaders.CONTENT_TYPE, "application/json");
        params.add(HttpHeaders.ACCEPT, "*/*");
        params.add(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<>(params);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println("resEntity.getBody() = " + response.getBody());
        System.out.println(exchange.getBody());


//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://api.instamoney.co/p2p-customers/external_id=lender_2348")
//                .get()
//                .addHeader("Authorization", "Basic c2tfdGVzdF9PWUNFZkw1eGdMTCtsOFp2SzdRYVNHR1ZNTjczb05FcGszeXorUnhuLzJiUy9MQ2dDUVorZ3c9PTo=")
////                .addHeader("Accept", "*/*")
////                .addHeader("Cache-Control", "no-cache")
////                .addHeader("Connection", "keep-alive")
////                .addHeader("cache-control", "no-cache")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        byte[] bytes = response.body().bytes();
//        System.out.println(new String(bytes));
    }
}
