import java.util.*;

public class Board{
	private Stack<Move> movementHistory; //El historial de movimientos
	private ArrayList<Piece> pieces; //Array de piezas
	private String boardDrawed;//El tablero dibujado
	private Color currentPlayer; //Cambiarla cada que se agrega un movimiento

	//------------------
	//Flags
	//------------------
	private boolean isCheckMate;
	private boolean isStalemate;

	public Board()
	{
		this.isCheckMate = false;
		this.currentPlayer = Color.WHITE;
		this.isStalemate = false;
		this.movementHistory = new Stack<>();

		this.pieces = new ArrayList<Piece>();

		//Inicializar piezas
		//Inicializar peones
		for(int i = 0; i < 8; i++){//Miren la i de abajito para las coordenadas
			pieces.add(new Pawn(Color.BLACK, new Coordinate(i,1))); //♟
			pieces.add(new Pawn(Color.WHITE, new Coordinate(i,6))); //♟ NEGROS
		}
		//Inicializar resto de las piezas
		pieces.add(new Rook(Color.BLACK, new Coordinate(0,0)));		//♜
		pieces.add(new Knight(Color.BLACK, new Coordinate(1,0)));	//♞
		pieces.add(new Bishop(Color.BLACK, new Coordinate(2,0)));	//♝
		pieces.add(new Queen(Color.BLACK, new Coordinate(3,0)));	//♛
		pieces.add(new King(Color.BLACK, new Coordinate(4,0)));		//♚
		pieces.add(new Bishop(Color.BLACK, new Coordinate(5,0)));	//♝
		pieces.add(new Knight(Color.BLACK, new Coordinate(6,0)));	//♞
		pieces.add(new Rook(Color.BLACK, new Coordinate(7,0)));		//♜

		pieces.add(new Rook(Color.WHITE, new Coordinate(0,7)));		//♜
		pieces.add(new Knight(Color.WHITE, new Coordinate(1,7)));	//♞
		pieces.add(new Bishop(Color.WHITE, new Coordinate(2,7)));	//♝
		pieces.add(new Queen(Color.WHITE, new Coordinate(3,7)));	//♛
		pieces.add(new King(Color.WHITE, new Coordinate(4,7)));		//♚
		pieces.add(new Bishop(Color.WHITE, new Coordinate(5,7)));	//♝
		pieces.add(new Knight(Color.WHITE, new Coordinate(6,7)));	//♞
		pieces.add(new Rook(Color.WHITE, new Coordinate(7,7)));		//♜
		//
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
					if( currentPosition.equals( pieces.get(i).getCoordinate() ) ){//Si la pieza esta en la coordenada iterable, entonces agregala al string
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
		this.boardDrawed += "\n   a b c d e f g h";
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
		this.isCheckMate = false;
		if(!movementHistory.empty()){
			List <Move> auxiliarLista = movementHistory.peek().getPieceToMove().getMoves(this);
			for (int i = 0; i < pieces.size(); i++){
				if(this.pieces.get(i).getColor() == getCurrentPlayer() && this.pieces.get(i).getFigure() == '♚'){
					for(Move m : auxiliarLista ){
						if (this.pieces.get(i).getCoordinate() == (m.getPieceToMove().getCoordinate())){
							this.isCheckMate = true;
						}
					}
				}
			}
			
		}
		return this.isCheckMate;
	}

	public boolean isStalemate(){
		//Si el rey no tiene movimientos validos pero no esta siendo atacado
		for (int i = 0; i < pieces.size(); i++){
			if(this.pieces.get(i).getColor() == Color.WHITE && this.pieces.get(i).getFigure() == '♚'){
				if(pieces.get(i).getMoves(this) == null){
					this.isCheckMate = true;
				}else{
					this.isCheckMate = false;
				}
			}else if (this.pieces.get(i).getColor() == Color.BLACK && this.pieces.get(i).getFigure() == '♚'){
				if(pieces.get(i).getMoves(this) == null){
					this.isCheckMate = true;
				}else{
					this.isCheckMate = false;
				}
			}
		}
		return this.isStalemate;
	}

	//El valor retornado indica solamente si el movimiento fue exitoso (o sea que si se hizo o no)
	public boolean makeMovement(Move move){
		if(move == null)
			return false;
		else{
			//Obtener los posibles Movimientos de la Pieza en cuestion
			ArrayList<Move> possibleMoves = new ArrayList<>( move.getPieceToMove().getMoves(this) );

			
			//Validar que sea un movimiento valido
			for(Move m : possibleMoves ){
				if( m.isEqual(move) ){//Buscar el move que se quiere hacer en la lista de los posibles moves
					for(Piece pieza : pieces){//Buscar la pieza que hace el movimiento y moverla;
						if( move.getPieceToMove().isEqual(pieza) ){
							pieza.setPosition(move.getNewPos());//Aqui se realiza el movimiento
							this.movementHistory.push(move);
							this.currentPlayer = (this.currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;

							if(move.getPieceToCapture() != null){//Si hay pieza para comer, entonces cometela
								for(Piece p : pieces){//Buscar la pieza a comer
									if(move.getPieceToCapture().isEqual(p)){
										pieces.remove(p);
										break;
									}
								}
								return true;
							}
							else //Si no hay pieza atacada retorna verdadero de todas formas
								return true;
						}
					}
				}
			}
			//Si no se hizo el movimiento
			return false;
		}
	}

	public void undoMovement(){
		if(movementHistory.empty())//Si esta vacia la lista de movimientos no hagas el undo
			return;

		this.currentPlayer = (this.currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
		Move undoMove = this.movementHistory.pop();
		Piece pieceToUndo = null;

		pieceToUndo = undoMove.getPieceToMove().deepCopy();//Get the piece to undo
		pieceToUndo.setPosition(undoMove.getNewPos());//Set the current position of the piece in board
		//
		for( int i = 0; i < pieces.size(); i++){
			if( pieceToUndo.isEqual(pieces.get(i)) ){
				pieces.get(i).setPosition(undoMove.getPieceToMove().getCoordinate());
				break;
			}
		}
		//Si se capturó una pieza entonces restaurala
		if(undoMove.getPieceToCapture() != null)
			pieces.add(undoMove.getPieceToCapture());
	}

	public Color getCurrentPlayer(){
		return this.currentPlayer;
	}

	public List<Coordinate> obtenerPiezasPorColor(Color color){
		List<Coordinate> listaPiezasCoordenadas = new ArrayList<>();
		listaPiezasCoordenadas.clear();
		for(Piece piece : pieces){
			if(piece.getColor().equals(color)){
				listaPiezasCoordenadas.add(piece.getCoordinate());
			}
		}
		return listaPiezasCoordenadas;
	}

	public Piece obtenerPiezaCoordenadas(Coordinate coordinate){
		for(Piece piece : pieces){
			if(piece.getCoordinate().equals(coordinate)){
				return piece;
			}
		}
		return null;
	}

	public String listPlayerMoves(){
		String s = new String();
		ArrayList<Move> possibleMoves = new ArrayList<>(possibleMovesCurrentPlayer());
		for( Move m : possibleMoves )
			s += m.toChessNotation() + '\n';
		return s;
	}

	public ArrayList<Move> possibleMovesCurrentPlayer(){
		ArrayList<Move> possibleMoves = new ArrayList<>();
		//Add all possible moves of all pieces
		for( Piece piece : pieces )
			if(piece.getColor() == this.currentPlayer)//If the piece's color is of the current color, then add the movements of that piece
				if( ! piece.getMoves(this).isEmpty() )
					possibleMoves.addAll(piece.getMoves(this));
		return possibleMoves;

	}
}