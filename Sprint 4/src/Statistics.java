import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TimerTask;

public class Statistics extends TimerTask{
	 private int products_views ;
 private int sold_products;
 private int orderd_Product;
 
 
public int getOrderd_Product() {
	return orderd_Product;
}
public void setOrderd_Product(int orderd_Product) {
	this.orderd_Product = 0;
}
public int getProducts_views() {
	return products_views;
}
public void setProducts_views(int products_views) {
	this.products_views =0;
}

public int getSold_products() {
	return sold_products;
}
public void setSold_products(int sold_products) {
	
	this.sold_products =0;
}

//verride
/*public void run() {
	System.out.println("the orderd barnds Statistics");
	System.out.println(getOrderd_brand());
	System.out.println("the Productsviews Statistics");
	System.out.println(getProducts_views());
	System.out.println("Our Sold Products Statistics");
	System.out.println(getSold_products());
	System.out.println("Our Stores View Statistics");
	System.out.println(getStores_view());
	
}*/
@Override
public void run() {
UsersStatistics v=new UsersStatistics();
ProductsStatistics t=new  ProductsStatistics();
System.out.println("the sold products Statistics");
try {
	System.out.println(v.sum_users());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("the  Most Ordered Product Statistics");
try {
	t.maxproduct();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("the products view Statistics");
System.out.println(getProducts_views());

}


}
