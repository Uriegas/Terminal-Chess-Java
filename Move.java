//Una clase que guarde toda la información de un movimiento
public class Move {
	//------------------
	//Flags
	//------------------
    private boolean checkmate;
    private boolean kingsideCastle;
    private boolean queensideCastle;
    private boolean promotion;
    private boolean passant;
    private boolean stalemate;
    private boolean specialMovePiece;
    private boolean rookMove;

	//------------------
	//Piece
	//------------------
    private Piece piece;
    private Coordinate oldPos;
    private Coordinate newPos;
    private Piece pieceToCapture;

    Move(Piece piece, Coordinate destionation, Piece toCapture){
        this.checkmate = false;
        this.kingsideCastle = false;
        this.queensideCastle = false;
        this.promotion = false;
        this.passant = false;
        this.stalemate = false;
        this.specialMovePiece = false;
        this.rookMove = false;
        
        this.piece = piece;
        this.oldPos = this.piece.getCoordinate();
        this.newPos = destionation;
        this.pieceToCapture = toCapture;
    }
    
    Move(Piece piece, Coordinate destionation){
        this.checkmate = false;
        this.kingsideCastle = false;
        this.queensideCastle = false;
        this.promotion = false;
        this.passant = false;
        this.stalemate = false;
        this.specialMovePiece = false;
        this.rookMove = false;
        
        this.piece = piece;
        this.oldPos = this.piece.getCoordinate();
        this.newPos = destionation;
        this.pieceToCapture = null;
    }

    public String toString(){
        String s = "";

        s +=  "----Current  Piece----\n" + this.piece.toString();
        if(this.pieceToCapture == null)
            s += "---Piece to Capture---\n" + "NONE piece to Capture\n";
        else
            s += "---Piece to Capture---\n" + this.pieceToCapture.toString();

        s     += ("\n-------Flags--------"
               + "\nCheckmate = " + Boolean.toString(this.checkmate)
               + "\nKing Side Castle = " + Boolean.toString(this.kingsideCastle)
               + "\nQueen Side Castle = " + Boolean.toString(this.queensideCastle)
               + "\nPromotion = " + Boolean.toString(this.promotion)
               + "\nPassant = " + Boolean.toString(this.passant)
               + "\nStalemate = " + Boolean.toString(this.stalemate)
               + "\nSpecial Move Piece = " + Boolean.toString(this.specialMovePiece)
               + "\nRook Move = " + Boolean.toString(this.rookMove) );
        return s;
    }

    public Piece getPieceToMove(){
        return this.piece;
    }
    public Piece getPieceToCapture(){
        return this.pieceToCapture;
    }

    public Coordinate getOldPos(){
        return this.oldPos;
    }

    public Coordinate getNewPos(){
        return this.newPos;
    }

    public boolean isEqual(Move m){
        //Solo si la pieza es la misma y las coordenadas de destino
        if( this.piece.isEqual(m.piece) && this.newPos.equals(m.newPos) )
            return true;
        else
            return false;
    }

    public String toChessNotation(){
        return this.oldPos.toChessNotation() + " -> " + this.newPos.toChessNotation();
    }
}
