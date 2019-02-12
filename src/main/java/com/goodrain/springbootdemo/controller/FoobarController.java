package com.goodrain.springbootdemo.controller;

import com.goodrain.springbootdemo.service.FoobarService;
import com.goodrain.springbootdemo.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoobarController {
    @Autowired
    private FoobarService foobarService;

    @GetMapping("/list-env")
    public RestResponse<List<String>> listEnv() {
        List<String> envs = foobarService.listEnv();
        RestResponse<List<String>> res = new RestResponse<>();
        res.setSuccess(0);
        res.setCode("3000");
        res.setMsg("");
        res.setData(envs);
        return res;
    }
}
