/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import java.util.List;

/**
 *
 * @author Rácz Dénes
 */
public interface MenetrendDAO {
    public  void createMenetrend(int ora,String munkanap,String Tanszunet,String Szabadnap,String Munkaszunet,int buszszam);

    public  List<Menetrend> readMenetrend(int buszszam);

    public  void updateMenetrend(Menetrend m, int ora,String munkanap,String Tanszunet,String Szabadnap,String Munkaszunet,int buszszam);

    public  void deleteMenetrend(int buszszam) ;

    public  List<Menetrend> findMenetrend(String buszszam);
}
