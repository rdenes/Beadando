/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Rácz Dénes
 */
public class Megallo {
    private final SimpleStringProperty Megallo;
    int keses;
    
    public Megallo(int keses,String Megallo){
        this.keses=keses;
        this.Megallo=new SimpleStringProperty(Megallo);
    }

    public String getMegallo() {
        return Megallo.get();
    }

    public int getKeses() {
        return keses;
    }

    public void setKeses(int keses) {
        this.keses = keses;
    }
    public void setMegallo(String Megallo){
        this.Megallo.set(Megallo);
    }
    
}
