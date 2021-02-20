import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {
        String[][] field = new String[][]{{" "," "," "},{" "," "," "},{" "," "," "}};
        byte player = 1;
        byte[] coordinates = new byte[2];
        play(field,coordinates,player);
    }
    private static void play(String[][] field, byte[] coordinates, byte player){
        boolean finish = false;
        boolean correct;
        boolean win = false;
        byte i = 0;
        Scanner in = new Scanner(System.in);
        while(!finish && i<9){
            draw(field);
            coordinates = inputCoordinates(player,in);
            correct = putLabel(field,coordinates,player);
            if(correct){
                i++;
                if(checkWin(field)){
                    System.out.printf("Player №%d won!", player);
                    win = true;
                    finish = true;
                }
                player = (byte)(player==1?2:1);
            }else {
                System.out.println("The field is occupied!");

            }
        }
        if(!win){
            System.out.println("Draw!");
        }
        in.close();
    }

    private static boolean checkWin(String[][] field){
        int a=0;
        if(field[0][0]!=" " && field[0][0] == field[0][1] && field[0][1] == field[0][2]){
            return true;
        }
        if(field[1][0]!=" " && field[1][0] == field[1][1] && field[1][1] == field[1][2]){
            return true;
        }
        if(field[2][0]!=" " && field[2][0] == field[2][1] && field[2][1] == field[2][2]) {
            return true;
        }
        if(field[0][0]!=" " && field[0][0] == field[1][0] && field[1][0] == field[2][0]){
            return true;
        }
        if(field[0][1]!=" " && field[0][1] == field[1][1] && field[1][1] == field[2][1]){
            return true;
        }
        if(field[0][2]!=" " && field[0][2] == field[1][2] && field[1][2] == field[2][2]){
            return true;
        }
        if(field[0][0]!=" " && field[0][0] == field[1][1] && field[1][1] == field[2][2]){
            return true;
        }
        if(field[0][2]!=" " && field[0][2] == field[1][1] && field[1][1] == field[2][0]){
            return true;
        }
        return false;
    }

    private static boolean putLabel(String[][] field, byte[] coordinates, byte player){
        if(!emptyCoordinates(field,coordinates)) {
            return false;
        }
        if(player == 1){
            field[coordinates[0]][coordinates[1]] = "x";
        }else{
            field[coordinates[0]][coordinates[1]] = "o";
        }
        return true;
    }

    private static void draw(String[][] field){
        System.out.println("  0 1 2");
        System.out.printf("0 %s|%s|%s\n", field[0][0],field[0][1],field[0][2]);
        System.out.printf("1 %s|%s|%s\n", field[1][0],field[1][1],field[1][2]);
        System.out.printf("2 %s|%s|%s\n", field[2][0],field[2][1],field[2][2]);
        System.out.println();
    }
    private static boolean emptyCoordinates(String[][] field, byte[] coordinates){
        return field[coordinates[0]][coordinates[1]] == " ";
    }
    private static byte[] inputCoordinates(byte player,Scanner in){
        byte[] coordinates = new byte[2];


        System.out.printf("%d player: ", player);
        for(int i = 0; i<2; i++) {
            coordinates[i] = in.nextByte();
        }
        return coordinates;
    }
}
