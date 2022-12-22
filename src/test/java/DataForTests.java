import org.testng.annotations.DataProvider;

public class DataForTests {

	
	//This is a new class for the data provider functions. 
	//This will be extended in the DataDrivenExamples class for inheritance.
	@DataProvider(name = "DataForPost")
	public Object [][] dataForPost(){
	
	/* 	Here, the number of rows and columns are specified in the object. 
	 * This is used to create multiple users at once.
	Object[][] data = new Object [2][3];
		
		data[0][0] = "Paul";
		data[0][1] = "Pogba";
		data[0][2] = 2;
	
		data[1][0] = "Ronaldo";
		data[1][1] = "Nazario";
		data[1][2] = 1;
		
		return data;
		*/
	//this is another way to go about it without having to specify the rows and columns. 
	//Useful for large volumes of data.
		
		return new Object[][] {
		
			{"Paul", "Pogba", 2},
			{"Ronaldo", "Nazario", 1}			
		};
	}
	//To delete multiple users at once
	@DataProvider(name = "DeleteData")
	public Object[] dataForDelete() {
		
		return new Object[] {
		
				7,8,9
		};
	}
}
