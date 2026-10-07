import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {

    // Add Student
    public static void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                     "(id, name, branch, cgpa, skills) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.id);
            ps.setString(2, student.name);
            ps.setString(3, student.branch);
            ps.setDouble(4, student.cgpa);
            ps.setString(5, student.skills);

            ps.executeUpdate();

            System.out.println("Student saved in database.");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    // Get All Students
    public static ArrayList<Student> getAllStudents() {

        ArrayList<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String branch = rs.getString("branch");
                double cgpa = rs.getDouble("cgpa");
                String skills = rs.getString("skills");

                Student student =
                    new Student(id, name, branch, cgpa, skills);

                students.add(student);
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        return students;
    }


    // Update Student
    public static void updateStudent(Student student) {

        String sql = "UPDATE students SET " +
                     "name=?, branch=?, cgpa=?, skills=? " +
                     "WHERE id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.name);
            ps.setString(2, student.branch);
            ps.setDouble(3, student.cgpa);
            ps.setString(4, student.skills);
            ps.setInt(5, student.id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    // Delete Student
    public static void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}