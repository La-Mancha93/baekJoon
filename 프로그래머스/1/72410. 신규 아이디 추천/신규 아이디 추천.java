class Solution {
    public String solution(String new_id) {
        //아이디의 길이는 3자 이상 15자 이하
        // 아이디는 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 문자만 사용가능
        //단, 마침표는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없음
        String answer = new_id;
        //1. 모든 대문자를 대응되는 소문자로 치환
        answer = answer.toLowerCase();
        //2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
        String temp_answer = "";
        for(int i =0; i<answer.length();i++){
            char answer_char = answer.charAt(i);
            if(answer_char == '.') temp_answer += answer_char;
            if(answer_char == '_') temp_answer += answer_char;
            if(answer_char == '-') temp_answer += answer_char;
            if(answer_char >= '0' && answer_char <= '9') temp_answer += answer_char;
            if(answer_char >= 'a' && answer_char <= 'z') temp_answer += answer_char;
        //3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        }
        answer = temp_answer;
        temp_answer = "";
        for(int i =0; i<answer.length();i++){
            char answer_char = answer.charAt(i);
            if(i != 0 && answer_char == '.' && answer.charAt(i-1) == '.') continue;
            temp_answer += answer_char;
        }
        answer = temp_answer;
        temp_answer = "";
        //4. 마침표가 처음이나 끝에 위치한다면 제거
        if(answer.charAt(0) == '.') {
            for(int i =1;i<answer.length();i++){
                temp_answer += answer.charAt(i);
            }
            answer = temp_answer;
        }
        temp_answer = "";
        
        if(answer.length() >0 && answer.charAt(answer.length()-1) == '.') {
            for(int i =0;i<answer.length()-1;i++){
                temp_answer += answer.charAt(i);
            }
            answer = temp_answer;
        }
        //5. 빈 문자열이라면 a를 대입
        if(answer.length() == 0) answer += "a";
        //6. 길이가 16자 이상이라면 첫 15개의 문자를 제외한 나머지 문자를 모두 제거
        if(answer.length() >=16) {
            temp_answer = "";
            for(int i =0; i<15;i++){
                temp_answer += answer.charAt(i);
            }
           answer = temp_answer;
        }
        //7. 제거 후 마침표가 new_id의 끝에 위치한다면 마침ㅁ표도 제거
        if(answer.charAt(0) == '.') {
            for(int i =1;i<answer.length();i++){
                temp_answer += answer.charAt(i);
            }
            answer = temp_answer;
        }
        temp_answer = "";
        
        if(answer.length() >0 && answer.charAt(answer.length()-1) == '.') {
            for(int i =0;i<answer.length()-1;i++){
                temp_answer += answer.charAt(i);
            }
            answer = temp_answer;
        }
        //8. 길이가 2자 이하라면 new_id의 마지막 문자를 new_id길이가 3이될떄까지 반복하여 붙임
        if(answer.length() <= 2){
            char lastChar = answer.charAt(answer.length()-1);
            while(answer.length() <3){
                answer += lastChar;
            }
        }
        return answer;
    }
}