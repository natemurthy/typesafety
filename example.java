class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    public void setX(double x) { this.x = x; }

    public void setY(double y) { this.y = y; }

}

class Quadratic {

    private double a;
    private double b;
    private double c;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Point solve() {
        double radicand = Math.pow(b,2)-4*a*c;
        boolean isImaginary = radicand < 0;
        if (isImaginary)
            return "undefined";
        double radical = Math.sqrt(Math.pow(b,2)-4*a*c);
        double plus  = -b + radical;
        double minus = -b - radical;
        return new Point(plus/(2*a), minus/(2*a));	
     }
}

class Example {

    static Point swapCoords(Point p) {
        double x = p.getX();
        double y = p.getY();
        p.setX(y);
        p.setY(x);
        return p;
    }

    static double distance(Point p1, Point p2) {
        double deltaX = p1.getX() - p2.getX();
        double deltaY = p1.getY() - p2.getY();
        return Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
    }

    public static void main(String [] args) throws InterruptedException {
        Point pt1 = new Point(3,4);
        Point pt2 = new Point(9,0);
        System.out.println(distance(pt1,pt2));
        pt2 = swapCoords(pt2);

        Point p = new Point(5,6);
        Quadratic quad = new Quadratic(1,3,pt2.getX());

        int newX = 0;
        while (newX < 8) {
            System.out.println("Finding new x coord " + newX);
            Thread.sleep(100);
            newX++; 
        }
        p.setX(newX);

        System.out.println(p.getX() + " " + p.getY());
        Point q = swapCoords(p);
        System.out.println(q.getX() + " " + q.getY());

        boolean ready = false;
        while(!ready) {
            System.out.println("Waiting for services to be ready...");
            Thread.sleep(1000);
            ready = true;
        }

        p = quad.solve();
        System.out.println(distance(p,q));
    }
}
