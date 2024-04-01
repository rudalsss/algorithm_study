class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        int len = pat.length(); 
        
        // 비교대상문자열크기만큼씩 잘라서 비교하기
        // 비교대상문자열크기만큼 자르기가 가능할때까지 자르기
        for(int i=0; i<=myString.length()-len; i++){
            String str = myString.substring(i, i+len);
            if( str.equals(pat) ){
                answer++;
            }
        }
        
        return answer;
    }
}
