/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.DomeinController;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
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
    private Label naamLbl;

//    @FXML
//    private Checkbox eva1Check;
//    @FXML
//    private Checkbox eva2Check;
//    @FXML
//    private Checkbox eva3Check;
    @FXML
    private Button infoButton;

    @FXML
    private Button plus;

    @FXML
    private Button min;

    @FXML
    private Button attitudeButton;

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
        
        naamLbl.setText(dc.getGeselecteerd().getNaam());
        imgView.setImage(new Image(dc.getGeselecteerd().getFotoPath().toURI().toString()));
        schakelaarButton.setBackground(standaardBackground);
        vloeistoffenButton.setBackground(standaardBackground);
        bandenButton.setBackground(standaardBackground);

        stopButton.setBackground(standaardBackground);
        tankenButton.setBackground(standaardBackground);
        gpsButton.setBackground(standaardBackground);

    }

//    public OverzichtSchermController(Button schakelaarButton, Button vloeistoffenButton, Button bandenButton, Button stopButton, Button tankenButton, Button gpsButton) {
//        this.schakelaarButton = schakelaarButton;
//        this.vloeistoffenButton = vloeistoffenButton;
//        this.bandenButton = bandenButton;
//        this.stopButton = stopButton;
//        this.tankenButton = tankenButton;
//        this.gpsButton = gpsButton;
////        schakelaarButton.setBackground(standaarBackground);
////        vloeistoffenButton.setBackground(standaarBackground);
////        bandenButton.setBackground(standaarBackground);
////        
////        tankenButton.setBackground(standaarBackground);
////        gpsButton.setBackground(standaarBackground);
////        stopButton.setBackground(standaarBackground);
//    }
    public void veranderBol(ActionEvent event) throws IOException {
        Circle dezeBol = null;
        if (event.getSource() == rotondeButton) {
            dezeBol = bol1;
        }
        if (event.getSource() == rijbaanButton) {
            dezeBol = bol2;
        }
        if (event.getSource() == stadButton) {
            dezeBol = bol3;
        }
        if (event.getSource() == autostradeButton) {
            dezeBol = bol4;
        }
        if (dezeBol.getFill() == Color.WHITE) {
            dezeBol.setFill(Color.RED);
        } else if (dezeBol.getFill() == Color.RED) {
            dezeBol.setFill(Color.ORANGE);
        } else if (dezeBol.getFill() == Color.ORANGE) {
            dezeBol.setFill(Color.GREEN);
        } else {
            dezeBol.setFill(Color.WHITE);
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
        Parent root = FXMLLoader.load(getClass().getResource("InfoScherm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void plusProgress(ActionEvent event) throws IOException {
        if (progress.getProgress() < 1) {
            progress.setProgress(progress.getProgress() + 0.08);
            tekstProgress(event);
        }
    }

    public void minProgress(ActionEvent event) throws IOException {
        if (progress.getProgress() > 0.0) {
            progress.setProgress(progress.getProgress() - 0.08);
            tekstProgress(event);
        }
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
        Parent root = FXMLLoader.load(getClass().getResource("AttitudeScherm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void naarLogOutScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) attitudeButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
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
