package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Plan.*;

import java.util.Scanner;

// Основной класс, в котором происходит запрос команд
public class Menu {
	
	@Autowired
	public static AcademicPlan plan;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
		plan = context.getBean("plan", AcademicPlan.class);
		
        
		// Запрашиваем одну из команд
		System.out.println("\nВведите одну из следующих команд: ");
		System.out.println("create - создать учебный план");
		System.out.println("quit - выйти из программы");
		
		Scanner console = new Scanner(System.in);
		String inputData = console.nextLine();

		// Пока не введена команда "quit"
		// ожидается ввод правильной команды
		while (!inputData.equalsIgnoreCase("quit")) {
			if (inputData.equalsIgnoreCase("create")) {
				plan = PlanBuilder.createPlan();
				break;
			}
			else { // Сообщение о неправильной команде
				System.out.println("\nНеверная команда!");
				System.out.println("Введите одну из следующих команд: ");
		   		System.out.println("create - создать учебный план");
		    	System.out.println("quit - выйти из программы");
		    	inputData = console.nextLine();
			}
		}
		
		// Если план создан,
		// то оживается ввод следующих комманд
		if (plan.countDiscipline() != 0) {
				plan.printPlan();
				System.out.println("\nВведите одну из следующих команд: ");
				System.out.println("info - вывести информацию о какой-либо дисциплине");
			    System.out.println("group - вывести взаимосвязанные дисциплины");
			    System.out.println("quit - выйти из программы");
			    inputData = console.nextLine();
				
			    // Пока не введена команда "quit"
				// ожидается ввод правильной команды
				while (!inputData.equalsIgnoreCase("quit")) {
					
					// Вывод информации об определенной дисциплине
		   			if (inputData.equalsIgnoreCase("info")) {
						System.out.println("\nВведите название дисциплины: ");
						inputData = console.nextLine();
						if (plan.checkDiscipline(inputData)) {
							plan.infoDiscipline(inputData);

							System.out.println("\nВведите одну из следующих команд: ");
							System.out.println("info - вывести информацию о какой-либо дисциплине");
							System.out.println("group - вывести взаимосвязанные дисциплины");
					    	System.out.println("quit - выйти из программы");
					    	inputData = console.nextLine();
		   				}
						else { // Сообщение о неправильном названии дисциплины
							System.out.println("Учебный план не содержит данной дисциплины");
							System.out.println("\nВведите одну из следующих команд: ");
							System.out.println("info - вывести информацию о какой-либо дисциплине");
							System.out.println("group - вывести взаимосвязанные дисциплины");
					    	System.out.println("quit - выйти из программы");
					    	inputData = console.nextLine();
						}
					}
		   			// Вывод связанных дисциплин
		   			else if (inputData.equalsIgnoreCase("group")) {
						System.out.println("\nВведите название дисциплины: ");
						inputData = console.nextLine();
						if (plan.checkDiscipline(inputData)) {
							plan.GroupDisc(inputData);
							
							System.out.println("\nВведите одну из следующих команд: ");
							System.out.println("info - вывести информацию о какой-либо дисциплине");
							System.out.println("group - вывести взаимосвязанные дисциплины");
					    	System.out.println("quit - выйти из программы");
					    	inputData = console.nextLine();
		   				}
						else { // Сообщение о неправильном названии дисциплины
							System.out.println("Учебный план не содержит данной дисциплины");
							System.out.println("\nВведите одну из следующих команд: ");
							System.out.println("info - вывести информацию о какой-либо дисциплине");
							System.out.println("group - вывести взаимосвязанные дисциплины");
					    	System.out.println("quit - выйти из программы");
					    	inputData = console.nextLine();
						}
					}
					else { // Сообщение о неправильной команде
						System.out.println("\nНеверная команда!");
						System.out.println("Введите одну из следующих команд: ");
						System.out.println("info - вывести информацию о какой-либо дисциплине");
					    System.out.println("quit - выйти из программы");
		    			inputData = console.nextLine();
					}
				}
		}
		else {
			System.out.println("Вы не создали дисциплины");
		}

		System.out.println("\nЗавершение работы программы");
		console.close();
	}
}
