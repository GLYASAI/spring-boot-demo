package com.goodrain.springbootdemo.controller;

import com.goodrain.springbootdemo.service.DBInfoService;
import com.goodrain.springbootdemo.util.DBConnPool;
import com.goodrain.springbootdemo.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("/db")
public class DBController {

    @Autowired
    public DBInfoService dbInfoService;

    @GetMapping("is-connected")
    @CrossOrigin(origins = "*")
    public RestResponse<Boolean> isConnected() throws SQLException {
        DBConnPool dcp = DBConnPool.getInstance();
        Connection conn = dcp.getConnection();

        RestResponse<Boolean> resp = new RestResponse<>();
        resp.setCode("1001");
        resp.setSuccess(0);
        resp.setMsg("ok");
        resp.setData(!conn.isClosed());

        return resp;
    }

    @GetMapping("list-tables")
    @CrossOrigin(origins = "*")
    public RestResponse<List<String>> listTables() throws SQLException {
        List<String> list = dbInfoService.listTables();

        RestResponse<List<String>> resp = new RestResponse<>(0, "1002", "ok", list);

        return resp;
    }
}
