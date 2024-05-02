
package Dominio;

/**
 * Clase para representar la clase Proxy para el tablero dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class ProxyBoard /*implements InterfaceBoard*/{

    private Board board;

    /**
     * Método constructor base de la clase.
     */
    public ProxyBoard() {
    }
    
    
    /*@Override
    public Line addLine() {
        if (board == null) {
            board = new Board();
        }
        return board.addLine();
    }

    @Override
    public Box addBox() {
        if (board == null) {
            board = new Board();
        }
        return board.addBox();
    }

    @Override
    public Dot addDot() {
        if (board==null) {
            board=new Board();
        }
        return board.addDot();
    }*/
    
}
