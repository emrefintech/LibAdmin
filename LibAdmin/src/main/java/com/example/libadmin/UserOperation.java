package com.example.libadmin;




import java.util.ArrayList;
import java.util.List;

public class UserOperation implements IOperation<User> {
    private List<User> userList;


    public UserOperation() {
        userList = new ArrayList<>();
    }



    @Override
    public void add(User user) {
        userList.add(user);
    }

    public void updateUser(int userID, String name, String surname, int date) throws Exception {
        User userToUpdate = null;
        for (User user : userList) {
            if (user.getUserID() == userID) {
                userToUpdate = user;
                break;
            }
        }
        if (userToUpdate != null) {
            userToUpdate.setName(name);
            userToUpdate.setSurname(surname);
            userToUpdate.setDate(date);
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public void update(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserID() == user.getUserID()) {
                userList.set(i, user);
                break;
            }
        }
    }

    @Override
    public void delete(int userID) throws Exception {
        User userToRemove = null;
        for (User user : userList) {
            if (user.getUserID() == userID) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove != null) {
            userList.remove(userToRemove);
        } else {
            throw new Exception("User not found");
        }
    }


    @Override
    public User search(int id) {

        for (User u : userList) {
            if (u.getUserID() == id) {
                return u;
            }
        }


        return null;
    }

    public User findUserById(int userID) {
        for (User user : userList) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }


    @Override
    public List<User> getList() {
        return userList;
    }
}
