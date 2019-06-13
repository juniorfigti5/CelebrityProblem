package co.com.celebrity.problem;

import java.util.logging.Logger;

public class App {	
	private static final Logger logger = Logger.getLogger( App.class.getName() );
	
    public static void main( String[] args )
    {
    	logger.info( "CELEBRITY PROBLEM!!" );
    	new Problem();
    	logger.info( "THANK YOU!" );
    }
}
