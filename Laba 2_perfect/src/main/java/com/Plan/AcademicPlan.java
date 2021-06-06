package com.Plan;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

// Класс Учебный план, содержащий название и список дисциплин
@Component("plan")
public class AcademicPlan {
	private String name;
	private ArrayList<Discipline> disciplines;

	public AcademicPlan() {}
	
	// Конструктор с параметрами
	public AcademicPlan(String name, ArrayList<Discipline> discip) {
		this.name = name;
		this.disciplines = discip;
	}
	
	// Вывод учебного плана
	public void printPlan() {
		System.out.println("\n -----  Учебный план " + name + " -----");
		if (disciplines.size() != 0) {
			System.out.println("План содержит следующие дисциплины:");
			System.out.println(disciplines.get(0).getName());
			for(int i = 1; i < disciplines.size(); i++) {
				System.out.println(disciplines.get(i).getName());
			}
		}
		else {
			System.out.println("План не содержит дисциплин");
		}
	}
	
	// Проверка, есть ли введённая дисциплина
	// в учебном плане
	public boolean checkDiscipline(String name) {
		for (int i = 0; i < disciplines.size(); i++) {
			if (disciplines.get(i).getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	
	// Вывод информации об определённой дисциплине
	public void infoDiscipline(String name) {
		for (int i = 0; i < disciplines.size(); i++) {
			if (disciplines.get(i).getName().equalsIgnoreCase(name)) {
				disciplines.get(i).getInfo();
				return;
			}
		}
	}
	
	// Вывод размера списка дисциплин
	public int countDiscipline() {
		return disciplines.size();
	}
	
	// Группировка связанных дисциплин
	public void GroupDisc(String name){
		DisciplinesEditor discip = new DisciplinesEditor();
		Discipline discipline = new Discipline();
		
		// Находим нужную дисциплину в списке
		for (int i = 0; i < disciplines.size(); i++) {
			if (disciplines.get(i).getName().equalsIgnoreCase(name)) {
				discipline = disciplines.get(i);
			}
		}
		
		// Находим связанные с ней дисциплины
		for (int i = 0; i < disciplines.size(); i++) {
			if (discipline.checkGroup(disciplines.get(i))) {
				discip.load(disciplines.get(i));
			}
		}
		
		// Если дисциплины найдены, выводим их
		if (discip.getSize() != 0) {
			System.out.println("\n" + name + " потребуется для изучения:");
			discip.groupSelected(discip.getArray());
		}
		else { // Если не найдены, сообщаем об этом
			System.out.println("Нет дисциплин, для которых нужно изучение " + name);
		}
	}
}
