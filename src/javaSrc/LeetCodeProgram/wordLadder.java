package javaSrc.LeetCodeProgram;

import java.util.HashSet;

/**
 * Created by Jim Wang on 2017/4/9.
 */
public class wordLadder {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");

        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(wordLadderBFS(start,end,dict));

    }

    /**
     * 使用广度优先遍历种。
     0）将start放入队列q1，初始count=0。
     1）当q1非空，逐个遍历q1中的单词，count++；一个队列count+1
     2）设q1中的单词为str，寻找其邻近单词s，如果s等于end返回count+1；
     否则将s放入队列q2中；
     3）将q1与q2交换，继续执行1）。
     其中代码修改了dict
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public static int wordLadderBFS(String start ,String end , HashSet<String> dict){

    return 0;

    }
}
