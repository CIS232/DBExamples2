package edu.cis232.DBExamples2;

import java.util.List;

import edu.cis232.DBExamples2.model.Coffee;
import edu.cis232.DBExamples2.repository.CoffeeRepository;

public class CoffeeDataModelExample {

	public static void main(String[] args) {
		CoffeeRepository repo = new CoffeeRepository();
		Coffee newCoffee = new Coffee("Dan's Dark", "32-200", 20.95);
		repo.save(newCoffee);
		
		List<Coffee> coffees = repo.findByDescriptionLike("%Dark%");
		
		for(Coffee c : coffees){
			System.out.println(c);
		}
	}

}
