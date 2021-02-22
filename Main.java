public class Main {
    public static void main(String[] args) {
        int filas = 8, columnas = 8;
		Board board = new Board(filas, columnas);
		String linea = "";
		King king = new King();
		Pawn pawn = new Pawn();
		Queen queen = new Queen();

		//Agrega los Reyes
		board.setPiece(String.valueOf(king.getFigure()), 0, 4);
		board.setPiece(String.valueOf(king.getFigure()), 7, 4);

		//Agrega las Reinas
		board.setPiece(String.valueOf(queen.toChar()), 0, 3);
		board.setPiece(String.valueOf(queen.toChar()), 7, 3);

		//Agrega peones en la 2da y 7ma fila
		for(int i = 0; i < board.getFilas(); i++)
		{
			for(int j = 0; j < board.getColumnas(); j++)
			{
				//System.out.println("Entra");
				if(i == 1 || i == 6)
				{
					board.setPiece(String.valueOf(pawn.toChar()), i, j);
					board.setPiece(String.valueOf(pawn.toChar()), i, j);
				}
				else if(board.getPosition(i, j) == null)
				{
					board.setPiece(String.valueOf("x"), i, j);
				}
			}
		}

		int k = 97;
		String filasCoordenadas =" ";
		for(int i = 0; i < board.getFilas(); i++)
		{
			linea = String.valueOf(8-i + " ");
			for(int j = 0; j < board.getColumnas(); j++)
			{
				if(j == 7)
				{
					filasCoordenadas += "  " + String.valueOf((char) k);
					k++;
				}
				linea = linea + "  " + board.getPosition(i, j);
			}

			System.out.println(linea);
			linea = "";
		}
		System.out.println("\n " + filasCoordenadas);
    }
}
