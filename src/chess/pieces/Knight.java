package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "N";
	}

	private boolean canMove(Position position) {
		ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
		return chessPiece == null || chessPiece.getColor() != getColor();
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position position = new Position(0, 0);
		
		position.setValues(this.position.getRow() - 1, this.position.getColumn() - 2);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() - 2, this.position.getColumn() - 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() - 2 , this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() - 1, this.position.getColumn() + 2);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() + 1 , this.position.getColumn() + 2);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() + 2 , this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() + 2 , this.position.getColumn() - 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		position.setValues(this.position.getRow() + 1 , this.position.getColumn() - 2);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		
		return mat;
	}
}
