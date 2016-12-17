
package edugame;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public abstract class User  implements Serializable{
   private String name;
   private String gender;
   private int age;
   private String email;
   private String username;
   private String password;
   private int ID;
   private String Identity;

    public User() {
    }

    public User(String name, String gender, int age, String email, String password) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;
        this.ID= (int) Date.from(Instant.EPOCH).getTime();
        
    }
    public void setIdentity(String Identity){
        this.Identity=Identity;
    }
    public String getIdentity(){
        return Identity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

//    public void setID(int ID) { //we handle this later
//        this.ID = ID;
//    }
   
}
