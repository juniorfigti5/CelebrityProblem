package co.com.celebrity.problem.loader;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LoaderTest {

	private Loader loader;
	
	@Before
	public void setup() {
		loader = new Loader();
	}
	
	@Test
	public void testLoadMatrix() {
		ArrayList<List<Integer>> matrix = loader.loadMatrix();
		assertNotNull(matrix);
		assertTrue(matrix.size()>0);
	}
	
	@Test
	public void testLoadCsv() {
		ArrayList<List<Integer>> csv = loader.loadCsv();
		assertTrue(csv.size()>0);
	}
}
