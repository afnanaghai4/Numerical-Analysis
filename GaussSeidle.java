/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussseidle;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class GaussSeidle {

    /**
     * @param args the command line arguments
     */
    static Scanner input= new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner input= new Scanner(System.in);
        System.out.println("Enter coefficient matrix A:");
        System.out.print("Order of matrix= ");
        int order= input.nextInt();
        double [][] matA= insertMatA(order);
        System.out.println("Enter matrix b: ");
        
        double [] matB= insertMatB(order);
        printMat(matA);
        printMatB(matB);
        double[]matX= new double[order];
        for(int i=0; i<order; i++){
            matX[i]=0;
        }
        
        double norm= norm(matA,matX,matB);
        
        int iteration=0;
        
        while(norm>=Math.pow(10, -15)){
            iteration++;
        matX= gaussSeidle(matA,matB,matX);
        norm= norm(matA,matX,matB);
        
        }
        
        System.out.println("solution: ");
        printMatB(matX);
        System.out.println("iterations= " + iteration);
        
    }
    public static double[] gaussSeidle(double[][]matA, double[]matB, double[]matX){
        for(int i=0;i<matA.length;i++){
            double sum=0;
            for(int j=0; j<matA.length;j++){
                if(j!=i){
                    sum= sum+ (matA[i][j]*matX[j]);
                }
            }
            matX[i]=(matB[i]-sum)/matA[i][i];
        }
        return matX;
    }
    public static double norm(double[][] matA, double[]matX, double[]matB){
        double[]product=new double[matA.length];
        
        for (int i = 0; i < matA.length; i++)
         {
            double sum=0;
            for (int j = 0; j < matA.length; j++)
            {  
               sum= sum + matA[i][j]*matX[j]; 
 
            }
            product[i]=sum;
         }
        double sum=0;
        for(int i=0; i<product.length;i++){
            product[i]= product[i]-matB[i];
            sum= sum+ (product[i]*product[i]);
            
        }
        double norm= Math.sqrt(sum);
        return norm;
    }

    public static double[] insertMatB(int n){
        //Scanner input= new Scanner(System.in);
        double[]mat= new double[n];
        /*for(int i=0; i<n; i++){
        int j=1;
        System.out.print("Enter element (" + (i+1)+ "," + (j) + ")= ");
        mat[i]= input.nextInt();
        
        }*/
        mat[0]=9;
        mat[1]=12;
        mat[2]=18;
        return mat;
    }
    public static double[][] insertMatA(int n){
        //Scanner input= new Scanner(System.in);
        double[][]mat= new double[n][n];
        /*for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
        System.out.print("Enter element (" + (i+1)+ "," + (j+1) + ")= ");
        mat[i][j]= input.nextInt();
        }
        }*/
        mat[0][0]=8;
        mat[0][1]=3;
        mat[0][2]=4;
        mat[1][0]=9;
        mat[1][1]=10;
        mat[1][2]=1;
        mat[2][0]=2;
        mat[2][1]=3;
        mat[2][2]=9;
        return mat;
    }
    public static void printMat(double[][]mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                System.out.print(mat[i][j] + "\t");
                
            }
            System.out.println("");
        }
    }
    public static void printMatB(double[]mat){
        for(int i=0; i<mat.length; i++){
            
                System.out.println(mat[i]);
                
            
            
        }
    }
    
}
