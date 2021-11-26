/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packets;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author khali
 */
public class UserListPacket implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<String> users;

    public UserListPacket(ArrayList<String> users) {
        this.users = users;
    }

    public ArrayList<String> getUsers() {
        return users;
    }
    
}
