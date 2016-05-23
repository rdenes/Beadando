package com.mycompany.beadando;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author Rácz Dénes
 */
public class BuszHozzaadController implements Initializable {

    List<Menetrend> ll = new ArrayList<>();
    int buszszam;
    @FXML
    private TextField Buszsz_T;
    @FXML
    private Button Szam_B;
    @FXML
    private Button Hozzarak_B;
    @FXML
    private Button Hozzaad_B;
    @FXML
    private TextField ora_T;
    @FXML
    private TextField Munkanap_T;
    @FXML
    private TextField Tanszunet_T;
    @FXML
    private TextField Szabadnap_T;
    @FXML
    private TextField Munkaszunet_T;
    
    @FXML
    private TableColumn ora_C;
    @FXML
    private TableColumn Munkanap_C;
    @FXML
    private TableColumn Tanszunet_C;
    @FXML
    private TableColumn Szabadnap_C;
    @FXML
    private TableColumn Munkaszunet_C;
    
    @FXML
    private TableView Menetrend_T;
    
    @FXML
    private Button Modosito_B;
    
    @FXML
    private ComboBox ora_Cbox;
    @FXML
    private Button Vissza_B;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    private void Vissza_E(ActionEvent event){
            try{
            Stage stage;
            Parent root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Indit.fxml"));
            root = loader.load();


            //root = FXMLLoader.load(getClass().getResource("/fxml/Busz.fxml"));
            stage = (Stage) Vissza_B.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void Modosito_E(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        MenetrendXMLDAO mx = new MenetrendXMLDAO();
        Menetrend m = new Menetrend(Integer.parseInt(ora_Cbox.getValue()+""),Munkanap_T.getText(),Tanszunet_T.getText(),Szabadnap_T.getText(),Munkaszunet_T.getText());
        mx.ModositBusz(buszszam, m);
        
        try{
            Stage stage;
            Parent root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Hozzaad.fxml"));
            root = loader.load();
            loader.<BuszHozzaadController>getController().initDataModosit(mx.getBusz(buszszam),buszszam);
            

            //root = FXMLLoader.load(getClass().getResource("/fxml/Busz.fxml"));
            stage = (Stage) Modosito_B.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    @FXML
    private void ora_Cbox_E(ActionEvent event){
       for (Menetrend e : ll){
           if (e.getOra()==Integer.parseInt(ora_Cbox.getValue()+"")){
                Munkanap_T.setText(e.getMunkanap());
                Tanszunet_T.setText(e.getTanszunet());
                Szabadnap_T.setText(e.getSzabadnap());
                Munkaszunet_T.setText(e.getMunkaszunet());
           }
       }
    }
    @FXML
    private void Buszszam_E(ActionEvent event) {
        try{
            buszszam = Integer.parseInt(Buszsz_T.getText());
            Buszsz_T.setEditable(false);
            Szam_B.setDisable(true);
            Szam_B.setVisible(false);
            if(Hozzarak_B.disableProperty().get()) Hozzarak_B.setDisable(false);
        }catch (Exception e){
            System.out.println("Csak számot adhatsz meg buszszámnak");
        }
    }
    @FXML
    private void Hozzarak_E(ActionEvent event) {
        if (ora_T.getText()!=""&&Munkanap_T.getText()!=""&&Tanszunet_T.getText()!=""&&Szabadnap_T.getText()!=""&&Munkaszunet_T.getText()!=""){
            //try{
                Integer.parseInt(ora_T.getText());
                String[] tmp = Munkanap_T.getText().split(" ");
                for (int i = 0; i< tmp.length;i++){
                    Integer.parseInt(tmp[i]);
                    System.out.println("0");
                }
                String[] tmp2 = Tanszunet_T.getText().split(" ");
                for (int i = 0; i< tmp2.length;i++){
                    Integer.parseInt(tmp2[i]);
                    System.out.println("1");
                }
                String[] tmp3 = Szabadnap_T.getText().split(" ");
                for (int i = 0; i< tmp3.length;i++){
                    Integer.parseInt(tmp3[i]);
                    System.out.println("2");
                }
                String[] tmp4 = Munkaszunet_T.getText().split(" ");
                for (int i = 0; i< tmp4.length;i++){
                    Integer.parseInt(tmp4[i]);
                    System.out.println("3");
                }

                if(Hozzaad_B.disableProperty().get()) Hozzaad_B.setDisable(false);
                ll.add(new Menetrend(Integer.parseInt(ora_T.getText()),Munkanap_T.getText(),Tanszunet_T.getText(),Szabadnap_T.getText(),Munkaszunet_T.getText()));
                
                ora_C.setCellValueFactory(new PropertyValueFactory("ora"));
                Munkanap_C.setCellValueFactory(new PropertyValueFactory("Munkanap"));
                Tanszunet_C.setCellValueFactory(new PropertyValueFactory("Tanszunet"));
                Szabadnap_C.setCellValueFactory(new PropertyValueFactory("Szabadnap"));
                Munkaszunet_C.setCellValueFactory(new PropertyValueFactory("Munkaszunet"));
                
                ObservableList<Menetrend> ob = FXCollections.observableArrayList();
                System.out.println(ll.get(0));
                for (Menetrend e : ll){
                //System.out.println(e.getOra());
                ob.add(e);
                }
                
                Menetrend_T.setItems(ob);
            /*}catch(Exception e){
                System.out.println("Számon kívül mást is tartalmaz valamelyik mező.");   
            }*/
        }else{
            System.out.println("Töltse ki az összes mezőt.");
        }
    }
    @FXML
    private void Hozzaad_E(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        System.out.println(buszszam);
        MenetrendXMLDAO mxd = new MenetrendXMLDAO();
        mxd.InsertBusz(ll, buszszam);
        
        try{
            Stage stage;
            Parent root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Indit.fxml"));
            root = loader.load();

            //root = FXMLLoader.load(getClass().getResource("/fxml/Busz.fxml"));
            stage = (Stage) Hozzaad_B.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
 

    public void initDataModosit(List<Menetrend> mlist,int bszam){
        ll = mlist;
        buszszam = bszam;
        ora_Cbox.setVisible(true);
        ora_Cbox.setDisable(false);
        ora_T.setDisable(false);
        Modosito_B.setVisible(true);
        
        ObservableList<Integer> ob = FXCollections.observableArrayList();
        

            for (int i = 0; i<ll.size();i++){
                ob.add(ll.get(i).getOra());
            }
            ora_Cbox.setItems(ob);
            ora_Cbox.setValue(ob.get(0));
            
                ora_C.setCellValueFactory(new PropertyValueFactory("ora"));
                Munkanap_C.setCellValueFactory(new PropertyValueFactory("Munkanap"));
                Tanszunet_C.setCellValueFactory(new PropertyValueFactory("Tanszunet"));
                Szabadnap_C.setCellValueFactory(new PropertyValueFactory("Szabadnap"));
                Munkaszunet_C.setCellValueFactory(new PropertyValueFactory("Munkaszunet"));
                
                ObservableList<Menetrend> ob2 = FXCollections.observableArrayList();
                System.out.println(ll.get(0));
                for (Menetrend e : ll){
                ob2.add(e);
                }
                
                Menetrend_T.setItems(ob2);
                
                Munkanap_T.setText(ll.get(0).getMunkanap());
                Tanszunet_T.setText(ll.get(0).getTanszunet());
                Szabadnap_T.setText(ll.get(0).getSzabadnap());
                Munkaszunet_T.setText(ll.get(0).getMunkaszunet());
            
            

    }

    public void initDataHozzaad(){
        Szam_B.setDisable(false);
        Buszsz_T.setDisable(false);
    }
}
