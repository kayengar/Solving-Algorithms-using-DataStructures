public class LFUCache {
    Map<Integer,Integer> map;
    Map<Integer,LinkedHashSet<Integer>> treeMap;
    Map<Integer,Integer> freqMap;
    final int capacity;
    int i = 0;
    int min;
    public LFUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        treeMap = new HashMap<>();
        min=1;
    }
    public int get(int key){
        System.out.println(key+" "+i++);
        if(!map.containsKey(key))
            return -1;
        if(freqMap.containsKey(key)){
            treeMap.get(freqMap.get(key)).remove(key);
            if(treeMap.get(freqMap.get(key)).size()==0){
                min = freqMap.get(key)+1;
                treeMap.remove(min-1);
                freqMap.put(key,min);
            }
            freqMap.put(key,freqMap.get(key)+1);
            if(treeMap.containsKey(freqMap.get(key))){
                treeMap.get(freqMap.get(key)).add(key);
            }
            else{
                LinkedHashSet<Integer> list = new LinkedHashSet<>();
                list.add(key);
                treeMap.put(freqMap.get(key),list);
            }
        }
        return map.get(key);
    }
    public void put(int key, int value){
        System.out.println(key+" "+value+" "+i++);
        if(capacity==0)
            return;
        if(map.size()>=capacity){
            LinkedHashSet<Integer> list = treeMap.get(min);
            Iterator it = list.iterator();
            Integer x = (Integer)it.next();
            list.remove(x);
            if(list.size()==0)
                treeMap.remove(min);
            map.remove(x);
        }
        int newFreq = 1;
        if(freqMap.containsKey(key)){
            newFreq = freqMap.get(key)+1;
            treeMap.get(newFreq-1).remove(key);
            if(treeMap.get(newFreq-1).size()==0)
                min = newFreq;  
        }
        freqMap.put(key, newFreq);

        if(treeMap.containsKey(newFreq)){
            LinkedHashSet<Integer> list = treeMap.get(newFreq);
            list.add(key);
                treeMap.put(newFreq,list );
        }
        else{
            LinkedHashSet<Integer> list = new LinkedHashSet<>();
            list.add(key);
            treeMap.put(newFreq,list);
        }
        map.put(key,value);
    }
}
