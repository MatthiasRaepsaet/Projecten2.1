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

/**
 *
 * @author ewout
 */
public class DomeinController {
    
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
    
    public DomeinController()
    {
        leerlingen.add(new Leerling("0001","Joske Vermeulen", new File("src/images/GastonPng.png"),"joske.vermeulen@gmail.com"));
        leerlingen.add(new Leerling("0002","Ewout Ghysbrecht", new File("src/images/EwoutPng.png"), "ewout.g@hotmail.com"));
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
    
    
}
