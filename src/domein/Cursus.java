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
    private Map<String, Map<String, List<String>>> evaRijtechniekOpmerkingenMap;
    private Map<String, Map<String, String>> evaRijtechniekKleurenMap;
    private Map<String, Map<String, List<String>>> VorigeEvaRijtechniekMap;
    private Map<String, Map<String, List<String>>> evaRijtechniekMap1;
    private Map<String, Map<String, List<String>>> evaRijtechniekMap2;
    private Map<String, Map<String, List<String>>> evaRijtechniekMap3;
    
    //StuurtechniekScherm
    private Map<String, List<String>> stuurtechniekOpmerkingenMap;
    private Map<String, String> stuurtechniekKleurenMap;
    private Map<String, Map<String, List<String>>> evaStuurtechniekOpmerkingenMap;
    private Map<String, Map<String, String>> evaStuurtechniekKleurenMap;
    private Map<String, Map<String, List<String>>> VorigeEvaStuurtechniekMap;
    private Map<String, Map<String, List<String>>> evaStuurtechniekMap1;
    private Map<String, Map<String, List<String>>> evaStuurtechniekMap2;
    private Map<String, Map<String, List<String>>> evaStuurtechniekMap3;
    
    public Cursus() {
    }

    public Cursus(String evaNummer, String kleurBol1, String kleurBol2, String kleurBol3, String kleurBol4, String kleurStuurBoven, String kleurStuurLinks, String kleurStuurRechts, double waardeProgressbar, String opmerking, Map<String, List<String>> rijtechniekOpmerkingenMap, Map<String, String> rijtechniekKleurenMap, Map<String, Map<String, List<String>>> VorigeEvaRijtechniekMap, Map<String, List<String>> stuurtechniekOpmerkingenMap, Map<String, String> stuurtechniekKleurenMap, Map<String, Map<String, List<String>>> VorigeEvaStuurtechniekMap) {
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
        this.VorigeEvaRijtechniekMap = VorigeEvaRijtechniekMap;
        this.stuurtechniekOpmerkingenMap = stuurtechniekOpmerkingenMap;
        this.stuurtechniekKleurenMap = stuurtechniekKleurenMap;
        this.VorigeEvaStuurtechniekMap = VorigeEvaStuurtechniekMap;
    }

    public Map<String, Map<String, List<String>>> getEvaRijtechniekOpmerkingenMap() {
        return evaRijtechniekOpmerkingenMap;
    }

    public void setEvaRijtechniekOpmerkingenMap(Map<String, Map<String, List<String>>> evaRijtechniekOpmerkingenMap) {
        this.evaRijtechniekOpmerkingenMap = evaRijtechniekOpmerkingenMap;
    }

    public Map<String, Map<String, String>> getEvaRijtechniekKleurenMap() {
        return evaRijtechniekKleurenMap;
    }

    public void setEvaRijtechniekKleurenMap(Map<String, Map<String, String>> evaRijtechniekKleurenMap) {
        this.evaRijtechniekKleurenMap = evaRijtechniekKleurenMap;
    }

    public Map<String, Map<String, List<String>>> getEvaStuurtechniekOpmerkingenMap() {
        return evaStuurtechniekOpmerkingenMap;
    }

    public void setEvaStuurtechniekOpmerkingenMap(Map<String, Map<String, List<String>>> evaStuurtechniekOpmerkingenMap) {
        this.evaStuurtechniekOpmerkingenMap = evaStuurtechniekOpmerkingenMap;
    }

    public Map<String, Map<String, String>> getEvaStuurtechniekKleurenMap() {
        return evaStuurtechniekKleurenMap;
    }

    public void setEvaStuurtechniekKleurenMap(Map<String, Map<String, String>> evaStuurtechniekKleurenMap) {
        this.evaStuurtechniekKleurenMap = evaStuurtechniekKleurenMap;
    }

    
    
    public Map<String, Map<String, List<String>>> getEvaRijtechniekMap1() {
        return evaRijtechniekMap1;
    }

    public void setEvaRijtechniekMap1(Map<String, Map<String, List<String>>> evaRijtechniekMap1) {
        this.evaRijtechniekMap1 = evaRijtechniekMap1;
    }

    public Map<String, Map<String, List<String>>> getEvaRijtechniekMap2() {
        return evaRijtechniekMap2;
    }

    public void setEvaRijtechniekMap2(Map<String, Map<String, List<String>>> evaRijtechniekMap2) {
        this.evaRijtechniekMap2 = evaRijtechniekMap2;
    }

    public Map<String, Map<String, List<String>>> getEvaRijtechniekMap3() {
        return evaRijtechniekMap3;
    }

    public void setEvaRijtechniekMap3(Map<String, Map<String, List<String>>> evaRijtechniekMap3) {
        this.evaRijtechniekMap3 = evaRijtechniekMap3;
    }

    public Map<String, Map<String, List<String>>> getEvaStuurtechniekMap1() {
        return evaStuurtechniekMap1;
    }

    public void setEvaStuurtechniekMap1(Map<String, Map<String, List<String>>> evaStuurtechniekMap1) {
        this.evaStuurtechniekMap1 = evaStuurtechniekMap1;
    }

    public Map<String, Map<String, List<String>>> getEvaStuurtechniekMap2() {
        return evaStuurtechniekMap2;
    }

    public void setEvaStuurtechniekMap2(Map<String, Map<String, List<String>>> evaStuurtechniekMap2) {
        this.evaStuurtechniekMap2 = evaStuurtechniekMap2;
    }

    public Map<String, Map<String, List<String>>> getEvaStuurtechniekMap3() {
        return evaStuurtechniekMap3;
    }

    public void setEvaStuurtechniekMap3(Map<String, Map<String, List<String>>> evaStuurtechniekMap3) {
        this.evaStuurtechniekMap3 = evaStuurtechniekMap3;
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


    public Map<String, Map<String, List<String>>> getVorigeEvaStuurtechniekMap() {
        return VorigeEvaStuurtechniekMap;
    }

    public void setVorigeEvaStuurtechniekMap(Map<String, Map<String, List<String>>> VorigeEvaStuurtechniekMap) {
        this.VorigeEvaStuurtechniekMap = VorigeEvaStuurtechniekMap;
    }
    
    
}
