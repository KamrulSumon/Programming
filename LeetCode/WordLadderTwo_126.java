package com.sumon.leetcode;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each intermediate word must exist in the word list
 * @author Kamrul Hasan
 * @Ref  LeetCode #126
 */

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderTwo {

	// flag of whether we have connected two parts
	boolean isConnected = false;

	/*
	 * We use Bidirectional BFS which always expand from direction with less
	 * nodes We use char[] to build string so it would be fast Instead of
	 * scanning dict each time, we build new string from existing string and
	 * check if it is in dict
	 */
	List<List<String>> findLadders(String beginWord, String endWord, Set<String> dict) {

		Map<String, List<String>> ladder = new HashMap<String, List<String>>(); // hold
																				// ladder
		List<List<String>> result = new ArrayList<List<String>>();
		Set<String> fwdSet = new HashSet<>(); // forward set
		Set<String> bwdSet = new HashSet<>(); // backward set
		fwdSet.add(beginWord);
		bwdSet.add(endWord);

		// run bi-directional BFS to construct ladder and find shortest path
		BFS(fwdSet, bwdSet, dict, false, ladder);

		// if two parts cannot be connected, then return empty list
		if (!isConnected)
			return result;

		// we need to add start node to temp list as there is no other node can
		// get start node
		List<String> temp = new ArrayList<String>();
		temp.add(beginWord);

		// find all the paths
		DFS(result, temp, beginWord, endWord, ladder);

		return result;

	}

	/* contruct the graph or ladder */
	public void BFS(Set<String> fwdSet, Set<String> bwdSet, Set<String> dict, boolean swap,
			Map<String, List<String>> ladder) {
		// boundary check
		if (fwdSet.isEmpty() || bwdSet.isEmpty()) {
			return;
		}

		// run BFS on direction with less nodes. Here we assume forward set has
		// less node, if not, we swap them
		if (fwdSet.size() > bwdSet.size()) {
			BFS(bwdSet, fwdSet, dict, !swap, ladder);
			return;
		}

		// remove all forward/backward words from dict to avoid duplicate
		// addition
		dict.removeAll(fwdSet);
		dict.removeAll(bwdSet);

		// new set contains all new nodes from forward set
		Set<String> nextLevelSet = new HashSet<String>();

		// run BFS on every node of forward direction
		for (String word : fwdSet) {
			// try to change each char of the word
			for (int i = 0; i < word.length(); i++) {
				// replace current char with every chars from a to z
				char[] ary = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					ary[i] = j;
					String tmpWord = new String(ary); // make new word chain

					// skip this word/string if it is not in dictionary nor in
					// backward set
					if (!dict.contains(tmpWord) && !bwdSet.contains(tmpWord)) {
						continue;
					}

					// follow forward direction
					String key = !swap ? word : tmpWord;
					String value = !swap ? tmpWord : word;

					// if key not exist, then create list
					if (!ladder.containsKey(key)) {
						ladder.put(key, new ArrayList<String>());
					}

					// if temp word/string is in backward set, then it will
					// connect two parts
					if (bwdSet.contains(tmpWord)) {
						ladder.get(key).add(value);
						isConnected = true;
					}

					// if temp word is in dict, then we can add it to set as new
					// nodes in next layer
					if (!isConnected && dict.contains(tmpWord)) {
						ladder.get(key).add(value);
						nextLevelSet.add(tmpWord);
					}

				}
			}
		}

		// to force our path to be shortest, we will not run BFS if we have
		// found shortest path(isConnected = true)
		if (!isConnected) {
			BFS(nextLevelSet, bwdSet, dict, swap, ladder);
		}
	}// end BFS

	/* find all the paths from begin word to end word */
	public void DFS(List<List<String>> result, List<String> list, String start, String end,
			Map<String, List<String>> ladder) {
		// run DFS, more specifically backtracking to build paths

		// boundary case
		if (start.equals(end)) {
			result.add(new ArrayList<String>(list));
			return;
		}

		// not each node in hs is valid node in shortest path, if we found
		// current node does not have children node,
		// then it means it is not in shortest path
		if (!ladder.containsKey(start)) {
			return;
		}

		for (String word : ladder.get(start)) {
			list.add(word);
			DFS(result, list, word, end, ladder);
			list.remove(list.size() - 1); // remove the word, try to add another
											// from list
		}
	}

	/*
	 * 
	 * Dijkstra algo: taken from LeetCode
	 */
	public List<List<String>> findLadders2(String start, String end, Set<String> dict) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> results = new ArrayList<List<String>>();

		if (dict.size() == 0)
			return results;

		int min = Integer.MAX_VALUE;

		Queue<String> queue = new ArrayDeque<String>();
		queue.add(start);

		Map<String, Integer> ladder = new HashMap<String, Integer>();
		for (String string : dict)
			ladder.put(string, Integer.MAX_VALUE);
		ladder.put(start, 0);

		dict.add(end);
		// BFS: Dijisktra search
		while (!queue.isEmpty()) {

			String word = queue.poll();

			int step = ladder.get(word) + 1;// 'step' indicates how many steps
											// are needed to travel to one word

			if (step > min)
				break;

			for (int i = 0; i < word.length(); i++) {
				StringBuilder builder = new StringBuilder(word);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					builder.setCharAt(i, ch);
					String new_word = builder.toString();
					if (ladder.containsKey(new_word)) {

						if (step > ladder.get(new_word))// Check if it is the
														// shortest path to one
														// word.
							continue;
						else if (step < ladder.get(new_word)) {
							queue.add(new_word);
							ladder.put(new_word, step);
						} else
							;// It is a KEY line. If one word already appeared
								// in one ladder,
								// Do not insert the same word inside the queue
								// twice. Otherwise it gets TLE.

						if (map.containsKey(new_word)) // Build adjacent Graph
							map.get(new_word).add(word);
						else {
							List<String> list = new LinkedList<String>();
							list.add(word);
							map.put(new_word, list);
							// It is possible to write three lines in one:
							// map.put(new_word,new
							// LinkedList<String>(Arrays.asList(new
							// String[]{word})));
							// Which one is better?
						}

						if (new_word.equals(end))
							min = step;

					} // End if dict contains new_word
				} // End:Iteration from 'a' to 'z'
			} // End:Iteration from the first to the last
		} // End While

		// BackTracking
		LinkedList<String> list = new LinkedList<String>();
		backTrace(end, start, list, results, map);

		return results;
	}

	private void backTrace(String word, String start, List<String> list, List<List<String>> results,
			Map<String, List<String>> map) {
		if (word.equals(start)) {
			list.add(0, start);
			results.add(new ArrayList<String>(list));
			list.remove(0);
			return;
		}
		list.add(0, word);
		if (map.get(word) != null)
			for (String s : map.get(word))
				backTrace(s, start, list, results, map);
		list.remove(0);
	}

}

class WordLadderTest {
	public static void main(String[] args) {
		WordLadderTwo wl = new WordLadderTwo();
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		// wordList = ["hot","dot","dog","lot","log"]
		System.out.println(wl.findLadders(beginWord, endWord, dict).toString());
	}
}
