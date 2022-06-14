package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmEliminarAutor;
import vista.FrmEliminarLibro;
import vista.FrmInsertarAutor;
import vista.FrmInsertarLibro;
import vista.FrmMenu;
import vista.FrmModificarAutor;
import vista.FrmModificarLibro;
import vista.FrmMostrarAutor;
import vista.FrmMostrarLibro;

public class ControladorMenu implements ActionListener{

    FrmMenu fme = new FrmMenu();
    FrmInsertarAutor fia = new FrmInsertarAutor();
    FrmInsertarLibro fil = new FrmInsertarLibro();
    FrmMostrarAutor fma = new FrmMostrarAutor();
    FrmMostrarLibro fml = new FrmMostrarLibro();
    FrmModificarAutor fmda = new FrmModificarAutor();
    FrmModificarLibro fmdl = new FrmModificarLibro();
    FrmEliminarAutor fea = new FrmEliminarAutor();
    FrmEliminarLibro fel = new FrmEliminarLibro();

    public ControladorMenu(FrmMenu fme, FrmInsertarAutor fia, FrmInsertarLibro fil, 
            FrmMostrarAutor fma, FrmMostrarLibro fml, FrmModificarAutor fmda, FrmModificarLibro fmdl, 
            FrmEliminarAutor fea, FrmEliminarLibro fel) {
        this.fme = fme;
        this.fia = fia;
        this.fil = fil;
        this.fma = fma;
        this.fml = fml;
        this.fmda = fmda;
        this.fmdl = fmdl;
        this.fea = fea;
        this.fel = fel;
        this.fme.jmiInsertarA.addActionListener(this);
        this.fme.jmiInsertarL.addActionListener(this);
        this.fme.jmiMostrarA.addActionListener(this);
        this.fme.jmiMostrarL.addActionListener(this);
        this.fme.jmiModificarA.addActionListener(this);
        this.fme.jmiModificarL.addActionListener(this);
        this.fme.jmiEliminarA.addActionListener(this);
        this.fme.jmiEliminarL.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.fme.jmiInsertarA){
           this.fia.setVisible(true);
           this.fia.setLocationRelativeTo(fme);
           this.fia.setResizable(false);
        }
        if(ae.getSource() == this.fme.jmiInsertarL){
            this.fil.setVisible(true);
            this.fil.setLocationRelativeTo(fme);
            this.fil.setResizable(false);
        }
        if(ae.getSource() == this.fme.jmiMostrarA){
            this.fma.setVisible(true);
            this.fma.setLocationRelativeTo(fme);
            this.fma.setResizable(false);
        }
        if(ae.getSource() == this.fme.jmiMostrarL){
            this.fml.setVisible(true);
            this.fml.setLocationRelativeTo(fme);
            this.fml.setResizable(false);
        }
        if (ae.getSource() == this.fme.jmiModificarA) {
            this.fmda.setVisible(true);
            this.fmda.setLocationRelativeTo(fme);
            this.fmda.setResizable(false);
        }
        if (ae.getSource() == this.fme.jmiModificarL) {
            this.fmdl.setVisible(true);
            this.fmdl.setLocationRelativeTo(fme);
            this.fmdl.setResizable(false);
        }
        if (ae.getSource() == this.fme.jmiEliminarA) {
            this.fea.setVisible(true);
            this.fea.setLocationRelativeTo(fme);
            this.fea.setResizable(false);
        }
        if (ae.getSource() == this.fme.jmiEliminarL) {
            this.fel.setVisible(true);
            this.fel.setLocationRelativeTo(fme);
            this.fel.setResizable(false);
        }
    }
}