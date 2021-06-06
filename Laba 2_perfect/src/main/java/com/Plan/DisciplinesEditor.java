package com.Plan;

import java.util.ArrayList;

// Класс, где происходит управление
// группировкой дисциплин
public class DisciplinesEditor {
	private CompoundDisciplines all = new CompoundDisciplines();

	// Конструктор без параметров
	public DisciplinesEditor() {
		// TODO Auto-generated constructor stub
	}

	// Добавление дисциплины в список
	public void load(Disciplines disc) {
		all.add(disc);
    }

	// Группировка выбранных дисциплин
	public void groupSelected(ArrayList<Disciplines> disc) {
		CompoundDisciplines group = new CompoundDisciplines();
		for (int i = 0; i < disc.size(); i++) {
			group.add(disc.get(i));
			all.remove(disc.get(i));
        }
		all.add(group);
		all.discPrint();
	}

	// Функция, возвращаюся размер списка дисциплин
	public int getSize() {
		return all.getSize();
	}

	// Функция, возвращаюся список дисциплин
	public ArrayList<Disciplines> getArray() {
		return all.getArray();
	}
}
