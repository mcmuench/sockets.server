package sockets.server;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Protocol {
	
	String process(String msg) {
		String dienst;
		String rueckgabe;
		
		// Addieren
		dienst = "+";
		AdderCommand ac = new AdderCommand();
					
		rueckgabe = ac.process(msg.split("\\" + dienst));
		
		/*
		 *  // Subtrahieren
		 *  
		 *  dienst = "-";
		 *  SubtractorCommand sc = new SubtractorCommand();
		 *  
		 *  rueckgabe = sc.process(msg.split("\\" + dienst));
		 *  
		 *  // Multiplizieren
		 *  
		 *  dienst = "*";
		 *  MultCommand mc = new MultCommand();
		 *  
		 *  rueckgabe = mc.process(msg.split("\\" + dienst));
		 *  
		 */
		
		return rueckgabe;
	}

}
