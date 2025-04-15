public class CommandParser {
    public static Command parse(String input) {
        if (input.startsWith("move ")) return new MoveCommand(input.substring(5));      //輸入若以move開頭 將字串刪掉前4個字
        if (input.equals("attack")) return new AttackCommand();
        if (input.equals("look")) return new LookCommand();
        if (input.equals("use potion")) return new UsePotionCommand();
        if (input.startsWith("skill ")) return new SkillCommand(input.substring(6));
        if (input.equals("exit")) System.exit(0);
        return null;
    }
}
