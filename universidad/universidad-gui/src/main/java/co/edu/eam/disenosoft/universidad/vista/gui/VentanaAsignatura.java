/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.vista.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.TipoAsignaturaEnum;
import co.edu.eam.disenosoft.universidad.vista.controladores.ControladorAsignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOAsignaturaJPA;

/**
 *
 * @author dir_software
 */
public class VentanaAsignatura extends javax.swing.JInternalFrame{


	private ControladorAsignatura controlador;
    public VentanaAsignatura() {
        initComponents();
        setVisible(true);
        setMaximizable(false);
        setIconifiable(true);
        setResizable(false);        
        setClosable(true);
        comboTipoAsignatura.addItem(TipoAsignaturaEnum.PRACTICA);
        comboTipoAsignatura.addItem(TipoAsignaturaEnum.TEORICO_PRACTICA);
        comboTipoAsignatura.addItem(TipoAsignaturaEnum.TEORICA);
        controlador = new ControladorAsignatura();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboTipoAsignatura = new javax.swing.JComboBox();
        tfcodigo = new javax.swing.JTextField();
        tfnombre = new javax.swing.JTextField();
        tfcreditos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSemestre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        brtnEditar = new javax.swing.JButton();
        brtnDelete = new javax.swing.JButton();

        setTitle("Administrar Asignaturas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/open161.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Basicos"));

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Creditos");

        jLabel4.setText("Tipo");

        jLabel5.setText("Semestre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfSemestre)
                    .addComponent(tfcodigo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTipoAsignatura, javax.swing.GroupLayout.Alignment.LEADING, 0, 268, Short.MAX_VALUE)
                    .addComponent(tfnombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfcreditos, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfcreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboTipoAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calculation1.png"))); // NOI18N
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zoom37.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        brtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pen38.png"))); // NOI18N
        brtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brtnEditarActionPerformed(evt);
            }
        });

        brtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        brtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(brtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(brtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(brtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /* Registrar Asignatura */
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		String codigo = tfcodigo.getText(); 
    		String nombre = tfnombre.getText(); 
            int semestre = Integer.parseInt(tfSemestre.getText());
    		int creditos = Integer.parseInt(tfcreditos.getText()); 
    		TipoAsignaturaEnum tipo = (TipoAsignaturaEnum) comboTipoAsignatura.getSelectedItem(); 
    		if(codigo.isEmpty() || nombre.isEmpty() || tfcreditos.getText().isEmpty()){
    			JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.", "Administrador de Asignatura", JOptionPane.INFORMATION_MESSAGE);   
    		}else{
    			Asignatura asignatura = new Asignatura(nombre, codigo, tipo, creditos, semestre);
    			System.out.println("Guardando los datos...");
    			Asignatura a = controlador.buscar(asignatura.getCodigo());
    			if(a == null){
        			controlador.crear(asignatura);
        			JOptionPane.showMessageDialog(null, "Se ha registrado la asignatura.", "Administrador de Asignatura", JOptionPane.INFORMATION_MESSAGE); 
        			limpiarCampos();
    			}else{
    				JOptionPane.showMessageDialog(null, "Ya hay una asignatura con el codigo "+a.getCodigo(), "Administrador de Asignatura", JOptionPane.WARNING_MESSAGE); 
    			}
    		}
    	}catch(Exception e1){
    		e1.printStackTrace();
    		JOptionPane.showMessageDialog(null, "Ups! ha ocurrido un error.", "Administrador de Asignatura", JOptionPane.ERROR_MESSAGE);   
    	}
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		String codigo = tfcodigo.getText(); 
    		if(codigo.isEmpty()){
    			JOptionPane.showMessageDialog(null, "Por favor, ingrese el codigo de la asignatura.", "Administrador de Asignatura", JOptionPane.QUESTION_MESSAGE);   
    		}else{
    			Asignatura asignatura = controlador.buscar(codigo);
    			if(asignatura != null){
    				tfcodigo.setText(asignatura.getCodigo()); 
    				tfnombre.setText(asignatura.getNombre()); 
    				tfcreditos.setText(String.valueOf(asignatura.getNumeroCreditos())); 
    				comboTipoAsignatura.setSelectedItem(asignatura.getTipo());
                    tfSemestre.setText(String.valueOf(asignatura.getSemestre()));
    			}else{
        			JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna asignatura\ncon el codigo: "+codigo, "Administrador de Asignatura", JOptionPane.INFORMATION_MESSAGE);   
    			}
    		}
    	}catch(Exception e1){
    		e1.printStackTrace();
    		JOptionPane.showMessageDialog(null, "Ups! ha ocurrido un error.", "Administrador de Asignatura", JOptionPane.ERROR_MESSAGE);   
    	}
    }

    private void brtnEditarActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		String codigo = tfcodigo.getText(); 
    		String nombre = tfnombre.getText(); 
    		int semestre = Integer.parseInt(tfSemestre.getText());
    		int creditos = Integer.parseInt(tfcreditos.getText()); 
    		TipoAsignaturaEnum tipo = (TipoAsignaturaEnum) comboTipoAsignatura.getSelectedItem(); 
    		if(codigo.isEmpty() || nombre.isEmpty() || tfcreditos.getText().isEmpty()){
    			JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.", "Administrador de Asignatura", JOptionPane.INFORMATION_MESSAGE);   
    		}else{
    			Asignatura asignatura = new Asignatura(nombre, codigo, tipo, creditos, semestre);
    			controlador.editar(asignatura);
    			JOptionPane.showMessageDialog(null, "Se ha Actualizado la informacion correctamente.", "Administrador de Asignatura", JOptionPane.INFORMATION_MESSAGE);  
    			limpiarCampos();
    		}
    	}catch(Exception e1){
    		e1.printStackTrace();
    		JOptionPane.showMessageDialog(null, "Ups! ha ocurrido un error.", "Administrador de Asignatura", JOptionPane.ERROR_MESSAGE);   
    	}
    }

    private void brtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
      	try{
            String codigo = tfcodigo.getText(); 
            if(codigo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el codigo de la asignatura.", "Administrador de Asignatura", JOptionPane.QUESTION_MESSAGE);   
            }else{
            	controlador.eliminar(codigo);
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente", "Administrador de Asignatura", JOptionPane.INFORMATION_MESSAGE);   
                limpiarCampos();
            }
      	}catch(Exception e1){
      		e1.printStackTrace();
      		JOptionPane.showMessageDialog(null, "Ups! ha ocurrido un error.", "Administrador de Asignatura", JOptionPane.ERROR_MESSAGE);   
      	}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brtnDelete;
    private javax.swing.JButton brtnEditar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox comboTipoAsignatura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfSemestre;
    private javax.swing.JTextField tfcodigo;
    private javax.swing.JTextField tfcreditos;
    private javax.swing.JTextField tfnombre;
    // End of variables declaration//GEN-END:variables

	public void limpiarCampos(){
		tfcodigo.setText(null); 
		tfnombre.setText(null); 
		tfcreditos.setText(null); 
		comboTipoAsignatura.setSelectedIndex(0);
        tfSemestre.setText(null);
	}
}
