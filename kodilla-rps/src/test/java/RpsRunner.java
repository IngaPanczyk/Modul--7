import java.util.Map;
import java.util.stream.Collectors;

public class RpsRunner {

    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();
        GiveWinner giveWinner = new GiveWinner();
        giveWinner.giveWinner(player, computer);
    }
}