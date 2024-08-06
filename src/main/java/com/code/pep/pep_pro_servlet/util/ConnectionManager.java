package com.code.pep.pep_pro_servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Утилитный класс - для установки соединения с базой.
public final class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USR_KEY = "db.usr";
    private static final String PAS_KEY = "db.pas";
    private static final String DRV_KEY = "db.drv";

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
//            Class.forName("org.postgresql.Driver");
            Class.forName(PropertiesUtil.get(DRV_KEY));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionManager() {
    }

    public static Connection get() {
        try {
//            Блок для проверки:
//            System.out.println("URL_KEY = " + URL_KEY);
//            System.out.println("USR_KEY = " + USR_KEY);
//            System.out.println("PAS_KEY = " + PAS_KEY);
//            System.out.println("DDB_KEY = " + DRV_KEY);
//            System.out.println("PropertiesUtil.get(URL_KEY) = " + PropertiesUtil.get(URL_KEY));
//            System.out.println("PropertiesUtil.get(USR_KEY) = " + PropertiesUtil.get(USR_KEY));
//            System.out.println("PropertiesUtil.get(PAS_KEY) = " + PropertiesUtil.get(PAS_KEY));
//            System.out.println("PropertiesUtil.get(DDB_KEY) = " + PropertiesUtil.get(DRV_KEY));
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USR_KEY),
                    PropertiesUtil.get(PAS_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
