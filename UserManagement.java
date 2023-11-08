package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserManagement extends Users {
    private List<Users> register;

    public UserManagement(String firstName, String middleName, String lastName, String studentID, String section, String department, String email, String course, int year, String contact, String datemonth, int dateday, int dateyear) {
        super(firstName, middleName, lastName, studentID, section, department, email, course, year, contact, datemonth, dateday, dateyear);
        register = new ArrayList<>();
        readFile();
    }

    private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("registration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemInfo = line.split(",");
                if (itemInfo.length >= 13) {
                    String firstName = itemInfo[0];
                    String middleName = itemInfo[1];
                    String lastName = itemInfo[2];
                    String studentID = itemInfo[3];
                    String section = itemInfo[4];
                    String dept = itemInfo[5];
                    String email = itemInfo[6];
                    String course = itemInfo[7];
                    int year = Integer.parseInt(itemInfo[8]);
                    String contact = itemInfo[9];
                    String datemonth = itemInfo[10];
                    int dateday = Integer.parseInt(itemInfo[11]);
                    int dateyear = Integer.parseInt(itemInfo[12]);

                    Users user = new Users(firstName, middleName, lastName, studentID, section, dept, email, course, year, contact, datemonth, dateday, dateyear);
                    register.add(user);
                } 
                
                else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUsers(Users users) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("registration.txt"))) {
            pw.println(users.getFirstName() + "," + users.getMiddleName() + "," + users.getLastName() + "," + users.getStudentID() + "," + users.getSection() + "," 
            + users.getDepartment() + "," + users.getEmail() + "," + users.getCourse() + ","+ users.getYear() + ","
            + users.getContact() + "," + users.getdatemonth() + "," + users.getdateday() + "," + users.getdateyear());
        } 
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getStudentID() {
        for (Users user : register) {
            return user.getStudentID();
        }
        return null;
    }

    public String getName() {
        for (Users user : register) {
            String firstName = user.getFirstName();
            String middleName = user.getMiddleName();
            String lastName = user.getLastName();
            if (firstName != null && middleName != null && lastName != null) {
                return firstName + " " + middleName + " " + lastName;
            }
        }
        return "";
    }

    public String getSection() {
        for (Users user : register) {
            return user.getSection();
        }
        return null;
    }

    public String getEmail() {
        for (Users user : register) {
            return user.getEmail();
        }
        return null;
    }

    public String getDepartment() {
        for (Users user : register) {
            return user.getDepartment();
        }
        return null;
    }

    public int getYear() {
        for (Users user : register) {
            return user.getYear();
        }
        return 0;
    }

    public String getContactNo() {
        for (Users user : register) {
            return user.getContact();
        }
        return null;
    }

    public String getdate() {
        for (Users user : register) {
            String datemonth = user.getdatemonth();
            int dateday = user.getdateday();
            int dateyear = user.getdateyear();
            if (datemonth != null && dateday != 0 && dateyear != 0) {
                return datemonth + " " + dateday + " " + dateyear;
            }
        }
        return "";
    }
}
