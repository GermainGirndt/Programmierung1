import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;

/**
 * <p>Diese Klasse ist eine Fassade, hinter der Sie Ihre Loesung verstecken. Der Test ruft nur die hier definierten
 * Schnittstellenmethoden auf. Loeschen Sie bitte keine Methoden. Wenn Sie eine Methode nicht implementieren
 * moechten, lassen Sie bitte die leere Implementierung stehen. Innerhalb der Methoden und in allen anderen Klassen,
 * die Sie noch benoetigen, haben Sie alle Freiheiten.</p>
 * 
 * <p>Wenn Sie Ihre Loesung mit JUnit testen moechten, testen Sie diese Schnittstellenmethoden.</p>
 * @author christopher
 *
 */
public class Ueb18Fassade {
    /**
     * Loest die Aufgabe (c) i.
     * <br />
     * Sortierung nach den folgenden Kriterien:
     * <ol>
     *     <li>Unterkategorie (alphabetisch)</li>
     *     <li>Bestand</li>
     *     <li>Preis</li>
     * </ol>
     * @param lager Das Lager mit der unsortierten Artikelliste.
     * @return Die sortierte Artikelliste.
     */
    public Artikel[] aufgabe_c_i(Lager lager) {
        BiPredicate<Artikel, Artikel> unterkategorieAbsteigendSortieren = 
        (artikel1, artikel2) -> {return Helferklasse.compareStrings(artikel1.getArt(), artikel2.getArt());};
        
        BiPredicate<Artikel, Artikel> unterkategorieAufsteigendSortieren = 
        (artikel1, artikel2) -> {return !Helferklasse.compareStrings(artikel1.getArt(), artikel2.getArt());};
          
        BiPredicate<Artikel, Artikel> bestandAbsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getBestand() < artikel2.getBestand();};
        
        BiPredicate<Artikel, Artikel> bestandAufsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getBestand() > artikel2.getBestand();};
        
        BiPredicate<Artikel, Artikel> preisAbsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getPreis() < artikel2.getPreis();};
        
        BiPredicate<Artikel, Artikel> preisAufsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getPreis() > artikel2.getPreis();};
        
        //hier gewuenschtes Kriterium uebergeben
        return  lager.sortAll(unterkategorieAbsteigendSortieren, bestandAbsteigendSortieren, preisAbsteigendSortieren);
    }

    /**
     * Loest die Aufgabe (c) ii.
     * <br />
     * Der Preis aller Artikel wird um 10% reduziert.
     * @param lager Das Lager mit den Artikeln, deren Preise geaendert werden sollen.
     */
    public void aufgabe_c_ii(Lager lager) {
         UnaryOperator<Artikel> preis10ProzentReduzieren = 
         (artikel) -> { artikel.aenderePreis(-10); return artikel;};
         lager.applyToArticles(preis10ProzentReduzieren);
    }

    /**
     * Loest die Aufgabe (c) iii.
     * <br />
     * An alle Artikelbezeichnungen wird das Suffix (Sonderangebot) angehaengt.
     * @param lager Das Lager mit den Artikeln, deren Bezeichnungen geaendert werden sollen.
     */    
    public void aufgabe_c_iii(Lager lager) {
        UnaryOperator<Artikel> sonderangebotArtSetzen = 
        (artikel) -> {String art = artikel.getArt(); 
                        artikel.setArt(art + " Sonderangebot");
                        return artikel;};
        lager.applyToArticles(sonderangebotArtSetzen);                
    }

    /**
     * Loest die Aufgabe (c) iv.
     * <br />
     * Die beiden Operatoren aus den Aufgabenteilen ii und iii werden konkateniert, d.h. alle Preise werden
     * um 10 % reduziert und alle Bezeichnungen werden um das Suffix (Sonderangebot) erweitert.
     * @param lager Das Lager mit den Artikeln, deren Preise und Bezeichnungen geaendert werden sollen.
     */
    public void aufgabe_c_iv(Lager lager) {
        UnaryOperator<Artikel> sonderangebot = 
        (artikel) -> {String art = artikel.getArt(); 
                        artikel.aenderePreis(-10);
                        artikel.setArt(art + " Sonderangebot");
                        return artikel;};
        lager.applyToArticles(sonderangebot);    
    }

    /**
     * Loest die Aufgabe (h) i.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_i(Lager lager) {
        UnaryOperator<Artikel> preis10ProzentErhoehen = 
         (artikel) -> { artikel.aenderePreis(10); return artikel;};
        
        lager.applyToSomeArticles( preis10ProzentErhoehen, a -> a instanceof CD);
    }

    /**
     * Loest die Aufgabe (h) ii.
     * <br />
     * Der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_ii(Lager lager) {
        UnaryOperator<Artikel> preis5ProzentReduzieren = 
        (artikel) -> { artikel.aenderePreis(-5); return artikel;};
         
         lager.applyToSomeArticles( preis5ProzentReduzieren, a -> a.getBestand() < 3); 
    }

    /**
     * Loest die Aufgabe (h) iii.
     * <br />
     * Der Preis der Buecher eines bestimmten Autors wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     * @param gesuchterAutor Der Autor, dessen Buecher guenstiger werden sollen.
     */
    public void aufgabe_h_iii(Lager lager, String gesuchterAutor) {
        UnaryOperator<Artikel> preis5ProzentReduzieren = 
        (artikel) -> { artikel.aenderePreis(-5); return artikel;};
        
        Predicate p = a ->
        {
            if(a instanceof Buch){
                Buch b = (Buch)a;
                return b.getAutor().equals(gesuchterAutor);  
            }
            else{
                return false;    
            }
                
        }; 
        
         lager.applyToSomeArticles( preis5ProzentReduzieren, p); 
    }

    /**
     * Loest die Aufgabe (h) iv.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht und der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_iv(Lager lager) {
        //kann man das besser machen?
        
        UnaryOperator<Artikel> preiseBerechnen = 
         (artikel) -> {  if(artikel instanceof CD){
                             artikel.aenderePreis(10);
                         }
                        
                         if(artikel.getBestand() < 3){
                             artikel.aenderePreis(-5);
                         }
                         return artikel;};
        
        lager.applyToSomeArticles( preiseBerechnen, a -> true);
    }

    /**
     * Loest die Aufgabe (h) v.
     * <br />
     * @param lager Das Lager mit den Artikeln. 
     * @return Eine Liste mit allen Buechern, sortiert nach den Namen der Autoren. 
     */
    public Artikel[] aufgabe_h_v(Lager lager) {
         BiPredicate<Artikel, Artikel> autorSortieren = 
        (artikel1, artikel2) -> {   Buch b1 = (Buch)artikel1;
                                    Buch b2 = (Buch)artikel2;
                                    return Helferklasse.compareStrings(b1.getAutor(), b2.getAutor());
                                };
        
        return lager.getArticles( autorSortieren  , a-> a instanceof Buch); 
        
    }

    /**
     * Loest die Aufgabe (h) vi.
     * <br />
     * @param lager Das Lager, dessen Artikel gefiltert werden sollen.
     * @param gesuchterAutor Der Autor, nach dem gefiltert werden soll.
     * @param minPreis Der kleinste Preis, den die zu filternden Buecher haben sollen.
     * @param maxPreis Der hoechste Preis, den die zu filternden Buecher haben sollen.
     * @return Alle Buecher vom Autor autor und mit einem Preis, der zwischen minPreis und maxPreis liegt.
     */
    public Artikel[] aufgabe_h_vi(Lager lager, String gesuchterAutor, double minPreis, double maxPreis) {
        Predicate p = a ->
        {
            if(a instanceof Buch){
                Buch b = (Buch)a;
                return b.getAutor().equals(gesuchterAutor);
            
            }
            else{
                return false;    
            }
                
        }; 

        //muss man da auf die 0 achten?
        return lager.filterAll(p, a -> a.getPreis() >= minPreis , a -> a.getPreis() <= maxPreis);
    }
}