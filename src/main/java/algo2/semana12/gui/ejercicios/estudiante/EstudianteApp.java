package algo2.semana12.gui.ejercicios.estudiante;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import net.miginfocom.swing.MigLayout;

class Estudiante {
    String codigo, apellido, nombre;
    int promedio;

    Estudiante(String codigo, String apellido, String nombre, int promedio) {
        this.codigo = codigo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.promedio = promedio;
    }
}

public class EstudianteApp {
    private List<Estudiante> listaEstudiantes;
    private EstudianteTableModel tableModel;

    private JFrame f = new JFrame("Mantenimiento de Alumnos");
    JLabel lblCodigo;
    JTextField txtCodigo;
    JTextArea txtSalidas;
    JLabel lblApellido;
    JTextField txtApellido;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblPromedio;
    JTextField txtPromedio;
    JPanel pnlBotones;
    JButton btnNuevo;
    JButton btnEliminar;
    JButton btnGuardar;

    JTable tblAlumnos;

    EstudianteApp() {
        listaEstudiantes = obtenerLista();
        f.setBounds(50, 50, 600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agregarComponentes(f);
        f.setVisible(true);
    }

    private List<Estudiante> obtenerLista() {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("12345678", "Perez", "Juan", 5));
        lista.add(new Estudiante("22345678", "Diaz", "Luis", 15));
        lista.add(new Estudiante("32345678", "Garcia", "Carlos", 15));
        lista.add(new Estudiante("42345678", "Rodriguez", "Julio", 8));
        return lista;
    }

    private void agregarComponentes(JFrame f) {
        f.getContentPane().setLayout(new MigLayout("", "[49px][250px,grow][250px]", "[30px][10px][30px][10px][30px][10px][30px][10px][30px][10px][grow]"));

        lblCodigo = new JLabel("Codigo:");
        lblCodigo.setDisplayedMnemonic(KeyEvent.VK_C);
        f.getContentPane().add(lblCodigo, "cell 0 0,alignx left,aligny center");
        txtCodigo = new JTextField();
        lblCodigo.setLabelFor(txtCodigo);
        f.getContentPane().add(txtCodigo, "cell 1 0,grow");

        txtSalidas = new JTextArea(10, 20);
        JScrollPane sp = new JScrollPane(txtSalidas);
        f.getContentPane().add(sp, "cell 2 0 1 7,grow");

        lblApellido = new JLabel("Apellido:");
        lblApellido.setDisplayedMnemonic(KeyEvent.VK_A);
        f.getContentPane().add(lblApellido, "cell 0 2,grow");
        txtApellido = new JTextField();
        lblApellido.setLabelFor(txtApellido);
        f.getContentPane().add(txtApellido, "cell 1 2,grow");

        lblNombre = new JLabel("Nombre:");
        lblNombre.setDisplayedMnemonic(KeyEvent.VK_N);
        f.getContentPane().add(lblNombre, "cell 0 4,grow");
        txtNombre = new JTextField();
        lblNombre.setLabelFor(txtNombre);
        f.getContentPane().add(txtNombre, "cell 1 4,grow");

        lblPromedio = new JLabel("Promedio:");
        lblPromedio.setDisplayedMnemonic(KeyEvent.VK_P);
        f.getContentPane().add(lblPromedio, "cell 0 6,grow");
        txtPromedio = new JTextField();
        lblPromedio.setLabelFor(txtPromedio);
        f.getContentPane().add(txtPromedio, "cell 1 6,grow");

        pnlBotones = new JPanel(new FlowLayout());
        btnNuevo = new JButton("Nuevo");
        pnlBotones.add(btnNuevo);
        btnEliminar = new JButton("Eliminar");
        pnlBotones.add(btnEliminar);
        btnGuardar = new JButton("Guardar");
        pnlBotones.add(btnGuardar);
        
		//Aqui va la linea de codigo que hace que aparezca el panel con los botones.
        f.getContentPane().add(pnlBotones, "cell 0 8 3 1,align center");

        agregarAcciones();
        agregarTable(f);
    }

    private void agregarTable(JFrame f) {
        tableModel = new EstudianteTableModel(listaEstudiantes);
        tblAlumnos = new JTable(tableModel);
        tblAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tblAlumnos.getSelectedRow();
                    if (fila >= 0) {
                        Estudiante est = listaEstudiantes.get(fila);
                        txtCodigo.setText(est.codigo);
                        txtApellido.setText(est.apellido);
                        txtNombre.setText(est.nombre);
                        txtPromedio.setText(String.valueOf(est.promedio));
                        log("Seleccionado: " + est.apellido + ", " + est.nombre);
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(tblAlumnos);
        tblAlumnos.setFillsViewportHeight(true);
        f.getContentPane().add(scrollPane, "cell 0 10 3 1,grow");
    }

    private void agregarAcciones() {
        btnNuevo.addActionListener(e -> {
            txtCodigo.setText("");
            txtApellido.setText("");
            txtNombre.setText("");
            txtPromedio.setText("");
            tblAlumnos.clearSelection();
            log("Campos limpiados.");
        });

        btnGuardar.addActionListener(e -> {
            int fila = tblAlumnos.getSelectedRow();
            try {
                String cod = txtCodigo.getText();
                String ape = txtApellido.getText();
                String nom = txtNombre.getText();
                int prom = Integer.parseInt(txtPromedio.getText());

                if (fila >= 0) {
                    Estudiante est = listaEstudiantes.get(fila);
                    est.codigo = cod;
                    est.apellido = ape;
                    est.nombre = nom;
                    est.promedio = prom;
                    tableModel.fireTableRowsUpdated(fila, fila);
                    log("Registro actualizado en fila " + fila);
                } else {
                    listaEstudiantes.add(new Estudiante(cod, ape, nom, prom));
                    tableModel.fireTableDataChanged();
                    log("Nuevo alumno agregado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(f, "Promedio debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tblAlumnos.getSelectedRow();
            if (fila >= 0) {
                listaEstudiantes.remove(fila);
                tableModel.fireTableDataChanged();
                log("Fila " + fila + " eliminada.");
                txtCodigo.setText("");
                txtApellido.setText("");
                txtNombre.setText("");
                txtPromedio.setText("");
            } else {
                log("Seleccione una fila para eliminar.");
            }
        });
    }

    private void log(String mensaje) {
        txtSalidas.append(mensaje + System.lineSeparator());
    }

    public static void main(String[] args) {
        new EstudianteApp();
    }
}

class EstudianteTableModel extends AbstractTableModel {
    private final List<Estudiante> lista;
    private final String[] colNames = {"Codigo", "Apellido", "Nombre", "Promedio"};

    EstudianteTableModel(List<Estudiante> lista) {
        this.lista = lista;
    }

    public int getRowCount() {
        return lista.size();
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public String getColumnName(int col) {
        return colNames[col];
    }

    public Object getValueAt(int row, int col) {
        Estudiante est = lista.get(row);
        switch (col) {
            case 0: return est.codigo;
            case 1: return est.apellido;
            case 2: return est.nombre;
            case 3: return est.promedio;
        }
        return null;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
