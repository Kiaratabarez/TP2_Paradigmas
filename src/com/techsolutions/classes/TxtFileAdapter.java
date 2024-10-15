package classes;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import people.Employee;
import people.EmployeeFactory;

public class TxtFileAdapter {

    private String filePath;

    public TxtFileAdapter(String filePath) {
        this.filePath = filePath;
    }

    public Company readCompanyData() {
        Company company = Company.getInstance();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Empresa:")) {
                    // Set company name
                    String companyName = line.substring(line.indexOf(":") + 1).trim();
                    company.setName(companyName);
                } else if (line.startsWith("Proyecto:")) {
                    // Add project to company
                    String projectName = line.substring(line.indexOf(":") + 1).trim();
                    company.createProject(projectName);
                } else if (line.startsWith("Empleado:")) {
                    // Add employee to the project
                    String[] employeeData = line.substring(line.indexOf(":") + 1).trim().split(", ");
                    String name = employeeData[0];
                    String dni = employeeData[1];
                    String phone = employeeData[2];
                    String email = employeeData[3];
                    String role = employeeData[4];

                    Employee employee = EmployeeFactory.createEmployee(name, dni, phone, email, role);
                    // Asignar el empleado al proyecto (en este ejemplo, al primer proyecto)
                    company.getProjectByID(1).addEmployee(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return company;
    }
}