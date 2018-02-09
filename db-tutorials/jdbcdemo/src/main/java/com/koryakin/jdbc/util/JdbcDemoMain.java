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
            //      JDBCTutorialUtilities.outputClientInfoProperties(myConnection);
            // myConnection = myJDBCTutorialUtilities.getConnection("root", "root", "jdbc:mysql://localhost:3306/");
            //       myConnection = myJDBCTutorialUtilities.
            //         getConnectionWithDataSource(myJDBCTutorialUtilities.dbName,"derby","", "", "localhost", 3306);


        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            JDBCTutorialUtilities.closeConnection(myConnection);
        }

    }

}

