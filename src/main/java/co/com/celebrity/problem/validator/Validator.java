package co.com.celebrity.problem.validator;

import java.util.ArrayList;

public class Validator {

	// true if a knows b, false otherwise
    public static boolean aKnowsB (ArrayList<ArrayList<Integer>> people, int a, int b) 
    { 
        return people.get(a).get(b) == 1 ?  true :  false;
    }
}
