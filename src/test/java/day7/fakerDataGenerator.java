package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class fakerDataGenerator {
	
	@Test
	public void testGenerateDummyData() {
		Faker faker = new Faker();
		String fullname= faker.name().fullName();
		String Lastname=faker.name().lastName();
		String First=faker.name().firstName();
		String User=faker.name().username();
		String pass= faker.internet().password(3, 50);
		String ph=faker.phoneNumber().cellPhone();
		String mail=faker.internet().emailAddress();
		
	}

}
