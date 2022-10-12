package data;

public enum CompanyData {
    NEW_COMPANY(6,
            "D1",
            "d1@d1.com",
            "Cll 3 #4-78",
            "1234567"),

    UPDATE_COMPANY(6,
            "Justo y Bueno",
            "jyb@jyb.com",
            "Cll 3 #4-78",
            "12398737");

    private final int id;
    private final String name;
    private final String email;
    private final String address;
    private final String phone;

    public static final int COMPANY_BY_ID = 1;
    public static final String COMPANY_BY_NAME = "Only";

    CompanyData(int id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
