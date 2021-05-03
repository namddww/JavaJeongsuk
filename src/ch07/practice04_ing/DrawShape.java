package ch07.practice04_ing;

public class DrawShape {
	public static void main(String[] args) {
	Shape s = new Shape();
	System.out.println(s);
	Circle c = new Circle();
	System.out.println(c);
	Triangle t = new Triangle();
	System.out.println(t);

	Triangle tt = new Triangle("삼사각형","빨강", new Point());
	System.out.println(tt);

	}
}

class Point {
	int x;
	int y;
	Point() {
		this(0, 0);
	}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Shape {
	String name;
	String color;
	Point p;
	Shape() {
		this("도형", "색", new Point());
	}
	Shape(String name, String color, Point p) {
		this.name = name;
		this.color = color;
		this.p = p;
	}
	public String toString() {
		return name + ", " + color + ", " + p.x + ", " + p.y;
	}
}

class Circle extends Shape {
	static final double pi = Math.PI;
	int r;
	Circle() {
		this("원", "없음", new Point(), 0);
	}
	Circle(String name, String color, Point p, int r) {
		this.name = name;
		this.color = color;
		this.p = p;
		this.r = r;
	}
	
}

class Triangle extends Shape{
	static final int m = 2;
	Triangle() {
		this("삼각형", "없음", new Point());
	}
	Triangle(String name, String color, Point p) {
		this.name = name;
		this.color = color;
		this.p = p;
	}
}

