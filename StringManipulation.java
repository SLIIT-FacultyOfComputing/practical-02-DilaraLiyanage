import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Part 1: String Concatenation
	
	//Prompt user to enter first name
        System.out.println("Enter Your First Name:");
        String firstName = scanner.nextLine();
        
	//Prompt user to enter middle name
        System.out.println("Enter Your Middle Name:");
        String middleName = scanner.nextLine();
        
	//Prompt user to enter last name
        System.out.println("Enter Your Last Name:");
        String lastName = scanner.nextLine();
        
        // Concatenate the strings to create a full name
        String fullName = lastName + ", " + firstName + " " + middleName;
        
	//Display cpncatenated full name
	System.out.println("Full Name: " + fullName);
        

        // Part 2: String Comparison
	
	//Promt User to enter another full name
        System.out.println("Enter another full name to compare:");
        String anotherFullName = scanner.nextLine();
        
        // Compare the full names (case-insensitive)
	// Display an appropriate message indicating whether the names are the same or different.
        if (fullName.equalsIgnoreCase(anotherFullName)) {
            System.out.println("The names are the same.");
        } else {
            System.out.println("The names are different.");
        }
        

        // Part 3: String Modification
	
        // Replace 'a' with '@' and 'e' with '3'
        String modifiedFullName = fullName.replace('a', '@').replace('e', '3');
        
        // Convert to uppercase
	// Display the modified full name.
        modifiedFullName = modifiedFullName.toUpperCase();
        System.out.println("Modified Full Name: " + modifiedFullName);
        
        // Part 4: String Splitting
	
        // Split the concatenated full name into components
        String[] nameComponents = fullName.split(", ");
        String lastNameComponent = nameComponents[0];
        String[] firstMiddleNames = nameComponents[1].split(" ");
        String firstNameComponent = firstMiddleNames[0];
        String middleNameComponent = firstMiddleNames.length > 1 ? firstMiddleNames[1] : "";
        
        // Display each component separately
        System.out.println("Last Name: " + lastNameComponent);
        System.out.println("First Name: " + firstNameComponent);
        System.out.println("Middle Name: " + middleNameComponent);
        
        // Part 5: String Trimming
        System.out.println("Enter a string with leading and trailing spaces:");
        String stringWithSpaces = scanner.nextLine();
        
        // Trim the spaces from the string
        String trimmedString = stringWithSpaces.trim();
        System.out.println("Trimmed string: \"" + trimmedString + "\"");
        
	
        // Part 6: Additional Manipulations
	
        // Count the number of vowels in the concatenated full name
        int vowelCount = 0;
        for (char c : fullName.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }
        System.out.println("Number of vowels in the full name: " + vowelCount);
        
        scanner.close();
    }
}
