package com.Plan;

//Класс Знания, содержащий название и описание
public class Knowledge implements IKSA {
	private String name;
	private String description;
	
	// Конструктор без параметров
	public Knowledge() {}
	
	// Конструктор с параметрами
	public Knowledge(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// Вывод информации об знаниях
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
