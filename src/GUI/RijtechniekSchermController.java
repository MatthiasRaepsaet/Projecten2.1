
package GUI;

import domein.DomeinController;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RijtechniekSchermController{
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
    private Rectangle wijzer;

    @FXML
    private Text titel;
    
    @FXML
    private TextArea txtArea;
    
    @FXML
    private ComboBox combo;
    
    private ObservableList<String> lijst = FXCollections.observableArrayList();
    
    @FXML
    private void naarOverzichtScherm(ActionEvent event) throws IOException{
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
    
    public void naarInfoScherm(ActionEvent event) throws IOException{
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
    
    public void comboNaarTextArea(ActionEvent event) throws IOException{
        String tekst;
        txtArea.setText(txtArea.getText()+"\n" );
    }
    
    public void voegOpmerkingToe(ActionEvent event)throws IOException{
        ObservableList<String> comboLijst;
        if (event.getSource() == remButton) {
            comboLijst=FXCollections.observableArrayList();
            comboLijst.add("Bruusk remmen");
            comboLijst.add("Te laat remmen");
            comboLijst.add("Remmen met verkeerde voet");
            comboLijst.add("Ontkoppeling induwen tijdens het remmen");
            combo.setItems(comboLijst);
            
            wijzer.setRotate(345);
            titel.setText("Remmen");
        }
        if (event.getSource() == stuurButton) {
            comboLijst=FXCollections.observableArrayList();
            comboLijst.add("Teveel correctie nodig");
            comboLijst.add("Te bruusk");
            comboLijst.add("Handen fout plaatsen");
            comboLijst.add("Niet met een hoek van 45°");
            combo.setItems(comboLijst);
            
            wijzer.setRotate(15);
            titel.setText("Sturen");
        }
        if (event.getSource() == schakelButton) {
            wijzer.setRotate(45);
            titel.setText("Schakelen");
        }
        if (event.getSource() == kijkButton) {
            wijzer.setRotate(75);
            titel.setText("Kijken");
        }
        if (event.getSource() == parkeerButton) {
            wijzer.setRotate(105);
            titel.setText("Parkeren");
        }
        if (event.getSource() == kerenButton) {
            wijzer.setRotate(135);
            titel.setText("Keren");
        }
        if (event.getSource() == garageButton) {
            wijzer.setRotate(155);
            titel.setText("Garage");
        }
        if (event.getSource() == achteruitButton) {
            wijzer.setRotate(205);
            titel.setText("Achterwaarts rijden");
        }
        if (event.getSource() == bochtenButton) {
            wijzer.setRotate(235);
            titel.setText("Bochten");
        }
        if (event.getSource() == hellingButton) {
            wijzer.setRotate(255);
            titel.setText("Vertrekken op een helling");
        }
        if (event.getSource() == zittenButton) {
            wijzer.setRotate(285);
            titel.setText("Zithouding");
        }
        if (event.getSource() == embreageButton) {
            wijzer.setRotate(315);
            titel.setText("Ontkoppeling");
        }
    }
}
