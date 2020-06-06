package Code;

import View.Compilador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Methods {

    static List array1 = new ArrayList();

    static List eFor1 = new ArrayList();
    static List eFor2 = new ArrayList();
    static List eFor3 = new ArrayList();
    static List eFor4 = new ArrayList();
    static List eFor5 = new ArrayList();
    static List eFor6 = new ArrayList();

    public static void Proyecto(String path) {
        String fileDir = path;
        FileReader leerArchivo = null;
        BufferedReader textoArchivo = null;
        List contenido = new ArrayList();
        String lineContent = "";
        int p = 0;
        int lineNumber = 0;
        int largo = 0;
        String temp = "";
        String temp2 = "";
        String constantes[][] = new String[5][5];
        String[] operadores = {"=", "+", "-", "*", "/",};
        String[] doperadores = {"OPERADOR IGUAL", "OPERADOR SUMA", "OPERADOR SUSTRACCION", "OPERADOR MULTIPLICADOR", "OPERADOR DIVISION"};
        int va1;
        int va2;
        int va3;
        int va4;
        String t1 = "";
        String t2 = "";
        String t3 = "";
        String t4 = "";
        String t5 = "";
        String t6 = "";
        FileWriter fichero = null;
        PrintWriter pw = null;
        String Pr1 = null;

        try {
            leerArchivo = new FileReader(new File(fileDir));
            textoArchivo = new BufferedReader(leerArchivo);

            System.out.println("LECTURA DE ARCHIVO-----------------------------------------------------");

            while (lineContent != null) {
                try {
                    lineContent = textoArchivo.readLine();
                } catch (IOException ex) {
                    System.err.println(
                            "Error lectura de linea: " + lineNumber + " -> " + ex);
                }
                if (lineContent != null && !lineContent.equals("")) {
                    System.out.println("Datos leidos : " + lineContent);
                    String[] lineElements = lineContent.split("\n");
                    contenido.add(lineElements);
                    array1.add(lineContent);
                }
                array1.add(lineContent);
                lineNumber++;
            }
            for (Object a : array1) {
                Compilador.txtArea.append(a + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("LECTURA DE DATOS CARGADOS-----------------------------------------------");
        String[] datos = new String[contenido.size()];
        for (int i = 0; i < contenido.size(); i++) {
            String[] lineElements = (String[]) contenido.get(i);
            for (String lineElement : lineElements) {
                datos[i] = lineElement;
                System.out.print("linea " + i + ": " + datos[i] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------\n");
        //CONSTANTES
        for (int i = 0; i < constantes.length; i++) {
            System.out.println("");
            for (int j = 0; j < constantes[i].length; j++) {
                int k = i + 5;
                if (datos[k].indexOf(" ") < 0) {
                    largo = datos[k].length();
                } else {
                    largo = datos[k].indexOf(" ") + 1;
                }
                constantes[i][j] = datos[k].substring(0, largo).replace(" ", "");
                temp = datos[k].substring(largo);
                datos[k] = temp;
                System.out.print(constantes[i][j] + "\t");
            }

        }

        System.out.println("\n------------------------------------------------------------------------\n");
        //CREACION DE TABLA DE SIMBOLOS -- FORMULA 1
        System.out.println("\n\nVALIDACION FORMULA 1----------------------------------------------------");
        p = 10;
        String tabla1[][] = new String[15][5];
        System.out.println(datos[p]);

        /////validacion si hay operadores juntos
        try {
            String val = "";
            val = datos[p];

            String formula = "";

            int bandera = 0;

            for (int a = 9; a <= 29; a++) {
                formula = val.substring(9, a);

                if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0))) {

                    if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0))) {

                        bandera = 1;
                    } else if (bandera == 0) {
                        System.out.println("todo bien");
                    }

                }
            }
            System.out.println(bandera);
            if (bandera == 1) {
                System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
                //Compilador.lbFor1.setText("ERROR: 2 OPERADORES SEGUIDOS");
                eFor1.add("ERROR: 2 OPERADORES SEGUIDOS");
            }

        } catch (Exception a) {
            System.out.println("");
        } finally {

            temp = datos[p];
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    //Compilador.lbFor1.setText("ERROR: FALTA CERRAR PARENTESIS");
                    eFor1.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    //Compilador.lbFor1.setText("ERROR: FALTA CERRAR PARENTESIS");
                    eFor1.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    //Compilador.lbFor1.setText("ERROR: FALTA CERRAR PARENTESIS");
                    eFor1.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf(")") > 0) {
                temp = temp.replace(")", "");
                System.out.println("ERROR: FALTA ABRIR PARENTESIS");
                //Compilador.lbFor1.setText("ERROR: FALTA ABRIR PARENTESIS");
                eFor1.add("ERROR: FALTA ABRIR PARENTESIS");
            }

            if (temp.indexOf(";") < 0) {
                System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
                //Compilador.lbFor1.setText("ERROR: FALTA PUNTO Y COMA (;) ");
                eFor1.add("ERROR: FALTA PUNTO Y COMA (;) ");
            }

            largo = temp.indexOf("=");
            if (largo < 0) {
                System.out.println("ERROR: FALTA SIGNO '='");
                //Compilador.lbFor1.setText("ERROR: FALTA SIGNO '='");
                eFor1.add("ERROR: FALTA SIGNO '='");
            } else {
                tabla1[0][0] = temp.substring(0, largo);
                tabla1[0][1] = "VARIABLE";
                tabla1[0][4] = "";
                temp = temp.substring(largo);

                for (int x = 1; x < tabla1.length; x++) {
                    va1 = 99;
                    va2 = 99;
                    va3 = 99;
                    va4 = 0;
                    for (int z = 0; z < operadores.length; z++) {
                        if (va1 == 99) {
                            if (temp.length() < 1) {
                            } else if (va1 > temp.substring(0, 1).indexOf(operadores[z])) {
                                va1 = temp.substring(0, 1).indexOf(operadores[z]);
                                t1 = operadores[z];
                                t5 = doperadores[z];
                                if (t1 == "/") {
                                    Pr1 = "4";
                                }
                                if (t1 == "*") {
                                    Pr1 = "2";
                                }
                                if (t1 == "+") {
                                    Pr1 = "3";
                                }
                                if (t1 == "=") {
                                    Pr1 = "1";
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                            }
                        }
                    }

                    for (int z = 0; z < constantes.length; z++) {
                        if (va2 == 99) {
                            if (va2 > temp.indexOf(constantes[z][0])) {
                                va2 = temp.indexOf(constantes[z][0]);
                                t2 = constantes[z][0];
                                t4 = constantes[z][2];
                                t6 = constantes[z][4].replace(";", "");
                                if (va2 < 0) {
                                    va2 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 10; z < 100; z++) {
                        if (va3 == 99) {
                            if (temp.length() < 2) {
                            } else if (va3 > temp.substring(0, 2).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.substring(0, 2).indexOf(t3);
                                if (va3 < 0) {
                                    va3 = 99;
                                }
                            }
                        }
                    }
                    if (va3 == 99) {
                        for (int z = 10; z > 0; z--) {
                            if (temp.length() < 1) {
                            } else if (va3 > temp.substring(0, 1).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.indexOf(t3);
                            }
                            if (va3 < 0) {
                                va3 = 99;
                            }
                        }
                    }
                    if (va1 < va2 & va1 < va3) {
                        va4 = 1;
                    } else if (va2 < va1 & va2 < va3) {
                        va4 = 2;
                    } else if (va3 < va1 & va3 < va2) {
                        va4 = 3;
                    }
                    switch (va4) {
                        case 1:
                            tabla1[x][0] = temp.substring(0, t1.length());
                            tabla1[x][1] = t5;
                            tabla1[x][2] = "N/A";
                            tabla1[x][3] = "N/A";
                            tabla1[x][4] = Pr1;
                            temp = temp.substring(t1.length(), temp.length());
                            break;
                        case 2:
                            tabla1[x][0] = temp.substring(0, t2.length());
                            tabla1[x][1] = "VARIABLE";
                            tabla1[x][2] = t4;
                            tabla1[x][3] = t6;
                            tabla1[x][4] = "";
                            temp = temp.substring(t2.length(), temp.length());
                            break;
                        case 3:
                            tabla1[x][0] = temp.substring(0, t3.length());
                            tabla1[x][1] = "CONSTANTE";
                            tabla1[x][2] = "Integer";
                            tabla1[x][3] = t3;
                            tabla1[x][4] = "";
                            temp = temp.substring(t3.length(), temp.length());
                            break;
                    }
                }
            }

            calculo(tabla1[2][2], tabla1[2][3], tabla1[4][3], tabla1[6][3], tabla1[8][3], tabla1[10][3]);
            String ca = " # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD";
            System.out.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
            //Compilador.txt1.append(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD" + "\n");

            for (int x = 0; x < tabla1.length; x++) {
                if (tabla1[x][0] == null) {
                } else {
                    temp2 = " " + (x + 1);
                    System.out.print(temp2.substring(0, 2) + " ");
                    //Compilador.txt1.append(temp2.substring(0, 2) + " " + "\n");
                    ca = ca + "\n";
                }
                for (int y = 0; y < tabla1[x].length; y++) {
                    if (tabla1[x][y] == null) {
                    } else {

                        temp2 = tabla1[x][y] + "                         ";
                        System.out.print(temp2.substring(0, 25));
                        ca = ca + temp2.substring(0, 25);

                    }
                }
                System.out.println("");
                //Compilador.txt1.append("");
            }
            //Compilador.txt1.append(ca);
            /**
             * ********* ESCRITURA DE ARCHIVO FORMULA 1 ***********
             */
            HashSet hs = new HashSet();
            hs.addAll(eFor1);
            eFor1.clear();
            eFor1.addAll(hs);

            for (Object a : eFor1) {
                Compilador.txtFor1.append(a + "\n");
            }

            try {
                DefaultTableModel model = new DefaultTableModel(tabla1, 20);

                fichero = new FileWriter("C:\\Files\\Formula 1.txt");
                pw = new PrintWriter(fichero);
                pw.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");

                for (int x = 0; x < tabla1.length; x++) {
                    if (tabla1[x][0] == null) {
                    } else {
                        temp2 = " " + (x + 1);
                        //System.out.print(temp2.substring(0, 2) + " ");
                        pw.print(temp2.substring(0, 2) + " ");

                    }
                    for (int y = 0; y < tabla1[x].length; y++) {
                        if (tabla1[x][y] == null) {
                        } else {
                            temp2 = tabla1[x][y] + "                         ";
                            //System.out.print(temp2.substring(0, 25));
                            pw.print(temp2.substring(0, 25));

                        }
                    }
                    //System.out.println("");
                    pw.println("");

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {

                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

////////////////////////////////////////////////////////////////////////////////////////formula 2/////////////////////////////////////////////////////////////////////////////////////////////////////        
        //CREACION DE TABLA DE SIMBOLOS -- FORMULA 2
        System.out.println("\n\nVALIDACION FORMULA 2----------------------------------------------------");
        p = 11;
        String tabla2[][] = new String[15][5];
        System.out.println(datos[p]);

        ///////////////////////////validacion operadores juntos//////////////////////////////////////////////
        try {
            String val = "";
            val = datos[p];

            String formula = "";

            int bandera = 0;

            for (int a = 9; a <= 29; a++) {
                formula = val.substring(9, a);

                if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0))) {

                    if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0))) {

                        bandera = 1;
                    } else if (bandera == 0) {
                        System.out.println("todo bien");
                    }

                }
            }

            if (bandera == 1) {
                System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
                eFor2.add("ERROR: 2 OPERADORES SEGUIDOS");
            }

        } catch (Exception a) {
            System.out.println("");
        } finally {

            temp = datos[p];
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor2.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor2.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor2.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf(")") > 0) {
                temp = temp.replace(")", "");
                System.out.println("ERROR: FALTA ABRIR PARENTESIS");
                eFor2.add("ERROR: FALTA ABRIR PARENTESIS");
            }

            if (temp.indexOf(";") < 0) {
                System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
                eFor2.add("ERROR: FALTA PUNTO Y COMA (;) ");
            }

            largo = temp.indexOf("=");
            if (largo < 0) {
                System.out.println("ERROR: FALTA SIGNO '='");
                eFor2.add("ERROR: FALTA SIGNO '='");
            } else {
                tabla2[0][0] = temp.substring(0, largo);
                tabla2[0][1] = "VARIABLE";
                tabla2[0][4] = "";
                temp = temp.substring(largo);
                for (int x = 1; x < tabla2.length; x++) {
                    va1 = 99;
                    va2 = 99;
                    va3 = 99;
                    va4 = 0;
                    for (int z = 0; z < operadores.length; z++) {
                        if (va1 == 99) {
                            if (temp.length() < 1) {
                            } else if (va1 > temp.substring(0, 1).indexOf(operadores[z])) {
                                va1 = temp.substring(0, 1).indexOf(operadores[z]);
                                t1 = operadores[z];
                                t5 = doperadores[z];
                                if (t1 == "/") {
                                    Pr1 = "4";
                                }
                                if (t1 == "*") {
                                    Pr1 = "2";
                                }
                                if (t1 == "+") {
                                    Pr1 = "3";
                                }
                                if (t1 == "=") {
                                    Pr1 = "1";
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 0; z < constantes.length; z++) {
                        if (va2 == 99) {
                            if (va2 > temp.indexOf(constantes[z][0])) {
                                va2 = temp.indexOf(constantes[z][0]);
                                t2 = constantes[z][0];
                                t4 = constantes[z][2];
                                t6 = constantes[z][4].replace(";", "");
                                if (va2 < 0) {
                                    va2 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 10; z < 100; z++) {
                        if (va3 == 99) {
                            if (temp.length() < 2) {
                            } else if (va3 > temp.substring(0, 2).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.substring(0, 2).indexOf(t3);
                                if (va3 < 0) {
                                    va3 = 99;
                                }
                            }
                        }
                    }
                    if (va3 == 99) {
                        for (int z = 10; z > 0; z--) {
                            if (temp.length() < 1) {
                            } else if (va3 > temp.substring(0, 1).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.indexOf(t3);
                            }
                            if (va3 < 0) {
                                va3 = 99;
                            }
                        }
                    }
                    if (va1 < va2 & va1 < va3) {
                        va4 = 1;
                    } else if (va2 < va1 & va2 < va3) {
                        va4 = 2;
                    } else if (va3 < va1 & va3 < va2) {
                        va4 = 3;
                    }

                    switch (va4) {
                        case 1:
                            tabla2[x][0] = temp.substring(0, t1.length());
                            tabla2[x][1] = t5;
                            tabla2[x][2] = "N/A";
                            tabla2[x][3] = "N/A";
                            tabla2[x][4] = Pr1;
                            temp = temp.substring(t1.length(), temp.length());
                            break;
                        case 2:
                            tabla2[x][0] = temp.substring(0, t2.length());
                            tabla2[x][1] = "VARIABLE";
                            tabla2[x][2] = t4;
                            tabla2[x][3] = t6;
                            tabla2[x][4] = "";
                            temp = temp.substring(t2.length(), temp.length());
                            break;
                        case 3:
                            tabla2[x][0] = temp.substring(0, t3.length());
                            tabla2[x][1] = "CONSTANTE";
                            tabla2[x][2] = "Integer";
                            tabla2[x][3] = t3;
                            tabla2[x][4] = "";
                            temp = temp.substring(t3.length(), temp.length());
                            break;
                    }
                }
            }

            calculo(tabla2[2][2], tabla2[2][3], tabla2[4][3], tabla2[6][3], tabla2[8][3], "1");

            System.out.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
            for (int x = 0; x < tabla2.length; x++) {
                if (tabla2[x][0] == null) {
                } else {
                    temp2 = " " + (x + 1);
                    System.out.print(temp2.substring(0, 2) + " ");
                }
                for (int y = 0; y < tabla2[x].length; y++) {
                    if (tabla2[x][y] == null) {
                    } else {
                        temp2 = tabla2[x][y] + "                         ";
                        System.out.print(temp2.substring(0, 25));
                    }
                }
                System.out.println("");
            }

            /**
             * ********* ESCRITURA DE ARCHIVO FORMULA 2 ***********
             */
            HashSet hs = new HashSet();
            hs.addAll(eFor2);
            eFor2.clear();
            eFor2.addAll(hs);

            for (Object a : eFor2) {
                Compilador.txtFor2.append(a + "\n");
            }

            try {
                fichero = new FileWriter("C:\\Files\\Formula 2.txt");
                pw = new PrintWriter(fichero);
                pw.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
                for (int x = 0; x < tabla2.length; x++) {
                    if (tabla2[x][0] == null) {
                    } else {
                        temp2 = " " + (x + 1);
                        //System.out.print(temp2.substring(0, 2) + " ");
                        pw.print(temp2.substring(0, 2) + " ");
                    }
                    for (int y = 0; y < tabla2[x].length; y++) {
                        if (tabla2[x][y] == null) {
                        } else {
                            temp2 = tabla2[x][y] + "                         ";
                            //System.out.print(temp2.substring(0, 25));
                            pw.print(temp2.substring(0, 25));
                        }
                    }
                    //System.out.println("");
                    pw.println("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {

                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        }
        /////////////////////////////////////////////////////////////////////////formula 3/////////////////////////////////////////////////////////////////////////////////////////////////////////      

        //CREACION DE TABLA DE SIMBOLOS -- FORMULA 3
        System.out.println("\n\nVALIDACION FORMULA 3----------------------------------------------------");
        p = 12;
        String tabla3[][] = new String[15][5];
        System.out.println(datos[p]);

        //////////////////////////validacion operadores juntos
        try {
            String val = "";
            val = datos[p];

            String formula = "";

            int bandera3 = 0;

            for (int a = 9; a <= 29; a++) {
                formula = val.substring(9, a);

                if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0))) {

                    if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0))) {

                        bandera3 = 1;
                    } else if (bandera3 == 0) {
                        System.out.println("todo bien");
                    }

                }
            }

            if (bandera3 == 1) {
                System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
                eFor3.add("ERROR: 2 OPERADORES SEGUIDOS");
            }

        } catch (Exception a) {
            System.out.println("");
        } finally {

            temp = datos[p];
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor3.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor3.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor3.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf(")") > 0) {
                temp = temp.replace(")", "");
                System.out.println("ERROR: FALTA ABRIR PARENTESIS");
                eFor3.add("ERROR: FALTA ABRIR PARENTESIS");
            }

            if (temp.indexOf(";") < 0) {
                System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
                eFor3.add("ERROR: FALTA PUNTO Y COMA (;) ");
            }

            largo = temp.indexOf("=");
            if (largo < 0) {
                System.out.println("ERROR: FALTA SIGNO '='");
                eFor3.add("ERROR: FALTA SIGNO '='");
            } else {
                tabla3[0][0] = temp.substring(0, largo);
                tabla3[0][1] = "VARIABLE";
                tabla3[0][4] = "";
                temp = temp.substring(largo);
                for (int x = 1; x < tabla3.length; x++) {
                    va1 = 99;
                    va2 = 99;
                    va3 = 99;
                    va4 = 0;
                    for (int z = 0; z < operadores.length; z++) {
                        if (va1 == 99) {
                            if (temp.length() < 1) {
                            } else if (va1 > temp.substring(0, 1).indexOf(operadores[z])) {
                                va1 = temp.substring(0, 1).indexOf(operadores[z]);
                                t1 = operadores[z];
                                t5 = doperadores[z];
                                if (t1 == "/") {
                                    Pr1 = "4";
                                }
                                if (t1 == "*") {
                                    Pr1 = "2";
                                }
                                if (t1 == "+") {
                                    Pr1 = "3";
                                }
                                if (t1 == "=") {
                                    Pr1 = "1";
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 0; z < constantes.length; z++) {
                        if (va2 == 99) {
                            if (va2 > temp.indexOf(constantes[z][0])) {
                                va2 = temp.indexOf(constantes[z][0]);
                                t2 = constantes[z][0];
                                t4 = constantes[z][2];
                                t6 = constantes[z][4].replace(";", "");
                                if (va2 < 0) {
                                    va2 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 10; z < 100; z++) {
                        if (va3 == 99) {
                            if (temp.length() < 2) {
                            } else if (va3 > temp.substring(0, 2).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.substring(0, 2).indexOf(t3);
                                if (va3 < 0) {
                                    va3 = 99;
                                }
                            }
                        }
                    }
                    if (va3 == 99) {
                        for (int z = 10; z > 0; z--) {
                            if (temp.length() < 1) {
                            } else if (va3 > temp.substring(0, 1).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.indexOf(t3);
                            }
                            if (va3 < 0) {
                                va3 = 99;
                            }
                        }
                    }
                    if (va1 < va2 & va1 < va3) {
                        va4 = 1;
                    } else if (va2 < va1 & va2 < va3) {
                        va4 = 2;
                    } else if (va3 < va1 & va3 < va2) {
                        va4 = 3;
                    }

                    switch (va4) {
                        case 1:
                            tabla3[x][0] = temp.substring(0, t1.length());
                            tabla3[x][1] = t5;
                            tabla3[x][2] = "N/A";
                            tabla3[x][3] = "N/A";
                            tabla3[x][4] = Pr1;
                            temp = temp.substring(t1.length(), temp.length());
                            break;
                        case 2:
                            tabla3[x][0] = temp.substring(0, t2.length());
                            tabla3[x][1] = "VARIABLE";
                            tabla3[x][2] = t4;
                            tabla3[x][3] = t6;
                            tabla3[x][4] = "";
                            temp = temp.substring(t2.length(), temp.length());
                            break;
                        case 3:
                            tabla3[x][0] = temp.substring(0, t3.length());
                            tabla3[x][1] = "CONSTANTE";
                            tabla3[x][2] = "Integer";
                            tabla3[x][3] = t3;
                            tabla3[x][4] = "";
                            temp = temp.substring(t3.length(), temp.length());
                            break;
                    }
                }
            }

            calculo(tabla3[2][2], tabla3[2][3], tabla3[4][3], tabla3[6][3], tabla3[8][3], "1");
            System.out.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
            for (int x = 0; x < tabla3.length; x++) {
                if (tabla3[x][0] == null) {
                } else {
                    temp2 = " " + (x + 1);
                    System.out.print(temp2.substring(0, 2) + " ");
                }
                for (int y = 0; y < tabla3[x].length; y++) {
                    if (tabla3[x][y] == null) {
                    } else {
                        temp2 = tabla3[x][y] + "                         ";
                        System.out.print(temp2.substring(0, 25));
                    }
                }
                System.out.println("");
            }

            /**
             * ********* ESCRITURA DE ARCHIVO FORMULA 3 ***********
             */
            HashSet hs = new HashSet();
            hs.addAll(eFor3);
            eFor3.clear();
            eFor3.addAll(hs);

            for (Object a : eFor3) {
                Compilador.txtFor3.append(a + "\n");
            }

            try {
                fichero = new FileWriter("C:\\Files\\Formula 3.txt");
                pw = new PrintWriter(fichero);
                pw.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
                for (int x = 0; x < tabla3.length; x++) {
                    if (tabla3[x][0] == null) {
                    } else {
                        temp2 = " " + (x + 1);
                        //System.out.print(temp2.substring(0, 2) + " ");
                        pw.print(temp2.substring(0, 2) + " ");
                    }
                    for (int y = 0; y < tabla3[x].length; y++) {
                        if (tabla3[x][y] == null) {
                        } else {
                            temp2 = tabla3[x][y] + "                         ";
                            //System.out.print(temp2.substring(0, 25));
                            pw.print(temp2.substring(0, 25));
                        }
                    }
                    //System.out.println("");
                    pw.println("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {

                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        }
        ////////////////////////////////////////////////////////////////////////////////// formula 4 /////////////////////////////////////////////////////////////////////////////////////////////       

        //CREACION DE TABLA DE SIMBOLOS -- FORMULA 4
        System.out.println("\n\nVALIDACION FORMULA 4----------------------------------------------------");
        p = 13;
        String tabla4[][] = new String[15][5];
        System.out.println(datos[p]);

        //////////////////////////validacion operadores juntos
        try {
            String val = "";
            val = datos[p];

            String formula = "";

            int bandera = 0;

            for (int a = 9; a <= val.length(); a++) {
                formula = val.substring(9, a);

                if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0))) {

                    if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0))) {

                        bandera = 1;
                    } else if (bandera == 0) {
                        System.out.println("todo bien");
                    }

                }
            }

            if (bandera == 1) {
                System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
                eFor4.add("ERROR: 2 OPERADORES SEGUIDOS");
            }

        } catch (Exception a) {
            System.out.println("");
        } finally {

            temp = datos[p];
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor4.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor4.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor4.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf(")") > 0) {
                temp = temp.replace(")", "");
                System.out.println("ERROR: FALTA ABRIR PARENTESIS");
                eFor4.add("ERROR: FALTA ABRIR PARENTESIS");
            }

            if (temp.indexOf(";") < 0) {
                System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
                eFor4.add("ERROR: FALTA PUNTO Y COMA (;) ");
            }

            largo = temp.indexOf("=");
            if (largo < 0) {
                System.out.println("ERROR: FALTA SIGNO '='");
                eFor4.add("ERROR: FALTA SIGNO '='");
            } else {
                tabla4[0][0] = temp.substring(0, largo);
                tabla4[0][1] = "VARIABLE";
                tabla4[0][4] = "";
                temp = temp.substring(largo);
                for (int x = 1; x < tabla4.length; x++) {
                    va1 = 99;
                    va2 = 99;
                    va3 = 99;
                    va4 = 0;
                    for (int z = 0; z < operadores.length; z++) {
                        if (va1 == 99) {
                            if (temp.length() < 1) {
                            } else if (va1 > temp.substring(0, 1).indexOf(operadores[z])) {
                                va1 = temp.substring(0, 1).indexOf(operadores[z]);
                                t1 = operadores[z];
                                t5 = doperadores[z];
                                if (t1 == "/") {
                                    Pr1 = "4";
                                }
                                if (t1 == "*") {
                                    Pr1 = "2";
                                }
                                if (t1 == "+") {
                                    Pr1 = "3";
                                }
                                if (t1 == "=") {
                                    Pr1 = "1";
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 0; z < constantes.length; z++) {
                        if (va2 == 99) {
                            if (va2 > temp.indexOf(constantes[z][0])) {
                                va2 = temp.indexOf(constantes[z][0]);
                                t2 = constantes[z][0];
                                t4 = constantes[z][2];
                                t6 = constantes[z][4].replace(";", "");
                                if (va2 < 0) {
                                    va2 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 10; z < 100; z++) {
                        if (va3 == 99) {
                            if (temp.length() < 2) {
                            } else if (va3 > temp.substring(0, 2).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.substring(0, 2).indexOf(t3);
                                if (va3 < 0) {
                                    va3 = 99;
                                }
                            }
                        }
                    }
                    if (va3 == 99) {
                        for (int z = 10; z > 0; z--) {
                            if (temp.length() < 1) {
                            } else if (va3 > temp.substring(0, 1).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.indexOf(t3);
                            }
                            if (va3 < 0) {
                                va3 = 99;
                            }
                        }
                    }
                    if (va1 < va2 & va1 < va3) {
                        va4 = 1;
                    } else if (va2 < va1 & va2 < va3) {
                        va4 = 2;
                    } else if (va3 < va1 & va3 < va2) {
                        va4 = 3;
                    }

                    switch (va4) {
                        case 1:
                            tabla4[x][0] = temp.substring(0, t1.length());
                            tabla4[x][1] = t5;
                            tabla4[x][2] = "N/A";
                            tabla4[x][3] = "N/A";
                            tabla4[x][4] = Pr1;
                            temp = temp.substring(t1.length(), temp.length());
                            break;
                        case 2:
                            tabla4[x][0] = temp.substring(0, t2.length());
                            tabla4[x][1] = "VARIABLE";
                            tabla4[x][2] = t4;
                            tabla4[x][3] = t6;
                            tabla4[x][4] = "";
                            temp = temp.substring(t2.length(), temp.length());
                            break;
                        case 3:
                            tabla4[x][0] = temp.substring(0, t3.length());
                            tabla4[x][1] = "CONSTANTE";
                            tabla4[x][2] = "Integer";
                            tabla4[x][3] = t3;
                            tabla4[x][4] = "";
                            temp = temp.substring(t3.length(), temp.length());
                            break;
                    }
                }
            }
            System.out.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
            for (int x = 0; x < tabla4.length; x++) {
                if (tabla4[x][0] == null) {
                } else {
                    temp2 = " " + (x + 1);
                    System.out.print(temp2.substring(0, 2) + " ");
                }
                for (int y = 0; y < tabla4[x].length; y++) {
                    if (tabla4[x][y] == null) {
                    } else {
                        temp2 = tabla4[x][y] + "                         ";
                        System.out.print(temp2.substring(0, 25));
                    }
                }
                System.out.println("");
            }

            /**
             * ********* ESCRITURA DE ARCHIVO FORMULA 4 ***********
             */
            HashSet hs = new HashSet();
            hs.addAll(eFor4);
            eFor4.clear();
            eFor4.addAll(hs);

            for (Object a : eFor4) {
                Compilador.txtFor4.append(a + "\n");
            }

            try {
                fichero = new FileWriter("C:\\Files\\Formula 4.txt");
                pw = new PrintWriter(fichero);
                pw.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
                for (int x = 0; x < tabla4.length; x++) {
                    if (tabla4[x][0] == null) {
                    } else {
                        temp2 = " " + (x + 1);
                        //System.out.print(temp2.substring(0, 2) + " ");
                        pw.print(temp2.substring(0, 2) + " ");
                    }
                    for (int y = 0; y < tabla4[x].length; y++) {
                        if (tabla4[x][y] == null) {
                        } else {
                            temp2 = tabla4[x][y] + "                         ";
                            //System.out.print(temp2.substring(0, 25));
                            pw.print(temp2.substring(0, 25));
                        }
                    }
                    //System.out.println("");
                    pw.println("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {

                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        }
        ///////////////////////////////////////////////////////////////////////////////////////formula 5 ///////////////////////////////////////////////////////////////////////////////////////       

        //CREACION DE TABLA DE SIMBOLOS -- FORMULA 5
        System.out.println("\n\nVALIDACION FORMULA 5----------------------------------------------------");
        p = 14;
        String tabla5[][] = new String[15][5];
        System.out.println(datos[p]);

        //////////////validacion operadores juntos
        try {
            String val = "";
            val = datos[p];

            String formula = "";

            int bandera = 0;

            for (int a = 9; a <= val.length(); a++) {
                formula = val.substring(9, a);

                if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0)) || ((formula.indexOf(")") > 0))) {

                    if (((formula.indexOf("+") > 0)) || ((formula.indexOf("*") > 0)) || ((formula.indexOf("-") > 0)) || ((formula.indexOf("/") > 0)) || ((formula.indexOf(";") > 0)) || ((formula.indexOf(")") > 0))) {

                        bandera = 1;
                    } else if (bandera == 0) {
                        System.out.println("todo bien");
                    }

                }
            }

            if (bandera == 1) {
                System.out.println("ERROR: 2 OPERADORES SEGUIDOS");
                eFor5.add("ERROR: 2 OPERADORES SEGUIDOS");
            }

        } catch (Exception a) {
            System.out.println("");
        } finally {

            temp = datos[p];
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor5.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor5.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf("(") > 0) {
                temp = temp.substring(0, temp.indexOf("(")) + temp.substring(temp.indexOf("(") + 1, temp.length());
                if (temp.indexOf(")") > 0) {
                    temp = temp.substring(0, temp.indexOf(")")) + temp.substring(temp.indexOf(")") + 1, temp.length());
                } else {
                    System.out.println("ERROR: FALTA CERRAR PARENTESIS");
                    eFor5.add("ERROR: FALTA CERRAR PARENTESIS");
                }
            }
            if (temp.indexOf(")") > 0) {
                temp = temp.replace(")", "");
                System.out.println("ERROR: FALTA ABRIR PARENTESIS");
                eFor5.add("ERROR: FALTA ABRIR PARENTESIS");
            }

            if (temp.indexOf(";") < 0) {
                System.out.println("ERROR: FALTA PUNTO Y COMA (;) ");
                eFor5.add("ERROR: FALTA PUNTO Y COMA (;) ");
            }

            largo = temp.indexOf("=");
            if (largo < 0) {
                System.out.println("ERROR: FALTA SIGNO '='");
                eFor5.add("ERROR: FALTA SIGNO '='");
            } else {
                tabla5[0][0] = temp.substring(0, largo);
                tabla5[0][1] = "VARIABLE";
                tabla5[0][4] = "";
                temp = temp.substring(largo);
                for (int x = 1; x < tabla5.length; x++) {
                    va1 = 99;
                    va2 = 99;
                    va3 = 99;
                    va4 = 0;

                    for (int z = 0; z < operadores.length; z++) {
                        if (va1 == 99) {
                            if (temp.length() < 1) {
                            } else if (va1 > temp.substring(0, 1).indexOf(operadores[z])) {
                                va1 = temp.substring(0, 1).indexOf(operadores[z]);
                                t1 = operadores[z];
                                t5 = doperadores[z];
                                if (t1 == "/") {
                                    Pr1 = "4";
                                }
                                if (t1 == "*") {
                                    Pr1 = "2";
                                }
                                if (t1 == "+") {
                                    Pr1 = "3";
                                }
                                if (t1 == "=") {
                                    Pr1 = "1";
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                                if (va1 < 0) {
                                    va1 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 0; z < constantes.length; z++) {
                        if (va2 == 99) {
                            if (va2 > temp.indexOf(constantes[z][0])) {
                                va2 = temp.indexOf(constantes[z][0]);
                                t2 = constantes[z][0];
                                t4 = constantes[z][2];
                                t6 = constantes[z][4].replace(";", "");
                                if (va2 < 0) {
                                    va2 = 99;
                                }
                            }
                        }
                    }
                    for (int z = 10; z < 100; z++) {
                        if (temp.length() < 2) {
                        } else if (va3 == 99) {
                            if (va3 > temp.substring(0, 2).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.substring(0, 2).indexOf(t3);
                                if (va3 < 0) {
                                    va3 = 99;
                                }
                            }
                        }
                    }
                    if (va3 == 99) {
                        for (int z = 10; z > 0; z--) {
                            if (temp.length() < 1) {
                            } else if (va3 > temp.substring(0, 1).indexOf(String.valueOf(z))) {
                                t3 = String.valueOf(z);
                                va3 = temp.indexOf(t3);
                            }
                            if (va3 < 0) {
                                va3 = 99;
                            }
                        }
                    }
                    if (va1 < va2 & va1 < va3) {
                        va4 = 1;
                    } else if (va2 < va1 & va2 < va3) {
                        va4 = 2;
                    } else if (va3 < va1 & va3 < va2) {
                        va4 = 3;
                    }
                    switch (va4) {
                        case 1:
                            tabla5[x][0] = temp.substring(0, t1.length());
                            tabla5[x][1] = t5;
                            tabla5[x][2] = "N/A";
                            tabla5[x][3] = "N/A";
                            tabla5[x][4] = Pr1;
                            temp = temp.substring(t1.length(), temp.length());
                            break;
                        case 2:
                            tabla5[x][0] = temp.substring(0, t2.length());
                            tabla5[x][1] = "VARIABLE";
                            tabla5[x][2] = t4;
                            tabla5[x][3] = t6;
                            tabla5[x][4] = "";
                            temp = temp.substring(t2.length(), temp.length());
                            break;
                        case 3:
                            tabla5[x][0] = temp.substring(0, t3.length());
                            tabla5[x][1] = "CONSTANTE";
                            tabla5[x][2] = "Integer";
                            tabla5[x][3] = t3;
                            tabla5[x][4] = "";
                            temp = temp.substring(t3.length(), temp.length());
                            break;
                    }
                }
            }
            System.out.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
            for (int x = 0; x < tabla5.length; x++) {
                if (tabla5[x][0] == null) {
                } else {
                    temp2 = " " + (x + 1);
                    System.out.print(temp2.substring(0, 2) + " ");
                }
                for (int y = 0; y < tabla5[x].length; y++) {
                    if (tabla5[x][y] == null) {
                    } else {
                        temp2 = tabla5[x][y] + "                         ";
                        System.out.print(temp2.substring(0, 25));
                    }
                }
                System.out.println("");
            }

            /**
             * ********* ESCRITURA DE ARCHIVO FORMULA 5 ***********
             */
            HashSet hs = new HashSet();
            hs.addAll(eFor5);
            eFor5.clear();
            eFor5.addAll(hs);

            for (Object a : eFor5) {
                Compilador.txtFor5.append(a + "\n");
            }

            try {
                fichero = new FileWriter("C:\\Files\\Formula 5.txt");
                pw = new PrintWriter(fichero);
                pw.println(" # TOKEN                    CATEGORIA                TIPO                     VALOR                    PRIORIDAD");
                for (int x = 0; x < tabla5.length; x++) {
                    if (tabla5[x][0] == null) {
                    } else {
                        temp2 = " " + (x + 1);
                        //System.out.print(temp2.substring(0, 2) + " ");
                        pw.print(temp2.substring(0, 2) + " ");
                    }
                    for (int y = 0; y < tabla5[x].length; y++) {
                        if (tabla5[x][y] == null) {
                        } else {
                            temp2 = tabla5[x][y] + "                         ";
                            //System.out.print(temp2.substring(0, 25));
                            pw.print(temp2.substring(0, 25));
                        }
                    }
                    //System.out.println("");
                    pw.println("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {

                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        }
    }

    public static void calculo(String tipo, String v, String cons1, String cons2, String cons3, String x) {
        int constante1 = Integer.valueOf(cons1);
        int constante2 = Integer.valueOf(cons2);
        int constante3 = Integer.valueOf(cons3);
        int x1 = Integer.valueOf(x);
        int resultanteI = 0;
        float resultanteF = 0;
        List e = new ArrayList();

        if (tipo.equals("Integer")) {
            int v1 = Integer.valueOf(v);
            resultanteI = v1 + constante1 * (constante2 / constante3) + x1;
            System.out.print("Resultado de la formula: " + Integer.toString(resultanteI) + "\n\n");
            Compilador.lbr1.setText("Resultado de la formula: " + Integer.toString(resultanteI));
            Compilador.lbr2.setText("Resultado de la formula: " + Integer.toString(resultanteI));
            Compilador.lbr3.setText("Resultado de la formula: " + Integer.toString(resultanteI));

        } else {
            if (tipo.equals("Real")) {
                float v2 = Float.valueOf(v);
                resultanteF = v2 + constante1 * (constante2 / constante3) + x1;
                System.out.print("Resultado de la formula: " + Float.toString(resultanteF) + "\n\n");
                Compilador.lbr1.setText("Resultado de la formula: " + Float.toString(resultanteF));
                Compilador.lbr2.setText("Resultado de la formula: " + Float.toString(resultanteF));
                Compilador.lbr3.setText("Resultado de la formula: " + Float.toString(resultanteF));

            } else {

                System.out.print("Error: Tipo de variable no permitida \n\n");
                //Compilador.lbFor1.setText("Error: Tipo de variable no permitida");
                eFor1.add("ERROR: TIPO DE VARIABLE NO PERMITIDA");
                eFor2.add("ERROR: TIPO DE VARIABLE NO PERMITIDA");
                eFor3.add("ERROR: TIPO DE VARIABLE NO PERMITIDA");
                eFor4.add("ERROR: TIPO DE VARIABLE NO PERMITIDA");
                eFor5.add("ERROR: TIPO DE VARIABLE NO PERMITIDA");
            }

        }

    }

}
