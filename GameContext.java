public class GameContext {
    private Player player;
    private Room currentRoom;
    
    private GameMap gameMap; // 新增 GameMap

    public GameContext(Player player, Room startRoom) {
        this.player = player;
        this.currentRoom = startRoom;
    }

    public Player getPlayer() { return player; }
    public Room getCurrentRoom() { return currentRoom; }
    public void setCurrentRoom(Room room) { this.currentRoom = room; }

    //新增地圖功能
    public GameMap getGameMap() { return gameMap; } // 新增 getter
    public void setGameMap(GameMap gameMap) { this.gameMap = gameMap; } // 新增 setter
}
