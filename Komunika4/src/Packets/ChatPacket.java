/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packets;

import java.io.Serializable;

/**
 *
 * @author khali
 */
public class ChatPacket implements Serializable{

    private static final long serialVersionUID = 1L;
    private String username;
    private String message;

    public ChatPacket(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
    
    
}
