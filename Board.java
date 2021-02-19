
public class Board
{
	private int filas;
	private int columnas;
	String[][] board;

	public Board(int filas, int columnas)
	{
		this.board = new String [filas][columnas];
		this.filas = filas;
		this.columnas = columnas;
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

}