package com.company;

public class Friend extends User{
    private String message;

    public Friend(String name, String surname, String Username) {
        super(name, surname, Username);
    }

    public String setMessage(){
        return message;
    }
    public void getMessage(){
        this.message=message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
