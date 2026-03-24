package main.java.org.jdbc_steps;

public class Player {

    private int id;
    private String name;
    private String sport;
    private int age;

    public Player(int id, String name, String sport, int age) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.age = age;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSport() { return sport; }
    public int getAge() { return age; }
}
