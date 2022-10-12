package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "employee")
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @Column(name = "id_employee", nullable = false)
    private int id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 45)
    private String phoneNumber;

    @Column(name = "address", length = 45)
    private String address;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "fk_company", nullable = false)
    private int fkCompany;

    @Column(name = "fk_institution", nullable = false)
    private int fkInstitution;

    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String firstName, String lastName, String email, String phoneNumber, String address, double salary, String birthDate, int fkCompany, int fkInstitution) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.birthDate = birthDate;
        this.fkCompany = fkCompany;
        this.fkInstitution = fkInstitution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getFkCompany() {
        return fkCompany;
    }

    public void setFkCompany(int fkCompany) {
        this.fkCompany = fkCompany;
    }

    public int getFkInstitution() {
        return fkInstitution;
    }

    public void setFkInstitution(int fkInstitution) {
        this.fkInstitution = fkInstitution;
    }
}
