import java.io.IOException;

public class Customer extends User {

	User cust = new User();
	
public void Customer_Login() throws IOException {
	cust.login();
}
	
public void Buy_Product(User u) throws IOException {
		cust.BuyProduct(u);
}

}