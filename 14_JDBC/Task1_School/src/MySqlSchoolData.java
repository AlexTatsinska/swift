
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class MySqlSchoolData {

    /*
     insertTeacher
 getTeacher (by ID) ready
 getTeachers (with salary between X and Y) ready
 insertStudent ready
 getStudent (by ID) ready
 getStudents (with enrollmentDate after date X) rady
 getDisciplinesByTeacherId (by teacher ID, retrieves all disciplines he/she is teaching)
 getTeachersByDisciplineName (by discipline name, retrieves all teachers that are teaching it)
    
     */
    public static StringBuilder getTeacher(int id) throws SQLException {
        StringBuilder result = new StringBuilder();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "SwiftTraining1");
                PreparedStatement statement = conn.prepareStatement(
                        "SELECT tch.name, "
                        + "tch.email, "
                        + "tch.salary "
                        + "FROM "
                        + "school.teachers tch "
                        + "where tch.id = ?;")) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    result.append(String.format("Name: %s - email: %s, salary: %.2f.%n", rs.getString("tch.name"),
                            rs.getString("tch.email"), rs.getDouble("tch.salary")));
                }
            }
        } catch (SQLException ex) {

            while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return result;
    }

    public static StringBuilder getTeachers(double salary1, double salary2) throws SQLException {
        StringBuilder result = new StringBuilder();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "SwiftTraining1");
                PreparedStatement statement = conn.prepareStatement(
                        "SELECT \n"
                        + "distinct\n"
                        + "tch.name, \n"
                        + "tch.email, \n"
                        + "tch.salary \n"
                        + "FROM \n"
                        + "school.teachers tch \n"
                        + "where \n"
                        + "tch.salary >= ? \n"
                        + "and tch.salary<=?;")) {
            statement.setDouble(1, salary1);
            statement.setDouble(2, salary2);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    result = result.append(String.format("Name: %s - email: %s, salary: %.2f.%n", rs.getString("tch.name"),
                            rs.getString("tch.email"), rs.getDouble("tch.salary")));
                }
            }
        } catch (SQLException ex) {

            while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return result;
    }

    public static void insertStudent(String name, String date) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "SwiftTraining1");
                PreparedStatement statement = conn.prepareStatement("INSERT INTO `school`.`students` (`name`, `enrollment_date`) VALUES (?, ?);")) {
            statement.setString(1, name);
            statement.setString(2, date);
            statement.execute();
        }
    }

    public static StringBuilder getStudent(int id) throws SQLException {
        StringBuilder result = new StringBuilder();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "SwiftTraining1");
                PreparedStatement statement = conn.prepareStatement(
                        "select\n"
                        + "st.name,\n"
                        + "st.enrollment_date\n"
                        + "from \n"
                        + "school.students st\n"
                        + "where\n"
                        + "st.id =  ?;")) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    result = result.append(String.format("Name: %s - enrollment_date: %s.%n", rs.getString("st.name"),
                            rs.getString("st.enrollment_date")));
                }
            }
        } catch (SQLException ex) {

            while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return result;
    }

    public static StringBuilder getStudents(String minDate, String maxDate) throws SQLException {
        StringBuilder result = new StringBuilder();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "SwiftTraining1");
                PreparedStatement statement = conn.prepareStatement(
                        "select\n"
                        + "st.name,\n"
                        + "st.enrollment_date\n"
                        + "from \n"
                        + "school.students st\n"
                        + "where\n"
                        + "st.enrollment_date >= ?\n"
                        + "and st.enrollment_date <= ?")) {
            statement.setString(1, minDate);
            statement.setString(2, maxDate);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    result = result.append(String.format("Name: %s - enrollment_date: %s.%n", rs.getString("st.name"),
                            rs.getString("st.enrollment_date")));
                }
            }
        } catch (SQLException ex) {

            while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return result;
    }

}
