package MainApp;

import java.io.IOException;
import java.sql.SQLException;

import com.shoeshop.dao.CustomerDao;
import com.shoeshop.dao.PurchaseDao;
import com.shoeshop.dao.ShoeDao;

public class MainApp {
	public static void main(String[] args) throws IOException, SQLException {
		CustomerDao customerDao=new CustomerDao();
		ShoeDao shoeDao = new ShoeDao();
		PurchaseDao purchaseDao = new PurchaseDao();
		purchaseDao.insertValue(2, 4, 3);
		
	}

}
