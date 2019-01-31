package com.goodrain.springbootdemo.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class ProxyService {
    public String doProxy(String url) throws IOException {
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }
        in.close();

        return result.toString();
    }
}
