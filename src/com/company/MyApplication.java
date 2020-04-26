package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

    public class MyApplication {
        // users - a list of users
        private Scanner sc = new Scanner(System.in);
        private User signedUser;
        private LinkedList<User> users;
        Password password= new Password();

        public MyApplication() throws FileNotFoundException{
           users=new LinkedList();
           fillUsers();
        }

        private void fillUsers() throws FileNotFoundException{
            File file=new File("C:\\Users\\User\\Downloads\\db.txt");
            Scanner fsc=new Scanner(file);
            while(fsc.hasNext()){
                User user=new User(fsc.nextInt(), fsc.next(), fsc.next(), fsc.next(), fsc.next());
                addUser(user);
            }

        }

        private void addUser(User user) {
            users.add(user);
        }

        private void menu() {
            while (true) {
                if (signedUser == null) {
                    System.out.println("You are not signed in.");
                    System.out.println("1. Authentication");
                    System.out.println("2. Exit");
                    int choice = sc.nextInt();
                    if (choice == 1) authentication();
                    else break;
                }
                else {
                    userProfile();
                }
            }
        }

        private void userProfile() {
            while (true){
                System.out.println("1.log off");
                signedUser.getFriends();
                int choise =sc.nextInt();
                if(choise==1) logOff();
            }
        }

        private void logOff() {
             signedUser=null;
             start();
        }

        private void authentication() {
            while (true){
                System.out.println("1.sign in");
                System.out.println("2.sign up");
                int choice=sc.nextInt();
                if(choice==1){
                    signIn();
                }else signUp();
            }

            // sign in
            // sign up
        }

        private void signIn() {
            Scanner scanner=new Scanner(System.in);
            String username=scanner.next();
            String password=scanner.next();
            Password password1=new Password(password);
            for(User user:users){
                if(username.equals(user.getUsername()) && password1.equals(user.getPassword())){
                    signedUser=user;
                }
            }
        }

        private void signUp() {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter your name:");
            String name=sc.next();
            System.out.println("Enter your surname:");
            String surname=sc.next();
            System.out.println("Create username:");
            String username=sc.next();
            System.out.println("Create password(it should contain uppercase, lowercase letters,digits and it's lengh should be more than 9):");
            String password=sc.next();
            if(password!=null && username!=null &&name!=null && surname!=null){
                User user= new User();
                user.setUsername(name);
                user.setSurname(surname);
                user.setUsername(username);
                Password password1=new Password(password);
                if(password1.checkPassword(user)){
                    addUser(user);
                    authentication();
                }

            }
            signIn();

        }

        public void start(){
            //File file = new File("D:\\IdeaProjects\\Task12\\src\\com\\company\\db.txt");
            //Scanner fileScanner = new Scanner(file);
            // fill userlist from db.txt

            while (true) {
                System.out.println("Welcome to my application!");
                System.out.println("Select command:");
                System.out.println("1. Menu");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1) {
                    menu();
                } else {
                    break;
                }
            }
            saveUserList();
        }


        private void saveUserList() throws IOException {
            String content=" ";
            for(User user:users){
                content+=user+"\n";
            }
            Files.write(Paths.get("C:\\Users\\User\\Downloads\\db.txt"), content.getBytes());
        }
    }


