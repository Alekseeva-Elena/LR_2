package com.Plan;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

// Класс Дисциплина, содержащий название, 
// списки входных и выходных ЗУН и список атрибутов
public class Discipline implements Disciplines {
	private String name;
	ArrayList<IKSA> inKSA = new ArrayList<IKSA>();
	ArrayList<IKSA> outKSA = new ArrayList<IKSA>();
	ArrayList<Attributes> attr = new ArrayList<Attributes>();
	
	@Override
	public void add(Disciplines disc){
        throw new UnsupportedOperationException("Операция не поддерживается"); 
    }
	
	@Override
    public void remove(Disciplines disc){
        throw new UnsupportedOperationException("Операция не поддерживается"); 
    }
	
	@Override
	public void discPrint() {
		System.out.println(name);
	}
	
	// Конструктор без параметров
	public Discipline() {
		super();
	}
	
	// Конструктор с одним параметром
	public Discipline(String name) {
		super();
		this.name = name;
	}
	
	// Конструктор с параметрами
	@Autowired
	public Discipline(String name, ArrayList<IKSA> inKSA, ArrayList<IKSA> outKSA, ArrayList<Attributes> attr) {
		super();
		this.name = name;
		this.inKSA = inKSA;
		this.outKSA = outKSA;
		this.attr = attr;
	}
	
	// Метод, возвращающий название дисциплины
	public String getName() {
		return this.name;
	}
	
	// Вывод информации о данной дисциплине
	public void getInfo() {
		System.out.println("\n --- Дисциплина " + name + " ---");
		System.out.println("Знания, умения и навыки, требуемые для этой дисциплины:");
		for (int i = 0; i < inKSA.size(); i++) {
			System.out.print((i+1) + ". "); inKSA.get(i).showKSA();
		}
		
		System.out.println("Знания, умения и навыки, получаемые на этой дисциплины:");
		for (int i = 0; i < outKSA.size(); i++) {
			System.out.print((i+1) + ". "); outKSA.get(i).showKSA();
		}
		
		if (attr.size() != 0) {
			System.out.println("\nДополнительные сведения:");
			for (int i = 0; i < attr.size(); i++) {
			System.out.print((i+1) + ". "); attr.get(i).showKSA();
		    }
		}
	}
	
	// Проверка, есть ли дисциплины, связанные с данной
	public boolean checkGroup(Discipline discipline) {
		for (int i = 0; i < outKSA.size(); i++) {
			if (name != discipline.name) {
				if (outKSA.get(i).getDescription().equalsIgnoreCase(discipline.inKSA.get(i).getDescription())) {
					return true;
				}
			}
		}
		return false;
	}
}
