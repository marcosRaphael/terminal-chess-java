package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position position = new Position(0,0);
		
		if(getColor() == Color.WHITE) {
			position.setValues(this.position.getRow() - 1, this.position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			position.setValues(this.position.getRow() - 2, this.position.getColumn());
			Position position2 = new Position(this.position.getRow() - 1, this.position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getMoveCount() == 0 &&
			getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			
			}
			if(this.position.getRow() == 3) {
				Position left = new Position(this.position.getRow(), this.position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(this.position.getRow(), this.position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
				
			}
		}
		else {
			position.setValues(this.position.getRow() + 1, this.position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			position.setValues(this.position.getRow() + 2, this.position.getColumn());
			Position position2 = new Position(this.position.getRow() + 1, this.position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getMoveCount() == 0 &&
			getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			
			}
			if(this.position.getRow() == 4) {
				Position left = new Position(this.position.getRow(), this.position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(this.position.getRow(), this.position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
				
			}
		}
	
		return mat;
	
	}
}
