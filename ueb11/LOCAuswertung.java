import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * java LOCAuswertung datei1.java datei2.java datei3.java
 * 
 * • Es ist mindestens eine Datei zu übergeben. Die Gesamtanzahl an übergebenen Dateien ist beliebig.
 *
 *
 * • Die zu verarbeitenden Dateien sind auf die Eigenschaften „normale Datei“ und „Lesbarkeit“
 * zu prüfen. Natürlich müssen die zu verarbeitenden Dateien auch existieren, bevor eine Verarbeitung starten kann.
 * 
 * 
 * • Mögliche Ausnahmen sind zu behandeln. Definieren Sie dazu eigene Ausnahmeklassen.
 * 
 * 
 * • Bei Lesefehlern in einer Datei soll mit der nächsten Datei fortgefahren werden.
 * 
 * 
 * • Zu zählen sind dabei alle nichtleeren Zeilen, die keine Kommentarzeilen sind.
 * 
 * – Dabei können leere Zeilen durchaus eine Länge größer als 0 haben.
 * 
 * – Als Kommentarzeilen betrachten wir der Einfachheit halber nur die Zeilen, die mit dem
 * String „//“ beginnen
 * 
 */
public class LOCAuswertung {

    private LOCAuswertung() {
    };

    private static BufferedReader reader;
    
    private static StringBuilder auswertungsmessage;
    private static StringBuilder auswertungsfehler;
    
    private static Pattern patternKommentar = Pattern.compile("^//*");

    private static File file;
    
    private static String START_MESSAGE = "Auswertung Lines Of Code (LOC)\n";
    private static String TEMPLATE_DATEI_MESSAGE = "%s \t %s LOC\n";

    private static String FEHLER_MESSAGE = "Die Datei %s könnte nicht ausgewertet werden, denn: ";    
    public static void main(String[] args) {

        LOCAuswertung.auswertungsmessage = new StringBuilder();
        LOCAuswertung.auswertungsfehler = new StringBuilder();
        
        try {
        // validierung args nicht null
        Validierung.validiereArgsLaenge(args);
        } catch (IllegalArgumentException argsError) {
            // eigene Ausnahmeklassen definineren und behandeln
            // ausgeben, was das Problem war
            LOCAuswertung.auswertungsfehler.append(String.format( argsError.getMessage()));
        }
         
        LOCAuswertung.auswertungsmessage.append(START_MESSAGE);
       
        for (String dateiname : args) {
            
            try {
               
                // validierung String nicht leer
                Validierung.validiereNichtLeer(dateiname);
                
                int zeilenAnzahl = LOCAuswertung.auswerteDatei(dateiname);
                LOCAuswertung.auswertungsmessage.append(String.format(TEMPLATE_DATEI_MESSAGE, dateiname, zeilenAnzahl));
                
            } catch (IOException IOError) {
                // eigene Ausnahmeklassen definineren und behandeln
                // ausgeben, was das Problem war
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE + IOError.getMessage(), dateiname));
    
            
            } catch (IllegalArgumentException IlError) {
                // eigene Ausnahmeklassen definineren und behandeln
                // ausgeben, was das Problem war
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE + IlError.getMessage(), dateiname));
            }
        }
         

         System.out.println(LOCAuswertung.auswertungsmessage);
         System.out.println(LOCAuswertung.auswertungsfehler);

    }

   
    private static int auswerteDatei(String dateiname) throws IOException {
            
            // Validierung (wenn nicht gültig, eigene Ausnahme werfen!):
            // checke ob Datei existiert
            // checke ob Datei kein Ordner ist
            // checke ob Datei das richtige Format hat
            // checke ob Datei gelesen werden kann
            
            file         = new File(dateiname);
            Validierung.validiereFileExistiert(file);
            Validierung.validiereFileLesbar(file);
            Validierung.validiereFileIstFile(file);
            
            reader       = new BufferedReader(new FileReader(dateiname));
     
            int zaehler  = 0;
            String zeile = "";

                        
            // Zeilen durchlaufen bis zum Dateienende (??mit Buffer + while-loop?? )
            // ueberprufen, ob Zeile gezahelt werden soll
            // wenn Zeile ein Kommentar ist (mit // anfaengt), nichts tun
            // sonst, zaehler++
            while((zeile = reader.readLine()) != null){
                zeile = zeile.trim();
                if(!zeile.isEmpty()){
                     Matcher matcher = patternKommentar.matcher(zeile);{   
                     if(!matcher.find()){
                         zaehler++;  
                     }
                }
            }
        }
        return zaehler;
    }
}