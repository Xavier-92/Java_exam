public class MoveCommand implements Command { 
    private String direction;

    public void execute(Player p, GameContext c) {
        Room currentRoom = c.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);  // 根據方向獲得下一個房間

        if (nextRoom != null) {
            c.setCurrentRoom(nextRoom);  // 移動到下一個房間
            System.out.println("你移動到了：" + nextRoom.getName());
            System.out.println(nextRoom.getDescription());
        } else {
            System.out.println("無效的方向。");
        }
    }

    public MoveCommand(String input) {
        this.direction = input.trim();  // 去除多餘的空格
    }
}

