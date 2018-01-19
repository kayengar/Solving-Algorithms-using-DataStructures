class MagicDictionary {
    Set<String> set;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict)
            set.add(word);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        String str = word;
        char [] w = word.toCharArray();
        for(int i = 0;i<w.length;i++){
            char j = w[i];
            for(char c = 'a';c<='z';c++){
                w[i] = c;
                String temp = String.valueOf(w);
                if(set.contains(temp) && !temp.equals(str))
                    return true;
            }
            w[i] = j;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
