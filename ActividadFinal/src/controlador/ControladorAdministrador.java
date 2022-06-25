package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Extras;
import modelo.PuntajesUsuarioDAO;
import modelo.PuntajesUsuarioVO;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmLogin;

public class ControladorAdministrador implements WindowListener, MouseListener {

    FrmLogin vLogin = new FrmLogin();
    FrmAdministrador vAdmin = new FrmAdministrador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    TipoUsuarioVO tuvo = new TipoUsuarioVO();
    TipoUsuarioDAO tudao = new TipoUsuarioDAO();
    PuntajesUsuarioVO puvo = new PuntajesUsuarioVO();
    PuntajesUsuarioDAO pudao = new PuntajesUsuarioDAO();

    public ControladorAdministrador(FrmLogin vLogin, FrmAdministrador vAdmin, UsuarioVO uvo, UsuarioDAO udao, TipoUsuarioVO tuvo, TipoUsuarioDAO tudao, PuntajesUsuarioVO puvo, PuntajesUsuarioDAO pudao) {
        this.vLogin = vLogin;
        this.vAdmin = vAdmin;
        this.uvo = uvo;
        this.udao = udao;
        this.tuvo = tuvo;
        this.tudao = tudao;
        this.puvo = puvo;
        this.pudao = pudao;
        this.vAdmin.addWindowListener(this);
        this.vAdmin.tblUsuarios.addMouseListener(this);
        this.vAdmin.lblInsertar.addMouseListener(this);
        this.vAdmin.lblModificar.addMouseListener(this);
        this.vAdmin.lblEliminar.addMouseListener(this);
        this.vAdmin.lblSalir.addMouseListener(this);
        this.vAdmin.lblReporteU.addMouseListener(this);
    }

    //Método para mostrar la información de los usuarios existentes en una tabla
    private void mostrarUsuarios() {
        DefaultTableModel mU = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        mU.setColumnCount(0);
        mU.addColumn("ID");
        mU.addColumn("Nombre");
        mU.addColumn("Apellido");
        mU.addColumn("Edad");
        mU.addColumn("Usuario");
        mU.addColumn("Contraseña");
        mU.addColumn("Rango");
        for (UsuarioVO uvo : udao.consultar()) {
            String tipoU = "";
            for (TipoUsuarioVO tuvo : tudao.consultarTipo()) {
                if (uvo.getIdTipoUsuarioFk() == tuvo.getIdTipoUsuario()) {
                    tipoU = tuvo.getNombreTipoUsuario();
                }
            }
            mU.addRow(new Object[]{uvo.getIdUsuario(), uvo.getNombreUsuario(),
                uvo.getApellidoUsuario(), uvo.getEdadUsuario(), uvo.getUsuarioUsuario(),
                uvo.getContrasenaUsuario(), tipoU});
        }
        vAdmin.tblUsuarios.setModel(mU);
        vAdmin.tblUsuarios.getTableHeader().setReorderingAllowed(false);
        vAdmin.tblUsuarios.getColumnModel().getColumn(5).setMaxWidth(0);
        vAdmin.tblUsuarios.getColumnModel().getColumn(5).setMinWidth(0);
        vAdmin.tblUsuarios.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        vAdmin.tblUsuarios.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
    }

    /*Método para llenar el comboBox con los niveles y/o rangos del usuario
    Rangos: Administrador, Principiante, Intermedio y Avanzado*/
    private void llenarComboBox() {
        ArrayList<TipoUsuarioVO> tiposUs = tudao.consultarTipo();
        for (int i = 0; i < tiposUs.size(); i++) {
            this.vAdmin.cmbRango.addItem(tiposUs.get(i).getNombreTipoUsuario());
        }
        if (tiposUs.size() == 0) {
            this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "No hay tipos de usuario disponibles");
            this.vAdmin.dispose();
        }
    }

    //Método para llenar los TextField con la información del usuario seleccionado en la tabla 
    private void llenarCamposUsuario() {
        int numero = 0;
        while (numero < 7) {
            switch (numero) {
                case 0:
                    this.vAdmin.txtID.setText(String.valueOf(this.vAdmin.tblUsuarios.getValueAt(this.vAdmin.tblUsuarios.getSelectedRow(), numero)));
                    break;
                case 1:
                    this.vAdmin.txtNombre.setText(String.valueOf(this.vAdmin.tblUsuarios.getValueAt(this.vAdmin.tblUsuarios.getSelectedRow(), numero)));
                    break;
                case 2:
                    this.vAdmin.txtApellido.setText(String.valueOf(this.vAdmin.tblUsuarios.getValueAt(this.vAdmin.tblUsuarios.getSelectedRow(), numero)));
                    break;
                case 3:
                    this.vAdmin.txtEdad.setText(String.valueOf(this.vAdmin.tblUsuarios.getValueAt(this.vAdmin.tblUsuarios.getSelectedRow(), numero)));
                    break;
                case 4:
                    this.vAdmin.txtUsuario.setText(String.valueOf(this.vAdmin.tblUsuarios.getValueAt(this.vAdmin.tblUsuarios.getSelectedRow(), numero)));
                    break;
                case 5:
                    this.vAdmin.psfContrasena.setText(String.valueOf(this.vAdmin.tblUsuarios.getValueAt(this.vAdmin.tblUsuarios.getSelectedRow(), numero)));
                    break;
                case 6:
                    this.vAdmin.cmbRango.setSelectedItem(String.valueOf(this.vAdmin.tblUsuarios.getValueAt(this.vAdmin.tblUsuarios.getSelectedRow(), numero)));
                    break;
            }
            numero++;
        }
    }

    //Método para encontrar el ID que representa el nivel y/o rango seleccionado en el comboBox
    private int encontrarIDTipoUsuario() {
        int idUser = 0;
        String tipoUser = String.valueOf(this.vAdmin.cmbRango.getSelectedItem());
        for (TipoUsuarioVO tuvo : tudao.consultarTipo()) {
            if (tuvo.getNombreTipoUsuario().equals(String.valueOf(tipoUser))) {
                idUser = tuvo.getIdTipoUsuario();
            }
        }
        return idUser;
    }

    //Método para registrar al usuario, tanto en la tabla 'usuario' como en la tabla 'puntajes_usuario'
    private void registrarUsuario() {
        try {
            this.uvo.setNombreUsuario(this.vAdmin.txtNombre.getText());
            this.uvo.setApellidoUsuario(this.vAdmin.txtApellido.getText());
            this.uvo.setEdadUsuario(Integer.parseInt(this.vAdmin.txtEdad.getText()));
            this.uvo.setUsuarioUsuario(this.vAdmin.txtUsuario.getText());
            this.uvo.setContrasenaUsuario(this.vAdmin.psfContrasena.getText());
            this.uvo.setFechaIngresoUsuario(Extras.fechaHoy());
            this.uvo.setIdTipoUsuarioFk(encontrarIDTipoUsuario());
            if (udao.insertar(uvo) == true) {
                this.puvo.setIdUsuarioFk(buscarIdInsertado());
                if (pudao.insertarP(puvo)) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Datos insertados con éxito");
                    limpiarCampos();
                } else {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Error, datos no registrados");
                }
            } else {
                this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Error, datos no registrados");
            }
        } catch (Exception e) {
            this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "La edad debe ser un valor numérico entero");
        }
    }

    /*Método para encontrar y devolver el ID del usuario creado, para insertarlo en la llave foránea 
    'id_usuario_fk' de la tabla 'puntajes_usuario'*/
    private int buscarIdInsertado() {
        int codigoU = 0;
        ArrayList<UsuarioVO> usuarios = udao.consultar();
        for (int i = 0; i < usuarios.size(); i++) {
            String userU = String.valueOf(usuarios.get(i).getUsuarioUsuario());
            String userC = String.valueOf(usuarios.get(i).getContrasenaUsuario());
            if (userU.equals(this.vAdmin.txtUsuario.getText()) && userC.equals(this.vAdmin.psfContrasena.getText())) {
                codigoU = usuarios.get(i).getIdUsuario();
            }
        }
        return codigoU;
    }

    //Método para modificar la información del usuario seleccionado
    private void modificarUsuario() {
        try {
            this.uvo.setIdUsuario(Integer.parseInt(this.vAdmin.txtID.getText()));
            this.uvo.setNombreUsuario(this.vAdmin.txtNombre.getText());
            this.uvo.setApellidoUsuario(this.vAdmin.txtApellido.getText());
            this.uvo.setEdadUsuario(Integer.parseInt(this.vAdmin.txtEdad.getText()));
            this.uvo.setUsuarioUsuario(this.vAdmin.txtUsuario.getText());
            this.uvo.setContrasenaUsuario(this.vAdmin.psfContrasena.getText());
            this.uvo.setFechaActualizacionUsuario(Extras.fechaHoy());
            this.uvo.setIdTipoUsuarioFk(encontrarIDTipoUsuario());
            this.puvo.setIdUsuarioFk(this.uvo.getIdUsuario());
            if (udao.actualizar(uvo) == true) {
                this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Datos modificados con éxito");
                limpiarCampos();
            } else {
                this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Error, datos no modificados");
            }
        } catch (Exception e) {
            this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "La edad debe ser un valor numérico entero");
        }
    }

    /*Método para eliminar al usuario seleccionado, tanto su información personal (tabla 'usuario')
    como sus puntajes (tabla 'puntajes_usuario')*/
    private void eliminarUsuario() {
        this.uvo.setIdUsuario(Integer.parseInt(this.vAdmin.txtID.getText()));
        this.puvo.setIdUsuarioFk(Integer.parseInt(this.vAdmin.txtID.getText()));
        if (pudao.eliminarP(puvo) == true) {
            if (udao.eliminar(uvo) == true) {
                this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Datos eliminados correctamente");
                limpiarCampos();
            } else {
                this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Error, datos no eliminados");
            }
        } else {
            this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Error, datos no eliminados");
        }
    }

    //Método para generar el reporte de usuarios
    private void reporteUsuarios() {
        udao.reporte();
        udao.jv.setDefaultCloseOperation(vAdmin.DISPOSE_ON_CLOSE);
        udao.jv.setVisible(true);
    }

    //Método para limpiar los campos luego de realizar una acción de inserción, modificación o eliminación de datos
    private void limpiarCampos() {
        this.vAdmin.txtID.setText("");
        this.vAdmin.txtNombre.setText("");
        this.vAdmin.txtApellido.setText("");
        this.vAdmin.txtEdad.setText("");
        this.vAdmin.txtUsuario.setText("");
        this.vAdmin.psfContrasena.setText("");
    }

    //Método para devolver el nombre y apellido del usuario administrador logueado y establecerlo en la ventana
    private String encontrarNombreApellido() {
        String nombre = "";
        String apellido = "";
        for (UsuarioVO uvo : udao.consultar()) {
            if (uvo.getIdUsuario() == Integer.parseInt(this.vAdmin.lblIdUser.getText())) {
                nombre = uvo.getNombreUsuario();
                apellido = uvo.getApellidoUsuario();
            }
        }
        String nombreCompleto = nombre + " " + apellido;
        return nombreCompleto;
    }

    @Override
    public void windowOpened(WindowEvent we) {
        //Configuraciones de la ventana Administrador
        vAdmin.setResizable(false);
        vAdmin.setLocationRelativeTo(null);
        vAdmin.setSize(1060, 735);
        llenarComboBox();
        mostrarUsuarios();
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {
        limpiarCampos();
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
        mostrarUsuarios();
        this.vAdmin.lblIdUser.setHorizontalAlignment(SwingConstants.CENTER);
        this.vAdmin.lblNombreUsuario.setText(encontrarNombreApellido());
        vAdmin.lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == this.vAdmin.tblUsuarios) {
            if (me.getClickCount() == 2) {
                llenarCamposUsuario();
            }
        }
        if (me.getSource() == this.vAdmin.lblSalir) {
            limpiarCampos();
            this.vAdmin.dispose();
        }
        if (me.getSource() == this.vAdmin.lblInsertar) {
            if (!this.vAdmin.txtNombre.getText().equals("")
                    && !this.vAdmin.txtApellido.getText().equals("") && !this.vAdmin.txtEdad.getText().equals("")
                    && !this.vAdmin.txtUsuario.getText().equals("") && !this.vAdmin.psfContrasena.getText().equals("")) {
                registrarUsuario();
            } else {
                if (this.vAdmin.txtNombre.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Nombre no ingresado");
                } else if (this.vAdmin.txtApellido.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Apellido no ingresado");
                } else if (this.vAdmin.txtEdad.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Edad no ingresada");
                } else if (this.vAdmin.txtUsuario.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Usuario no ingresado");
                } else if (this.vAdmin.psfContrasena.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Contraseña no ingresada");
                }
            }
        }
        if (me.getSource() == this.vAdmin.lblModificar) {
            if (!this.vAdmin.txtID.getText().equals("") && !this.vAdmin.txtNombre.getText().equals("")
                    && !this.vAdmin.txtApellido.getText().equals("") && !this.vAdmin.txtEdad.getText().equals("")
                    && !this.vAdmin.txtUsuario.getText().equals("") && !this.vAdmin.psfContrasena.getText().equals("")) {
                modificarUsuario();
            } else {
                if (this.vAdmin.txtID.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "No ha seleccionado ningún registro a modificar");
                } else if (this.vAdmin.txtNombre.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Nombre no ingresado");
                } else if (this.vAdmin.txtApellido.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Apellido no ingresado");
                } else if (this.vAdmin.txtEdad.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Edad no ingresada");
                } else if (this.vAdmin.txtUsuario.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Usuario no ingresado");
                } else if (this.vAdmin.psfContrasena.getText().equals("")) {
                    this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "Contraseña no ingresada");
                }
            }
        }
        if (me.getSource() == vAdmin.lblEliminar) {
            if (!vAdmin.txtID.getText().equals("")) {
                eliminarUsuario();
            } else {
                this.vAdmin.jopAdministrador.showMessageDialog(vAdmin, "No ha seleccionado ningún registro a eliminar");
            }
        }
        if (me.getSource() == vAdmin.lblReporteU) {
            reporteUsuarios();
        }
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