package com.Plan;

//Класс Навыки, содержащий название и описание
public class Skills implements IKSA {
	private String name;
	private String description;
	
	// Конструктор без параметров
	public Skills() {}
	
	// Конструктор с параметрами
	public Skills(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// Вывод информации об атрибутах
	@Override
	public void showKSA() {
		System.out.println(name);
		System.out.println(description);
	}
	
	// Метод, возвращающий описание
	@Override
	public String getDescription() {
		return description;
	}
}
