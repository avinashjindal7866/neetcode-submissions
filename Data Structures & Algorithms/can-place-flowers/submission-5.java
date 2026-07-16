class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result = n;

        if(flowerbed.length == 1){
            if(flowerbed[0] == 0){
                result--;
                return result <= 0 ? true : false;
            }else{
                return result == 0 ? true : false;
            }
        }

        for(int i=0;i<flowerbed.length;i++){
            if(result == 0){
                return true;
            }

            if(flowerbed[i] == 1){
                continue;
            }else{
                if(i==0){
                   if(flowerbed[i+1]==0) {
                        result--;
                        flowerbed[i] = 1;
                   }
                }else if(i==(flowerbed.length-1)){
                    if(flowerbed[i-1]==0) {
                        result--;
                        flowerbed[i] = 1;
                   }
                }else{
                    System.out.println(result+" " + i);
                   if(flowerbed[i+1]==0 && flowerbed[i-1]==0) {
                        result--;
                        flowerbed[i] = 1;
                   } 
                }
            }
        }
        // System.out.println(result);
        if(result == 0){
            return true;
        }else{
            return false;
        }
    }
}