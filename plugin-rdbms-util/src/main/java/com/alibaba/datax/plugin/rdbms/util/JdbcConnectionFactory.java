package com.alibaba.datax.plugin.rdbms.util;

import java.sql.Connection;

/**
 * Date: 15/3/16 下午3:12
 */
public class JdbcConnectionFactory implements ConnectionFactory {

    private DataBaseType dataBaseType;

    private String jdbcUrl;

    private String jdbcJarUrl;

    private String driverName;

    private String userName;

    private String password;

//    public JdbcConnectionFactory(DataBaseType dataBaseType, String jdbcUrl, String userName, String password) {
//        this.dataBaseType = dataBaseType;
//        this.jdbcUrl = jdbcUrl;
//        this.userName = userName;
//        this.password = password;
//    }

    public JdbcConnectionFactory(DataBaseType dataBaseType, String jdbcUrl, String driverName, String jdbcJarUrl, String userName, String password) {
        this.dataBaseType = dataBaseType;
        this.jdbcUrl = jdbcUrl;
        this.driverName = driverName;
        this.jdbcJarUrl = jdbcJarUrl;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Connection getConnecttion() {
        return DBUtil.getConnection(dataBaseType, jdbcUrl, driverName, jdbcJarUrl, userName, password);
    }

    @Override
    public Connection getConnecttionWithoutRetry() {
        return DBUtil.getConnectionWithoutRetry(dataBaseType, jdbcUrl, driverName, jdbcJarUrl, userName, password);
    }

    @Override
    public String getConnectionInfo() {
        return "jdbcUrl:" + jdbcUrl;
    }
}
