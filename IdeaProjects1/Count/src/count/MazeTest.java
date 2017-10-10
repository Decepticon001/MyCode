package count;
import java.util.Stack;

class Step{
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//横坐标
        this.y = y;//纵坐标
        this.d = d;//方向
    }
}

public class MazeTest {

    public static void main(String[] args) {
        // 迷宫定义
        /*int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,1,0,1,1,1,1},
                {1,1,0,0,0,1,1,1,1,1},
                {1,0,1,0,0,0,0,0,1,1},
                {1,0,1,1,1,0,0,1,1,1},
                {1,1,0,0,1,1,0,0,0,1},
                {1,0,1,1,0,0,1,1,0,1},
                {1,1,1,1,1,1,1,1,1,1}};
        //行走的方向东南西北四个方向
        int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};*/
        //打印迷宫
        int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
        MapFile mf = new MapFile();
        int[][] maze = mf.load();
        for(int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                if(maze[i][j] == 1){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.print("\n");
        }
        Stack s = new Stack();
        Stack s1 = new Stack();
        int a = path(maze, move, s);
        Step aa = null;
        //反转堆栈里面的元素
        Stack s2 = new Stack();
        //将s堆栈里面的元素出栈，并且将元素压到s2的堆栈里面，这样就能保证是按行走的顺序输出坐标，否则是倒序输出的坐标
        while(!s.isEmpty()){
            Step step = (Step) s.pop();
            s2.push(step);
        }
        //打印出最后的坐标顺序
        StringBuffer aaa = new StringBuffer() ;
        while(!s2.isEmpty()){
            Step step = (Step) s2.pop();
            aaa.append("("+step.x+","+step.y+")"+"→");
        }
        String str = aaa.toString();
        System.out.print(str.substring(0, str.length()-1));
        System.out.println("\r");
        System.out.println("走过的路径为：");
        //打印出走过的所有坐标位置
        for(int i=0;i<=7;i++){
            for(int j=0;j<=9;j++){
                if(maze[i][j] == 1){
                    System.out.print("1");
                }else if(maze[i][j] == -1){
                    System.out.print("5");
                }else{
                    System.out.print("0");
                }
            }
            System.out.print("\n");
        }

    }
    //计算路径
    public static int path(int[][] maze,int[][] move,Stack s){
        Step temp = new Step(1,1,-1); //起点
        s.push(temp);
        while(!s.isEmpty()){
            temp = (Step) s.pop();
            int x = temp.x;
            int y = temp.y;
            int d = temp.d+1;
            //如果d大于4也就是说当前坐标的无路可走，只能后退一步，找后一坐标的下一个方向，在继续寻找坐标
            while(d<4){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 0){    //该点可达
                    temp = new Step(i,j,d); //到达新点
                    s.push(temp);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //到达新点，标志已经到达
                    if(x == 6 && y == 8){
                        return 1;  //到达出口，迷宫有路，返回1
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
        return 0;
    }

}
