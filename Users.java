package project;

public class Users {
    private String firstName;
    private String middleName;
    private String lastName;
    private String studentID;
    private String section;
    private String email;
    private String course;
    private String department;
    private int year;
    private String contact;
    private String datemonth;
    private int dateday;
    private int dateyear;

    public Users(String firstName, String middleName, String lastName, String studentID, String section, String department, String email, String course, int year, String contact, String datemonth, int dateday, int dateyear) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.section = section;
        this.department = department;
        this.email = email;
        this.course = course;
        this.year = year;
        this.contact = contact;
        this.datemonth = datemonth;
        this.dateday = dateday;
        this.dateyear = dateyear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getdatemonth() {
        return datemonth;
    }

    public void setdatemonth(String datemonth) {
        this.datemonth = datemonth;
    }

    public int getdateday() {
        return dateday;
    }

    public void setdateday(int dateday) {
        this.dateday = dateday;
    }

    public int getdateyear() {
        return dateyear;
    }

    public void setdateyear(int dateyear) {
        this.dateyear = dateyear;
    }
}
