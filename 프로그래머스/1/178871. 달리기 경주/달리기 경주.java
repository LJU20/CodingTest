import java.util.HashMap;

class Solution {
    
    static public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String name : callings) {

            int i = map.get(name);

            String temp = "";
            temp = players[i - 1];

            players[i - 1] = players[i];
            players[i] = temp;

            map.put(name, i - 1);
            map.put(temp, i);
        }

        return players;
    }
}