package domein;

import java.io.File;
import java.util.List;

public class Leerling {

    public Leerling(String inschrijvingsNummer, String naam, File fotoPath, String email, Evaluatie evaluatie) {
        this.inschrijvingsNummer = inschrijvingsNummer;
        this.naam = naam;
        this.fotoPath = fotoPath;
        this.email = email;
        this.evaluatie = evaluatie;
    }
    
    private String inschrijvingsNummer;
    private String naam;
    private File fotoPath;
    private String email;
    private Evaluatie evaluatie;

    public Leerling() {
        
    }

    public String getInschrijvingsNummer() {
        return inschrijvingsNummer;
    }

    public void setInschrijvingsNummer(String inschrijvingsNummer) {
        this.inschrijvingsNummer = inschrijvingsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public File getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(File fotoPath) {
        this.fotoPath = fotoPath;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Evaluatie getEvaluatie() {
        return evaluatie;
    }

    public void setEvaluatie(Evaluatie evaluatie) {
        this.evaluatie = evaluatie;
    }
    
    
    
    @Override
    public String toString(){
        return naam;
    }
    
}
