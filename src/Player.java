public class Player {
    private String name;
    private GameFild ownFild;
    private GameFild enemyFild;
    private boolean shotResult = true;

    public Player(String name) {
        this.ownFild = new GameFild(this);
        this.enemyFild = new GameFild(this);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GameFild getOwnFild() {
        return ownFild;
    }

    public GameFild getEnemyFild() {
        return enemyFild;
    }

    public boolean isShotResult() {
        return shotResult;
    }

    public void setShotResult() {
        this.shotResult = true;
    }

    public void attack(Player player, int x, int y) {
        if (player.ownFild.isCellEmpty(x, y) || player.ownFild.getField()[x][y].equals(player.ownFild.getOreolSymbol())) {
            System.out.println("Miss");
            shotResult = false;
            player.enemyFild.getField()[x][y] = player.ownFild.getMissSymbol();
        } else {
            shotResult = true;
            System.out.println("Hit");
            player.enemyFild.getField()[x][y] = player.ownFild.getHitlSymbol();
        }
    }

    public boolean isAlivedShip() {
        for (int i = 0; i < getOwnFild().getField().length; i++) {
            for (int j = 0; j < getOwnFild().getField().length; j++) {
                if (getOwnFild().getField()[i][j].equals(getOwnFild().getShipSymbol())) {
                    return false;
                }
            }
        }
        return true;
    }
}