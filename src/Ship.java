public class Ship {
    private int[] coordinates;
    private String typeOfShip;

    public Ship(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getTypeOfShip() {
        return typeOfShip;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public boolean isShipValid() {
        boolean result = false;

        if (coordinates.length == 8) {
            if (coordinates[0] == coordinates[2] && coordinates[0] == coordinates[4] && coordinates[0] == coordinates[6]) {
                if (coordinates[3] == coordinates[1] + 1 && coordinates[5] == coordinates[3] + 1 && coordinates[7] == coordinates[5] + 1) {
                    result = true;
                    typeOfShip = "horizontal";
                }
            } else if (coordinates[1] == coordinates[3] && coordinates[1] == coordinates[5] && coordinates[1] == coordinates[7]) {
                if (coordinates[2] == coordinates[0] + 1 && coordinates[4] == coordinates[2] + 1 && coordinates[6] == coordinates[4] + 1) {
                    result = true;
                    typeOfShip = "vertical";
                }
            }
        } else if (coordinates.length == 6) {
            if (coordinates[0] == coordinates[2] && coordinates[0] == coordinates[4]) {
                if (coordinates[3] == coordinates[1] + 1 && coordinates[5] == coordinates[3] + 1) {
                    result = true;
                    typeOfShip = "horizontal";
                }
            } else if (coordinates[1] == coordinates[3] && coordinates[1] == coordinates[5]) {
                if (coordinates[2] == coordinates[0] + 1 && coordinates[4] == coordinates[2] + 1) {
                    result = true;
                    typeOfShip = "vertical";
                }
            }
        } else if (coordinates.length == 4) {
            if (coordinates[0] == coordinates[2]) {
                if (coordinates[3] == coordinates[1] + 1) {
                    result = true;
                    typeOfShip = "horizontal";
                }
            } else if (coordinates[1] == coordinates[3]) {
                if (coordinates[2] == coordinates[0] + 1) {
                    result = true;
                    typeOfShip = "vertical";
                }
            }
        } else if (coordinates.length == 2) {
            result = true;
            typeOfShip = "horizontal";
        }
        return result;
    }
}
