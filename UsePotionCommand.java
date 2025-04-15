public class UsePotionCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();

        if (room.hasPotion()) {
            if (p.getHp()!=100){
                int healAmount = 30;
                p.heal(healAmount); 
                room.removePotion();
    
                System.out.println("你喝下了治療藥水，恢復了 " + healAmount + " 點生命！");
                System.out.println("目前生命：" + p.getHp());
            }
            else {
                System.out.println("血量已滿，無須喝藥水");
            }
        } else {
            System.out.println("這裡沒有藥水可以使用。");
        }
    }
}
