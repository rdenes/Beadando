/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beadando;

import Modell.Megallo;
import Modell.Menetrend;
import Modell.MenetrendDAO;
//import Modell.MenetrendDAOFactory;
//import Modell.MenetrendDAOImpl;
import Modell.MenetrendXMLDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableArray;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author Rácz Dénes
 */
public class BuszController implements Initializable {
    
    @FXML
    private Button Vissza;
    @FXML
    private TableView<Menetrend> Menetrendt;
    @FXML
    private TableView<Megallo> Megallok;
    @FXML
    private TableColumn ora;
    @FXML
    private TableColumn Munkanap;
    @FXML
    private TableColumn Tanszunet;
    @FXML
    private TableColumn Szabadnap;
    @FXML
    private TableColumn Munkaszunet;
    @FXML
    private TableColumn Megallo;
    @FXML
    private TableColumn Keses;
    @FXML
    public Label Label_B;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {




    }
    public void VisszaClick() throws IOException{
        try {
            Stage stage;
            Parent root;
            stage = (Stage) Vissza.getScene().getWindow();            
            FXMLLoader fl1 = new FXMLLoader(getClass().getResource("/fxml/Indit.fxml"));
            root = fl1.load();
            Scene scene = new Scene(root);            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void MegalloStart(String buszszam,String megallo){
        int busz = Integer.parseInt(buszszam);

        MenetrendXMLDAO m = new MenetrendXMLDAO();
        List<Menetrend> l = new ArrayList<>();
        List<Megallo> ll = new ArrayList<>();

        
        ora.setCellValueFactory(new PropertyValueFactory("ora"));
        Munkanap.setCellValueFactory(new PropertyValueFactory("Munkanap"));
        Tanszunet.setCellValueFactory(new PropertyValueFactory("Tanszunet"));
        Szabadnap.setCellValueFactory(new PropertyValueFactory("Szabadnap"));
        Munkaszunet.setCellValueFactory(new PropertyValueFactory("Munkaszunet"));
        
        Megallo.setCellValueFactory(new PropertyValueFactory("Megallo"));
        Keses.setCellValueFactory(new PropertyValueFactory("Keses"));
        
        ObservableList<Menetrend> ob = FXCollections.observableArrayList();
        ObservableList<Megallo> ob2 = FXCollections.observableArrayList();



        
        /*for (int i=0;i<ob.size();i++){
            Menetrendt.getItems().add(ob.get(i));
        }*/
        try {
            l = m.getBuszMegallo(busz,megallo);
            ll = m.getMegallo(busz);
            for (Menetrend e : l){
            //System.out.println(e.getOra());
            ob.add(e);
            }
            boolean bo=false;
            int kes = 0;
            for (Megallo e : ll){
                if(e.getMegallo().equals(megallo)) {
                    bo=true;
                    kes = e.getKeses();
                }
                if (bo) ob2.add(new Megallo(e.getKeses()-kes, e.getMegallo()));
            }
            
            Menetrendt.setItems(ob);
            Megallok.setItems(ob2);
            // Menetrendt.getColumns().addAll(ora,Munkanap,Tanszunet,Szabadnap,Munkaszunet);
        
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(BuszController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(BuszController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuszController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void Start(String buszszam){
        
        int busz = Integer.parseInt(buszszam);
        /*TableColumn ora = new TableColumn("Ora");
        TableColumn Munkanap = new TableColumn("Munkanap");
        TableColumn Tanszunet = new TableColumn("Tanszunet");
        TableColumn Szabadnap = new TableColumn("Szabadnap");
        TableColumn Munkaszunet = new TableColumn("Munkaszunet");*/
        //MenetrendDAO m = MenetrendDAOFactory.getInstance().createMenetrendDAO();
        MenetrendXMLDAO m = new MenetrendXMLDAO();
        List<Menetrend> l = new ArrayList<>();
        List<Megallo> ll = new ArrayList<>();
        /*
        ora.setCellValueFactory(new PropertyValueFactory("ora"));
        Munkanap.setCellValueFactory(new PropertyValueFactory("Munkanap"));
        Tanszunet.setCellValueFactory(new PropertyValueFactory("Tanszunet"));
        Szabadnap.setCellValueFactory(new PropertyValueFactory("Szabadnap"));
        Munkaszunet.setCellValueFactory(new PropertyValueFactory("Munkaszunet"));*/
        
        ora.setCellValueFactory(new PropertyValueFactory("ora"));
        Munkanap.setCellValueFactory(new PropertyValueFactory("Munkanap"));
        Tanszunet.setCellValueFactory(new PropertyValueFactory("Tanszunet"));
        Szabadnap.setCellValueFactory(new PropertyValueFactory("Szabadnap"));
        Munkaszunet.setCellValueFactory(new PropertyValueFactory("Munkaszunet"));
        
        Megallo.setCellValueFactory(new PropertyValueFactory("Megallo"));
        Keses.setCellValueFactory(new PropertyValueFactory("Keses"));
        
        ObservableList<Menetrend> ob = FXCollections.observableArrayList();
        ObservableList<Megallo> ob2 = FXCollections.observableArrayList();
        /*
        ob.add(new Menetrend(0,"1","1","1","1"));
        ob.add(new Menetrend(1,"1","1","1","1"));
        ob.add(new Menetrend(2,"1","1","1","1"));
        ob.add(new Menetrend(3,"1","1","1","1"));
        System.out.println(ob.get(1).Munkanap.get());
        Menetrendt.getItems().add(ob.get(0));
        */


        
        /*for (int i=0;i<ob.size();i++){
            Menetrendt.getItems().add(ob.get(i));
        }*/
        try {
            l = m.getBusz(busz);
            ll = m.getMegallo(busz);
            for (Menetrend e : l){
            //System.out.println(e.getOra());
            ob.add(e);
            }
            for (Megallo e : ll){
            ob2.add(e);
            }
            
            Menetrendt.setItems(ob);
            Megallok.setItems(ob2);
            // Menetrendt.getColumns().addAll(ora,Munkanap,Tanszunet,Szabadnap,Munkaszunet);
        
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(BuszController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(BuszController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuszController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initData(String buszszam){
        Label_B.setText(buszszam);
        
    }
    
}
