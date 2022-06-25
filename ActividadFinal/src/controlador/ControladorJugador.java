package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import modelo.Extras;
import modelo.PuntajesUsuarioDAO;
import modelo.PuntajesUsuarioVO;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmJugador;
import vista.FrmLogin;

public class ControladorJugador implements ActionListener, WindowListener, MouseListener {

    FrmLogin vLogin = new FrmLogin();
    FrmJugador vJugar = new FrmJugador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    TipoUsuarioVO tuvo = new TipoUsuarioVO();
    TipoUsuarioDAO tudao = new TipoUsuarioDAO();
    PuntajesUsuarioVO puvo = new PuntajesUsuarioVO();
    PuntajesUsuarioDAO pudao = new PuntajesUsuarioDAO();

    //Variables a utilizar en los juegos
    int numeroS1, numeroS2, numeroS3, numeroS4, numeroR1, numeroR2, numeroR3, numeroR4, numeroM1, numeroM2, numeroD1, numeroD2;
    int respuestaS1, respuestaS2, respuestaR1, respuestaR2, respuestaM1, respuestaD1;
    int numeroIntentos = 0;
    int num1 = 0;
    int num2 = 15;
    int numeroSecreto = (int) (Math.random() * (num1 - num2) + num2);
    int puntajeA = 0;

    public ControladorJugador(FrmLogin vLogin, FrmJugador vJugar, UsuarioVO uvo, UsuarioDAO udao, TipoUsuarioVO tuvo, TipoUsuarioDAO tudao, PuntajesUsuarioVO puvo, PuntajesUsuarioDAO pudao) {
        this.vLogin = vLogin;
        this.vJugar = vJugar;
        this.uvo = uvo;
        this.udao = udao;
        this.tuvo = tuvo;
        this.tudao = tudao;
        this.puvo = puvo;
        this.pudao = pudao;
        this.vJugar.addWindowListener(this);
        this.vJugar.btnLogout.addActionListener(this);
        this.vJugar.btnHome.addActionListener(this);
        this.vJugar.btnPrincipiante.addActionListener(this);
        this.vJugar.btnIntermedio.addActionListener(this);
        this.vJugar.btnAvanzado.addActionListener(this);
        this.vJugar.btnTerminarP.addActionListener(this);
        this.vJugar.btnTerminarI.addActionListener(this);
        this.vJugar.btnComprobarNumero.addActionListener(this);
        this.vJugar.btnTerminarA.addActionListener(this);
    }

    //Método para devolver el nombre y apellido del usuario Jugador logueado y establecerlo en la ventana
    private String encontrarNombreApellido() {
        String nombre = "";
        String apellido = "";
        for (UsuarioVO uvo : udao.consultar()) {
            if (uvo.getIdUsuario() == Integer.parseInt(this.vJugar.lblIdUser.getText())) {
                nombre = uvo.getNombreUsuario();
                apellido = uvo.getApellidoUsuario();
            }
        }
        String nombreCompleto = nombre + " " + apellido;
        return nombreCompleto;
    }

    //Método para encontrar y devolver el ID que representa el nivel y/o rango del usuario
    private int devolverIDTipoUsuario() {
        int idUser = Integer.parseInt(this.vJugar.lblIdUser.getText());
        int tipoUsuario = 0;
        for (UsuarioVO uvo : udao.consultar()) {
            if (uvo.getIdUsuario() == idUser) {
                tipoUsuario = uvo.getIdTipoUsuarioFk();
            }
        }
        return tipoUsuario;
    }

    //Método para encontrar y devolver el nombre del nivel y/o rango del usuario y establecerlo en la ventana
    private String encontrarIDTipoUsuario() {
        String tipoUsuarioN = "";
        for (TipoUsuarioVO tuvo : tudao.consultarTipo()) {
            if (tuvo.getIdTipoUsuario() == devolverIDTipoUsuario()) {
                tipoUsuarioN = tuvo.getNombreTipoUsuario();
            }
        }
        return tipoUsuarioN;
    }
    
    //Método para establecer el estado y la nota de las actividades en la pestaña Home
    private void inicio() {
        String punteoP = ""; 
        String punteoI = ""; 
        String punteoA = "";
        int idU = 0;
        ArrayList<PuntajesUsuarioVO> punteo = pudao.consultarP();
        for (int i = 0; i < punteo.size(); i++) {
            idU = punteo.get(i).getIdUsuarioFk();
            if (idU == Integer.parseInt(this.vJugar.lblIdUser.getText())) {
                punteoP = String.valueOf(punteo.get(i).getPuntajePrincipiante());
                punteoI = String.valueOf(punteo.get(i).getPuntajeIntermedio());
                punteoA = String.valueOf(punteo.get(i).getPuntajeAvanzado());
            }
        }
        if(punteoP.equals("6")){
            this.vJugar.lblPunteoP.setText(String.valueOf(punteoP));
            this.vJugar.lblEstadoP.setText("PRUEBA COMPLETADA");
        }else{
            this.vJugar.lblPunteoP.setText(String.valueOf(punteoP));
            this.vJugar.lblEstadoP.setText("PRUEBA INCOMPLETA");
        }
        if(punteoI.equals("5")){
            this.vJugar.lblPunteoI.setText(String.valueOf(punteoI));
            this.vJugar.lblEstadoI.setText("PRUEBA COMPLETADA");
        }else{
            this.vJugar.lblPunteoI.setText(String.valueOf(punteoI));
            this.vJugar.lblEstadoI.setText("PRUEBA INCOMPLETA");
        }
        if(punteoA.equals("4")){
            this.vJugar.lblPunteoA.setText(String.valueOf(punteoA));
            this.vJugar.lblEstadoA.setText("PRUEBA COMPLETADA");
        }else{
            this.vJugar.lblPunteoA.setText(String.valueOf(punteoA));
            this.vJugar.lblEstadoA.setText("PRUEBA INCOMPLETA");
        }      
    }

    //Método para establecer los números de las operaciones aritméticas del juego para Principiante
    private void nivelPrincipiante() {
        int n1 = 1;
        int n2 = 10;
        numeroS1 = (int) (Math.random() * (n1 - n2) + n2);
        numeroS2 = (int) (Math.random() * (n1 - n2) + n2);
        numeroS3 = (int) (Math.random() * (n1 - n2) + n2);
        numeroS4 = (int) (Math.random() * (n1 - n2) + n2);
        numeroR1 = (int) (Math.random() * (n1 - n2) + n2);
        numeroR2 = (int) (Math.random() * (n1 - n2) + n2);
        numeroR3 = (int) (Math.random() * (n1 - n2) + n2);
        numeroR4 = (int) (Math.random() * (n1 - n2) + n2);
        numeroM1 = (int) (Math.random() * (n1 - n2) + n2);
        numeroM2 = (int) (Math.random() * (n1 - n2) + n2);
        numeroD1 = (int) (Math.random() * (n1 - n2) + n2);
        numeroD2 = (int) (Math.random() * (n1 - n2) + n2);
        respuestaS1 = numeroS1 + numeroS2;
        respuestaS2 = numeroS3 + numeroS4;
        respuestaR1 = numeroR1 - numeroR2;
        respuestaR2 = numeroR3 - numeroR4;
        respuestaM1 = numeroM1 * numeroM2;
        respuestaD1 = numeroD1 / numeroD2;
        this.vJugar.lblNumero1S.setText(String.valueOf(numeroS1));
        this.vJugar.lblNumero2S.setText(String.valueOf(numeroS2));
        this.vJugar.lblNumero3S.setText(String.valueOf(numeroS3));
        this.vJugar.lblNumero4S.setText(String.valueOf(numeroS4));
        this.vJugar.lblNumero1R.setText(String.valueOf(numeroR1));
        this.vJugar.lblNumero2R.setText(String.valueOf(numeroR2));
        this.vJugar.lblNumero3R.setText(String.valueOf(numeroR3));
        this.vJugar.lblNumero4R.setText(String.valueOf(numeroR4));
        this.vJugar.lblNumero1M.setText(String.valueOf(numeroM1));
        this.vJugar.lblNumero2M.setText(String.valueOf(numeroM2));
        this.vJugar.lblNumero1D.setText(String.valueOf(numeroD1));
        this.vJugar.lblNumero2D.setText(String.valueOf(numeroD2));
    }

    /*Método para comprobar las respuestas de las operaciones aritméticas del juego para Principiante
    y a su vez, determinar y devolver el puntaje alcanzado*/
    private int comprobacionRespuestaPrincipiante() {
        int puntajeP = 0;
        try {
            if (!this.vJugar.txtRespuestaS1.getText().equals("")) {
                if (Integer.valueOf(this.vJugar.txtRespuestaS1.getText()) == respuestaS1) {
                    puntajeP++;
                }
            }
            if (!this.vJugar.txtRespuestaS2.getText().equals("")) {
                if (Integer.valueOf(this.vJugar.txtRespuestaS2.getText()) == respuestaS2) {
                    puntajeP++;
                }
            }
            if (!this.vJugar.txtRespuestaR1.getText().equals("")) {
                if (Integer.valueOf(this.vJugar.txtRespuestaR1.getText()) == respuestaR1) {
                    puntajeP++;
                }
            }
            if (!this.vJugar.txtRespuestaR2.getText().equals("")) {
                if (Integer.valueOf(this.vJugar.txtRespuestaR2.getText()) == respuestaR2) {
                    puntajeP++;
                }
            }
            if (!this.vJugar.txtRespuestaM1.getText().equals("")) {
                if (Integer.valueOf(this.vJugar.txtRespuestaM1.getText()) == respuestaM1) {
                    puntajeP++;
                }
            }
            if (!this.vJugar.txtRespuestaD1.getText().equals("")) {
                if (Integer.valueOf(this.vJugar.txtRespuestaD1.getText()) == respuestaD1) {
                    puntajeP++;
                }
            }
        } catch (Exception e) {
            vJugar.jopMensaje.showMessageDialog(vJugar, "Las RESPUESTAS deben ser valores NUMÉRICOS ENTEROS");
        }
        return puntajeP;
    }

    //Actualizar la nota obtenida en el juego Principiante en la tabla 'puntajes_usuario'
    private void actualizarPuntajePrincipiante() {
        try {
            this.puvo.setPuntajePrincipiante(comprobacionRespuestaPrincipiante());
            this.puvo.setIdUsuarioFk(Integer.parseInt(this.vJugar.lblIdUser.getText()));
            if (pudao.actualizarPrincipiante(puvo) == true) {
            } else {
                System.err.println("NO se pudo actualizar la nota PRINCIPIANTE");
            }
        } catch (Exception e) {
            System.err.println("ERROR ACTUALIZACIÓN NOTA PRINCIPIANTE: " + e);
        }
    }

    //Método para limpiar los TextField del juego Principiante al terminar el mismo
    private void limpiarCamposP() {
        this.vJugar.txtRespuestaS1.setText("");
        this.vJugar.txtRespuestaS2.setText("");
        this.vJugar.txtRespuestaR1.setText("");
        this.vJugar.txtRespuestaR2.setText("");
        this.vJugar.txtRespuestaM1.setText("");
        this.vJugar.txtRespuestaD1.setText("");
    }

    /*Método para comprobar las respuestas de las preguntas del juego para Intermedio
    y a su vez, determinar y devolver el puntaje alcanzado*/
    private int nivelIntermedio() {
        int puntajeI = 0;
        if (this.vJugar.cmbRespuesta1.getSelectedItem().equals("Tecún Umán")) {
            puntajeI++;
        }
        if (this.vJugar.cmbRespuesta2.getSelectedItem().equals("Falso")) {
            puntajeI++;
        }
        if (this.vJugar.cmbRespuesta3.getSelectedItem().equals("San Marcos")) {
            puntajeI++;
        }
        if (this.vJugar.cmbRespuesta4.getSelectedItem().equals("22")) {
            puntajeI++;
        }
        if (this.vJugar.cmbRespuesta5.getSelectedItem().equals("República")) {
            puntajeI++;
        }
        return puntajeI;
    }

    //Actualizar la nota obtenida en el juego Intermedio en la tabla 'puntajes_usuario'
    private void actualizarPuntajeIntermedio() {
        try {
            this.puvo.setPuntajeIntermedio(nivelIntermedio());
            this.puvo.setIdUsuarioFk(Integer.parseInt(this.vJugar.lblIdUser.getText()));
            if (pudao.actualizarIntermedio(puvo) == true) {
            } else {
                System.err.println("NO se pudo actualizar la nota INTERMEDIO");
            }
        } catch (Exception e) {
            System.err.println("ERROR ACTUALIZACIÓN NOTA INTERMEDIO: " + e);
        }
    }

    //Método para devolver el comboBox a su estado original/inicial del juego Intermedio al terminar el mismo
    private void limpiarRespuestasI() {
        this.vJugar.cmbRespuesta1.setSelectedIndex(0);
        this.vJugar.cmbRespuesta2.setSelectedIndex(0);
        this.vJugar.cmbRespuesta3.setSelectedIndex(0);
        this.vJugar.cmbRespuesta4.setSelectedIndex(0);
        this.vJugar.cmbRespuesta5.setSelectedIndex(0);
    }

    //Método para configurar los intentos para adivinar el número del juego Avanzado
    private void nivelAvanzadoNumeroSecreto() {
        switch (numeroIntentos) {
            case 0:
                this.vJugar.txtIntento1.setEditable(false);
                this.vJugar.txtIntento2.setEditable(true);
                comprobacionNumeroSecreto();
                break;
            case 1:
                this.vJugar.txtIntento2.setEditable(false);
                this.vJugar.txtIntento3.setEditable(true);
                comprobacionNumeroSecreto();
                break;
            case 2:
                this.vJugar.txtIntento3.setEditable(false);
                this.vJugar.btnComprobarNumero.setEnabled(false);
                comprobacionNumeroSecreto();
                break;
            case 3:
                this.vJugar.txtIntento1.setEditable(false);
                this.vJugar.txtIntento2.setEditable(false);
                this.vJugar.txtIntento3.setEditable(false);
                this.vJugar.btnComprobarNumero.setEnabled(false);
                break;
        }
    }

    //Método para comprobar los intentos de respuesta del número secreto y otorgar el puntaje debido en esta sección del juego Avanzado
    private void comprobacionNumeroSecreto() {
        switch (numeroIntentos) {
            case 0:
                try {
                    if (numeroSecreto == Integer.parseInt(this.vJugar.txtIntento1.getText())) {
                        this.vJugar.jopMensaje.showMessageDialog(vJugar, "¡Felicidades! Adivinó el número secreto");
                        this.vJugar.lblNumeroSecreto.setText(String.valueOf(numeroSecreto));
                        puntajeA++;
                        numeroIntentos = 3;
                        nivelAvanzadoNumeroSecreto();
                    } else {
                        this.vJugar.jopMensaje.showMessageDialog(vJugar, "INTENTE DE NUEVO");
                        numeroIntentos++;
                    }
                } catch (Exception e) {
                    this.vJugar.jopMensaje.showMessageDialog(vJugar, "NO escribió un número entero como respuesta");
                    numeroIntentos++;
                }
                break;
            case 1:
                try {
                    if (numeroSecreto == Integer.parseInt(this.vJugar.txtIntento2.getText())) {
                        this.vJugar.jopMensaje.showMessageDialog(vJugar, "¡Felicidades! Adivinó el número secreto");
                        this.vJugar.lblNumeroSecreto.setText(String.valueOf(numeroSecreto));
                        puntajeA++;
                        numeroIntentos = 3;
                        nivelAvanzadoNumeroSecreto();
                    } else {
                        this.vJugar.jopMensaje.showMessageDialog(vJugar, "INTENTE DE NUEVO");
                        numeroIntentos++;
                    }
                } catch (Exception e) {
                    this.vJugar.jopMensaje.showMessageDialog(vJugar, "NO escribió un número entero como respuesta");
                    numeroIntentos++;
                }
                break;
            case 2:
                try {
                    if (numeroSecreto == Integer.parseInt(this.vJugar.txtIntento3.getText())) {
                        this.vJugar.jopMensaje.showMessageDialog(vJugar, "¡Felicidades! Adivinó el número secreto");
                        this.vJugar.lblNumeroSecreto.setText(String.valueOf(numeroSecreto));
                        puntajeA++;
                        numeroIntentos = 3;
                        nivelAvanzadoNumeroSecreto();
                    } else {
                        numeroIntentos++;
                        this.vJugar.jopMensaje.showMessageDialog(vJugar, "YA NO CUENTA CON MÁS INTENTOS");
                    }
                } catch (Exception e) {
                    this.vJugar.jopMensaje.showMessageDialog(vJugar, "NO escribió un número entero como respuesta");
                    numeroIntentos++;
                }
                break;
        }
    }

    //Método para comprobar las traducciones y otorgar el puntaje debido en esta sección del juego Avanzado
    private void nivelAvanzadoTraduccion() {
        if (this.vJugar.txtPalabra1A.getText().equals("LIBRO")) {
            puntajeA++;
        }
        if (this.vJugar.txtPalabra2A.getText().equals("GATO")) {
            puntajeA++;
        }
        if (this.vJugar.txtPalabra3A.getText().equals("MANZANA")) {
            puntajeA++;
        }
    }

    //Método para actualizar la nota obtenida en el juego Avanzado en la tabla 'puntajes_usuario'
    private void actualizarPuntajeAvanzado() {
        try {
            this.puvo.setPuntajeAvanzado(puntajeA);
            this.puvo.setIdUsuarioFk(Integer.parseInt(this.vJugar.lblIdUser.getText()));
            if (pudao.actualizarAvanzado(puvo) == true) {
            } else {
                System.err.println("NO se pudo actualizar la nota AVANZADO");
            }
        } catch (Exception e) {
            System.err.println("ERROR ACTUALIZACIÓN NOTA AVANZADO: " + e);
        }
    }

    /*Método restablecer a su estado original los elementos del juego Avanzado
    al terminar el mismo, y generar un nuevo número a adivinar*/
    private void limpiarCamposA() {
        this.vJugar.txtIntento1.setText("");
        this.vJugar.txtIntento2.setText("");
        this.vJugar.txtIntento3.setText("");
        this.vJugar.txtPalabra1A.setText("");
        this.vJugar.txtPalabra2A.setText("");
        this.vJugar.txtPalabra3A.setText("");
        numeroIntentos = 0;
        puntajeA = 0;
        numeroSecreto = (int) (Math.random() * (num1 - num2) + num2);
        this.vJugar.txtIntento1.setEditable(true);
        this.vJugar.btnComprobarNumero.setEnabled(true);
        this.vJugar.lblNumeroSecreto.setText("¿?");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.vJugar.btnLogout) {
            this.vJugar.dispose();
        }
        if (ae.getSource() == this.vJugar.btnHome) {
            this.vJugar.jtpPestanias.setSelectedIndex(0);
        }
        if (ae.getSource() == this.vJugar.btnPrincipiante) {
            this.vJugar.jtpPestanias.setSelectedIndex(1);
            nivelPrincipiante();
        }
        if (ae.getSource() == this.vJugar.btnIntermedio) {
            if (devolverIDTipoUsuario() < 3) {
                vJugar.jopMensaje.showMessageDialog(vJugar, "NO cuenta con el nivel necesario para realizar la prueba INTERMEDIA");
                this.vJugar.jtpPestanias.setSelectedIndex(0);
            } else {
                this.vJugar.jtpPestanias.setSelectedIndex(2);
            }
        }
        if (ae.getSource() == this.vJugar.btnAvanzado) {
            if (devolverIDTipoUsuario() < 4) {
                vJugar.jopMensaje.showMessageDialog(vJugar, "NO cuenta con el nivel necesario para realizar la prueba AVANZADA");
                this.vJugar.jtpPestanias.setSelectedIndex(0);
            } else {
                this.vJugar.jtpPestanias.setSelectedIndex(3);
            }
        }
        if (ae.getSource() == this.vJugar.btnTerminarP) {
            int resultadoPrincipiante = comprobacionRespuestaPrincipiante();
            vJugar.jopMensaje.showMessageDialog(vJugar, "RESULTADO: " + resultadoPrincipiante + "/6");
            actualizarPuntajePrincipiante();
            if (resultadoPrincipiante == 6) {
                if (devolverIDTipoUsuario() == 2) {
                    uvo.setIdUsuario(Integer.valueOf(vJugar.lblIdUser.getText()));
                    uvo.setFechaActualizacionUsuario(Extras.fechaHoy());
                    uvo.setIdTipoUsuarioFk(3);
                    udao.actualizarRango(uvo);
                    vJugar.jopMensaje.showMessageDialog(vJugar, "¡Felicidades! Ahora es un jugador de nivel INTERMEDIO");
                }
            }
            limpiarCamposP();
            vJugar.jtpPestanias.setSelectedIndex(0);
        }
        if (ae.getSource() == this.vJugar.btnTerminarI) {
            int resultadoIntermedio = nivelIntermedio();
            vJugar.jopMensaje.showMessageDialog(vJugar, "RESULTADO: " + resultadoIntermedio + "/5");
            actualizarPuntajeIntermedio();
            if (resultadoIntermedio == 5) {
                if (devolverIDTipoUsuario() == 3) {
                    uvo.setIdUsuario(Integer.valueOf(vJugar.lblIdUser.getText()));
                    uvo.setFechaActualizacionUsuario(Extras.fechaHoy());
                    uvo.setIdTipoUsuarioFk(4);
                    udao.actualizarRango(uvo);
                    vJugar.jopMensaje.showMessageDialog(vJugar, "¡Felicidades! Ahora es un jugador de nivel AVANZADO");
                }
            }
            limpiarRespuestasI();
            vJugar.jtpPestanias.setSelectedIndex(0);
        }
        if (ae.getSource() == this.vJugar.btnComprobarNumero) {
            nivelAvanzadoNumeroSecreto();
        }
        if (ae.getSource() == this.vJugar.btnTerminarA) {
            nivelAvanzadoTraduccion();
            this.vJugar.jopMensaje.showMessageDialog(vJugar, "RESULTADO: " + puntajeA + "/4");
            actualizarPuntajeAvanzado();
            if (puntajeA == 4) {
                this.vJugar.jopMensaje.showMessageDialog(vJugar, "¡Felicidades! Usted ha ganado el juego");
            }
            limpiarCamposA();
            vJugar.jtpPestanias.setSelectedIndex(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        //Configuraciones de la ventana 'Jugador'
        vJugar.setResizable(false);
        vJugar.setLocationRelativeTo(null);
        vJugar.setSize(1045, 750);
        vJugar.jtpPestanias.setSelectedIndex(0);
        vJugar.jtpPestanias.setEnabledAt(0, false);
        vJugar.jtpPestanias.setEnabledAt(1, false);
        vJugar.jtpPestanias.setEnabledAt(2, false);
        vJugar.jtpPestanias.setEnabledAt(3, false);
        this.vJugar.lblNumeroSecreto.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {
        this.vLogin.setVisible(true);
    }

    @Override
    public void windowIconified(WindowEvent we) {

    }

    @Override
    public void windowDeiconified(WindowEvent we) {

    }

    @Override
    public void windowActivated(WindowEvent we) {
        this.vJugar.lblIdUser.setHorizontalAlignment(SwingConstants.CENTER);
        this.vJugar.lblNombreUser.setText(encontrarNombreApellido());
        this.vJugar.lblNombreUser.setHorizontalAlignment(SwingConstants.CENTER);
        this.vJugar.lblRangoUauario.setText(encontrarIDTipoUsuario());
        this.vJugar.lblRangoUauario.setHorizontalAlignment(SwingConstants.CENTER);
        System.out.println(numeroSecreto);
        inicio();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}