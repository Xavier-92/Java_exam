public class LookCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();

        System.out.println("你目前在：" + room.getName());
        System.out.println(room.getDescription());

        // 顯示怪物資訊
        Monster monster = room.getMonster();
        if (monster != null && monster.isAlive()) {
            System.out.println("這裡有一隻怪物：" + monster.getName() + "（HP：" + monster.getHp() + "）");
        } else {
            System.out.println("這裡沒有怪物。");
        }

        // 顯示藥水資訊
        if (room.hasPotion()) {
            System.out.println("你看到一瓶治療藥水。");
        }

        // 顯示出口資訊
        String exits = room.getExitString();
        System.out.println("你可以往這些方向走：" + (exits.isEmpty() ? "沒有出口" : exits));
    }
}
