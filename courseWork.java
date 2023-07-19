import java.util.*;

class clearConsole{
	
		public final static void ClearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Linux")) {
                System.out.print("\033\143");
            } else if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } 
        
        catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class LoginManager {
	
	static courseWork home = new courseWork();
	static Scanner scanner = new Scanner(System.in);
	
	
    public String userName = "Shenan";
    public String passWord = "1234";
    

    public void login() {
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                   LOGIN PAGE                                                                                                     |");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");

        String inputedUserName = "";
        String inputedPassword;

        do {
            inputedUserName = enterUserName();
            if (userName.equals(inputedUserName)) {
                break;
            } else {
                System.out.println("User name is invalid. Please try again!\n");
            }
        } while (!userName.equals(inputedUserName));

        do {
            inputedPassword = enterPassword();
            if (inputedPassword.equals(passWord)) {
				home.Home();
                return;
            } else {
                System.out.println("Password is invalid. Please try again!\n");
            }
        } while (!passWord.equals(inputedPassword));
    }

    public String enterUserName() {
        System.out.print("User Name : ");
        return scanner.next();
    }

    public String enterPassword() {
        System.out.print("Password : ");
        return scanner.next();
    }

    
}

class credentialManage{
	
		static Scanner scanner = new Scanner(System.in);
		static LoginManager logins = new LoginManager();
		static courseWork CourseWork = new courseWork();
		static clearConsole clear = new clearConsole(); 
	
		public static void changeCredentials() {
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                      Credential Manage                                                                                           |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
		
				
		char yesOrNotemp = '0';
		
		verifyUsername();
				
		System.out.println("Hey " + logins.userName);
			
		verifyPassword();
			
		passwordChanger();
		
		yesOrNotemp = goBackToHomeOrNot();
			
		if(yesOrNotemp == 'Y' || yesOrNotemp == 'y' ) {
			clear.ClearConsole();
			CourseWork.Home();
		}
		else if (yesOrNotemp == 'N' || yesOrNotemp == 'n') {
			while (yesOrNotemp == 'N' || yesOrNotemp == 'n' ) {
				System.out.println("\nYou can change your Password again now!\n\n");
				passwordChanger();
				yesOrNotemp = goBackToHomeOrNot();
				if (yesOrNotemp == 'Y' || yesOrNotemp == 'y' ) {
					clear.ClearConsole();
					CourseWork.Home();
					return; // This will exit the method when going back to the home page
				}
			}
		}
	}
			
	public static void verifyUsername() {
		
		String tempUserName = "";
		
		while(!tempUserName.equals(logins.userName)) {
			System.out.print("Please Enter the User Name to verify it's you : ");
			tempUserName = scanner.next();
			if(!tempUserName.equals(logins.userName)) {
			System.out.println("User Name is invalid Please try Again !\n");
			}
		}
		
	}
	
	public static void verifyPassword() {
		
		String tempPassword = "";
		
		while(!(logins.passWord).equals(tempPassword)) {
			System.out.print("Enter your current password : ");
			tempPassword = scanner.next();
			if(!(logins.passWord).equals(tempPassword)) {
				System.out.println("incorrect Password. Please Try again!\n");
			}
		}
		
	}
	
	public static void passwordChanger() {
		
		char yesOrNotemp = '0';
		
		System.out.print("Enter your new password : ");
		logins.passWord = scanner.next();
		
	}
	
	public static char goBackToHomeOrNot() {
	
		char yesOrNotemp = '0';
	
		System.out.print("\n\nPassword Changed Successfully! Do you want to Go to home Page (Y/N) : ");
		yesOrNotemp = scanner.next().charAt(0);
		
		return yesOrNotemp;
	}
	
}

class AddSupplier{
	
	static courseWork sup = new courseWork();
	static Scanner scanner = new Scanner(System.in);
	static clearConsole clear = new clearConsole();
	static int index = 0; //used to find which index was the last supplier ids location
	
	
	
	public static void addSupplier() {
		
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                        ADD SUPPLIER                                                                                             |");
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
		

		while (true) {
			
			sup.Suppliers = growArray();
			
			boolean correct = false;
			char ask;

			do {
				System.out.print("\n\nSupplier ID  : ");
				String id = scanner.next();
				correct = checkId(sup.Suppliers, id);

				if (correct) {
					sup.Suppliers[index][0] = id;

					System.out.print("Supplier Name: ");
					sup.Suppliers[index][1] = scanner.next();
					break;
				} else {
					System.out.println("Supplier ID already exists. Try another supplier ID!");
				}

			} while (true);

			index++;
			System.out.print("Added successfully! Do you want to add another supplier (Y/N) : ");
			ask = scanner.next().charAt(0);
			if (ask == 'Y' || ask == 'y') {
				continue;
			} else if (ask == 'N' || ask == 'n') {
				clear.ClearConsole();
				break;
			}
		}
		
		sup.supplierManagement();
		
	}

	


	public static String[][] growArray() {
        String[][] temp = new String[(sup.Suppliers).length + 1][2];

        for (int i = 0; i < (sup.Suppliers).length; i++) {
            temp[i][0] = sup.Suppliers[i][0];
            temp[i][1] = sup.Suppliers[i][1];
        }

        return temp;
    }

    public static boolean checkId(String[][] array, String id) {
        boolean checked = true;

        for (int i = 0; i < array.length; i++) {
            if (id.equals(array[i][0])) {
                checked = false;
                break;
            }
        }

        return checked;
    }
	
}

class UpdateSupplier{
	
	static courseWork Sup = new courseWork();
	static Scanner scanner = new Scanner(System.in);
	
	public static void updateSupplier() {
		
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                   UPDATE SUPPLIER                                                                                               |");
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		
		int nameIndex = 0;
		do{
			System.out.print("\n\nSupplier id  : ");
			String id = scanner.next();
			boolean correct = checkId(id);
				if(correct) {
					System.out.println("Can't find supplier id. Please try again!");
				} 
				else {
					while(true) {
						nameIndex = findName(id);
						System.out.println("Supplier name: " + Sup.Suppliers[nameIndex][1]);
						System.out.print("\nEnter the new supplier name: ");
						String newName = scanner.next();
						
						Sup.Suppliers[nameIndex][1] = newName;
			
						System.out.print("\nUpdated succesfully! Do you want to update another supplier (Y/N) : ");
						char y = scanner.next().charAt(0);
						
						if( y == 'y' | y == 'Y' ) {
							break;
						}
						else if( y == 'N' | y == 'n' ){
							Sup.supplierManagement();
						}
					}
				} 
		} while ( true );

	}
	
	public static boolean checkId(String id){
		boolean checked = true;
		for (int i = 0; i < (Sup.Suppliers).length; i++){
			if(id.equals(Sup.Suppliers[i][0]))
				checked=false;
		}
		return checked;
	}
	
	public static int findName(String id){
		int nameIndex = 0;
		for (int i = 0; i < (Sup.Suppliers).length; i++){
			if(id.equals(Sup.Suppliers[i][0])) {
				nameIndex = i;
				break;
			}			
		}
		return nameIndex;
	}
	
}

class deleteSupplier{
	
	static courseWork sup = new courseWork();
	static Scanner scanner = new Scanner(System.in);
	
	
	
	public static void supplierDelete() {
		
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                   Delete Supplier                                                                                               |");
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		
		do{
			System.out.print("\n\nSupplier id  : ");
			String id = scanner.next();
			boolean correct = checkId(id);
				if(correct){
					System.out.println("Can't find supplier id. try again!");
				} else {
					while(true) {
					sup.Suppliers = removeId(id);
					System.out.print("Deleted succesfully! Do you want to delete another supplier (Y/N) : ");
					char y = scanner.next().charAt(0);
						if( y == 'Y' | y == 'y' ) {
							if (sup.Suppliers.length == 0) {
								System.out.println("No more supplier IDs to delete.");
								break;
							}
						} else if( y == 'N' | y == 'n' ) {
							sup.supplierManagement();
						}
					}	
				}
			}while(true);
		
	}
	
	public static String[][] removeId(String id) {
		String[][] temp = new String[sup.Suppliers.length - 1][2];

		int index1 = 0;
		int tempId = showId(id);
		boolean skip = false;

		for (int i = 0; i < (sup.Suppliers).length; i++) {
			if (i == tempId) {
				skip = true;
				continue;  // Skip the input with the matching ID
			}

			if (!skip) {
				for (int j = 0; j < (sup.Suppliers[i]).length; j++) {
					temp[index1][j] = sup.Suppliers[i][j];
				}
				index1++;
			} else {
				skip = false;
			}
		}

		return temp;
	}


	
	public static int showId(String id) {
		int tempId = -1;
		for (int i = 0; i < (sup.Suppliers).length; i++) {
			if (id.equals(sup.Suppliers[i][0])) {
				tempId = i;
				break;
			}
		}
		return tempId;
	}
	
	public static boolean checkId(String id){
		boolean checked=true;
		for (int i = 0; i < (sup.Suppliers).length; i++){
			if(id.equals(sup.Suppliers[i][0]))
				checked=false;
		}
		return checked;
	}
	
	
}

class SupplierView{
	
		static courseWork sup = new courseWork();
		static Scanner scanner = new Scanner(System.in);
		static clearConsole clear = new clearConsole();
	
		public static void viewSupplier() {
		System.out.printf("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
		System.out.printf("|                     	                                                 VIEW SUPPLIER                                                                                      |\n");
		System.out.printf("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");

		System.out.println("+--------------------+--------------------+");
		System.out.printf("| %-18s | %-18s |\n", "SUPPLIER ID", "SUPPLIER NAME");
		System.out.println("+--------------------+--------------------+");

		for (int i = 0; i < (sup.Suppliers).length; i++) {
			System.out.printf("| %-18s | %-18s |\n", sup.Suppliers[i][0], sup.Suppliers[i][1]);
		}

		System.out.println("+--------------------+--------------------+");

		System.out.print("\nDo you want to go to the Supplier Management page (Y/N): ");
		char y = scanner.next().charAt(0);
		if (y == 'Y' || y == 'y') {
			sup.supplierManagement();
			return;
		} else if (y == 'N' || y == 'n') {
			System.out.print("Press (Y) anytime to go back to the Supplier Management Page: ");
			y = scanner.next().charAt(0);

			if (y == 'Y' || y == 'y') {
				clear.ClearConsole();
				sup.supplierManagement();
			}
		}
	}
	
}

class SupplierSearch{

		
		static courseWork sup = new courseWork();
		static Scanner scanner = new Scanner(System.in);
		
		
		public static void searchSupplier() {
		
		
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                 SEARCH SUPPLIER                                                                                                 |");
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		
		
		do {
			
			System.out.print("\n\nSupplier iD : ");
			String id = scanner.next();
			boolean correct = checkId(id);
			
				if(correct) {
					System.out.println("Can't find supplier id. try again!");
				} 
				else {
					
					while(true) {
						
						int name = findName(id);
						System.out.println("Supplier name : " + sup.Suppliers[name][1]);
						
						System.out.print("Added succesfully! Do you want to add another find (Y/N) ? : ");
						char y = scanner.next().charAt(0);
						
						if( y =='y' | y == 'Y' ) {
							break;
						}
						else if( y == 'n' | y == 'N' ) {
							sup.supplierManagement();
						}
					}
				}
			} while(true);
	}
	
	public static int findName(String id){
		int nameIndex = 0;
		for (int i = 0; i < (sup.Suppliers).length; i++){
			if(id.equals(sup.Suppliers[i][0])) {
				nameIndex = i;
				break;
			}			
		}
		return nameIndex;
	}
	
	public static boolean checkId(String id){
		boolean checked=true;
		for (int i = 0; i < (sup.Suppliers).length; i++){
			if(id.equals(sup.Suppliers[i][0]))
				checked=false;
		}
		return checked;
	}


}

class AddNewItemCategory{
	
	static Scanner scanner = new Scanner(System.in);
	static courseWork Category = new courseWork();
	static clearConsole clear = new clearConsole();
	
	
	public static void addNewItemCategory() {
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     ADD NEW ITEM CATEGORY                                                                                        |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
		
		while (true) {
		System.out.print("\n\nEnter the new item category: ");
			String newCategory = scanner.next();

			boolean categoryAdded = false;
			for (int i = 0; i < Category.Categories.length; i++) {
				if (Category.Categories[i] == null) {
					Category.Categories[i] = newCategory;
					categoryAdded = true;
					break;
				}
			}

			if (!categoryAdded) {
				growCategories();
				Category.Categories[Category.Categories.length - 1] = newCategory;
			}

			System.out.print("Added successfully! Do you want to add another category (Y/N): ");
			char yesOrNo = scanner.next().charAt(0);

			if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
				continue;
			}
			else if( yesOrNo == 'N' || yesOrNo == 'n' ) {
				clear.ClearConsole();
				Category.manageItemCategory();
				return;
			}	
			
		}
			
	}
	

	public static void growCategories() {
		String[] temp = new String[Category.Categories.length + 1];

		for (int i = 0; i < Category.Categories.length; i++) {
			temp[i] = Category.Categories[i];
		}

		Category.Categories = temp;
	}
	
}

class ItemCategoryDelete{
	
		static Scanner scanner = new Scanner(System.in);
		static courseWork Category = new courseWork();
		static clearConsole clear = new clearConsole();
		
		public static void deleteItemCategory() {
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     DELETE ITEM CATEGORY                                                                                         |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");

		while (true) {
			System.out.print("\n\nEnter the category to delete: ");
			String categoryToDelete = scanner.next();

			boolean categoryFound = false;
			for (int i = 0; i < Category.Categories.length; i++) {
				if (categoryToDelete.equals(Category.Categories[i])) {
					Category.Categories[i] = null;
					categoryFound = true;
					break;
				}
			}

			if (categoryFound) {
				System.out.println("Category deleted successfully!");
			} else {
				System.out.println("Category not found!");
			}

			Category.Categories = removeNullCategories();

			System.out.print("Do you want to Delete Another category (Y) OR Go manage Item Category Page (N): ");
			char yesOrNo = scanner.next().charAt(0);

			if (yesOrNo == 'N' || yesOrNo == 'n') {
				clear.ClearConsole();
				Category.manageItemCategory();
				return;
			}
		}
	}
	
	public static String[] removeNullCategories() {
		int nonNullCount = 0;

		for (String category : Category.Categories) {
			if (category != null) {
				nonNullCount++;
			}
		}

		String[] nonNullCategories = new String[nonNullCount];
		int index = 0;

		for (String category : Category.Categories) {
			if (category != null) {
				nonNullCategories[index] = category;
				index++;
			}
		}

		return nonNullCategories;
	}
	
}

class UpdateItemCategory{
	
		static Scanner scanner = new Scanner(System.in);
		static courseWork Category = new courseWork();
		static clearConsole clear = new clearConsole();
	
		public static void updateItemCategory() {
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     UPDATING ITEM CATEGORY                                                                                       |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
		
		while(true) {
			System.out.print("\n\nEnter the category to update: ");
			String categoryToUpdate = scanner.next();

			boolean categoryFound = false;
			for (int i = 0; i < Category.Categories.length; i++) {
				if (categoryToUpdate.equals(Category.Categories[i])) {
					categoryFound = true;
					
					System.out.print("Enter the new category name: ");
					String newCategoryName = scanner.next();
				
					Category.Categories[i] = newCategoryName;
					break;
				}
			}

			if (categoryFound) {
				
				System.out.println("Category updated successfully!");
				
			} 
			else {
				System.out.println("Category not found!");
			}
			
			System.out.print("Do you want to Update Another category(Y) OR  Go manage Item Category Page(N) : ");
			char yesOrNo = scanner.next().charAt(0);

			if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
				continue;
			}
			else if( yesOrNo == 'N' || yesOrNo == 'n' ) {
				clear.ClearConsole();
				Category.manageItemCategory();
				return;
			}
		}
		
	}
	
}

class AddItems{
	
		static Scanner scanner = new Scanner(System.in);
		static courseWork Items = new courseWork();
		static clearConsole clear = new clearConsole();
		static AddNewItemCategory ANIC = new AddNewItemCategory();
		static AddSupplier addSuppliers = new AddSupplier();
	
	
		public static void AddItem() {
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     ADD ITEM                                                                                                     |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");

		while (true) {
			if (!hasCategories()) {
				System.out.println("Oops! It seems like you don't have any item categories in the System.");
				System.out.print("Do you want to Add a new Item Category (Y/N): ");
				char yesOrNo = scanner.next().charAt(0);

				if (yesOrNo == 'Y' || yesOrNo == 'y') {
					clear.ClearConsole();
					ANIC.addNewItemCategory();
					return;
				} else if (yesOrNo == 'N' || yesOrNo == 'n') {
					clear.ClearConsole();
					Items.stockManagement();
					return;
				}
			}

			if (!hasSuppliers()) {
				System.out.println("Oops! It seems like you don't have any Suppliers in the System.");
				System.out.print("Do you want to Add a new Supplier (Y/N): ");
				char yesOrNo = scanner.next().charAt(0);

				if (yesOrNo == 'Y' || yesOrNo == 'y') {
					clear.ClearConsole();
					addSuppliers.addSupplier();
					return;
				} else if (yesOrNo == 'N' || yesOrNo == 'n') {
					clear.ClearConsole();
					Items.stockManagement();
					return;
				}
			}
			
			//checks if Item ID exists. If it exists, this will restart the loop.

			System.out.print("\n\nItem Code: ");
			String itemCode = scanner.next();
			
			boolean exists = checkIfItemExists(itemCode);

			if (exists) {
				System.out.println("Item ID already exists. Please try a new ID.");
				continue;
			}

			int currentItemIndex = checkAndAddItemCode(itemCode);

			String supplierId = assignToWhichSupplier();
			String category = assignToWhichCategory();

			// Updating the Item array with the selected supplier and category
			Items.Item[currentItemIndex][1] = supplierId;
			Items.Item[currentItemIndex][2] = category;

			System.out.print("\n\nDescription: ");
			Items.Item[currentItemIndex][3] = scanner.next();

			System.out.print("Unit Price: ");
			int unitPrice = scanner.nextInt();
			Items.Item[currentItemIndex][4] = String.valueOf(unitPrice);

			System.out.print("QTY on Hand: ");
			Items.Item[currentItemIndex][5] = scanner.next();

			System.out.println("\nAdded successfully!");

			System.out.print("Do you want to add another Item (Y/N): ");
			char yesOrNo = scanner.next().charAt(0);

			if (yesOrNo == 'N' || yesOrNo == 'n') {
				clear.ClearConsole();
				Items.stockManagement();
				return;
			}
		}
	}
	
	public static boolean checkIfItemExists(String itemCode) {
		for (int i = 0; i < Items.Item.length; i++) {
			if (Items.Item[i][0] != null && Items.Item[i][0].equals(itemCode)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasCategories() {
		for (String category : Items.Categories) {
			if (category != null) {
				return true; // At least one category found
			}
		}
		return false; // No categories found in Array
	}
	
	public static boolean hasSuppliers() {
		for (String[] supplier : Items.Suppliers) {
			if (supplier != null) {
				return true; // At least one supplier found
			}
		}
		return false; // No suppliers found
	}
	
	public static int checkAndAddItemCode(String itemCode) {
		for (int i = 0; i < Items.Item.length; i++) {
			if (Items.Item[i][0] == null) {
				Items.Item[i][0] = itemCode;
				System.out.println("\n\nItem code added successfully!");
				return i;
			}
		}

		// If no empty element is found, grow the Item array
		int newIndex = Items.Item.length;
		growItemArray();
		Items.Item[newIndex][0] = itemCode;
		System.out.println("Item code added successfully!");
		return newIndex;
	}


	public static void growItemArray() {
		String[][] temp = new String[Items.Item.length + 1][6];
		
		for (int i = 0; i < Items.Item.length; i++) {
			for (int j = 0; j < Items.Item[i].length; j++) {
				temp[i][j] = Items.Item[i][j];
			}
		}
		
		Items.Item = temp;
	}
	

	public static String assignToWhichSupplier() {
		System.out.println("\n+---------------------------------------+");
		System.out.printf("| %-5s | %-28s |%n", "Option", "Supplier");
		System.out.println("+-------+------------------------------+");
		
		for (int i = 0; i < Items.Suppliers.length; i++) {
			String supplierId = Items.Suppliers[i][0];
			String supplierName = Items.Suppliers[i][1];
			System.out.printf("| %-6d | %-28s |%n", (i + 1), supplierName);
		}
		
		System.out.println("+-------+------------------------------+");
		
		String selectedSupplier;
		while (true) {
			System.out.print("\nSelect Option > ");
			int optionNumber = scanner.nextInt();
			
			if (optionNumber >= 1 && optionNumber <= Items.Suppliers.length) {
				selectedSupplier = Items.Suppliers[optionNumber - 1][0];
				break;
			} 
			else {
				System.out.println("Invalid option number!\n");
				continue;
			}
		}
		return selectedSupplier;
	}

	public static String assignToWhichCategory() {
		
		System.out.println("\n+---------------------------------------+");
		System.out.printf("| %-5s | %-28s |%n", "Option", "Category");
		System.out.println("+--------+------------------------------+");
		
		for (int i = 0; i < Items.Categories.length; i++) {
			System.out.printf("| %-6d | %-28s |%n", (i + 1), Items.Categories[i]);
		}
		
		System.out.println("+-------+------------------------------+");
		
		String selectedCategory;
		while (true) {
			System.out.print("\nSelect Option > ");
			int optionNumber = scanner.nextInt();
			
			if (optionNumber >= 1 && optionNumber <= Items.Categories.length) {
				selectedCategory = Items.Categories[optionNumber - 1];
				break;
			} 
			else {
				System.out.println("Invalid option number!\n");
				continue;
			}
		}
		return selectedCategory;
	}
	
	
}

class DisplayItemsSupplierWise{
	
	static Scanner scanner = new Scanner(System.in);
	static courseWork supplier = new courseWork();
	static clearConsole clear = new clearConsole();
	
	public static void displayItemsBySupplierWise() {
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     SEARCH SUPPLIER                                                                                              |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
		
		while(true) {
			System.out.print("\n\nEnter the supplier ID: ");
			String supplierId = scanner.next();

			// Check if the supplier ID exists
			boolean supplierExists = false;
			for (int i = 0; i < supplier.Suppliers.length; i++) {
				if (supplier.Suppliers[i][0] != null && supplier.Suppliers[i][0].equals(supplierId)) {
					supplierExists = true;
					break;
				}
			}

			if (supplierExists) {
				// Print the supplier name
				String supplierName = getSupplierName(supplierId);
				System.out.println("Supplier name : " + supplierName + "\n\n");
				
				// Print the items for the supplier
				System.out.println("------------------------------------------------------------------------------------------------");
				System.out.printf("| %-15s | %-20s | %-15s | %-20s | %-10s |\n", "Item Code", "Description", "Unit Price", "QTY on Hand", "Category");
				System.out.println("------------------------------------------------------------------------------------------------");
				for (int i = 0; i < supplier.Item.length; i++) {
					if (supplier.Item[i][1] != null && supplier.Item[i][1].equals(supplierId)) {
						String itemCode = supplier.Item[i][0];
						String description = supplier.Item[i][3];
						String unitPrice = supplier.Item[i][4];
						String qtyOnHand = supplier.Item[i][5];
						String category = supplier.Item[i][2];
						System.out.printf("| %-15s | %-20s | %-15s | %-20s | %-10s |\n", itemCode, description, unitPrice, qtyOnHand, category);
					}
				}
				System.out.println("------------------------------------------------------------------------------------------------");
				
				System.out.print(" Search successfully! Do you want another search (Y/N) : ");
				char yesOrNo = scanner.next().charAt(0); 
				
				if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
						continue;
				}
				else if( yesOrNo == 'N' || yesOrNo == 'n' ) {
					clear.ClearConsole();
					supplier.stockManagement();
					return;
				}
				
			} else {
				System.out.println("Supplier ID not found. Do you want another search (Y/N) : ");
				char y = scanner.next().charAt(0); 
				
				if( y == 'Y' || y == 'y' ) {
						continue;
				}
			}
		}
	}
	
	public static String getSupplierName(String supplierId) {
		for (int i = 0; i < supplier.Suppliers.length; i++) {
			if (supplier.Suppliers[i][0] != null && supplier.Suppliers[i][0].equals(supplierId)) {
				return supplier.Suppliers[i][1];
			}
		}
		return "";
	}
	
	
}

class ViewItemsByPriceASC{
	
		static Scanner scanner = new Scanner(System.in);
		static courseWork R2 = new courseWork();
		static clearConsole clear = new clearConsole();
	
		public static void viewItemsByPriceAscending() {
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     RANK UNIT PRICE                                                                                              |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");

		if (R2.Item[0][0] == null) {
			System.out.println("No items found in the system.");
			return;
		}

		// Count the number of non-null items
		int itemCount = 0;
		for (String[] item : R2.Item) {
			if (item[0] != null) {
				itemCount++;
			}
		}

		// Create a new array to store non-null items
		String[][] sortedItems = new String[itemCount][6];

		// Copy non-null items to the new array
		int index = 0;
		for (int i = 0; i < R2.Item.length; i++) {
			if (R2.Item[i][0] != null) {
				for (int j = 0; j < R2.Item[i].length; j++) {
					sortedItems[index][j] = R2.Item[i][j];
				}
				index++;
			}
		}

		// Sort the items using unit price. (using bubble sort)
		for (int i = 0; i < sortedItems.length - 1; i++) {
			for (int j = 0; j < sortedItems.length - i - 1; j++) {
				int price1 = Integer.parseInt(sortedItems[j][4]);
				int price2 = Integer.parseInt(sortedItems[j + 1][4]);

				if (price1 > price2) {
					// Swap items
					String[] temp = sortedItems[j];
					sortedItems[j] = sortedItems[j + 1];
					sortedItems[j + 1] = temp;
				}
			}
		}

		// Print table headers
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("| %-10s | %-10s | %-20s | %-10s | %-5s | %-10s |\n", "SID", "CODE", "DESC", "PRICE", "QTY", "CATEGORY");
		System.out.println("------------------------------------------------------------------------------------");

		// Print items in tabular format
		for (String[] item : sortedItems) {
			String sid = item[1];
			String itemCode = item[0];
			String description = item[3];
			String price = item[4];
			String qty = item[5];
			String category = item[2];

			// Print item details in tabular format
			System.out.printf("| %-10s | %-10s | %-20s | %-10s | %-5s | %-10s |\n", sid, itemCode, description, price, qty, category);
		}

		System.out.println("-------------------------------------------------------------------------------------");
		
		System.out.print(" Do you want to go back to Stock Manage Page   (Y/N) : ");
		char yesOrNo = scanner.next().charAt(0); 
				
			if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
					clear.ClearConsole();
					R2.stockManagement();
			}
			else if( yesOrNo == 'N' || yesOrNo == 'n' ) {
				
				System.out.print(" Press (Y) anytime to go back to Stock Manage Page  : ");
				yesOrNo = scanner.next().charAt(0); 
						
					if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
							clear.ClearConsole();
							R2.stockManagement();
					}
				
				
			}
			
			
	}
	
}

class ViewItemsByCategory{
	
	static Scanner scanner = new Scanner(System.in);
	static courseWork R1 = new courseWork();
	static clearConsole clear = new clearConsole();
	
	public static void viewItemsByCategory() {
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     VIEW ITEMS                                                                                                   |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");

		if (!hasCategories()) {
			System.out.println("No item categories found in the system.");
			return;
		}

		for (int i = 0; i < R1.Categories.length; i++) {
			if (R1.Categories[i] != null) {
				String category = R1.Categories[i];
				System.out.println("\nCategory: " + category);

				boolean itemsFound = false; // To track if any items found in the current category

				for (int j = 0; j < R1.Item.length; j++) {
					if ( ( R1.Item[j][0] != null ) && ( R1.Item[j][2].equals(category) ) ) {
						String sid = R1.Item[j][1];
						String itemCode = R1.Item[j][0];
						String description = R1.Item[j][3];
						String price = R1.Item[j][4];
						String qty = R1.Item[j][5];
						
						itemsFound = true;
						if (itemsFound) {
							System.out.println("------------------------------------------------------------");
							System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-5s |\n", "SID", "CODE", "DESC", "PRICE", "QTY");
							System.out.println("------------------------------------------------------------");
							
							System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-5s |\n", sid, itemCode, description, price, qty);
							System.out.println("------------------------------------------------------------");
						}
						
					}
				}
				
			}
		}

		System.out.print("Do you want to go back to Stock Manage Page (Y/N): ");
		char yesOrNo = scanner.next().charAt(0);

		if (yesOrNo == 'Y' || yesOrNo == 'y') {
			clear.ClearConsole();
			R1.stockManagement();
		} else if (yesOrNo == 'N' || yesOrNo == 'n') {
			System.out.print("Press (Y) anytime to go back to Stock Manage Page: ");
			yesOrNo = scanner.next().charAt(0);

			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clear.ClearConsole();
				R1.stockManagement();
			}
		}
	}
	
	public static boolean hasCategories() {
		for (String category : R1.Categories) {
			if (category != null) {
				return true; // At least one category found
			}
		}
		return false; // No categories found in Array
	}
	
	
}


    
class courseWork{
	
	static String[][] Suppliers = new String[0][2];
	static String[] Categories = new String[1];
	static String[][] Item = new String[1][6];
	static credentialManage ChangeCredentials = new credentialManage();
	static AddSupplier ad =  new AddSupplier();
	
	static LoginManager logins = new LoginManager();
	public static Scanner scanner = new Scanner(System.in);
	static clearConsole clear = new clearConsole();
	
	
	public static void Home() {
		
		clear.ClearConsole();
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                                                                      |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
	
		System.out.print("[1] Change the Credentials\t\t\t");
		System.out.println("[2] Supplier Manage");
		System.out.print("[3] Stock Manage\t\t\t\t");
		System.out.println("[4] Log out");
		System.out.println("[5] Exit the System\n\n ");
		
		int optionNumber = 0;
		boolean validity;
		
		do {
            System.out.print("Enter an Option to Continue > ");
            optionNumber = scanner.nextInt();
            validity = checkHomeOptionValidity(optionNumber);

            switch (optionNumber) {
                case 1:
                    clear.ClearConsole();
                    ChangeCredentials.changeCredentials();
                    break;
                case 2:
					clear.ClearConsole();
                    supplierManagement();
                    break;
                case 3:
					clear.ClearConsole();
                    stockManagement();
                    break;
                case 4:
                    clear.ClearConsole();
                    logins.login();
                    return;
                case 5:
                    System.out.print("\nSystem Shutting down... \nGood bye ☺  ♧");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.\n");
                    validity = false;
                    continue;
            }
        } while (!validity);	
	}
	
	public static boolean checkHomeOptionValidity(int optionNumber) {
	
		boolean validity;
		if(optionNumber <= 5 && optionNumber > Long.MIN_VALUE ) {
			validity = true;	
		}
		else{
			validity = false;
		}
		return validity;
	}
	
	public static boolean check4OptionValidity(int optionNumber) {
	
		boolean validity;
		if(optionNumber <= 4 && optionNumber > Long.MIN_VALUE ) {
			validity = true;	
		}
		else{
			validity = false;
		}
		return validity;
	}
	
	public static boolean check6OptionValidity(int optionNumber) {
	
		boolean validity;
		if(optionNumber <= 6 && optionNumber > Long.MIN_VALUE ) {
			validity = true;	
		}
		else{
			validity = false;
		}
		return validity;
	}
	
	public static void supplierManagement() {
		
		clear.ClearConsole();
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     SUPPLIER MANAGE                                                                                              |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
	
		System.out.print("[1] Add Supplier\t\t\t");
		System.out.println("[2] Update Supplier");
		System.out.print("[3] Delete Supplier\t\t\t");
		System.out.println("[4] View Suppliers");
		System.out.print("[5] Search Supplier\t\t\t");
		System.out.println("[6] Home Page\n\n");
		
		int optionNumber = 0;
		boolean validity;
		
		do {
            System.out.print("Enter an Option to Continue > ");
            optionNumber = scanner.nextInt();
            validity = check6OptionValidity(optionNumber);

            switch (optionNumber) {
                case 1:
					clear.ClearConsole();
                    ad.addSupplier();
                    return;
                case 2:
                    clear.ClearConsole();
                    UpdateSupplier.updateSupplier();
                    return;
                case 3:
					clear.ClearConsole();
                    deleteSupplier.supplierDelete();
                    return;
                case 4:
                    clear.ClearConsole();
                    SupplierView.viewSupplier();
                    return;
                case 5:
					clear.ClearConsole();
					SupplierSearch.searchSupplier();
                    return;
                case 6:
					clear.ClearConsole();
                    Home(); 
                    return; 
                default:
                    System.out.println("Invalid option! Please try again.\n");
                    validity = false;
                    continue;
            }
        } while (!validity);
		
	}
	
	public static void stockManagement() {
		
		clear.ClearConsole();
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     STOCK MANAGE                                                                                                 |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
	
		System.out.print  ("[1] Manage Item categories\t\t\t");
		System.out.println("[2] Add Item");
		System.out.print  ("[3] Get Items Supplier Wise\t\t\t");
		System.out.println("[4] View Items");
		System.out.print  ("[5] Rank Items Per Unit Price\t\t\t");
		System.out.println("[6] Home Page\n\n");
		
		int optionNumber = 0;
		boolean validity;
		
		do {
            System.out.print("Enter an Option to Continue > ");
            optionNumber = scanner.nextInt();
            validity = check6OptionValidity(optionNumber);

            switch (optionNumber) {
                case 1:
					clear.ClearConsole();
					manageItemCategory();
                    return;
                case 2:
                    clear.ClearConsole();
                    AddItems.AddItem();
                    return;
                case 3:
					clear.ClearConsole();
					DisplayItemsSupplierWise.displayItemsBySupplierWise();
                    return;
                case 4:
                    clear.ClearConsole();
                    ViewItemsByCategory.viewItemsByCategory();
                    return;
                case 5:
					clear.ClearConsole();
					ViewItemsByPriceASC.viewItemsByPriceAscending();
                    return;
                case 6:
					clear.ClearConsole();
                    Home();	
                    return; 
                default:
                    System.out.println("Invalid option! Please try again.\n");
                    validity = false;
                    continue;
            }
        } while (!validity);
		
	}
	
	public static void manageItemCategory() {
		
		clear.ClearConsole();
		
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                     MANAGE ITEM CATEGORY                                                                                         |");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");
	
		System.out.print  ("[1] Add new Item Category\t\t\t");
		System.out.println("[2] Delete Item Category");
		System.out.print  ("[3] Update Item Category\t\t\t");
		System.out.println("[4] Stock Management\n\n");
		
		int optionNumber = 0;
		boolean validity;
		
		do {
            System.out.print("Enter an Option to Continue > ");
            optionNumber = scanner.nextInt();
            validity = check4OptionValidity(optionNumber);

            switch (optionNumber) {
                case 1:
					clear.ClearConsole();
					AddNewItemCategory.addNewItemCategory();
                    return;
                case 2:
                    clear.ClearConsole();
                    ItemCategoryDelete.deleteItemCategory();
                    return;
                case 3:
					clear.ClearConsole();
					UpdateItemCategory.updateItemCategory();
                    return;
                case 4:
                    clear.ClearConsole();
                    stockManagement();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.\n");
                    validity = false;
                    continue;
            }
        } while (!validity);
        	
	}
	

    public static void main(String[] args) {
        
        
        logins.login();
        
        
        
    }
}
