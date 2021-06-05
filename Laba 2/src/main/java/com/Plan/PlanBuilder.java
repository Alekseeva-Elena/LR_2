package com.Plan;

import java.util.Scanner;
import java.util.ArrayList;

//Класс, в котором происходит 
//создание учебного плана
public class PlanBuilder{
	
	public static AcademicPlan createPlan() {
		String name;
		ArrayList<Discipline> disciplines =  new ArrayList<Discipline>();
		
		System.out.println("\n -----  Создание учебного плана -----");
		System.out.println("Введите название учебного плана: ");
		Scanner console = new Scanner(System.in);
		name = console.nextLine();
		
		// Запрос команд
		System.out.println("\nВведите одну из следующих команд: ");
		System.out.println("create - создать дисциплину");
		System.out.println("quit - завершить создание дисциплин");
		String inputData = console.nextLine();
		
		// Пока не введена команда "quit"
		// ожидается ввод правильной команды
		while (!inputData.equalsIgnoreCase("quit")) {
			// Создание учебного плана
			if (inputData.equalsIgnoreCase("create")) {
				disciplines.add(DisciplineBuilder.createDiscipline());
		    	System.out.println("\nВведите одну из следующих команд: ");
		    	System.out.println("create - создать дисциплину");
		    	System.out.println("quit - завершить создание дисциплин");
		    	inputData = console.nextLine();
			}
			else { // Сообщение о неправльной команде
				System.out.println("\nНеверная команда!");
				System.out.println("Введите одну из следующих команд: ");
		    	System.out.println("create - создать дисциплину");
		    	System.out.println("quit - завершить создание дисциплин");
				inputData = console.nextLine();
			}
		}
		
		System.out.println("Завершение создания дисциплин");
		return new AcademicPlan(name, disciplines);
	}
}
