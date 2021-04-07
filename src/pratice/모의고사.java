package pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 모의고사 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		int[] answer = 모의고사.solution(answers);
		System.out.println();
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + ", ");
		}
	}

//	정답이 순서대로 들은 배열 answers
	public static int[] solution(int[] answers) {
//		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
		// 2 1 2 3 2 4 2 5
//		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
		// 3 3 1 1 2 2 4 4 5 5
		// 0 1 2 3 4 5 6 7 8 9
		//
//		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

		// 1
		int firstCnt = 0;
		int secCnt = 0;
		int thirdCnt = 0;
		int j = 1;
		int k = 0;
		for (int i = 0; i < answers.length; i++) {
			int temp = 0;
			if (i % 2 == 0) {
				temp = 2;
			} else {
				k++;
				if (k == 2) {
					k++;
				}
				temp = k;
			}
			int temp2 = 0;
			if (i % 10 <= 1) {
				temp2 = 3;
			} else if (i % 10 <= 3) {
				temp2 = 1;
			} else if (i % 10 <= 5) {
				temp2 = 2;
			} else if (i % 10 <= 7) {
				temp2 = 4;
			} else {
				temp2 = 5;
			}
//			System.out.println("[" + i + "]번째 : " + answers[i] + "|| " + j + "||" + temp + " || " + temp2);
			if (answers[i] == j) {
				firstCnt++;
			}
			if (answers[i] == temp) {
				secCnt++;
			}
			if (answers[i] == temp2) {
				thirdCnt++;
			}
			j++;
			if (j > 5) {
				j = 1;
			}
			if (k > 4) {
				k = 0;
			}

		}
//		System.out.println("first : " + firstCnt);
//		System.out.println("sec : " +secCnt );
//		System.out.println("third : " + thirdCnt);
		List<Integer> answerList = new ArrayList<>();
		List<Integer> cnt = new ArrayList<Integer>();
		cnt.add(firstCnt);
		cnt.add(secCnt);
		cnt.add(thirdCnt);
		Collections.sort(cnt);
		int highestCnt = cnt.get(2);
//		System.out.println("highest : " + highestCnt);
		if(firstCnt >= highestCnt) {
			answerList.add(1);
		}
		if(secCnt >= highestCnt) {
			answerList.add(2);
		}
		if(thirdCnt >= highestCnt) {
			answerList.add(3);
		}
		int[] answer = new int[answerList.size()];
		for(int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}
}
