import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Die Klasse ArtikelDialog ist eine Dialogklasse zum Testen der Klasse Artikel
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class MathFunctionsDialog
{
    private              UserInput      userInput;
    private              int            funktion;
    
    private static final int            BERECHNE_TEILER_SUMME      = 1;
    private static final int            BERECHNE_CHECKSUMME_ISBN   = 2;
    private static final int            BERECHNE_NULLSTELLEN       = 3;
    private static final int            FUNKTION_ENDE              = 0;
    
    
     /**
    * Konstruktor
    */
    public MathFunctionsDialog() {
        userInput = new UserInput();
    }
    
    public static void main(String[] args) {
        MathFunctionsDialog mathfunctiondialog = new MathFunctionsDialog();
        mathfunctiondialog.start();
        
    }

    /**
    * Hauptschleife der Artikeldialog Klasse
    */
    public void start() {
        this.funktion        = -1;
        
        while(this.funktion != FUNKTION_ENDE) {
            try {
                einlesenFunktion();
                ausfuehrenFunktion();
                
            } catch(IllegalArgumentException error) {
                System.out.println(error);

            } catch(InputMismatchException error) {
                System.out.println(error);
                userInput.next();

            } catch(Exception error) {
                System.out.println(error);
                error.printStackTrace(System.out); 

            }
        }
    }
    
    /**
    * Diese Funktion liest ein welche Funktion ausgefuehrt werden soll
    * @return funktion die ausgewaehlt wurde
    */
    public void einlesenFunktion() {
        
        System.out.print(
            "\n\n" +
            BERECHNE_TEILER_SUMME      + ": Berechne die Teilersumme einer Zahl;\n"  + 
            BERECHNE_CHECKSUMME_ISBN   + ": Berechne die Checksumme einer ISBN-Nummer;\n" + 
            BERECHNE_NULLSTELLEN       + ": Berchne die Nullstellen einer quadratischen funktion;\n" +
            FUNKTION_ENDE              + ": beenden -> \n\n"
        );

        
        this.funktion = userInput.getInt("Ausgewählte Funktion: ");
        System.out.println();
    }
    
    /**
    * Diese Funktion führt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgeführt werden soll
    */
    public void ausfuehrenFunktion() {
        boolean sollNachBestandFragen;

        switch(this.funktion) {
            case BERECHNE_TEILER_SUMME :
                berechneTeilersumme();
                break;
            case  BERECHNE_CHECKSUMME_ISBN:
                berechneChecksummeIsbn();
                break;
            case BERECHNE_NULLSTELLEN :      
                berechneNullstellen();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }
    }

    /**
    * Legt einen Artikel mit Bestand an und erfragt alle nötigen Parameter
    */
    public void berechneTeilersumme() {
        
            long zahl = userInput.getLong("Zahl: ");
            System.out.println("Teilersumme: " + MathFunctions.berechneTeilersumme(zahl));
        }
    

    public void berechneChecksummeIsbn(){
            long isbn = userInput.getLong("ISBN: ");
            System.out.println("Pruefziffer: " + MathFunctions.berechneChecksummeIsbn(isbn));
    }
    
       public void berechneNullstellen(){
            double p = userInput.getDouble("p: ");
            double q = userInput.getDouble("q: ");
            System.out.println(MathFunctions.berechneNullstellen(p , q));
    }
    
}