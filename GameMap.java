// import java.util.HashMap;
// import java.util.Map;

// public class GameMap {
//     private Map<String, Room> rooms = new HashMap<>();

//     public void addRoom(String name, Room room) {
//         rooms.put(name, room);
//     }

//     public Room getRoom(String name) {
//         return rooms.get(name);
//     }

//     public void showMap() {
//         System.out.println("遊戲地圖：");
//         for (String roomName : rooms.keySet()) {
//             Room room = rooms.get(roomName);
//             System.out.println("房間：" + room.getName());
//             System.out.println("描述：" + room.getDescription());
//             System.out.println("可通往的方向：" + room.getExitString());
//             System.out.println();
//         }
//     }
// }
public class GameMap {
    private Room[][] grid; // 2D 房間地圖格子
    private int width;
    private int height;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Room[height][width]; // [row][col]
    }

    public void setRoom(int row, int col, Room room) {
        grid[row][col] = room;
    }

    public Room getRoom(int row, int col) {
        return grid[row][col];
    }

    public void showGridMap(Room currentRoom) {
        System.out.println("╔════════════ 地圖 ═══════════╗");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Room room = grid[i][j];
                if (room != null) {
                    if (room == currentRoom) {
                        System.out.print("★" + padName(room.getName()));
                    } else {
                        System.out.print("[" + padName(room.getName()) + "]");
                    }
                } else {
                    System.out.print("[        ]");
                }
            }
            System.out.println();
        }
        System.out.println("╚════════════════════════════╝\n");
    }

    // 統一名稱長度（最多5字），不足補空格
    private String padName(String name) {
        if (name.length() > 4) return name.substring(0, 4);
        while (name.length() < 4) name += " ";
        return name;
    }
}
