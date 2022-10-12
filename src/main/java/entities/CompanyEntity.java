package entities;

import jakarta.persistence.*;

//Define entity and table name
@Entity(name = "company")
@Table(name = "company")
public class CompanyEntity {

    //Define columns
    @Id
    @Column(name = "id_company", nullable = false)
    private int id;

    @Column(name = "company_name", nullable = false, length = 45)
    private String name;

    @Column(name = "phone_number", nullable = false, length = 45)
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "address", length = 45)
    private String address;

    //empty constructor
    public CompanyEntity() {
    }

    //constructor
    public CompanyEntity(int id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
