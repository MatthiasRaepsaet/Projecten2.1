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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ewout
 */
public class InfoSchermController implements Initializable {
    
    DomeinController dc;
    
    private OverzichtSchermController ozc;

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
    
    
    @FXML
    private Button naarOverzichtSchermButton;
    
    @FXML
    private Text tekst;
    
    //eerste rij
    @FXML
    private Button rotondeButton;
    @FXML
    private Button rijbaanButton;
    @FXML
    private Button stadButton;
    @FXML
    private Button autostradeButton;
    @FXML
    private Button attitudeButton;
    
    //tweede rij
    @FXML
    private Button schakelaarButton;
    @FXML
    private Button vloeistoffenButton;
    @FXML
    private Button bandenButton;
     @FXML
    private Button tankenButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button gpsButton;
       
    //3rde rij
    @FXML
    private Button stuurtechniekButton;
    @FXML
    private Button rijtechniekButton;
    
    //4de
    @FXML
    private Button owButton;
    @FXML
    private Button voorrangButton;
    @FXML
    private Button bordenButton;
    @FXML
    private Button pinkersButton;
    @FXML
    private Button overgaanButton;
    @FXML
    private Button autosButton;
    @FXML
    private Button linksButton;
    @FXML
    private Button kruisenButton;
    @FXML
    private Button rechtsButton;
    @FXML
    private Button snelheidButton;
    
    //5de
    @FXML
    private Button stuurButton;
    @FXML
    private Button schakelButton;
    @FXML
    private Button kijkTechniekButton;
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
    private Button remButton;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    public void vorigScherm(ActionEvent event) throws IOException{
        Stage stage = (Stage) naarOverzichtSchermButton.getScene().getWindow();
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
      
    public void schrijfTekst(ActionEvent event) throws IOException{
        if(event.getSource()==rotondeButton){
            tekst.setText("Dit is de rotonde/plein knop:"+"\nJe kan hiermee aangeven of de leerling het rijden op een plein of rotonde al onder de knie heeft.");
        }
        if(event.getSource()==rijbaanButton){
            tekst.setText("Dit is de rijbaan met rijstroken knop:"+"\nJe kan hiermee aangeven of de leerling het rijden op een rijbaan met meerdere rijstroken al onder de knie heeft.");
        }
        if(event.getSource()==stadButton){
            tekst.setText("Dit is de stad knop:"+"\nJe kan hiermee aangeven of de leerling het rijden in een stad al onder de knie heeft.");
        }
        if(event.getSource()==autostradeButton){
            tekst.setText("Dit is de autostrade knop:"+"\nJe kan hiermee aangeven of de leerling het rijden op een snelweg al onder de knie heeft.");
        }
        if(event.getSource()==attitudeButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je de attitude van je leerling kan aanduiden.");
        }
        if(event.getSource()==schakelaarButton){
            tekst.setText("Dit is de schakelaars knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==vloeistoffenButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==bandenButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==tankenButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==stopButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==gpsButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==rijtechniekButton){
            tekst.setText("Dit is de verkeerstechniek knop:"+"\nJe gaat hiermee naar het verkeerstechniekscherm waar je de leerling kan evalueren.");
        }
        if(event.getSource()==stuurtechniekButton){
            tekst.setText("Dit is de rijtechniek knop:"+"\nJe gaat hiermee naar het rijtechniekscherm waar je de leerling verder kan evalueren.");
        }
        if(event.getSource()==snelheidButton){
            tekst.setText("Dit is de snelheids knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==owButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==voorrangButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==bordenButton){
            tekst.setText("Dit is de verkeersborden knop:"+"\nJe kan hiermee aangeven of de leerling een goede kennis heeft van alle verkeersborden.");
        }
        if(event.getSource()==pinkersButton){
            tekst.setText("Dit is de richtingsaanwijzers knop:"+"\nJe kan hiermee aangeven of de leerling zijn richtingsaanwijzers reeds juist gebruikt.");
        }
        if(event.getSource()==overgaanButton){
            tekst.setText("Dit is de auto's overgaan knop:"+"\nJe kan hiermee aangeven of de leerling juist auto's kan overgaan.");
        }
        if(event.getSource()==autosButton){
            tekst.setText("Dit is de attitude knop:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
        if(event.getSource()==linksButton){
            tekst.setText("Dit is de links knop:"+"\nJe kan hiermee aangeven of de leerling reeds goed naar links kan afdraaien.");
        }
        if(event.getSource()==kruisenButton){
            tekst.setText("Dit is de kruisen knop:"+"\nJe kan hiermee aangeven of de leerling andere auto's correct kan kruisen.");
        }
        if(event.getSource()==rechtsButton){
            tekst.setText("Dit is de rechts afdraaien knop:"+"\nJe kan hiermee aangeven of de leerling reeds goed naar rechts kan afdraaien.");
        }
         if(event.getSource()==stuurButton){
            tekst.setText("Dit is de stuurknop:"+"\nJe kan hiermee aangeven of de leerling het stuur reeds goed gebruikt.");
        }
        if(event.getSource()==schakelButton){
            tekst.setText("Dit is de schakel knop:"+"\nJe kan hiermee aangeven of de leerling het schakelen reeds onder de knie heeft.");
        }
        if(event.getSource()==kijkTechniekButton){
            tekst.setText("Dit is de kijktechniek knop:"+"\nJe kan hiermee aangeven of de leerling correct zijn spiegels gebruikt en kijkt voor fietsers.");
        }
        if(event.getSource()==parkeerButton){
            tekst.setText("Dit is de parkeer knop:"+"\nJe kan hiermee aangeven of de leerling reeds kan parkeren op alle verschillende mogelijkheden.");
        }
        if(event.getSource()==kerenButton){
            tekst.setText("Dit is de keren in een straat knop:"+"\nJe kan hiermee aangeven of de leerling het keren in een straat reeds onder de knie heeft.");
        }
        if(event.getSource()==garageButton){
            tekst.setText("Dit is de garage knop:"+"\nJe kan hiermee aangeven of de leerling reeds in een garage kan parkeren.");
        }
        if(event.getSource()==achteruitButton){
            tekst.setText("Dit is de achteruitrij knop:"+"\nJe gaat hiermee aangeven of de leerling het achteruitrijden reeds op de knie heeft.");
        }
        if(event.getSource()==bochtenButton){
            tekst.setText("Dit is de bochten knop:"+"\nJe gaat hiermee aangeven of een leerling een bocht reeds juist kan nemen.");
        }
        if(event.getSource()==hellingButton){
            tekst.setText("Dit is de knop voor het starten op de helling:"+"\nJe gaat hiermee naar een ander scherm waar je");
        }
         if(event.getSource()==zittenButton){
            tekst.setText("Dit is de zithouding knop:"+"\nJe kan hiermee aangeven of je leerling een goede zithouding heeft.");
        }
          if(event.getSource()==embreageButton){
            tekst.setText("Dit is de ontkoppelingsknop:"+"\nJe kan hiermee aangeven of de leerling ontkoppelen al onder de knie heeft.");
        }
           if(event.getSource()==remButton){
            tekst.setText("Dit is de remknop:"+"\nJe kan hiermee aangeven of de leerling remmen al onder de knie heeft.");
        }
    }
    
}
