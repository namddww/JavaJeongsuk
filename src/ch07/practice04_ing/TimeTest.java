package ch07.practice04_ing;

public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time();
		System.out.println(t);
		t.getHour();
		t.setHour(2);
		t.setMinute(12);
		t.setSecond(100);
		t.setSecond(53);
		System.out.println(t);
//		System.out.println(t.second); // 접근제한자
		System.out.println(t.getHour());
	}
}

class Time {
	private int hour;
	private int minute;
	private int second;
	
	int getHour() { return hour; }
	int getMinute() { return minute; }
	int getSecond() { return second; }
	
	void setHour(int hour) {
		if(hour<0 || hour>23) {return;}
		this.hour = hour;
	}
	void setMinute(int minute) {
		if(minute<0 || minute>59) {return;}
		this.minute = minute;
	}
	void setSecond(int second) {
		if(second<0 || second>59) {return;}
		this.second = second;
	}
	public String toString() {
		return hour + ":" + minute + ":" + second; 
	}
}