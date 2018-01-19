class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<prerequisites.length;i++){
            if(graph.containsKey(prerequisites[i][1]))
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(new Integer(prerequisites[i][0]));
                graph.put(new Integer(prerequisites[i][1]),list);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : graph.entrySet()){
            if(set.contains(entry.getKey()))
                continue;
            boolean result = canFinishUtils(entry.getKey(),new HashSet<Integer>(),graph,set);
            if(!result)
                return false;
        }
        return true;
    }
    public boolean canFinishUtils(int v,Set<Integer> set,Map<Integer,List<Integer>> graph, Set<Integer> oldSet){
       
        if(set.contains(v))
                return false;
         if(oldSet.contains(v))
            return true;
        oldSet.add(v);
        set.add(v);
        for(Integer s : graph.get(v)){
            if(graph.containsKey(s)){
                boolean res = canFinishUtils(s,set,graph,oldSet);
                if(!res)
                    return false;
            }
        }
        set.remove(v);
        return true;
    }
}
