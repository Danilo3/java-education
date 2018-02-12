package com.koryakin.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDemoMain {
    public static void main(String[] args) {

        JDBCTutorialUtilities myJDBCTutorialUtilities;
        String propertiesFileName = "/home/dan/IdeaProjects/java-education/db-tutorials/jdbcdemo/src/main/resources/mysql-sample-properties.xml";
        try{
            myJDBCTutorialUtilities = new JDBCTutorialUtilities(propertiesFileName);
        }catch(IOException exception){
            System.out.println("Fail to read file");
            exception.printStackTrace();
            return;
        }
        Connection myConnection = null;
        try {
            myConnection = myJDBCTutorialUtilities.getConnectionToDatabase();
            JDBCTutorialUtilities.initializeTables(myConnection, myJDBCTutorialUtilities.dbName, myJDBCTutorialUtilities.dbms);


        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            JDBCTutorialUtilities.closeConnection(myConnection);
        }
    }


}

