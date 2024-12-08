package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 241101 금 - 모스부호 - 백준 29701번
 * https://www.acmicpc.net/problem/29701
 * 해시
 * */
public class MorseCode29701 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Character> map = new HashMap<String, Character>();
        // 알파벳
        map.put(".-", 'A');
        map.put("-...", 'B');
        map.put("-.-.", 'C');
        map.put("-..", 'D');
        map.put(".", 'E');
        map.put("..-.", 'F');
        map.put("--.", 'G');
        map.put("....", 'H');
        map.put("..", 'I');
        map.put(".---", 'J');
        map.put("-.-", 'K');
        map.put(".-..", 'L');
        map.put("--", 'M');
        map.put("-.", 'N');
        map.put("---", 'O');
        map.put(".--.", 'P');
        map.put("--.-", 'Q');
        map.put(".-.", 'R');
        map.put("...", 'S');
        map.put("-", 'T');
        map.put("..-", 'U');
        map.put("...-", 'V');
        map.put(".--", 'W');
        map.put("-..-", 'X');
        map.put("-.--", 'Y');
        map.put("--..", 'Z');

        // 숫자
        map.put(".----", '1');
        map.put("..---", '2');
        map.put("...--", '3');
        map.put("....-", '4');
        map.put(".....", '5');
        map.put("-....", '6');
        map.put("--...", '7');
        map.put("---..", '8');
        map.put("----.", '9');
        map.put("-----", '0');

        // 특수문자
        map.put("--..--", ',');
        map.put(".-.-.-", '.');
        map.put("..--..", '?');
        map.put("---...", ':');
        map.put("-....-", '-');
        map.put(".--.-.", '@');
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = "";
        for (int i = 0; i < N; i++) {
            String encodedCharacter = st.nextToken();
            Character decoded = map.get(encodedCharacter);
            answer += decoded;
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
