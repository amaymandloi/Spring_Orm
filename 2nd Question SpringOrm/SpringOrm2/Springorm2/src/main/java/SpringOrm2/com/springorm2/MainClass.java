package SpringOrm2.com.springorm2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.BillDao;
import com.springorm.dao.BillItemDao;
import com.springorm.dao.CategoryDao;
import com.springorm.dao.CustomerDao;
import com.springorm.dao.ItemDao;
import com.springorm.dao.SubcategoryDao;
import com.springorm.entity.Category;
import com.springorm.entity.Customer;
import com.springorm.entity.Item;
import com.springorm.entity.Subcategory;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringOrm2/applicationContext.xml");
		BillDao billDao = context.getBean("billDao", BillDao.class);
		BillItemDao billItemDao = context.getBean("billItemDao", BillItemDao.class);
		CategoryDao categoryDao = context.getBean("categoryDao", CategoryDao.class);
		CustomerDao customerDao = context.getBean("customerDao", CustomerDao.class);
		ItemDao itemDao = context.getBean("itemDao", ItemDao.class);
		SubcategoryDao subcategoryDao = context.getBean("subcategory", SubcategoryDao.class);

		// Find out total number of item in each subcategory
		System.out.println("***************************************************************");
		List<Subcategory> subCategories = subcategoryDao.getAllSubCategory();
		for (Subcategory subCategory : subCategories) {
			System.out.println("Total number of item in " + subCategory.getSubcatname() + " Subcategory:"
					+ itemDao.countItemBySubCategory(subCategory.getSubcatid()));
		}

		// Find out total number of item in each category.
		System.out.println("***************************************************************");
		List<Category> categories = categoryDao.getAllCategory();
		for (Category category : categories) {
			System.out.println("Total number of item in " + category.getCatname() + " Category:"
					+ itemDao.countItemByCategory(category.getCatid()));
		}

		// Find out total number of item which are out of stock
		System.out.println("***************************************************************");
		System.out.println("Total number of items which are out of stock : " + itemDao.countItemOutOfStock());

		// Total number of items from each category which are out of stock
		System.out.println("***************************************************************");
		for (Category category : categories) {

			System.out.println("Total number of items which are out of stock in " + category.getCatname()
					+ " categoey:  " + itemDao.countItemOutOfStockByCategory(category.getCatid()));
		}

		// Print Details of items which are out of stock
		System.out.println("***************************************************************");
		System.out.println("Items which are out of stock ");
		List<Item> itemOutOfStock = itemDao.itemOutOfStock();
		for (Item item : itemOutOfStock) {
			System.out.println(item);
		}

		// Print Details of items which are having price greater than average marks
		System.out.println("***************************************************************");
		List<Item> itemGreaterAveragePrice = itemDao.itemGreaterThanAveragePrice();
		System.out.println("Items which are having price greater than average marks");
		for (Item item : itemGreaterAveragePrice) {
			System.out.println(item);
		}

		// Print Details of item which are having highest discount.
		System.out.println("***************************************************************");
		System.out.println("Item which are having highest discount");
		System.out.println(itemDao.getItemHavingHighestDiscount());

		// Print details of items which are having lowest selling
		System.out.println("***************************************************************");
		List<Item> itemLowestSelling = itemDao.getItemLowestSelling();
		for (Item item : itemLowestSelling) {
			System.out.println(item);
		}
		System.out.println("***************************************************************");
		// Print details of items which are having highest selling.
		List<Item> items = itemDao.getItems();
		List<Item> highestSellings = new ArrayList<Item>();
		int temp = 0;
		for (Item item : items) {
			int itemSelling = billItemDao.getSellingItemById(item.getItemid());
			if (itemSelling > temp) {
				temp = itemSelling;
				highestSellings.clear();
				highestSellings.add(item);
			} else if (itemSelling == temp) {
				highestSellings.add(item);
			}
		}
		System.out.println("Highest Selling items Selling in " + temp + " times");
		for (Item item : highestSellings) {
			System.out.println(item);
		}

		// Print details of customer which buy item often
		System.out.println("***************************************************************");
		int max = billDao.getMaxItemPurchased();
		List<Integer> customerIdBuyOften = billDao.getCustomerIdBuyOftenItem(max);
		System.out.println("Details of Customer which buy item often");
		for (int customerid : customerIdBuyOften) {
			Customer customer = customerDao.getCustomerFromId(customerid);
			System.out.println(customer);
		}
		// Print total selling of each day.
		System.out.println("***************************************************************");
		List<Date> allBillDates = billDao.getAllBillDates();
		List<Integer> billId;
		double totalSelling;
		for (Date date : allBillDates) {
			billId = billDao.getBillIdFromDate(date);
			totalSelling = billItemDao.getTotalSellingPerDayFromBillId(billId);
			System.out.println("Total selling of date " + date + " is : " + totalSelling);
		}
		// Print average selling of each day
		System.out.println("***************************************************************");
		double averageSelling;
		for (Date date : allBillDates) {
			billId = billDao.getBillIdFromDate(date);
			averageSelling = billItemDao.getAverageSellingPerDayFromBillId(billId);
			System.out.println("Average selling of date " + date + " is : " + averageSelling);
		}

	}
}
