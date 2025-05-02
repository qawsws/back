package chapter24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import chapter24.Ex12_Unit;

public class Ex13_ObjectOuputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex12_Unit unit1 = new Ex12_Unit("Marine");
		Ex12_Unit unit2 = new Ex12_Unit("Medic");
		try(ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream("Object.bin"))){
			oos.writeObject(unit1);
			oos.writeObject(unit2);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}








