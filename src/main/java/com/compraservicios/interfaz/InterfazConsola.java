package com.compraservicios.interfaz;

import java.util.Scanner;

public class InterfazConsola {
    private Scanner scanner;

    public InterfazConsola() {
        this.scanner = new Scanner(System.in);
    }

    public void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String capturarEntrada() {
        return scanner.nextLine();
    }
}
