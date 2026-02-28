public class StringMethod {
  public static void main(String[] args) {
    String str = "Java Programming";
    
    System.out.println("Length: " + str.length());
    System.out.println("Uppercase: " + str.toUpperCase());
    System.out.println("Lowercase: " + str.toLowerCase());
    System.out.println("Character at 2: " + str.charAt(2));
    System.out.println("Substring: " + str.substring(5));
    System.out.println("Contains 'Java': " + str.contains("Java"));
    System.out.println("Replace: " + str.replace("Java", "Advanced Java"));
  }
  
}
