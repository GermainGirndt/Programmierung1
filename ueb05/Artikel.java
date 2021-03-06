import java.util.regex.Pattern;

/**
* Die Klasse Artikel ist für eine einfache Bestandsprüfung
*
* @author Girndt & Krier
* @version 1.2
*/
public class Artikel
{
    private              int        artikelNr;
    private              String     art;
    private              long       bestand;
    
    private              double     preis;
    
    private static final int        MINIMUM_BESTAND = 0;
    private static final double     INITIAL_PREIS   = 0;

    
    
    /**
    * Konstruktor für Artikel mit Angaben
    * @param artikelNr ist die ArtikelNr
    * @param art ist die Artikelart
    * @param bestand steht für den Bestand
    * @param preis steht für den Preis
    */
    public Artikel(int artikelNr, String art, int bestand, double preis)
    {
        Validierung.validiereArtikelNr(artikelNr);
        Validierung.validiereArtikelArt(art);
        Validierung.validiereBestand(bestand);
        Validierung.validierePreis(preis);
        
        this.artikelNr  = artikelNr;
        this.art        = art;
        this.bestand    = bestand;
        this.preis      = preis;
    }
    
    /**
    * Konstruktor für Artikel ohne Preis- und Bestandsangabe
    * @param artikelNr ist die ArtikelNr
    * @param art ist die Artikelart
    * @param bestand steht für den initalen Bestand
    */
    public Artikel(int artikelNr, String art, double preis)
    {
         this(artikelNr, art, MINIMUM_BESTAND, INITIAL_PREIS);

    }
    
    /**
    * Konstruktor für Artikel ohne Preisangabe
    * @param artikelNr ist die ArtikelNr
    * @param art ist die Artikelart
    * @param bestand steht für den Bestand
    */
    public Artikel(int artikelNr, String art, int bestand)
    {
        this(artikelNr, art, bestand, INITIAL_PREIS);
    }

    /**
    * Konstruktor für Artikel ohne Bestandsangabe
    * @param artikelNr ist die ArtikelNr
    * @param art ist die Artikelart
    */
    public Artikel(int artikelNr, String art)
    {
        this(artikelNr, art, MINIMUM_BESTAND, INITIAL_PREIS);
    }

    /**
    * Die Methode bucht eine übergebene Menge dem Bestand hinzu
    * @param mengeArtikelzugang ist die Menge neuer Artikel, die dazugebucht wird
    */
    public void bucheZugang(int mengeArtikelzugang)
    {
        Validierung.validiereZugangsmenge(this.bestand, mengeArtikelzugang);
        
        this.bestand += mengeArtikelzugang;
    }
    
    /**
    * Die Methode bucht eine übergebene Menge dem Bestand ab
    * @param menge ist die Menge, die abgebucht wird
    */
    public void bucheAbgang(int menge) {
        Validierung.validiereAbgangsmenge(this.bestand, menge);
        
        this.bestand -= menge;
    }
    
    /**
     * Die Methode aendert den Preis eines Artikels
    * @param prozent ist der Prozensatz an Preisabweichung
    */
    public void aenderePreis(double prozent)
    {
        Validierung.validierePreisaenderung(prozent);
        
        double preisfaktor = berechnePreisfaktor(prozent);
        
        this.preis *= preisfaktor;
    }
    
    /**
    * Die Methode berechnet die Preisabweichung des Artikelpreises
    * @param prozent ist der Prozensatz an Preisabweichung
    */
    private double berechnePreisfaktor(double prozent) {
        return (prozent + 100.0) / 100.0;
    }

    /**
    * Die Methode gibt das Objekt aufbereitet als String zurueck
    * @return gibt die Attribute des Artikels als String zurueck
    */
    public String toString()
    {
        return  "ArtikeNr: "    + this.artikelNr     + "\n" +
                "Art: "         + this.art           + "\n" +
                "Bestand: "     + this.bestand       + "\n" +
                "Preis: "       + this.preis;

    }

    /**
    * Die Methode gibt die Artikelnummer zurueck
    * @return die Artikelnummer
    */
    public int getArtikelNr()
    {
        return this.artikelNr;
    }
    
    /**
    * Die Methode gibt die Artikelart zurueck
    * @return die Artikelart
    */
    public String getArt()
    {
        return this.art;
    }

    /**
    * Die Methode gibt den Bestand zurueck
    * @return den Bestand
    */
    public long getBestand()
    {
        return this.bestand;
    }

    /**
    * Die Methode gibt den Preis zurueck
    * @return den Preis
    */
    public double getPreis()
    {
        return this.preis;
    }

    /**
    * Die Methode setzt die Artikelart neu
    * @param neue Artikelart
    */
    public void setArt(String art)
    {
        Validierung.validiereArtikelArt(art);
        
        this.art = art;
    }

}