/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
*/
/**
 *
 * @author Rácz Dénes
 */

public class Menetrend {

    private int ora;

    private final SimpleStringProperty Munkanap;

    private final SimpleStringProperty Tanszunet;

    private final SimpleStringProperty Szabadnap;

    private final SimpleStringProperty Munkaszunet;

    public Menetrend(int ora, String Munkanap, String Tanszunet, String Szabadnap, String Munkaszunet) {
        this.ora = ora;
        this.Munkanap = new SimpleStringProperty(Munkanap);
        this.Tanszunet = new SimpleStringProperty(Tanszunet);
        this.Szabadnap = new SimpleStringProperty(Szabadnap);
        this.Munkaszunet = new SimpleStringProperty(Munkaszunet);
    }

    public Menetrend() {
        this.Munkanap = null;
        this.Tanszunet = null;
        this.Szabadnap = null;
        this.Munkaszunet = null;
    }


    
    
    
    public int getOra() {
        return ora;
    }

    public String getMunkanap() {
        return Munkanap.get();
    }

    public String getTanszunet() {
        return Tanszunet.get();
    }

    public String getSzabadnap() {
        return Szabadnap.get();
    }

    public String getMunkaszunet() {
        return Munkaszunet.get();
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public void setMunkanap(String Munkanap) {
        this.Munkanap.set(Munkanap);
    }

    public void setTanszunet(String Tanszunet) {
        this.Tanszunet.set(Tanszunet);
    }

    public void setSzabadnap(String Szabadnap) {
        this.Szabadnap.set(Szabadnap);
    }

    public void setMunkaszunet(String Munkaszunet) {
        this.Munkaszunet.set(Munkaszunet);
    }
    public boolean equals(Menetrend m){
        
        if (this.ora==m.getOra()){
            if (this.Munkanap.equals(m.getMunkanap())){
                if(this.Tanszunet.equals(m.getTanszunet())){
                    if(this.Szabadnap.equals(m.getSzabadnap())){
                        if(this.Munkaszunet.equals(m.getMunkaszunet())){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
}
