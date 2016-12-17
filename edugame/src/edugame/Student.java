/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.Serializable;

/**
 *
 * @author musta
 */
public class Student extends User implements Serializable{

    public Student() {
    }

    public Student(String name, String gender, int age, String email, String username, String password) {
        super(name, gender, age, email, username, password);
    }

    
}
