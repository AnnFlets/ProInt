package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;

public class ControladorMenu implements ActionListener{
    
    FrmMenu vMe = new FrmMenu();
    FrmInsertar vIn = new FrmInsertar();
    FrmMostrar vMo = new FrmMostrar();
    FrmActualizar vAc = new FrmActualizar();
    FrmEliminar vEl = new FrmEliminar();
    
    public ControladorMenu(FrmMenu vMe, FrmInsertar vIn, FrmMostrar vMo, FrmActualizar vAc, FrmEliminar vEl){
        this.vMe = vMe;
        this.vIn = vIn;
        this.vMo = vMo;
        this.vAc = vAc;
        this.vEl = vEl;
        vMe.btnInsertar.addActionListener(this);
        vMe.btnMostrar.addActionListener(this);
        vMe.btnActualizar.addActionListener(this);
        vMe.btnEliminar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.vMe.btnInsertar){
           this.vIn.setVisible(true);
           this.vIn.setLocationRelativeTo(vMe);
           this.vIn.setResizable(false);
       }
       if(e.getSource() == this.vMe.btnMostrar){
           this.vMo.setVisible(true);
           this.vMo.setLocationRelativeTo(vMe);
           this.vMo.setResizable(false);
       }
       if(e.getSource() == this.vMe.btnActualizar){
           this.vAc.setVisible(true);
           this.vAc.setLocationRelativeTo(vMe);
           this.vAc.setResizable(false);
       }
       if(e.getSource() == this.vMe.btnEliminar){
           this.vEl.setVisible(true);
           this.vEl.setLocationRelativeTo(vMe);
           this.vEl.setResizable(false);
       }
    }
}
