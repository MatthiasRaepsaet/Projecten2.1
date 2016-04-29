/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matthias
 */
public class Cursus {
    
    private Leerling leerling = new Leerling();
    
    //OverzichtScherm
    private String evaNummer;
    
    private String kleurBol1;
    private String kleurBol2;
    private String kleurBol3;
    private String kleurBol4;
    
    private String kleurStuurBoven;
    private String kleurStuurLinks;
    private String kleurStuurRechts;
    
    private double waardeProgressbar;
    
    private String opmerking;
    
    //AttitudeScherm
    private List<String> attitudeOpmerkingen = new ArrayList<>();
    
    //RijtechniekScherm
    private Map<String, List<String>> rijtechniekOpmerkingenMap;
    private Map<String, String> rijtechniekKleurenMap;
    private Map<String, Map<String, List<String>>> evaRijtechniekMap;
    private Map<String, Map<String, List<String>>> VorigeEvaRijtechniekMap;
    
    //StuurtechniekScherm
    private Map<String, List<String>> stuurtechniekOpmerkingenMap;
    private Map<String, String> stuurtechniekKleurenMap;
    private Map<String, Map<String, List<String>>> evaStuurtechniekMap;
    private Map<String, Map<String, List<String>>> VorigeEvaStuurtechniekMap;

    public Cursus() {
    }

    public Cursus(String evaNummer, String kleurBol1, String kleurBol2, String kleurBol3, String kleurBol4, String kleurStuurBoven, String kleurStuurLinks, String kleurStuurRechts, double waardeProgressbar, String opmerking, Map<String, List<String>> rijtechniekOpmerkingenMap, Map<String, String> rijtechniekKleurenMap, Map<String, Map<String, List<String>>> evaRijtechniekMap, Map<String, Map<String, List<String>>> VorigeEvaRijtechniekMap, Map<String, List<String>> stuurtechniekOpmerkingenMap, Map<String, String> stuurtechniekKleurenMap, Map<String, Map<String, List<String>>> evaStuurtechniekMap, Map<String, Map<String, List<String>>> VorigeEvaStuurtechniekMap) {
        this.evaNummer = evaNummer;
        this.kleurBol1 = kleurBol1;
        this.kleurBol2 = kleurBol2;
        this.kleurBol3 = kleurBol3;
        this.kleurBol4 = kleurBol4;
        this.kleurStuurBoven = kleurStuurBoven;
        this.kleurStuurLinks = kleurStuurLinks;
        this.kleurStuurRechts = kleurStuurRechts;
        this.waardeProgressbar = waardeProgressbar;
        this.opmerking = opmerking;
        this.rijtechniekOpmerkingenMap = rijtechniekOpmerkingenMap;
        this.rijtechniekKleurenMap = rijtechniekKleurenMap;
        this.evaRijtechniekMap = evaRijtechniekMap;
        this.VorigeEvaRijtechniekMap = VorigeEvaRijtechniekMap;
        this.stuurtechniekOpmerkingenMap = stuurtechniekOpmerkingenMap;
        this.stuurtechniekKleurenMap = stuurtechniekKleurenMap;
        this.evaStuurtechniekMap = evaStuurtechniekMap;
        this.VorigeEvaStuurtechniekMap = VorigeEvaStuurtechniekMap;
    }
    
    
    public String getEvaNummer() {
        return evaNummer;
    }

    public void setEvaNummer(String evaNummer) {
        this.evaNummer = evaNummer;
    }

    public Leerling getLeerling() {
        return leerling;
    }

    public void setLeerling(Leerling leerling) {
        this.leerling = leerling;
    }

    public String getKleurBol1() {
        return kleurBol1;
    }

    public void setKleurBol1(String kleurBol1) {
        this.kleurBol1 = kleurBol1;
    }

    public String getKleurBol2() {
        return kleurBol2;
    }

    public void setKleurBol2(String kleurBol2) {
        this.kleurBol2 = kleurBol2;
    }

    public String getKleurBol3() {
        return kleurBol3;
    }

    public void setKleurBol3(String kleurBol3) {
        this.kleurBol3 = kleurBol3;
    }

    public String getKleurBol4() {
        return kleurBol4;
    }

    public void setKleurBol4(String kleurBol4) {
        this.kleurBol4 = kleurBol4;
    }

    

    public String getKleurStuurBoven() {
        return kleurStuurBoven;
    }

    public void setKleurStuurBoven(String kleurStuurBoven) {
        this.kleurStuurBoven = kleurStuurBoven;
    }

    public String getKleurStuurLinks() {
        return kleurStuurLinks;
    }

    public void setKleurStuurLinks(String kleurStuurLinks) {
        this.kleurStuurLinks = kleurStuurLinks;
    }

    public String getKleurStuurRechts() {
        return kleurStuurRechts;
    }

    public void setKleurStuurRechts(String kleurStuurRechts) {
        this.kleurStuurRechts = kleurStuurRechts;
    }

    public double getWaardeProgressbar() {
        return waardeProgressbar;
    }

    public void setWaardeProgressbar(double waardeProgressbar) {
        this.waardeProgressbar = waardeProgressbar;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public List<String> getAttitudeOpmerkingen() {
        return attitudeOpmerkingen;
    }

    public void setAttitudeOpmerkingen(List<String> attitudeOpmerkingen) {
        this.attitudeOpmerkingen = attitudeOpmerkingen;
    }

    public Map<String, List<String>> getRijtechniekOpmerkingenMap() {
        return rijtechniekOpmerkingenMap;
    }

    public void setRijtechniekOpmerkingenMap(Map<String, List<String>> rijtechniekOpmerkingenMap) {
        this.rijtechniekOpmerkingenMap = rijtechniekOpmerkingenMap;
    }

    public Map<String, String> getRijtechniekKleurenMap() {
        return rijtechniekKleurenMap;
    }

    public void setRijtechniekKleurenMap(Map<String, String> rijtechniekKleurenMap) {
        this.rijtechniekKleurenMap = rijtechniekKleurenMap;
    }

    public Map<String, Map<String, List<String>>> getEvaRijtechniekMap() {
        return evaRijtechniekMap;
    }

    public void setEvaRijtechniekMap(Map<String, Map<String, List<String>>> evaRijtechniekMap) {
        this.evaRijtechniekMap = evaRijtechniekMap;
    }

    public Map<String, Map<String, List<String>>> getVorigeEvaRijtechniekMap() {
        return VorigeEvaRijtechniekMap;
    }

    public void setVorigeEvaRijtechniekMap(Map<String, Map<String, List<String>>> VorigeEvaRijtechniekMap) {
        this.VorigeEvaRijtechniekMap = VorigeEvaRijtechniekMap;
    }

    public Map<String, List<String>> getStuurtechniekOpmerkingenMap() {
        return stuurtechniekOpmerkingenMap;
    }

    public void setStuurtechniekOpmerkingenMap(Map<String, List<String>> stuurtechniekOpmerkingenMap) {
        this.stuurtechniekOpmerkingenMap = stuurtechniekOpmerkingenMap;
    }

    public Map<String, String> getStuurtechniekKleurenMap() {
        return stuurtechniekKleurenMap;
    }

    public void setStuurtechniekKleurenMap(Map<String, String> stuurtechniekKleurenMap) {
        this.stuurtechniekKleurenMap = stuurtechniekKleurenMap;
    }

    public Map<String, Map<String, List<String>>> getEvaStuurtechniekMap() {
        return evaStuurtechniekMap;
    }

    public void setEvaStuurtechniekMap(Map<String, Map<String, List<String>>> evaStuurtechniekMap) {
        this.evaStuurtechniekMap = evaStuurtechniekMap;
    }

    public Map<String, Map<String, List<String>>> getVorigeEvaStuurtechniekMap() {
        return VorigeEvaStuurtechniekMap;
    }

    public void setVorigeEvaStuurtechniekMap(Map<String, Map<String, List<String>>> VorigeEvaStuurtechniekMap) {
        this.VorigeEvaStuurtechniekMap = VorigeEvaStuurtechniekMap;
    }
    
    
}
