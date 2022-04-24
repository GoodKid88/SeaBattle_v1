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
                shipsName = " четырехпалубного";
                format = "(формат: x,y;x,y;x,y;x,y)";
            }
            if (counter == 1 || counter == 2) {
                shipsName = " трехпалубного";
                format = "(формат: x,y;x,y;x,y)";

            } else if (counter == 3 || counter == 4 || counter == 5) {
                shipsName = " двухпалубного";
                format = "(формат: x,y;x,y)";

            } else if (counter == 6 || counter == 7 || counter == 8 || counter == 9) {
                shipsName = " однопалубного";
                format = "(формат: x,y)";

            }
            try {
                System.out.println("Введите координаты" + shipsName + " корабля" + format);
                String line = scanner.nextLine();
                String[] coordinates = line.split(("[.,:;()?!\"\\s–]+"));

                Ship ship = new Ship(coordinatesParseInt(coordinates));

                if (ship.isShipValid()) {
                    if (player.getOwnFild().isShipAdded(ship)) {
                        player.getOwnFild().addOreol(ship);
                        counter++;
                    } else {
                        System.out.println("Ячейки заняты");
                    }
                } else {
                    System.out.println("Корабль не валидный!!!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Неверный формат!");
            }
        }
    }


    public void startGame() {
        System.out.println("Начнем расставлять корабли на поле " + player1.getName() + "! Другой игрок, не смотри!");
        addAllShips(player1);

        System.out.println("Начнем расставлять корабли на поле " + player2.getName() + "! Другой игрок, не смотри!");
        addAllShips(player2);

        player1.getOwnFild().showFild();
        System.out.println();

        player2.getOwnFild().showFild();
        System.out.println();

        System.out.println("Корабли расставлены! Бой начинается!");
        while (true) {
            while (player1.isShotResult()) {
                if (player2.isAlivedShip()) {
                    System.out.println(player1.getName() + " Выиграл!");
                    break;
                } else {
                    System.out.println(player1.getName() + " Твой ход");
                    player1.attack(player2, scanner.nextInt(), scanner.nextInt());
                }
            }
            player2.setShotResult();
            player2.getEnemyFild().showFild();

            while (player2.isShotResult()) {
                if (player1.isAlivedShip()) {
                    System.out.println(player2.getName() + " Выиграл!");
                    break;
                } else {
                    System.out.println(player2.getName() + " Твой ход");
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

