public class AlphabetChanger{
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public char[] createNewAlphabet(String keyWord, int key){
        char[] newAlpha = new char[26];
        boolean findSame = false;
        int current;
        if(key+keyWord.length() > newAlpha.length) current = keyWord.length()+key - newAlpha.length;
            else current = key+keyWord.length();
        for(int i = 0; i < keyWord.length(); i++){
            if(i+key >= newAlpha.length) newAlpha[i-(newAlpha.length - key)] = keyWord.charAt(i);
            else newAlpha[i+key] = keyWord.charAt(i);
        }
        for(int i = 0; i < this.alphabet.length(); i++){
            for(int j = 0; j < keyWord.length(); j++){
                if(alphabet.charAt(i) == keyWord.charAt(j)){
                    findSame = true;
                    break;
                }
            }
            if(!findSame){
                newAlpha[current] = alphabet.charAt(i);
                current++;
            }
            findSame = false;
            if(current == newAlpha.length && i+keyWord.length() != alphabet.length()){
                current = 0;
            }
        }
        return newAlpha;
    }

    public String getAlphabet() {
        return alphabet;
    }
}
