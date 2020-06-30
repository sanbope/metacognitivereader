package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils
{
	public static String readFile(String url)
	{
		File file = new File(url);
		String text = "";
		
		if(file.exists())
		{
			FileReader fr;
			try
			{
				fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				
				while((line = br.readLine())!=null) {
					text += line+"\n";
				}
				
				br.close();
			} catch (IOException e)
			{
			}
		}
		
		return text;
	}
	
	public static String formatText(String text)
	{
		String questions[] = text.split("DIVPREGUNTAS");
		String items[];
		
		String uses = "var uses = [\n";
		String examples = "var examples = [\n";
		String corrections = "var corrections = [\n";
		String notes = "var notes = [\n";
		
		for(int i=0; i<questions.length; i++)
		{
			items = questions[i].split("#");
			
			if(items.length >= 4)
			{
				uses = formatEnters(items[0], uses);
				examples = formatEnters(items[1].replace("Example: ", ""), examples);
				corrections = formatEnters(items[2].replace("Correction: ", ""), corrections);
				notes = formatEnters(items[3].replace("Note: ", ""), notes);
			}
		}///home/sanbope/eclipse-workspace/personalProjects/MetacognitiveReader/syntactic2.txt
		
		examples += "];\n";
		uses += "];\n";
		corrections += "];\n";
		notes += "];\n";		
		
		return uses+"\n"+examples+"\n"+corrections+"\n"+notes;
	}
	
	private static String formatEnters(String nuevo, String text)
	{
		String items2[];
		String encerrador;
		if(nuevo.length() > 0)
		{
			encerrador = "'";
			items2 = nuevo.trim().split("\n");
			if(items2.length > 1) //Si tiene enters
			{
				for(int j=0; j<items2.length; j++)
				{
					encerrador = "'";
					if(items2[j].length() > 0)
					{
						if(items2[j].contains("'"))
						{
							encerrador = "\"";
						}
						text += encerrador+items2[j].trim()+"\\n"+encerrador+"+\n";
					}
				}
				text = text.substring(0, text.length()-3);
				text += encerrador+",\n";
			}else
			{
				if(nuevo.contains("'"))
				{
					encerrador = "\"";
				}
				text += encerrador+nuevo.trim()+encerrador+",\n";
			}
		}
		
		return text;
	}
}