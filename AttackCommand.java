public class AttackCommand implements Command { 
    public void execute(Player p, GameContext c) {
        Room currentRoom = c.getCurrentRoom();
        Monster monster = currentRoom.getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有可以攻擊的怪物。");
            return;
        }

        // 玩家攻擊怪物
        int damage = p.getAttack();
        monster.takeDamage(damage);
        p.addDamage(damage);
        System.out.println("你攻擊了 " + monster.getName() + "，造成了 " + damage + " 傷害！");

        // 判斷怪物是否死亡
        if (!monster.isAlive()) {
            System.out.println("你打倒了 " + monster.getName() + "！");
            p.addKill();
            return;
        }

        // 怪物反擊
        int counterDamage = monster.getAttack();
        p.takeDamage(counterDamage);
        System.out.println(monster.getName() + " 反擊你，造成了 " + counterDamage + " 傷害！");
        System.out.println("你的剩餘生命：" + p.getHp());
    } 
}