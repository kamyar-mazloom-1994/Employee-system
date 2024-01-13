# Employee Project Assignment System Pseudocode

## Introduction

This pseudocode describes an Employee Project Assignment system that manages employees, projects, and their assignments. The system offers various functionalities for adding employees and projects, assigning employees to projects, updating project and assignment details, and more.

## Employee Class

### Attributes

- `employeeId` (String): A unique identifier for each employee.
- `firstName` (String): The first name of the employee.
- `lastName` (String): The last name of the employee.
- `department` (String): The department in which the employee works.
- `role` (String): The role or position of the employee.

### Methods

- `Employee(employeeId, firstName, lastName, department, role)`: Constructor to initialize employee attributes.
- `getEmployeeId()`: Returns the employee's unique ID.
- `getFirstName()`: Returns the first name of the employee.
- `getLastName()`: Returns the last name of the employee.
- `getDepartment()`: Returns the employee's department.
- `getRole()`: Returns the employee's role.
- `toString()`: Returns a formatted string representation of the employee.

## Project Class

### Attributes

- `projectId` (String): A unique identifier for each project.
- `projectName` (String): The name of the project.
- `projectDescription` (String): A description of the project.
- `startDate` (String): The project's start date.
- `endDate` (String): The project's end date.

### Methods

- `Project(projectId, projectName, projectDescription, startDate, endDate)`: Constructor to initialize project attributes.
- `getProjectId()`: Returns the project's unique ID.
- `getProjectName()`: Returns the project name.
- `getProjectDescription()`: Returns the project description.
- `getStartDate()`: Returns the project's start date.
- `getEndDate()`: Returns the project's end date.
- `setProjectName(projectName)`: Updates the project name.
- `setProjectDescription(projectDescription)`: Updates the project description.
- `setStartDate(startDate)`: Updates the project's start date.
- `setEndDate(endDate)`: Updates the project's end date.
- `toString()`: Returns a formatted string representation of the project.

## EmployeeProjectAssignment Class

### Attributes

- `employees` (Map): Stores employees with their unique IDs as keys.
- `projects` (Map): Stores projects with their unique IDs as keys.
- `assignments` (Map): Tracks assignments of employees to projects.
- `employeeCounter` (int): Used to generate unique employee IDs.
- `projectCounter` (int): Used to generate unique project IDs.

### Methods

- `addEmployee(firstName, lastName, department, role)`: Adds an employee to the system and returns their unique ID.
- `addProject(projectName, projectDescription, startDate, endDate)`: Adds a project to the system and returns its unique ID.
- `assignEmployeeToProject(employeeId, projectId, role)`: Assigns an employee to a project with a specific role.
- `displayProjectsAndAssignments()`: Displays all projects and their assigned team members with roles.
- `displayEmployeesForProject(projectId)`: Displays employees assigned to a specific project.
- `displayProjectsForEmployee(employeeId)`: Displays projects assigned to a specific employee.
- `updateProject(projectId, projectName, projectDescription, startDate, endDate)`: Updates project details.
- `updateEmployeeAssignment(employeeId, projectId, newRole)`: Updates employee assignment details.
- `deleteProject(projectId)`: Deletes a project and its assignments.
- `main(args)`: The main program that provides a menu for interacting with the system, including adding employees, projects, assigning employees to projects, updating project and assignment details, and more.

## Example Usage

Below is an example pseudocode snippet for using the system:

```markdown
employeeProjectAssignment = new EmployeeProjectAssignment()
while true:
displayMenu()
choice = readInt()
switch choice:
case 1:
firstName = readString("Enter first name: ")
lastName = readString("Enter last name: ")
department = readString("Enter department: ")
role = readString("Enter role: ")
employeeId = employeeProjectAssignment.addEmployee(firstName, lastName, department, role)
print("Employee added. Employee ID: " + employeeId)
case 2:
projectName = readString("Enter project name: ")
projectDescription = readString("Enter project description: ")
startDate = readString("Enter start date: ")
endDate = readString("Enter end date: ")
projectId = employeeProjectAssignment.addProject(projectName, projectDescription, startDate, endDate)
print("Project added. Project ID: " + projectId)
case 3:
employeeId = readString("Enter employee ID: ")
projectId = readString("Enter project ID: ")
role = readString("Enter role: ")
employeeProjectAssignment.assignEmployeeToProject(employeeId, projectId, role)
case 4:
employeeProjectAssignment.displayProjectsAndAssignments()
case 5:
projectId = readString("Enter project ID: ")
employeeProjectAssignment.displayEmployeesForProject(projectId)
case 6:
employeeId = readString("Enter employee ID: ")
employeeProjectAssignment.displayProjectsForEmployee(employeeId)
case 7:
projectId = readString("Enter project ID: ")
newProjectName = readString("Enter new project name: ")
newProjectDescription = readString("Enter new project description: ")
newStartDate = readString("Enter new start date: ")
newEndDate = readString("Enter new end date: ")
employeeProjectAssignment.updateProject(projectId, newProjectName, newProjectDescription, newStartDate, newEndDate)
case 8:
employeeId = readString("Enter employee ID: ")
projectId = readString("Enter project ID: ")
newRole = readString("Enter new role: ")
employeeProjectAssignment.updateEmployeeAssignment(employeeId, projectId, newRole)
case 9:
projectId = readString("Enter project ID to delete: ")
employeeProjectAssignment.deleteProject(projectId)
case 10:
exitProgram()
default:
print("Invalid choice. Please try again.")
```
