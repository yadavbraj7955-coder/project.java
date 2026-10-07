# Student Placement Management System

A Java-based Student Placement Management System designed to manage students, companies, placement eligibility, and job applications.

## Features

- Add, display, update and delete students
- Add, display, update and delete companies
- Check student eligibility based on CGPA and skills
- Apply for company placements
- Manage application status
- Store data using MySQL database
- JDBC connectivity
- Uses Java and ArrayList for data handling

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Data Structures
- MySQL
- JDBC
- Git & GitHub

## Project Structure

- `Student.java` – Student information
- `Company.java` – Company information
- `Application.java` – Placement application information
- `DatabaseConnection.java` – MySQL database connection
- `StudentDAO.java` – Student database operations
- `CompanyDAO.java` – Company database operations
- `ApplicationDAO.java` – Application database operations
- `Main.java` – Main application and menu

## Database

The project uses MySQL with three main tables:

- Students
- Companies
- Applications

## How to Run

1. Install Java JDK.
2. Install MySQL.
3. Create the `placement_db` database.
4. Create the required tables.
5. Configure your MySQL username and password in `DatabaseConnection.java`.
6. Add MySQL Connector/J to the project.
7. Compile and run `Main.java`.

## Future Improvements

- Admin login system
- Student login
- Company login
- Placement statistics and reports
- Search and sorting features
- Web-based interface
- Email notifications

## Author

Braj Yadav

B.Tech CSE Student
