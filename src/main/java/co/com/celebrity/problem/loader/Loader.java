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
import java.util.stream.Collectors;

public class Loader {
	
	// Load and return data, everybody knows himself and celebrity if he exist
    public ArrayList<List<Integer>> loadMatrix() {
    	ArrayList<List<Integer>> team = new ArrayList<List<Integer>>(Arrays.asList(
    			new ArrayList<Integer> (Arrays.asList(1, 0, 0, 0, 0, 1)),  
    			new ArrayList<Integer> (Arrays.asList(0, 1, 0, 0, 0, 1)), 
    			new ArrayList<Integer> (Arrays.asList(0, 0, 1, 0, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 1, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 1, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 0, 1))));
    	System.out.println("Team loaded: " + team);
    	return team;
    }
    
    public ArrayList<List<Integer>> loadCsv() {
    	ArrayList<List<Integer>> team = new ArrayList<List<Integer>>();
    	Path pathToFile = Paths.get("./src/main/resources/team.csv");
    	try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
    		String line = br.readLine();
    		while (line != null) {
                String[] attributes = line.split(",");
                List<String> memberStr = Arrays.asList(attributes); 
                List<Integer> member = memberStr.stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList());
                team.add(member);
                line = br.readLine();
            }

        	System.out.println("Team loaded: " + team);
    	} catch (IOException ioe) {
            ioe.printStackTrace();
        	System.out.println("Error loading team: " + team);
        }
    	return team;
    }
}
