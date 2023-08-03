package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
        String apples = new String(characters);
    	//chars combined
      //  System.out.println("Chars combined: " + apples);
    	
    	
    	StringBuilder bob = new StringBuilder(str);
    	//StringBuilder current value
    //	System.out.println("StringBuilder current value: " + bob);
    	
    	bob.append(apples);
    	//Builder after appending apples
    	//System.out.println("StringBuilder after appending apples: " + bob);
    	
    	return bob.toString();
    }
    
    public static String reverse(String str) {
       StringBuilder bob = new StringBuilder(str);
    	bob.reverse();
    //	System.out.println("builder after reverse-ing: " + bob);
    	
    	return bob.toString();
    }
    
    public static String insert(String str, int index, char newChar) {
       StringBuilder bob = new StringBuilder(str);
       bob.insert(index, newChar);
    System.out.println("bob after inserting: " + bob);
    	return bob.toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
        StringBuilder bob = new StringBuilder(str);
        bob.delete(startIndex, endIndex);
        System.out.println("bob after deleting: " + bob);
    	
    	
    	
    	return bob.toString();
    }
}