import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Student> students;
    static ArrayList<Company> companies;
    static ArrayList<Application> applications;

    public static void main(String[] args) {

        students = StudentDAO.getAllStudents();
        companies = CompanyDAO.getAllCompanies();
        applications = ApplicationDAO.getAllApplications();

        int choice;

        do {
            System.out.println("\n===== STUDENT PLACEMENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add Company");
            System.out.println("6. Display Companies");
            System.out.println("7. Update Company");
            System.out.println("8. Delete Company");
            System.out.println("9. Check Eligibility");
            System.out.println("10. Apply for Company");
            System.out.println("11. Display Applications");
            System.out.println("12. Update Application Status");
            System.out.println("13. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    addCompany();
                    break;

                case 6:
                    displayCompanies();
                    break;

                case 7:
                    updateCompany();
                    break;

                case 8:
                    deleteCompany();
                    break;

                case 9:
                    checkEligibility();
                    break;

                case 10:
                    applyForCompany();
                    break;

                case 11:
                    displayApplications();
                    break;

                case 12:
                    updateApplicationStatus();
                    break;

                case 13:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 13);

        sc.close();
    }

    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Skills: ");
        String skills = sc.nextLine();

        Student student =
                new Student(id, name, branch, cgpa, skills);

        StudentDAO.addStudent(student);
        students.add(student);
    }

    static void displayStudents() {

        students = StudentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.display();
        }
    }

    static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter New CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter New Skills: ");
        String skills = sc.nextLine();

        Student student =
                new Student(id, name, branch, cgpa, skills);

        StudentDAO.updateStudent(student);
        students = StudentDAO.getAllStudents();
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        StudentDAO.deleteStudent(id);
        students = StudentDAO.getAllStudents();
    }

    static void addCompany() {

        System.out.print("Enter Company ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Company Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Required CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Required Skills: ");
        String skills = sc.nextLine();

        Company company =
                new Company(id, name, cgpa, skills);

        CompanyDAO.addCompany(company);
        companies.add(company);
    }

    static void displayCompanies() {

        companies = CompanyDAO.getAllCompanies();

        if (companies.isEmpty()) {
            System.out.println("No companies found.");
            return;
        }

        for (Company company : companies) {
            company.display();
        }
    }

    static void updateCompany() {

        System.out.print("Enter Company ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Company Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Required CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter New Required Skills: ");
        String skills = sc.nextLine();

        Company company =
                new Company(id, name, cgpa, skills);

        CompanyDAO.updateCompany(company);
        companies = CompanyDAO.getAllCompanies();
    }

    static void deleteCompany() {

        System.out.print("Enter Company ID: ");
        int id = sc.nextInt();

        CompanyDAO.deleteCompany(id);
        companies = CompanyDAO.getAllCompanies();
    }

    static void checkEligibility() {

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Enter Company ID: ");
        int companyId = sc.nextInt();

        Student student = null;
        Company company = null;

        for (Student s : students) {
            if (s.id == studentId) {
                student = s;
                break;
            }
        }

        for (Company c : companies) {
            if (c.companyId == companyId) {
                company = c;
                break;
            }
        }

        if (student == null || company == null) {
            System.out.println("Student or Company not found.");
            return;
        }

        if (student.cgpa < company.requiredCgpa) {
            System.out.println("Student is not eligible.");
            return;
        }

        String[] studentSkills = student.skills.split(",");
        String[] requiredSkills = company.requiredSkills.split(",");

        boolean skillsMatch = true;

        for (String required : requiredSkills) {

            boolean found = false;

            for (String skill : studentSkills) {

                if (skill.trim().equalsIgnoreCase(required.trim())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                skillsMatch = false;
                break;
            }
        }

        if (skillsMatch) {
            System.out.println("Student is eligible.");
        } else {
            System.out.println("Student is not eligible.");
        }
    }

    static void applyForCompany() {

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Enter Company ID: ");
        int companyId = sc.nextInt();

        Student student = null;
        Company company = null;

        for (Student s : students) {
            if (s.id == studentId) {
                student = s;
                break;
            }
        }

        for (Company c : companies) {
            if (c.companyId == companyId) {
                company = c;
                break;
            }
        }

        if (student == null || company == null) {
            System.out.println("Student or Company not found.");
            return;
        }

        if (student.cgpa < company.requiredCgpa) {
            System.out.println("Student is not eligible.");
            return;
        }

        Application application =
                new Application(studentId, companyId);

        ApplicationDAO.addApplication(application);

        applications = ApplicationDAO.getAllApplications();
    }

    static void displayApplications() {

        applications = ApplicationDAO.getAllApplications();

        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (Application application : applications) {
            application.display();
        }
    }

    static void updateApplicationStatus() {

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Enter Company ID: ");
        int companyId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Status: ");
        String status = sc.nextLine();

        ApplicationDAO.updateStatus(
                studentId,
                companyId,
                status
        );

        applications = ApplicationDAO.getAllApplications();
    }
}