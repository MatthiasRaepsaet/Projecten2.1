/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import GUI.AttitudeSchermController;
import GUI.InfoSchermController;
import GUI.LoginController;
import GUI.LogoutController;
import GUI.NieuweLlnSchermController;
import GUI.OverzichtSchermController;
import GUI.RijtechniekSchermController;
import GUI.StuurtechniekSchermController;
import GUI.ZoekLlnSchermController;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;

/**
 *
 * @author ewout
 */
public class DomeinController {
    
    private List<Leerling> leerlingenCache = new ArrayList<>();
    private List<Evaluatie> evaluatiesCache = new ArrayList<>();
    
    private Cursus cursus;
    
    private Evaluatie evaluatieMatthias;
    
    private Leerling geselecteerd;
    private List<Leerling> leerlingen = new ArrayList<>();
    
    private AttitudeSchermController asc;
    private InfoSchermController isc;
    private LoginController loginc;
    private LogoutController logoutc;
    private NieuweLlnSchermController nlc;
    private OverzichtSchermController ozc;
    private RijtechniekSchermController rtc;
    private StuurtechniekSchermController stc;
    private ZoekLlnSchermController zlsc;
    
    private Kleuren boven, links, rechts;
    private Kleuren onderPijl, linkerPijl, rechterPijl;
    
    private Scene overzichtScene;
    private Scene stuurTechniekenScene;
    private Scene rijTechniekenScene;
    private Scene attitudeScene;

    public Kleuren getBoven() {
        return boven;
    }

    public void setBoven(Kleuren boven) {
        this.boven = boven;
    }

    public Kleuren getLinks() {
        return links;
    }

    public void setLinks(Kleuren links) {
        this.links = links;
    }

    public Kleuren getRechts() {
        return rechts;
    }

    public void setRechts(Kleuren rechts) {
        this.rechts = rechts;
    }

    public Kleuren getOnderPijl() {
        return onderPijl;
    }

    public void setOnderPijl(Kleuren onderPijl) {
        this.onderPijl = onderPijl;
    }

    public Kleuren getLinkerPijl() {
        return linkerPijl;
    }

    public void setLinkerPijl(Kleuren linkerPijl) {
        this.linkerPijl = linkerPijl;
    }

    public Kleuren getRechterPijl() {
        return rechterPijl;
    }

    public void setRechterPijl(Kleuren rechterPijl) {
        this.rechterPijl = rechterPijl;
    }
    
    
    
    public DomeinController()
    {
//        leerlingen.add(new Leerling("0001","Joske Vermeulen", new File("src/images/GastonPng.png"),"joske.vermeulen@gmail.com"));
//        leerlingen.add(new Leerling("0002","Ewout Ghysbrecht", new File("src/images/EwoutPng.png"), "ewout.g@hotmail.com"));
    }

    public List<Evaluatie> getEvaluatiesCache() {
        return evaluatiesCache;
    }

    public void setEvaluatiesCache(List<Evaluatie> evaluatiesCache) {
        this.evaluatiesCache = evaluatiesCache;
    }

    
    
    public List<Leerling> getLeerlingenCache() {
        return leerlingenCache;
    }

    public void setLeerlingenCache(List<Leerling> leerlingenCache) {
        this.leerlingenCache = leerlingenCache;
    }

    public Cursus getCursus() {
        return cursus;
    }

    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }
    
    
    
    public void voegLeerlingToe(Leerling leerling){
        leerlingen.add(leerling);
    }
    
    public List<Leerling> getLeerlingen()
    {
        return leerlingen;
    }

    public Leerling getGeselecteerd() {
        return geselecteerd;
    }

    public void setGeselecteerd(Leerling geselecteerd) {
        this.geselecteerd = geselecteerd;
    }

    public AttitudeSchermController getAsc() {
        return asc;
    }

    public void setAsc(AttitudeSchermController asc) {
        this.asc = asc;
    }

    public InfoSchermController getIsc() {
        return isc;
    }

    public void setIsc(InfoSchermController isc) {
        this.isc = isc;
    }

    public LoginController getLoginc() {
        return loginc;
    }

    public void setLoginc(LoginController loginc) {
        this.loginc = loginc;
    }

    public LogoutController getLogoutc() {
        return logoutc;
    }

    public void setLogoutc(LogoutController logoutc) {
        this.logoutc = logoutc;
    }

    public NieuweLlnSchermController getNlc() {
        return nlc;
    }

    public void setNlc(NieuweLlnSchermController nlc) {
        this.nlc = nlc;
    }

    public OverzichtSchermController getOzc() {
        return ozc;
    }

    public void setOzc(OverzichtSchermController ozc) {
        this.ozc = ozc;
    }

    public RijtechniekSchermController getRtc() {
        return rtc;
    }

    public void setRtc(RijtechniekSchermController rtc) {
        this.rtc = rtc;
    }

    public StuurtechniekSchermController getStc() {
        return stc;
    }

    public void setStc(StuurtechniekSchermController stc) {
        this.stc = stc;
    }

    public ZoekLlnSchermController getZlsc() {
        return zlsc;
    }

    public void setZlsc(ZoekLlnSchermController zlsc) {
        this.zlsc = zlsc;
    }

    public Evaluatie getEvaluatieMatthias() {
        return evaluatieMatthias;
    }

    public void setEvaluatieMatthias(Evaluatie evaluatieMatthias) {
        this.evaluatieMatthias = evaluatieMatthias;
    }
    
       public void setStuurtechniekenScene(Scene scene) {
        stuurTechniekenScene=scene;
    }
    
    public Scene getStuurtechniekenScene(){
        return stuurTechniekenScene;
    }
    
    public void setRijtechniekenScene(Scene scene) {
        this.rijTechniekenScene=scene;
    }
    
    public Scene getRijtechniekenScene() {
        return rijTechniekenScene;
    }
    
    public void setOverzichtScene(Scene scene) {
        this.overzichtScene=scene;
    }

    public Scene getOverzichtScene() {
        return overzichtScene;
    }
    
    public void setAttitudeScene(Scene scene) {
        this.attitudeScene=scene;
    }
    
    public Scene getAttitudeScene() {
        return attitudeScene;
    }
    
}
