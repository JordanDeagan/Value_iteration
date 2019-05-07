import java.util.ArrayList;
import java.util.Arrays;

public class Square {
    Square U,R,D,L;
    private int V;
    boolean fin;
    public Square(int value,  boolean end){
        V = value;
        fin = end;
    }

    public void setNeighbors(Square up, Square right, Square down, Square left){
        U = up;
        L = left;
        D = down;
        R = right;
    }

    public int getValue() {
        return V;
    }

    public void setValue(int v) {
        V = v;
    }
    public ArrayList<Square> getNeighbors(){
//        System.out.println(U + " " + R + " " + D + " " + L);
        return new ArrayList<>(Arrays.asList(U,R,D,L));
    }
    public ArrayList<Square> moveOptions(int direction){
        switch (direction){
            case 0: return new ArrayList<>(Arrays.asList(U,R,L));
            case 1: return new ArrayList<>(Arrays.asList(R,D,U));
            case 2: return new ArrayList<>(Arrays.asList(D,R,L));
            case 3: return new ArrayList<>(Arrays.asList(L,D,U));
        }
        return null;
    }
}
