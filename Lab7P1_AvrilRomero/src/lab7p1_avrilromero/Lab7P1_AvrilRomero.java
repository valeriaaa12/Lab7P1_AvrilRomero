/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_avrilromero;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rodge
 */
public class Lab7P1_AvrilRomero {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();
    static int ganar1 = 0;
    static int ganar2 = 0;

    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) {
            System.out.println("1.She shoot,she scores!");
            System.out.println("2.Piedra,papel o...");
            System.out.println("3.Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese la cantidad de filas: ");
                    int filas = sc.nextInt();
                    System.out.println("Ingrese una cantidad de columnas: ");
                    int columnas = sc.nextInt();
                    System.out.println("Ingrese la cantidad de balas: ");
                    int balas = sc.nextInt();
                    boolean valid = true;
                    int balas2 = (filas * columnas) / 2;
                    int num1 = filas * columnas;
                    if (num1 >= 88 || balas > balas2) {
                        valid = false;
                        while (valid == false) {
                            System.out.println("-Datos errones-");
                            System.out.println("Ingrese la cantidad de filas: ");
                            filas = sc.nextInt();
                            System.out.println("Ingrese una cantidad de columnas: ");
                            columnas = sc.nextInt();
                            System.out.println("Ingrese la cantidad de balas: ");
                            balas = sc.nextInt();
                            balas2 = (filas * columnas) / 2;
                            num1 = filas * columnas;
                            if (num1 >= 88 || balas > balas2) {
                                valid = false;
                            } else {
                                valid = true;
                            }
                        }

                    }
                    int[][] num = new int[filas][columnas];
                    System.out.println("-----Tablero para jugar-----");
                    num = lectura(filas, columnas);
                    print(num);
                    int balas3 = balas;

                    while (balas > 0 || balas3 > 0) {
                        System.out.println("Elige que numero disparar Jugador 1! ");
                        int disparo = sc.nextInt();
                        if (disparo == 88 || disparo == 99) {
                            System.out.println("Numero invalido");
                        } else {
                            num = tiro(num, disparo);
                            print(num);
                            // op = 2;
                            balas--;
                            System.out.println("Le quedan: " + balas + " balas");
                        }
                        System.out.println("Elige que numero disparar Jugador 2! ");
                        disparo = sc.nextInt();
                        if (disparo == 88 || disparo == 99) {
                            System.out.println("Numero invalido");
                        } else {
                            num = tiro2(num, disparo);
                            print(num);
                            //  op = 1;
                            balas3--;
                            System.out.println("Le quedan: " + balas3 + " balas");
                        }
                    }

                }
                if (ganar1 > ganar2) {
                    System.out.println("Jugador 1 gana con " + ganar1);
                    System.out.println("Jugador 2 pierde con " + ganar2);
                } else {
                    System.out.println("Jugador 2 gana con " + ganar2);
                    System.out.println("Jugador 1 pierde con " + ganar1);
                }

                break;
                case 2: {
                    int[][] mat = {{0, 1, 0, 1, 0}, {0, 0, 1, 1, 0}, {1, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {1, 1, 0, 0, 0}};
                    System.out.println("Elija que quiere usar: ");
                    System.out.println("1.Roca");
                    System.out.println("2.Tijera");
                    System.out.println("3.Papel");
                    System.out.println("4.Lizard");
                    System.out.println("5.Spock");
                    int posicion = sc.nextInt();
                    posicion--;

                    int computer = generaposicion();

                    switch (computer) {
                        case 1: {
                            System.out.println("La maquina escogio Roca");
                        }
                        break;
                        case 2: {
                            System.out.println("La maquina escogio Tijera");
                        }
                        break;
                        case 3: {
                            System.out.println("La maquina escogio Papel");
                        }
                        break;
                        case 4: {
                            System.out.println("La maquina escogio Lizard");
                        }
                        break;
                        case 5: {
                            System.out.println("La maquina escogio Spock");
                        }
                        break;
                    }
                    computer--;
                    int value = mat[posicion][computer];
                    if (value == 1) {
                        System.out.println("¡Jugador Gana!");
                    } else if (computer == posicion) {
                        System.out.println("Empate");
                    } else if (value == 0) {
                        System.out.println("¡La maquina Gana!");
                    }

                }
                break;
                case 3: {
                    seguir = false;
                }
                break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        }//fin while

    }//fin main

    public static int[][] lectura(int f, int c) {
        int[][] temporal = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                temporal[i][j] = 1 + ran.nextInt(f * c);

                while (repetidos(temporal, temporal[i][j], i, j)) {
                    temporal[i][j] = 1 + ran.nextInt(f * c);
                }
            }
        }
        return temporal;
    }

    public static void print(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static boolean repetidos(int[][] matriz, int valor, int z, int c) {

        int temp = 0;
        boolean valid = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                temp = matriz[i][j];
                if (i != z || j != c) {
                    if (temp == valor) {

                        valid = true;
                    }
                }

            }
        }
        return valid;
    }

    public static int[][] tiro(int[][] x, int y) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j] == y) {
                    System.out.println("Tiro acertado!");
                    x[i][j] = 99;
                    ganar1 += y;

                }
            }

        }
        return x;
    }

    public static int[][] tiro2(int[][] x, int y) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j] == y) {
                    System.out.println("Tiro acertado!");
                    x[i][j] = 88;
                    ganar2 += y;
                }
            }

        }
        return x;
    }

    public static int generaposicion() {
        int temporal = 0;
        temporal = 1 + ran.nextInt(5);
        return temporal;
    }

    public static boolean lectura2(int[][] x, int y, int z) {
        boolean temporal = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

            }
        }
        return temporal;
    }

}//fin class

