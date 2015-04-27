package com.mf.netCourier;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeliniumTest {

	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
				WebDriver driver = new FirefoxDriver();
				// Wait For Page To Load
				// Put a Implicit wait, this means that any search for elements on the page
				// could take the time the implicit wait is set for before throwing exception
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Navigate to URL
				driver.get("http://meta4:password@nagios.metafour.com/nagios/cgi-bin/status.cgi?hostgroup=netcourier&style=detail&start=100&limit=100");

				// Maximize the window.
				driver.manage().window().maximize();
				
				System.out.println("Net Courier Service Test Started:");
				
				// Click on Service Status Totals:Warning Link
				// driver.findElement(By.xpath("//td[3]/table/tbody/tr/td/table/tbody/tr/th[2]/a")).click();

				String warning_result = driver.findElement(
						By.xpath("//td[3]/table/tbody/tr/td/table/tbody/tr[2]/td[2]"))
						.getText();

				if (warning_result.equals("0")) {

					System.out.println("Service Status Types:	No Warning found");
				} else {
					System.out.println("Service Status Types:	Warning = "
							+ warning_result);
				}
				
				String critical_result = driver.findElement(
						By.xpath("//td[3]/table/tbody/tr/td/table/tbody/tr[2]/td[4]"))
						.getText();

				if (critical_result.equals("0")) {

					System.out.println("Service Status Types:	No Critical found");
				} else {
					System.out.println("Service Status Types:	Critical = "
							+ critical_result);
				}
				
				String pending_result = driver.findElement(
						By.xpath("//td[3]/table/tbody/tr/td/table/tbody/tr[2]/td[5]"))
						.getText();

				if (pending_result.equals("0")) {

					System.out.println("Service Status Types:	No Pending found");
				} else {
					System.out.println("Service Status Types:	Pending = "
							+ pending_result);
				}
				// Close the browser.
				driver.close();

	}

}
