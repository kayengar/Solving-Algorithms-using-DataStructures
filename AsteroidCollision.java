class AsteroidCollision{
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<asteroids.length;i++){
            stack.push(asteroids[i]);
            if(stack.peek()<0){
                int a = stack.pop();
                while(!stack.isEmpty() && stack.peek()>=0 && a<0){
                    int s = stack.pop();
                    if(Math.abs(a)>s){
                    }
                    else if(Math.abs(a)<s){
                        a = s;
                    }
                    else{
                        a = 0;
                    }
                }
                if(a!=0)
                    stack.push(a);
            }            
        }
        int [] result = new int[stack.size()];
        for(int i = stack.size()-1;i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
        
    }
}
