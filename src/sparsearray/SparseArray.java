package sparsearray;

/**
 * @author Brenna    3407137458@qq.com  13408937760
 * @Title:
 * @Package
 * @Description:稀疏数组
 * @date 2020/6/1618:45
 */
public class SparseArray {
    public static void main(String[] args) {
//        创建一个原始的二维数组 11*11
//        0  表示没有旗子  1  表示黑棋子   2  表示白棋子
        int cheseArr1[][] = new int[11][11];
        cheseArr1[1][2] = 1;
        cheseArr1[2][3] = 2;
        cheseArr1[3][4]=1;
//        输出原始的二维数组
        System.out.println("原始的二维数组：");
        for (int[] row : cheseArr1) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
//        将二维数组转换为稀疏数组思路
//        1、先获取有效数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (cheseArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        //遍历二维数组  转为稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (cheseArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = cheseArr1[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }

//        稀疏数组恢复为二维数组
//      遍历稀疏数组第一行  确定 二维数组的行和列
        int[][] cheseArr2 =new int[sparseArr[0][0]][sparseArr[0][1]];

//        遍历稀疏数组，将有效值赋值给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
           cheseArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];

        }

        System.out.println("恢复后的二维数组:");
        for (int[] row : cheseArr2) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
    }
}
