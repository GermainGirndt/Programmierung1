
/**
 * Beschreiben Sie hier die Klasse Person.
 * Die Klasse Person soll einen Menschen mit Vor- und Nachname abbilden
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class Person {
    private String vorname;
    private String nachname;

    private static final String FEHLER_VORNAME_UNGUELTIG  = "Der Vorname darf nur alphabetische Charactere und Bindestrich enthalten";
    private static final String FEHLER_NACHNAME_UNGUELTIG = "Der Nachname darf nur alphabetische Charactere und Bindestrich enthalten";

    private static final String regexAlphabetischeCharaktere = "^[a-zA-Z\\-\\säöüÄÖÜß]+$";

    /**
     * Konstruktor für Objekte der Klasse Person
     * @param vorname ist der Vorname der Person, darf nicht leer sein
     * @param nachname ist der Nachname der Person, darf nicht leer sein
     */
    public Person(String vorname, String nachname)
    {
        if (vorname == null || !vorname.matches(regexAlphabetischeCharaktere)) {
            throw new IllegalArgumentException(FEHLER_VORNAME_UNGUELTIG);
        }
        if (nachname == null || !nachname.matches(regexAlphabetischeCharaktere)) {
            throw new IllegalArgumentException(FEHLER_NACHNAME_UNGUELTIG);
        }

        this.vorname  = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return this.vorname;
    }
    
    public String getNachname() {
        return this.nachname;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s",  this.vorname, this.nachname); 
    }

    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }

        if (object == this) {
            return true;
        }

        if (!(object instanceof Person)) {
            return false;
        }

        Person person = (Person) object;

        return this.hasSameAttributes(person);
    }

    @Override
    protected boolean hasSameAttributes(Person person) {
        return person.getVorname().equals(this.getVorname()) &&
        person.getNachname().equals(this.getNachname());
    }
}
