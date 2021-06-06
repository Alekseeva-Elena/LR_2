package com.Plan;

// Класс Умения, содержащий название и описание
public class Abilities implements IKSA {
	private String name;
	private String description;
	
	// Конструктор без параметров
	public Abilities() {}
	
	// Конструктор с параметрами
	public Abilities(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// Вывод информации об умениях
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
