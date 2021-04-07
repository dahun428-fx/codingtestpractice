package pratice;

import java.util.Arrays;

public class 문자열압축 {

	/*
	 * s result "aabbaccc" 7 "ababcdcdababcdcd" 9 "abcabcdede" 8
	 * "abcabcabcabcdededededede" 14 "xababcdcdababcdcd" 17 2a2ba3c ->7 2ababcdcd ->
	 * 9
	 */
	public static void main(String[] args) {
		int answer = 문자열압축.solution("abc");
//		System.out.println(answer);
	}

	public static int solution(String s) {
		int answer = 0;
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.println("i : " +arr[i]);
			for(int j = 0; j < arr.length - 1; j++) {
				System.out.println("j : " +arr[j]);
			}
		}
		
		return answer;
	}
}
