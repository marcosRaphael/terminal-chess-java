package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
		return chessPiece == null || chessPiece.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece chessPiece = (ChessPiece)getBoard().piece(position);
		return chessPiece != null && chessPiece instanceof Rook && chessPiece.getColor() == getColor() && chessPiece.getMoveCount() == 0;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position position = new Position(0, 0);
		
		position.setValues(this.position.getRow() - 1, this.position.getColumn());
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() + 1, this.position.getColumn());
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow(), this.position.getColumn() -1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow(), this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() - 1 , this.position.getColumn() - 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() - 1 , this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() + 1 , this.position.getColumn() -1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() + 1 , this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			Position position1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
			if(testRookCastling(position1)) {
				Position position2 = new Position(this.position.getRow(), this.position.getColumn() + 1);
				Position position3 = new Position(this.position.getRow(), this.position.getColumn() + 2);
				if(getBoard().piece(position2) == null && getBoard().piece(position3) == null) {
					mat[this.position.getRow()][this.position.getColumn() + 2] = true;
				}
			}
			Position position4 = new Position(this.position.getRow(), this.position.getColumn() - 4);
			if(testRookCastling(position4)) {
				Position position2 = new Position(this.position.getRow(), this.position.getColumn() - 1);
				Position position3 = new Position(this.position.getRow(), this.position.getColumn() - 2);
				Position position5 = new Position(this.position.getRow(), this.position.getColumn() - 3);
				if(getBoard().piece(position2) == null && getBoard().piece(position3) == null && getBoard().piece(position5) == null) {
					mat[this.position.getRow()][this.position.getColumn() - 2] = true;
				}
			}
		}
		return mat;
	}
}
