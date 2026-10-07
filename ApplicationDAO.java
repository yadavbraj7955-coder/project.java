import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ApplicationDAO {

    // Add Application
    public static void addApplication(Application application) {

        String sql = "INSERT INTO applications " +
                     "(student_id, company_id, status) " +
                     "VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, application.studentId);
            ps.setInt(2, application.companyId);
            ps.setString(3, application.status);

            ps.executeUpdate();

            System.out.println("Application saved in database.");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    // Get All Applications
    public static ArrayList<Application> getAllApplications() {

        ArrayList<Application> applications = new ArrayList<>();

        String sql = "SELECT * FROM applications";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int studentId = rs.getInt("student_id");
                int companyId = rs.getInt("company_id");
                String status = rs.getString("status");

                Application application =
                    new Application(studentId, companyId);

                application.status = status;

                applications.add(application);
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        return applications;
    }


    // Update Application Status
    public static void updateStatus(
            int studentId,
            int companyId,
            String status) {

        String sql = "UPDATE applications SET status=? " +
                     "WHERE student_id=? AND company_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, studentId);
            ps.setInt(3, companyId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Application status updated.");
            } else {
                System.out.println("Application not found.");
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}