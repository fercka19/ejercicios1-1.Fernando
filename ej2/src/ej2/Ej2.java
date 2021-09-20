/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //crearFicherosIO();
      
     String rut;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce ruta");
        rut = teclado.nextLine();
  
         listarDirectorios(rut);
       
       BorrarFicherosDirectorios();
        crearFicherosNIO();
        System.out.println("introduce ruta : ");
        String path = teclado.nextLine();
        
        infoFicheroIO(path);
        infoFicheroNIO(path);
       pruebasRutas01(System.getProperty("user.Fernando")+"\\fotos" ); 
        pruebasRutas02( );
    }
       public static void  listarDirectorios (String rut){

         
       
        File f = new File(rut);

        if( f.exists() && f.isDirectory()){
            String [] rutas = f.list();
            
            for(int i = 0; i<=rutas.length-1;i++){
                System.out.println(rutas[i]);
            }
        }else{
             System.out.println("no existe el directorio u no es un directorio.");
        }
        

    
    }
    

    public static void crearFicherosIO() throws IOException{
        File dir = new File("C://NUEVODIR//");
        File fich = new File("C://NUEVODIR//FICHERO1.TXT");
       File fich2 = new File("C://NUEVODIR//FICHERO2.TXT");
         if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
            
         }else{
              System.out.println("El directorio ya existe");
         }
           if (!fich.exists()) {
            if (fich.createNewFile()) {
                System.out.println("fichero creado");
            } else {
                System.out.println("Error al crear fichero");
            }
         }else{
                System.out.println("El fichero ya existe");
           }
            if (!fich2.exists()) {
            if (fich2.createNewFile()) {
                System.out.println("fichero creado");
            } else {
                System.out.println("Error al crear fichero");
            }
         }else{
                System.out.println("El fichero ya existe");
           }
          
        
    }
    public static void crearFicherosNIO() throws IOException{
 try {

    Path path = Paths.get("C:/NUEVODIR");

    if(!Files.exists(path)){
    Files.createDirectories(path);

    System.out.println("Directory creado");
    }else{
        System.out.println("el directorio ya esta creado");
    }
   

       Path p5 = Paths.get("C:/NUEVODIR/FICHERO1.TXT");
        if(!Files.exists(p5)){
            System.out.println("estoy");;
           p5 =Files.createFile(Paths.get("C:/NUEVODIR/FICHERO1.TXT"));
           
        System.out.println(p5);;
        }
         } catch (IOException e) {

    System.err.println("error!");

  }
      
    }
        public static void BorrarFicherosDirectorios() throws IOException{
            //borrado en cascada, si no elimino primero los ficheros no me deja borrar el directorio
            try{
       File dir = new File("C://NUEVODIR");
       File fich = new File("C://NUEVODIR//FICHERO1.TXT");
       File fich2 = new File("C://NUEVODIR//FICHERO2.TXT");
       
       fich.delete();
        fich2.delete();
        dir.delete();
       System.out.println(dir);;
       
     if(dir.exists()){
         System.out.println("Error no se ha podido eliminar el  archivo");
     }else{
          System.out.println("Se ha eliminado el archivo exitosamente");
     }
          }catch(Exception e){

           System.out.println(e);

        }
    }
        public static void infoFicheroIO(String path) throws IOException{
           File f = new File(path);
           System.out.println("Nombre del fichero  :"+f.getName());
           System.out.println("Ruta                :"+f.getPath());
           System.out.println("Ruta absoluta       :"+f.getAbsolutePath());
           System.out.println("Se puede leer       :"+f.canRead());
           System.out.println("Se puede escribir   :"+f.canWrite());
           System.out.println("Tamaño              :"+f.length());
           System.out.println("Es un directorio    :"+f.isDirectory());
           System.out.println("Es un fichero       :"+f.isFile());
           
        }
                public static void infoFicheroNIO(String path) throws IOException{
            
           Path f = Paths.get(path);
           System.out.println("Elemnto en posicion raiz  :"+f.getName(0));
           System.out.println("Nombre fichero            :"+f.getFileName());
           System.out.println("Num elementos ruta        :"+f.getNameCount());
           System.out.println("Secuencia de la ruta      :"+f.subpath(0,1));
           System.out.println("Devuelva la ruta del dir padre   :"+f.getParent());
           System.out.println("Raiz de la ruta           :"+f.getRoot());
           System.out.println("Ruta                      :"+f.toString());
           
        }
              static void pruebasRutas01(String fichero){
           Path path = Paths.get(fichero);            	

            	
            	  System.out.format("toString: %s%n", path.toString());
            	  System.out.format("getFileName: %s%n", path.getFileName());
            	  System.out.format("getName(0): %s%n", path.getName(0));
            	  System.out.format("getNameCount: %d%n", path.getNameCount());
            	  System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
            	  System.out.format("getParent: %s%n", path.getParent());
            	  System.out.format("getRoot: %s%n", path.getRoot());
                }
              static void pruebasRutas02() throws IOException{
                  
                  Path pa = Paths.get(System.getProperty("user.home"),"..","logs", "foo.log");
                   System.out.println(pa.toAbsolutePath());
                   System.out.println("Formato de ruta original:"+pa.toAbsolutePath());
                   System.out.println("Después de ejecutar el método normalize ():"+pa.toAbsolutePath().normalize());
             
              }
}
