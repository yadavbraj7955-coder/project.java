public class Company {

    int companyId;
    String companyName;
    double requiredCgpa;
    String requiredSkills;

    Company(int companyId, String companyName,
            double requiredCgpa, String requiredSkills) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.requiredCgpa = requiredCgpa;
        this.requiredSkills = requiredSkills;
    }

    void display() {

        System.out.println("Company ID: " + companyId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Required CGPA: " + requiredCgpa);
        System.out.println("Required Skills: " + requiredSkills);

        System.out.println("--------------------");
    }
}