package com.dn.dijstra;

import java.util.Stack;

/**
 * @ClassName a
 * @Description TODO
 * @Author 郭洪昌
 * @Date 2019/12/3 11:29
 * @Version 1.0
 * 图的拓扑排序（使用栈）
 * 1 邻接表构造图结构
 * 2 查找边顶点第一个位置 放入栈
 * 3 弹出栈中第一个元素并计数，遍历第一个元素的所有临街顶点，每遍历到一个，则这个顶点in--，如果in--==0，则push入栈
 * 4 判断计数数量是否大于总顶点数量
 */
public class DnGraphTopologicTest {
   private int size;
   private bbNode[] topoList;

    public DnGraphTopologicTest(int size) {
        this.size = size;
    }


    private void createTopo(){
        DnGraphTopologicTest dnGraphTopologicTest  = new DnGraphTopologicTest(size);
        bbNode node0 = new bbNode(0,"v0");
        bbNode node1 = new bbNode(0,"v1");
        bbNode node2 = new bbNode(2,"v2");
        bbNode node3 = new bbNode(0,"v3");
        bbNode node4 = new bbNode(2,"v4");
        bbNode node5 = new bbNode(3,"v5");
        bbNode node6 = new bbNode(1,"v6");
        bbNode node7 = new bbNode(2,"v7");
        bbNode node8 = new bbNode(2,"v8");
        bbNode node9 = new bbNode(1,"v9");
        bbNode node10 = new bbNode(1,"v10");
        bbNode node11 = new bbNode(2,"v11");
        bbNode node12 = new bbNode(1,"v12");
        bbNode node13 = new bbNode(2,"v13");
        topoList  = new bbNode[size];
        topoList[0] = node0;
        topoList[1] =node1;
        topoList[2] =node2;
        topoList[3] =node3;
        topoList[4] =node4;
        topoList[5] =node5;
        topoList[6] =node6;
        topoList[7] =node7;
        topoList[8] =node8;
        topoList[9] =node9;
        topoList[10] =node10;
        topoList[11] =node11;
        topoList[12] =node12;
        topoList[13] =node13;
        node0.next = new ljNode(11);node0.next.next = new ljNode(5);node0.next.next.next = new ljNode(4);
        node1.next = new ljNode(8);node1.next.next = new ljNode(4);node1.next.next.next = new ljNode(2);
        node2.next = new ljNode(9);node2.next.next = new ljNode(6);node2.next.next.next = new ljNode(5);
        node3.next = new ljNode(13);node3.next.next = new ljNode(2);
        node4.next = new ljNode(7);
        node5.next = new ljNode(12);node5.next.next = new ljNode(8);
        node6.next = new ljNode(5);
        node8.next = new ljNode(7);
        node9.next = new ljNode(11);node9.next.next = new ljNode(10);
        node10.next = new ljNode(13);
        node12.next = new ljNode(9);
   }

   private  void topoSort() throws Exception {
        int count =0;
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<topoList.length;i++){
           if(topoList[i].in==0){
               stack.push(i);
           }
       }
       while (!stack.isEmpty()){
           Integer pop = stack.pop();
           System.out.println("弹出节点"+pop);
           count++;
           for(ljNode liNode  =topoList[pop].next;liNode!=null;liNode =  liNode.next ){
               Integer k = liNode.index;
               if (--topoList[k].in  ==0){
                   stack.push(k);
               }
           }

       }
       if (count<size){
           throw new Exception("完犊子了，拓扑排序失败");
       }
   }


   public static void  main(String[] args){
       DnGraphTopologicTest dnGraphTopologicTest = new DnGraphTopologicTest(14);
       dnGraphTopologicTest.createTopo();
       try {
           dnGraphTopologicTest.topoSort();
       } catch (Exception e) {
           e.printStackTrace();
       }

   }

    // 线顶点
   class ljNode{
       private int index;
       private ljNode next;
       private int weight;

        public ljNode(int index) {
            this.index = index;
        }

        public int getIndex() {
           return index;
       }

       public void setIndex(int index) {
           this.index = index;
       }

       public ljNode getNext() {
           return next;
       }

       public void setNext(ljNode next) {
           this.next = next;
       }
   }

   // 边顶点
   class bbNode{
       private int in;
       private ljNode next;
       private String data;

       public bbNode(int in, String data) {
           this.in = in;
           this.data = data;
       }

       public ljNode getNext() {
           return next;
       }

       public void setNext(ljNode next) {
           this.next = next;
       }
   }

}
