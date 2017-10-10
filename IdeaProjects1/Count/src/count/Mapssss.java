package count;

import java.util.HashMap;
import java.util.Map;

public class Mapssss {
    public static void main(String[] args) {
        MapFile m = new MapFile();
        int ar[][] = m.load();
       /* for(int[] as:ar){
            for (int i:as){
                System.out.print(i);
            }
            System.out.println();
        }*/
        /*int[] a1 = {1,1,1,1,1,1,1,1,1,0};
        int[] a2 = {0,1,1,0,0,0,2,1,1,1};
        int[] a3 = {0,1,0,0,1,0,1,1,1,1};
        int[] a4 = {1,1,0,1,1,1,1,0,1,0};
        int[] a5 = {1,1,0,0,0,0,0,1,1,0};
        int[] a6 = {1,1,1,1,1,0,1,1,1,0};
        int[] a7 = {1,1,1,1,1,0,1,1,1,0};
        int[] a8 = {1,1,1,1,1,0,0,1,1,0};
        int[] a9 = {1,1,1,1,1,1,3,1,1,0};
        int[] a0 = {1,1,1,1,1,1,1,1,1,0};
        int[][] arr = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a0};*/
        Map<String,Integer> map = find(ar);
        /*int x_2 = map.get("2_x");
        int y_2 = map.get("2_y");
        System.out.println(x_2+" " + y_2);*/
        //int i = arr[0][5];
        //System.out.println(i);
        //System.out.println(map.get("2_x"));
        //System.out.println(map.get("2_y"));
        //System.out.println(map.get("3_x"));
        //System.out.println(map.get("3_y"));
        //int a = arr[map.get("2_y")][map.get("2_x")];
       // System.out.println("11111111");
        int x=map.get("2_x");
        int y=map.get("2_y");
        /*for(int[] as:arr){
            for (int i:as){
                System.out.print(i);
            }
            System.out.println();
        }*/
        int[][] a = getout(ar,x,y);
        a[map.get("2_y")][map.get("2_x")] = 2;
        for(int[] as:a){
            for (int i:as){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static Map<String,Integer> find(int[][] arr){
        Map<String,Integer> map = new HashMap<String, Integer>();
        int y = 0;
        int x;
        for(int[] a:arr){
            y++;
            x=0;
            for(int i:a){
                x++;
                if(i == 2){
                    map.put("2_x",new Integer(x-1));
                    map.put("2_y",new Integer(y-1));
                }
                if(i == 3){
                    map.put("3_x",new Integer(x-1));
                    map.put("3_y",new Integer(y-1));
                }
            }
        }
        return map;
    }
    public static int[][] getout(int arr[][],int x,int y){

        while(arr[y][x] != 3){
            if (arr[y][x+1] == 3){
                arr[y][x]=-1;
                x++;
            }else if(arr[y+1][x] == 3){
                arr[y][x]=-1;
                y++;
            }else if(arr[y][x-1]==3){
                arr[y][x]=-1;
                x--;
            }else if (arr[y-1][x]==3) {
                arr[y][x] = -1;
                y--;
            }
           if (arr[y][x+1] == 0){
               arr[y][x]=5;
               x++;
           }else if(arr[y+1][x] == 0){
               arr[y][x]=5;
               y++;
           }else if(arr[y][x-1]==0){
               arr[y][x]=5;
               x--;
           }else if (arr[y-1][x]==0){
               arr[y][x]=5;
               y--;
           }else{
               if (arr[y][x+1] == 5){
                   arr[y][x]=-2;
                   x++;
               }else if(arr[y+1][x] == 5){
                   arr[y][x]=-2;
                   y++;
               }else if(arr[y][x-1]==5){
                   arr[y][x]=-2;
                   x--;
               }else if (arr[y-1][x]==5) {
                   arr[y][x] = -2;
                   y--;
               }
           }
            if (((arr[y][x+1] == -2)||(arr[y][x+1] == 1))&&((arr[y][x-1] == -2)||(arr[y][x-1] == 1))&&
                    ((arr[y+1][x] == -2)||(arr[y+1][x] == 1))&&((arr[y-1][x] == -2)||(arr[y-1][x] == 1))){
                System.out.println("没有出路");
                for (int i = 0 ;i < arr.length ;i++){
                    for (int j = 0;j<arr[i].length;j++){
                        if (arr[i][j] == -2){
                            arr[i][j]=0;
                        }
                    }
                }
                return arr;
            }
            /*for (int i = 0 ;i < arr.length ;i++){
                for (int j = 0;j<arr[i].length;j++){
                    if (!(arr[i][j] == 0)){
                        System.out.println("没有出口");
                        return arr;
                    }
                }
            }*/

        }
        for (int i = 0 ;i < arr.length ;i++){
            for (int j = 0;j<arr[i].length;j++){
                if (arr[i][j] == -2){
                    arr[i][j]=0;
                }
                if(arr[i][j]==-1){
                    arr[i][j]=5;
                }
            }
        }
        return arr;
    }

}
