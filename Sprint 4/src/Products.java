
public class Products {
	
 private String Name;
 private String Price;
 private String Brand;
 private String Category;


public Products(String name, String price, String brand, String category) {
	super();
	Name = name;
	Price = price;
	Brand = brand;
	Category = category;
}

public Products() {
	super();
	// TODO Auto-generated constructor stub
}

public String getName() {
	return Name;
}
public void setName(String name) {
	this.Name = name;
}
public String getPrice() {
	return Price;
}
public void setPrice(String price) {
	this.Price = price;
}
public String getBrand() {
	return Brand;
}
public void setBrand(String brand) {
	Brand = brand;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	this.Category = category;
}

}