public class Application {

    int studentId;
    int companyId;
    String status;

    Application(int studentId, int companyId) {

        this.studentId = studentId;
        this.companyId = companyId;
        this.status = "Applied";
    }

    void display() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Company ID: " + companyId);
        System.out.println("Status: " + status);

        System.out.println("--------------------");
    }
}