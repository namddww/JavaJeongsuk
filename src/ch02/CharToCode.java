package ch02;

public class CharToCode {
	public static void main(String[] args) {
		char ch = 'A';		// char ch = 65;
		char ch1 = 65;		// char ch = 65;	
		int code = (int)ch;	// ch�� ����� ���� int Ÿ������ ��ȯ�Ͽ� �����Ѵ�.
		
		System.out.println(ch + ch1);
		
		System.out.printf("%c=%d(%#X)%n", ch, code, code);
		
		char hch = '��';
		char hch1 = 0xAC00;
		System.out.println(hch);
		System.out.println(hch1);
	}
}
