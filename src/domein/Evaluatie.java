/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthias
 */
public class Evaluatie {
    private String evaluatieNummer;
    private int rijtechniekenScore;
    private int verkeerstechniekenScore;
    private int algemeneScore;
    private String algemeneOpmerkingen;
    
    private Kleuren rotonde;
    private Kleuren steenweg;
    private Kleuren bebouwdeKom;
    private Kleuren autostrade;
    
    private EvaluatieMoment huidigeEva;
    private EvaluatieMoment vorigeEva;
    private List<EvaluatieMoment> evaLijst = new ArrayList<>();

    public Evaluatie(String evaluatieNummer, int rijtechniekenScore, int verkeerstechniekenScore, int algemeneScore, String algemeneOpmerkingen, Kleuren rotonde, Kleuren steenweg, Kleuren bebouwdeKom, Kleuren autostrade) {
        this.evaluatieNummer = evaluatieNummer;
        this.rijtechniekenScore = rijtechniekenScore;
        this.verkeerstechniekenScore = verkeerstechniekenScore;
        this.algemeneScore = algemeneScore;
        this.algemeneOpmerkingen = algemeneOpmerkingen;
        this.rotonde = rotonde;
        this.steenweg = steenweg;
        this.bebouwdeKom = bebouwdeKom;
        this.autostrade = autostrade;
        
    }

    public Evaluatie(String string, int i, int i0, int i1, String string0, Kleuren kleuren, Kleuren kleuren0, Kleuren kleuren1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEvaluatieNummer() {
        return evaluatieNummer;
    }

    public void setEvaluatieNummer(String evaluatieNummer) {
        this.evaluatieNummer = evaluatieNummer;
    }

    public int getRijtechniekenScore() {
        return rijtechniekenScore;
    }

    public void setRijtechniekenScore(int rijtechniekenScore) {
        this.rijtechniekenScore = rijtechniekenScore;
    }

    public int getVerkeerstechniekenScore() {
        return verkeerstechniekenScore;
    }

    public void setVerkeerstechniekenScore(int verkeerstechniekenScore) {
        this.verkeerstechniekenScore = verkeerstechniekenScore;
    }

    public int getAlgemeneScore() {
        return algemeneScore;
    }

    public void setAlgemeneScore(int algemeneScore) {
        this.algemeneScore = algemeneScore;
    }

    public String getAlgemeneOpmerkingen() {
        return algemeneOpmerkingen;
    }

    public void setAlgemeneOpmerkingen(String algemeneOpmerkingen) {
        this.algemeneOpmerkingen = algemeneOpmerkingen;
    }

    public Kleuren getRotonde() {
        return rotonde;
    }

    public void setRotonde(Kleuren rotonde) {
        this.rotonde = rotonde;
    }

    public Kleuren getSteenweg() {
        return steenweg;
    }

    public void setSteenweg(Kleuren steenweg) {
        this.steenweg = steenweg;
    }

    public Kleuren getBebouwdeKom() {
        return bebouwdeKom;
    }

    public void setBebouwdeKom(Kleuren bebouwdeKom) {
        this.bebouwdeKom = bebouwdeKom;
    }

    public Kleuren getAutostrade() {
        return autostrade;
    }

    public void setAutostrade(Kleuren autostrade) {
        this.autostrade = autostrade;
    }

    public EvaluatieMoment getHuidigeEva() {
        return huidigeEva;
    }

    public void setHuidigeEva(EvaluatieMoment huidigeEva) {
        this.huidigeEva = huidigeEva;
    }

    public EvaluatieMoment getVorigeEva() {
        return vorigeEva;
    }

    public void setVorigeEva(EvaluatieMoment vorigeEva) {
        this.vorigeEva = vorigeEva;
    }

    public List<EvaluatieMoment> getEvaLijst() {
        return evaLijst;
    }

    public void setEvaLijst(List<EvaluatieMoment> evaLijst) {
        this.evaLijst = evaLijst;
    }
    
    
}
