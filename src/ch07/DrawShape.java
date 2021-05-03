package ch07;

public class DrawShape {
	public static void main(String[] args) {
//		Point a = new Point();
//		System.out.println(a.x);
//		System.out.println(a.y);
		
		Point[] p = {	new Point(100, 100),
						new Point(140, 50),
						new Point(200, 100)
		};
		
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150, 150), 50);
		Circle c1 = new Circle(new Point(150), 50);
		
		t.draw();
		c.draw();
		c1.draw();
	}
}

class Shape {
	String color = "black";
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}

class Point {
	int x;
	int y;
	
	Point(int x){
		this.x = x;
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Point() {
		this(0,0);
	}
	String getXY() {
		return "("+x+","+y+")";
	}
}

class Circle extends Shape {
	Point center;
	int r;
	Circle() {
	this(new Point(0, 0), 100);
	}
	
	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	void draw() {
		if (center.y == 0){
			System.out.printf("[center=(%d), r=%d, color=%s]%n",
					center.x, r, color);
		} else {
		System.out.printf("[center=(%d, %d), r=%d, color=%s]%n",
				center.x, center.y, r, color);
		}
	}
}

class Triangle extends Shape {
	Point[] p = new Point[3];
	
	Triangle(Point[] p) {
		this.p = p;
	}
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", 
				p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}
