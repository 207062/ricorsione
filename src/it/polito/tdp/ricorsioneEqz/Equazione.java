package it.polito.tdp.ricorsioneEqz;

import java.util.ArrayList;
import java.util.List;

public class Equazione {
	private int conta=0;
	private int somma ;
    
    private int globale;
    private int arraySol[]={0,0,0,0,0};
    private List<int []> soluzioni ;
     
  public Equazione(int number){
	this.globale=number;
	this.somma=0 ;
	soluzioni=new ArrayList<int []>() ;
	//this.arraySol [] ={0,0,0,0,0};
  }
	public void recursive(int tentativi[],int parametri[],int level){
		if(level==parametri.length){
			if(somma==globale){
				int sol[] = {0,0,0,0,0} ;
				for(int i=0; i<tentativi.length; i++)
					sol[i]=tentativi[i] ;
				soluzioni.add(sol);
				
				 System.out.print("La soluzione è : ");

				 for(int i=0;i<tentativi.length;i++){
					 System.out.print(tentativi[i]+" ");
					 }
				 System.out.println();
			}		 
			else{
			 //System.out.println("La soluzione proposta non è valida");
			 return;
			}
		}
		else{
			int prova = 0 ;
		  while(somma+prova*parametri[level]<=globale){
			  
			  tentativi[level] = prova ;
			  somma+=prova*parametri[level] ;
			  recursive(tentativi, parametri, level+1);
			  somma-=prova*parametri[level] ;

			  
		    prova++ ;
		  }
		 }
	
	}

	
	
	
	public static void main(String[] args){
	 Equazione eqz = new Equazione(83);
	 int tentativi[]= {1,0,0,5,0};
	 int parametri[]={3,7,12,16,21};
	 
	 eqz.recursive(tentativi,parametri,0);
	 System.out.println();
		
	}

}







