
/**
 *  MyInputFunctions realisiert ausgewaehlte Eingabe-Methoden
 *  auf Basis der Scanner-Klasse
 *  
 *  Folgende Methoden sind realisiert :
 *  
 *      readlnInt
 *      readlnLong
 *      readlnDouble
 *      readlnChar
 * 
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 14.11.2019
 */


import java.util.Scanner;


public class MyInputFunctions
{
                         
    /**
     * Konstruktor, der die Erzeugung eines Objektes dieser Klasse verhindert, 
     * da sinnlos !!
     */
    private MyInputFunctions()
    {
    }



   /**
    * gibt eine Eingabeaufforderungs-Text aus und
    * liest aus einem Eingabestrom genau die erste Integer-Zahl
    * und ueberliest bis zum Zeilenende alle weiteren Zeichen
    *
    *  @param  in der zu lesende Eingabestrom
    *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
    *  @return die eingegebene Integer-Zahl
    */
   public static int readlnInt(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    int zahl = in.nextInt();
    in.nextLine();
    return zahl;
   }


   /**
    * gibt eine Eingabeaufforderungs-Text aus und
    * liest aus einem Eingabestrom genau die erste Long-Integer-Zahl
    * und ueberliest bis zum Zeilenende alle weiteren Zeichen
    *
    *  @param  in der zu lesende Eingabestrom
    *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
    *  @return die eingegebene Long-Integer-Zahl
    */
   public static long readlnLong(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    long zahl = in.nextLong();
    in.nextLine();
    return zahl;
   }



   /**
    * gibt eine Eingabeaufforderungs-Text aus und
    * liest aus einem Eingabestrom genau die erste Double-Zahl
    * und ueberliest bis zum Zeilenende alle weiteren Zeichen
    *
    *  @param  in der zu lesende Eingabestrom
    *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
    *  @return die eingegebene Double-Zahl
    */
   public static double readlnDouble(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    double zahl = in.nextDouble();
    in.nextLine();
    return zahl;
   }



   /**
    * gibt eine Eingabeaufforderungs-Text aus und
    * liest aus einem Eingabestrom genau das erste Zeichen ( Char )
    * und ueberliest bis zum Zeilenende alle weiteren Zeichen
    *
    *  @param  in der zu lesende Eingabestrom
    *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
    *  @return das eingegebene Zeichen ( char )
    */
  public static char readlnChar(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    String zeile = in.nextLine();
    char zeichen = zeile.toCharArray()[0];
    return zeichen;
   }

}
