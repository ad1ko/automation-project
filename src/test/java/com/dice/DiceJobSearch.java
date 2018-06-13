package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();// setup chrome driver path
		
		WebDriver dr = new ChromeDriver(); // invoking selenium driver
		//fullscreen
		dr.manage().window().fullscreen();// or maximize();
		//set universal wait time in case web page is slow
		dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/*
		 * 1. Launch browser and navigate to https://dice.com 
	Expected: dice home page should be displayed 
		 */
		String url = "https://dice.com";
		dr.get(url);
		
		String actualTitle = dr.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS. Dice homepage successfully loaded");
		}else {
			System.out.println("Step FAILED. Dice homepage did not successfully loaded");
			throw new RuntimeException("Step FAILED. Dice homepage did not successfully loaded");
		}
		
		
		/*
		 * 2. Insert search keyword and location then click on find tech jobs 
	Expected: - Search results page should be located.
			  - Page title should contain count of results, along with search keyword.
			  - Count of results should be displayed on the page.
		 */
		
		String keyword = "java developer";
		dr.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		String location = "60645";
		dr.findElement(By.id("search-field-location")).clear();
		dr.findElement(By.id("search-field-location")).sendKeys(location);
		
		dr.findElement(By.id("findTechJobs")).click(); //  some times it needs to put submit();
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		
		String count = dr.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		//ensure count is more than 0 
		int countReslut = Integer.parseInt(count.replace(",", ""));
		
		if(countReslut>0) {
			System.out.println("keyword: "+ keyword+" search returned "+countReslut+" result in "+ location);
		}else {
			System.out.println("step FAILED: Keyword : "+ keyword + "search returned "+ countReslut +"result in"+location);
		}
		
		dr.manage().window();
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		dr.close();
		System.out.println("Test completed at "+LocalDateTime.now());
		

		
		
		

	}

}
