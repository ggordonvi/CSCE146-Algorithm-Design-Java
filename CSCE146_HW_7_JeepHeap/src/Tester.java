
public class Tester {
	
	public static void main(String[] args)
	{
		final int size = 15;
		JeepHeap heap = new JeepHeap();
		heap.addJeep(new Jeep("Jeep1",1200.0,540));
		heap.addJeep(new Jeep("Jeep2",1400.0,480));
		heap.addJeep(new Jeep("Jeep3",1350.0,500));
		heap.addJeep(new Jeep("Jeep4",1460.0,450));
		heap.addJeep(new Jeep("Jeep5",1300.0,510));
		heap.addJeep(new Jeep("Jeep6",1700.0,380));
		heap.addJeep(new Jeep("Jeep7",1000.0,780));
		heap.addJeep(new Jeep("Jeep8",1150.0,700));
		heap.addJeep(new Jeep("Jeep9",1640.0,490));
		heap.addJeep(new Jeep("Jeep10",1280.0,600));
		heap.addJeep(new Jeep("Jeep11",1050.0,670));
		heap.addJeep(new Jeep("Jeep12",1450.0,620));
		heap.addJeep(new Jeep("Jeep13",1600.0,580));
		heap.addJeep(new Jeep("Jeep14",1110.0,740));
		heap.addJeep(new Jeep("Jeep15",1240.0,680));
		
		System.out.println("Jeep Roll Call");
		heap.jeepRollCall();
		
		System.out.println("\nRemoving 5 jeeps and printing roll call again...");
		heap.removeJeep();
		heap.removeJeep();
		heap.removeJeep();
		heap.removeJeep();
		heap.removeJeep();
		
		heap.jeepRollCall();
		
		System.out.println("\nJeep heap sorting...");
		heap.jeepHeapSort(heap);
		
	}

}
