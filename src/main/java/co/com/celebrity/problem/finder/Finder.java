package co.com.celebrity.problem.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Finder {
	private static final Logger logger = Logger.getLogger( Finder.class.getName() );
	
	private static final int TRUE_VALUE = 1;
	private static final int KNOWS_BY_CELEBRITY = 1;
	
	// return:
	// -1 if celebrity is not present or more than 1. 
    // id (value from 0 to n-1) if present. 
	// Precondition: Data has same number of rows and columns, if not algorith can find more than 1 celebrity or none 
	public int find(ArrayList<List<Integer>> team) {
		int resp = -1;
    	List<List<Integer>> celebrities = team.stream().filter(isCelebrity()).collect(Collectors.toList());
    	logger.info("Posible celebrities are: "+ celebrities);
    	if (celebrities.size()>1) {
    		logger.info("More than one celebrity");
    	} else if(celebrities.isEmpty()) {
    		logger.info("There are not celebrities");
    	} else {
    		Optional<List<Integer>> optCelebrity = celebrities.stream().findFirst();
    		if (optCelebrity.isPresent()) {
    			List<Integer> celebrity = optCelebrity.get();
    			resp = IntStream.range(0, celebrity.size()).filter(e-> celebrity.get(e)==TRUE_VALUE).findFirst().getAsInt();
    		}
    	}
    	return resp;
	}
	
	private Predicate<? super List<Integer>> isCelebrity() {
		return e ->e.stream().mapToInt(i->i).sum()==KNOWS_BY_CELEBRITY;
	}
}
