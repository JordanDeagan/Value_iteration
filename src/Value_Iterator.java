import java.util.ArrayList;
import java.util.Arrays;

public class Value_Iterator {
    static Square A,B,C,D,E,F,G,H,J;
    static ArrayList<Square> box;
    public static void main(String[] args) {
        int R = 100;
        A = new Square(R,false);
        B = new Square(-1,false);
        C = new Square(10,true);
        D = new Square(-1,false);
        E = new Square(-1,false);
        F = new Square(-1,false);
        G = new Square(-1,false);
        H = new Square(-1,false);
        J = new Square(-1,false);
        A.setNeighbors(null,B,D,null);
        B.setNeighbors(null,C,E,A);
        C.setNeighbors(null,null,F,B);
        D.setNeighbors(A,E,G, null);
        E.setNeighbors(B,F,H,D);
        F.setNeighbors(C,null,J,E);
        G.setNeighbors(D,H,null,null);
        H.setNeighbors(E,J,null,G);
        J.setNeighbors(F,null, null,H);
        box = new ArrayList<>(Arrays.asList(A,B,C,D,E,F,G,H,J));
//        drawSquares();
        ArrayList<Double> vals = new ArrayList<>();
        for(Square start:box){
            vals.add(DiscountedSum.expectedValue(.9,start,4));
        }
        drawValues(vals);
    }

    private static void drawSquares(){
        System.out.println("_________________");
        System.out.println("| " + A.getValue() + " | " + B.getValue() + " | " + C.getValue() + " |");
        System.out.println("_________________");
        System.out.println("| " + D.getValue() + " | " + E.getValue() + " | " + F.getValue() + " |");
        System.out.println("_________________");
        System.out.println("| " + G.getValue() + " | " + H.getValue() + " | " + J.getValue() + " |");
        System.out.println("_________________");
    }

    private static void drawValues(ArrayList<Double> vals){
        System.out.println("_______________________");
        System.out.println("| " + vals.get(0) + " | " + vals.get(1) + " | " + vals.get(2) + " |");
        System.out.println("_______________________");
        System.out.println("| " + vals.get(3) + " | " + vals.get(4) + " | " + vals.get(5) + " |");
        System.out.println("_______________________");
        System.out.println("| " + vals.get(6) + " | " + vals.get(7) + " | " + vals.get(8) + " |");
        System.out.println("_______________________");
    }
}
