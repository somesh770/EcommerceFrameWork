package Utility_PACK;

import com.github.javafaker.Faker;

public class Datafaker {
	
	Faker faker = new Faker();

	public String faker_FirstName() {
	return	faker.name().firstName();
	}

	public String faker_lastname() {

		return	faker.name().lastName();
	}
}
