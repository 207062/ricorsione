# ricorsione

package it.polito.tdp.ricorsioneEqz;


public class Equazione {
	private int conta=0;
    
    private int globale;
    private int arraySol[]={0,0,0,0,0};
    
  public Equazione(int number){
	this.globale=number;
	//this.arraySol [] ={0,0,0,0,0};
  }
	public void recursive(int tentativi[],int parametri[],int level){
	   int somma=0;
		if(level==parametri.length){
			if(somma==globale){
				 for(int i=0;i<arraySol.length;i++){
					 System.out.println("La soluzione è : "+arraySol[i]);
					 }
			}		 
			else{
			 System.out.println("La soluzione proposta non è valida");
			 return;
			}
		}
		else{
			 somma=somma+ tentativi[level]*parametri[level];
		  while(somma<=globale){
			  arraySol[level]=tentativi[level]; 
			 if(somma<globale)
			   recursive(tentativi,parametri,level+1);
			 
			 if (somma+arraySol[level]*parametri[level]==globale){
				 conta++;
			 }
			 if(somma+arraySol[level]*parametri[level]>globale){ // --> backtracking
				somma=somma-arraySol[level]*parametri[level];
			    arraySol[level]=0;  
			 }
		  }
		 }
	
	}

	
	
	
	public static void main(String[] args){
	 Equazione eqz = new Equazione(83);
	 int tentativi[]= {1,0,0,5,0};
	 int parametri[]={3,7,12,16,21};
	 
	 eqz.recursive(tentativi,parametri,0);
		
	}

}







