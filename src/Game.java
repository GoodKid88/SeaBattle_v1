import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;

    public Game() {
        player1 = new Player("Player1");
        player2 = new Player("Player2");
    }

    public static int[] coordinatesParseInt(String[] string_coordinates) {
        int[] coordinates = new int[string_coordinates.length];
        for (int i = 0; i < string_coordinates.length; i++) {
            coordinates[i] = Integer.parseInt(string_coordinates[i]);
        }
        return coordinates;
    }

    public void addAllShips(Player player) {
        String shipsName = "";
        String format = "";
        int counter = 0;
        while (counter < 10) {
            if (counter == 0) {
                shipsName = " four-deck";
                format = "(format: x,y;x,y;x,y;x,y)";
            }
            if (counter == 1 || counter == 2) {
                shipsName = " three-deck";
                format = "(format: x,y;x,y;x,y)";

            } else if (counter == 3 || counter == 4 || counter == 5) {
                shipsName = " two-deck";
                format = "(format: x,y;x,y)";

            } else if (counter == 6 || counter == 7 || counter == 8 || counter == 9) {
                shipsName = " one-deck";
                format = "(format: x,y)";

            }
            try {
                System.out.println("Please, enter the coordinates" + shipsName + " of ship" + format);
                String line = scanner.nextLine();
                String[] coordinates = line.split(("[.,:;()?!\"\\s–]+"));

                Ship ship = new Ship(coordinatesParseInt(coordinates));

                if (ship.isShipValid()) {
                    if (player.getOwnFild().isShipAdded(ship)) {
                        player.getOwnFild().addOreol(ship);
                        counter++;
                    } else {
                        System.out.println("Cells are occupied");
                    }
                } else {
                    System.out.println("The ship is not valid!!!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect format!");
            }
        }
    }


    public void startGame() {
        System.out.println("Let's start placing ships " + player1.getName() + " ! " + player2.getName() + " don't look!");
        addAllShips(player1);

        System.out.println("Let's start placing ships " + player2.getName() + " ! " + player1.getName() + " don't look!");
        addAllShips(player2);

        player1.getOwnFild().showFild();
        System.out.println();

        player2.getOwnFild().showFild();
        System.out.println();

        System.out.println("The ships hve been placed! The battle begins!");
        while (true) {
            while (player1.isShotResult()) {
                if (player2.isAlivedShip()) {
                    System.out.println(player1.getName() + " Won!");
                    break;
                } else {
                    System.out.println(player1.getName() + " your turn");
                    player1.attack(player2, scanner.nextInt(), scanner.nextInt());
                }
            }
            player2.setShotResult();
            player2.getEnemyFild().showFild();

            while (player2.isShotResult()) {
                if (player1.isAlivedShip()) {
                    System.out.println(player2.getName() + " Won!");
                    break;
                } else {
                    System.out.println(player2.getName() + " your turn");
                    player2.attack(player1, scanner.nextInt(), scanner.nextInt());
                }
            }
            player1.setShotResult();
            player1.getEnemyFild().showFild();

            if (player2.isAlivedShip() || player1.isAlivedShip()) {
                break;
            }
        }
    }
}

