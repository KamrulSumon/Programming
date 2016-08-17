package com.sumon.leetcode;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * 
 * @author Kamrul Hasan
 * @Ref LeetCode #127
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/* simple BFS technique */
	int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		int distance = 0;
		if (beginWord.equals(endWord))
			return distance;

		wordList.add(endWord);

		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int q = 0; q < size; q++) {
				String word = queue.remove();
				if (word.equals(endWord))
					return distance + 1;
				for (int i = 0; i < word.length(); i++) {
					char[] currWord = word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						// String newWord = word.substring(0, i) + c +
						// word.substring(i + 1);
						currWord[i] = c;
						String newWord = new String(currWord);
						if (wordList.contains(newWord) && !word.equals(newWord)) {
							queue.add(newWord);
							wordList.remove(newWord);
						}
					}
				}
			}
			distance++;
		}
		return 0;
	}

	
	/* Bidirectional BFS that is faster idea taken from LeetCode */
	public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 1;
		HashSet<String> visited = new HashSet<String>();

		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// this makes search faster as we are searching from smaller set
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}

		return 0;
	}

	/* using Dijkastra's algorithm, idea taken from LeetCode */ // https://discuss.leetcode.com/topic/20965/java-solution-using-dijkstra-s-algorithm-with-explanation
	public int ladderLength3(String beginWord, String endWord, Set<String> wordDict) {
		Set<String> reached = new HashSet<String>();
		reached.add(beginWord);
		wordDict.add(endWord);
		int distance = 1;
		while (!reached.contains(endWord)) {
			Set<String> toAdd = new HashSet<String>();
			for (String each : reached) {
				for (int i = 0; i < each.length(); i++) {
					char[] chars = each.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						chars[i] = ch;
						String word = new String(chars);
						if (wordDict.contains(word)) {
							toAdd.add(word);
							wordDict.remove(word);
						}
					}
				}
			}
			distance++;
			if (toAdd.size() == 0)
				return 0;
			reached = toAdd;
		}
		return distance;
	}
}

class WordLadderTest {
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		String beginWord = "hot";
		String endWord = "dog";
		Set<String> dic = new HashSet<>();
		dic.add("hot");
		// dic.add("dot");
		dic.add("dog");
		// dic.add("lot");
		// dic.add("log");
		// wordList = ["hot","dot","dog","lot","log"]
		System.out.println(wl.ladderLength(beginWord, endWord, dic));
	}
}
