package challenges.hackerrank.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
    
    static class Priorities {
    	
    	PriorityQueue<Student> queue = new PriorityQueue<>(Comparator.comparingDouble(Student::getCGPA).reversed()
    																 .thenComparing(Student::getName)
    																 .thenComparingInt(Student::getID)
    																 );

		public List<Student> getStudents(List<String> events) {
			events.stream().forEach(s ->{
				if(s.contains("ENTER")) {
					String[] st = s.split(" ");
					Student student = new Student(Integer.parseInt(st[3]), st[1], Double.parseDouble(st[2]));
					queue.offer(student);
				} else {
					queue.poll();
				}
			});
			
			List<Student> students = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				students.add(queue.poll());
			}
			return students;
		}
    	
    }
    
    static class Student {
    	int id;
    	String name;
    	double cgpa;
		
    	public Student(int id, String name, double cgpa) {
			this.id = id;
			this.name = name;
			this.cgpa = cgpa;
		}
    	
    	public int getID() {
			return id;
		}
    	
    	public String getName() {
			return name;
		}
    	
    	public double getCGPA() {
			return cgpa;
		}
    }
}