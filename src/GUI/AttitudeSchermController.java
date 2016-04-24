/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.DomeinController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AttitudeSchermController implements Initializable {
    
    DomeinController dc;
    
    private OverzichtSchermController ozc;
    
    @FXML
    private Button achteruitButton;
    
    @FXML
    private Button rechts;
    
    @FXML
    private Button delete;
    
    @FXML
    private Button okButton;
    
    @FXML
    ListView linkerLijst = new ListView();
    
    @FXML
    ListView rechterLijst = new ListView();
    
    @FXML
    private TextField andereText;
            
    //dit is de rechterlijst
    private ObservableList<String> attitudes = FXCollections.observableArrayList();
    //linker
    private ObservableList<String> keuzes = FXCollections.observableArrayList();
    
    private List<String> controle;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        keuzes.add("Zenuwachtig");
        keuzes.add("Concentratie");
        keuzes.add("Angst");
        keuzes.add("Asociaal");
        keuzes.add("Verkeersgevaarlijk");
        keuzes.add("Inzet");
        keuzes.add("Verstrooid");
        linkerLijst.setItems(keuzes);
        controle=keuzes;
        rechts.setDisable(true);
        delete.setDisable(true);
        linkerLijst.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
                if(linkerLijst.getSelectionModel().getSelectedItem()!=null){
                    rechts.setDisable(false);
                }else{
                    rechts.setDisable(true);
                }
            }
        });
        rechterLijst.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
                if(rechterLijst.getSelectionModel().getSelectedItem()!=null){
                    delete.setDisable(false);
                }else{
                    delete.setDisable(true);
                }
            }
        });
    }  
    
    public void naarRechterLijst(ActionEvent event) throws IOException{
        if(!keuzes.isEmpty()){
        attitudes.add(linkerLijst.getSelectionModel().getSelectedItem().toString());
        keuzes.remove(linkerLijst.getSelectionModel().getSelectedItem());
        linkerLijst.setItems(keuzes);
        linkerLijst.getSelectionModel().clearSelection();
        rechterLijst.setItems(attitudes);
        }
    }
    
    public void naarLinkerLijst(ActionEvent event) throws IOException{
        if(!attitudes.isEmpty()){
            if(controle.contains(rechterLijst.getSelectionModel().getSelectedItem().toString()))
            {
                keuzes.add(rechterLijst.getSelectionModel().getSelectedItem().toString());
                System.out.println("van rechts naar links");
                linkerLijst.setItems(keuzes);
            }
            attitudes.remove(rechterLijst.getSelectionModel().getSelectedItem());
            rechterLijst.setItems(attitudes);
            rechterLijst.getSelectionModel().clearSelection();
            linkerLijst.setItems(keuzes);
        }
    }
    
    public void andereNaarOpmerkingList(ActionEvent event) throws IOException{
        if(!andereText.getText().isEmpty()&&andereText.getText()!=""&&andereText.getText()!=" "){
            attitudes.add(andereText.getText());
            rechterLijst.setItems(attitudes);
            andereText.clear();
        }
    }
    
    public void enableOkButton(ActionEvent event) throws IOException{
        if(!andereText.getText().isEmpty()){
            okButton.setDisable(false);
        }else{
            okButton.setDisable(true);
        }
    }
    
    public void gaAchteruit(ActionEvent event) throws IOException{
        Stage stage = (Stage) achteruitButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        ozc = dc.getOzc();
        dc.setOzc(ozc);
        dc.getOzc().setDc(dc);
        loader.setLocation(getClass().getResource("OverzichtScherm.fxml"));
        loader.setController(dc.getOzc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
    
    
}