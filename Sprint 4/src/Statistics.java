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
     UsersStatistics StoreOwn_stat = new UsersStatistics();
     ProductsStatistics StoreOwnprod_stat = new  ProductsStatistics();
 
 
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

@Override
public void run() {

System.out.println("the sold products Statistics");
try {
	System.out.println(StoreOwn_stat.sum_users());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("the  Most Ordered Product Statistics");
try {
	StoreOwnprod_stat.maxproduct();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("the products view Statistics");
System.out.println(getProducts_views());

}


}
