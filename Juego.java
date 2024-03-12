package examen;

import java.util.Arrays;
import java.util.Scanner;

public class Juego {
	private static boolean correcto(String letra) {
		// Metodo para que solo sea correcto cuando el usuario introduzca J,Z o X
		if(letra.matches("[J,Z,X]{1}")) {
			return true;
		}else {
			return false;
		}
	}
	
	private static void menu() {
		// Metodo para mostrar el menu
		System.out.println("A. Dos numeros suman el siguiente");
		System.out.println("B. Tirada impar por sumar");
		System.out.println("C. Salir");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn=new Scanner(System.in);
		String letra="";
		String participantes[]= {"J111_Ma", "J222_IV", "J123_Ca", "J341_Ja","X123","Z3423","X322","341_Ja","Zdsfa","Xdfa","zeree","X111_Lu",
				"X222_Mi","X256_PP","X299_An","Juan99","LuisaCC2","XX1234","Z23","X_3234","Z876_Mi","Z100_TN","Z987_He","Z299_Rw","JJJ22"};
		String jugadores[]=new String[4];
		//Bucle para elegir una letra y que no salga si es correcta, y seleccionar los participantes correctos
		do {
			System.out.println("Dame una letra: J, X o Z");
			letra=sn.next();
		}while(!correcto(letra));
			
			int k=0;
			for(int i=0;i<participantes.length;i++) {
				if(participantes[i].matches("[X]+[0-9]{3}+_+[a-zA-Z]{2}")) {
					System.out.print(participantes[k]+" ");
					jugadores[k]=participantes[k];
				}
			}
			for(int j=0;j<participantes.length;j++) {
				if(participantes[j].matches("[J]+[0-9]{3}+_+[a-zA-Z]{2}")) {
					System.out.print(participantes[j]+" ");
					jugadores[j]=participantes[j];
				}
			}
			int v=0;
			for(int i=0;i<participantes.length;i++) {
				if(participantes[i].matches("[Z]+[0-9]{3}+_+[a-zA-Z]{2}")) {
					System.out.print(participantes[v]+" ");
					jugadores[v]=participantes[v];
				}
		}
		//Apuestas y calculo de apuesta total
		System.out.println("");
		System.out.println("Nueva partida");
		double apuestas[]=new double [4];
		double sumaApostado=0;
		for(int i=0;i<apuestas.length;i++) {
			apuestas[i]=(int)(1+Math.random()*100);
			System.out.println("El jugador "+jugadores[i]+"apuesta "+apuestas[i]);
			sumaApostado+=apuestas[i];
		}
		System.out.println("Total apostado: "+sumaApostado);
		//Matriz de los dados
		int matriz[][]=new int [4][10];
		System.out.println("*************LANZAMIENTOS**************");
		//Generamos la matriz con numeros aleatorios del 1 al 9
		for(int j=0;j<4;j++) {
			for(int i=0;i<10;i++) {
				matriz[j][i]=(int)(1+Math.random()*9);
				System.out.print("["+matriz[j][i]+"]");
			}
			System.out.println("");
		}
		System.out.println("****************************************");
		//Matriz que alamacena a los ganadores y contador para contar los ganadores
		int gana[]=new int [4];
		int contador=0;
		//Bucle con un switch qeu muestra las opciones que damos a elegir al usuario
		String opcion="";
		do {
			menu();
			System.out.println("Elige una opcion");
			opcion=sn.next();
			switch(opcion) {
			case "a":
				sumaSiguiente(matriz,gana);
				System.out.println(Arrays.toString(gana));
				break;
			case "b":
				sumarImpar(matriz,contador);
				break;
			case "c":
				System.out.println("Adios");
			}
				
		}while(opcion=="c");
		//Metodo que muestra quien gana 
		reparto(gana, apuestas,sumaApostado);
	}

	private static void reparto(int[] gana, double[] apuestas, double sumaApostado) {
		// Metodo para deicidir quien ha ganado y como se reparte el dinero
		System.out.println("***********REPARTO*****************");
		System.out.println("Nª de ganadores: ");
	}

	private static int sumarImpar(int [][]matriz, int contador) {
		// Metodo que si la suma de las posicions impares da un numero par gana
		int sumarColumnas []=new int[10];
		for(int j=0;j<4;j++) {
			int sumaColumnas=0;
			for(int i=0;i<10;i++) {
				if(i%2!=0) {
					sumaColumnas+=matriz[j][i];
				}
				sumarColumnas[i]=sumaColumnas;
			}
			if(sumarColumnas[j]%2==0) {
				System.out.println("Has ganado");
				contador++;
			}else {
				System.out.println("Has perdido");
			}
		}
		System.out.println(contador);
		
		return contador;
//        return sumarColumnas;
	}

	private static void sumaSiguiente(int [][]matriz, int []gana) {
		// Metodo para comprobar si sumando dos nuemeros seguidos de la matriz, da el numero que tiene delante
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[0].length-2;j++) {
				if(matriz[i][j]+matriz[i][j+1]==matriz[i][j+2]) {
					gana[i]=1;
				}else 
					gana[i]=0;
			}
		}
	}



	
}
