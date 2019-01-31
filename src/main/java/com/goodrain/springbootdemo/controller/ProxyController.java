package com.goodrain.springbootdemo.controller;

import com.goodrain.springbootdemo.service.ProxyService;
import com.goodrain.springbootdemo.vo.ProxyReqVO;
import com.goodrain.springbootdemo.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/proxy")
public class ProxyController {
    @Autowired
    public ProxyService proxyService;

    @RequestMapping(value = "/do", method = RequestMethod.POST, produces = "application/json")
    public RestResponse<String> proxyGet(@Valid @RequestBody ProxyReqVO proxyReqVO) throws IOException {
        String data = proxyService.doProxy(proxyReqVO.getUrl());
        RestResponse<String> resp = new RestResponse<>(0, "2001", "ok", data);
        return resp;
    }
}
