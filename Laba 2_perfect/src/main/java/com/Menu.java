package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Plan.*;

import java.util.Scanner;

// �������� �����, � ������� ���������� ������ ������
public class Menu {
	
	@Autowired
	public static AcademicPlan plan;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
		plan = context.getBean("plan", AcademicPlan.class);
		
        
		// ����������� ���� �� ������
		System.out.println("\n������� ���� �� ��������� ������: ");
		System.out.println("create - ������� ������� ����");
		System.out.println("quit - ����� �� ���������");
		
		Scanner console = new Scanner(System.in);
		String inputData = console.nextLine();

		// ���� �� ������� ������� "quit"
		// ��������� ���� ���������� �������
		while (!inputData.equalsIgnoreCase("quit")) {
			if (inputData.equalsIgnoreCase("create")) {
				plan = PlanBuilder.createPlan();
				break;
			}
			else { // ��������� � ������������ �������
				System.out.println("\n�������� �������!");
				System.out.println("������� ���� �� ��������� ������: ");
		   		System.out.println("create - ������� ������� ����");
		    	System.out.println("quit - ����� �� ���������");
		    	inputData = console.nextLine();
			}
		}
		
		// ���� ���� ������,
		// �� ��������� ���� ��������� �������
		if (plan.countDiscipline() != 0) {
				plan.printPlan();
				System.out.println("\n������� ���� �� ��������� ������: ");
				System.out.println("info - ������� ���������� � �����-���� ����������");
			    System.out.println("group - ������� ��������������� ����������");
			    System.out.println("quit - ����� �� ���������");
			    inputData = console.nextLine();
				
			    // ���� �� ������� ������� "quit"
				// ��������� ���� ���������� �������
				while (!inputData.equalsIgnoreCase("quit")) {
					
					// ����� ���������� �� ������������ ����������
		   			if (inputData.equalsIgnoreCase("info")) {
						System.out.println("\n������� �������� ����������: ");
						inputData = console.nextLine();
						if (plan.checkDiscipline(inputData)) {
							plan.infoDiscipline(inputData);

							System.out.println("\n������� ���� �� ��������� ������: ");
							System.out.println("info - ������� ���������� � �����-���� ����������");
							System.out.println("group - ������� ��������������� ����������");
					    	System.out.println("quit - ����� �� ���������");
					    	inputData = console.nextLine();
		   				}
						else { // ��������� � ������������ �������� ����������
							System.out.println("������� ���� �� �������� ������ ����������");
							System.out.println("\n������� ���� �� ��������� ������: ");
							System.out.println("info - ������� ���������� � �����-���� ����������");
							System.out.println("group - ������� ��������������� ����������");
					    	System.out.println("quit - ����� �� ���������");
					    	inputData = console.nextLine();
						}
					}
		   			// ����� ��������� ���������
		   			else if (inputData.equalsIgnoreCase("group")) {
						System.out.println("\n������� �������� ����������: ");
						inputData = console.nextLine();
						if (plan.checkDiscipline(inputData)) {
							plan.GroupDisc(inputData);
							
							System.out.println("\n������� ���� �� ��������� ������: ");
							System.out.println("info - ������� ���������� � �����-���� ����������");
							System.out.println("group - ������� ��������������� ����������");
					    	System.out.println("quit - ����� �� ���������");
					    	inputData = console.nextLine();
		   				}
						else { // ��������� � ������������ �������� ����������
							System.out.println("������� ���� �� �������� ������ ����������");
							System.out.println("\n������� ���� �� ��������� ������: ");
							System.out.println("info - ������� ���������� � �����-���� ����������");
							System.out.println("group - ������� ��������������� ����������");
					    	System.out.println("quit - ����� �� ���������");
					    	inputData = console.nextLine();
						}
					}
					else { // ��������� � ������������ �������
						System.out.println("\n�������� �������!");
						System.out.println("������� ���� �� ��������� ������: ");
						System.out.println("info - ������� ���������� � �����-���� ����������");
					    System.out.println("quit - ����� �� ���������");
		    			inputData = console.nextLine();
					}
				}
		}
		else {
			System.out.println("�� �� ������� ����������");
		}

		System.out.println("\n���������� ������ ���������");
		console.close();
	}
}
