package com.Plan;

//����� ��������, ���������� �������� � ��������
public class Attributes implements IKSA {
	private String name;
	private String description;
	
	// ����������� ��� ����������
	public Attributes() {}
	
	// ����������� � �����������
	public Attributes(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// ����� ���������� �� ���������
	@Override
	public void showKSA() {
		System.out.println(name + ": " + description);
	}
	
	// �����, ������������ ��������
	@Override
	public String getDescription() {
		return description;
	}
}
