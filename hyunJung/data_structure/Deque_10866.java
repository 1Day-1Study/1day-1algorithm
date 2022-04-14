package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Deque_10866 {

	static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
	static StringBuilder print = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		while (N-- > 0) {
			String[] cmd = input.readLine().split(" ");
			startProgram(cmd);
		}
		System.out.println(print);
	}

	static StringBuilder startProgram(String[] cmd) throws IOException {

		switch (cmd[0]) {
		case "push_front":
			dq.addFirst(Integer.parseInt(cmd[1]));
			break;
		case "push_back":
			dq.addLast(Integer.parseInt(cmd[1]));
			break;
		case "pop_front":
			if (!dq.isEmpty()) {
				print.append(dq.pollFirst()).append("\n");
			} else {
				print.append(-1).append("\n");
			}
			break;
		case "pop_back":
			if (!dq.isEmpty()) {
				print.append(dq.pollLast()).append("\n");
			} else {
				print.append(-1).append("\n");
			}
			break;
		case "size":
			print.append(dq.size()).append("\n");
			break;
		case "empty":
			if (dq.isEmpty()) {
				print.append(1).append("\n");
			} else {
				print.append(0).append("\n");
			}
			break;
		case "front":
			if (dq.isEmpty()) {
				print.append(-1).append("\n");
			} else {
				print.append(dq.peekFirst()).append("\n");
			}
			break;
		case "back":
			if (dq.isEmpty()) {
				print.append(-1).append("\n");
			} else {
				print.append(dq.peekLast()).append("\n");
			}
			break;
		default:
			System.out.println("not correct command");
			break;
		}

		return print;
	}
}
