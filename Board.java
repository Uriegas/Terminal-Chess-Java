import java.util.*;

public class Board
{
	private int filas;//8
	private int columnas;//8
	private String[][] board;//El tablero chicas, no se que haga Isaac

	//private Stack<Movimiento> movementHistory; //El historial chicas
	private ArrayList<Piece> pieces; //Array de piezas
	private String boardDrawed;//El tablero dibujado

	public Board(int filas, int columnas)
	{
		this.board = new String [filas][columnas];
		this.filas = filas;
		this.columnas = columnas;

		pieces = new ArrayList<Piece>();

		//Inicializar piezas, PD. se ve horribe pero jala
		//Inicializar peones
		for(int i = 0; i < 8; i++)//Miren la i de abajito para las coordenadas
			pieces.add(new Pawn(Color.WHITE, new Coordinate(i,1)));
		//Inicializar resto de las piezas
		pieces.add(new Rook(Color.WHITE, new Coordinate(0,0)));		//♜
		pieces.add(new Knight(Color.WHITE, new Coordinate(1,0)));	//♞
		pieces.add(new Bishop(Color.WHITE, new Coordinate(2,0)));	//♝
		pieces.add(new Queen(Color.WHITE, new Coordinate(3,0)));	//♛
		pieces.add(new King(Color.WHITE, new Coordinate(4,0)));		//♚
		pieces.add(new Bishop(Color.WHITE, new Coordinate(5,0)));	//♝
		pieces.add(new Knight(Color.WHITE, new Coordinate(6,0)));	//♞
		pieces.add(new Rook(Color.WHITE, new Coordinate(7,0)));		//♜
		//
	}

	public int getFilas()
	{
		return this.filas;
	}

	public int getColumnas()
	{
		return this.columnas;
	}

	public void setPiece(String piece, int filas, int columnas)
	{
		board[filas][columnas] = piece;
	}

	public String getPosition(int filas, int columnas)
	{
		return this.board[filas][columnas];
	}

	public String drawBoard(){
		this.boardDrawed = "";
		int sizeOfBoard = 0;
		//La neta no tengo idea de como pasar esto a un string
		for(int y=0; y<8; y++){
			for(int x=0; x<8; x++){//Recorrer filas
				//Antes de iterar sobre cada pieza, guarda el tamaño del boardDrawed
				sizeOfBoard = this.boardDrawed.length();
				for( int i=0; i<pieces.size(); i++){//Iterar sobre todas las piezas
					if(pieces.get(i).getPosition() == new Coordinate(x,y)){//Si la pieza esta en la coordenada iterable, entonces agregala al string
						this.boardDrawed += pieces.get(i).getFigure();
					}
				}
				//Verificar si en realidad se agrego algo a la casilla x,y
				if(sizeOfBoard == this.boardDrawed.length()){//No se agregó nada, entonces dibuja un puntillo
					this.boardDrawed += '·';
				}
			}
			//Se acabo de recorrer una fila, entonces agrega un salto de linea
			this.boardDrawed += '\n';
		}
		return this.boardDrawed;
	}

}