import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class CaesarMethod {
    private AlphabetChanger alphabetChanger;
    private char[] newAlphabet;
    public CaesarMethod(int key, String keyWord){
        init(key, keyWord);
    }
    private void init(int key, String keyWord) throws IllegalArgumentException{
        if((keyWord.length()>25) || (!keyWord.matches("[a-zA-z]+"))) throw new IllegalArgumentException();
        if((key<0) || (key>25)) throw new IllegalArgumentException();
        alphabetChanger = new AlphabetChanger();
        this.newAlphabet = alphabetChanger.createNewAlphabet(keyWord, key);
    }
    public String encrypt(String content){
        StringBuilder stringBuilder = new StringBuilder();
        content.chars().forEach(c -> {
            char element = (char) c;
            boolean isUpperCase = false;
            for(int i = 0; i < alphabetChanger.getAlphabet().length(); i++){
                if(Character.isUpperCase(element)) isUpperCase = true;
                element = Character.toLowerCase(element);
                if(element == alphabetChanger.getAlphabet().charAt(i)) {
                    element = this.newAlphabet[i];
                    if(isUpperCase) element = Character.toUpperCase(element);
                    stringBuilder.append(element);
                    break;
                }
                if(isUpperCase) element = Character.toUpperCase(element);
                if((i+1) == alphabetChanger.getAlphabet().length()) stringBuilder.append(element);
            }
        });
        return stringBuilder.toString();
    }
    public String decrypt(String content){
        StringBuilder stringBuilder = new StringBuilder();
        content.chars().forEach(c -> {
            char element = (char) c;
            boolean isUpperCase = false;
            for(int i = 0; i < alphabetChanger.getAlphabet().length(); i++){
                if(Character.isUpperCase(element)) isUpperCase = true;
                element = Character.toLowerCase(element);
                if(element == this.newAlphabet[i]) {
                    element = alphabetChanger.getAlphabet().charAt(i);
                    if(isUpperCase) element = Character.toUpperCase(element);
                    stringBuilder.append(element);
                    break;
                }
                if(isUpperCase) element = Character.toUpperCase(element);
                if((i+1) == alphabetChanger.getAlphabet().length()) stringBuilder.append(element);
            }
        });
        return stringBuilder.toString();
    }
    public AlphabetChanger getAlphabetChanger() {
        return alphabetChanger;
    }
}
