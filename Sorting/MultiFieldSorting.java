package com.sumon.sorting;
import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



//Simple model class
class Person{
	private String name;
	private int age;
	private String address;
	
	public Person(String name, int age, String address){
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString(){
		return String.format("%s\t%s\t%s", name, age, address);
	}
}


// Chained of Comparator
class PersonMultiFieldComparators implements Comparator<Person>{

	private List<Comparator<Person>> listOfComparators;
	
	
	public PersonMultiFieldComparators(Comparator<Person>... comparators) {
		this.listOfComparators = Arrays.asList(comparators);
	}
	
	@Override
	public int compare(Person p1, Person p2) {
		
		for(Comparator<Person> comparator : listOfComparators){
			int result = comparator.compare(p1, p2);
			
			if(result != 0 ){
				return result;
			}
		}
		
		return 0;
	}
	
}

// Sort by age Comparator
class PersonAgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		
		return (p1.getAge() - p2.getAge());
	}
	
}


//Sort by Name Comparator
class PersonNameCompartor implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getName().compareTo(p2.getName());
	}
	
}




public class MultiFieldSorting {

	public static void main(String[] args) {
	
		out.println("================= SORTING BY MULTIFIELD ====================");
		
		List<Person> listPersons = new ArrayList<Person>();
		
		listPersons.add(new Person("Kamrul", 35, "1403 College Heights"));
		listPersons.add(new Person("Hasan", 29, "1403 College Heights"));
		listPersons.add(new Person("Sumon", 30, "1403 College Heights"));
		listPersons.add(new Person("Kamrul Sumon", 25, "1403 College Heights"));
		listPersons.add(new Person("Kamrul Hasan", 20, "1403 College Heights"));
		listPersons.add(new Person("Kamrul Hasan Sumon", 20, "1403 College Heights"));
		
		out.println("==================== Before Sorting ===================");
		
		for(Person person : listPersons)
			out.println(person);
		
		Collections.sort(listPersons, new PersonMultiFieldComparators(
				new PersonAgeComparator(), 
				new PersonNameCompartor()
				));

		out.println("==================== After Sorting ===================");
		
		for(Person person : listPersons)
			out.println(person);
		
	}

}
