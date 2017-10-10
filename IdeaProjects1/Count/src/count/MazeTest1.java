package count;



import java.awt.*;
import java.util.*;


public class MazeTest1 {
    public static void main(String[] args) {
        MapFile mf = new MapFile();
        int[][] maze = mf.load();

        Queue<Point> qe = new LinkedList<Point>();

        Map<String,Integer> map = Mapssss.find(maze);
        int x = map.get("2_y");
        int y = map.get("2_x");
        int a = map.get("3_y");
        int b = map.get("3_x");
        Point pa = new Point(x,y);
        Point pb = new Point(a,b);
        qe.add(pa);
        int[][] arr = getPath(maze,qe,pa,pb);
        for (int[] s:arr){
            for(int f : s){
                System.out.print(f);
            }
            System.out.println();
        }

    }
    public static int[][] getPath(int[][] maze,Queue<Point> qe,Point pa,Point pb){

            if(qe.contains(pb)){
                return maze;
            }else {
                Point p = qe.poll();
                maze[p.x][p.y] = 5;
                if(maze[p.x][p.y+1] == 0){
                    pa=new Point(p.x,p.y+1);
                    qe.add(p);
                }
                if (maze[p.x][p.y-1] == 0){
                    pa = new Point(p.x,p.y-1);
                    qe.add(p);
                }
                if (maze[p.x+1][p.y] == 0){
                    pa = new Point(p.x+1,p.y);
                    qe.add(p);
                }
                if (maze[p.x-1][p.y] == 0){
                    pa = new Point(p.x-1,p.y);
                    qe.add(p);
                }
                getPath(maze,qe,pa,pb);
            }
            //Point p1 = new Point(a, b);
       /* if (qe.contains(p1)){
            return maze;
        }else {
            if(maze[x][y+1] == 0){
                p=new Point(x,y+1);
                qe.add(p);
            }
            if (maze[x][y-1] == 0){
                p = new Point(x,y-1);
                qe.add(p);
            }
            if (maze[x+1][y] == 0){
                p = new Point(x+1,y);
                qe.add(p);
            }
            if (maze[x-1][y] == 0){
                p = new Point(x-1,y);
                qe.add(p);
            }
            qe.poll();
            Point p2 = qe.poll();
            maze[p2.x][p2.y] = 5;
            getPath(maze,qe,p2.x,p2.y,a,b);
        }*/
        return maze;
    }
}
