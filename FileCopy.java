import java.util.*;
import java.io.*;

public class FileCopy {
	
	public static void main(String[] args) throws IOException{
	
		Scanner a = new Scanner(System.in);
                System.out.println("Enter the InputPath:");
		String inputPath=a.nextLine();
                System.out.println("Enter the OutputPath:");
		String outputPath=a.nextLine();
                System.out.println("Enter File Name:-");
		String fileName=a.nextLine();
                fileCopier(inputPath, outputPath, fileName);
		
		
		
	}
        static void fileCopier(String inputPath,String outputPath,String fileName) throws FileNotFoundException, IOException
        {
            
                    File inputFile=new File(inputPath+"\\"+fileName);
                    File outputFile=new File(outputPath+"\\"+fileName);
                    File temp=null;
                    FileReader readFile=null;
                    FileWriter writeFile=null;
			
			readFile = new FileReader(inputPath+"\\"+fileName);
					
			if(inputFile.exists()){
				if(outputFile.exists()){
			
					temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));
					
					if(temp.exists()){
						int j=2;
						int b;
						while(true){
							temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+j+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
							if(!temp.exists()){
								break;
							}
							j++;
						}
						writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+j+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
						while((b=readFile.read())!=-1){
							writeFile.write(b);
						}
						System.out.println("Successfully copied.");
					}else{
						int b;
						writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));
						while((b=readFile.read())!=-1){
							writeFile.write(b);
						}
						System.out.println("Successfully copied.");
					}
				}else{
					int b;
					writeFile = new FileWriter(outputPath+"\\"+fileName);
					while((b=readFile.read())!=-1){
						writeFile.write(b);
					}
					System.out.println("Successfully copied.");
				}
			}else{
				System.out.println("dosen't exists.");
			}
			
			readFile.close();
			writeFile.close();
		
        }
}

