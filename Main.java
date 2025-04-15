public class Main {
    public static void main(String[] args) {
        GameContext context = GameInitializer.init();       //初始化角色
        GameEngine engine = new GameEngine(context);
        engine.start();
    }
}
