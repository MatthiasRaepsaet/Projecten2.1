/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import domein.Cursus;
import domein.DomeinController;
import domein.Leerling;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import jdk.nashorn.internal.parser.JSONParser;

public class ZoekLlnSchermController implements Initializable {
    
    private DomeinController dc = new DomeinController();

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
    
    private Cursus cursus;

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
    
    //RijtechniekScherm
    private Map<String, List<String>> rijtechniekOpmerkingenMap = new HashMap<>();
    private Map<String, String> rijtechniekKleurenMap = new HashMap<>();
    private Map<String, Map<String, List<String>>> evaRijtechniekMap = new HashMap<>();
    private Map<String, Map<String, List<String>>> VorigeEvaRijtechniekMap;
    private Map<String, List<String>> evaRijtechniekMap1 = new HashMap<>();
    private Map<String, List<String>> evaRijtechniekMap2 = new HashMap<>();
    private Map<String, List<String>> evaRijtechniekMap3 = new HashMap<>();
    
    //StuurtechniekScherm
    private Map<String, List<String>> stuurtechniekOpmerkingenMap;
    private Map<String, String> stuurtechniekKleurenMap;
    private Map<String, Map<String, List<String>>> evaStuurtechniekMap;
    private Map<String, List<String>> VorigeEvaStuurtechniekMap;
    private Map<String, List<String>> evaStuurtechniekMap1;
    private Map<String, List<String>> evaStuurtechniekMap2;
    private Map<String, List<String>> evaStuurtechniekMap3;
    
    private OverzichtSchermController ozc = new OverzichtSchermController();
    
    private Leerling geselecteerdeLeerling = new Leerling(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        rijtechniekOpmerkingenMap.put("ambreage", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("rem", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("stuur", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("schakelen", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("kijk", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("parkeren", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("keren", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("garage", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("achteruitrijden", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("bochten", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("helling", new ArrayList<>());
        rijtechniekOpmerkingenMap.put("zithouding", new ArrayList<>());

        evaRijtechniekMap1 = rijtechniekOpmerkingenMap;
        evaRijtechniekMap2 = rijtechniekOpmerkingenMap;
        evaRijtechniekMap3 = rijtechniekOpmerkingenMap;
        
        
        rijtechniekKleurenMap.put("ambreage", "#FFFFFF");
        rijtechniekKleurenMap.put("rem", "#FFFFFF");
        rijtechniekKleurenMap.put("stuur", "#FFFFFF");
        rijtechniekKleurenMap.put("schakelen", "#FFFFFF");
        rijtechniekKleurenMap.put("opmerkzaamheid", "#FFFFFF");
        rijtechniekKleurenMap.put("parkeren", "#FFFFFF");
        rijtechniekKleurenMap.put("keren in een straat", "#FFFFFF");
        rijtechniekKleurenMap.put("garage", "#FFFFFF");
        rijtechniekKleurenMap.put("achteruitrijden", "#FFFFFF");
        rijtechniekKleurenMap.put("bochten", "#FFFFFF");
        rijtechniekKleurenMap.put("helling", "#FFFFFF");
        rijtechniekKleurenMap.put("zithouding", "#FFFFFF");
        
        evaRijtechniekMap.put("eva1", evaRijtechniekMap1);
        evaRijtechniekMap.put("eva2", evaRijtechniekMap2);
        evaRijtechniekMap.put("eva3", evaRijtechniekMap3);
        
        evaRijtechniekMap.get("eva1").get("ambreage").add("eva1");
        evaRijtechniekMap.get("eva2").get("ambreage").add("eva2am");
        evaRijtechniekMap.get("eva2").get("rem").add("eva2rem");
        evaRijtechniekMap.get("eva3").get("stuur").add("eva3");
        
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
                dc.setGeselecteerd(geselecteerd);
                
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
        
        geselecteerdeLeerling.setNaam(jsono.get("naam").toString().replaceAll("\"", ""));
        geselecteerdeLeerling.setInschrijvingsNummer(jsono.get("inschrijvingsNummer").toString().replaceAll("\"", ""));
        geselecteerdeLeerling.setFotoPath(new File("src/images/" + jsono.get("inschrijvingsNummer").getAsString() + ".png"));
        geselecteerdeLeerling.setEmail(jsono.get("email").toString().replaceAll("\"", ""));
        dc.setGeselecteerd(geselecteerdeLeerling);
        
        
        naamLbl.setText(geselecteerdeLeerling.getNaam());
        nummerLbl.setText(geselecteerdeLeerling.getInschrijvingsNummer());
        emailLbl.setText(geselecteerdeLeerling.getEmail());
        imgView.setImage(new Image(new File("src/images/" + jsono.get("inschrijvingsNummer").getAsString() + ".png").toURI().toString()));
        
        cursus = new Cursus("1", "#FFFFFF", "#FFFFFF", "#FFFFFF", "#FFFFFF", "rood", "rood", "rood", 0.0, "", null, null, null, null, null, null);
        if(naamLbl.getText() != "naam"){
            ok.setDisable(false);
        }
    }
    
    public void zoekAlle(ActionEvent event){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/projecten/api/leerlingen");
        
        List<Leerling> test = new ArrayList<>();
        
        Gson gson = new Gson();
        JsonArray jsona = gson.fromJson(target.request(MediaType.APPLICATION_JSON).get(String.class), JsonElement.class).getAsJsonArray();
        
        for(int i=0; i<jsona.size();i++)
        {
            JsonObject jsono = jsona.get(i).getAsJsonObject();
            Leerling l = new Leerling(jsono.get("inschrijvingsnummer").getAsString(), jsono.get("naam").getAsString(),null, null); //nullpointer >.<
            test.add(l);
        }
        System.out.println(test.toString());
        lijst.setItems(FXCollections.observableList(test));
        System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
        System.out.println(jsona.toString());
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
        dc.setCursus(cursus);
        ozc.setDc(dc);
        dc.getCursus().setRijtechniekOpmerkingenMap(rijtechniekOpmerkingenMap);
        dc.getCursus().setEvaRijtechniekOpmerkingenMap(evaRijtechniekMap);
        dc.getCursus().setRijtechniekKleurenMap(rijtechniekKleurenMap);
        //System.out.println(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("ambreage"));
        loader.setLocation(getClass().getResource("OverzichtScherm.fxml"));
        Stage stage = (Stage) zoekenButton.getScene().getWindow();
        loader.setController(dc.getOzc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    
}
