package edu.usc.cs561;

import java.util.List;

public class Testbefore {
	
	private int[][] location; // location of baby
	private int row;
	public Testbefore(int row) {
		location = new int[row][row];
		// initial i=-1, so that when babynumber<row, no error in location[]
		for(int i=0;i<row;i++) location[i][0]=-1;
		this.row = row;
	}
	
	public boolean DFShelper(int tempRow, int babynumber, int[][] grid) {
		if(tempRow == row&&babynumber==0) {
			for(int i=0;i<row;i++) {
				System.out.println("location "+i+" no: "+location[i][0]);
			}
			return true;
		}else if(tempRow==row&&babynumber!=0){
			return false;
		}else{
			if(babynumber==0) {
				for(int i=0;i<row;i++) {
					System.out.println("location "+i+" : "+location[i][0]);
				}
				return true;
			}
            for (int i = 0; i < row; i++) {  
                location[tempRow][0] = i;  
                if(isPlace(tempRow)&&grid[tempRow][i]==0) {
                	if(DFShelper(tempRow + 1, babynumber-1,grid)) return true;  
                }  
            }  
         return false;
        }  
	}
	
    /** 
     * judge if have right answer
     * @param i 
     * @return 
     */  
    private boolean isPlace(int tempRow) {  
          
        for (int i = 0; i < tempRow; i++) {  
            if(Math.abs(tempRow - i) == Math.abs(location[tempRow][0] - location[i][0])  || location[tempRow][0] == location[i][0])  {  
                return false;  
            }  
        }  
        return true;  
    }  
    
    public int[][] getLocation() {
    	return this.location;
    }
    
    public static void main(String[] args) {
    	Testbefore tb = new Testbefore(8);
    	ReadFile rf = new ReadFile();
		
		List<String> list = rf.readFileByLines("allzero.txt");
		rf.dealWithData(list);
		boolean status = tb.DFShelper(0, rf.getBaby(), rf.getGrid());
    	System.out.println(status);
    	WriteFile wf = new WriteFile();
    	wf.WriteDataToFile(status, list,  tb.getLocation());
    }
}
