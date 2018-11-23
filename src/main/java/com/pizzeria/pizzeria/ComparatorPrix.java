package com.pizzeria.pizzeria;

import java.util.Comparator;

public class ComparatorPrix implements Comparator<Pizza>  {

	@Override
	public int compare(Pizza o1, Pizza o2) {
		
		return o1.getPrix().compareTo(o2.getPrix());
	}


}
