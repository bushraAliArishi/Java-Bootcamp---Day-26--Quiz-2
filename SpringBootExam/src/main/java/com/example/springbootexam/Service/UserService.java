package com.example.springbootexam.Service;

import com.example.springbootexam.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    final private ArrayList<User> users = new ArrayList();

    //crud
    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean updateUser(String ID, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equalsIgnoreCase(ID)) {
                users.set(i, user);
                return true;

            }
        }
        return false;
    }

    public boolean deleteUser(String ID) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equalsIgnoreCase(ID)) {
                users.remove(users.get(i));
                return true;

            }
        }
        return false;
    }

    //crud
    public boolean checkRoll(String userID) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equalsIgnoreCase(userID)) {
                if (users.get(i).getRoll().equalsIgnoreCase("libraian")) {
                    return true;
                }
            }
        }
        return false;

    }
    public ArrayList<User> getBalance(double balance){
        ArrayList<User>users1=new ArrayList<>();
        for (User user : users) {
            if (user.getBalance()>=balance){
                users1.add(user);
            }

        }return users1;
    }
    public ArrayList<User> getage(int age){
        ArrayList<User>users2=new ArrayList<>();
        for (User user : users) {
            if (user.getAge()>=age){
                users2.add(user);
            }

        }return users2;
    }
}
