// public class GameInitializer {
//     public static GameContext init() {
//         Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
//         Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
//         forest.setExit("north", temple);
//         temple.setExit("south", forest);
//         Player player = new Player("勇者", 100, 15);
//         return new GameContext(player, forest);
//     }
// }



// public class GameInitializer {
//     public static GameContext init() {
//         // 創建房間
//         Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
//         Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
//         Room village = new Room("小村莊", "這是一個安靜的小村莊", new Monster("九魂九尾貓", 25, 75), true);

//         // 設定房間之間的出口
//         forest.setExit("north", temple);
//         temple.setExit("south", forest);
//         village.setExit("east", temple);
//         temple.setExit("west", village);

//         // 創建玩家與初始房間
//         Player player = new Player("勇者", 100, 15);
//         GameMap gameMap = new GameMap();
//         gameMap.addRoom(forest.getName(), forest);
//         gameMap.addRoom(temple.getName(), temple);
//         gameMap.addRoom(village.getName(), village);

//         // 初始化遊戲
//         GameContext context = new GameContext(player, forest);
//         context.setGameMap(gameMap);

//         return context;
//     }
// }

public class GameInitializer {
    public static GameContext init() {
        // 建立房間
        Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
        Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
        Room village= new Room("小村莊  ", "這是一個安靜的小村莊", new Monster("九魂九尾貓", 25, 75), true);
        Room WoW    = new Room("世界奇觀", "遭了又是世界奇觀", null, true);


        // 設定出口
        forest.setExit("north", temple);
        WoW.setExit("east", temple);
        village.setExit("south", temple);

        temple.setExit("north", village);
        temple.setExit("south", forest);
        temple.setExit("west", WoW);

        


        // 創建 GameMap：3行 3列
        GameMap map = new GameMap(3, 3);
        map.setRoom(0, 1, village); // 第0行第1列（上）
        map.setRoom(1, 1, temple);  // 中間
        map.setRoom(2, 1, forest);  // 下
        map.setRoom(1, 0, WoW); 

        // 建立玩家與 Context
        Player player = new Player("哭勇者", 100, 15);
        GameContext context = new GameContext(player, forest);
        context.setGameMap(map);
        return context;
    }
}
