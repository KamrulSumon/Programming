package com.sumon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given an array of strings, group anagrams together.
 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */

public class GroupAnagram {

  public static void main(String[] args) {
    String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    GroupAnagram ga = new GroupAnagram();
    System.out.println(ga.groupAnagrams(strs));
  }

  public List<List<String>> groupAnagrams(String[] strs) {

    if (strs == null || strs.length == 0) {
      return null;
    }

    HashMap<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] sortedStr = str.toCharArray();
      Arrays.sort(sortedStr);
      String newSorted = new String(sortedStr);
      if (!map.containsKey(newSorted)) {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(newSorted, list);
      } else {
        map.get(newSorted).add(str);
      }
    }
    List<List<String>> result = new ArrayList<>();
    result.addAll(map.values());
    return result;

  }

}
