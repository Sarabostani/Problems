import java.util.ArrayList;
import java.util.List;

public class Morse {
    public static void Run() {
        System.out.println(uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
    }
    
    public static int uniqueMorseRepresentations(String[] words) {
        List<String> morseWords = new ArrayList<String>();
        String converted = "";
        for(String word : words){
            converted = convertToMorse(word);
            if(!morseWords.contains(converted)) {
                morseWords.add(converted);
            }
        }
        return morseWords.size();
    }
    
    private static String convertToMorse(String word) {
        String[] morseMap = new String[] {".-","-...","-.-.",
                "-..",".","..-.","--.","....","..",".---","-.-",
                ".-..","--","-.","---",".--.","--.-",".-.","...",
                "-","..-","...-",".--","-..-","-.--","--.."};
        StringBuffer sb = new StringBuffer();
        for (char c : word.toCharArray()) {
            sb.append(morseMap[c - 'a']);
        }
        
        return sb.toString();
    }
}
