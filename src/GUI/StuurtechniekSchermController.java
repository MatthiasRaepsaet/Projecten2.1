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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StuurtechniekSchermController implements Initializable {
    DomeinController dc;
    
    private OverzichtSchermController ozc;

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
    @FXML
    private Label onderdeelLbl;
    
    @FXML
    private Rectangle groen;
    
    @FXML
    private Rectangle oranje;
    
    @FXML
    private Rectangle rood;
    
    
    @FXML
    private Button terugButton;

    @FXML
    private Button owButton;
    
    @FXML
    private Rectangle ow1;
    
    @FXML
    private Rectangle ow2;
    
    @FXML
    private Rectangle ow3;

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
    private Button basicButton1;

    @FXML
    private Button basicButton2;

    @FXML
    private Button basicButton3;

    @FXML
    private Button basicButton4;

    @FXML
    private Button basicButton5;

    @FXML
    private Button basicButton6;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label opmerkingLabel;

    @FXML
    private TextField andereTxtArea;
    
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
        opmerkingListView.setItems(data);
        deactiveerButton(okButton);
        deactiveerButton(cancelButton);
        opmerkingLabel.setVisible(false);
        deactiveerTxtArea(andereTxtArea);

        basicLijst.add(basicButton1);
        basicLijst.add(basicButton2);
        basicLijst.add(basicButton3);
        basicLijst.add(basicButton4);
        basicLijst.add(basicButton5);
        basicLijst.add(basicButton6);

        for (Button b : basicLijst) {
            b.setDisable(true);
            b.setVisible(false);
        }
        
    }

    public void veranderKnoppen(ActionEvent event) {
        if (event.getSource() == pinkerButton) {
            for (Button b : basicLijst) {
                deactiveerButton(b);
            }

            activeerButton(basicButton1);
            basicButton1.setText("Achteruit bollen");

            activeerButton(basicButton2);
            basicButton2.setText("Schakelen");
            
            activeerButton(basicButton6);
            wijzer.setRotate(285);
        }

        if (event.getSource() == owButton) {
            for (Button b : basicLijst) {
                deactiveerButton(b);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(315.0);
        }

        if (event.getSource() == voorrangButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(0.1);
        }

        if (event.getSource() == bordenButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(45.0);
        }

        if (event.getSource() == snelheidButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(75.0);
        }

        if (event.getSource() == autosButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(105.0);
            
        }

        if (event.getSource() == overgaanButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(135.0);
        }

        if (event.getSource() == kruisenButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(180.0);
        }

        if (event.getSource() == linksButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(225);
        }

        if (event.getSource() == rechtsButton) {
            for (Button b : basicLijst) {
                b.setDisable(true);
                b.setVisible(false);
            }

            activeerButton(basicButton1);
            basicButton1.setText("voldoende snelheid");

            activeerButton(basicButton2);
            basicButton2.setText("niet defensief");

            activeerButton(basicButton6);
            wijzer.setRotate(255.0);
        }
    }

    public void toonInvoerveld(ActionEvent event) {
        opmerkingLabel.setVisible(true);
        activeerTxtArea(andereTxtArea);
        activeerButton(okButton);
        activeerButton(cancelButton);
    }

    public void andereNaarOpmerkingList(ActionEvent event) {
        data.add(andereTxtArea.getText());
        opmerkingListView.setItems(data);
    }

    public void basicNaarOpmerkingLijst(ActionEvent event) {
        Button source = (Button) event.getSource();
        data.add(source.getText());
        opmerkingListView.setItems(data);
    }

    public void activeerButton(Button button) {
        button.setVisible(true);
        button.setDisable(false);
    }

    public void deactiveerButton(Button button) {
        button.setVisible(false);
        button.setDisable(true);
    }

    public void activeerTxtArea(TextField ta) {
        ta.setVisible(true);
        ta.setDisable(false);
    }

    public void deactiveerTxtArea(TextField ta) {
        ta.setVisible(false);
        ta.setDisable(true);
    }
    public void naarInfoScherm(ActionEvent event) throws IOException{
        Stage stage = (Stage) infoButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("InfoScherm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void veranderKleur(ActionEvent event)throws IOException{
        Button source = (Button) event.getSource();
        String naam = source.getId().replace("Button", "");
        
        Rectangle target;
        int eva=1;//moet uit vorig scherm komen
//        if(true){
//            if(event.getSource()==rood){
//                target.setFill(new Color(1, 0, 0, 1));
//            }else if(event.getSource()==oranje){
//                target.setFill(new Color(0.98, 0.5, 0, 1));
//            }else if(event.getSource()==groen){
//                target.setFill(new Color(0.255, 0.69, 0, 1));
//            }
//        }
    }
}
