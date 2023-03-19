import java.util.Scanner;

public class Minesweeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int row = sc.nextInt();
            int column = sc.nextInt();
            int mines = sc.nextInt();
            String matrix[][] = new String[row][column];

            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                   matrix[j][k] = ".";
                }
            }

            int r = 0;
            int r1 = row-1;
            int c = 0;
            int c1 = column -1;
            while(mines > 0){
               
                for(int k = 0; k < column; k++){
                  
                    if(mines<=0){
                        break;
                    }
                    if(matrix[r][k] == "*"){
                        mines++;
                       }
                    matrix[r][k] = "*";
                    mines--;
                   
                }r++; 
                
                for(int k = 0; k < column; k++){
                   
                    if(mines<=0){
                        break;
                    }
                    if(matrix[r1][k] == "*"){
                        mines++;
                       }
                    matrix[r1][k] = "*";
                    mines--;
                   
                }r1--;
               
                for(int k = 0 ; k < row; k++){
                   
                    if(mines<=0){
                        break;
                    }
                    if(matrix[k][c] == "*"){
                        mines++;
                       }
                    matrix[k][c] = "*";
                   
                    mines--;
                   
                }
                c++;
               
                for(int k =0; k < row; k++){
                   
                    if(mines<=0){
                        break;
                    }
                    if(matrix[k][c1] == "*"){
                        mines++;
                       }
                    matrix[k][c1] = "*";
                    
                    mines--;
                   
                }
                c1--;


            }
            for(int k = 1; k < row-1; k++){
                for(int j = 1; j < column-1; j++){
                    if(matrix[k][j] != "*"){
                        if(matrix[k-1][j-1] != "*" && matrix[k][j-1] != "*" && matrix[k+1][j-1] != "*" && matrix[k-1][j] != "*" && matrix[k+1][j] != "*" && matrix[k+1][j+1] != "*" && matrix[k][j+1] != "*" && matrix[k-1][j+1] != "*" ){
                            matrix[k][j] = "C";
                            break;
                        }
                    }
                }
                
            }
            boolean flag = true;
            int count = 0;
            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                    if(matrix[j][k] == "C"){
                            if(count >=1){
                                matrix[j][k] = ".";
                            }
                            flag = false;
                            count++;
                        }
                }
            }
        

            if(flag){
                System.out.println("Impossible");
            }else{
                for(int y = 0; y < row; y++){
                    for(int z = 0; z < column; z++){
                        System.out.print(matrix[y][z]);
                    }
                    System.out.println();
            }
            
        }
    }

    }
}
