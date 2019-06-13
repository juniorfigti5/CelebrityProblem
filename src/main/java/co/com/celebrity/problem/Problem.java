package co.com.celebrity.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import co.com.celebrity.problem.finder.Finder;
import co.com.celebrity.problem.loader.Loader;

public class Problem {
	private static final Logger logger = Logger.getLogger( Problem.class.getName() );

	private Loader loader;
	
	private Finder finder;

	public Problem() {
		loader = new Loader();
		finder = new Finder();
    	ArrayList<List<Integer>> team = loader.loadCsv();
		int idCelebridad = finder.find(team);
		logger.info("The Celebrity Id is: " + idCelebridad);
	}
}
