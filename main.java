/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;
import java.util.*;
import java.util.Map.Entry;
/**
 *
 * @author LongGTL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  	  
      HashMap<String, String> hm = new HashMap<String, String>();

        String Name = null;
        String Phone;
      while(true) {
          
        System.out.println("Student name: ");
        Name = sc.nextLine();
        if((Name.equals("x") == true) || (Name.equals("X") == true)) break;
        System.out.println("Student phone: ");
        Phone = sc.nextLine();
        hm.put(Name, Phone);
       }
      Set<Entry<String, String>> set = hm.entrySet();
      
      Iterator<Entry<String, String>> i = set.iterator();
      
      while(i.hasNext()) {
        Map.Entry me = (Map.Entry)i.next();
        System.out.print("Name: " + me.getKey() + " ||***|| Phone:  ");
        System.out.println(me.getValue());
      }
      System.out.println();
    }
    
}