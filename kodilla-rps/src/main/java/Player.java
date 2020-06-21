import java.util.Scanner;

public class Player {
    int playerMove;


    public Player() {
        this.playerMove = playerMove;
    }


    public int getPlayerMove() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Jak masz na imię?");
        String firstName = scan.nextLine();
        System.out.println("Witaj " + firstName);
        System.out.println("klawisz 1 - zagranie kamień, klawisz 2 - zagranie papier, klawisz 3 - zagranie nożyce");
        int playerMove = scan.nextInt();
        if (playerMove > 3){
            System.out.print("Wprowadziłaes blędną liczbę, gra zakończona");
        }
        if(playerMove ==1) {
            System.out.println("Zagrałeś kamień");
        }else{
            if (playerMove == 2){
                System.out.println("Zagrałeś zagrał papier");
            }else {
                System.out.println("Zagrałeś zagrał nożyczki");
            }
        }
        return playerMove;
    }
}
