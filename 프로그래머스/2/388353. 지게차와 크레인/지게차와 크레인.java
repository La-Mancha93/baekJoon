class Solution {
    static boolean[][] check;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        String[][] box = new String[storage.length+2][storage[0].length()+2];
        check = new boolean[storage.length+2][storage[0].length()+2];
        for(int i =0; i<box.length;i++){
            for(int j = 0; j<box[i].length;j++){
                if(i ==0) box[i][j] = "0";
                else if(i == box.length-1) box[i][j] = "0";
                else if(j == 0) box[i][j] = "0";
                else if(j == box[i].length-1) box[i][j] = "0";
                else box[i][j] = String.valueOf(storage[i-1].charAt(j-1));
            }
        }

        for(int i =0; i<requests.length;i++){
            if(requests[i].length() == 1){
                jigecha(box,requests[i]);
                box = clearBox(box);
            } else{
                box = crain(box, String.valueOf(requests[i].charAt(0)));
            }
        }
        //만약 requests의 값의 길이가 1글자라면..
        //0인 값에서 상하좌우로 접근했을 때 requests의 문자와 동일한 값이 있는지 확인
        //requests의 값의 길이가 2글자라면...
        //그냥 box배열내부에 동일한 값이 있는지 전체확인
        int result = 0;
        for (String[] strings : box) {
            for (String string : strings) {
                if(!string.equals("0")) result++;
            }
        }
        return result;
    }

    private String[][] clearBox(String[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if(check[i][j]) box[i][j] = "0";
                check[i][j] = false;
            }
        }
        return box;
    }

    private String[][] jigecha(String[][] box, String alphabet){
        for(int i =0;i<box.length;i++){
            // 외곽부분만 로직 진행
            if(i == 0){
                for(int j=0;j<box[i].length;j++){
                    foundAndChange(box,j,i,alphabet);
                }
            }else if(i > 0 && i <box.length-1){
                foundAndChange(box,0,i,alphabet);
                foundAndChange(box,box[i].length-1,i,alphabet);
            }else {
                for(int j=0;j<box[i].length;j++){
                    foundAndChange(box,j,i,alphabet);
                }
            }
        }
        return box;
    }
    private static void foundAndChange(String[][] box, int x, int y, String alphabet){
        if(check[y][x]) return;
        check[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //상하좌우 접근가능한지(표 내부인지) 확인
            if(nx>=0 && nx <box[y].length && ny>=0 && ny<box.length){
                //접근 가능할 경우 해당 위치의 값이 알파벳과 같은지 확인
                if(box[ny][nx].equals(alphabet)){
                    //같을 경우 값을 "0"으로 변경하고 해당 위치에서 한번더 메서드 수행
                    check[ny][nx] = true;
                    foundAndChange(box,nx,ny,alphabet);
                }
                //값이 다를 경우 "0"인지 확인
                else if(box[ny][nx].equals("0")){
                    foundAndChange(box,nx,ny,alphabet);
                }
                //아닐경우 넘기기
            }
        }
    }
    private static String[][] crain(String[][] box, String alphabet){
        for(int i =0; i<box.length;i++){
            for(int j =0;j<box[i].length;j++){
                if(box[i][j].equals(alphabet)) {
                    box[i][j] = "0";
                }
            }
        }
        return box;
    }

}