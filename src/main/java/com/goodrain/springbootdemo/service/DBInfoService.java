package com.goodrain.springbootdemo.service;

import com.goodrain.springbootdemo.dao.DBInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DBInfoService {
    @Autowired
    public DBInfoDao dbInfoDao;

    public List<String> listTables() throws SQLException {
        return dbInfoDao.listTables(System.getenv("MYSQL_DATABASE"));
    }
}
