package data;

public enum EmployeeData {

    NEW_EMPLOYEE(100,
            "Grandpa Gohan",
            "Son",
            "songohan@dbz.com",
            "231456987",
            "Paoz Mountain",
            2.456,
            "1958-01-01",
            3,
            5),

    UPDATE_EMPLOYEE(100,
            "Gohan",
            "Son",
            "songohan@dball.com",
            "231456987",
            "Paoz Mountain",
            2456,
            "1958-01-01",
            3,
            5);

    public static final String EMPLOYEE_BY_LAST_NAME = "Kameja";

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final double salary;
    private final String birthDate;
    private final int fkCompany;
    private final int fkInstitution;

    EmployeeData(int id, String firstName, String lastName, String email, String phoneNumber, String address, double salary, String birthDate, int fkCompany, int fkInstitution) {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getFkCompany() {
        return fkCompany;
    }

    public int getFkInstitution() {
        return fkInstitution;
    }
}
