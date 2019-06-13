package co.com.celebrity.problem.finder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FinderTest {

	private Finder finder;
	
	@Before
	public void setup() {
		finder = new Finder();
	}

	@Test
	public void testFind() {
		ArrayList<List<Integer>> team = new ArrayList<List<Integer>>(Arrays.asList(
    			new ArrayList<Integer> (Arrays.asList(1, 0, 0, 0, 0, 1)),  
    			new ArrayList<Integer> (Arrays.asList(0, 1, 0, 0, 0, 1)), 
    			new ArrayList<Integer> (Arrays.asList(0, 0, 1, 0, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 1, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 1, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 0, 1))));
		int idCelebrity = finder.find(team);
		assertEquals(5, idCelebrity);
	}

	@Test
	public void testFindWhenMoreCelebrities() {
		ArrayList<List<Integer>> team = new ArrayList<List<Integer>>(Arrays.asList(
    			new ArrayList<Integer> (Arrays.asList(1, 0, 0, 0, 0, 0)),  
    			new ArrayList<Integer> (Arrays.asList(0, 1, 0, 0, 0, 0)), 
    			new ArrayList<Integer> (Arrays.asList(0, 0, 1, 0, 0, 0)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 1, 0, 0)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 1, 0)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 0, 1))));
		int idCelebrity = finder.find(team);
		assertEquals(-1, idCelebrity);
	}

	@Test
	public void testFindWhenNoCelebrity() {
		ArrayList<List<Integer>> team = new ArrayList<List<Integer>>(Arrays.asList(
    			new ArrayList<Integer> (Arrays.asList(1, 1, 0, 0, 0, 0)),  
    			new ArrayList<Integer> (Arrays.asList(0, 1, 1, 0, 0, 0)), 
    			new ArrayList<Integer> (Arrays.asList(0, 0, 1, 1, 0, 0)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 1, 1, 0)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 1, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 1, 1))));
		int idCelebrity = finder.find(team);
		assertEquals(-1, idCelebrity);
	}

	@Test
	public void testFindWhenEmpty() {
		ArrayList<List<Integer>> team = new ArrayList<List<Integer>>();
		int idCelebrity = finder.find(team);
		assertEquals(-1, idCelebrity);
	}
}
