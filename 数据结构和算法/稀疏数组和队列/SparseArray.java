package 稀疏数组和队列;

/**
 * 稀疏数组(Sparse Array)
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0 :表示没有棋子，1：表示黑子，2：表示篮子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        //查看原始的二维数组
        for(int[] arr : chessArr){
            for(int data : arr){
                System.out.print(data + " ");
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        //1.先遍历二维数组，得到非零数据的个数
        int sum = 0;
        for(int i = 0; i < chessArr.length; i++){
            for(int j = 0; j < chessArr[0].length; j++){
                if(chessArr[i][j] != 0){
                    sum++;
                }
            }
        }


        //2.创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;
        int count = 0;
        for(int i = 0; i < chessArr.length; i++){
            for(int j = 0; j < chessArr[0].length; j++){
                if(chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        // 输出稀疏数组
        for(int[] arr : sparseArr){
            for(int data : arr){
                System.out.print(data + " ");
            }
            System.out.println();
        }

    }
}
