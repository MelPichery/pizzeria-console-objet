package com.pizzeria.pizzeria;

import java.util.Comparator;

public class ComparatorCode implements Comparator<Pizza> {

	@Override
	public int compare(Pizza o1, Pizza o2) {
		
		return o2.getCode().compareTo(o1.getCode());
	}

}
