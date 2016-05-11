/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.Cursus;
import domein.DomeinController;
import domein.Kleuren;
import java.awt.Checkbox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Matthias
 */
public class OverzichtSchermController implements Initializable {

    private DomeinController dc = new DomeinController();

    /**
     * Initializes the controller class.
     */
    //linkse menu
    @FXML
    private Button schakelaarButton;
    @FXML
    private Button vloeistoffenButton;
    @FXML
    private Button bandenButton;

    //bovenste menu
    @FXML
    private Button rotondeButton;
    @FXML
    private Button rijbaanButton;
    @FXML
    private Button stadButton;
    @FXML
    private Button autostradeButton;

    //rechtse menu
    @FXML
    private Button stopButton;
    @FXML
    private Button tankenButton;
    @FXML
    private Button gpsButton;

    //middenste menu
    @FXML
    private Button rijtechniekButton;
    @FXML
    private Button verkeerstechniekButton;

    @FXML
    private Circle bol1;
    @FXML
    private Circle bol2;
    @FXML
    private Circle bol3;
    @FXML
    private Circle bol4;

    @FXML
    private ProgressBar progress;

    @FXML
    private Text text;

    @FXML
    private ImageView imgView;

    @FXML
    private RadioButton radioEva1;

    @FXML
    private RadioButton radioEva2;

    @FXML
    private RadioButton radioEva3;

    @FXML
    private Label naamLbl;

    @FXML
    private Button infoButton;

    @FXML
    private Button plus;

    @FXML
    private Button min;

    @FXML
    private Button attitudeButton;
    
    @FXML
    private Circle bolLinks1;
    @FXML
    private Circle bolLinks2;
    @FXML
    private Circle bolLinks3;
    
    @FXML
    private Circle bolRechts1;
    @FXML
    private Circle bolRechts2;
    @FXML
    private Circle bolRechts3;
    
    @FXML
    private Circle topStuur;
    @FXML
    private Circle linkerStuur;
    @FXML
    private Circle rechterStuur;

    private AttitudeSchermController asc = new AttitudeSchermController();
    private InfoSchermController info = new InfoSchermController();
    private LogoutController logout = new LogoutController();
    private StuurtechniekSchermController stuurtechniek = new StuurtechniekSchermController();
    private RijtechniekSchermController rijtechniek = new RijtechniekSchermController();

    //prefill progress bar
    private Background standaardBackground = new Background(new BackgroundFill(null, new CornerRadii(30), Insets.EMPTY));
    private Background roodBackground = new Background(new BackgroundFill(Color.RED, new CornerRadii(30), Insets.EMPTY));
    private Background oranjeBackground = new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(30), Insets.EMPTY));
    private Background groenBackground = new Background(new BackgroundFill(Color.GREEN, new CornerRadii(30), Insets.EMPTY));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(dc.getEvaluatieMatthias().getHuidigeEva().getNaam());
        evaCheck();
        System.out.println(dc.getEvaluatieMatthias().getRotonde().getHexValue());
        bol1.setFill(Color.web(dc.getEvaluatieMatthias().getRotonde().getHexValue(),1.0));
        bol2.setFill(Color.web(dc.getEvaluatieMatthias().getSteenweg().getHexValue(),1.0));
        bol3.setFill(Color.web(dc.getEvaluatieMatthias().getBebouwdeKom().getHexValue(),1.0));
        bol4.setFill(Color.web(dc.getEvaluatieMatthias().getAutostrade().getHexValue(),1.0));
        bolLinks1.setFill(Color.web(dc.getEvaluatieMatthias().getLinks1().getHexValue(),1.0));
        bolLinks2.setFill(Color.web(dc.getEvaluatieMatthias().getLinks2().getHexValue(),1.0));
        bolLinks3.setFill(Color.web(dc.getEvaluatieMatthias().getLinks3().getHexValue(),1.0));
        bolRechts1.setFill(Color.web(dc.getEvaluatieMatthias().getRechts1().getHexValue(),1.0));
        bolRechts2.setFill(Color.web(dc.getEvaluatieMatthias().getRechts2().getHexValue(),1.0));
        bolRechts3.setFill(Color.web(dc.getEvaluatieMatthias().getRechts3().getHexValue(),1.0));
        
        naamLbl.setText(dc.getGeselecteerd().getNaam());
        imgView.setImage(new Image(dc.getGeselecteerd().getFotoPath().toURI().toString()));
        schakelaarButton.setBackground(standaardBackground);
        vloeistoffenButton.setBackground(standaardBackground);
        bandenButton.setBackground(standaardBackground);

        stopButton.setBackground(standaardBackground);
        tankenButton.setBackground(standaardBackground);
        gpsButton.setBackground(standaardBackground);

        progress.setProgress(dc.getEvaluatieMatthias().getWaardeProgress());
    }


    public void veranderBol(ActionEvent event) throws IOException {
        Circle dezeBol = null;
        String kleur = null;
        Kleuren aux = Kleuren.WIT;
        if (event.getSource() == rotondeButton) {
            dezeBol = bol1;
            kleur = dc.getEvaluatieMatthias().getRotonde().getHexValue();
        }
        if (event.getSource() == rijbaanButton) {
            dezeBol = bol2;
            kleur = dc.getEvaluatieMatthias().getSteenweg().getHexValue();
        }
        if (event.getSource() == stadButton) {
            dezeBol = bol3;
            kleur = dc.getEvaluatieMatthias().getBebouwdeKom().getHexValue();
        }
        if (event.getSource() == autostradeButton) {
            dezeBol = bol4;
            kleur = dc.getEvaluatieMatthias().getAutostrade().getHexValue();
        }
        if(event.getSource() == bandenButton){
            dezeBol = bolLinks1;
            kleur =dc.getEvaluatieMatthias().getLinks1().getHexValue();
        }
        if(event.getSource() == vloeistoffenButton){
            dezeBol = bolLinks2;
            kleur =dc.getEvaluatieMatthias().getLinks2().getHexValue();
        }
        if(event.getSource() == schakelaarButton){
            dezeBol = bolLinks3;
            kleur = dc.getEvaluatieMatthias().getLinks3().getHexValue();
        }
        if(event.getSource() == tankenButton){
            dezeBol = bolRechts1;
            kleur = dc.getEvaluatieMatthias().getRechts1().getHexValue();
        }
        if(event.getSource() == gpsButton){
            dezeBol = bolRechts2;
            kleur = dc.getEvaluatieMatthias().getRechts2().getHexValue();
        }
        if(event.getSource() == stopButton){
            dezeBol = bolRechts3;
            kleur = dc.getEvaluatieMatthias().getRechts3().getHexValue();
        }
        
        if (kleur == "#FFFFFF") {
            kleur = "#FF0000";
//            dc.getCursus().setKleurBol1("#FF0000");
            dezeBol.setFill(Color.web(kleur,1.0));
            aux = Kleuren.ROOD;
        } else if (kleur == "#FF0000") {
            kleur = "#FFA500";
//            dc.getCursus().setKleurBol1("#FFA500");
            dezeBol.setFill(Color.web(kleur,1.0));
            aux = Kleuren.ORANJE;
        } else if (kleur == "#FFA500") {
            kleur = "#00FF00";
//            dc.getCursus().setKleurBol1("#00FF00");
            dezeBol.setFill(Color.web(kleur,1.0));
            aux = Kleuren.GROEN;
        } else{
            kleur = "#FFFFFF";
//            dc.getCursus().setKleurBol1("#FFFFFF");
            dezeBol.setFill(Color.web(kleur,1.0));
            aux = Kleuren.WIT;
        }
        if (event.getSource() == rotondeButton) {
            dezeBol = bol1;
            dc.getEvaluatieMatthias().setRotonde(aux);
        }
        if (event.getSource() == rijbaanButton) {
            dezeBol = bol2;
            dc.getEvaluatieMatthias().setSteenweg(aux);
        }
        if (event.getSource() == stadButton) {
            dezeBol = bol3;
            dc.getEvaluatieMatthias().setBebouwdeKom(aux);
        }
        if (event.getSource() == autostradeButton) {
            dezeBol = bol4;
            dc.getEvaluatieMatthias().setAutostrade(aux);
        }
        if(event.getSource() == bandenButton){
            dc.getEvaluatieMatthias().setLinks1(aux);
        }
        if(event.getSource() == vloeistoffenButton){
            dc.getEvaluatieMatthias().setLinks2(aux);
        }
        if(event.getSource() == schakelaarButton){
            dc.getEvaluatieMatthias().setLinks3(aux);
        }
        if(event.getSource() == tankenButton){
            dc.getEvaluatieMatthias().setRechts1(aux);
        }
        if(event.getSource() == gpsButton){
            dc.getEvaluatieMatthias().setRechts2(aux);
        }
        if(event.getSource() == stopButton){
            dc.getEvaluatieMatthias().setRechts3(aux);
        }
    }

    public void veranderKleur(ActionEvent event) throws IOException {
        Button dezeButton = (Button) event.getSource();
        System.out.println(dezeButton.getStyle());
        if (dezeButton.getBackground() == standaardBackground) {
            dezeButton.setBackground(roodBackground);
            System.out.println("rood");
        } else if (dezeButton.getBackground() == roodBackground) {
            dezeButton.setBackground(oranjeBackground);
            System.out.println("oranje");
        } else if (dezeButton.getBackground() == oranjeBackground) {
            dezeButton.setBackground(groenBackground);
            System.out.println("groen");
        } else if (dezeButton.getBackground() == groenBackground) {
            dezeButton.setBackground(roodBackground);
            System.out.println("rood");
        }
    }

    public void ketKleur(ActionEvent event) throws IOException {
        schakelaarButton.setStyle("-fx-background-radius:30;"
                + "-fx-background-color:'orange'");
    }

    public void naarRijtechniekScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) rijtechniekButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        dc.setRtc(rijtechniek);
        dc.getRtc().setDc(dc);
        loader.setLocation(getClass().getResource("RijtechniekScherm.fxml"));
        loader.setController(dc.getRtc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void naarStuurtechniekScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) schakelaarButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        dc.setStc(stuurtechniek);
        dc.getStc().setDc(dc);
        loader.setLocation(getClass().getResource("StuurtechniekScherm.fxml"));
        loader.setController(dc.getStc());
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

    public void plusProgress(ActionEvent event) throws IOException {
        if (progress.getProgress() < 1) {
            progress.setProgress(progress.getProgress() + 0.08);
            tekstProgress(event);
        }
        dc.getEvaluatieMatthias().setWaardeProgress(progress.getProgress());
    }

    public void minProgress(ActionEvent event) throws IOException {
        if (progress.getProgress() > 0.0) {
            progress.setProgress(progress.getProgress() - 0.08);
            tekstProgress(event);
        }
        dc.getEvaluatieMatthias().setWaardeProgress(progress.getProgress());
    }

    public void tekstProgress(ActionEvent event) throws IOException {
        String bericht;

        if (progress.getProgress() < 0.25) {
            bericht = "";
        } else if (progress.getProgress() >= 0.25 && progress.getProgress() < 0.75) {
            bericht = "NIVEAU B:\n"
                    + "klaar om met een begeleider te oefenen in de\n"
                    + "stageperiode";
        } else if (progress.getProgress() >= 0.92) {
            bericht = "NIVEAU X:\n"
                    + "klaar voor praktisch examen";
        } else {
            bericht = "NIVEAU A:\nklaar om alleen te oefenen in de stageperiode";
        }
        text.setText(bericht);
    }

    public void naarAttitudeScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) attitudeButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        dc.setAsc(asc);
        dc.getAsc().setDc(dc);
        loader.setLocation(getClass().getResource("AttitudeScherm.fxml"));
        loader.setController(dc.getAsc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void naarLogOutScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) imgView.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        dc.setLogoutc(logout);
        dc.getLogoutc().setDc(dc);
        loader.setLocation(getClass().getResource("Logout.fxml"));
        loader.setController(dc.getLogoutc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void evaCheck() {

        System.out.println(dc.getEvaluatieMatthias().getHuidigeEva().getNaam());
        
        if (dc.getEvaluatieMatthias().getHuidigeEva().getNaam().equals("eva1")) {
            radioEva1.setSelected(true);
            radioEva2.setSelected(false);
            radioEva3.setSelected(false);
        }
        if (dc.getEvaluatieMatthias().getHuidigeEva().getNaam().equals("eva2")) {
            radioEva1.setSelected(false);
            radioEva2.setSelected(true);
            radioEva3.setSelected(false);
        }
        if (dc.getEvaluatieMatthias().getHuidigeEva().getNaam().equals("eva3")) {
            radioEva1.setSelected(false);
            radioEva2.setSelected(false);
            radioEva3.setSelected(true);
        }
    }

    public void veranderEva(ActionEvent event) throws IOException {
        if (event.getSource().equals(radioEva1)) {
            dc.getEvaluatieMatthias().setHuidigeEva(dc.getEvaluatieMatthias().getEvaLijst().get(0));
            System.out.println(dc.getEvaluatieMatthias().getHuidigeEva().getNaam());
            evaCheck();
        }
        if (event.getSource().equals(radioEva2)) {
            dc.getEvaluatieMatthias().setHuidigeEva(dc.getEvaluatieMatthias().getEvaLijst().get(1));
            System.out.println(dc.getEvaluatieMatthias().getHuidigeEva().getNaam());
            evaCheck();
        }
        if (event.getSource().equals(radioEva3)) {
            dc.getEvaluatieMatthias().setHuidigeEva(dc.getEvaluatieMatthias().getEvaLijst().get(2));
            System.out.println(dc.getEvaluatieMatthias().getHuidigeEva().getNaam());
            evaCheck();
        }
    }

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
    
    public void kleurStuur(){
        
    }

}
