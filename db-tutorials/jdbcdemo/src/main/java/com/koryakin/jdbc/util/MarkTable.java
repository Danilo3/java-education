package com.koryakin.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MarkTable {
    private Connection con;
    private String dbms;
    private String dbName;


    public MarkTable(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void viewTable(Connection con) throws SQLException {
        Statement stmt = null;
        String query = "select MARK, STUD_ID, SUB_ID from Mark";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int mark = rs.getInt("MARK");
                int studentID = rs.getInt("STUD_ID");
                int subjectID =  rs.getInt("SUB_ID");
                System.out.println("studentID: "+ studentID+ " SubjectID:  " + subjectID+" Mark: "+ mark);
            }

        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }

    public void createTable() throws SQLException {
        String createString =
                "create table Mark " + "(MARK int NOT NULL, " +
                        "STUD_ID INT NOT NULL, "+
                        "SUB_ID INT NOT NULL"+
                        "FOREIGN KEY (SUB_ID) REFERENCES Subjects (SUB_ID)"+
                        "FOREIGN KEY (STUD_ID) REFERENCES Students (STUD_ID))";
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
            stmt.executeUpdate("insert into  " +
                    "values('John')");
            stmt.executeUpdate("insert into Students " +
                    "values('Jack')");
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
            stmt.executeUpdate("DROP TABLE IF EXISTS Students");
        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
