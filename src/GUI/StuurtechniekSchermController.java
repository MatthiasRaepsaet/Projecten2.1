/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.DomeinController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StuurtechniekSchermController implements Initializable {
    DomeinController dc;
    
    private OverzichtSchermController ozc;
    private InfoSchermController info;

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
    @FXML
    private Button rood;
    @FXML
    private Button oranje;
    @FXML
    private Button groen;

    @FXML
    private TextArea txtArea;
    
    
    private List<String> textAreaLijst = new ArrayList<>(30);
    
    
    @FXML
    private TextArea tekstVeld;
    
    @FXML
    private Button terugButton;

    @FXML
    private Button owButton;
    
    @FXML
    private Rectangle pinker1,pinker2,pinker3;
    @FXML
    private Rectangle ow1,ow2,ow3;
    @FXML
    private Rectangle voorrang1,voorrang2,voorrang3;
    @FXML
    private Rectangle borden1,borden2,borden3;
    @FXML
    private Rectangle snel1,snel2,snel3;
    @FXML
    private Rectangle autos1,autos2,autos3;
    @FXML
    private Rectangle over1,over2,over3;
    @FXML
    private Rectangle kruis1,kruis2,kruis3;
    @FXML
    private Rectangle l1,l2,l3;
    @FXML
    private Rectangle r1,r2,r3;

    @FXML
    private Button voorrangButton;

    @FXML
    private Button bordenButton;

    @FXML
    private Button snelheidButton;

    @FXML
    private Button autosButton;

    @FXML
    private Button overgaanButton;

    @FXML
    private Button kruisenButton;

    @FXML
    private Button linksButton;

    @FXML
    private Button rechtsButton;

    @FXML
    private Button pinkerButton;
    
    @FXML
    private Button infoButton;
    
    @FXML
    private Rectangle wijzer;

    //categorie per button en in listview laden
    @FXML
    private ListView<String> opmerkingListView = new ListView<>();

    private List<Button> basicLijst = new ArrayList<>();

    private ObservableList<String> data = FXCollections.observableArrayList();
    
    @FXML
    private Text titel;

    @FXML
    private Text naamLbl;
    
    private ObservableList<String> lijst = FXCollections.observableArrayList();
    
    private int nummerVierkant = 0;

    private List<Rectangle> vierkantjes = new ArrayList<>();
    

    @FXML
    private void vorigeScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) terugButton.getScene().getWindow();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        naamLbl.setText(dc.getGeselecteerd().getNaam());
        
    }

    public void veranderKnoppen(ActionEvent event) {
        if (event.getSource() == pinkerButton) {
            wijzer.setRotate(285);
            titel.setText("Richtingsaanwijzers");
            setNummerVierkant(0);
        }

        if (event.getSource() == owButton) {
            
            wijzer.setRotate(315.0);
            titel.setText("Openbare weg");
            setNummerVierkant(3);
        }

        if (event.getSource() == voorrangButton) {
            
            wijzer.setRotate(0.1);
            titel.setText("Voorrang");
            setNummerVierkant(6);
        }

        if (event.getSource() == bordenButton) {
            
            wijzer.setRotate(45.0);
            titel.setText("Verkeersborden");
            setNummerVierkant(9);
        }

        if (event.getSource() == snelheidButton) {
            
            wijzer.setRotate(75.0);
            titel.setText("Snelheid");
            setNummerVierkant(12);
        }

        if (event.getSource() == autosButton) {
            
            wijzer.setRotate(105.0);
            titel.setText("Afstand auto");
            setNummerVierkant(15);
            
        }

        if (event.getSource() == overgaanButton) {
            
            wijzer.setRotate(135.0);
            titel.setText("Overgaan");
            setNummerVierkant(18);
        }

        if (event.getSource() == kruisenButton) {
            
            wijzer.setRotate(180.0);
            titel.setText("Kruisen");
            setNummerVierkant(21);
        }

        if (event.getSource() == linksButton) {
            
            wijzer.setRotate(225);
            titel.setText("Linksaf");
            setNummerVierkant(24);
        }

        if (event.getSource() == rechtsButton) {
            
            wijzer.setRotate(255.0);
            titel.setText("Rechtsaf");
            setNummerVierkant(27);
        }
    }
    
    public void naarInfoScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) infoButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        dc.setIsc(info);
        dc.getIsc().setDc(dc);
        loader.setLocation(getClass().getResource("InfoScherm.fxml"));
        loader.setController(dc.getIsc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void veranderKleur(ActionEvent event) throws IOException {
        int eva = 0;//moet uit vorig scherm komen dit is eva1=0 eva2=1 eva3=2
        vulVierkantjes();
        if (event.getSource() == rood) {
            vierkantjes.get(eva + getNummerVierkant()).setFill(new Color(1, 0, 0, 1));
        } else if (event.getSource() == oranje) {
            vierkantjes.get(eva + getNummerVierkant()).setFill(new Color(0.98, 0.5, 0, 1));
        } else if (event.getSource() == groen) {
            vierkantjes.get(eva + getNummerVierkant()).setFill(new Color(0.255, 0.69, 0, 1));
        }
    }

    public void setNummerVierkant(int nummerVierkant) {
        this.nummerVierkant = nummerVierkant;
    }

    public int getNummerVierkant() {
        return nummerVierkant;
    }

    public void wijzigigenOpslaan(ActionEvent e) throws IOException {
        textAreaLijst.add(nummerVierkant, tekstVeld.getText());
    }

    public void vanLijstNaarTextArea(List<String> lijst) {
        for(String s : lijst){
            tekstVeld.setText(s + "\n");
        }
//        if (!textAreaLijst.isEmpty()) {
//            if (textAreaLijst.size() >= nummerVierkant + 1) {
//                tekstVeld.setText(textAreaLijst.get(nummerVierkant));
//            } else {
//                tekstVeld.setText("");
//            }
//        } else {
//            tekstVeld.setText("");
//        }
    }
    
    public void vulVierkantjes() {
        vierkantjes.add(pinker1);
        vierkantjes.add(pinker2);
        vierkantjes.add(pinker3);        
        vierkantjes.add(ow1);
        vierkantjes.add(ow2);
        vierkantjes.add(ow3);
        vierkantjes.add(voorrang1);
        vierkantjes.add(voorrang2);
        vierkantjes.add(voorrang3);
        vierkantjes.add(borden1);
        vierkantjes.add(borden2);
        vierkantjes.add(borden3);
        vierkantjes.add(snel1);
        vierkantjes.add(snel2);
        vierkantjes.add(snel3);
        vierkantjes.add(autos1);
        vierkantjes.add(autos2);
        vierkantjes.add(autos3);
        vierkantjes.add(over1);
        vierkantjes.add(over2);
        vierkantjes.add(over3);
        vierkantjes.add(kruis1);
        vierkantjes.add(kruis2);
        vierkantjes.add(kruis3);
        vierkantjes.add(l1);
        vierkantjes.add(l2);
        vierkantjes.add(l3);
        vierkantjes.add(r1);
        vierkantjes.add(r2);
        vierkantjes.add(r3);
    }
}
