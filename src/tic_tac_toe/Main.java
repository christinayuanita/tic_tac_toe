package tic_tac_toe;

public class Main {

	public Main() {
		Board b = new Board();
		BoardPrinter p = new BoardPrinter(b);
		do{
			p.print();
			try {
				b.doTurn();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(b.isWin(Side.O)){
				System.out.println("O winner");
				break;
			}
			
			if(b.isWin(Side.X)){
				System.out.println("X winner");
				break;
			}
			
			if(b.isDraw()) {
				System.out.println("Draw");
				return;
			}
		}while(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
