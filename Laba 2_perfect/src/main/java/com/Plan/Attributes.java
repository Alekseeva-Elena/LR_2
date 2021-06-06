package com.Plan;

//Класс Атрибуты, содержащий название и описание
public class Attributes implements IKSA {
	private String name;
	private String description;
	
	// Конструктор без параметров
	public Attributes() {}
	
	// Конструктор с параметрами
	public Attributes(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// Вывод информации об атрибутах
	@Override
	public void showKSA() {
		System.out.println(name + ": " + description);
	}
	
	// Метод, возвращающий описание
	@Override
	public String getDescription() {
		return description;
	}
}
