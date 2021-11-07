package sockets.server;

public class AdderCommand {
	
	public AdderCommand() {
		super();
	}

	String process(String[] strings) {
		
		int ergebnis = 0;
		
		for (String i: strings) {
			if (i.equals("")) return null;
			int integer = Integer.parseInt(i);
			ergebnis = ergebnis + integer;
		}
		return "" + ergebnis;
	}
	
}
