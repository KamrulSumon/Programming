package com.sumon.misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Find Top K users from a file
 * @author Kamrul Hasan
 * @ref Carrere Cup Amazon section 
 */
class TopMostKUsersImpl {

	/* display top k users from a file */
	public static void findTopKUsers(String userNames, int K) {
		Map<String, Integer> map = new HashMap<>();
		String[] users = userNames.split(",");

		for (String user : users) {
			user = user.trim();

			if (map.containsKey(user)) {
				map.put(user, map.get(user) + 1);
			} else {
				map.put(user, 1);
			}
		}

		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {

			Entry<String, Integer> entry = iterator.next();

			if (entry.getValue() == K) {
				System.out.println(entry.getKey() + " " + K);
			}
		}

	}

}

public class TopMostKUsers {

	public static void main(String[] args) {
	
		String userNames = "user1, user4, user2, user1, user3, user1, user2, user3";
		int K = 3;
		
		TopMostKUsersImpl topK = new TopMostKUsersImpl();
		topK.findTopKUsers(userNames, K);
	}
}
