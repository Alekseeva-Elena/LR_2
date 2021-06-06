package com.Plan;

//����� ������, ���������� �������� � ��������
public class Skills implements IKSA {
	private String name;
	private String description;
	
	// ����������� ��� ����������
	public Skills() {}
	
	// ����������� � �����������
	public Skills(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// ����� ���������� �� ���������
	@Override
	public void showKSA() {
		System.out.println(name);
		System.out.println(description);
	}
	
	// �����, ������������ ��������
	@Override
	public String getDescription() {
		return description;
	}
}
