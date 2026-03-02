package main.java;

import main.java.com.capgemini.dao.PlayerDAO;
import main.java.com.capgemini.dao.PlayerDAOImplementation;
import main.java.com.capgemini.entity.Player;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) {

        PlayerDAO dao = new PlayerDAOImplementation();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    \n1. Insert Player
                    2. Get all Player
                    3. Update Player
                    4. Delete Player
                    5. Exit
                    """);
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Player name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Player country: ");
                    String country = scanner.nextLine();

                    if (dao.insertPlayer(new Player(name, country))) {
                        System.out.println("Player inserted");
                    } else {
                        System.out.println("Failed to insert");
                    }
                }

                case 2 -> {
                    List<Player> players = dao.getAllPlayer();
                    if (players == null || players.isEmpty()) {
                        System.out.println("No data found.");
                    } else {
                        printPlayers(players);
                    }
                }

                case 3 -> {
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Player p = dao.getPlayer(id);

                    if (p != null) {

                        System.out.println("""
                1. Update name
                2. Update country
                """);

                        System.out.print("Enter choice: ");
                        int c = scanner.nextInt();
                        scanner.nextLine();

                        if (c == 1) {
                            System.out.print("Enter new name: ");
                            String name = scanner.nextLine();
                            p.setPlayerName(name);

                        } else if (c == 2) {
                            System.out.print("Enter new country: ");
                            String country = scanner.nextLine();
                            p.setPlayerCountry(country);

                        } else {
                            System.out.println("Invalid input...Try again");
                            return;
                        }

                        if (dao.updatePlayer(p)) {
                            System.out.println("Data updated");
                        } else {
                            System.out.println("Failed to update");
                        }

                    } else {
                        System.out.println("Player does not exist!");
                    }
                }

                case 4 -> {
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if(dao.deletePlayer(id)){
                        System.out.println("Player deleted!");
                    }else {
                        System.out.println("Failed to delete");
                    }
                }

                case 5 -> {
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Player p = dao.getPlayer(id);
                    if (p != null){
                        printPlayer(p);
                    }else {
                        System.out.println("Player not found");
                    }
                }

                case 6 -> {
                    System.out.println("Exiting application.....");
                    exit(0);
                }

                default -> System.out.println("Invalid Input....try again");

            }
        }
    }

    static void printPlayers(List<Player> players) {

        System.out.println("\n-------------------------------");
        System.out.printf("%-5s %-15s %-12s%n",
                "ID", "Name", "Country");
        System.out.println("-------------------------------");

        for (Player p : players) {
            System.out.printf("%-5d %-15s %-12s%n",
                    p.getPlayerId(),
                    p.getPlayerName(),
                    p.getPlayerCountry()
                    );
        }
    }

    static void printPlayer(Player p) {

        if (p == null) {
            System.out.println("Player not found!");
            return;
        }

        System.out.println("\n-------------------------------");
        System.out.printf("%-5s %-15s %-12s%n",
                "ID", "Name", "Country");
        System.out.println("-------------------------------");

        System.out.printf("%-5d %-15s %-12s%n",
                p.getPlayerId(),
                p.getPlayerName(),
                p.getPlayerCountry());
    }
}
