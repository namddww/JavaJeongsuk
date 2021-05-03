package ch07;

public class RepairableTest_Dasi {
	public static void main(String[] args) {
		
	}
}

interface Repairable {}

class Unit {
	int hitPoint;
	final int MAX_HP; // �ʱ�ȭ�� �ν��Ͻ� ������ �� �ѹ��� �ȴ�!
	Unit (int hp) {
		MAX_HP = hp;
	}
//	public String toString() {
//		return "";
//	}
}
class GroundUnit extends Unit {
	GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit {
	AirUnit (int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Dropship";
	}
}


class SCV extends AirUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit)r;
			while(u.hitPoint!=u.MAX_HP) {
				/* Unit�� HP�� ������Ų��. */
				u.hitPoint++;
			}
			System.out.println(u.toString() + "�� ������ �������ϴ�.");
		}
	}
}