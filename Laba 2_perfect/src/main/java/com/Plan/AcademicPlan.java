package com.Plan;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

// ����� ������� ����, ���������� �������� � ������ ���������
@Component("plan")
public class AcademicPlan {
	private String name;
	private ArrayList<Discipline> disciplines;

	public AcademicPlan() {}
	
	// ����������� � �����������
	public AcademicPlan(String name, ArrayList<Discipline> discip) {
		this.name = name;
		this.disciplines = discip;
	}
	
	// ����� �������� �����
	public void printPlan() {
		System.out.println("\n -----  ������� ���� " + name + " -----");
		if (disciplines.size() != 0) {
			System.out.println("���� �������� ��������� ����������:");
			System.out.println(disciplines.get(0).getName());
			for(int i = 1; i < disciplines.size(); i++) {
				System.out.println(disciplines.get(i).getName());
			}
		}
		else {
			System.out.println("���� �� �������� ���������");
		}
	}
	
	// ��������, ���� �� �������� ����������
	// � ������� �����
	public boolean checkDiscipline(String name) {
		for (int i = 0; i < disciplines.size(); i++) {
			if (disciplines.get(i).getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	
	// ����� ���������� �� ����������� ����������
	public void infoDiscipline(String name) {
		for (int i = 0; i < disciplines.size(); i++) {
			if (disciplines.get(i).getName().equalsIgnoreCase(name)) {
				disciplines.get(i).getInfo();
				return;
			}
		}
	}
	
	// ����� ������� ������ ���������
	public int countDiscipline() {
		return disciplines.size();
	}
	
	// ����������� ��������� ���������
	public void GroupDisc(String name){
		DisciplinesEditor discip = new DisciplinesEditor();
		Discipline discipline = new Discipline();
		
		// ������� ������ ���������� � ������
		for (int i = 0; i < disciplines.size(); i++) {
			if (disciplines.get(i).getName().equalsIgnoreCase(name)) {
				discipline = disciplines.get(i);
			}
		}
		
		// ������� ��������� � ��� ����������
		for (int i = 0; i < disciplines.size(); i++) {
			if (discipline.checkGroup(disciplines.get(i))) {
				discip.load(disciplines.get(i));
			}
		}
		
		// ���� ���������� �������, ������� ��
		if (discip.getSize() != 0) {
			System.out.println("\n" + name + " ����������� ��� ��������:");
			discip.groupSelected(discip.getArray());
		}
		else { // ���� �� �������, �������� �� ����
			System.out.println("��� ���������, ��� ������� ����� �������� " + name);
		}
	}
}
