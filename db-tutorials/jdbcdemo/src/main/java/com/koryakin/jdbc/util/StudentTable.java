package com.koryakin.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTable {

    private Connection con;
    private String dbms;
    private String dbName;


    public StudentTable(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void viewTable(Connection con) throws SQLException {
        Statement stmt = null;
        String query = "select STUD_NAME, STUD_ID from Student";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String studentName = rs.getString("STUD_NAME");
                int studentID = rs.getInt("STUD_ID");
                System.out.println(studentName + "  " + studentID);
            }

        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }

    public void createTable() throws SQLException {
        String createString =
                "create table Student " + "(STUD_NAME varchar(32) NOT NULL, " +
                        "STUD_ID INT NOT NULL AUTO_INCREMENT, "+
                        " PRIMARY KEY(STUD_ID))";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }

    public void populateTable() throws SQLException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("insert into Student(STUD_NAME)"+
                    "VALUES('John')", Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate("insert into Student(STUD_NAME)" +
                    "values('Jack')", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
    public void dropTable() throws SQLException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS Student");
        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
