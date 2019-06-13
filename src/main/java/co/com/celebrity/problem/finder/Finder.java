package co.com.celebrity.problem.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import co.com.celebrity.problem.loader.Loader;

public class Finder {
	
	private Loader loader;

	public Finder() {
		loader = new Loader();
    	ArrayList<List<Integer>> team = loader.loadCsv();
		int idCelebridad = find(team);
		System.out.println("The Celebrity´s Id is: " + idCelebridad);
	}
	
	// return:
	// -1 if celebrity is not present or more than 1. 
    // id (value from 0 to n-1) if present. 
	// Precondition: Data has same number of rows and columns, if not algorith can find more than 1 celebrity or none 
	public static int find(ArrayList<List<Integer>> team) {
		int resp = -1;
    	List<List<Integer>> celebrities = team.stream().filter(isCelebrity()).collect(Collectors.toList());
    	System.out.println("Posible celebrities are: "+ celebrities);
    	if (celebrities.size()>1) {
    		System.out.println("More than one celebrity");
    	} else if(celebrities.size() == 0) {
    		System.out.println("There are not celebrities");
    	} else {
    		Optional<List<Integer>> optCelebrity = celebrities.stream().findFirst();
    		if (optCelebrity.isPresent()) {
    			List<Integer> celebrity = optCelebrity.get();
    			resp = IntStream.range(0, celebrity.size()).filter(e-> celebrity.get(e)==1).findFirst().getAsInt();
    		} else {
        		System.out.println("Error");
    		}
    	}
    	return resp;
	}
	
	private static Predicate<? super List<Integer>> isCelebrity() {
		return e ->e.stream().mapToInt(i->i).sum()==1;
	}
}
