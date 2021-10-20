import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFileParser {

	private String[] delimeters; 
	
	private String[] endOfCommand; 
	
	private String inputFile; 
	
	public InputFileParser(String[] delimeters, String[] endOfCommand, String inputFile)
	{
		this.delimeters = delimeters;
		this.endOfCommand = endOfCommand; 
		this.inputFile = inputFile; 
	}
	
	public InputFileParser(String delimeter,String endOfCommand, String inputFile)
	{
		this.delimeters = new String[] {delimeter}; 
		this.endOfCommand = new String[] {endOfCommand}; 
		
		this.inputFile = inputFile; 
	}
	
	public InputFileParser(String inputFile)
	{
		this(" ", "\n", inputFile);
	}
	
	public ArrayList<Command> createCommandList() throws FileNotFoundException
	{
		ArrayList<Command> commands = new ArrayList<Command>(); 
		
		File file = new File(inputFile);
		Scanner scan = new Scanner(file);
		
		
	}
}
