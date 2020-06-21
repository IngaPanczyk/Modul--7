public class GiveWinner {

    public String giveWinner(Player player, Computer computer) {

        //while (x!=)

        int rock = 1;
        int paper = 2;
        int sizors = 3;
        int computerMove = computer.getRandomComputerMove();
        int playerMove = player.getPlayerMove();
        //Remis
        if (playerMove == computerMove) {
            System.out.println("Remis, komputer zagrał to samo");
        } else {
            //Jeden
            if (playerMove == 1) {
                if (computerMove == 2) {
                    System.out.println("Przegrałeś, komputer zagrał papier");
                } else {
                    System.out.println("Wygrałeś, komputer zagrał nożyczki");
                }
            }
            if (playerMove == 2) {
                if (computerMove == 3) {
                    System.out.println("Przegrałeś, komputer zagrał norzyczki");
                } else {
                    System.out.println("Wygrałeś, komputer zagrał kamień");
                }
            }
            if (playerMove == 3) {
                if (computerMove == 1) {
                    System.out.println("Przegrałeś, komputer zagrał kamień");
                } else {
                    System.out.println("Wygrałeś, komputer zagrał papier");
                }
            }

        }
        return "Tura zakończona";
    }
}
