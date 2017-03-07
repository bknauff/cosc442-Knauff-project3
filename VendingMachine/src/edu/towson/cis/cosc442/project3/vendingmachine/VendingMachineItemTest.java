package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	
	VendingMachineItem product_item;
	VendingMachineException machineException;
	
	/*
	 * Initialize two objects as requested of test cases
	 * 
	 * @throws Exception the exception
	 * 
	 */
	
	@Before
	public void setUp() throws Exception {
		product_item = new VendingMachineItem("Mtn Dew", 1.75);
		machineException = new VendingMachineException();
	}

	@Test
	/*
	 * Test custom constructor
	 */
	public void testConstructor(){
		assertNotNull(product_item);
	}

	@Test(expected = VendingMachineException.class)
	public void testNegativeValues(){
		assertSame(machineException, new VendingMachineItem("Water", -5.0));
	}
	
	@Test
	/*
	 * Test for getName method
	 * Test to see if the item returns the correct name
	 */
	public void testGetName() {
		assertEquals("Mtn Dew", product_item.getName());
	}

	@Test
	/*
	 * Test for getPrice method
	 * Test to see if the price of the item is correct as initialized
	 */
	public void testGetPrice() {
		assertEquals(1.75, product_item.getPrice(),0.001);
	}

	/*
	 * @throws java.lang.Exception
	 * Assign objects to null
	 */
	@After
	public void tearDown() throws Exception {
		product_item = null;
		machineException = null;
	}
}
