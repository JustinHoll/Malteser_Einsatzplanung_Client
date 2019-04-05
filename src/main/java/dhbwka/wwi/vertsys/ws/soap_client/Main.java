/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.ws.soap_client;

import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.AccessRestrictedException_Exception;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.Category;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.FindAllCategories;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.FindAllTasks;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.InvalidCredentialsException_Exception;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.MalteserSOAPService;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.MalteserSOAPService_Service;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.Task;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/*
 * Mini-Beispiel zum Aufruf eines SOAP-Webservices. Damit das funktioniert, muss
 * im Hintergrund das Projekt "SOAP_Server_Beispiel" ausgeführt werden.
 */
public class Main {
    
    static BufferedReader fromKeyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        System.out.println("============");
        System.out.println("Einsatzplanung API");
        System.out.println("============");
        System.out.println("============");
        System.out.println("Bitte loggen Sie sich ein:");
        System.out.print("Username: ");
        String username = fromKeyboard.readLine();
        System.out.print("Passwort: ");
        String passwort = fromKeyboard.readLine();

        //Stub-Objekt zum entfernten Aufruf erstellen
        MalteserSOAPService_Service service = new MalteserSOAPService_Service();
        MalteserSOAPService einsatzWs = service.getMalteserSOAPServicePort();
        
        System.out.println("============");
        System.out.println("Alle Einsätze");
        System.out.println("============");
        FindAllTasks findTasks = new FindAllTasks();
        List<Task> einsatzliste = einsatzWs.findAllTasks(findTasks, username, passwort).getEinsatz();
        for(Task einsatz : einsatzliste){
            System.out.println(einsatz.getShortText());
        }
        
        System.out.println("============");
        System.out.println("Alle Kategorien");
        System.out.println("============");
        FindAllCategories findCategories = new FindAllCategories();
        List<Category> categoriesListe = einsatzWs.findAllCategories(findCategories, username, passwort).getKategorie();
        for(Category category : categoriesListe){
            System.out.println(category.getName());
        }
       
        
    }
}
