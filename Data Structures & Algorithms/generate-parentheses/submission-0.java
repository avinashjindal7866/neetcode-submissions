class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        recursion("",0,0,result,n);
        return result;
    }

    public void recursion(String ans, int open,int close, List<String> ansList,int total){
        
        if(open == total && close == total ){
            ansList.add(ans);
            return;
        }
        

        if(open < total){
            recursion(ans + "(",open+1,close,ansList,total);
        }
        if(close < open){
            recursion(ans + ")",open,close+1,ansList,total);
        }
        
        
    }
}
