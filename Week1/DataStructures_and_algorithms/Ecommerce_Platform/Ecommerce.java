import java.util.*;
public class Product {
	
	int productId;
	String ProductName="";
	String category ="";
	
	Product(){
		
	}
	Product(int id,String name,String category){
		this.productId =id;
		this.ProductName = name;
		this.category = category;
	}
	void linearSearch(String category, List<Product> db) {
		for (Product prod : db) {
		    if(prod.category.equals(category)) {
		    	System.out.println("Id found");
				System.out.println(prod.productId);
				System.out.println(prod.ProductName);
				System.out.println(prod.category);
				System.out.println();
		    }
		}
		
		
	}
	void BinarySearch(int id, List<Product> db ) {
		Collections.sort(db, new Comparator<Product>() {
		    public int compare(Product p1, Product p2) {
		        return Integer.compare(p1.productId, p2.productId);
		    }
		});		
		int left = 0;
		int right = db.size()-1;
		int found = 0;
		while(left <= right) {
			int mid = (left + right)/2;
			if(db.get(mid).productId == id) {
				System.out.println("Id found");
				System.out.println(db.get(mid).productId);
				System.out.println(db.get(mid).ProductName);
				System.out.println(db.get(mid).category);
				System.out.println();
				found = 1;
				break;
				
			}
			else if(db.get(mid).productId < id) {
				left = mid+1;
				
			}
			else {
				right = mid-1;
			}
		}
		if(found!= 1) {
			System.out.println("Prduct not found");
			System.out.println();
		}

	}
	void BinarySearch(String name,ArrayList<Product> db ) {
		Collections.sort(db, new Comparator<Product>() {
		    public int compare(Product p1, Product p2) {
		        return p1.ProductName.compareToIgnoreCase(p2.ProductName);
		    }
		});
		int left = 0;
		int right = db.size()-1;
		int found = 0;
		while(left <= right) {
			int mid = (left + right)/2;
			if(db.get(mid).ProductName.compareToIgnoreCase(name)==0) {
				System.out.println(db.get(mid).productId);
				System.out.println(db.get(mid).ProductName);
				System.out.println(db.get(mid).category);
				System.out.println();
				found = 1;
				break;
				
			}
			else if(db.get(mid).ProductName.compareToIgnoreCase(name) < 0) {
				left = mid+1;
				
			}
			else {
				right = mid-1;
			}
		}
		if(found!= 1) {
			System.out.println("Prduct not found");
			System.out.println();
		}


	}
}


class Ecommerce{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> db = new ArrayList<>();
		db.add(new Product(1,"iPhone","Electronics"));
		db.add(new Product(2,"T-Shirt","Clothing"));
		db.add(new Product(3,"Laptop","Electronics"));
		db.add(new Product(4,"Shoes","Footwear"));
		db.add(new Product(5,"Watch","Accessories"));
		db.add(new Product(6,"Tablet","Electronics"));
		db.add(new Product(7,"Jeans","Clothing"));
		db.add(new Product(8,"Camera","Electronics"));
		db.add(new Product(10,"Backpack","Accessories"));
		db.add(new Product(9,"Sunglasses","Accessories"));
		
		Product p = new Product();
		while(true) {
			System.out.println("Enter the type to search:");
			System.out.println("1. ID");
			System.out.println("2. Name");
			System.out.println("3. Category");
			System.out.println("4. exit");
			System.out.println();
			int ch = sc.nextInt();
			switch(ch) {
				case 1:
					System.out.println("Enter the id");
					int id = sc.nextInt();
					System.out.println();
					sc.nextLine();
					p.BinarySearch(id,db);
					break;
				case 2:
					System.out.println("Enter the name");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println();
					p.BinarySearch(name,db);
					
					break;
				case 3:System.out.println("Enter the category");
					sc.nextLine();
					String cat = sc.nextLine();
					System.out.println();
					p.linearSearch(cat,db);
					break;
				case 4:
					return;
				default:
					return;
			}
		}
		
		
	}
}