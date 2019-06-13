package co.com.celebrity.problem.finder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FinderTest {


	@Test
	public void testFind() {
		ArrayList<List<Integer>> team = new ArrayList<List<Integer>>(Arrays.asList(
    			new ArrayList<Integer> (Arrays.asList(1, 0, 0, 0, 0, 1)),  
    			new ArrayList<Integer> (Arrays.asList(0, 1, 0, 0, 0, 1)), 
    			new ArrayList<Integer> (Arrays.asList(0, 0, 1, 0, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 1, 0, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 1, 1)),
    			new ArrayList<Integer> (Arrays.asList(0, 0, 0, 0, 0, 1))));
		int idCelebrity = Finder.find(team);
		assertNotNull(idCelebrity);
		assertEquals(5, idCelebrity);
	}
}
