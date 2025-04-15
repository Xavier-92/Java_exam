/*
 * 遊戲輸入指令檢查
 * 若無生命值則結束遊戲
 */

import java.util.Scanner;

public class GameEngine {
    private GameContext context;
    private Scanner scanner = new Scanner(System.in);

    public GameEngine(GameContext context) {
        this.context = context;
    }

    public void start() {
        while (context.getPlayer().isAlive()) {
            context.getGameMap().showGridMap(context.getCurrentRoom());     //顯示地圖

            System.out.println("\n你目前在：" + context.getCurrentRoom().getName());
            System.out.print("哭勇者( "+context.getPlayer().getHp()+"HP ) >> ");
            String input = scanner.nextLine();
            Command command = CommandParser.parse(input);
            if (command != null) {
                command.execute(context.getPlayer(), context);
            } else {
                System.out.println("無效的指令。");
            }
        }
        System.out.println("你已死亡，遊戲結束。");
    }
}
