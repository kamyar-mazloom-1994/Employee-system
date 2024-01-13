import java.text.*;
import java.util.*;

// Employee class to represent employees
class Employee {

  private String employeeId;
  private String firstName;
  private String lastName;
  private String department;
  private String role;

  public Employee(
    String employeeId,
    String firstName,
    String lastName,
    String department,
    String role
  ) {
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.department = department;
    this.role = role;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getDepartment() {
    return department;
  }

  public String getRole() {
    return role;
  }

  public String toString() {
    return (
      "Employee ID: " +
      employeeId +
      ", Name: " +
      firstName +
      " " +
      lastName +
      ", Department: " +
      department +
      ", Role: " +
      role
    );
  }
}

// Project class to represent projects
class Project {

  private String projectId;
  private String projectName;
  private String projectDescription;
  private String startDate;
  private String endDate;

  public Project(
    String projectId,
    String projectName,
    String projectDescription,
    String startDate,
    String endDate
  ) {
    this.projectId = projectId;
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getProjectId() {
    return projectId;
  }

  public String getProjectName() {
    return projectName;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String toString() {
    return (
      "Project ID: " +
      projectId +
      ", Name: " +
      projectName +
      ", Description: " +
      projectDescription +
      ", Start Date: " +
      startDate +
      ", End Date: " +
      endDate
    );
  }
}

public class EmployeeProjectAssignment {

  private Map<String, Employee> employees = new HashMap<>();
  private Map<String, Project> projects = new HashMap<>();
  private Map<String, List<String>> assignments = new HashMap<>();
  private int employeeCounter = 100;
  private int projectCounter = 200;

  // Method to add an employee to the system
  public String addEmployee(
    String firstName,
    String lastName,
    String department,
    String role
  ) {
    String employeeId = "E" + (++employeeCounter);
    Employee employee = new Employee(
      employeeId,
      firstName,
      lastName,
      department,
      role
    );
    employees.put(employeeId, employee);
    return employeeId;
  }

  // Method to add a project to the system
  public String addProject(
    String projectName,
    String projectDescription,
    String startDate,
    String endDate
  ) {
    String projectId = "P" + (++projectCounter);
    Project project = new Project(
      projectId,
      projectName,
      projectDescription,
      startDate,
      endDate
    );
    projects.put(projectId, project);
    return projectId;
  }

  // Method to assign an employee to a project with a specific role
  public void assignEmployeeToProject(
    String employeeId,
    String projectId,
    String role
  ) {
    if (employees.containsKey(employeeId) && projects.containsKey(projectId)) {
      List<String> projectAssignments = assignments.computeIfAbsent(
        projectId,
        k -> new ArrayList<>()
      );
      projectAssignments.add(employeeId + "-" + role);
      System.out.println(
        "Assignment successful: " +
        employees.get(employeeId).getFirstName() +
        " to " +
        projects.get(projectId).getProjectName() +
        " as " +
        role
      );
    } else {
      System.out.println("Error: Invalid Employee ID or Project ID");
    }
  }

  // Method to display a list of all projects along with their assigned team members and roles
  public void displayProjectsAndAssignments() {
    System.out.println("Projects and Their Assignments:");
    for (Map.Entry<String, Project> projectEntry : projects.entrySet()) {
      String projectId = projectEntry.getKey();
      Project project = projectEntry.getValue();
      List<String> projectAssignments = assignments.get(projectId);

      System.out.println("Project Details: " + project);
      if (projectAssignments != null) {
        System.out.println("Assigned Team Members and Roles:");
        for (String assignment : projectAssignments) {
          String[] assignmentParts = assignment.split("-");
          String employeeId = assignmentParts[0];
          String role = assignmentParts[1];
          Employee employee = employees.get(employeeId);
          System.out.println("  - " + employee + ", Role: " + role);
        }
      }
      System.out.println();
    }
  }

  // Method to search and display all employees assigned to a specific project
  public void displayEmployeesForProject(String projectId) {
    if (projects.containsKey(projectId)) {
      List<String> projectAssignments = assignments.get(projectId);
      System.out.println(
        "Employees assigned to Project " +
        projects.get(projectId).getProjectName() +
        ":"
      );
      if (projectAssignments != null) {
        for (String assignment : projectAssignments) {
          String[] assignmentParts = assignment.split("-");
          String employeeId = assignmentParts[0];
          String role = assignmentParts[1];
          Employee employee = employees.get(employeeId);
          System.out.println(employee + ", Role: " + role);
        }
      }
    } else {
      System.out.println("Project not found.");
    }
  }

  // Method to search and display all projects for a particular employee
  public void displayProjectsForEmployee(String employeeId) {
    if (employees.containsKey(employeeId)) {
      Employee employee = employees.get(employeeId);
      System.out.println(
        "Projects assigned to " +
        employee.getFirstName() +
        " " +
        employee.getLastName() +
        ":"
      );
      for (Map.Entry<String, List<String>> entry : assignments.entrySet()) {
        String projectId = entry.getKey();
        List<String> projectAssignments = entry.getValue();
        for (String assignment : projectAssignments) {
          String[] assignmentParts = assignment.split("-");
          String assignedEmployeeId = assignmentParts[0];
          if (assignedEmployeeId.equals(employeeId)) {
            Project project = projects.get(projectId);
            String role = assignmentParts[1];
            System.out.println(project + ", Role: " + role);
          }
        }
      }
    } else {
      System.out.println("Employee not found.");
    }
  }

  // Method to update project details
  public void updateProject(
    String projectId,
    String projectName,
    String projectDescription,
    String startDate,
    String endDate
  ) {
    if (projects.containsKey(projectId)) {
      Project project = projects.get(projectId);
      project.setProjectName(projectName);
      project.setProjectDescription(projectDescription);
      project.setStartDate(startDate);
      project.setEndDate(endDate);
      System.out.println("Project details updated successfully.");
    } else {
      System.out.println("Project not found.");
    }
  }

  // Method to update employee assignment details
  public void updateEmployeeAssignment(
    String employeeId,
    String projectId,
    String newRole
  ) {
    if (employees.containsKey(employeeId) && projects.containsKey(projectId)) {
      List<String> projectAssignments = assignments.get(projectId);
      if (projectAssignments != null) {
        for (int i = 0; i < projectAssignments.size(); i++) {
          String assignment = projectAssignments.get(i);
          String[] assignmentParts = assignment.split("-");
          String assignedEmployeeId = assignmentParts[0];
          if (assignedEmployeeId.equals(employeeId)) {
            projectAssignments.set(i, employeeId + "-" + newRole);
            System.out.println("Employee assignment updated successfully.");
            return;
          }
        }
      }
    } else {
      System.out.println("Employee or project not found.");
    }
  }

  // Method to delete a project along with all its assignments
  public void deleteProject(String projectId) {
    if (projects.containsKey(projectId)) {
      projects.remove(projectId);
      assignments.remove(projectId);
      System.out.println("Project and its assignments deleted successfully.");
    } else {
      System.out.println("Project not found.");
    }
  }

  public static void main(String[] args) {
    EmployeeProjectAssignment assignmentSystem = new EmployeeProjectAssignment();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n-----------------------------");
      System.out.println("Employee Project Assignment");
      System.out.println("-----------------------------");

      System.out.println("Options:");
      System.out.println("1. Add Employee");
      System.out.println("2. Add Project");
      System.out.println("3. Assign Employee to Project");
      System.out.println("4. Display Projects and Assignments");
      System.out.println("5. Display Employees for Project");
      System.out.println("6. Display Projects for Employee");
      System.out.println("7. Update Project Details");
      System.out.println("8. Update Employee Assignment");
      System.out.println("9. Delete Project");
      System.out.println("10. Quit");
      System.out.print("Enter your choice: ");

      try {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
          case 1:
            // Add Employee code
            System.out.println("\nAdding Employee:");
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Role: ");
            String role = scanner.nextLine();
            String employeeId = assignmentSystem.addEmployee(
              firstName,
              lastName,
              department,
              role
            );
            System.out.println(
              "Employee added: " +
              firstName +
              " " +
              lastName +
              " (ID: " +
              employeeId +
              ", Role: " +
              role +
              ", Department: " +
              department
            );
            break;
          case 2:
            // Add Project code
            System.out.println("\nAdding Project:");
            System.out.print("Project name: ");
            String projectName = scanner.nextLine();
            System.out.print("Project description: ");
            String projectDescription = scanner.nextLine();
            String startDate = "";
            String endDate = "";

            // Validate start date format
            while (true) {
              System.out.print("Start date (yyyy-MM-dd): ");
              startDate = scanner.nextLine();
              if (isValidDateFormat(startDate)) {
                break;
              } else {
                System.out.println(
                  "Invalid date format. Please use yyyy-MM-dd format."
                );
              }
            }

            // Validate end date format
            while (true) {
              System.out.print("End date (yyyy-MM-dd): ");
              endDate = scanner.nextLine();
              if (isValidDateFormat(endDate)) {
                break;
              } else {
                System.out.println(
                  "Invalid date format. Please use yyyy-MM-dd format."
                );
              }
            }

            String projectId = assignmentSystem.addProject(
              projectName,
              projectDescription,
              startDate,
              endDate
            );
            System.out.println(
              "Project added: " + projectName + " (ID: " + projectId + ")"
            );
            break;
          case 3:
            // Assign Employee to Project code
            System.out.println("\nAssigning Employee to Project:");
            System.out.print("Employee ID: ");
            String empId = scanner.nextLine();
            System.out.print("Project ID: ");
            String projId = scanner.nextLine();
            System.out.print("Role: ");
            String assignmentRole = scanner.nextLine();
            assignmentSystem.assignEmployeeToProject(
              empId,
              projId,
              assignmentRole
            );
            System.out.println("Assignment successful.");
            break;
          case 4:
            // Display Projects and Assignments code
            System.out.println("\nDisplaying Projects and Assignments:");
            assignmentSystem.displayProjectsAndAssignments();
            break;
          case 5:
            // Display Employees for Project code
            System.out.println("\nDisplaying Employees for Project:");
            System.out.print("Project ID: ");
            String projIdForDisplay = scanner.nextLine();
            assignmentSystem.displayEmployeesForProject(projIdForDisplay);
            break;
          case 6:
            // Display Projects for Employee code
            System.out.println("\nDisplaying Projects for Employee:");
            System.out.print("Employee ID: ");
            String empIdForDisplay = scanner.nextLine();
            assignmentSystem.displayProjectsForEmployee(empIdForDisplay);
            break;
          case 7:
            // Update Project Details code
            System.out.println("\nUpdating Project Details:");
            System.out.print("Project ID: ");
            String projIdForUpdate = scanner.nextLine();
            System.out.print("New project name: ");
            String newProjectName = scanner.nextLine();
            System.out.print("New project description: ");
            String newProjectDescription = scanner.nextLine();
            System.out.print("New start date (yyyy-MM-dd): ");
            String newStartDate = scanner.nextLine();
            System.out.print("New end date (yyyy-MM-dd): ");
            String newEndDate = scanner.nextLine();
            assignmentSystem.updateProject(
              projIdForUpdate,
              newProjectName,
              newProjectDescription,
              newStartDate,
              newEndDate
            );
            System.out.println("Project details updated.");
            break;
          case 8:
            // Update Employee Assignment code
            System.out.println("\nUpdating Employee Assignment:");
            System.out.print("Employee ID: ");
            String empIdForAssignment = scanner.nextLine();
            System.out.print("Project ID: ");
            String projIdForAssignment = scanner.nextLine();
            System.out.print("New role: ");
            String newRoleForAssignment = scanner.nextLine();
            assignmentSystem.updateEmployeeAssignment(
              empIdForAssignment,
              projIdForAssignment,
              newRoleForAssignment
            );
            System.out.println("Assignment updated.");
            break;
          case 9:
            // Delete Project code
            System.out.println("\nDeleting Project:");
            System.out.print("Project ID to delete: ");
            String projIdForDeletion = scanner.nextLine();
            assignmentSystem.deleteProject(projIdForDeletion);
            System.out.println("Project and its assignments deleted.");
            break;
          case 10:
            scanner.close();
            System.exit(0);
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (InputMismatchException e) {
        System.out.println(
          "Invalid input. Please enter a number corresponding to the menu option."
        );
        scanner.nextLine(); // Consume invalid input
      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        scanner.nextLine(); // Consume invalid input
      }
    }
  }

  // Function to validate the date format
  private static boolean isValidDateFormat(String dateStr) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);

    try {
      Date date = dateFormat.parse(dateStr);
      return true;
    } catch (ParseException e) {
      return false;
    }
  }
}
