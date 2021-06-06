package com.Plan;
import java.util.ArrayList;

// Класс для управления компоновкой
class CompoundDisciplines implements Disciplines {
	private ArrayList<Disciplines> disciplines = new ArrayList<Disciplines>();
	
	// Добавление компонента
	@Override
    public void add(Disciplines disc) {
    	disciplines.add(disc);
    }

	// Удаление компонента
    @Override
    public void remove(Disciplines disc) {
    	disciplines.remove(disc);
    }
    
    // Вывод информации о компонентах
    @Override
    public void discPrint() {
        for (Disciplines disc : disciplines) {
        	disc.discPrint();
        }
    }

    // Метод, возвращающий размер списка дисциплин
	public int getSize() {
		return disciplines.size();
	}

	// Метод, возвращающий список дисциплин
	public ArrayList<Disciplines> getArray() {
		return disciplines;
	}
	
}
