package pratice;

import java.util.ArrayList;
import java.util.List;

public class 인형뽑기 {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 3, 2, 4, 2, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		int answer = 인형뽑기.solution(board, moves);
		System.out.println("answer : " + answer);
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
		List<Integer> resultList = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		boolean isPicked = false;
		for (int m = 0; m < moves.length; m++) {
			int pick = moves[m];
			for (int i = 0; i < board.length; i++) {
				int picked = board[i][pick - 1];
				if (picked > 0 && isPicked == false) {
					
					list.add(picked);
					board[i][pick - 1] = 0;
					isPicked = true;
				}
			}
			isPicked = false;
		}
		int i = 0 ;
		while(i < list.size()) {
			if((i+1) == list.size()) {
				break;
			}
			if(list.get(i) == list.get(i + 1)) {
				
				resultList.add(list.get(i));
				resultList.add(list.get(i + 1));
				list.remove(i + 1);
				list.remove(i);
				i = 0;
			} else {
				i++;
			}
			
		}
		System.out.println("result : " + list.toString());
		System.out.println("resultList : " + resultList.toString());
		answer = resultList.size();
		return answer;
	}
}
