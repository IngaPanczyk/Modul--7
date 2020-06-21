import java.util.Random;

public class Computer {

    public int getRandomComputerMove (){
        Random random = new Random();
        int computerMove = random.nextInt(3)+1;
      /*  if(computerMove ==1) {
            System.out.println("Komputer zagrał kamień");
        }else{
            if (computerMove == 2){
                System.out.println("Komputer zagrał papier");
                    }else {
                    System.out.println("Komputer zagrał nożyczki");
                    }
        }*/
        return computerMove;
    }
}
