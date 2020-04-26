package com.company;

public class Password {
    private String passwordStr;

    public Password(String passwordStr){
        setPasswordStr(passwordStr);
    }

    public String getPasswordStr(){
        return passwordStr;
    }

    public void setPasswordStr(String passwordStr){
        if(checkPassword(passwordStr)){
            this.passwordStr=passwordStr;
        }
        else{
            System.out.println("Incorrect password");
        }

    }

    private static boolean checkPassword(String password){
        char a;
        boolean checker=false;
        for(int i=0;i<password.length();i++){
            a=password.charAt(i);
            if(Character.isDigit(a)){
                if(Character.isUpperCase(a)){
                    if(Character.isLowerCase(a)){
                        if(password.length()>9){
                            checker=true;
                        }
                    }
                }
            }

        }
        return checker;
    }
    // passwordStr // it should contain uppercase and lowercase letters and digits
    // and its length must be more than 9 symbols

    @Override
    public String toString() {
        return passwordStr;
    }
}
