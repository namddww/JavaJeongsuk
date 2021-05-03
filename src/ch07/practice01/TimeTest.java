package ch07.practice01;

public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time(12, 32, 44);
		System.out.println(t);
		
		t.setMinute(t.getMinute()+1);
		System.out.println(t);
		
	}
}

class Time {
	private int hour, minute, second;
	
	Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public int getHour() {return hour;}
	public int getMinute() {return minute;}
	public int getSecond() {return second;}
	
	public void setHour(int hour) {
		if(hour<0 || hour>23) {
			return;
		} 
		this.hour = hour;
	}
	public void setMinute(int minute) {
		if(minute<0 || minute>59) {
			return;
		} 
		this.minute = minute;
	}
	public void setSecond(int second) {
		if(second<0 || second>59) {
			return;
		} 
		this.second = second;
	}
	
	public String toString() {
		return hour+":"+minute+":"+second;
	}
}
