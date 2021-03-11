package com.example.demo.models;

import lombok.Data;
import org.dom4j.tree.AbstractEntity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Data
public class User  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)


    private int userId;


    private String userName;



    @NotBlank(message = "Name is mandatory")
    private String userLastName;


    private String email;

    public User(){
    }

    public User(int userId, String userName, String userLastName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.email = email;
    }

}
