/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Packets.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author khali
 */
public class EventListener {

    void recieved(Object data) {
        if(data instanceof AddUserPacket){
            AddUserPacket aup = (AddUserPacket) data;
            System.out.println("The user "+aup.getUsername()+" has joined the room");
        }else if(data instanceof RemoveUserPacket){
            RemoveUserPacket rup = (RemoveUserPacket) data;
            System.out.println("The user "+rup.getUsername()+" has left the room");
        }else if(data instanceof ChatPacket){
            ChatPacket cp = (ChatPacket) data;
            Client.chatTArea.setText(Client.chatTArea.getText()
                    + "\nfrom "+cp.getUsername()+":\n"
                    +cp.getMessage());
        }else if(data instanceof AudioPacket){
            AudioPacket ap = (AudioPacket)data;
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, getAudioFormat());
            try {
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                line.write(ap.getBuf(), ap.getI(), ap.getBytesIn());
            } catch (LineUnavailableException ex) {
                Logger.getLogger(EventListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    }
    
}
