public class StringBuilderDemo {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("Hello");
    sb.append(" World");
    System.out.println(sb.toString());  // Hello World

    sb.insert(5, ",");
    System.out.println(sb.toString());  // Hello, World

    sb.replace(5, 6, "!");
    System.out.println(sb.toString());  // Hello! World

    sb.delete(5, 6);
    System.out.println(sb.toString());  // Hello World
  }
  
}
