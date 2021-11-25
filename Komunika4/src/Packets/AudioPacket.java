/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packets;

import java.io.Serializable;
import javax.sound.sampled.AudioInputStream;

/**
 *
 * @author khali
 */
public class AudioPacket implements Serializable{

    private static final long serialVersionUID = 1L;
    private byte[] buf;
    private int i, bytesIn;
    private AudioInputStream ais;

    public AudioPacket(AudioInputStream ais) {
        this.ais = ais;
    }

    public AudioPacket(byte[] buf, int i, int bytesIn) {
        this.buf = buf;
        this.i= i;
        this.bytesIn = bytesIn;
    }

    public AudioInputStream getAis() {
        return ais;
    }

    public byte[] getBuf() {
        return buf;
    }

    public int getI() {
        return i;
    }

    public int getBytesIn() {
        return bytesIn;
    }
    
}
