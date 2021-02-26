import java.util.*;

public class Board
{
	private int filas;//8
	private int columnas;//8
	private String[][] board;//El tablero chicas, no se que haga Isaac

	//private Stack<Movimiento> movementHistory; //El historial chicas
	private ArrayList<Piece> pieces; //Array de piezas
	private String boardDrawed;//El tablero dibujado

	//------------------
	//Flags
	//------------------
	private boolean isCheckMate;

	public Board(int filas, int columnas)
	{
		this.board = new String [filas][columnas];
		this.filas = filas;
		this.columnas = columnas;
		this.isCheckMate = false;

		pieces = new ArrayList<Piece>();

		//Inicializar piezas, PD. se ve horribe pero jala
		//Inicializar peones
		for(int i = 0; i < 8; i++)//Miren la i de abajito para las coordenadas
			pieces.add(new Pawn(Color.WHITE, new Coordinate(i,1))); //♟
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
		Coordinate currentPosition;
		//La neta no tengo idea de como pasar esto a un string
		for(int y=0; y<8; y++){
			//Imprimir los numeros de filas
			this.boardDrawed += String.valueOf(8-y) + "  ";
			for(int x=0; x<8; x++){//Recorrer filas
				//Antes de iterar sobre cada pieza, guarda el tamaño del boardDrawed y crea una coordenada
				sizeOfBoard = this.boardDrawed.length();
				currentPosition = new Coordinate(x, y);
				for( int i=0; i<pieces.size(); i++){//Iterar sobre todas las piezas
					if( currentPosition.equals( pieces.get(i).getPosition() ) ){//Si la pieza esta en la coordenada iterable, entonces agregala al string
						//Seleccionar el color de la pieza segun la variable Color
						if(pieces.get(i).getColor() == Color.WHITE)//Azul
							this.boardDrawed += "\033[;34m" + pieces.get(i).getFigure() + "\u001B[0m" + ' ';
						else//Rojo
							this.boardDrawed += "\033[;31m" + pieces.get(i).getFigure() + "\u001B[0m" + ' ';
						//this.boardDrawed += pieces.get(i).getFigure();
					}
				}
				//Verificar si en realidad se agrego algo a la casilla x,y
				if(sizeOfBoard == this.boardDrawed.length()){//No se agregó nada, entonces dibuja un puntillo
					this.boardDrawed += "· ";
				}
			}
			//Se acabo de recorrer una fila, entonces agrega un salto de linea
			this.boardDrawed += '\n';
		}
		//Agregar la línea de "a b c d e f g h"
		this.boardDrawed += "   a b c d e f g h";
		return this.boardDrawed;
	}

	public void boardToFigures(){
		for(int i = 0; i < pieces.size(); i++)
			pieces.get(i).setFigureToFigure();
	}
	public void boardToLetters(){
		for(int i = 0; i < pieces.size(); i++)
			pieces.get(i).setFigureToLetter();

	}

	public boolean isCheckMate(){
		//Implementar una funcion que cheque si el rey tiene posibles movimiento
		//Una idea es que si se regresa una lista vacia de coordenadas, entonces no tiene posibles movimientos
		/*
		if(this.isThereLegalMoves("King") == false)
			this.isCheckMate = false;
		else
			this.isCheckMate = true;
			*/
		return this.isCheckMate;
	}
}