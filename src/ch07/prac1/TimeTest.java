package ch07.prac1;

public class TimeTest {
	public static void main(String[] args) {
		Time t1 = new Time();
		
		System.out.println(t1);
		System.out.println(t1.getHour());
		t1.setHour(3);
		System.out.println(t1);
		System.out.println(t1.getHour());
		t1.setMinute(15);
		System.out.println(t1);
		t1.setSecond(49);
		System.out.println(t1);
		t1.setSecond(79);
		System.out.println(t1);
	}
}

class Time {
	private int hour;
	private int minute;
	private int second;
	
	public int getHour() {return hour;}
	public int getMinute() {return minute;}
	public int getSecond() {return second;}
	
	public void setHour(int hour) {
		if(hour<0 || hour>23) {
			System.out.println("잘못 입력하셨습니다.-시");
			return;
		}
		this.hour = hour;
	}
	public void setMinute(int minute) {
		if(minute<0 || minute>59) {
			System.out.println("잘못 입력하셨습니다.-분");
			return;
		}
		this.minute = minute;
	}
	public void setSecond(int second) {
		if(second<0 || second>59) {
			System.out.println("잘못 입력하셨습니다.-초");
			return;
		}
		this.second = second;
	}
	public String toString() {
		return hour + ":" + minute + ":"+second;
	}
}