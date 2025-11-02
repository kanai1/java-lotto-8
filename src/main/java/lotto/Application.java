package lotto;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = Config.getMachine();
        lottoMachine.run();
    }
}
