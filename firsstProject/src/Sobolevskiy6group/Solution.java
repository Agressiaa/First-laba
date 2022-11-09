package Sobolevskiy6group;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counterEquilateral = 0;
        int counterIsosceles = 0;
        int counterRectangular = 0;
        int counterArbitrary = 0;
        int counterIsoscelesAndRectangular = 0;
        List<Triangle> triangles = new ArrayList<>();
        System.out.println("How many triangles do you want? ");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("x1: ");
            int x1 = sc.nextInt();
            System.out.println("y1: ");
            int y1 = sc.nextInt();
            System.out.println("x2: ");
            int x2 = sc.nextInt();
            System.out.println("y2: ");
            int y2 = sc.nextInt();
            System.out.println("x3: ");
            int x3 = sc.nextInt();
            System.out.println("y3: ");
            int y3 = sc.nextInt();
            Dot A = new Dot(x1,y1);
            Dot B = new Dot(x2,y2);
            Dot C = new Dot(x3,y3);
            Triangle tr = new Triangle(A,B,C);
            triangles.add(tr);
            System.out.println(tr.toString());
            System.out.println("Perimeter: " + tr.getPerimeter());
            System.out.println("Area: " + tr.getArea());
            if (tr.typeOfTheTriangle() == 1) {
                counterEquilateral++;
            }
            if (tr.typeOfTheTriangle() == 2) {
                counterIsosceles++;
            }
            if (tr.typeOfTheTriangle() == 3) {
                counterRectangular++;
            }
            if (tr.typeOfTheTriangle() == 4) {
                counterArbitrary++;
            }
           if (tr.typeOfTheTriangle() == 5) {
                counterIsoscelesAndRectangular++;
            }
        }
        System.out.println("Amount of Equilateral: " + counterEquilateral);
        System.out.println("Amount of Isosceles: " + counterIsosceles);
        System.out.println("Amount of Rectangular: " + counterRectangular);
        System.out.println("Amount of Arbitrary: " + counterArbitrary);
        System.out.println("Amount of Isosceles and Rectangular: " + counterIsoscelesAndRectangular);
        Triangle max = triangles.get(0);
        double maxArea = triangles.get(0).getArea();
        Triangle min = triangles.get(0);
        double minArea = triangles.get(0).getArea();

        for (int i = 0; i < triangles.size(); i++){
            if (maxArea < triangles.get(i).getArea()){
                max = triangles.get(i);
                maxArea =  triangles.get(i).getArea();
            }
        }

        for (int i = 0; i < triangles.size(); i++){
            if (minArea > triangles.get(i).getArea()){
                min = triangles.get(i);
                minArea =  triangles.get(i).getArea();
            }
        }
        System.out.println("Minimal area have the " + min  + " with area " + minArea);
        System.out.println("Maximum area have the " + max + " with area " + maxArea);
    }
}
