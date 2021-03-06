// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package tests;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import reports.CompanyReport;
import reports.DataNotProcessedException;

public class CompanyReportTest
{

	@Test
	public void unprocessedToStringTest()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		String expected = "Fortune 500 Report for Nike ranked 0 times\n"
				+ "Revenue\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Profit\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Rank\n"
				+ "Min: null Max: null Avg: nul StD: nul";

		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization,"
						+ "spacing, and format",
				expected, c.toString());
	}
	@Test
	public void basicCompanyToStringTest()
	{
		File inputFile = new File("fortune500.csv");
		CompanyReport d = new CompanyReport(inputFile, "Witco");
		d.processReport();
		assertEquals("Fortune 500 Report for Witco ranked 20 times\n"
				+ "Revenue\n"
				+ "Min: 95.600 Max: 966.800 Avg: 336.275 StD: 241.165\n"
				+ "Profit\n"
				+ "Min: 3.000 Max: 42.800 Avg: 13.805 StD: 10.437\n"
				+ "Rank\n"
				+ "Min: 294 Max: 413 Avg: 367.450 StD: 35.518", d.toString());
		
	}
	@Test (expected = DataNotProcessedException.class)
	public void dataNotProcessedException()
	{
		File inputFile = new File("fortune500.csv");
		CompanyReport d = new CompanyReport(inputFile, "Witco");
		File outputFile = new File ("output.txt");
		d.writeReport(outputFile);
	}
	@Test 
	public void fileNotFoundTest()
	{
		File inputFile = new File("fortune50.csv");
		CompanyReport d = new CompanyReport(inputFile, "Witco");
		assertFalse(d.processReport());
	}
	@Test
	public void methodCTest()
	{
		CompanyReport z = new CompanyReport(new File("fortune500.csv"), "Witco");
		assertEquals (z.getCompany(), "Witco");
	}
	@Test
	public void getCompanyMethodTest()
	{
		CompanyReport z = new CompanyReport(new File("fortune500.csv"), "Witco");
		assertEquals(z.getCompany(), "Witco");
	}
	
}
