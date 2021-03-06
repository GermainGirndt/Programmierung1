
/**
 * Beschreiben Sie hier die Klasse Mitarbeiter.
 * Die Klasse Mitarbeiter erbt von Person, zusätzlich hat ein Mitarbeiter eine email Adresse
 * 
 * @author Girndt & Krier
 * @version 1.0
 */
public class Mitarbeiter extends Person {
    private String email;
    
    private String emailRegex = "^\\S+@\\S+.\\S+$";
    
    private static final String FEHLER_UNGUELTIGE_EMAIL = "Geben Sie bitte eine gueltige Email-Addresse ein";
    
    /**
     * Konstruktor für Objekte der Klasse Mitarbeiter
     * @param vorname ist der Vorname der Person, darf nicht leer sein
     * @param nachname ist der Nachname der Person, darf nicht leer sein
     * @param email ist die email-Adresse der person, darf nicht leer sein und muss ein @ enthalten
     */
    public Mitarbeiter(String vorname, String nachname, String email) {
        super(vorname, nachname);
        
        if (email == null || !email.matches(emailRegex)) {
             throw new IllegalArgumentException(FEHLER_UNGUELTIGE_EMAIL);  
        }
        this.email = email;
    }

    /**
     * reserviere erstellt eine Reservierung und setzt eine Bemerkung, 
     * den uebergebenen Raum und den Mitarbeiter
     * selbst als erzeugenden Mitarbeiter.
     * @param raum ist der Raum, der reserviert wird
     * @param beginn ist die Anfangsuhrzeit
     * @param ende ist die Enduhrzeit
     * @bemerkung ist die Bemerkung
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) {
        Reservierung reservierung = new Reservierung(beginn, ende);
        
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        
    }

    public String getEmail() {
        return this.email;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", super.toString(), this.email); 
    }

    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }

        if (object == this) {
            return true;
        }

        if (!(object instanceof Mitarbeiter)) {
            return false;
        }

        Mitarbeiter mitarbeiter = (Mitarbeiter) object;

        if (this.hasSameAttributes(mitarbeiter)) {
            return true;
        }

        return false;
    }

    @Override
    protected boolean hasSameAttributes(Mitarbeiter mitarbeiter) {
        return super.hasSameAttributes(mitarbeiter) && this.getEmail().equals(mitarbeiter.getEmail());
    }
}
