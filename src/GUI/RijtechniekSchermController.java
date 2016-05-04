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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
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
    
    private ObservableList<String> lijst = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        naamLbl.setText(dc.getGeselecteerd().getNaam());
    }
    
    public void voegOpmerkingToe(ActionEvent event) throws IOException {
        ObservableList<String> comboLijst;
        tekstVeld.clear();
        if (event.getSource() == remButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Dosering");
            comboLijst.add("Volgorde");
            comboLijst.add("Te laat");
            comboLijst.add("Remmen op motor");
            combo.setItems(comboLijst);

            wijzer.setRotate(345);
            titel.setText("Remmen");
            setNummerVierkant(0);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("rem"));
        }
        if (event.getSource() == stuurButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Dosering");
            comboLijst.add("Houding");
            combo.setItems(comboLijst);

            wijzer.setRotate(15);
            titel.setText("Sturen");
            setNummerVierkant(3);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("stuur"));
        }
        if (event.getSource() == schakelButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Bediening");
            comboLijst.add("Aangepaste versnelling");
            combo.setItems(comboLijst);
            wijzer.setRotate(45);
            titel.setText("Schakelen");
            setNummerVierkant(6);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("schakelen"));
        }
        if (event.getSource() == kijkButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Ver/dichtbij");
            comboLijst.add("Meer vegewissen");
            comboLijst.add("Dode hoeken");
            comboLijst.add("Scannen/selecteren");
            combo.setItems(comboLijst);
            wijzer.setRotate(75);
            titel.setText("Kijken");
            setNummerVierkant(9);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("kijk"));
        }
        if (event.getSource() == parkeerButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Tussen 2 voertuigen");
            comboLijst.add("Achter een voertuig");
            comboLijst.add("Links");
            combo.setItems(comboLijst);
            wijzer.setRotate(105);
            titel.setText("Parkeren");
            setNummerVierkant(12);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("parkeren"));
        }
        if (event.getSource() == kerenButton) {
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(comboLijst);
            wijzer.setRotate(135);
            titel.setText("Keren");
            setNummerVierkant(15);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("keren"));
        }
        if (event.getSource() == garageButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("In 1 beweging");
            comboLijst.add("In 3 bewegingen");
            comboLijst.add("Achterwaarts");
            combo.setItems(comboLijst);
            wijzer.setRotate(155);
            titel.setText("Garage");
            setNummerVierkant(18);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("garage"));
        }
        if (event.getSource() == achteruitButton) {
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(comboLijst);
            wijzer.setRotate(205);
            titel.setText("Achterwaarts rijden");
            setNummerVierkant(21);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("achteruitrijden"));
        }
        if (event.getSource() == bochtenButton) {
            comboLijst = FXCollections.observableArrayList();
            combo.setItems(comboLijst);
            wijzer.setRotate(235);
            titel.setText("Bochten");
            setNummerVierkant(24);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("bochten"));
        }
        if (event.getSource() == hellingButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Balanceren");
            comboLijst.add("Aanzetten met voetrem");
            comboLijst.add("Aanzetten met handrem");
            combo.setItems(comboLijst);
            wijzer.setRotate(255);
            titel.setText("Vertrekken op een helling");
            setNummerVierkant(27);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("helling"));
        }
        if (event.getSource() == zittenButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Zithouding");
            comboLijst.add("Gordel");
            comboLijst.add("Spiegels");
            comboLijst.add("Handrem");
            combo.setItems(comboLijst);
            wijzer.setRotate(285);
            titel.setText("Zithouding");
            setNummerVierkant(30);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("zithouding"));
        }
        if (event.getSource() == embreageButton) {
            comboLijst = FXCollections.observableArrayList();
            comboLijst.add("Dosering");
            comboLijst.add("Volledig");
            comboLijst.add("Plaatsing voet");
            comboLijst.add("Onnodig");
            comboLijst.add("Bocht");
            combo.setItems(comboLijst);
            wijzer.setRotate(315);
            titel.setText("Ontkoppeling");
            setNummerVierkant(33);
            vanLijstNaarTextArea(dc.getCursus().getEvaRijtechniekOpmerkingenMap().get(dc.getCursus().getEvaNummer()).get("ambreage"));
        }
    }

    @FXML
    private void naarOverzichtScherm(ActionEvent event) throws IOException {
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

    public void comboNaarTextArea(ActionEvent event) throws IOException {
        String tekst;
        txtArea.setText(txtArea.getText() + "\n");
    }

    public void selecteerUitCombo(ActionEvent event) throws IOException {
        tekstVeld.setText(tekstVeld.getText() + "\n" + combo.getSelectionModel().getSelectedItem().toString());
    }

    public void vulVierkantjes() {
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
        vierkantjes.add(zit1);
        vierkantjes.add(zit2);
        vierkantjes.add(zit3);
        vierkantjes.add(embreage1);
        vierkantjes.add(embreage2);
        vierkantjes.add(embreage3);
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

}
