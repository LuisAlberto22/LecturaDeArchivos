package proyectoempresa;

import java.io.*;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/*Desarrolladores:Luis Alberto Garcia Orozco, Juan Pablo Flores Rivera, Oscar Uriel MOrales Peralta
 *Fecha de entrega:!5/05/2019
 *Nombre del programa:TrueProgram (consulta de registros)
 */
public class principal {

    static String contraseña;
    static int auxIdioma = 1;
    static String usuario;
    static String admin;
    static String errorContraseñaIncorrecta;
    static String textoIntentos = "intentos";
    static String TextoDeIntentosConsumidos = "contraseñaSalida";

    public void cambiar(String dir) {
        //cambia el idioma
        ResourceBundle idioma = ResourceBundle.getBundle(dir);
        errorContraseñaIncorrecta = idioma.getString("contraseñaIncorrecta");
    }

    public static void leerAdmin() throws IOException {
        RandomAccessFile usuarios = new RandomAccessFile("users.dat", "rw");
        char cadena;
        StringBuilder administrador = new StringBuilder();
        //Lee al administrador
        while ((cadena = (char) usuarios.readByte()) != ',') {
            administrador.append(cadena);
        }
        //lo asigna a una variable global para ser usado por todo el programa
        admin = administrador.toString();

    }

    public static void main(String args[]) throws FileNotFoundException, IOException {

        RandomAccessFile cifrado = new RandomAccessFile("cifrado.dat", "rw");
        RandomAccessFile usuarioGuardado = new RandomAccessFile("UsuarioGuardado.dat", "rw");
        RandomAccessFile usuarios = new RandomAccessFile("users.dat", "rw");
        //coloca el puntero para poder empezar a leer
        usuarioGuardado.seek(0);
        cifrado.seek(0);
        usuarios.seek(0);
        //lee si hay algun usuario guardado si lo hay leera una T y si no una F
        char comparar = (char) usuarioGuardado.readByte();
        //verifica si hay usuarios guardados en el programa
        if (usuarios.length() != 0) {
            leerAdmin();
            if (comparar == 'f') {
                //verifica si el archivo esta cifrado
                String verificarCifrado = cifrado.readLine();
                if (verificarCifrado.equalsIgnoreCase("f")) {
                    cifrarContraseñas();
                }
                //abre la ventana de inicio de sesion
                inicioDeSesion ventanaDeInicioDeSesion = new inicioDeSesion();
                ventanaDeInicioDeSesion.setVisible(true);
            } else {
                //coloca el puntero en la posicion 1 para empezar a leer que usuario esta guardado
                usuarioGuardado.seek(1);
                //lo asigna a una variable global para ser utilizado en todo el programa
                usuario = usuarioGuardado.readLine().trim();
                //abre la ventana de Bienvenida
                bienvenido ventanaDeBienvenido = new bienvenido();
                ventanaDeBienvenido.setVisible(true);
            }
        } else {
            //si no hay usuarios registrados abre la pestaña de registro
            pantallaDeRegistro ventanaDeRegistro = new pantallaDeRegistro();
            ventanaDeRegistro.setVisible(true);
        }

    }

    public static String lenguaje() {
        //aqui recibe el idioma al que sera cambiado el programa(viene de los metodos de aleman,chino,ingles y español)
        String idioma = "";
        switch (auxIdioma) {
            //da la direccion de donde esta guardado el lenguaje para mandarla a todos los cambiarLenguaje
            case 1:
                idioma = "Propiedades/Espanol";
                break;
            case 2:
                idioma = "Propiedades/Ingles";
                break;
            case 3:
                idioma = "Propiedades/Aleman";
                break;
            case 4:
                idioma = "Propiedades/Chino";
                break;
        }
        return idioma;
    }

    public static String buscarRegistro(RandomAccessFile archivoIdices, String comparar) throws IOException {//metodo de buscar.
        RandomAccessFile archivo = new RandomAccessFile("siiau2paraAlumnos.dat", "r");
        StringBuilder cadena = new StringBuilder();
        char letra;
        long posicionR;
        int contDeRegistros = 1;
        archivoIdices.seek(0);
        StringBuilder registros = new StringBuilder();
        while (archivoIdices.getFilePointer() != archivoIdices.length()) {
            cadena.delete(0, cadena.length());
            //lee el campo llave
            while ((letra = (char) archivoIdices.readByte()) != '|') {
                cadena.append(letra);
            }
            //aqui obtiene el tipo de busqueda que se modifico en los metodos de Normal,contenga,empiece del menu de busqueda
            switch (menuDeBusqueda.modoDeBusqueda) {
                case "contiene":
                    //lee la posicion
                    posicionR = archivoIdices.readLong();
                    //verifica si la variable esta vacia o no
                    if (comparar.length() > 0) {
                        //verifica que contenga comparar en el campo llave
                        if (cadena.toString().contains(comparar)
                                || cadena.toString().contains(comparar.toUpperCase())) {
                            //pone el puntero en siiau alumons en la posicionR
                            archivo.seek(posicionR);
                            //lee el tamaño
                            int tam = leerElTamaño(archivo);
                            //recoge el registro arrojado por el registro
                            String registro = leerRegistro(archivo, tam);
                            //concatena el registro
                            registros.append(contDeRegistros).append(".- ").append(registro).append("\n");
                            contDeRegistros++;
                        }
                    }
                    break;
                case "empieza":
                    //lee la posicion
                    posicionR = archivoIdices.readLong();
                    //verifica si la variable esta vacia o no
                    if (comparar.length() > 0) {
                        //verifica que empiece comparar en el campo llave
                        if (cadena.toString().startsWith(comparar.toUpperCase())) {
                            //pone el puntero en siiau alumons en la posicionR
                            archivo.seek(posicionR);
                            //lee el tamaño
                            int tam = principal.leerElTamaño(archivo);
                            //recoge el registro arrojado por el registro
                            String registro = leerRegistro(archivo, tam);
                            //concatena el registro
                            registros.append(contDeRegistros).append(".- ").append(registro).append("\n");
                            contDeRegistros++;
                        }
                    }
                    break;
                case "normal":
                    //lee la posicion
                    posicionR = archivoIdices.readLong();
                    //verifica si la variable esta vacia o no
                    if (comparar.length() > 0) {
                        //verifica que empiece comparar en el campo llave
                        if (cadena.toString().equalsIgnoreCase(comparar)) {
                            //pone el puntero en siiau alumons en la posicionR
                            archivo.seek(posicionR);
                            //lee el tamaño
                            int tam = principal.leerElTamaño(archivo);
                            //recoge el registro arrojado por el registro
                            String registro = leerRegistro(archivo, tam);
                            //concatena el registro
                            registros.append(contDeRegistros).append(".- ").append(registro).append("\n");
                            contDeRegistros++;
                        }
                    }
                    break;
            }
        }
        return registros.toString();
    }

    public static int leerElTamaño(RandomAccessFile archivo) throws IOException {
        StringBuilder tam = new StringBuilder();
        char letra = (char) archivo.readByte();
        while (letra != '|') {
            tam.append(letra);
            letra = (char) archivo.readByte();
        }
        return Integer.parseInt(tam.toString());
    }

    public static String leerRegistro(RandomAccessFile archivo, int tam) throws IOException {
        char letra;
        StringBuilder registro = new StringBuilder();
        for (int i = 0; i < tam; i++) {
            letra = (char) archivo.readByte();
            registro.append(letra);
        }
        return registro.toString();
    }

    public static boolean verificarUsuario(String comparar) {
        boolean encontrado = false;
        try {
            RandomAccessFile usuarios = new RandomAccessFile("users.dat", "r");
            StringBuilder cadena = new StringBuilder();
            char caracter;
            //recorre todo el users hasta que encuentre o llegue al final
            while ((!encontrado) && (usuarios.getFilePointer() != usuarios.length())) {
                //concatena lo leido
                while ((caracter = (char) usuarios.readByte()) != '|') {
                    cadena.append(caracter);
                }
                //divide lo leido
                String array[] = cadena.toString().split(",");
                //si el usuario ingresado existe
                if (array[0].equalsIgnoreCase(comparar)) {
                    encontrado = true;
                    //separa la contraseña y el usuario en variables globales que seran utilizadas en todo el programa
                    usuario = array[0];
                    contraseña = array[1];
                } else {
                    //elimina la cadena si no se encontro
                    cadena.delete(0, cadena.length());
                }
            }
        } catch (IOException oe) {

        }
        return encontrado;
    }

    public static void cifrarContraseñas() {
        long dirI, dirF = 0;
        try {
            RandomAccessFile cifrado = new RandomAccessFile("cifrado.dat", "rw");
            RandomAccessFile usuarios = new RandomAccessFile("users.dat", "rw");
            cifrado.seek(0);
            cifrado.writeBytes("t");
            StringBuilder cadena = new StringBuilder();
            char caracter;
            usuarios.seek(0);
            while ((usuarios.getFilePointer() != usuarios.length())) {
                usuarios.seek(dirF);
                while ((usuarios.readByte()) != ',') {
                }
                dirI = usuarios.getFilePointer();
                while ((caracter = (char) usuarios.readByte()) != '|') {
                    cadena.append(caracter);
                }
                dirF = usuarios.getFilePointer();
                for (long i = dirI; i < dirF - 1; i++) {
                    usuarios.seek(i);
                    usuarios.writeByte(0);
                }
                usuarios.seek(dirI);
                String contraseñaParaEscribir = cifradoCesar(cadena.toString());
                cadena.delete(0, cadena.length());
                usuarios.writeBytes(contraseñaParaEscribir);
            }
            for (long i = 0; i < cifrado.length(); i++) {
                cifrado.seek(i);
                cifrado.writeByte(0);
            }
        } catch (IOException oe) {
            System.out.println("error");
        }
    }

    public static String cifradoCesar(String texto) {
        StringBuilder cifrado = new StringBuilder();
        int codigo = 3;
        codigo = codigo % 237;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 33 && texto.charAt(i) <= 237) {
                if ((texto.charAt(i) + codigo) > 237) {
                    cifrado.append((char) (texto.charAt(i) + codigo - 237));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

    static int contDeIntentos = 3;

    public static boolean verificarContraseña(String password) {
        boolean contraseñaCorrecta = false;
        try {
            //crea un objeto de tipo player para reproducir audio
            Player audioError = new Player(new FileInputStream("AudioError.mp3"));
            RandomAccessFile usuarioGuardado = new RandomAccessFile("UsuarioGuardado.dat", "rw");
            //verifica si la contraseña pasada por parametro es igual a la contraseña del usuario
            if (contraseña.equals(password)) {
                //reinicia el contador de intentos
                contDeIntentos = 3;
                contraseñaCorrecta = true;
                usuarioGuardado.seek(1);
                //escribe el usuario logeado
                usuarioGuardado.writeBytes(usuario.trim());
                usuarioGuardado.setLength(usuarioGuardado.getFilePointer());
            } else {
                audioError.play();
                JOptionPane.showMessageDialog(null, errorContraseñaIncorrecta + "  " + (contDeIntentos - 1) + "  "
                        + "  " + textoIntentos, "", 0, null);
                contDeIntentos--;
            }
            if (contDeIntentos == 0) {
                JOptionPane.showMessageDialog(null, TextoDeIntentosConsumidos, "", 0, null);
                //cierra el programa
                System.exit(0);
            }
        } catch (JavaLayerException | FileNotFoundException eo) {
            System.out.println("Error en verificar contraseña");
        } catch (IOException eo) {
            System.out.println("Error en verificar contraseña");
        }
        return contraseñaCorrecta;
    }
}
