package GUI;

import domein.DomeinController;
import domein.Kleuren;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
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
    private ListView opmerkingenLV;
    
    @FXML
    private Button opslaanButton;
    
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
    private Button pinkerButton;
    @FXML
    private Button owButton;
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
    private Rectangle pinker1, pinker2, pinker3;
    @FXML
    private Rectangle ow1, ow2, ow3;
    @FXML
    private Rectangle voorrang1, voorrang2, voorrang3;
    @FXML
    private Rectangle borden1, borden2, borden3;
    @FXML
    private Rectangle snel1, snel2, snel3;
    @FXML
    private Rectangle autos1, autos2, autos3;
    @FXML
    private Rectangle over1, over2, over3;
    @FXML
    private Rectangle kruis1, kruis2, kruis3;
    @FXML
    private Rectangle l1, l2, l3;
    @FXML
    private Rectangle r1, r2, r3;

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
    private Ellipse linkerPijl;
    @FXML
    private Ellipse rechterPijl;
    @FXML
    private Ellipse onderPijl;
    
    private List<String> lijst = new ArrayList<>();
    
    private List<String> hulpLijst = new ArrayList<>();
    
    private int index;
    
    @FXML
    private TextField lelijkaard;
    @FXML
    private Button okButton;
    
    private Scene scene;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        naamLbl.setText(dc.getGeselecteerd().getNaam());
//        lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(0).getOpmerkingen());
kleurStuur();
        vierkantjes.clear();
        vulOp();
        
        initKleurEva1();
        initKleurEva2();
        initKleurEva3();
        
        
    }
    
    public void veranderKnoppen(ActionEvent event) throws IOException {
        
        List<String> comboLijst = new ArrayList<>();
        combo.setItems(FXCollections.observableArrayList(comboLijst));
        if (event.getSource() == pinkerButton) {
            index = 0;
            comboLijst.add("Dosering");
            comboLijst.add("Volgorde");
            comboLijst.add("Te laat");
            comboLijst.add("Remmen op motor");
            System.out.println(comboLijst.get(0));
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            wijzer.setRotate(280);
            titel.setText("Remmen");
            setNummerVierkant(0);
            lijst = dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(0).getOpmerkingen() ;
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
            hulpLijst.clear();
        }
        if (event.getSource() == owButton) {
            index = 1;
            System.out.println(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(1).getOpmerkingen());
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Dosering");
            comboLijst.add("Houding");
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(1).getOpmerkingen();
            wijzer.setRotate(315);
            titel.setText("Sturen");
            setNummerVierkant(3);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == voorrangButton) {
            index = 2;
            hulpLijst.clear();
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Bediening");
            comboLijst.add("Aangepaste versnelling");
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(2).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(0);
            titel.setText("Schakelen");
            setNummerVierkant(6);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == bordenButton) {
            index = 3;
            hulpLijst.clear();
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Ver/dichtbij");
            comboLijst.add("Meer vegewissen");
            comboLijst.add("Dode hoeken");
            comboLijst.add("Scannen/selecteren");
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(3).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(45);
            titel.setText("Kijken");
            setNummerVierkant(9);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == snelheidButton) {
            index = 4;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Tussen 2 voertuigen");
            comboLijst.add("Achter een voertuig");
            comboLijst.add("Links");
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(4).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(80);
            titel.setText("Parkeren");
            setNummerVierkant(12);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == autosButton) {
            index = 5;
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(5).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(100);
            titel.setText("Keren");
            setNummerVierkant(15);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == overgaanButton) {
            index = 6;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("In 1 beweging");
            comboLijst.add("In 3 bewegingen");
            comboLijst.add("Achterwaarts");
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(6).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(135);
            titel.setText("Garage");
            setNummerVierkant(18);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == kruisenButton) {
            index = 7;
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(7).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(180);
            titel.setText("Achterwaarts rijden");
            setNummerVierkant(21);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == linksButton) {
            index = 8;
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(8).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(225);
            titel.setText("Bochten");
            setNummerVierkant(24);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
        }
        if (event.getSource() == rechtsButton) {
            index = 9;
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Balanceren");
            comboLijst.add("Aanzetten met voetrem");
            comboLijst.add("Aanzetten met handrem");
            combo.setItems(FXCollections.observableArrayList(comboLijst));
            lijst = FXCollections.observableArrayList(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(9).getOpmerkingen());
            hulpLijst.addAll(lijst);
            wijzer.setRotate(260);
            titel.setText("Vertrekken op een helling");
            setNummerVierkant(27);
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
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
        dc.setStuurtechniekenScene(this.scene);
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
        dc.setStuurtechniekenScene(this.scene);
    }

    public void comboNaarTextArea(ActionEvent event) throws IOException {
        String tekst;
        txtArea.setText(txtArea.getText() + "\n");
    }

    public void selecteerUitCombo(ActionEvent event) throws IOException {
        if(combo.getItems().size()!=0){
        lijst = opmerkingenLV.getItems();
        lijst.add(combo.getSelectionModel().getSelectedItem().toString());
        opmerkingenLV.setItems(FXCollections.observableList(lijst));
        }
    }

    public void vulOp(){
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
            dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(index).setKleur(Kleuren.ROOD);
            System.out.println(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(index));
            dc.getEvaluatieMatthias().getEvaLijst().get(eva).getVerkeerstechniekOnderdelen().get(index).setKleur(Kleuren.ROOD);
            
        } else if (event.getSource() == oranje) {
            vierkantjes.get(eva + (index*3)).setFill(Color.web(Kleuren.ORANJE.getHexValue(),1.0));
            dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(index).setKleur(Kleuren.ORANJE);
            dc.getEvaluatieMatthias().getEvaLijst().get(eva).getVerkeerstechniekOnderdelen().get(index).setKleur(Kleuren.ORANJE);
        } else if (event.getSource() == groen) {
            vierkantjes.get(eva+(index*3)).setFill(Color.web(Kleuren.GROEN.getHexValue(),1.0));
            dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(index).setKleur(Kleuren.GROEN);
            dc.getEvaluatieMatthias().getEvaLijst().get(eva).getVerkeerstechniekOnderdelen().get(index).setKleur(Kleuren.GROEN);
        }
        kleurStuur();
    }

    public void setNummerVierkant(int nummerVierkant) {
        this.nummerVierkant = nummerVierkant;
    }

    public int getNummerVierkant() {
        return nummerVierkant;
    }

    public void wijzigingenOpslaan(ActionEvent e) throws IOException {
        dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(index).setOpmerkingen(opmerkingenLV.getItems());
        System.out.println(opmerkingenLV.getItems());
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
        for(int counter = 0;counter<=27;counter = counter+3){
            vierkantjes.get(counter).setFill(Color.web(dc.getEvaluatieMatthias().getEvaLijst().get(0).getVerkeerstechniekOnderdelen().get(i).getKleur().getHexValue()));
            i++;
        }
    }
    
    public void initKleurEva2(){
        int i=0;
        for(int counter = 1;counter<=28;counter = counter+3){
            vierkantjes.get(counter).setFill(Color.web(dc.getEvaluatieMatthias().getEvaLijst().get(1).getVerkeerstechniekOnderdelen().get(i).getKleur().getHexValue()));
            i++;
        }
    }
    
    public void initKleurEva3(){
        int i=0;
        for(int counter = 2;counter<=29;counter = counter+3){
            vierkantjes.get(counter).setFill(Color.web(dc.getEvaluatieMatthias().getEvaLijst().get(2).getVerkeerstechniekOnderdelen().get(i).getKleur().getHexValue()));
            i++;
        }
    }
    
    public void addFromLelijkaard(ActionEvent event) throws IOException{
        if(!lelijkaard.getText().isEmpty()&&lelijkaard.getText()!=""){
            lijst.add(lelijkaard.getText());
            opmerkingenLV.setItems(FXCollections.observableArrayList(lijst));
            lelijkaard.clear();
        }
    }
        public void addAlgemeneOpmerking(ActionEvent event) throws IOException{
        dc.getEvaluatieMatthias().setAlgemeneOpmerkingen(dc.getEvaluatieMatthias().getAlgemeneOpmerkingen()+"\n"+lelijkaard.getText());
    }
        
     public void kleurStuur(){
//         1. GROEP 1: richting aangeven, kruisen, inhalen
//          2. GROEP 2: plaats op de OW, links afslaan, rechts afslaan,
//          volgafstand/zijdelingse afstand
//          3. GROEP 3: voorrang, verkeerstekens en snelheid
        //bovenkant
        if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(0).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(6).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(7).getKleur().getHexValue()=="#FF0000")
        {
            linkerPijl.setFill(Color.web("#FF0000"));
            dc.setLinkerPijl(Kleuren.ROOD);
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(0).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(6).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(7).getKleur().getHexValue()=="#FFA500")
        {
            linkerPijl.setFill(Color.web("#FFA500"));
            dc.setLinkerPijl(Kleuren.ORANJE);
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(0).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(6).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(7).getKleur().getHexValue()=="#00FF00")
        {
            linkerPijl.setFill(Color.web("#00FF00"));
            dc.setLinkerPijl(Kleuren.GROEN);
            
            
        }else{
            linkerPijl.setFill(Color.web("#FFFFFF"));
            dc.setLinkerPijl(Kleuren.WIT);
        }
        //rechter
        if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(1).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(5).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(8).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(9).getKleur().getHexValue()=="#FF0000")
        {
            rechterPijl.setFill(Color.web("#FF0000"));
            dc.setRechterPijl(Kleuren.ROOD);
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(1).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(5).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(8).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(9).getKleur().getHexValue()=="#FFA500")
        {
            rechterPijl.setFill(Color.web("#FFA500"));
            dc.setRechterPijl(Kleuren.ORANJE);
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(1).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(5).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(8).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(9).getKleur().getHexValue()=="#00FF00")
        {
            rechterPijl.setFill(Color.web("#00FF00"));
            dc.setRechterPijl(Kleuren.GROEN);
            
            
        }else{
            rechterPijl.setFill(Color.web("#FFFFFF"));
            dc.setRechterPijl(Kleuren.WIT);
        }
        //linker
        if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(2).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(3).getKleur().getHexValue()=="#FF0000"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(4).getKleur().getHexValue()=="#FF0000")
        {
            onderPijl.setFill(Color.web("#FF0000"));
            dc.setOnderPijl(Kleuren.ROOD);
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(2).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(3).getKleur().getHexValue()=="#FFA500"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(4).getKleur().getHexValue()=="#FFA500")
        {
            onderPijl.setFill(Color.web("#FFA500"));
            dc.setOnderPijl(Kleuren.ORANJE);
            
        }else if(dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(2).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(3).getKleur().getHexValue()=="#00FF00"
                ||dc.getEvaluatieMatthias().getHuidigeEva().getVerkeerstechniekOnderdelen().get(4).getKleur().getHexValue()=="#00FF00")
        {
            onderPijl.setFill(Color.web("#00FF00"));
            dc.setOnderPijl(Kleuren.GROEN);
            
            
        }else{
            onderPijl.setFill(Color.web("#FFFFFF"));
            dc.setOnderPijl(Kleuren.WIT);
        }
     }
}
