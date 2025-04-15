public class FireballSkill implements Skill {
    public String getName() {
        return "fireball";
    }

    public void use(Player p, Monster m) {
        int damage = p.getAttack() + 10;  // 額外傷害 +10
        m.takeDamage(damage);
        p.addDamage(damage);
        System.out.println("🔥 火球造成 " + damage + " 點傷害！");
    }
}
