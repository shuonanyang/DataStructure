//SparesArray
public class SparseArray {
    public static void main(String[] args){
        // Orginal chessarray
        System.out.println("This is orginal array");
        System.out.println("-----------------------");
        int[][] chessArray = new int[6][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        for(int[] row : chessArray){
            for(int data : row ){
                System.out.printf("%d ", data);
            }
            System.out.println();
        }
        System.out.println();
        //System.out.println(chessArray.length);
        //遍历原始二维数组，得到意义数据总数。
        int sum  = 0;
        for(int i = 0; i < chessArray.length; i++){

            for(int j = 0; j < chessArray[i].length; j++){
                if (chessArray[i][j] != 0) sum++;
            }
        }
        System.out.println("Total meaningful data :" + sum);

        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = sum;
        int count = 1;//count必须在外for循环外面，不然count作用域在for里面，每次进去都会是1，而不是改变后的值。
        for (int i = 0; i < chessArray.length; i++){
            //int count = 1;
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {

                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println("This is sparseArray");
        for(int[] row : sparseArray){
            for(int data : row){
                System.out.printf("%d ", data);
            }
            System.out.println();
        }
        System.out.println();

        //将稀疏数组恢复
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1; i < sparseArray.length; i++){
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for(int[] row : chessArray2){
            for(int data : row){
                System.out.printf("%d ", data);
            }
            System.out.println();
        }
    }
}