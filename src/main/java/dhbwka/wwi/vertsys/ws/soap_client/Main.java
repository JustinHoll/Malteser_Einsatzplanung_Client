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

import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.MalteserSOAPService;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.MalteserSOAPService_Service;
import dhbwka.wwi.vertsys.javaee.malteser.soap.ws.Task;
import java.util.List;

/*
 * Mini-Beispiel zum Aufruf eines SOAP-Webservices. Damit das funktioniert, muss
 * im Hintergrund das Projekt "SOAP_Server_Beispiel" ausgeführt werden.
 */
public class Main {

    public static void main(String[] args) {
        //Stub-Objekt zum entfernten Aufruf erstellen
        MalteserSOAPService_Service service = new MalteserSOAPService_Service();
        MalteserSOAPService einsatzWs = service.getMalteserSOAPServicePort();
        List<Task> einsatzliste = einsatzWs.findAllTasks();
        for(Task einsatz : einsatzliste){
            System.out.println(einsatz.getStatus());
        }
        
        
        // Webservice-Operation "findAll" aufrufen
        //List<Movie> allMovies = movieWs.findAll();

        // Abgerufenes Ergebnis anzeigen
        System.out.println("========================");
        System.out.println("Alle Einsätze");
        System.out.println("========================");
        System.out.println();
        
//        for (Movie movie : allMovies) {
//            System.out.println("Name:         " + movie.getName());
//            System.out.println("Beschreibung: " + movie.getDescription());
//            System.out.println("Jahr:         " + movie.getReleaseYear());
//            System.out.println();
//        }
    }
}
