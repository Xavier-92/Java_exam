public class SkillCommand implements Command {
    private String skillName;

    public SkillCommand(String name) {
        this.skillName = name.trim().toLowerCase(); // 正規化一下
    }

    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        Monster monster = room.getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有怪物可以攻擊。");
            return;
        }

        // 建立技能（暫時硬編 fireball，可擴充）
        Skill skill = null;
        if (skillName.equals("fireball")) {
            skill = new FireballSkill();
        }

        if (skill == null) {
            System.out.println("你不會這個技能：" + skillName);
            return;
        }

        // 使用技能
        System.out.println("你施展了技能：" + skill.getName() + "！");
        showSkillAnimation(skill.getName());

        skill.use(p, monster);

        if (!monster.isAlive()) {
            System.out.println("你用技能擊敗了 " + monster.getName() + "！");
            p.addKill();
        } else {
            System.out.println(monster.getName() + " 剩下 HP：" + monster.getHp());
        }
    }

    // 動畫效果（模擬用 print）
    private void showSkillAnimation(String skillName) {
        switch (skillName) {
            case "fireball":
                System.out.println("🔥 火球飛向敵人，轟隆一聲爆炸！");
                break;
            default:
                System.out.println("* 神秘的力量釋放出來！ *");
        }
    }
}
