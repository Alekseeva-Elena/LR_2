package com.Plan;

import java.util.Scanner;
import java.util.ArrayList;

// Класс, в котором происходит 
// создание дисциплины
public class DisciplineBuilder {
	
	// Метод, создающий и возвращающий новую дисциплину
	public static Discipline createDiscipline() {
		ArrayList<IKSA> inKSA = new ArrayList<IKSA>();
		ArrayList<IKSA> outKSA = new ArrayList<IKSA>();
		ArrayList<Attributes> attr = new ArrayList<Attributes>();
		
		
		System.out.println("\n -----  Создание дисциплины -----");
		System.out.println("Введите название дисциплины:");
		Scanner console = new Scanner(System.in);
		String discipName = console.nextLine();
		
		// Ввод входных ЗУН
		System.out.println("Введите знания, умения и навыки, которые нужны для изучения этой дисциплины.");
		System.out.println("Знания:");
		String inDescription = console.nextLine();
		Knowledge inKnowledge = new Knowledge("Знания", inDescription);
		inKSA.add(inKnowledge);
		
		System.out.println("Умения:");
		inDescription = console.nextLine();
		inKSA.add(new Abilities("Умения", inDescription));
		
		System.out.println("Навыки:");
		inDescription = console.nextLine();
		inKSA.add(new Skills("Навыки", inDescription));
		
		// Ввод выходных ЗУН
		System.out.println("Введите знания, умения и навыки, которые будут получены после изучения этой дисциплины.");
		System.out.println("Знания:");
		inDescription = console.nextLine();
		outKSA.add(new Knowledge("Знания", inDescription));
		
		System.out.println("Умения:");
		inDescription = console.nextLine();
		outKSA.add(new Abilities("Умения", inDescription));
		
		System.out.println("Навыки:");
		inDescription = console.nextLine();
		outKSA.add(new Skills("Навыки", inDescription));
		
		// Запрос на ввод атрибутов
		System.out.println("\nХотите ввести атрибуты для этой дисциплины?");
		System.out.println("           yes             no");
		String inData = console.nextLine();
		while (!inData.equalsIgnoreCase("no")) {
			if (inData.equalsIgnoreCase("yes")) {
				System.out.println("Введите название атрибута:");
				String name = console.nextLine();
				
				System.out.println("Введите описание атрибута:");
				String description = console.nextLine();
				
				attr.add(new Attributes(name, description));
				
				System.out.println("\nХотите ещё ввести атрибуты для этой дисциплины?");
				System.out.println("           yes             no");
				inData = console.nextLine();
			}
			else {
				System.out.println("\nНеверная команда!");
				System.out.println("Хотите ещё ввести атрибуты для этой дисциплины?");
				System.out.println("           yes             no");
				inData = console.nextLine();
			}
		}
		
		// Создание и возврат новой дисциплины
		Discipline discipline = new Discipline(discipName, inKSA, outKSA, attr);
		return discipline;
	}
}
