
/**
 * Beschreiben Sie hier die Klasse StringQueue.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class StringQueue implements Queue
{
   private String[] queue;
   private int anzahl = 0;
   
   public StringQueue(int size){
       queue = new String[size];    
   }
   
   @Override
   public void addLast(Object o){
       if(o instanceof String){
          if(full()){
               throw new IllegalArgumentException("Schlange schon voll");
          }
          String s = (String)o;
          queue[anzahl] = s;
          anzahl++; 
       }
       
   }
   
   @ Override 
   public Object removeFirst(){
       
       if(empty()){
           throw new IllegalArgumentException("Schlange leer");    
       }
       
       Object o = queue[0];
       entferne(0);   
       return o;
   }
   
   @Override 
   public Object get(int i){
       if(empty()){
           throw new IllegalArgumentException("Schlange leer");    
       }
       if(i >= queue.length || i < 0){
           throw new IllegalArgumentException("Index Außerhalb der Schlange"); 
       }
       
       if(i >= anzahl){
           throw new IllegalArgumentException("An der Stelle der Schlang ist nichts"); 
       }
       return queue[i];
   }
   
   @Override
   public boolean empty(){
       if(anzahl == 0){
           return true;
       }
       else{
           return false;
       }
   }
   
   @Override
   public boolean full(){
       if(anzahl < queue.length){
           return false;
       }
       else{
           return true;
       }
   }
   
   @Override
   public int size(){
       return queue.length;   
   }
   
   private void entferne(int index){
        for(int i = index; i < anzahl; i++){
            if(i < queue.length){
                queue[i] = queue[i + 1];
                queue[anzahl] = null;
            }
        }
        anzahl--;
       
   }
}