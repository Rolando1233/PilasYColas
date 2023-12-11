
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.File;

public class Files {
    public int contarLineas(String name){
        File archivo; //apuntar a un archivo fisico en el disco duro
        FileReader reader; //para abrir el archivo 
        BufferedReader bufer; //para leer la info del archivo
        int numLineas = 0;


        try{
            archivo = new File("C:\\archivos\\" + name+ ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            while((bufer.readLine()) != null){
                numLineas++;
            } 
            reader.close();

        }catch ( Exception e){
            System.out.println("Error al abrir/leer el archivo: " + e.toString());
        }
        return numLineas;

    }
    //Metodo que lee un archivo de texto plano
    // y almacena cada linea en un arreglo de estring
    public  String[] archivoAStrings(String name){
        File archivo; //apuntar a un archivo fisico en el disco duro
        FileReader reader; //para abrir el archivo 
        BufferedReader bufer; //para leer la info del archivo
        String linea;
        String[] arreglo = null;
        int t; // tamaño del archivo
        int i=0;

        try{
            //Saber cuantas lineas tiene el archivo
            t = contarLineas(name);
            // Construir el arreglo con el valor t
            arreglo = new String[t];
            //Crea el apuntador al archivo fisico
            archivo = new File("C:\\archivos\\" + name+ ".txt");
            //Abrir el archivo 
            reader = new FileReader(archivo);
            //Confifurar el bufer para hacer la lectura
            bufer = new BufferedReader(reader);
            //Lectura de la imformacion del archivo
            while((linea=bufer.readLine()) != null){
                arreglo[i] = linea;
                i++;
               // System.out.println("Linea del archivo: " + linea);
            } 
            reader.close();

        }catch ( Exception e){
            System.out.println("Error al abrir/leer el archivo: " + e.toString());
        }
        return arreglo;
    }

     //Metodo que lee un archivo de texto plano
    // y almacena cada linea en un arreglo de int
    public  int[] archivoAint(String name){
        File archivo; //apuntar a un archivo fisico en el disco duro
        FileReader reader; //para abrir el archivo 
        BufferedReader bufer; //para leer la info del archivo
        String linea;
        int[] arreglo = null;
        int t; // tamaño del archivo
        int i=0;

        try{
            //Saber cuantas lineas tiene el archivo
            t = contarLineas(name);
            // Construir el arreglo con el valor t
            arreglo = new int[t];
            //Crea el apuntador al archivo fisico
            archivo = new File("C:\\archivos\\" + name+ ".txt");
            //Abrir el archivo 
            reader = new FileReader(archivo);
            //Confifurar el bufer para hacer la lectura
            bufer = new BufferedReader(reader);
            //Lectura de la imformacion del archivo
            while((linea=bufer.readLine()) != null){
                arreglo[i] = Integer.parseInt(linea);
                i++;
               // System.out.println("Linea del archivo: " + linea);
            } 
            reader.close();

        }catch ( Exception e){
            System.out.println("Error al abrir/leer el archivo: " + e.toString());
        }
        return arreglo;
    }

    public void escribirarchivo(String name){
        //Apuntar a la seccion del dd donde se crea el archivo
        FileWriter archivo;
        //llave para tener acceso al modo escritura
        PrintWriter writer;
        //para leer datos del teclado
        BufferedReader bufer = new BufferedReader(
            new InputStreamReader(System.in));
            String entrada;
            char respuesta;

            try{
                archivo= new FileWriter("C:\\archivos\\" 
                + name + ".txt");
                writer = new PrintWriter(archivo);
                do{
                    System.out.println("Escribe datos para el archivo:  ");
                    entrada = bufer.readLine();
                    writer.println(entrada);
                    System.out.println("Escribe x para parar: ");
                    entrada = bufer.readLine();
                    respuesta = entrada.charAt(0);
                }while(respuesta != 'x');
                archivo.close();
            }catch(Exception e){
                System.out.println("Error al crear el archivo");
            }
    }

       public static void arregloAarchivo(String name, int[] array){
       
        FileWriter archivo;
        PrintWriter writer;


            try{
                archivo= new FileWriter("C:\\archivos\\" 
                + name + ".txt");
                writer = new PrintWriter(archivo);
                for(int unDat: array){
                    writer.println(unDat);
                }
                archivo.close();
            }catch(Exception e){
                System.out.println("Error al crear el archivo");
            }
    }
}
