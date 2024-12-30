package amazon;

import google.Triple;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-question/5297905/CHIME-SDE-Interview
//Given a list of mines represented as 3-tuples (x, y, radius of explosion) - write a program which takes this input and returns the most destructive mine.
//Input: [][]float64{{-3,3,3}, {-1,2,3}, {1,8,4}, {3,1,2}, {-2,-2,3.5}, {1,1,2}, {-1,1,1}, {3,3,1}}
//Expected Output: []float64{-2,-2,3.5}


public class ChimeSdeInterview {

//    private List<AwsTriple> testCase() {
//        List<AwsTriple> data = new ArrayList<>();
//        data.add(new AwsTriple(-3, 3, 3));
//        data.add(new AwsTriple(-1, 2, 3));
//        data.add( new AwsTriple(1, 8, 4));
//        data.add(new AwsTriple(3 , 1, 2));
//        data.add(new AwsTriple(-2, -2, 3.5));
//        data.add(new AwsTriple(1, 1, 2));
//        data.add(new AwsTriple(-1, 1, 1));
//        data.add(new AwsTriple(3, 3, 1));
//        return data;
//    }
//
//    private void testCas2() {
//        AwsTriple val1 = new AwsTriple(-3, 3, 3);
//        AwsTriple val2 = new AwsTriple(-1, 2, 3);
//        AwsTriple val3 = new AwsTriple(1, 8, 4);
//        AwsTriple val4 = new AwsTriple(3 , 1, 2);
//        AwsTriple val5 = new AwsTriple(-2, -2, 3.5);
//        AwsTriple val6 = new AwsTriple(1, 1, 2);
//        AwsTriple val7 = new AwsTriple(-1, 1, 1);
//        AwsTriple val8 = new AwsTriple(3, 3, 1);
//    }

//    public static void main(String[] args) {
//        ChimeSdeInterview program = new ChimeSdeInterview();
//        AwsTriple mine = program.getDestructive(program.testCase());
//
//        if (mine == null) {
//            System.out.println("Not found mine");
//        } else {
//            System.out.println(mine);
//        }
//    }
//
//
//    private AwsTriple getDestructive(List<AwsTriple> data) {
//        if (data == null) {
//            return null;
//        }
//
//        AwsTriple result = null;
//
//        if (data.size() == 1) {
//            return data.get(0);
//        }
//
//        for (AwsTriple val: data) {
//            AwsTriple resultDfs = dfs(val);
//            if (resultDfs != null) {
//                replaceMine(result, resultDfs);
//            }
//        }
//        return result;
//    }
////√(xb - xa)2 + (yb - ya)2
//    private void replaceMine(AwsTriple result, AwsTriple resultDfs) {
//        if (result == null) {
//            result = resultDfs;
//        } else {
//            if (resultDfs.x) {
//
//            }
//        }
//    }
//
//    class AwsTriple {
//        int x;
//        int y;
//        double radius;
//
//        public AwsTriple(int x, int y, double radius) {
//            this.x = x;
//            this.y = y;
//            this.radius = radius;
//        }
//
//        @Override
//        public String toString() {
//            return "AwsTriple{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    ", radius=" + radius +
//                    '}';
//        }
//    }
}
