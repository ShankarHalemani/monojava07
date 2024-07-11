package com.techlabs.model;

import java.util.Objects;

public class Person {
	private String personName;
	private int personAge;
	private String personAddress;

	public Person(String personName, int personAge, String personAddress) {
		this.personName = personName;
		this.personAge = personAge;
		this.personAddress = personAddress;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Person person = (Person) obj;

		return personAge == person.personAge && Objects.equals(personName, person.personName)
				&& Objects.equals(personAddress, person.personAddress);
	}

	@Override
	public int hashCode() {

		return Objects.hash(personName, personAge, personAddress);
	}

	@Override
	public String toString() {
		return "\n[personName=" + personName + ", personAge=" + personAge + ", personAddress=" + personAddress + "]";
	}

}
