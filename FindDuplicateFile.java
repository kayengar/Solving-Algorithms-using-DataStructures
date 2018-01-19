class FindDuplicateFile {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String s : paths){
            String [] thisDir = s.split(" ");
            String rootPath = thisDir[0];
            boolean flag = false;
            String content = "";
            String fileN = "";
            for(int i = 1;i<thisDir.length;i++){
                String fileName = thisDir[i];
                fileN = fileName.substring(0,fileName.indexOf("("));
                content = fileName.substring(fileName.indexOf("(")+1,fileName.length());
                if(map.containsKey(content)){
                   List<String> list = map.get(String.valueOf(content));
                   list.add(rootPath+"/"+String.valueOf(fileN));
                }
                else{
                    List<String> list = new ArrayList<>();
                    list.add(rootPath+"/"+String.valueOf(fileN));
                    map.put(String.valueOf(content),list);
                }
            }
            
        }
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            if(entry.getValue().size()>1){
                result.add(entry.getValue());
            }
        }
        return result;
        
    }
}
