
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author abbib
 */
//add annotation here
@ManagedBean
public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String password;
    private final String databaseURL="jdbc:postgresql://localhost:5432/web";
    private final String db_username="postgres";
    private final String db_passwd="auca123";
    
    //generate constructor with no arg

    public Student() {
    }
    //generate getters and setters

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //generate methods
    public String saveStudent(Student theStudent){
        try{
        //Register drive
        DriverManager.registerDriver(new org.postgresql.Driver());
        int numberOfRowsAffected;
            //create statement
            try ( //Create connection
                    Connection conn = DriverManager.getConnection(databaseURL,db_username,db_passwd)) {
                //create statement
                java.sql.Statement st = conn.createStatement();
                String sql= "insert into student(first_name,last_name,age,password) "
                        + "values('"+theStudent.getFirstName()+"','"+theStudent.getLastName()+"',"+theStudent.getAge()+" ,'"+theStudent.getPassword()+"')";
                //execute Query
                numberOfRowsAffected = st.executeUpdate(sql);
                //close connection
            }
                    if(numberOfRowsAffected >=1){
                        return "confirmation";
                    }
                   } catch (Exception ex) {
                       System.out.println(ex);
                   }
                   return "confirmation";
    }
}
