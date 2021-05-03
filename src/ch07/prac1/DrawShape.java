package ch07.prac1;

public class DrawShape {
	public static void main(String[] args) {
		Point p = new Point(1,1);
		Circle c = new Circle(p,1);
		c.draw();
		c.color = "red";
		c.draw();
	}
}

class Point {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Point() {
		this(0, 0);
	}
}

class Shape {
	Point p = new Point();
	String color = "black";
	void draw() {
		System.out.printf("색: %s \n", color);
	}
}

class Circle extends Shape{
	int r;
	Circle(Point p, int r) {
		this.p = p;
		this.r = r;
	}
	Circle() {
		this(new Point(0,0),0);
	}
	@Override
	void draw() {
		System.out.printf("색:%s, 위치[%s:%s], 반지름:%s \n", color, this.p.x, this.p.y,  this.r);
	}
}

class Triangle {
	Point[] ps = new Point[3];
	Triangle(Point[] ps) {
		this.ps = ps;
	}
	Triangle() {
		this(new Point[3]);
	}
}
