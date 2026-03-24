package others;
class StringConcat {
  public static void main(String[] args) {
    
    System.out.println(concatString("hello", "mohammad", "javed"));
  }

  public static String concatString(String... strings) {
    StringBuilder s = new StringBuilder();
    for (String str : strings) {
      s.append(str);
    }
    return s.toString();
  }
}
