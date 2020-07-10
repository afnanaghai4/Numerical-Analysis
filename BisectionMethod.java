/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisection.method;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class BisectionMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Scanner input= new Scanner(System.in);
        //int cnst1,cnst2,cnst3,num=0 ;
        float c=0,y=100,a,b;
        //double maxerror=100;
        //double err=0;
        System.out.println("Equation: f(x)= e^x - x^3 + 10");
        /*System.out.print("x^2= ");
        cnst1= input.nextInt();
        System.out.println("x= ");
        cnst2= input.nextInt();
        System.out.println("constant= ");
        cnst3= input.nextInt();
        
        a= -1.4f;
        b=-0.5f;
        
        //y= cnst1*num*num + cnst2*num + cnst3;
        //System.out.println(y);
        int n=0;
        while (Math.abs(y)>Math.pow(10,-2)) {
            c= (a+b)/2;
            System.out.println("c: " + c);
            y= cnst1*c*c + cnst2*c + cnst3;
            System.out.println("y: " + y);
            if (y==0){
                System.out.println("root is= " + c);
                System.exit(0);
            }
            else if (y<0){
                a=c;
            }
            else {
                b=c;
            }
            n++;
            
            System.out.println(n);
            //maxerror= Math.abs((b-a)/2);
        }
        System.out.println("root is= " + c);
        System.out.println(n);
        //System.out.println(maxerror);
        System.out.println(err);*/
        System.out.println("Bisection: ");
        bisection();
        System.out.println("Newton raphson: ");
        newtonRaph();
        System.out.println("Secant: ");
        secant();
        System.out.println("False position: ");
        falsePos();
                
        
    
        
    }
    public static void bisection(){
        double a= 2.7;
        double b= 3.7;
        double c= (a+b)/2;
        double fc= functionVal(c);
        
        if(fc==0){
            System.out.println("Root= " + c);
            return;
        }
        else if(fc>0){
            a=c;
        }
        else{
            b=c;
        }
        int iter=1;
        while(Math.abs(fc)>=Math.pow(10,-15)){
            c=(a+b)/2;
            fc=functionVal(c);
            if(fc==0){
                System.out.println("Root= " + c);
                System.out.println("Number of iterations=" + iter);
                return;
            }
            else if(fc>0){
                a=c;
            }
            else if(fc<0){
                b=c;
            }
            
            iter++;
        }
        
        System.out.println("Root= " + c);
        System.out.println("Number of iterations= " + iter);
    }
    
    public static void newtonRaph(){
        double x= 3.1;
        double fx= functionVal(x);
        double derfx= functionDerivVal(x);
        int iter=1;
        while(Math.abs(fx)>=Math.pow(10,-15)){
            x= x-(fx/derfx);
            fx= functionVal(x);
            derfx= functionDerivVal(x);
            iter++;
        }
        System.out.println("Root= " + x);
        System.out.println("Number of iterations= " + iter);
    }
    
    public static void secant(){
        double a= 2.7;
        double b= 3.7;
        double c= (a*functionVal(b)-b*functionVal(a))/(functionVal(b)-functionVal(a));
        double fc= functionVal(c);
        int iter=1;
        while(Math.abs(fc)>=Math.pow(10,-15)){
            a=b;
            b=c;
            c= (a*functionVal(b)-b*functionVal(a))/(functionVal(b)-functionVal(a));
            fc= functionVal(c);
            iter++;
        }
        System.out.println("Root= " + c);
        System.out.println("Number of iterations= " + iter);
        
    }
    
    public static void falsePos(){
        double a= 2.7;
        double b= 3.7;
        double c= (a*functionVal(b)-b*functionVal(a))/(functionVal(b)-functionVal(a));
        double fc= functionVal(c);
        if(fc==0){
            System.out.println("Root= " + c);
            return;
        }
        else if(fc>0){
            a=c;
        }
        else{
            b=c;
        }
        int iter=1;
        while(Math.abs(fc)>=Math.pow(10,-15)){
            
            c= (a*functionVal(b)-b*functionVal(a))/(functionVal(b)-functionVal(a));
            fc= functionVal(c);
            if(fc==0){
            System.out.println("Root= " + c);
                        System.out.println("Number of iterations= " + iter);

            return;
        }
        else if(fc>0){
            a=c;
        }
        else{
            b=c;
        }
            iter++;
        }
        System.out.println("Root= " + c);
        System.out.println("Number of iterations= " + iter);
        
    }
    
    public static double functionVal(double x){
        return Math.pow(Math.E, x)-Math.pow(x, 3)+10;
    }
    public static double functionDerivVal(double x){
        return Math.pow(Math.E,x)-3*Math.pow(x,2);
    }
    
}
