package Sobolevskiy6group;

public class Triangle {
    Dot A;
    Dot B;
    Dot C;
    Triangle(Dot A, Dot B, Dot C) {
       try {
           this.A = A;
           this.B = B;
           this.C = C;
        if (isExists(A,B,C)){
            throw new Exception();
        }
       } catch (Exception e){
           System.out.println("Triangle isn't exist");
        }

    }

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
      try {
          this.A = new Dot(x1, y1);
          this.B = new Dot(x2, y2);
          this.C = new Dot(x3, y3);
          if (isExists(A, B, C)){
              throw new Exception();
          }
      } catch(Exception e){
          System.out.println("Triangle isn't exist");
      }
    }

    public boolean isExists(Dot A, Dot B, Dot C){
        if (Math.abs(getDistance(A,B) - getDistance(B,C)) < getDistance(A,C) || Math.abs(getDistance(A,C) - getDistance(B,C)) < getDistance(A,B) || Math.abs(getDistance(A,C) - getDistance(A,B)) < getDistance(B,C)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }

    private double getDistance(Dot first, Dot second) {
        double firstSide = Math.abs(first.getX() - second.getX());
        double secondSide = Math.abs(first.getY() - second.getY());
        double hypotenuse = Math.sqrt(firstSide * firstSide + secondSide * secondSide);
        return hypotenuse;
    }

    public double getPerimeter() {
        double AB = getDistance(A, B);
        double BC = getDistance(B, C);
        double AC = getDistance(A, C);
        double perimeter = AB + BC + AC;
        return perimeter;
    }

    public double getArea() {
        double AB = getDistance(A, B);
        double BC = getDistance(B, C);
        double AC = getDistance(A, C);
        double p = getPerimeter() / 2;
        double area = Math.sqrt(p * (p - AB) * (p - BC) * (p - AC));
        return area;
    }

    public int typeOfTheTriangle() {
        double AB = getDistance(A, B);
        double BC = getDistance(B, C);
        double AC = getDistance(A, C);
        int variant = 0;
        if (AB == AC && AB == BC) {
            //System.out.println("Equilateral");
            variant = 1;
        }
        else if (AB == AC && AB != BC || AB == BC && AB != AC) {
            //System.out.println("Isosceles");
            variant = 2;
            if (isRectangular()){
                //System.out.println("Rectangular");
                variant = 5;
            }

        } else if (isRectangular()){
            //System.out.println("Rectangular");
            variant = 3;
        }
        else {
            //System.out.println("Arbitrary");
            variant = 4;
        }
        return variant;
    }

    private Dot getVector(Dot first, Dot second) {
        Dot vector = new Dot(first.getX() - second.getX(), first.getX() - second.getY());
        return vector;
    }

    private boolean isRectangular() {
        double multiplyABxBC = getVector(A, B).getX() * getVector(B, C).getX() + getVector(A, B).getY() * getVector(B, C).getY();
        double multiplyACxAB = getVector(A, C).getX() * getVector(A, B).getX() + getVector(A, C).getY() * getVector(A, B).getY();
        double multiplyACxBC = getVector(A, C).getX() * getVector(B, C).getX() + getVector(A, C).getY() + getVector(B, C). getY();

        if (multiplyABxBC == 0 || multiplyACxBC == 0 || multiplyACxAB == 0) {
            return true;
        }
        return false;
    }
}
