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
public class EvaluatieMoment {
    
    private String naam;
    private List<Onderdeel> rijtechniekOnderdelen = new ArrayList<>();
    private List<Onderdeel> verkeerstechniekOnderdelen = new ArrayList<>();

    public EvaluatieMoment(String naam) {
        this.naam = naam;
        verkeerstechniekOnderdelen.add(new Onderdeel("Richtingaanwijzers", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("openbareweg", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("voorrang", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("borden", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("snelheid", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("fille", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("overgaan", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("kruisen", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("links", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new Onderdeel("rechts", Kleuren.WIT));
        
        rijtechniekOnderdelen.add(new Onderdeel("zithouding", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("ontkoppeling", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("remmen", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("stuur", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("schakelen", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("waakzaam", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("parkeren", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("keren", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("g", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("r", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("bochten", Kleuren.WIT));
        rijtechniekOnderdelen.add(new Onderdeel("helling", Kleuren.WIT));
        
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Onderdeel> getRijtechniekOnderdelen() {
        return rijtechniekOnderdelen;
    }

    public void setRijtechniekOnderdelen(List<Onderdeel> rijtechniekOnderdelen) {
        this.rijtechniekOnderdelen = rijtechniekOnderdelen;
    }

    public List<Onderdeel> getVerkeerstechniekOnderdelen() {
        return verkeerstechniekOnderdelen;
    }

    public void setVerkeerstechniekOnderdelen(List<Onderdeel> verkeerstechniekOnderdelen) {
        this.verkeerstechniekOnderdelen = verkeerstechniekOnderdelen;
    }
    
    
}
