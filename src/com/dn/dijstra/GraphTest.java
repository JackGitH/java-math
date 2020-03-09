package com.dn.dijstra;

import java.util.LinkedList;

/**
 * @ClassName GraphTest
 * @Description TODO
 * @Author 郭洪昌
 * @Date 2019/12/3 14:08
 * @Version 1.0
 *   图的深度优先遍历
 * 1 邻接矩阵构造图结构
 * 2 写出获取当前顶点的下一个邻接顶点位置的方法
 * 3 写出根据当前顶点以及现在的位置，获取下一个邻接顶点的方法，获取顶点的出度方法，入度方法
 * 4 由于图可能有断层，for循环所有顶点 深度优先遍历
 * 5 写深度优先遍历方法： 获取第一个节点的邻接顶点，标注为已遍历；获取到了邻接顶点，while该顶点没被遍历，则递归，否则该顶点以及位置遍历该顶点的邻接顶点
 *
 *   图的广度优先遍历（使用链表）
 * 1 邻接矩阵构造图结构
 * 2 写出获取当前顶点的下一个邻接顶点位置的方法
 * 3 写出根据当前顶点以及现在的位置，获取下一个邻接顶点的方法，获取顶点的出度方法，入度方法
 * 4 声明链表；放入第一个元素；while链表不为空，则remove第一个元素，getfirts邻接顶点，没被访问过，add进链表；继续根据顶点位置以及index遍历邻接顶点
 *
 *   图的最短路径prim算法
 * 1 构造邻接矩阵图
 * 2 声明两个数组，一个存储最小顶点集合，一个存储最小权值集合，最小值min 最小值id minid 权值合计 sum
 * 3 遍历第一个数组，把第一个顶点关系put
 * 4 遍历所有顶点集合，内部遍历第一个数组，找出最小值，遍历最小值顶点的所有关系，比较最小顶点集合里的权值，小的put代替
 * 5 累加所有权证得出最短路径
 */
public class GraphTest {
    private int vertexSize;//顶点数量

    public int getVertexSize() {
        return vertexSize;
    }

    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    public void setVertexSize(int vertexSize) {
        this.vertexSize = vertexSize;
    }

    private int [] vertexs;//顶点数组
    private int[][]  matrix;
    public int[][] getMatrix() {
        return matrix;
    }


    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    private static final int MAX_WEIGHT = 1000;
    private boolean [] isVisited;
    public GraphTest(int vertextSize){
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for(int i = 0;i<vertextSize;i++){
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }
    /**
     * 创建图的过程
     */
    public void createGraph(){
        int [] a1 = new int[]{0,1,5,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        int [] a2 = new int[]{1,0,3,7,5,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        int [] a3 = new int[]{5,3,0,MAX_WEIGHT,1,7,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        int [] a4 = new int[]{MAX_WEIGHT,7,MAX_WEIGHT,0,2,MAX_WEIGHT,3,MAX_WEIGHT,MAX_WEIGHT};
        int [] a5 = new int[]{MAX_WEIGHT,5,1,2,0,3,6,9,MAX_WEIGHT};
        int [] a6 = new int[]{MAX_WEIGHT,MAX_WEIGHT,7,MAX_WEIGHT,3,0,MAX_WEIGHT,5,MAX_WEIGHT};
        int [] a7 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,3,6,MAX_WEIGHT,0,2,7};
        int [] a8 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,9,5,2,0,4};
        int [] a9 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,7,4,0};

        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;
        matrix[3] = a4;
        matrix[4] = a5;
        matrix[5] = a6;
        matrix[6] = a7;
        matrix[7] = a8;
        matrix[8] = a9;
    }




    /**
     * 获取某个顶点的出度
     * @return
     */
    public int getOutDegree(int index){
        int degree = 0;
        for(int j=0;j<matrix[index].length;j++){
            if(matrix[index][j]>0 &&matrix[index][j]<MAX_WEIGHT ){
                degree++;
            }
        }
        return degree;
    }

    /**
     * 获取某个顶点的第一个邻接点
     */
    public int getFirstNeighbor(int index){
        for(int j=0;j<matrix[index].length;j++){
            if(matrix[index][j]>0 &&matrix[index][j]<MAX_WEIGHT ){
                return j;
            }
        }
        return -1;
    }


    /**
     * 根据前一个邻接点的下标来取得下一个邻接点
     * @param v 表示要找的顶点
     * @param index 表示该顶点相对于哪个邻接点去获取下一个邻接点
     */
    public int getNextNeighbor(int v,int index){
        for(int j=index+1;j<matrix[index].length;j++){
            if(matrix[index][j]>0 &&matrix[index][j]<MAX_WEIGHT ){
                return j;
            }
        }
        return -1;
    }


    /**
     * 图的深度优先遍历算法
     */
    private void depthFirstSearch(int i){
         isVisited[i] = true;
         int first  = getFirstNeighbor(i);
         while (first!=-1){
             if(!isVisited[first]){
                 System.out.println("访问到了："+i+"顶点");
                 depthFirstSearch(first);
             }else {
                 first = getNextNeighbor(i,first);
             }
         }
    }

    /**
     * 对外公开的深度优先遍历
     */

    public void depthFirstSearch(){
        isVisited = new boolean[vertexSize];
        for(int i=0;i<vertexSize;i++){
            if(!isVisited[i]){
                System.out.println("访问到了"+i+"顶点");
                depthFirstSearch(i);
            }
        }
        isVisited = new boolean[vertexSize];
    }

    public void broadFirstSearch() {
        isVisited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                broadFirstSearch(i);
            }
        }
    }


        /**
         * 实现广度优先遍历
         * @param i
         */
    private void broadFirstSearch(int i) {
        LinkedList<Integer> linkedList  = new LinkedList<>();
        linkedList.add(i);
        System.out.println("广度遍历到节点+"+'i');
        isVisited[i] = true;
        while(!linkedList.isEmpty()){
            Integer first  = (linkedList.removeFirst()).intValue();
             int n = getFirstNeighbor(first);
             while (n!=-1){
                 if(!isVisited[n]){
                     isVisited[n] = true;
                     System.out.println("广度遍历到节点"+'i');
                     linkedList.add(n);
                 }
                 n =getNextNeighbor(first,n);
             }
        }


    }



    /**
     * prim 普里姆算法
     */
    public void prim(){
        Integer [] minNode = new Integer[vertexSize];// 权重
        Integer [] minNode2 = new Integer[vertexSize]; /// 顶点
        int min =0,minId =0,sum = 0;
        for(int i=1;i<vertexSize;i++){
            minNode[i] =  matrix[0][i];
        }
        for(int i=1;i<vertexSize;i++){

            min = MAX_WEIGHT;
            for(int j=1;j<vertexSize;j++ ){
                if (minNode[j]>0 && minNode[j]<MAX_WEIGHT & minNode[j]<min){
                    min=minNode[j];
                    minId = j;
                }
            }
            sum+=min;
            System.out.println("");
            minNode[minId] = 0;
            for(int m=1;m<vertexSize;m++){
                if(minNode[m]!=0&&matrix[minId][m]<minNode[m]){
                    minNode[m] = matrix[minId][m];
                    minNode2[m] = minId;
                }
            }




        }


    }


    /**
     * 获取两个顶点之间的权值
     * @return
     */
    public int getWeight(int v1,int v2){
        int weight = matrix[v1][v2];
        return weight == 0?0:(weight == MAX_WEIGHT?-1:weight);
    }



    public static void main(String [] args){
        GraphTest graph = new GraphTest(9);

        int [] a1 = new int[]{0,10,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        int [] a2 = new int[]{10,0,18,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,MAX_WEIGHT,12};
        int [] a3 = new int[]{MAX_WEIGHT,MAX_WEIGHT,0,22,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,8};
        int [] a4 = new int[]{MAX_WEIGHT,MAX_WEIGHT,22,0,20,MAX_WEIGHT,MAX_WEIGHT,16,21};
        int [] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,20,0,26,MAX_WEIGHT,7,MAX_WEIGHT};
        int [] a6 = new int[]{11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,26,0,17,MAX_WEIGHT,MAX_WEIGHT};
        int [] a7 = new int[]{MAX_WEIGHT,16,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,17,0,19,MAX_WEIGHT};
        int [] a8 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,7,MAX_WEIGHT,19,0,MAX_WEIGHT};
        int [] a9 = new int[]{MAX_WEIGHT,12,8,21,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};

        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;
        graph.matrix[5] = a6;
        graph.matrix[6] = a7;
        graph.matrix[7] = a8;
        graph.matrix[8] = a9;

		int degree = graph.getOutDegree(4);
		System.out.println("vo的出度:"+degree);
		System.out.println("权值："+graph.getWeight(2,3));
		//graph.depthFirstSearch();
		graph.broadFirstSearch();
       // graph.prim();
    }



}
