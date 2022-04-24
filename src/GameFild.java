public class GameFild {
    private Player player;
    private String[][] field;
    private final String cellSymbol = "⬜" + " ";
    private final String shipSymbol = "\uD83D\uDEE5" + " ";
    private final String oreolSymbol = "\uD83D\uDFE6";
    private final String hitSymbol = "\uD83D\uDFE5";
    private final String missSymbol = "❌";


    public GameFild(Player player) {
        this.player = player;
        this.field = new String[10][10];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = cellSymbol;
            }
        }
    }

    public String getShipSymbol() {
        return shipSymbol;
    }

    public String getMissSymbol() {
        return missSymbol;
    }


    public String getOreolSymbol() {
        return oreolSymbol;
    }

    public String getHitlSymbol() {
        return hitSymbol;
    }

    public String[][] getField() {
        return field;
    }

    public void showFild() {
        for (String[] strings : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    public boolean isShipAdded(Ship ship) {
        for (int i = 0; i < ship.getCoordinates().length; i += 2) {
            int j = i + 1;
            if (isCellEmpty(ship.getCoordinates()[i], ship.getCoordinates()[j])) {
                field[ship.getCoordinates()[i]][ship.getCoordinates()[j]] = shipSymbol;
            } else {
                return false;
            }
        }
        return true;
    }

    public void addOreol(Ship ship) {
        int j = ship.getCoordinates().length / 2;
        int n = 0;
        if (ship.getTypeOfShip().equals("horizontal")) {
            if (ship.getCoordinates()[1] > 0) {
                field[ship.getCoordinates()[0]][ship.getCoordinates()[1] - 1] = oreolSymbol;
                n = -1;
            }
            if (ship.getCoordinates()[ship.getCoordinates().length - 1] < 9) {
                field[ship.getCoordinates()[0]][ship.getCoordinates()[ship.getCoordinates().length - 1] + 1] = oreolSymbol;
                j += 1;
            }

            for (int i = n; i < j; i++) {
                if (ship.getCoordinates()[0] > 0) {
                    field[ship.getCoordinates()[0] - 1][ship.getCoordinates()[1] + i] = oreolSymbol;
                }
                if (ship.getCoordinates()[0] < 9) {
                    field[ship.getCoordinates()[0] + 1][ship.getCoordinates()[1] + i] = oreolSymbol;
                }

            }

        } else if (ship.getTypeOfShip().equals("vertical")) {
            if (ship.getCoordinates()[0] > 0) {
                field[ship.getCoordinates()[0] - 1][ship.getCoordinates()[1]] = oreolSymbol;
                n = -1;
            }
            if (ship.getCoordinates()[ship.getCoordinates().length - 2] < 9) {
                field[ship.getCoordinates()[ship.getCoordinates().length - 2] + 1][ship.getCoordinates()[1]] = oreolSymbol;
                j += 1;
            }

            for (int i = n; i < j; i++) {
                if (ship.getCoordinates()[1] > 1) {
                    field[ship.getCoordinates()[0] + i][ship.getCoordinates()[1] - 1] = oreolSymbol;
                }
                if (ship.getCoordinates()[1] < 9) {
                    field[ship.getCoordinates()[0] + i][ship.getCoordinates()[1] + 1] = oreolSymbol;
                }

            }
        }
    }

    public boolean isCellEmpty(int a, int b) {
        return field[a][b].equals(cellSymbol);
    }

}
