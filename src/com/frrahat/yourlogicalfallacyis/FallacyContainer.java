package com.frrahat.yourlogicalfallacyis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;

/**
 * @author Rahat
 * @since Dec 26, 2016
 */
public class FallacyContainer {
	
	private static ArrayList<Fallacy> fallacies;
	
	public static void loadList(Context context){
		fallacies=new ArrayList<Fallacy>();
		
		InputStream inStream=context.getResources().openRawResource(R.raw.logical_fallacies);
		BufferedReader reader=null;
		try
		{
			reader=new BufferedReader(new InputStreamReader(inStream));
			String text;
			int fieldsCovered=0;
			String fields[]=new String[4];
			while((text=reader.readLine())!=null)
			{
				if(text.startsWith("#"))
					continue;
				
				else{
					fields[fieldsCovered]=text;
					fieldsCovered++;
					if(fieldsCovered==4){
						fallacies.add(new Fallacy(fields[0],//name
										fields[1],//definition,
										fields[2],//source,
										fields[3]));//example
						
						fieldsCovered=0;
					}
				}	
			}
			
			reader.close();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
	
	public static ArrayList<Fallacy> getList(){
		return fallacies;
	}
	
	public static Fallacy getItemAt(int index){
		if(fallacies.size()<=index)
			return null;
		return fallacies.get(index);
	}
}
