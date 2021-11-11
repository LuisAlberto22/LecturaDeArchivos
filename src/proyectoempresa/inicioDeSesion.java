package proyectoempresa;

import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *Desarrolladores:Luis Alberto Garcia Orozco, Juan Pablo Flores Rivera, Oscar Uriel MOrales Peralta
 *Fecha de entrega:!5/05/2019
 *Nombre del programa:TrueProgram (consulta de registros)
 */
public class inicioDeSesion extends javax.swing.JFrame {

    String Error = "Error, usuario no encontrado";

    public void cambiarIdioma(String dir) {
        //cambia de idioma
        ResourceBundle obj = ResourceBundle.getBundle(dir);
        contraseñaText.setText(obj.getString("Contraseña:"));
        usuariotext.setText(obj.getString("Usuario:"));
        botonAceptar.setText(obj.getString("Aceptar"));
        español.setText(obj.getString("Espanol"));
        ingles.setText(obj.getString("Ingles"));
        salir.setText(obj.getString("Salir"));
        idioma.setText(obj.getString("Idioma"));
        Error = obj.getString("Error");
        aleman.setText(obj.getString("Aleman"));
        chino.setText(obj.getString("Chino"));
        dejarSesion.setText(obj.getString("recordar"));
        ayuda.setText(obj.getString("ayuda"));
        paginaDeSoporte.setText(obj.getString("pagina"));
        numeroDeTelefono.setText(obj.getString("numero"));
        principal.textoIntentos = obj.getString("intentos");
        principal.errorContraseñaIncorrecta = obj.getString("contraseñaIncorrecta");
        principal.TextoDeIntentosConsumidos = obj.getString("contraseñaSalida");
    }

    public inicioDeSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagen/LogoBien.png")).getImage();
        setIconImage(icon);
        //llama al metodo de lenguaje para ver que lenguaje se esta utlizando en todo el programa
        cambiarIdioma(principal.lenguaje());
    }
    int cont = 3;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salir = new javax.swing.JButton();
        contraseñaText = new javax.swing.JLabel();
        usuariotext = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        passwordRecuadro = new javax.swing.JPasswordField();
        botonAceptar = new javax.swing.JButton();
        facebook = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        dejarSesion = new javax.swing.JCheckBox();
        fondo = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        idioma = new javax.swing.JMenu();
        español = new javax.swing.JMenuItem();
        ingles = new javax.swing.JMenuItem();
        aleman = new javax.swing.JMenuItem();
        chino = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        paginaDeSoporte = new javax.swing.JMenuItem();
        numeroDeTelefono = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TrueProgram");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 480, 270));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salir.setBackground(new java.awt.Color(51, 51, 51));
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 100, 30));

        contraseñaText.setForeground(new java.awt.Color(255, 255, 255));
        contraseñaText.setText("Contraseña:");
        getContentPane().add(contraseñaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 170, 40));

        usuariotext.setForeground(new java.awt.Color(255, 255, 255));
        usuariotext.setText("Usuario :");
        getContentPane().add(usuariotext, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, 44));

        usuario.setBackground(new java.awt.Color(51, 51, 51));
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setCaretColor(new java.awt.Color(255, 255, 255));
        usuario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        usuario.setSelectionColor(new java.awt.Color(255, 255, 255));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 270, 44));

        passwordRecuadro.setBackground(new java.awt.Color(51, 51, 51));
        passwordRecuadro.setForeground(new java.awt.Color(255, 255, 255));
        passwordRecuadro.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordRecuadro.setSelectionColor(new java.awt.Color(255, 255, 255));
        passwordRecuadro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordRecuadroActionPerformed(evt);
            }
        });
        getContentPane().add(passwordRecuadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 270, 50));

        botonAceptar.setBackground(new java.awt.Color(51, 51, 51));
        botonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonAceptar.setText("Aceptar");
        botonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonAceptarMousePressed(evt);
            }
        });
        getContentPane().add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 253, 100, 30));

        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/facebook.png"))); // NOI18N
        facebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                facebookMousePressed(evt);
            }
        });
        getContentPane().add(facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Usuario.png"))); // NOI18N
        getContentPane().add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 130, 130));

        dejarSesion.setBackground(new java.awt.Color(51, 51, 51));
        dejarSesion.setForeground(new java.awt.Color(255, 255, 255));
        dejarSesion.setText("Recuerdarme");
        dejarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dejarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(dejarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 120, -1));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondoFlecha.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 290));

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setBorder(null);
        menu.setForeground(new java.awt.Color(255, 255, 255));

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


    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        verificar();
    }//GEN-LAST:event_usuarioActionPerformed

    private void passwordRecuadroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordRecuadroActionPerformed
        verificar();
    }//GEN-LAST:event_passwordRecuadroActionPerformed


    private void botonAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAceptarMousePressed
        verificar();
    }//GEN-LAST:event_botonAceptarMousePressed
    public void verificar() {//verifica usuario y contraseña.
        String usuarioAVerificar = usuario.getText();
        char[] array = passwordRecuadro.getPassword();
        String password = new String(array);
        password = principal.cifradoCesar(password);
        //llama a verificar usuario 
        if (principal.verificarUsuario(usuarioAVerificar.trim())) {
            //verifica que la contraseña sea correcta
            boolean puedespasar = principal.verificarContraseña(password);
            if (puedespasar) {
                //abre ela ventana de bienvenida
                bienvenido menuDeBusqueda = new bienvenido();
                menuDeBusqueda.setVisible(puedespasar);
                //cierra inicio de sesion
                dispose();
                if (Recordar) {
                    try {
                        RandomAccessFile Usuario = new RandomAccessFile("UsuarioGuardado.dat", "rw");
                        //escribe si el usuario decidio recordar su usario
                        Usuario.seek(0);
                        Usuario.writeBytes("t");
                    } catch (IOException eo) {
                        System.out.println("Error en verificar");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, Error, "TrueProgram", 0, null);
        }
    }
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        verificar();
    }//GEN-LAST:event_formKeyPressed

    private void españolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_españolActionPerformed
        //cambia el idioma a español
        cambiarIdioma("Propiedades/Espanol");
        principal.auxIdioma = 1;
    }//GEN-LAST:event_españolActionPerformed

    private void inglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesActionPerformed
        //cambia el idioma a ingles
        cambiarIdioma("Propiedades/Ingles");
        principal.auxIdioma = 2;
    }//GEN-LAST:event_inglesActionPerformed

    private void alemanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alemanActionPerformed
        //cambia el idioma a aleman
        cambiarIdioma("Propiedades/Aleman");
        principal.auxIdioma = 3;
    }//GEN-LAST:event_alemanActionPerformed

    private void facebookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facebookMousePressed
        try {
            //crea un objeto de tipo URI
            java.net.URI uri = new java.net.URI("https://facebook.com/TrueProgram-834906380223146/");
            //abre la URI
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException or) {
            System.out.println("Error eb boton facebook");
        }
    }//GEN-LAST:event_facebookMousePressed

    private void chinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinoActionPerformed
        //cambia el idioma a chino
        cambiarIdioma("Propiedades/Chino");
        principal.auxIdioma = 4;
    }//GEN-LAST:event_chinoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        //sale del sistema
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void dejarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dejarSesionActionPerformed
        //gaurda si se deseo recordar el usuario en una variable global para ser utilizado por verificar
        Recordar = dejarSesion.isSelected();
    }//GEN-LAST:event_dejarSesionActionPerformed

    private void paginaDeSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paginaDeSoporteActionPerformed
        try {
            //crea un objeto de tipo URI
            java.net.URI uri = new java.net.URI("https://riverajuanpablo230.wixsite.com/trueprogram");
            //abre la URI
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException or) {
            System.out.println("Error En boton facebook");
        }
    }//GEN-LAST:event_paginaDeSoporteActionPerformed

    private void numeroDeTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroDeTelefonoActionPerformed
        //crea un icono para ser utilizado en el programa
        Icon icon = new ImageIcon(getClass().getResource("/Imagen/LogoBien.png"));
        JOptionPane.showMessageDialog(null, "Pablo: 332-188-2398\n"
                + "Oscar: 348-119-3821\n"
                + "Luis: 392-127-1791", "TrueProgram", 0, icon);
    }//GEN-LAST:event_numeroDeTelefonoActionPerformed
    boolean Recordar = false;

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
            java.util.logging.Logger.getLogger(inicioDeSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new inicioDeSesion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aleman;
    private javax.swing.JMenu ayuda;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JMenuItem chino;
    private javax.swing.JLabel contraseñaText;
    private javax.swing.JCheckBox dejarSesion;
    private javax.swing.JMenuItem español;
    private javax.swing.JLabel facebook;
    private javax.swing.JLabel fondo;
    private javax.swing.JMenu idioma;
    private javax.swing.JLabel imagen;
    private javax.swing.JMenuItem ingles;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem numeroDeTelefono;
    private javax.swing.JMenuItem paginaDeSoporte;
    private javax.swing.JPasswordField passwordRecuadro;
    private javax.swing.JButton salir;
    private javax.swing.JTextField usuario;
    private javax.swing.JLabel usuariotext;
    // End of variables declaration//GEN-END:variables
}
