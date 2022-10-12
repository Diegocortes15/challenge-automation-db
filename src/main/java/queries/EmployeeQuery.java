package queries;

import entities.EmployeeEntity;
import utils.loggers.EmployeeLogger;

import java.util.List;

public class EmployeeQuery extends QuerySetup {
    private EmployeeEntity employeeEntity;
    private List<EmployeeEntity> employeeEntityList;

    public EmployeeQuery() {
        super();
    }

    public List<EmployeeEntity> getAllEmployees() {
        employeeEntityList = manager.createQuery("FROM employee").getResultList();
        return employeeEntityList;
    }

    public EmployeeEntity getEmployeeById(int id) {
        employeeEntity = manager.find(EmployeeEntity.class, id);
        return employeeEntity;
    }

    public List<EmployeeEntity> getEmployeeByLastName(String lastName) {
        employeeEntityList = manager.createQuery("SELECT e FROM employee e WHERE e.lastName = :lastName").setParameter("lastName", lastName).getResultList();
        return employeeEntityList;
    }

    public int insertEmployee(EmployeeEntity employee) {
        transaction.begin();
        manager.persist(employee);

        try {
            transaction.commit();
            return employee.getId();
        } catch (Exception e) {
            transaction.rollback();
            EmployeeLogger.logger.info("Database was not updated");
            return -1;
        }
    }

    public int updateEmployee(int id, String firstName, String lastName, String email, String phoneNumber, String address, double salary, String birthDate, int fkCompany, int fkInstitution) {
        employeeEntity = getEmployeeById(id);

        if (employeeEntity != null) {
            employeeEntity.setFirstName(firstName);
            employeeEntity.setLastName(lastName);
            employeeEntity.setEmail(email);
            employeeEntity.setPhoneNumber(phoneNumber);
            employeeEntity.setAddress(address);
            employeeEntity.setSalary(salary);
            employeeEntity.setBirthDate(birthDate);
            employeeEntity.setFkCompany(fkCompany);
            employeeEntity.setFkInstitution(fkInstitution);

            transaction.begin();
            manager.merge(employeeEntity);

            try {
                transaction.commit();
                return employeeEntity.getId();
            } catch (Exception e) {
                transaction.rollback();
                EmployeeLogger.logger.info("Database was not updated");
                return -1;
            }
        } else {
            EmployeeLogger.logger.info("Company was not found");
            return -1;
        }
    }

    public int deleteEmployee(int id) {
        employeeEntity = getEmployeeById(id);

        if (employeeEntity != null) {
            transaction.begin();
            manager.remove(employeeEntity);

            try {
                transaction.commit();
                return employeeEntity.getId();

            } catch (Exception e) {
                transaction.rollback();
                EmployeeLogger.logger.info("Database was not updated");
                return -1;
            }
        } else {
            EmployeeLogger.logger.info("Employee was not found");
            return -1;
        }
    }
}
