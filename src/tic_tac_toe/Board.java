package tic_tac_toe;

import java.util.Scanner;

public class Board {

	/**
	 * @author name java doc
	 */

	private Side[][] grids;

	// 1 = O
	// -1 = X
	private Side turn;

	public Board() {
		grids = new Side[3][3];
		turn = Side.O;
	}

	public boolean isWin(Side side) {

		if (isVerticalWin(side))
			return true;

		if (isHorizontalWin(side))
			return true;

		if (isDiagonalLeftTopWin(side))
			return true;

		if (isDiagonalTopRight(side))
			return true;

		return false;
	}

	public boolean isDiagonalTopRight(Side side) {
		boolean win = true;
		for (int i = 0, j = 2; i < 3; i++, j--) {
			Side g = grids[i][j];
			if (g != side) {
				win = false;
				break;
			}
		}
		if (win)
			return true;

		return false;
	}

	public boolean isDiagonalLeftTopWin(Side side) {
		boolean win = true;
		for (int i = 0, j = 0; i < 3; i++, j++) {
			Side g = grids[i][j];
			if (g != side) {
				win = false;
				break;
			}
		}
		if (win)
			return true;
		return false;
	}

	public boolean isHorizontalWin(Side side) {
		for (int i = 0; i < 3; i++) {
			boolean win = true;
			for (int j = 0; j < 3; j++) {
				Side g = grids[j][i];
				if (g != side) {
					win = false;
					break;
				}
			}
			if (win)
				return true;
		}
		return false;
	}

	public boolean isVerticalWin(Side side) {
		for (int i = 0; i < 3; i++) {
			boolean win = true;
			for (int j = 0; j < 3; j++) {
				Side g = grids[i][j];
				if (g != side) {
					win = false;
					break;
				}
			}
			if (win)
				return true;
		}
		return false;
	}

	Scanner scan = new Scanner(System.in);

	public void doTurn() throws Exception {
		String s = turn == Side.O ? "O" : "X";
		System.out.print(s + " turn: ");

		String move = scan.nextLine();
		if (move.length() != 2) {
			throw new Exception("invalid move: query must be 2 characters");
		}

		char c1 = move.charAt(0);
		char c2 = move.charAt(1);

		if (c1 < 'A' || c1 > 'C') {
			throw new Exception("invalid move: 1st characters");
		}

		if (c2 < '1' || c2 > '3') {
			throw new Exception("invalid move: 2nd characters");
		}

		int file = convertFileToInt(c1);
		int rank = convertRankToInt(c2);
		if (grids[file][rank] != Side.Neutral) {
			throw new Exception("invalid move: already occupied");
		}
		grids[file][rank] = turn;
		// turn = turn == 1 ? -1 : 1;
//		turn *= -1;
		turn = turn == Side.O ? Side.X : Side.O;
	}

	public int convertRankToInt(char c2) {
		return c2 - '1';
	}

	public int convertFileToInt(char c1) {
		return c1 - 'A';
	}

	public boolean isDraw() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Side g = grids[i][j];
				if (g == Side.Neutral)
					return false; // kl masih ada yg kosong return false
			}
		}
		return true;
	}

	public Side[][] getGrids() {
		return grids;
	}

	
}
