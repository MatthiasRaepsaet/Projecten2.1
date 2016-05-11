package GUI;

import domein.DomeinController;
import domein.Kleuren;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RijtechniekSchermController implements Initializable {

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
    @FXML
    private TextArea tekstVeld;

    private List<String> textAreaLijst = new ArrayList<>(36);

    @FXML
    private Button overzichtButton;
    @FXML
    private Button infoButton;
    @FXML
    private Button remButton;
    @FXML
    private Button stuurButton;
    @FXML
    private Button schakelButton;
    @FXML
    private Button kijkButton;
    @FXML
    private Button parkeerButton;
    @FXML
    private Button kerenButton;
    @FXML
    private Button garageButton;
    @FXML
    private Button achteruitButton;
    @FXML
    private Button bochtenButton;
    @FXML
    private Button hellingButton;
    @FXML
    private Button zittenButton;
    @FXML
    private Button embreageButton;

    @FXML
    private Rectangle remmen1, remmen2, remmen3;
    @FXML
    private Rectangle sturen1, sturen2, sturen3;
    @FXML
    private Rectangle schakelen1, schakelen2, schakelen3;
    @FXML
    private Rectangle kijk1, kijk2, kijk3;
    @FXML
    private Rectangle parkeer1, parkeer2, parkeer3;
    @FXML
    private Rectangle keren1, keren2, keren3;
    @FXML
    private Rectangle garage1, garage2, garage3;
    @FXML
    private Rectangle achteruit1, achteruit2, achteruit3;
    @FXML
    private Rectangle bocht1, bocht2, bocht3;
    @FXML
    private Rectangle helling1, helling2, helling3;
    @FXML
    private Rectangle zit1, zit2, zit3;
    @FXML
    private Rectangle embreage1, embreage2, embreage3;

    private int nummerVierkant = 0;

    private List<Rectangle> vierkantjes = new ArrayList<>();

    @FXML
    private Rectangle wijzer;

    @FXML
    private Text titel;

    @FXML
    private ComboBox combo;

    @FXML
    private Text naamLbl;
    
    @FXML
    private Ellipse boven;
    @FXML
    private Ellipse linker;
    @FXML
    private Ellipse rechter;
    
    private ObservableList<String> lijst;
    
    private List<String> hulpLijst = new ArrayList<>();
    
    private int index;
    
    private Scene scene;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        naamLbl.setText(dc.getGeselecteerd().getNaam());
        System.out.println(dc.getEvaluatieMatthias().getEvaLijst().get(1)+" 1");
        System.out.println(dc.getEvaluatieMatthias().getEvaLijst().get(1).getRijtechniekOnderdelen()+" 2");
        dc.getEvaluatieMatthias().getEvaLijst().get(1).getRijtechniekOnderdelen().get(0).getOpmerkingen().add("zithouding niet goed");
        dc.getEvaluatieMatthias().getEvaLijst().get(0).getRijtechniekOnderdelen().get(1).getOpmerkingen().add("te snel");
        lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(0).getOpmerkingen());
        vulOp();
        
        initKleurEva1();
        initKleurEva2();
        initKleurEva3();
        
        kleurStuur();
    }
    
    public void voegOpmerkingToe(ActionEvent event) throws IOException {
        ObservableList<String> comboLijst;
        tekstVeld.clear();
        hulpLijst.clear();
        combo.getSelectionModel().clearSelection();
        if (event.getSource() == remButton) {
            index = 2;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Dosering");
            comboLijst.add("Volgorde");
            comboLijst.add("Te laat");
            comboLijst.add("Remmen op motor");
            combo.setItems(comboLijst);
            hulpLijst = dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(2).getOpmerkingen();
            wijzer.setRotate(345);
            titel.setText("Remmen");
            setNummerVierkant(0);
            vanLijstNaarTextArea(hulpLijst);
        }
        if (event.getSource() == stuurButton) {
            index = 3;
            hulpLijst.clear();
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Dosering");
            comboLijst.add("Houding");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(3).getOpmerkingen());
            wijzer.setRotate(15);
            titel.setText("Sturen");
            setNummerVierkant(3);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == schakelButton) {
            index = 4;
            hulpLijst.clear();
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Bediening");
            comboLijst.add("Aangepaste versnelling");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(4).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(45);
            titel.setText("Schakelen");
            setNummerVierkant(6);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == kijkButton) {
            index = 5;
            hulpLijst.clear();
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Ver/dichtbij");
            comboLijst.add("Meer vegewissen");
            comboLijst.add("Dode hoeken");
            comboLijst.add("Scannen/selecteren");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(5).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(75);
            titel.setText("Kijken");
            setNummerVierkant(9);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == parkeerButton) {
            index = 6;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Tussen 2 voertuigen");
            comboLijst.add("Achter een voertuig");
            comboLijst.add("Links");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(6).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(105);
            titel.setText("Parkeren");
            setNummerVierkant(12);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == kerenButton) {
            index = 7;
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(7).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(135);
            titel.setText("Keren");
            setNummerVierkant(15);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == garageButton) {
            index = 8;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("In 1 beweging");
            comboLijst.add("In 3 bewegingen");
            comboLijst.add("Achterwaarts");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(8).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(155);
            titel.setText("Garage");
            setNummerVierkant(18);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == achteruitButton) {
            index = 9;
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(9).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(205);
            titel.setText("Achterwaarts rijden");
            setNummerVierkant(21);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == bochtenButton) {
            index = 10;
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(10).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(235);
            titel.setText("Bochten");
            setNummerVierkant(24);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == hellingButton) {
            index = 11;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Balanceren");
            comboLijst.add("Aanzetten met voetrem");
            comboLijst.add("Aanzetten met handrem");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(11).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(255);
            titel.setText("Vertrekken op een helling");
            setNummerVierkant(27);
            vanLijstNaarTextArea(lijst);
        }
        if (event.getSource() == zittenButton) {
            index = 0;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Zithouding");
            comboLijst.add("Gordel");
            comboLijst.add("Spiegels");
            comboLijst.add("Handrem");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(0).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(285);
            titel.setText("Zithouding");
            setNummerVierkant(30);
            vanLijstNaarTextArea(hulpLijst);
        }
        if (event.getSource() == embreageButton) {
            index = 1;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Dosering");
            comboLijst.add("Volledig");
            comboLijst.add("Plaatsing voet");
            comboLijst.add("Onnodig");
            comboLijst.add("Bocht");
            combo.setItems(comboLijst);
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(1).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(315);
            titel.setText("Ontkoppeling");
            setNummerVierkant(33);
            vanLijstNaarTextArea(hulpLijst);
        }
    }

    @FXML
    private void naarOverzichtScherm(ActionEvent event) throws IOException {
        vierkantjes.clear();
        vulOp();
        Stage stage = (Stage) overzichtButton.getScene().getWindow();
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
        this.scene=overzichtButton.getScene();
        dc.setRijtechniekenScene(this.scene);
    }

    public void naarInfoScherm(ActionEvent event) throws IOException {
        vierkantjes.clear();
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
        this.scene=infoButton.getScene();
        dc.setRijtechniekenScene(this.scene);
    }

    public void comboNaarTextArea(ActionEvent event) throws IOException {
        String tekst;
        txtArea.setText(txtArea.getText() + "\n");
    }

    public void selecteerUitCombo(ActionEvent event) throws IOException {
        String toevoeg =  "\n" + combo.getSelectionModel().getSelectedItem().toString() + "\n";
        
        tekstVeld.appendText(toevoeg);
        hulpLijst.add(combo.getSelectionModel().getSelectedItem().toString());
        
        
    }

    public void vulOp(){
        vierkantjes.add(zit1);
        vierkantjes.add(zit2);
        vierkantjes.add(zit3);
        vierkantjes.add(embreage1);
        vierkantjes.add(embreage2);
        vierkantjes.add(embreage3);
        vierkantjes.add(remmen1);
        vierkantjes.add(remmen2);
        vierkantjes.add(remmen3);
        vierkantjes.add(sturen1);
        vierkantjes.add(sturen2);
        vierkantjes.add(sturen3);
        vierkantjes.add(schakelen1);
        vierkantjes.add(schakelen2);
        vierkantjes.add(schakelen3);
        vierkantjes.add(kijk1);
        vierkantjes.add(kijk2);
        vierkantjes.add(kijk3);
        vierkantjes.add(parkeer1);
        vierkantjes.add(parkeer2);
        vierkantjes.add(parkeer3);
        vierkantjes.add(keren1);
        vierkantjes.add(keren2);
        vierkantjes.add(keren3);
        vierkantjes.add(garage1);
        vierkantjes.add(garage2);
        vierkantjes.add(garage3);
        vierkantjes.add(achteruit1);
        vierkantjes.add(achteruit2);
        vierkantjes.add(achteruit3);
        vierkantjes.add(bocht1);
        vierkantjes.add(bocht2);
        vierkantjes.add(bocht3);
        vierkantjes.add(helling1);
        vierkantjes.add(helling2);
        vierkantjes.add(helling3);
    }
    

    public void veranderKleur(ActionEvent event) throws IOException {
        System.out.println(vierkantjes);
        int eva = 0;//moet uit vorig scherm komen dit is eva1=0 eva2=1 eva3=2
        if(dc.getEvaluatieMatthias().getHuidigeEva().getNaam().equals("eva1"))
            eva = 0;
        if(dc.getEvaluatieMatthias().getHuidigeEva().getNaam().equals("eva2"))
            eva = 1;
        if(dc.getEvaluatieMatthias().getHuidigeEva().getNaam().equals("eva3"))
            eva = 2;
        if (event.getSource() == rood) {
            vierkantjes.get(eva + (index*3)).setFill(Color.web(Kleuren.ROOD.getHexValue(),1.0));
            dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(index).setKleur(Kleuren.ROOD);
            dc.getEvaluatieMatthias().getEvaLijst().get(eva).getRijtechniekOnderdelen().get(index).setKleur(Kleuren.ROOD);
        } else if (event.getSource() == oranje) {
            vierkantjes.get(eva + (index*3)).setFill(Color.web(Kleuren.ORANJE.getHexValue(),1.0));
            dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(index).setKleur(Kleuren.ORANJE);
            dc.getEvaluatieMatthias().getEvaLijst().get(eva).getRijtechniekOnderdelen().get(index).setKleur(Kleuren.ORANJE);
        } else if (event.getSource() == groen) {
            vierkantjes.get(eva+(index*3)).setFill(Color.web(Kleuren.GROEN.getHexValue(),1.0));
            dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(index).setKleur(Kleuren.GROEN);
            dc.getEvaluatieMatthias().getEvaLijst().get(eva).getRijtechniekOnderdelen().get(index).setKleur(Kleuren.GROEN);
        }
        kleurStuur();
    }

    public void setNummerVierkant(int nummerVierkant) {
        this.nummerVierkant = nummerVierkant;
    }

    public int getNummerVierkant() {
        return nummerVierkant;
    }

    public void wijzigigenOpslaan(ActionEvent e) throws IOException {
        dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(index).setOpmerkingen(hulpLijst);
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
    
    public void initKleurEva1(){
        int i=0;
        for(int counter = 0;counter<=33;counter = counter+3){
            vierkantjes.get(counter).setFill(Color.web(dc.getEvaluatieMatthias().getEvaLijst().get(0).getRijtechniekOnderdelen().get(i).getKleur().getHexValue()));
            i++;
        }
    }
    
    public void initKleurEva2(){
        int i=0;
        for(int counter = 1;counter<=34;counter = counter+3){
            vierkantjes.get(counter).setFill(Color.web(dc.getEvaluatieMatthias().getEvaLijst().get(1).getRijtechniekOnderdelen().get(i).getKleur().getHexValue()));
            i++;
        }
    }
    
    public void initKleurEva3(){
        int i=0;
        for(int counter = 2;counter<=35;counter = counter+3){
            vierkantjes.get(counter).setFill(Color.web(dc.getEvaluatieMatthias().getEvaLijst().get(2).getRijtechniekOnderdelen().get(i).getKleur().getHexValue()));
            i++;
        }
    }
    public void kleurStuur(){
        //bovenkant
        if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(0).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(1).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(2).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(3).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(4).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(5).getKleur().getHexValue()=="#FF0000")
        {
            boven.setFill(Color.web("#FF0000"));
            dc.getOzc().setKleurTopStuur("#FF0000");
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(0).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(1).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(2).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(3).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(4).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(5).getKleur().getHexValue()=="#FFA500")
        {
            boven.setFill(Color.web("#FFA500"));
            dc.getOzc().setKleurTopStuur("#FFA500");
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(0).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(1).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(2).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(3).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(4).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(5).getKleur().getHexValue()=="#00FF00")
        {
            boven.setFill(Color.web("#00FF00"));
            dc.getOzc().setKleurTopStuur("#00FF00");
            
            
        }else{
            boven.setFill(Color.web("#FFFFFF"));
            dc.getOzc().setKleurTopStuur("#FFFFFF");
        }
        //rechter
        if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(6).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(7).getKleur().getHexValue()=="#FF0000")
        {
            rechter.setFill(Color.web("#FF0000"));
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(6).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(7).getKleur().getHexValue()=="#FFA500")
        {
            rechter.setFill(Color.web("#FFA500"));
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(6).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(7).getKleur().getHexValue()=="#00FF00")
        {
            rechter.setFill(Color.web("#00FF00"));
            
            
        }else{
            rechter.setFill(Color.web("#FFFFFF"));
        }
        //linker
        if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(8).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(9).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(10).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(11).getKleur().getHexValue()=="#FF0000")
        {
            linker.setFill(Color.web("#FF0000"));
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(8).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(9).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(10).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(11).getKleur().getHexValue()=="#FFA500")
        {
            linker.setFill(Color.web("#FFA500"));
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(8).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(9).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(10).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getRijtechniekOnderdelen().get(11).getKleur().getHexValue()=="#00FF00")
        {
            linker.setFill(Color.web("#00FF00"));
            
            
        }else{
            linker.setFill(Color.web("#FFFFFF"));
        }
    }
}
