package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine vendingMachine;
	VendingMachineItem vendingMachineItem;
	VendingMachineException vendingMachineException;

	@Before
	public void setUp() throws Exception {
		vendingMachine = new VendingMachine();
		vendingMachineItem = new VendingMachineItem("Mtn Dew", 1.70);
		vendingMachineException = new VendingMachineException();
		vendingMachine.addItem(vendingMachineItem, VendingMachine.D_CODE);
	}
	
	/*
	 * Assigns all objects to null
	 */
	@After
	public void tearDown() throws Exception {
		vendingMachine = null;
		vendingMachineItem = null;
	}

	/*
	 * Test method for adding an item and checking if the vending machine accepts or not
	 * After adding we will try to add another item, and check for the 
	 * expected exception in next method
	 */
	@Test
	public void testAddItem() {
		vendingMachine.addItem(vendingMachineItem, VendingMachine.B_CODE);
	}
	
	/*
	 * Test method for exception
	 * Adding another item method to see if it throws exception
	 * to check if we added a unique item or not
	 */	
	@Test(expected = VendingMachineException.class)
	public void testAddItemForException(){
		vendingMachine.addItem(vendingMachineItem, VendingMachine.A_CODE);
		vendingMachine.addItem(vendingMachineItem, VendingMachine.B_CODE);
		vendingMachine.addItem(vendingMachineItem, VendingMachine.C_CODE);
		vendingMachine.addItem(vendingMachineItem, VendingMachine.D_CODE);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testAddItemUnknown(){
		vendingMachine.addItem(vendingMachineItem, "E");
	}
	
	/*
	 * Test remove item method. Test if the item object is removed
	 * If removed then it will return a null value when trying to 
	 * retrieve the same item again
	 */
	@Test
	public void testRemoveItem() {
		vendingMachine.removeItem(VendingMachine.D_CODE);
		assertNull(vendingMachine.getItem(VendingMachine.D_CODE));
	}
	
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemExceptionCheck(){
		vendingMachine.removeItem(VendingMachine.D_CODE);
	    vendingMachine.removeItem(VendingMachine.D_CODE);
	}

	//Testing for Unknown
	@Test(expected = VendingMachineException.class)
	public void testRemoveUnknownItem(){
		vendingMachine.removeItem("E");
	}
	
	/*
	 * Test method that will return the balance which has been inserted
	 */	
	@Test
	public void testInsertMoney() {
		vendingMachine.insertMoney(1.75);
		assertEquals(1.75, vendingMachine.getBalance(), 0.0);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testInsertMoneyNegativeValue(){
		vendingMachine.insertMoney(-1.0);
	}

	/*
	 * Test get balance method which will return the balance
	 * which has been inserted into the machine
	 */
	@Test
	public void testGetBalance() {
		vendingMachine.insertMoney(1.75);
		assertEquals(1.75, vendingMachine.getBalance(), 0.0);
	}

	/*
	 * Test method makePurchase which will try to purchase an item
	 * and check if it succeeds
	 */
	@Test
	public void testMakePurchase() {
		vendingMachine.insertMoney(2.0);
		assertTrue(vendingMachine.makePurchase(VendingMachine.D_CODE));
	}
	
	@Test
	/*
	 * Check to see if it will allow to make same purchase again
	 */
	public void testPurchaseForNull(){
		assertFalse(vendingMachine.makePurchase(VendingMachine.D_CODE));
	}

	/*
	 * Test method for returnChange
	 * Will check if the vending machine returns the balance correctly
	 */
	@Test
	public void testReturnChange() {
		vendingMachine.insertMoney(2.0);
		assertTrue(vendingMachine.makePurchase(VendingMachine.D_CODE));
		assertEquals(0.25, vendingMachine.returnChange(), 0.5);
	}

}
