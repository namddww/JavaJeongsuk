package ch06;

class Document {
	static int count = 0;
	String name;
	
	Document() {
		this("�������" + count++);
	}
	
	Document(String name) {
		this.name = name;
		System.out.println("���� " + name +"��(��) �����Ǿ����ϴ�.");
	}
}
public class DocumentTest {
	public static void main(String[] args) {
		Document d1 = new Document();
		Document d2 = new Document("java.txt");
		Document d3 = new Document();
		Document d4 = new Document();
	}
}
