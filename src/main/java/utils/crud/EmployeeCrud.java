package utils.crud;

import entities.EmployeeEntity;
import queries.EmployeeQuery;
import utils.loggers.EmployeeLogger;

import java.util.List;

public class EmployeeCrud {
    EmployeeQuery employeeQuery = new EmployeeQuery();
    List<EmployeeEntity> employeeEntityList;
    EmployeeEntity employeeEntity;

    public void getAllEmployees() {
        employeeEntityList = employeeQuery.getAllEmployees();

        if (employeeEntityList.size() != 0) {
            employeeEntityList.forEach(employee -> {
                printEmployeeInfo(employee);
                System.out.println();
            });
        } else {
            EmployeeLogger.logger.info("No employees were found");
        }
    }

    public EmployeeEntity getEmployeeById(int id) {
        employeeEntity = employeeQuery.getEmployeeById(id);

        if (employeeEntity != null) {
            printEmployeeInfo(employeeEntity);
            return employeeEntity;
        } else {
            EmployeeLogger.logger.info(String.format("The employee with id %s wasn't found", id));
            return null;
        }
    }

    public List<EmployeeEntity> getEmployeesByLastName(String lastName) {
        employeeEntityList = employeeQuery.getEmployeeByLastName(lastName);
        if (employeeEntityList.size() != 0) {
            employeeEntityList.forEach(employee -> {
                printEmployeeInfo(employee);
                System.out.println();
            });
        } else {
            EmployeeLogger.logger.info(String.format("The employee with name %s was not found", lastName));
        }
        return employeeEntityList;
    }

    public int insertNewEmployee(int id, String firstName, String lastName, String email, String phoneNumber, String address, double salary, String birthDate, int fkCompany, int fkInstitution) {

        employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setFirstName(firstName);
        employeeEntity.setLastName(lastName);
        employeeEntity.setEmail(email);
        employeeEntity.setPhoneNumber(phoneNumber);
        employeeEntity.setAddress(address);
        employeeEntity.setSalary(salary);
        employeeEntity.setBirthDate(birthDate);
        employeeEntity.setFkCompany(fkCompany);
        employeeEntity.setFkInstitution(fkInstitution);

        int employeeId = employeeQuery.insertEmployee(employeeEntity);
        if (employeeId != -1) {
            EmployeeLogger.logger.info(String.format("A new employee with id %s was created", employeeId));
            return employeeId;
        } else {
            EmployeeLogger.logger.info("No employee was created");
            return -1;
        }
    }

    public void updateEmployee(int id, String firstName, String lastName, String email, String phoneNumber, String address, double salary, String birthDate, int fkCompany, int fkInstitution) {
        int employeeId = employeeQuery.updateEmployee(id, firstName, lastName, email, phoneNumber, address, salary, birthDate, fkCompany, fkInstitution);
        if (employeeId != -1) {
            EmployeeLogger.logger.info(String.format("The employee with id %s was updated", id));
        } else {
            EmployeeLogger.logger.info("No employee was updated");
        }
    }

    public void deleteEmployee(int id) {
        int employeeId = employeeQuery.deleteEmployee(id);
        if (employeeId != -1) {
            EmployeeLogger.logger.info(String.format("The employee with id %s was deleted", employeeId));
        } else {
            EmployeeLogger.logger.info("No employee was deleted");
        }
    }

    public void printEmployeeInfo(EmployeeEntity employee) {
        System.out.printf("Employee Id: %s", employee.getId());
        System.out.printf("Employee first name: %s", employee.getFirstName());
        System.out.printf("Employee last name: %s", employee.getLastName());
        System.out.printf("Employee email: %s", employee.getEmail());
        System.out.printf("Employee phone number: %s", employee.getPhoneNumber());
        System.out.printf("Employee address: %s", employee.getAddress());
        System.out.printf("Employee salary: %s", employee.getSalary());
        System.out.printf("Employee birth date: %s", employee.getBirthDate());
        System.out.printf("Employee fk company: %s", employee.getFkCompany());
        System.out.printf("Employee fk institution: %s", employee.getFkInstitution());
    }
}
