/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apttableformatter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tim
 */
public class AptFormatterTest {
    
    public AptFormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    private String content = "*----------------------------------------------------+----------------------------------------------------------+\n" +
"|Transaktionsschlüssel                            |Dieser Schlüssel beinhaltet die Referenz auf das          |\n" +
"|                                                     |gehandelte <<Instrument>> sowie das <<Portfolio>>,        |\n" +
"|                                                     |in dem gehandelt wurde.                                   |\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Quell Id                         |max. Länge: 255 Zeichen, Id der Transaktion im Quellsystem|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Quell Typ                       |max. Länge: 255 Zeichen, Typ der Transaktion im Quellsystem|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Handelstag                      |Handelstag                               |\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Handelszeit                     |Handelstag inkl. Uhrzeit                 |\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Valuta                          |Datum der Wertstellung                   |\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Nominal/Stück                   |2 Nachkommastellen, Anzahl der Aktien, Nominal der Anleihe, Kontraktzahl, etc.|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Neuer Bestand Nominal/Stück     |2 Nachkommastellen, Anzahl der Aktien, Nominal der Anleihe, Kontraktzahl, etc.,|\n" +
"|                                |die nach der Transaktion im Bestand sind.|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Preis                           |6 Nachkommatellen, Preis in Transaktionswährung|\n" +
"*-----------------------------------------------------+-----------------------------------------+\n" +
"|Stückzinsen HW                  |2 Nachkommastellen, aufgelaufene Stückzinsen für Zinsinstrumente in Transaktionswährung|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Stückzinsen SW                  |2 Nachkommastellen, aufgelaufene Stückzinsen für Zinsinstrumente in Abrechnungskontowährung|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Stückzinsen PW                  |2 Nachkommastellen, aufgelaufene Stückzinsen für Zinsinstrumente in Portfoliowährung|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Gebühr HW                       |2 Nachkommastellen, Gebühr in Transaktionswährung|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Gebühr SW                       |2 Nachkommastellen, Gebühr in Abrechnungskontowährung|\n" +
"*-----------------------------------------------------+----------------------------------------------------------+\n" +
"|Gebühr PW                       |2 Nachkommastellen, Gebühr in Depotwährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Kommission HW                   |2 Nachkommastellen, Kommission in Transaktionswährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Kommission SW                   |2 Nachkommastellen, Kommission in Abrechnungskontowährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Kommission PW                   |2 Nachkommastellen, Kommission in Depotwährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Steuern HW                      |2 Nachkommastellen, Steuern in Transaktionswährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Steuern SW                      |2 Nachkommastellen, Steuern in Abrechnungskontowährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Steuern PW                      |2 Nachkommastellen, Steuern in Depotwährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|sonstige Kosten HW              |2 Nachkommastellen, sonstige Kosten in Transaktionswährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|sonstige Kosten SW              |2 Nachkommastellen, sonstige Kosten in Abrechnungskontowährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|sonstige Kosten PW              |2 Nachkommastellen, sonstige Kosten in Depotwährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|ausm. Betrag HW                 |2 Nachkommastellen, ausmachender Betrag in Transaktionswährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|ausm. Betrag SW                 |2 Nachkommastellen, ausmachender Betrag in Abrechnungskontowährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|ausm. Betrag PW                 |2 Nachkommastellen, ausmachender Betrag in Portfoliowährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Handelswährung                  |Auswahl aus Liste                        |\n" +
"|                                |{{{./10_staticdata.html}Währungen}}|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Settlementwährung               |Auswahl aus Liste                        |\n" +
"|                                |{{{./10_staticdata.html}Währungen}}|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Devisenkurs                     |6 Nachkommastellen, Devisenkurs Transaktionswährung nach Portfoliowährung|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Broker                          |Auswahl aus Liste                        |\n" +
"|                                |{{{./10_staticdata.html}Banken}}         |\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Börse                           |max. Länge: 255 Zeichen, Freier Text zur Bezeichnung der Börse|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Clearing Datum                  |Datum des Clearings                      |\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Stornierte Transaktion          |Link zu der stornierten Transaktion|\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Transaktionstyp                 |Auswahl aus Liste (s.u.)                 |\n" +
"*--------------------------------+----------------------------------------------------------+\n" +
"|Settlement Instruction          |Freitext, max. Länge: 1024 Zeichen, Settlement Instructions|\n" +
"*--------------------------------+----------------------------------------------------------+";
    
    String content2 = "+---------------------------++------------------------------------------------------------+\n" +
"|Transaktionsschlüssel      |key|INTEGER |Dieser Schlüssel beinhaltet die Referenz auf das gehandelte |\n" +
"|                           || |<<Instrument>> sowie das <<Portfolio>>, in dem gehandelt    |\n" +
"|                           || |wurde.                                                      |\n" +
"+---------------------------++-+------------------------------------------------------------+";
    
    @Test
    public void test() {
        String s = "|Settlement Instruction          |Freitext, max. Länge: 1024 Zeichen, Settlement Instructions|";
        String[] splits = s.split("\\|");
        
        System.out.println(splits.length);
        
        for (int i = 0; i < splits.length; i++) {
            System.out.println(splits[i]);
        }
    }
    
    /**
     * Test of process method, of class AptFormatter.
     */
    @Test
    public void testProcess() {
        System.out.println("process");
        apttableformatter.AptFormatter formatter = new apttableformatter.AptFormatter(content);
        
        formatter.process();
        
        System.out.println(formatter.getTarget());
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of process method, of class AptFormatter.
     */
    @Test
    public void testProcess2() {
        System.out.println("process");
        apttableformatter.AptFormatter formatter = new apttableformatter.AptFormatter(content2);
        
        formatter.process();
        
        System.out.println(formatter.getTarget());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
