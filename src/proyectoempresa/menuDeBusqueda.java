/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresa;

import java.awt.Desktop;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *Desarrolladores:Luis Alberto Garcia Orozco, Juan Pablo Flores Rivera, Oscar Uriel MOrales Peralta
 *Fecha de entrega:!5/05/2019
 *Nombre del programa:TrueProgram (consulta de registros)
 */
public class menuDeBusqueda extends javax.swing.JFrame {

    String llaveDeLenguaje = "normal";
    String buscarpor = "Apellidos";
    String usuario = "Usuario Creado";
    String noCoinciden = "Contraseñas No son";
    String usuarioInvalido;
    String usuarioUsado = "Usuario ya Registrado";
    String noIngresada = "Contraseña No Ingresada";
    String noencontrado = "no encontrado";
    String errorPrivilegios = "error privilegios";
    String contraseñaInvalida;
    static String modoDeBusqueda = "normal";
    public RandomAccessFile archivoIndices;
    public static long posicion;

    public void foto() {
        try {
            RandomAccessFile usuarios = new RandomAccessFile("users.dat", "rw");
            StringBuilder cadena = new StringBuilder();
            char caracter;
            boolean encontrado = false;
            usuarios.seek(0);
            while ((!encontrado) && (usuarios.getFilePointer() != usuarios.length())) {
                while ((caracter = (char) usuarios.readByte()) != '|') {
                    cadena.append(caracter);
                }
                String Array[] = cadena.toString().split(",");
                if (Array[0].equalsIgnoreCase(principal.usuario.trim())) {//encuentra al usuario
                    encontrado = true;
                    cadena.delete(0, cadena.length());
                    posicion = usuarios.getFilePointer();
                    while ((caracter = (char) usuarios.readByte()) != '|') {//Lee la foto
                        cadena.append(caracter);
                    }
                } else {
                    cadena.delete(0, cadena.length());
                }
            }
            //coloca la foto
            String logo = cadena.toString().trim();
            Icon icon = new ImageIcon(getClass().getResource(logo));
            fotodeusuario.setIcon(icon);
        } catch (IOException oe) {

        }
    }

    public menuDeBusqueda() {
        initComponents();
        foto();
        //coloca la posicion de la ventana
        this.setLocationRelativeTo(null);
        //hace visible el menu
        setInvisibles();
        setVisiblesMenuBusqueda();
        //aplica el icono del programa en la barra de tareas
        Image icon = new ImageIcon(getClass().getResource("/Imagen/LogoBien.png")).getImage();
        setIconImage(icon);
        //cambia el lenguaje
        cambiarLenguaje(principal.lenguaje());
    }

    public void cambiarLenguaje(String dir) {
        //cambia el idioma
        ResourceBundle obj = ResourceBundle.getBundle(dir);
        errorPrivilegios = obj.getString("errorprivilegios");
        buscarPorApellidos.setText(obj.getString("buscarporapellidos"));
        buscarPorNombre.setText(obj.getString("buscarpornombre"));
        buscarPorClave.setText(obj.getString("buscarporclave"));
        buscarPorMateria.setText(obj.getString("buscarpormateria"));
        buscarporCrn.setText(obj.getString("buscarporcrn"));
        crearUsuario.setText(obj.getString("crearusuario"));
        volverMenuBuscar.setText(obj.getString("volver"));
        volverMenuCrear.setText(obj.getString("volver"));
        aceptar.setText(obj.getString("Aceptar"));
        aceptarbuscar.setText(obj.getString("Aceptar"));
        usuariotext1.setText(obj.getString("Usuario:"));
        confirmarcontra.setText(obj.getString("confiramarcontraseña"));
        contraseñatext.setText(obj.getString("Contraseña:"));
        tituloRegistros.setText(obj.getString("registrosencontrados"));
        tituloTexto.setText(obj.getString("Buscarpor") + " " + obj.getString(buscarpor));
        usuario = obj.getString("UsuarioCreado");
        noCoinciden = obj.getString("ContraseñasNoson");
        contraseñaInvalida = obj.getString("contraseñainvalida");
        usuarioUsado = obj.getString("UsuarioyaRegistrado");
        noIngresada = obj.getString("ContraseñaNoIngresada");
        noencontrado = obj.getString("noencontrado");
        español.setText(obj.getString("Espanol"));
        ingles.setText(obj.getString("Ingles"));
        aleman.setText(obj.getString("Aleman"));
        chino.setText(obj.getString("Chino"));
        idioma.setText(obj.getString("Idioma"));
        usuarioInvalido = obj.getString("usuarioinvalido");
        salir.setText(obj.getString("Salir"));
        ayuda.setText(obj.getString("ayuda"));
        paginaDeSoporte.setText(obj.getString("pagina"));
        numeroDeTelefono.setText(obj.getString("numero"));
        modoDeBusquedaM.setText(obj.getString("modo"));
        empieza.setText(obj.getString("empieza"));
        contenga.setText(obj.getString("contenga"));
        normal.setText(obj.getString("normal"));
        cambiarUsuario.setText(obj.getString("cambiar"));
        eliminarUsuario.setText(obj.getString("eliminar"));
        textoModo.setText(obj.getString(llaveDeLenguaje));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eliminarUsuario = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        buscarporCrn = new javax.swing.JButton();
        cambiarUsuario = new javax.swing.JButton();
        tituloTexto = new javax.swing.JLabel();
        tituloRegistros = new javax.swing.JLabel();
        ingresarTexto = new javax.swing.JTextField();
        crearUsuario = new javax.swing.JButton();
        buscarPorClave = new javax.swing.JButton();
        buscarPorMateria = new javax.swing.JButton();
        buscarPorNombre = new javax.swing.JButton();
        buscarPorApellidos = new javax.swing.JButton();
        usuarioNuevo = new javax.swing.JTextField();
        contraseña = new javax.swing.JTextField();
        confirmarcontra = new javax.swing.JLabel();
        contraseñatext = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        PasswordDelNuevoUsuario = new javax.swing.JPasswordField();
        usuariotext1 = new javax.swing.JLabel();
        aceptarbuscar = new javax.swing.JButton();
        volverMenuBuscar = new javax.swing.JButton();
        volverMenuCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        visualizar = new javax.swing.JTextArea();
        facebook = new javax.swing.JLabel();
        textoModo = new javax.swing.JLabel();
        fotodeusuario = new javax.swing.JLabel();
        nombreusuario = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        idioma = new javax.swing.JMenu();
        español = new javax.swing.JMenuItem();
        ingles = new javax.swing.JMenuItem();
        aleman = new javax.swing.JMenuItem();
        chino = new javax.swing.JMenuItem();
        modoDeBusquedaM = new javax.swing.JMenu();
        contenga = new javax.swing.JMenuItem();
        empieza = new javax.swing.JMenuItem();
        normal = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        paginaDeSoporte = new javax.swing.JMenuItem();
        numeroDeTelefono = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TrueProgram    "+"("+principal.usuario+")");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 440, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eliminarUsuario.setBackground(new java.awt.Color(51, 51, 51));
        eliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        eliminarUsuario.setText("Eliminar Usuario");
        eliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 140, 30));

        salir.setBackground(new java.awt.Color(51, 51, 51));
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 70, 30));

        buscarporCrn.setBackground(new java.awt.Color(51, 51, 51));
        buscarporCrn.setForeground(new java.awt.Color(255, 255, 255));
        buscarporCrn.setText("Buscar por CRN");
        buscarporCrn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarporCrnActionPerformed(evt);
            }
        });
        getContentPane().add(buscarporCrn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 270, 50));

        cambiarUsuario.setBackground(new java.awt.Color(51, 51, 51));
        cambiarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        cambiarUsuario.setText("Cambiar Usuario");
        cambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(cambiarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 160, 30));

        tituloTexto.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tituloTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 340, 40));

        tituloRegistros.setForeground(new java.awt.Color(255, 255, 255));
        tituloRegistros.setText("Registros encontrados:\n");
        getContentPane().add(tituloRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 340, 40));

        ingresarTexto.setBackground(new java.awt.Color(51, 51, 51));
        ingresarTexto.setForeground(new java.awt.Color(255, 255, 255));
        ingresarTexto.setCaretColor(new java.awt.Color(255, 255, 255));
        ingresarTexto.setSelectedTextColor(new java.awt.Color(0, 0, 102));
        ingresarTexto.setSelectionColor(new java.awt.Color(255, 255, 255));
        ingresarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarTextoActionPerformed(evt);
            }
        });
        getContentPane().add(ingresarTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 340, 40));

        crearUsuario.setBackground(new java.awt.Color(51, 51, 51));
        crearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        crearUsuario.setText("Crear Usuario");
        crearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(crearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 140, 40));

        buscarPorClave.setBackground(new java.awt.Color(51, 51, 51));
        buscarPorClave.setForeground(new java.awt.Color(255, 255, 255));
        buscarPorClave.setText("Buscar por CLAVE");
        buscarPorClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorClaveActionPerformed(evt);
            }
        });
        getContentPane().add(buscarPorClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 400, 50));

        buscarPorMateria.setBackground(new java.awt.Color(51, 51, 51));
        buscarPorMateria.setForeground(new java.awt.Color(255, 255, 255));
        buscarPorMateria.setText("Buscar por MATERIA");
        buscarPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorMateriaActionPerformed(evt);
            }
        });
        getContentPane().add(buscarPorMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 400, 50));

        buscarPorNombre.setBackground(new java.awt.Color(51, 51, 51));
        buscarPorNombre.setForeground(new java.awt.Color(255, 255, 255));
        buscarPorNombre.setText("Buscar por NOMBRE");
        buscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorNombreActionPerformed(evt);
            }
        });
        getContentPane().add(buscarPorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 270, 50));

        buscarPorApellidos.setBackground(new java.awt.Color(51, 51, 51));
        buscarPorApellidos.setForeground(new java.awt.Color(255, 255, 255));
        buscarPorApellidos.setText("Buscar por APELLIDOS");
        buscarPorApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorApellidosActionPerformed(evt);
            }
        });
        getContentPane().add(buscarPorApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 400, 50));

        usuarioNuevo.setBackground(new java.awt.Color(51, 51, 51));
        usuarioNuevo.setForeground(new java.awt.Color(255, 255, 255));
        usuarioNuevo.setCaretColor(new java.awt.Color(255, 255, 255));
        usuarioNuevo.setSelectedTextColor(new java.awt.Color(0, 0, 102));
        usuarioNuevo.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(usuarioNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 84, 289, 50));

        contraseña.setBackground(new java.awt.Color(51, 51, 51));
        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        contraseña.setCaretColor(new java.awt.Color(255, 255, 255));
        contraseña.setSelectedTextColor(new java.awt.Color(0, 0, 102));
        contraseña.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 154, 289, 50));

        confirmarcontra.setForeground(new java.awt.Color(255, 255, 255));
        confirmarcontra.setText("Confirmar contraseña:");
        getContentPane().add(confirmarcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 167, 50));

        contraseñatext.setForeground(new java.awt.Color(255, 255, 255));
        contraseñatext.setText("contraseña :");
        getContentPane().add(contraseñatext, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 167, 50));

        aceptar.setBackground(new java.awt.Color(51, 51, 51));
        aceptar.setForeground(new java.awt.Color(255, 255, 255));
        aceptar.setText("aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 353, 86, 30));

        PasswordDelNuevoUsuario.setBackground(new java.awt.Color(51, 51, 51));
        PasswordDelNuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        PasswordDelNuevoUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        PasswordDelNuevoUsuario.setSelectedTextColor(new java.awt.Color(0, 0, 102));
        PasswordDelNuevoUsuario.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(PasswordDelNuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 290, 50));

        usuariotext1.setForeground(new java.awt.Color(255, 255, 255));
        usuariotext1.setText("Usuario :");
        getContentPane().add(usuariotext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 84, 167, 50));

        aceptarbuscar.setBackground(new java.awt.Color(51, 51, 51));
        aceptarbuscar.setForeground(new java.awt.Color(255, 255, 255));
        aceptarbuscar.setText("aceptar");
        aceptarbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 3, 90, 30));

        volverMenuBuscar.setBackground(new java.awt.Color(51, 51, 51));
        volverMenuBuscar.setForeground(new java.awt.Color(255, 255, 255));
        volverMenuBuscar.setText("volver");
        volverMenuBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(volverMenuBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3, 90, 30));

        volverMenuCrear.setBackground(new java.awt.Color(51, 51, 51));
        volverMenuCrear.setForeground(new java.awt.Color(255, 255, 255));
        volverMenuCrear.setText("volver");
        volverMenuCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuCrearActionPerformed(evt);
            }
        });
        getContentPane().add(volverMenuCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 353, -1, 30));

        visualizar.setEditable(false);
        visualizar.setBackground(new java.awt.Color(51, 51, 51));
        visualizar.setColumns(50);
        visualizar.setForeground(new java.awt.Color(255, 255, 255));
        visualizar.setRows(5);
        visualizar.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setViewportView(visualizar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 440, 200));

        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/facebook.png"))); // NOI18N
        facebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                facebookMousePressed(evt);
            }
        });
        getContentPane().add(facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, 70));

        textoModo.setForeground(new java.awt.Color(255, 255, 255));
        textoModo.setText("jLabel1");
        getContentPane().add(textoModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 140, 30));

        fotodeusuario.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(51, 51, 51)));
        fotodeusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cambiarfoto(evt);
            }
        });
        getContentPane().add(fotodeusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 120));

        nombreusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreusuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreusuario.setText(principal.usuario);
        nombreusuario.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(51, 51, 51)));
        getContentPane().add(nombreusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 30));

        fondo.setBackground(new java.awt.Color(51, 51, 255));
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondoFlecha.jpg"))); // NOI18N
        fondo.setFocusable(false);
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 420));

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setBorder(null);
        menu.setForeground(new java.awt.Color(255, 255, 255));

        idioma.setBackground(new java.awt.Color(0, 0, 0));
        idioma.setForeground(new java.awt.Color(255, 255, 255));
        idioma.setText("Idioma");

        español.setBackground(new java.awt.Color(0, 0, 0));
        español.setForeground(new java.awt.Color(255, 255, 255));
        español.setText("Español");
        español.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                españolActionPerformed(evt);
            }
        });
        idioma.add(español);

        ingles.setBackground(new java.awt.Color(0, 0, 0));
        ingles.setForeground(new java.awt.Color(255, 255, 255));
        ingles.setText("Inglés");
        ingles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesActionPerformed(evt);
            }
        });
        idioma.add(ingles);

        aleman.setBackground(new java.awt.Color(0, 0, 0));
        aleman.setForeground(new java.awt.Color(255, 255, 255));
        aleman.setText("Aleman");
        aleman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alemanActionPerformed(evt);
            }
        });
        idioma.add(aleman);

        chino.setBackground(new java.awt.Color(0, 0, 0));
        chino.setForeground(new java.awt.Color(255, 255, 255));
        chino.setText("Chino");
        chino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinoActionPerformed(evt);
            }
        });
        idioma.add(chino);

        menu.add(idioma);

        modoDeBusquedaM.setBackground(new java.awt.Color(0, 0, 0));
        modoDeBusquedaM.setForeground(new java.awt.Color(255, 255, 255));
        modoDeBusquedaM.setText("Modo de Busqueda");

        contenga.setBackground(new java.awt.Color(0, 0, 0));
        contenga.setForeground(new java.awt.Color(255, 255, 255));
        contenga.setText("Contenga");
        contenga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contengaActionPerformed(evt);
            }
        });
        modoDeBusquedaM.add(contenga);

        empieza.setBackground(new java.awt.Color(0, 0, 0));
        empieza.setForeground(new java.awt.Color(255, 255, 255));
        empieza.setText("Empiece");
        empieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empiezaActionPerformed(evt);
            }
        });
        modoDeBusquedaM.add(empieza);

        normal.setBackground(new java.awt.Color(0, 0, 0));
        normal.setForeground(new java.awt.Color(255, 255, 255));
        normal.setText("Normal");
        normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalActionPerformed(evt);
            }
        });
        modoDeBusquedaM.add(normal);

        menu.add(modoDeBusquedaM);

        ayuda.setBackground(new java.awt.Color(0, 0, 0));
        ayuda.setForeground(new java.awt.Color(255, 255, 255));
        ayuda.setText("Ayuda");

        paginaDeSoporte.setBackground(new java.awt.Color(0, 0, 0));
        paginaDeSoporte.setForeground(new java.awt.Color(255, 255, 255));
        paginaDeSoporte.setText("Pagina de soporte");
        paginaDeSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paginaDeSoporteActionPerformed(evt);
            }
        });
        ayuda.add(paginaDeSoporte);

        numeroDeTelefono.setBackground(new java.awt.Color(0, 0, 0));
        numeroDeTelefono.setForeground(new java.awt.Color(255, 255, 255));
        numeroDeTelefono.setText("Numero de soporte");
        numeroDeTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroDeTelefonoActionPerformed(evt);
            }
        });
        ayuda.add(numeroDeTelefono);

        menu.add(ayuda);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setInvisibles() {
        textoModo.setVisible(false);
        tituloTexto.setVisible(false);
        tituloRegistros.setVisible(false);
        ingresarTexto.setVisible(false);
        crearUsuario.setVisible(false);
        buscarporCrn.setVisible(false);
        buscarPorClave.setVisible(false);
        buscarPorMateria.setVisible(false);
        buscarPorApellidos.setVisible(false);
        buscarPorNombre.setVisible(false);
        usuarioNuevo.setVisible(false);
        contraseña.setVisible(false);
        confirmarcontra.setVisible(false);
        contraseñatext.setVisible(false);
        aceptar.setVisible(false);
        PasswordDelNuevoUsuario.setVisible(false);
        usuariotext1.setVisible(false);
        aceptarbuscar.setVisible(false);
        volverMenuBuscar.setVisible(false);
        volverMenuCrear.setVisible(false);
        jScrollPane1.setVisible(false);
        facebook.setVisible(false);
        fondo.setVisible(false);
        cambiarUsuario.setVisible(false);
        salir.setVisible(false);
        eliminarUsuario.setVisible(false);
        fotodeusuario.setVisible(false);
        nombreusuario.setVisible(false);
    }

    public void setVisiblesMenuBusqueda() {
        buscarPorMateria.setVisible(true);
        crearUsuario.setVisible(true);
        contraseñatext.setVisible(false);
        buscarPorClave.setVisible(true);
        buscarPorApellidos.setVisible(true);
        buscarPorNombre.setVisible(true);
        buscarporCrn.setVisible(true);
        facebook.setVisible(true);
        fondo.setVisible(true);
        cambiarUsuario.setVisible(true);
        eliminarUsuario.setVisible(true);
        salir.setVisible(true);
        fotodeusuario.setVisible(true);
        nombreusuario.setVisible(true);
    }

    public void setVisibleBoton() {
        tituloRegistros.setVisible(true);
        tituloTexto.setVisible(true);
        jScrollPane1.setVisible(true);
        ingresarTexto.setVisible(true);
        aceptarbuscar.setVisible(true);
        volverMenuBuscar.setVisible(true);
        fondo.setVisible(true);
        textoModo.setVisible(true);
        fotodeusuario.setVisible(false);
        nombreusuario.setVisible(false);
    }

    public void setVisibleCrearUsuario() {
        volverMenuCrear.setVisible(true);
        usuariotext1.setVisible(true);
        usuarioNuevo.setVisible(true);
        contraseña.setVisible(true);
        PasswordDelNuevoUsuario.setVisible(true);
        aceptar.setVisible(true);
        confirmarcontra.setVisible(true);
        contraseñatext.setVisible(true);
        fondo.setVisible(true);
        fotodeusuario.setVisible(false);
        nombreusuario.setVisible(false);
    }

    private void crearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioActionPerformed
        if (principal.usuario.equalsIgnoreCase(principal.admin)) {//verifica si es administrador.
            setInvisibles();
            setVisibleCrearUsuario();
        } else {
            JOptionPane.showMessageDialog(null, errorPrivilegios, "TrueProgram", 0, null);
        }
    }//GEN-LAST:event_crearUsuarioActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            //crear usuario.
            Icon icon = new ImageIcon(getClass().getResource("/Imagen/LogoBien.png"));
            RandomAccessFile usuarios = new RandomAccessFile("users.dat", "rw");
            Player audioError = new Player(new FileInputStream("AudioError.mp3"));
            long pos = usuarios.length();
            usuarios.seek(pos);
            char[] array = PasswordDelNuevoUsuario.getPassword();
            String passwordSin = new String(array);
            //busca si ya existe un usuario con ese nombre
            if (!principal.verificarUsuario(usuarioNuevo.getText())) {
                if (!usuarioNuevo.getText().isEmpty() && !usuarioNuevo.getText().startsWith(" ")) {//busca si ya existe un usuario con ese nombre
                    //verifica que las 2 contraseñas sean iguales
                    if (!contraseña.getText().contains(" ")) {
                        if (passwordSin.equals(contraseña.getText())) {
                            //verifica que el campo de contraseñas no este vacio
                            if (!contraseña.getText().equals("")) {
                                usuarios.writeBytes(usuarioNuevo.getText().trim() + ",");
                                String contraseñacifrada;
                                //cifra la contraseña
                                contraseñacifrada = principal.cifradoCesar(contraseña.getText().trim());
                                //Escribe el nuevo usuario en users.dat
                                usuarios.writeBytes(contraseñacifrada + "|");
                                usuarios.writeBytes("/Imagen/Usuario.png" + "|");
                                usuarios.close();
                                //cambia a menu principal
                                setInvisibles();
                                setVisiblesMenuBusqueda();
                                JOptionPane.showMessageDialog(null, usuario + ":  '" + usuarioNuevo.getText() + "'", "TrueProgram", 0, icon);
                            } else {
                                audioError.play();
                                JOptionPane.showMessageDialog(null, noIngresada, "TrueProgram", 0, null);
                            }
                        } else {
                            audioError.play();
                            JOptionPane.showMessageDialog(null, noCoinciden, "TrueProgram", 0, null);
                        }
                    } else {
                        audioError.play();
                        JOptionPane.showMessageDialog(null, contraseñaInvalida, "TrueProgram", 0, null);
                    }
                } else {
                    audioError.play();
                    JOptionPane.showMessageDialog(null, usuarioInvalido, "TrueProgram", 0, null);
                }
            } else {
                audioError.play();
                JOptionPane.showMessageDialog(null, usuarioUsado, "TrueProgram", 0, null);
            }
        } catch (IOException | JavaLayerException eo) {
            System.out.println("Error en crear usuario");
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void buscarPorClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorClaveActionPerformed
        try {
            //busca por clave
            RandomAccessFile claveIndice = new RandomAccessFile("claveIndice.txt", "r");
            //hace visible las opciones de buscar registros
            setInvisibles();
            setVisibleBoton();
            //pasa el randomaccessfile para poder ser procesado en buscar registros(Principal)
            archivoIndices = claveIndice;
            //crea la llave para el metodo cambiar
            buscarpor = "Clave";
            //cambia el lenguaje
            cambiarLenguaje(principal.lenguaje());
            facebook.setVisible(false);
        } catch (IOException io) {

        }
    }//GEN-LAST:event_buscarPorClaveActionPerformed

    private void ingresarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarTextoActionPerformed
        //Llama al metodo de aceptar buscar(registros)
        aceptarbuscarActionPerformed(null);
    }//GEN-LAST:event_ingresarTextoActionPerformed

    private void aceptarbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarbuscarActionPerformed
        String cadena;
        try {
            //llama a buscar registro con la variable randomaccessfile y el texto ingresado en la pantalla
            cadena = principal.buscarRegistro(archivoIndices, ingresarTexto.getText());
            //verifica si la cadena esta vacia.
            if (!cadena.isEmpty()) {
                visualizar.setText(cadena);
            } else {
                visualizar.setText(noencontrado);
            }
        } catch (IOException io) {
            JOptionPane.showInternalMessageDialog(null, "error");
        }
    }//GEN-LAST:event_aceptarbuscarActionPerformed

    private void volverMenuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuBuscarActionPerformed
        //vuelve al menu de busqueda
        setInvisibles();
        setVisiblesMenuBusqueda();
        //vacia los campos
        visualizar.setText("");
        ingresarTexto.setText("");
        facebook.setVisible(true);
    }//GEN-LAST:event_volverMenuBuscarActionPerformed

    private void volverMenuCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuCrearActionPerformed
        //vuelve al menu de busqueda
        setInvisibles();
        setVisiblesMenuBusqueda();
    }//GEN-LAST:event_volverMenuCrearActionPerformed

    private void españolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_españolActionPerformed
        //cambia el idioma de todo el programa
        cambiarLenguaje("Propiedades/Espanol");
        principal.auxIdioma = 1;
    }//GEN-LAST:event_españolActionPerformed

    private void inglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesActionPerformed
        //cambia el idioma de todo el programa
        cambiarLenguaje("Propiedades/Ingles");
        principal.auxIdioma = 2;
    }//GEN-LAST:event_inglesActionPerformed

    private void alemanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alemanActionPerformed
        //cambia el idioma de todo el programa
        cambiarLenguaje("Propiedades/Aleman");
        principal.auxIdioma = 3;
    }//GEN-LAST:event_alemanActionPerformed

    private void chinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinoActionPerformed
        //cambia el idioma de todo el programa
        cambiarLenguaje("Propiedades/Chino");
        principal.auxIdioma = 4;
    }//GEN-LAST:event_chinoActionPerformed

    private void facebookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facebookMousePressed
        try {
            //crea una variable de tipo URI
            java.net.URI uri = new java.net.URI("https://facebook.com/TrueProgram-834906380223146/");
            //abre la URI
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException or) {
            System.out.println("Error En boton facebook");
        }
    }//GEN-LAST:event_facebookMousePressed

    private void buscarPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorMateriaActionPerformed
        try {
            RandomAccessFile materiaIndice = new RandomAccessFile("materiaIndice.txt", "r");
            //hace visible las opciones de buscar registros
            setInvisibles();
            setVisibleBoton();
            //pasa el randomaccessfile para poder ser procesado en buscar registros(Principal)
            archivoIndices = materiaIndice;
            //crea la llave para el metodo cambiar
            buscarpor = "Materia";
            //cambia el lenguaje
            cambiarLenguaje(principal.lenguaje());
        } catch (IOException io) {
            System.out.println("Error en BuscarporMateria");
        }
    }//GEN-LAST:event_buscarPorMateriaActionPerformed

    private void buscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorNombreActionPerformed
        try {
            RandomAccessFile nombreIndice = new RandomAccessFile("nombreIndice.txt", "r");
            //hace visible las opciones de buscar registros
            setInvisibles();
            setVisibleBoton();
            //pasa el randomaccessfile para poder ser procesado en buscar registros(Principal)
            archivoIndices = nombreIndice;
            //crea la llave para el metodo cambiar
            buscarpor = "Nombre";
            //cambia el lenguaje
            cambiarLenguaje(principal.lenguaje());
        } catch (IOException io) {
            System.out.println("Error en BuscarporNombre");
        }
    }//GEN-LAST:event_buscarPorNombreActionPerformed

    private void buscarPorApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorApellidosActionPerformed
        try {
            RandomAccessFile apellidoIndice = new RandomAccessFile("apellidoIndice.txt", "r");
            //hace visible las opciones de buscar registros
            setInvisibles();
            setVisibleBoton();
            //pasa el randomaccessfile para poder ser procesado en buscar registros(Principal)
            archivoIndices = apellidoIndice;
            //crea la llave para el metodo cambiar
            buscarpor = "Apellidos";
            //cambia el lenguaje
            cambiarLenguaje(principal.lenguaje());
            facebook.setVisible(false);
        } catch (IOException io) {
            System.out.println("Error en BuscarporApellido");
        }
    }//GEN-LAST:event_buscarPorApellidosActionPerformed

    private void buscarporCrnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarporCrnActionPerformed
        try {
            RandomAccessFile crnIndice = new RandomAccessFile("crnIndice.txt", "r");
            //hace visible las opciones de buscar registros
            setInvisibles();
            setVisibleBoton();
            //pasa el randomaccessfile para poder ser procesado en buscar registros(Principal)
            archivoIndices = crnIndice;
            //crea la llave para el metodo cambiar
            buscarpor = "Crn";
            //cambia el lenguaje
            cambiarLenguaje(principal.lenguaje());
        } catch (IOException io) {
            System.out.println("Error en BuscarporCrn");
        }
    }//GEN-LAST:event_buscarporCrnActionPerformed

    private void cambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarUsuarioActionPerformed
        //cierra la ventana de menu de busquedas
        dispose();
        inicioDeSesion ventanaInicioDeSesion = new inicioDeSesion();
        //hace visible la ventana de inicio de sesion
        ventanaInicioDeSesion.setVisible(true);
        try {
            RandomAccessFile usuarioGuardado = new RandomAccessFile("UsuarioGuardado.dat", "rw");
            //escribe que se ha cerrado la sesion con un f para que cuando se abra el programa de nuevo-
            //no entre con el usuario guardado
            usuarioGuardado.seek(0);
            usuarioGuardado.writeBytes("f");
            //borra el usuario guardado
            for (int i = 1; i < usuarioGuardado.length(); i++) {
                usuarioGuardado.seek(i);
                usuarioGuardado.writeByte(0);
            }
        } catch (IOException eo) {
            System.out.println("Error en menudebusqueda Cambiarusuario");
        }
    }//GEN-LAST:event_cambiarUsuarioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void eliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuarioActionPerformed
        //verifica si es administrador.
        if (principal.usuario.equalsIgnoreCase(principal.admin)) {
            //abre la ventana de eliminar
            eliminar ventanaEliminar = new eliminar();
            ventanaEliminar.setVisible(true);
            //cierra el menuDeBusqueda
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, errorPrivilegios, "TrueProgram", 0, null);
        }
    }//GEN-LAST:event_eliminarUsuarioActionPerformed

    private void normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalActionPerformed
        //cambia a modo normal que sera utilizado en buscar registros
        modoDeBusqueda = "normal";
        //crea la llave que se utilizara en cambiarLenguaje
        llaveDeLenguaje = "normal";
        cambiarLenguaje(principal.lenguaje());
    }//GEN-LAST:event_normalActionPerformed

    private void paginaDeSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paginaDeSoporteActionPerformed
        try {
            // crea un objeto de tipo URI
            java.net.URI uri = new java.net.URI("https://riverajuanpablo230.wixsite.com/trueprogram");
            //abre la URI
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException or) {
            System.out.println("Error En boton facebook");
        }
    }//GEN-LAST:event_paginaDeSoporteActionPerformed

    private void numeroDeTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroDeTelefonoActionPerformed
        //crea un objeto de tipo icon para usarlo como icono en el programa
        Icon icon = new ImageIcon(getClass().getResource("/Imagen/LogoBien.png"));
        JOptionPane.showMessageDialog(null, "Oscar: 332-188-2398\n"
                + "Pablo: 348-119-3821\n"
                + "Luis: 392-127-1791", "TrueProgram", 0, icon);
    }//GEN-LAST:event_numeroDeTelefonoActionPerformed

    private void contengaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contengaActionPerformed
        //cambia el metodo de busqueda que sera utilizado en buscar registros
        modoDeBusqueda = "contiene";
        //crea la llave que se utilizara en cambiarLenguaje
        llaveDeLenguaje = "contenga";
        cambiarLenguaje(principal.lenguaje());
    }//GEN-LAST:event_contengaActionPerformed

    private void empiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empiezaActionPerformed
        //cambia el metodo de busqueda que sera utilizado en buscar registros
        modoDeBusqueda = "empieza";
        //crea la llave que se utilizara en cambiarLenguaje
        llaveDeLenguaje = "empieza";
        cambiarLenguaje(principal.lenguaje());
    }//GEN-LAST:event_empiezaActionPerformed

    private void cambiarfoto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarfoto
        fotosDePerfil ventanaFotosDePerfil = new fotosDePerfil();
        //abre la ventana de fotos de perfil
        ventanaFotosDePerfil.setVisible(true);
        //cierra el menu de busqueda
        dispose();
    }//GEN-LAST:event_cambiarfoto

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuDeBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new menuDeBusqueda().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordDelNuevoUsuario;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton aceptarbuscar;
    private javax.swing.JMenuItem aleman;
    private javax.swing.JMenu ayuda;
    private javax.swing.JButton buscarPorApellidos;
    private javax.swing.JButton buscarPorClave;
    private javax.swing.JButton buscarPorMateria;
    private javax.swing.JButton buscarPorNombre;
    private javax.swing.JButton buscarporCrn;
    private javax.swing.JButton cambiarUsuario;
    private javax.swing.JMenuItem chino;
    private javax.swing.JLabel confirmarcontra;
    private javax.swing.JMenuItem contenga;
    private javax.swing.JTextField contraseña;
    private javax.swing.JLabel contraseñatext;
    private javax.swing.JButton crearUsuario;
    private javax.swing.JButton eliminarUsuario;
    private javax.swing.JMenuItem empieza;
    public javax.swing.JMenuItem español;
    private javax.swing.JLabel facebook;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fotodeusuario;
    private javax.swing.JMenu idioma;
    public javax.swing.JMenuItem ingles;
    private javax.swing.JTextField ingresarTexto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu modoDeBusquedaM;
    private javax.swing.JLabel nombreusuario;
    private javax.swing.JMenuItem normal;
    private javax.swing.JMenuItem numeroDeTelefono;
    private javax.swing.JMenuItem paginaDeSoporte;
    private javax.swing.JButton salir;
    private javax.swing.JLabel textoModo;
    private javax.swing.JLabel tituloRegistros;
    private javax.swing.JLabel tituloTexto;
    private javax.swing.JTextField usuarioNuevo;
    private javax.swing.JLabel usuariotext1;
    private volatile javax.swing.JTextArea visualizar;
    private javax.swing.JButton volverMenuBuscar;
    private javax.swing.JButton volverMenuCrear;
    // End of variables declaration//GEN-END:variables
}
