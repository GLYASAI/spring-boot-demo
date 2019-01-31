package com.goodrain.springbootdemo.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;


public class DBConnPoolTest {
    @Test
    public void TestGetConnection() throws FileNotFoundException, SQLException {
        DBConnPool dcp = DBConnPool.getInstance();
        Connection conn = dcp.getConnection();
        Assert.assertTrue("error connecting to mysql", !conn.isClosed());
    }
}
