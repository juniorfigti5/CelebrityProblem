package co.com.celebrity.problem.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Loader {
	
	private static final Logger logger = Logger.getLogger( Loader.class.getName() );
	
	private static final String SPLIT = ",";
	private static final String CSV_URL = "./src/main/resources/team.csv";

	// Load and return data, everybody knows himself and celebrity if he exist
    public ArrayList<List<Integer>> loadMatrix() {
    	ArrayList<List<Integer>> team = new ArrayList<List<Integer>>(Arrays.asList(
    			new ArrayList<Integer> (Arrays.asList(1, 0, 0, 0, 0, 1)),  
    			new ArrayList<Integer> (Arrays.asList(0, 1, 0, 0, 0, 1)), 
    			new ArrayList<Integer> (Arrays.asList(0, 0, 1, 0, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 1, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 1, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 0, 1))));
    	logger.info("Team loaded: " + team);
    	return team;
    }
    
    public ArrayList<List<Integer>> loadCsv() {
    	ArrayList<List<Integer>> team = new ArrayList<List<Integer>>();
    	Path pathToFile = Paths.get(CSV_URL);
    	try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
    		String line = br.readLine();
    		while (line != null) {
                String[] attributes = line.split(SPLIT);
                List<String> memberStr = Arrays.asList(attributes); 
                List<Integer> member = memberStr.stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList());
                team.add(member);
                line = br.readLine();
            }

    		logger.info("Team loaded: " + team);
    	} catch (IOException ioe) {
            ioe.printStackTrace();
            logger.info("Error loading team: " + team);
        }
    	return team;
    }
}
