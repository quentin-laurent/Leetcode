import java.util.HashMap;

class Solution 
{
    public boolean wordPattern(String pattern, String s)
    {
        // A HashMap to store pairs of characters associated to a word
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;

        for(int i = 0; i < pattern.length(); i++)
        {
            // If the current character is not associated to a word, it is added to the map
            if(!map.containsKey(pattern.charAt(i)))
            {
                // If the word has already been paired with a character, then the pattern is invalid
                if(map.containsValue(words[i]))
                    return false;
                map.put(pattern.charAt(i), words[i]);
                continue;
            }

            // If the current word does not correspond to the pair stored in the map, then the pattern is invalid
            if(!map.get(pattern.charAt(i)).equals(words[i]))
                return false;
        }

        return true;
    }
}