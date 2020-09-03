package individualproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final String DB_URL = "localhost:3306";
    private static final String FULL_DB_URL = "jdbc:mysql://" + DB_URL + "/individual_project?zeroDateTimeBehavior=convertToNull";
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "qweqwe123";
    private static Connection connection = null;
    private static Statement statement = null;

    public static ResultSet getResults(String query) {
        try {
            setStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Statement getStatement() {
        return statement;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void setStatement() {
        try {
            getConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printStudentResults(ResultSet rs) {
        try {
            System.out.println("List of Students");
            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getString(1)
                        + ", Name: " + rs.getString(2) + " " + rs.getString(3)
                        + ", Date of Birth: " + rs.getString(4)
                        + ", Tuition Fees: " + rs.getString(5));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printCourseResults(ResultSet rs) {
        try {
            System.out.println("List of Courses");
            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getString(1)
                        + ", Title: " + rs.getString(2)
                        + ", Stream: " + rs.getString(3)
                        + ", Type: " + rs.getString(4)
                        + ", Start Date: " + rs.getString(5)
                        + ", End Date: " + rs.getString(6));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printTrainerResults(ResultSet rs) {
        try {
            System.out.println("List of Trainers");
            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getString(1)
                        + ", Name: " + rs.getString(2) + " " + rs.getString(3)
                        + ", Subject: " + rs.getString(4));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAssignmentResults(ResultSet rs) {
        try {
            System.out.println("List of Assignments");
            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getString(1)
                        + ", Title: " + rs.getString(2)
                        + ", Description: " + rs.getString(3)
                        + ", Sub Date: " + rs.getString(4)
                        + ", Oral Mark: " + rs.getString(5)
                        + ", Total Mark: " + rs.getString(6));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printStudentsPerCourseResults(ResultSet rs) {
        try {
            System.out.println("List of Students per Course");
            while (rs.next()) {
                System.out.println(
                        "Name: " + rs.getString(1)
                        + ", Course: " + rs.getString(2));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printTrainersPerCourseResults(ResultSet rs) {
        try {
            System.out.println("List of Trainers per Course");
            while (rs.next()) {
                System.out.println(
                        "Name: " + rs.getString(1)
                        + ", Course: " + rs.getString(2));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAssignmentsPerCourseResults(ResultSet rs) {
        try {
            System.out.println("List of Assignments per Course");
            while (rs.next()) {
                System.out.println(
                        "Assignment: " + rs.getString(1)
                        + ", Course: " + rs.getString(2));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAssignmentsPerCoursePerStudentResults(ResultSet rs) {
        try {
            System.out.println("List of Assignments per Course per Student");
            while (rs.next()) {
                System.out.println(
                        "Name: " + rs.getString(1)
                        + ", Course: " + rs.getString(2)
                        + ", Assignment: " + rs.getString(3));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printStudentsWithMultipleCoursesResults(ResultSet rs) {
        try {
            System.out.println("List of Students with Multiple Courses");
            while (rs.next()) {
                System.out.println(
                        "Name: " + rs.getString(1)
                        + ", Courses: " + rs.getString(2));
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertRecordToStudents(String first_name, String last_name, LocalDate date_of_birth, int tuition) {
        String data = "'" + first_name + "','" + last_name + "','" + date_of_birth + "','" + tuition + "'";
        String sql = "INSERT INTO students (first_name, last_name, date_of_birth, tuition_fees) VALUES (" + data + ");";
        setStatement();
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertRecordToCourses(String title, String stream, String type, LocalDate start_date, LocalDate end_date) {
        String data = "'" + title + "','" + stream + "','" + type + "','" + start_date + "','" + end_date + "'";
        String sql = "INSERT INTO courses (title, stream, type, start_date, end_date) VALUES (" + data + ");";
        setStatement();
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertRecordToTrainers(String first_name, String last_name, String subject) {
        String data = "'" + first_name + "','" + last_name + "','" + subject + "'";
        String sql = "INSERT INTO trainers (first_name, last_name, subject) VALUES (" + data + ");";
        setStatement();
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertRecordToAssignments(String title, String description, LocalDate sub_date, int oral_mark, int total_mark) {
        String data = "'" + title + "','" + description + "','" + sub_date + "','" + oral_mark + "','" + total_mark + "'";
        String sql = "INSERT INTO assignments (title, description, sub_date, oral_mark, total_mark) VALUES (" + data + ");";
        setStatement();
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertRecordStudentToCourse(int sid, int cid) {
        String data = "'" + sid + "','" + cid + "'";
        String sql = "INSERT IGNORE INTO students_in_course (sid, cid) VALUES (" + data + ");";
        setStatement();
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertRecordTrainerToCourse(int tid, int cid) {
        String data = "'" + tid + "','" + cid + "'";
        String sql = "INSERT IGNORE INTO trainers_in_course (tid, cid) VALUES (" + data + ");";
        setStatement();
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertRecordAssignmentToCourse(int aid, int cid) {
        String data = "'" + aid + "','" + cid + "'";
        String sql = "INSERT IGNORE INTO assignments_in_course (aid, cid) VALUES (" + data + ");";
        setStatement();
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getQueries() {
        ResultSet rs = getResults("SELECT * FROM students");
        printStudentResults(rs);
        rs = getResults("SELECT * FROM courses");
        printCourseResults(rs);
        rs = getResults("SELECT * FROM trainers");
        printTrainerResults(rs);
        rs = getResults("SELECT * FROM assignments");
        printAssignmentResults(rs);
        rs = getResults("SELECT concat(students.first_name,' ',students.last_name) , courses.title FROM students, courses, students_in_course \n"
                + "WHERE students.id=students_in_course.sid AND courses.id=students_in_course.cid ORDER BY courses.title;");
        printStudentsPerCourseResults(rs);
        rs = getResults("SELECT concat (trainers.first_name,' ',trainers.last_name), courses.title FROM trainers, courses, trainers_in_course\n"
                + "WHERE trainers.id=trainers_in_course.tid AND courses.id=trainers_in_course.cid ORDER BY courses.title;");
        printTrainersPerCourseResults(rs);
        rs = getResults("SELECT concat (assignments.title,' ',assignments.description),  courses.title FROM assignments, courses, assignments_in_course\n"
                + "WHERE assignments.id=assignments_in_course.aid AND courses.id=assignments_in_course.cid ORDER BY courses.title;");
        printAssignmentsPerCourseResults(rs);
        rs = getResults("SELECT concat(students.first_name,' ',students.last_name) AS Name, courses.title AS Course, concat (assignments.title,' ',assignments.description) AS Assignment  \n"
                + "FROM students \n"
                + "JOIN students_in_course ON students.id=students_in_course.sid\n"
                + "JOIN courses ON students_in_course.cid=courses.id\n"
                + "JOIN assignments_in_course ON courses.id=assignments_in_course.cid\n"
                + "JOIN assignments ON assignments_in_course.aid=assignments.id\n"
                + "ORDER BY students.id;");
        printAssignmentsPerCoursePerStudentResults(rs);
        rs = getResults("SELECT concat(students.first_name,' ',students.last_name), COUNT(students_in_course.sid) FROM students, students_in_course\n"
                + "WHERE students.id=students_in_course.sid GROUP BY students_in_course.sid HAVING COUNT(students_in_course.sid) >1; ");
        printStudentsWithMultipleCoursesResults(rs);
    }
}
