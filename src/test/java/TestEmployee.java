import data.EmployeeData;
import entities.EmployeeEntity;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.crud.EmployeeCrud;
import utils.loggers.EmployeeLogger;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestEmployee {
    private final EmployeeCrud employeeCrud = new EmployeeCrud();

    @Test
    @Description("Get all employees")
    public void getAllEmployees() {
        EmployeeLogger.logger.info("Test: Get all employees");
        employeeCrud.getAllEmployees();
    }

    @Test
    @Description("Get employees by last name")
    public void getEmployeeByLastName() {
        EmployeeLogger.logger.info("Test: Get employees by last name");
        List<EmployeeEntity> employeesByLastName = employeeCrud.getEmployeesByLastName(EmployeeData.EMPLOYEE_BY_LAST_NAME);
        if (employeesByLastName.size() != 0) {
            employeesByLastName.forEach(employee -> assertThat(employee.getLastName().toLowerCase(), equalTo(EmployeeData.EMPLOYEE_BY_LAST_NAME.toLowerCase())));
        } else {
            System.out.printf("The employee with name %s was not found%n", EmployeeData.EMPLOYEE_BY_LAST_NAME);
        }
    }

    @Test
    @Description("Insert new employee")
    public void insertNewEmployee() {
        EmployeeLogger.logger.info("Test: Insert new employee");
        int employeeId = employeeCrud.insertNewEmployee(
                EmployeeData.NEW_EMPLOYEE.getId(),
                EmployeeData.NEW_EMPLOYEE.getFirstName(),
                EmployeeData.NEW_EMPLOYEE.getLastName(),
                EmployeeData.NEW_EMPLOYEE.getEmail(),
                EmployeeData.NEW_EMPLOYEE.getPhoneNumber(),
                EmployeeData.NEW_EMPLOYEE.getAddress(),
                EmployeeData.NEW_EMPLOYEE.getSalary(),
                EmployeeData.NEW_EMPLOYEE.getBirthDate(),
                EmployeeData.NEW_EMPLOYEE.getFkCompany(),
                EmployeeData.NEW_EMPLOYEE.getFkInstitution());

        EmployeeEntity newEmployee = employeeCrud.getEmployeeById(employeeId);

        assertThat(newEmployee.getId(), equalTo(EmployeeData.NEW_EMPLOYEE.getId()));
        assertThat(newEmployee.getFirstName(), equalTo(EmployeeData.NEW_EMPLOYEE.getFirstName()));
        assertThat(newEmployee.getLastName(), equalTo(EmployeeData.NEW_EMPLOYEE.getLastName()));
        assertThat(newEmployee.getEmail(), equalTo(EmployeeData.NEW_EMPLOYEE.getEmail()));
        assertThat(newEmployee.getPhoneNumber(), equalTo(EmployeeData.NEW_EMPLOYEE.getPhoneNumber()));
        assertThat(newEmployee.getAddress(), equalTo(EmployeeData.NEW_EMPLOYEE.getAddress()));
        assertThat(newEmployee.getSalary(), equalTo(EmployeeData.NEW_EMPLOYEE.getSalary()));
        assertThat(newEmployee.getBirthDate(), equalTo(EmployeeData.NEW_EMPLOYEE.getBirthDate()));
        assertThat(newEmployee.getFkCompany(), equalTo(EmployeeData.NEW_EMPLOYEE.getFkCompany()));
        assertThat(newEmployee.getFkInstitution(), equalTo(EmployeeData.NEW_EMPLOYEE.getFkInstitution()));

        employeeCrud.deleteEmployee(newEmployee.getId());
    }

    @Test
    @Description("Update employee")
    public void updateEmployee() {
        EmployeeLogger.logger.info("Test: Update employee");
        int employeeId = employeeCrud.insertNewEmployee(
                EmployeeData.NEW_EMPLOYEE.getId(),
                EmployeeData.NEW_EMPLOYEE.getFirstName(),
                EmployeeData.NEW_EMPLOYEE.getLastName(),
                EmployeeData.NEW_EMPLOYEE.getEmail(),
                EmployeeData.NEW_EMPLOYEE.getPhoneNumber(),
                EmployeeData.NEW_EMPLOYEE.getAddress(),
                EmployeeData.NEW_EMPLOYEE.getSalary(),
                EmployeeData.NEW_EMPLOYEE.getBirthDate(),
                EmployeeData.NEW_EMPLOYEE.getFkCompany(),
                EmployeeData.NEW_EMPLOYEE.getFkInstitution());

        EmployeeEntity newEmployee = employeeCrud.getEmployeeById(employeeId);

        assertThat(newEmployee.getId(), equalTo(EmployeeData.NEW_EMPLOYEE.getId()));
        assertThat(newEmployee.getFirstName(), equalTo(EmployeeData.NEW_EMPLOYEE.getFirstName()));
        assertThat(newEmployee.getLastName(), equalTo(EmployeeData.NEW_EMPLOYEE.getLastName()));
        assertThat(newEmployee.getEmail(), equalTo(EmployeeData.NEW_EMPLOYEE.getEmail()));
        assertThat(newEmployee.getPhoneNumber(), equalTo(EmployeeData.NEW_EMPLOYEE.getPhoneNumber()));
        assertThat(newEmployee.getAddress(), equalTo(EmployeeData.NEW_EMPLOYEE.getAddress()));
        assertThat(newEmployee.getSalary(), equalTo(EmployeeData.NEW_EMPLOYEE.getSalary()));
        assertThat(newEmployee.getBirthDate(), equalTo(EmployeeData.NEW_EMPLOYEE.getBirthDate()));
        assertThat(newEmployee.getFkCompany(), equalTo(EmployeeData.NEW_EMPLOYEE.getFkCompany()));
        assertThat(newEmployee.getFkInstitution(), equalTo(EmployeeData.NEW_EMPLOYEE.getFkInstitution()));

        employeeCrud.updateEmployee(
                newEmployee.getId(),
                EmployeeData.UPDATE_EMPLOYEE.getFirstName(),
                EmployeeData.UPDATE_EMPLOYEE.getLastName(),
                EmployeeData.UPDATE_EMPLOYEE.getEmail(),
                EmployeeData.UPDATE_EMPLOYEE.getPhoneNumber(),
                EmployeeData.UPDATE_EMPLOYEE.getAddress(),
                EmployeeData.UPDATE_EMPLOYEE.getSalary(),
                EmployeeData.UPDATE_EMPLOYEE.getBirthDate(),
                EmployeeData.UPDATE_EMPLOYEE.getFkCompany(),
                EmployeeData.UPDATE_EMPLOYEE.getFkInstitution());

        EmployeeEntity updatedEmployee = employeeCrud.getEmployeeById(newEmployee.getId());

        assertThat(updatedEmployee.getId(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getId()));
        assertThat(updatedEmployee.getFirstName(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getFirstName()));
        assertThat(updatedEmployee.getLastName(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getLastName()));
        assertThat(updatedEmployee.getEmail(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getEmail()));
        assertThat(updatedEmployee.getPhoneNumber(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getPhoneNumber()));
        assertThat(updatedEmployee.getAddress(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getAddress()));
        assertThat(updatedEmployee.getSalary(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getSalary()));
        assertThat(updatedEmployee.getBirthDate(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getBirthDate()));
        assertThat(updatedEmployee.getFkCompany(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getFkCompany()));
        assertThat(updatedEmployee.getFkInstitution(), equalTo(EmployeeData.UPDATE_EMPLOYEE.getFkInstitution()));

        employeeCrud.deleteEmployee(updatedEmployee.getId());
    }

    @Test
    @Description("Delete employee")
    public void deleteEmployee() {
        EmployeeLogger.logger.info("Test: Delete employee");
        int employeeId = employeeCrud.insertNewEmployee(
                EmployeeData.NEW_EMPLOYEE.getId(),
                EmployeeData.NEW_EMPLOYEE.getFirstName(),
                EmployeeData.NEW_EMPLOYEE.getLastName(),
                EmployeeData.NEW_EMPLOYEE.getEmail(),
                EmployeeData.NEW_EMPLOYEE.getPhoneNumber(),
                EmployeeData.NEW_EMPLOYEE.getAddress(),
                EmployeeData.NEW_EMPLOYEE.getSalary(),
                EmployeeData.NEW_EMPLOYEE.getBirthDate(),
                EmployeeData.NEW_EMPLOYEE.getFkCompany(),
                EmployeeData.NEW_EMPLOYEE.getFkInstitution());

        EmployeeEntity newEmployee = employeeCrud.getEmployeeById(employeeId);

        assertThat(newEmployee.getId(), equalTo(EmployeeData.NEW_EMPLOYEE.getId()));
        assertThat(newEmployee.getFirstName(), equalTo(EmployeeData.NEW_EMPLOYEE.getFirstName()));
        assertThat(newEmployee.getLastName(), equalTo(EmployeeData.NEW_EMPLOYEE.getLastName()));
        assertThat(newEmployee.getEmail(), equalTo(EmployeeData.NEW_EMPLOYEE.getEmail()));
        assertThat(newEmployee.getPhoneNumber(), equalTo(EmployeeData.NEW_EMPLOYEE.getPhoneNumber()));
        assertThat(newEmployee.getAddress(), equalTo(EmployeeData.NEW_EMPLOYEE.getAddress()));
        assertThat(newEmployee.getSalary(), equalTo(EmployeeData.NEW_EMPLOYEE.getSalary()));
        assertThat(newEmployee.getBirthDate(), equalTo(EmployeeData.NEW_EMPLOYEE.getBirthDate()));
        assertThat(newEmployee.getFkCompany(), equalTo(EmployeeData.NEW_EMPLOYEE.getFkCompany()));
        assertThat(newEmployee.getFkInstitution(), equalTo(EmployeeData.NEW_EMPLOYEE.getFkInstitution()));

        employeeCrud.deleteEmployee(newEmployee.getId());
        EmployeeEntity removedEmployee = employeeCrud.getEmployeeById(EmployeeData.NEW_EMPLOYEE.getId());
        assertThat(removedEmployee, equalTo(null));
    }
}
