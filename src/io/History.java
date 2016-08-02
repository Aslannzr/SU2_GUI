package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class History {
	
	private String csvFileName;
	
	public ArrayList<String> Iteration                     	= new ArrayList<String>();
	public ArrayList<String> CLift						    = new ArrayList<String>();
	public ArrayList<String> CDrag							= new ArrayList<String>();
	public ArrayList<String> CSideForce   					= new ArrayList<String>();
	public ArrayList<String> CMx							= new ArrayList<String>();
	public ArrayList<String> CMy							= new ArrayList<String>();
	public ArrayList<String> CMz							= new ArrayList<String>();
	public ArrayList<String> CFx							= new ArrayList<String>();
	public ArrayList<String> CFy							= new ArrayList<String>();
	public ArrayList<String> CFz							= new ArrayList<String>();
	public ArrayList<String> CL_CD							= new ArrayList<String>();
	public ArrayList<String> Res_Flow0						= new ArrayList<String>();
	public ArrayList<String> Res_Flow1						= new ArrayList<String>();
	public ArrayList<String> Res_Flow2						= new ArrayList<String>();
	public ArrayList<String> Res_Flow3						= new ArrayList<String>();
	public ArrayList<String> Res_Flow4						= new ArrayList<String>();
	public ArrayList<String> Linear_Solver_Iterations		= new ArrayList<String>();
	public ArrayList<String> CFL_Number						= new ArrayList<String>();
	public ArrayList<String> Time							= new ArrayList<String>();
	
	
	public History(String csvFileName) throws FileNotFoundException{
		
		this.csvFileName = csvFileName;
		
		BufferedReader br = null;
		String line;
		
		try{
			br = new BufferedReader(new FileReader(csvFileName));
			int curLine = 0;
			outerloop:
			while ((line = br.readLine()) != null){
				
				curLine++;
				//not zero-indexed because it's easier this way
				if ( curLine < 4 ) continue outerloop;
				
				String[] iteration = line.split(", ");
				Iteration					.add(iteration[0]);
				CLift						.add(iteration[1]);
				CDrag						.add(iteration[2]);
				CSideForce					.add(iteration[3]);
				CMx							.add(iteration[4]);
				CMy							.add(iteration[5]);
				CMz							.add(iteration[6]);
				CFx							.add(iteration[7]);
				CFy							.add(iteration[8]);
				CFz							.add(iteration[9]);
				CL_CD						.add(iteration[10]);
				Res_Flow0					.add(iteration[11]);
				Res_Flow1					.add(iteration[12]);
				Res_Flow2					.add(iteration[13]);
				Res_Flow3					.add(iteration[14]);
				Res_Flow4					.add(iteration[15]);
				Linear_Solver_Iterations	.add(iteration[16]);
				CFL_Number					.add(iteration[17]);
				Time						.add(iteration[18]);
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void hisError(){
		JFrame frame = new JFrame("File Not Found");
		JOptionPane.showMessageDialog(frame,
				"Could not find " + csvFileName + "!\n"
				+ "SU2 may not have executed properly.",
				"Could not find " + csvFileName,
				JOptionPane.ERROR_MESSAGE);
	}
	
}
