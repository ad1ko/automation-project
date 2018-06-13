package com.cybertek;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class Batch8 {
	public static void main(String[] args) {
		System.out.println("AdiLet");
		
		Faker faker = new Faker();
		String creditCard =  faker.finance().creditCard();
		String ChuckNorris = faker.chuckNorris().fact();
		String some = faker.hacker().abbreviation();
		String some1 = faker.beer().name();
		String some2 = faker.gameOfThrones().city();
		String some3 = faker.cat().breed();
		System.out.println(creditCard);
		System.out.println(ChuckNorris);
		System.out.println(some);
		System.out.println(some1);
		System.out.println(some2);
		System.out.println(some3);
		
		WebDriver driver;
	}

}
