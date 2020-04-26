package com.company;

import java.util.HashSet;

public class User {
    private int id;
    private int id_gen=0;
    private String name;
    private String surname;
    private String username;
    private Password password;
    private HashSet<User> friends=new HashSet<>();

    public User( String name, String surname,String Username){
        generateId();
        setName(name);
        setSurname(surname);
        setUsername(username);
    }

    public void addFriend(User user){
        friends.add(user);
    }

    public HashSet<User> getFriends(){
        return friends;
    }

    public void generateId (){
        id=id_gen++;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(Password password){
        this.password=password;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getUsername(){
        return username;
    }

    public Password getPassword(){
        return password;
    }



    // id (you need to generate this id by static member variable)
    // name, surname
    // username
    // password
}
