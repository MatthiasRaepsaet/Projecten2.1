/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import domein.DomeinController;
import domein.Leerling;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ZoekLlnSchermController implements Initializable {
    
    private DomeinController dc = new DomeinController();

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
    

    @FXML
    private ListView listView;
    @FXML
    private Button ok;

    @FXML
    private Button zoekenButton;

    @FXML
    private ListView<Leerling> lijst;

    @FXML
    private Text naamLbl;

    @FXML
    private Text nummerLbl;

    @FXML
    private Text emailLbl;

    @FXML
    private ImageView imgView;
    
    @FXML
    private TextField nummerField;
    
    @FXML
    private Label zoekNaamLbl;
    
    @FXML
    private TextField zoekNaamTxtField;
    
    
    private OverzichtSchermController ozc = new OverzichtSchermController();
    
    private Leerling geselecteerdeLeerling = new Leerling(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        zoekNaamLbl.setVisible(false);
        zoekNaamTxtField.setVisible(false);
        ok.setDisable(true);
//        List<Leerling> test = dc.getLeerlingen();
        File startupimg = new File("src/images/boom.png");
        imgView.setImage(new Image(startupimg.toURI().toString()));
        imgView.scaleXProperty();
        imgView.scaleYProperty();
//        test.add(new Leerling("0001", "Joske Vermeulen", new File("src/images/GastonPng.png"), "joske.vermeulen@gmail.com"));
//        test.add(new Leerling("0002", "Ewout Ghysbrecht", new File("src/images/EwoutPng.png"), "ewout.g@hotmail.com"));
//        System.out.println(test.toString());
////        lijst.setItems(FXCollections.observableList(test));//leerling.getAlleLeerlingen() ipv test ofzo
//        System.out.println(lijst.toString());

        lijst.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {

                Leerling geselecteerd = lijst.getSelectionModel().getSelectedItem();
                System.out.println(geselecteerd.getFotoPath().toURI().toString());
                naamLbl.setText(geselecteerd.getNaam());
                nummerLbl.setText("" + geselecteerd.getInschrijvingsNummer());
                emailLbl.setText(geselecteerd.getEmail());
                imgView.setImage(new Image(geselecteerd.getFotoPath().toURI().toString()));
                
            }
        });

    }

    public void zoekOpNummer(ActionEvent event) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/projecten/api/leerlingen/nummer/"+ nummerField.getText());
        System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
        
        Gson gson = new Gson();
        JsonObject jsono = gson.fromJson(target.request(MediaType.APPLICATION_JSON).get(String.class), JsonElement.class).getAsJsonObject();
        System.out.println(jsono.get("naam").getAsString());
        
        naamLbl.setText(jsono.get("naam").toString());
        geselecteerdeLeerling.setInschrijvingsNummer(jsono.get("inschrijvingsNummer").toString());
        nummerLbl.setText(jsono.get("inschrijvingsNummer").toString());
        geselecteerdeLeerling.setNaam(jsono.get("naam").toString());
        emailLbl.setText(jsono.get("email").toString());
        geselecteerdeLeerling.setEmail(jsono.get("email").toString());
        imgView.setImage(new Image(new File("src/images/" + jsono.get("inschrijvingsNummer").getAsString() + ".png").toURI().toString()));
        geselecteerdeLeerling.setFotoPath(new File("src/images/" + jsono.get("inschrijvingsNummer").getAsString() + ".png"));
        dc.setGeselecteerd(geselecteerdeLeerling);
        
        if(naamLbl.getText() != "naam"){
            ok.setDisable(false);
        }
    }
    
    public void zoekAlle(ActionEvent event){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/projecten/api/leerlingen");
    }

    public void veranderScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) zoekenButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void naarOverzichtScherm(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        dc.setOzc(ozc);
        ozc.setDc(dc);
        loader.setLocation(getClass().getResource("OverzichtScherm.fxml"));
        Stage stage = (Stage) zoekenButton.getScene().getWindow();
        loader.setController(dc.getOzc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    
}
