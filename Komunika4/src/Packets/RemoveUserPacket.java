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
public class RemoveUserPacket implements Serializable{

    private static final long serialVersionUID = 1L;
    private String username;

    public RemoveUserPacket(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
}
