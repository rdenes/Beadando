package com.mycompany.beadando;

import Modell.Megallo;
import Modell.Menetrend;
import Modell.MenetrendXMLDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button Keres_B;
    @FXML
    private ComboBox Buszok_B;
    @FXML
    private ComboBox Megallok_M;
    @FXML
    private ComboBox Megallok_B;
    @FXML
    private Button Megallok_But;
    @FXML
    private Button BuszKeres_B;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        /*Stage stage;
        Parent root;*/
        BuszController m = new BuszController();
        try{
            Stage stage;
            Parent root;
            /*stage = (Stage) Keres.getScene().getWindow();            
            FXMLLoader fl1 = new FXMLLoader(getClass().getResource("/fxml/Busz.fxml"));
            root = fl1.load();
            Scene scene = new Scene(root);            
            stage.setScene(scene);
            stage.show();*/
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Busz.fxml"));
            root = loader.load();
            loader.<BuszController>getController().initData(Buszok_B.getValue()+"");
            loader.<BuszController>getController().Start(Buszok_B.getValue()+"");

            //root = FXMLLoader.load(getClass().getResource("/fxml/Busz.fxml"));
            stage = (Stage) Keres_B.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
   @FXML
   private void Megallot_Keres(ActionEvent event) throws SAXException, ParserConfigurationException, IOException {
       String megallo = Megallok_M.getValue().toString();
       MenetrendXMLDAO m = new MenetrendXMLDAO();
       List<Integer> ll = new ArrayList<>();
       ObservableList<Integer> ob = FXCollections.observableArrayList();
       ll = m.getBuszok(megallo);
       for(Integer e :ll){
                ob.add(e);
       }
       //System.out.println(ob.get(0));
       Megallok_B.setItems(ob);
       Megallok_B.setValue(ob.get(0));
       
       Megallok_B.setDisable(false);
       BuszKeres_B.setDisable(false);
    }
   @FXML
   private void Busz_Keres_E(ActionEvent event){
        BuszController m = new BuszController();
        try{
            Stage stage;
            Parent root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Busz.fxml"));
            root = loader.load();
            loader.<BuszController>getController().initData(Megallok_B.getValue()+" "+Megallok_M.getValue());
            loader.<BuszController>getController().MegalloStart(Megallok_B.getValue()+"",Megallok_M.getValue()+"");

            //root = FXMLLoader.load(getClass().getResource("/fxml/Busz.fxml"));
            stage = (Stage) Keres_B.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenetrendXMLDAO m = new MenetrendXMLDAO();
        List<Integer> ll = new ArrayList<>();
        List<String> megallok = new ArrayList<>();
        ObservableList<Integer> ob = FXCollections.observableArrayList();
        ObservableList<String> ob2 = FXCollections.observableArrayList();
        List<Menetrend> re = new ArrayList<>();
        try {
            /*
            re = m.getBuszMegallo(18, "Megallo2");
            System.out.println("most jön");
            for (Menetrend e:re){
                System.out.println(e.getMunkanap());
            }*/
            ll = m.getStart();
            for(Integer e :ll){
                ob.add(e);
            }
            Buszok_B.setItems(ob);
            Buszok_B.setValue(ob.get(0));
            
            megallok = m.MegallokStart();
            for(String s :megallok){
                ob2.add(s.trim());
            }
            //System.out.println(ob2.get(0));
            Megallok_M.setItems(ob2);
            Megallok_M.setValue(ob2.get(0));
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
