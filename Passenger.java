public class Passenger {
    private int memberID;
    private String passportNumber;
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private int contactNumber;
    private String email;
    private String vipStatus;

    // Constructor

    public Passenger(int memberID, String passportNumber, String lastName, String firstName,
                     String dateOfBirth, int contactNumber, String email, String vipStatus) {
        this.memberID = memberID;
        this.passportNumber = passportNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.email = email;
        this.vipStatus = vipStatus;
    }


    // GETTERS //

    public int getMemberID() {
        return memberID;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getVipStatus() {
        return vipStatus;
    }


    // SETTERS //

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }
}