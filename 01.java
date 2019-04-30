import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");

        System.out.println(status(sequencia));
    }

    public static boolean status(String[] sequencia){
        for(int i=0; i<sequencia.length; i++){
            for(int j=0; j<sequencia.length; j++){
                if(i!=j && sequencia[i].equals(sequencia[j])){
                    return true;
                }
            }
        } return false;
    }

}