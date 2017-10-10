package count;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MapFile {
    public int[][] load(){
        File f = new File("/home/peng/map.txt");
        FileInputStream fis = null;
        int[][] arr = new int[10][10];
        try {
            fis = new FileInputStream(f);
            byte[] b = new byte[(int)f.length()];
            fis.read(b);
            String bs = new String(b);
            System.out.println(bs);
            String[] ss = bs.split("\n");
            String[][] sss = new String[10][10];
            int i = 0;
            for (String s2:ss){
                String[] s3 = s2.split(" ");
                sss[i] = s3;
                i++;
            }
            /*for (String s1:ss){
                System.out.print(s1);
            }*/
            /*String[] s = bs.split(" ");
            for (String s1:s){
                System.out.print(s1);
            }*/

            //int d = 0;
            for(int k = 0;k<arr.length;k++){
                for(int j = 0; j < arr[k].length; j++){
                    arr[k][j] = Integer.valueOf(sss[k][j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return arr;
    }
}
