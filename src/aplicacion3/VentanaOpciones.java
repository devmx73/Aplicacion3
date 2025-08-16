package aplicacion3;

import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ToolTipManager;

import javax.swing.table.DefaultTableModel;

public class VentanaOpciones extends javax.swing.JFrame {

    String nomEstudiante, apellEstudiante, correoEstudiante;
    String nomDocente, apellDocente, formacAcademica, nomUnidadDidactica;
    String programaEstudio, sitLaboral, turno;
    int usaLaboratorio, cantAsistidas, horasLab,horasTeoria;
    double notaAct1, notaAct2, notaAct3, notaAct4, creditos;
    double notaCon1, notaCon2, notaCon3, notaCon4, notaProc;
    DefaultTableModel modelo;
    DefaultTableModel modelo1;
    
    
            
    
    public VentanaOpciones() {
        initComponents();
        // Desactiva todo excepto el btnDocente
        btnTablaDocente.setEnabled(false);
        btnEstudiante.setEnabled(false);
        btnRegistroCalif.setEnabled(false);
        btnResultadoNotas.setEnabled(false);
        
        // Cargar el panel docente al hacer clic
        btnDocente.addActionListener(e -> {
        });    
        
        // agregar los encabezados de registro de estudiante
        modelo = new DefaultTableModel();
        modelo.addColumn("Apellidos");
        modelo.addColumn("Nombres");
        modelo.addColumn("Correo");
        modelo.addColumn("Unidad");
        modelo.addColumn("Laboratorio");
        modelo.addColumn("Turno");
        modelo.addColumn("Asistencia");
        modelo.addColumn("Actitud");
        modelo.addColumn("Conocimiento");
        modelo.addColumn("Procedimental");
        modelo.addColumn("Promedio Final");
        modelo.addColumn("Categoria");
        modelo.addColumn("Condición");
        this.tbEstudiantes.setModel(modelo);
        
        // Encabezado de registro de docente
        modelo1 = new DefaultTableModel();
        modelo1.addColumn("Nombres");
        modelo1.addColumn("Apellidos");
        modelo1.addColumn("Formación Académica");
        modelo1.addColumn("Situación Laboral");
        modelo1.addColumn("Programa de estudio");
        modelo1.addColumn("Unidad Didáctica");
        modelo1.addColumn("Créditos");
        modelo1.addColumn("Horas Teoria");
        modelo1.addColumn("Horas de Laboratorio");
        this.tbRegistroDocente.setModel(modelo1);

        // Centra ventana
        setLocationRelativeTo(null);
    }
    
    public void mostrarPanel(JPanel panel){
        pnDocente.removeAll();
        pnDocente.add(panel);
        pnDocente.revalidate();
        pnDocente.repaint();
    }
    
    public void activarBoton2(){
        btnTablaDocente.setEnabled(true);
    }
    
    public void activarBoton3() {
        btnEstudiante.setEnabled(true);
    }

    public void activarBoton4() {
        btnRegistroCalif.setEnabled(true);
    }

    public void activarBoton5() {
        btnResultadoNotas.setEnabled(true);
    }

    public void ingresarDatosEstudiante() {
        nomEstudiante = getNomEstudiante();
        apellEstudiante = getApellEstudiante();
        correoEstudiante = getCorreoEstudiante();
        usaLaboratorio = getUsaLaboratorio();
        turno = getTurno();

    }

    public void ingresarDatosDocente() {
        nomDocente = getNomDocente();
        apellDocente = getApellDocente();
        formacAcademica = getFormacionAcademica();
        sitLaboral = getSituacionLaboral();
        programaEstudio = getProgramaEstudio();
        nomUnidadDidactica = getNomUnidDidactica();
        horasTeoria=getHorasTeoriaUD();
        horasLab = getHorasLabUD();
        creditos = getCreditosUD();
    }

    public void ingresarNotas() {
        cantAsistidas = getClasesAsistidas(); // numero de asistencias
        // notas de actitudes
        notaAct1 = getNotaAct1();
        notaAct2 = getNotaAct2();
        notaAct3 = getNotaAct3();
        notaAct4 = getNotaAct4();
        //notas de conocimiento
        notaCon1 = getNotaAct1();
        notaCon2 = getNotaAct2();
        notaCon3 = getNotaAct3();
        notaCon4 = getNotaAct4();
        // nota procedimental
        notaProc = getNotaProcedimental();
    }

    // Acceso a los datos del Docente
    public String getNomDocente() {
        return txtNombresDocente.getText();
    }

    public String getApellDocente() {
        return txtApellidosDocente.getText();
    }

    public String getFormacionAcademica() {
        return txtFormacionAcademica.getText();
    }

    public String getSituacionLaboral() {
        return (String) cboSituacionLaboral.getSelectedItem();
    }

    public String getProgramaEstudio() {
        return (String) cboProgramEstudio.getSelectedItem();
    }

    public String getNomUnidDidactica() {
        return txtUnidadDidactica.getText();
    }

    public double getCreditosUD() {
        return Double.parseDouble(txtCantCreditos.getText());
    }
    
    public int getHorasTeoriaUD(){
        return cboHorasTeoria.getSelectedIndex();
    }

    public int getHorasLabUD() {
        return cboHorasLab.getSelectedIndex();
    }

    // ACCESO A LOS DATOS DEL ESTUDIANTE
    public String getNomEstudiante() {
        return txtNombres.getText();
    }

    public String getApellEstudiante() {
        return txtApellidos.getText();
    }

    public String getCorreoEstudiante() {
        return txtCorreoEstudiante.getText();
    }

    public int getUsaLaboratorio() {
        return cboUseLab.getSelectedIndex();
    }

    public String getTurno() {
        return (String) cboTurno.getSelectedItem();
    }

    // obtener clases asistidas
    public int getClasesAsistidas() {
        return cboSemanas.getSelectedIndex();
    }

    // Acceso a las 4 notas de actitudes
    public double getNotaAct1() {
        return Double.parseDouble(txtNotaAc1.getText());
    }

    public double getNotaAct2() {
        return Double.parseDouble(txtNotaAc2.getText());
    }

    public double getNotaAct3() {
        return Double.parseDouble(txtNotaAc3.getText());
    }

    public double getNotaAct4() {
        return Double.parseDouble(txtNotaAc4.getText());
    }

    // Acceso a las 4 notas de conocimiento    
    public double getNotaCon1() {
        return Double.parseDouble(txtNotaCon1.getText());
    }

    public double getNotaCon2() {
        return Double.parseDouble(txtNotaCon2.getText());
    }

    public double getNotaCon3() {
        return Double.parseDouble(txtNotaCon3.getText());
    }

    public double getNotaCon4() {
        return Double.parseDouble(txtNotaCon4.getText());
    }

    // nota procedimental
    public double getNotaProcedimental() {
        return notaProc = Double.parseDouble(txtNotaP1.getText());
    }

    public double promActitud(double a1, double a2, double a3, double a4) { // menor se elimina
        boolean a1Menor = a1 < a2 && a1 < a3 && a1 < a4;
        boolean a2Menor = a2 < a1 && a2 < a3 && a2 < a4;
        boolean a3Menor = a3 < a2 && a3 < a1 && a3 < a4;
        boolean a4Menor = a4 < a1 && a4 < a2 && a4 < a3;
        boolean ig = a1 == a2 && a2 == a3 && a3 == a4;

        if (ig) {
            return (a1 + a2 + a3 + a4) / 4;
        } else if (a1Menor) {
            return (a2 + a3 + a4) / 3;
        } else if (a2Menor) {
            return (a1 + a3 + a4) / 3;
        } else if (a3Menor) {
            return (a1 + a2 + a4) / 3;
        } else if (a4Menor) {
            return (a1 + a2 + a3) / 3;
        }
        return 0;
    }

    public double calcularConocimientos(double c1, double c2, double c3, double c4) {

        //ver cual de los 3 primeros es el mayor
        boolean c1Menor = c2 > c1 && c3 > c1;
        boolean c2Menor = c1 > c2 && c3 > c2;
        boolean c3Menor = c1 > c3 && c2 > c3;
        boolean c1Mayor = c1 > c2 && c1 > c3;
        boolean c2Mayor = c2 > c1 && c2 > c3;
        boolean c3Mayor = c3 > c1 && c3 > c2;
        boolean ig = c1 == c2 && c2 == c3;

        double mayor = 0;

        if (ig) {
            mayor = c1;
        } else if (c1Mayor) {
            mayor = c1;
        } else if (c2Mayor) {
            mayor = c2;
        } else if (c3Mayor) {
            mayor = c3;
        }

        if (c1Menor) {
            c1 = mayor;
        } else if (c2Menor) {
            c2 = mayor;
        } else if (c3Menor) {
            c3 = mayor;
        }

        return ((c1 * 1 + c2 * 2 + c3 * 3 + c4 * 4) / 10);
    }

    double promAct, promCon, promAsis, promFinal;
    int notaFinal;
    String categoria, numLetras, estadoFinal;

    public void calificador() {
        ingresarDatosEstudiante();
        ingresarNotas();
        double totalClass = 0;
        if (cboUseLab.getSelectedItem().toString().equalsIgnoreCase("Si")) {
            totalClass = 34;
        } else {
            totalClass = 17;
        }

        promAct = promActitud(notaAct1, notaAct2, notaAct3, notaAct4);
        promCon = calcularConocimientos(notaCon1, notaCon2, notaCon3, notaCon4);

        double porcAsistencias = (cantAsistidas / totalClass);

        if (porcAsistencias >= 1) {
            promAsis = 95;
        } else {
            promAsis = (int) (porcAsistencias * 95);
        }

        if (cboUseLab.getSelectedIndex() == 2) {
            promFinal = promAsis * 0.15 + promAct * 0.35 + promCon * 0.50;
        } else if (cboUseLab.getSelectedIndex() == 1) {
            promFinal = promAsis * 0.15 + promAct * 0.25 + promCon * 0.35 + notaProc * 0.25;
        }

        promFinal = promFinal + 0.5;
        notaFinal = (int) promFinal;

        if ((promFinal - notaFinal) > 0.5) {
            notaFinal = notaFinal + 1;
        }

        numLetras = convertirNumAText(notaFinal);
        categoria = hallarCategoria(notaFinal);
        estadoFinal = condicion(notaFinal);

    }

    public void procesar() {
        ingresarDatosEstudiante();
        ingresarDatosDocente();
        ingresarNotas();
        calificador();

        int filaActual = modelo.getRowCount();
        modelo.addRow(new Object[modelo.getColumnCount()]);

        modelo.setValueAt(txtApellidos.getText(), filaActual, 0);
        modelo.setValueAt(txtNombres.getText(), filaActual, 1);
        modelo.setValueAt(txtCorreoEstudiante.getText(), filaActual, 2);
        modelo.setValueAt(txtUnidadDidactica.getText(), filaActual, 3);
        modelo.setValueAt(cboUseLab.getSelectedItem(), filaActual, 4);
        modelo.setValueAt(cboTurno.getSelectedItem(), filaActual, 5);
        modelo.setValueAt(promAsis, filaActual, 6);
        modelo.setValueAt(promActitud(notaAct1, notaAct2, notaAct3, notaAct4), filaActual, 7);
        modelo.setValueAt(calcularConocimientos(notaCon1, notaCon2, notaCon3, notaCon4), filaActual, 8);
        modelo.setValueAt(notaProc, filaActual, 9);
        modelo.setValueAt(notaFinal, filaActual, 10);
        modelo.setValueAt(hallarCategoria(notaFinal), filaActual, 11);
        modelo.setValueAt(condicion(notaFinal), filaActual, 12);

        // textArea
        txtRepo.setText("Apellido: " + apellEstudiante + "\n");
        txtRepo.append("Nombre: " + nomEstudiante + "\n");
        txtRepo.append("Correo: " + correoEstudiante + "\n");
        txtRepo.append("Unidad didáctica: " + nomUnidadDidactica + "\n");
        txtRepo.append("Laboratorio: " + usaLaboratorio + "\n");
        txtRepo.append("Turno: " + turno);
        txtRepo.append("Asistencia: " + promAsis + "\n");
        txtRepo.append("Actitud: " + promAct + "\n");
        txtRepo.append("Conocimiento: " + promCon + "\n");
        txtRepo.append("Procedimental: " + notaProc + "\n");

        txtRepo.append("Categoria: " + categoria + "\n");
        txtRepo.append("Condición:" + estadoFinal + "\n");
        txtRepo.append("Promedio final texto: " + numLetras);

    }

    //metodos para convertir de numeros a letras
    public int calcLongNum(double numero) {

        int longitudNumero = 0;

        if (numero == 0) {
            longitudNumero = 0;
        } else if (numero <= 9) {
            longitudNumero = 1;
        } else if (numero <= 99) {
            longitudNumero = 2;
        } else if (numero <= 999) {
            longitudNumero = 3;
        } else if (numero <= 9999) {
            longitudNumero = 4;
        } else if (numero <= 99999) {
            longitudNumero = 5;
        } else {
            longitudNumero = -1;
        }
        return longitudNumero;
    }

    //metodo que usa los demás y devuelve los valores reales segun el numero
    public String convertirNumAText(double numero) {
        int longNum = calcLongNum(numero);
        String value = "";
        switch (longNum) {
            case 0:
                value = "cero";
                break;
            case 1:
                value = numerosNaturales(numero);
                break;
            case 2, 3:
                value = dosCifras(numero);
                break;
            default:
                value = "limite excedido!";
        }
        double rest = numero - ((int) numero);
        if (rest != 0) {
            double porcent = Math.round(rest * 100);
            return (value + " y " + (int) porcent + "/100").trim();
        } else {
            return value.trim();
        }
    }

    //metodo que convierte de numeros a letras si el numero es natural (menor a 10)
    public String numerosNaturales(double numero) {
        String numText = "";
        switch ((int) numero) {
            case 1:
                numText = "un";
                break;
            case 2:
                numText = "dos";
                break;
            case 3:
                numText = "tres";
                break;
            case 4:
                numText = "cuatro";
                break;
            case 5:
                numText = "cinco";
                break;
            case 6:
                numText = "seis";
                break;
            case 7:
                numText = "siete";
                break;
            case 8:
                numText = "ocho";
                break;
            case 9:
                numText = "nueve";
                break;
            default:
                numText = "";
        }
        return numText.trim();
    }

    //metodo que transforma de numeros a letras si el numero es de 2 cifras
    public String dosCifras(double num) {
        String numText = "";
        if (num < 10) {
            numText = numerosNaturales(num);
        } else {
            if (num >= 30) {
                if (num < 40) {
                    if (num == 30) {
                        numText = "treinta";
                    } else if (num == 31) {
                        numText = "treinta y un";
                    } else {
                        int nuevoNum = (int) num - 30;
                        String uni = numerosNaturales(nuevoNum);
                        numText = "treinta y " + uni;
                    }
                } else if (num < 50) {
                    if (num == 40) {
                        numText = "cuarenta";
                    } else if (num == 41) {
                        numText = "cuarenta y un";
                    } else {
                        int nuevoNum = (int) num - 40;
                        String uni = numerosNaturales(nuevoNum);
                        numText = "cuarenta y " + uni;
                    }
                } else if (num < 60) {
                    if (num == 50) {
                        numText = "cincuenta";
                    } else if (num == 51) {
                        numText = "cincuenta y un";
                    } else {
                        int nuevoNum = (int) num - 50;
                        String uni = numerosNaturales(nuevoNum);
                        numText = "cincuenta y " + uni;
                    }
                } else if (num < 70) {
                    if (num == 60) {
                        numText = "sesenta";
                    } else if (num == 61) {
                        numText = "sesenta y un";
                    } else {
                        int nuevoNum = (int) num - 60;
                        String uni = numerosNaturales(nuevoNum);
                        numText = "sesenta y " + uni;
                    }
                } else if (num < 80) {
                    if (num == 70) {
                        numText = "setenta";
                    } else if (num == 71) {
                        numText = "setenta y un";
                    } else {
                        int nuevoNum = (int) num - 70;
                        String uni = numerosNaturales(nuevoNum);
                        numText = "setenta y " + uni;
                    }
                } else if (num < 90) {
                    if (num == 80) {
                        numText = "ochenta";
                    } else if (num == 81) {
                        numText = "ochenta y un";
                    } else {
                        int nuevoNum = (int) num - 80;
                        String uni = numerosNaturales(nuevoNum);
                        numText = "ochenta y " + uni;
                    }
                } else if (num < 100) {
                    if (num == 90) {
                        numText = "noventa";
                    } else if (num == 91) {
                        numText = "noventa y un";
                    } else {
                        int nuevoNum = (int) num - 90;
                        String uni = numerosNaturales(nuevoNum);
                        numText = "noventa y " + uni;
                    }
                } else if (num == 100) {
                    numText = "cien";
                }
            } else {
                if (num < 20) {
                    switch ((int) num) {
                        case 10:
                            numText = "diez";
                            break;
                        case 11:
                            numText = "once";
                            break;
                        case 12:
                            numText = "doce";
                            break;
                        case 13:
                            numText = "trece";
                            break;
                        case 14:
                            numText = "catorce";
                            break;
                        case 15:
                            numText = "quince";
                            break;
                        case 16:
                            numText = "diesciseis";
                            break;
                        case 17:
                            numText = "diescisiete";
                            break;
                        case 18:
                            numText = "diesciocho";
                            break;
                        case 19:
                            numText = "diescinueve";
                            break;
                    }
                } else {
                    switch ((int) num) {
                        case 20:
                            numText = "veinte";
                            break;
                        case 21:
                            numText = "veintiun";
                            break;
                        case 22:
                            numText = "veintidos";
                            break;
                        case 23:
                            numText = "veintitres";
                            break;
                        case 24:
                            numText = "veinticuatro";
                            break;
                        case 25:
                            numText = "veinticinco";
                            break;
                        case 26:
                            numText = "veintiseis";
                            break;
                        case 27:
                            numText = "veintisiete";
                            break;
                        case 28:
                            numText = "veintiocho";
                            break;
                        case 29:
                            numText = "veintinueve";
                            break;
                    }
                }
            }
        }
        return numText.trim();
    }

    public String hallarCategoria(int x) {
        if (x <= 50) {
            return "D";
        } else if (x <= 65) {
            return "C";
        } else if (x <= 80) {
            return "B";
        } else if (x <= 90) {
            return "A";
        } else if (x > 90) {
            return "AD";
        }
        return "";
    }

    public String condicion(int z) {
        if(promAsis<50 || z < 65){
            JOptionPane.showMessageDialog(this,"No tiene derecho por inasistencia");
            //if (z < 65)
            return "desaprobado";               
        } else {
            JOptionPane.showMessageDialog(this,"Estudiante admitido");
            return "aprobado";
        }        
}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTurno = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        pnTituloCueto = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnPestañas = new javax.swing.JTabbedPane();
        VentanaInicio = new javax.swing.JPanel();
        btnDocente = new javax.swing.JButton();
        btnRegistroCalif = new javax.swing.JButton();
        btnResultadoNotas = new javax.swing.JButton();
        btnEstudiante = new javax.swing.JButton();
        btnTablaDocente = new javax.swing.JButton();
        pnResultado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiantes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEliminarTodo = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnAgregarAlum = new javax.swing.JButton();
        pnDatosEstudiante = new javax.swing.JPanel();
        lblEti8 = new javax.swing.JLabel();
        lblEti10 = new javax.swing.JLabel();
        txtNotaAc1 = new javax.swing.JTextField();
        lblEti11 = new javax.swing.JLabel();
        txtNotaAc2 = new javax.swing.JTextField();
        lblEti13 = new javax.swing.JLabel();
        txtNotaAc3 = new javax.swing.JTextField();
        lblEti12 = new javax.swing.JLabel();
        txtNotaAc4 = new javax.swing.JTextField();
        lblEti15 = new javax.swing.JLabel();
        txtNotaCon1 = new javax.swing.JTextField();
        lblEti16 = new javax.swing.JLabel();
        txtNotaCon2 = new javax.swing.JTextField();
        lblEti17 = new javax.swing.JLabel();
        txtNotaCon3 = new javax.swing.JTextField();
        lblEti18 = new javax.swing.JLabel();
        txtNotaCon4 = new javax.swing.JTextField();
        lblEti19 = new javax.swing.JLabel();
        lblEti20 = new javax.swing.JLabel();
        lblEti21 = new javax.swing.JLabel();
        txtNotaP1 = new javax.swing.JTextField();
        btnSiguiente2 = new javax.swing.JButton();
        cboSemanas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardarAlum = new javax.swing.JButton();
        pnEstudiantes = new javax.swing.JPanel();
        lblEti3 = new javax.swing.JLabel();
        lblEti4 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        lblEti5 = new javax.swing.JLabel();
        txtCorreoEstudiante = new javax.swing.JTextField();
        lblEti6 = new javax.swing.JLabel();
        btnSiguiente1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboTurno = new javax.swing.JComboBox<>();
        lblTituloEstud = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRepo = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbRegistroDocente = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        pnDocente = new javax.swing.JPanel();
        txtNombresDocente = new javax.swing.JTextField();
        lblEti1 = new javax.swing.JLabel();
        txtFormacionAcademica = new javax.swing.JTextField();
        lblEti2 = new javax.swing.JLabel();
        lblEti9 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        lblEti14 = new javax.swing.JLabel();
        txtApellidosDocente = new javax.swing.JTextField();
        cboSituacionLaboral = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblEspecialidad1 = new javax.swing.JLabel();
        cboProgramEstudio = new javax.swing.JComboBox<>();
        lblUD1 = new javax.swing.JLabel();
        txtUnidadDidactica = new javax.swing.JTextField();
        lblCreditos1 = new javax.swing.JLabel();
        txtCantCreditos = new javax.swing.JTextField();
        lblEti23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboHorasTeoria = new javax.swing.JComboBox<>();
        lblLab = new javax.swing.JLabel();
        cboHorasLab = new javax.swing.JComboBox<>();
        lblTeoria = new javax.swing.JLabel();
        cboUseLab = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTituloCueto.setBackground(new java.awt.Color(51, 102, 255));
        pnTituloCueto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("I.E.S.T.P. CARLOS CUETO FERNANDINI");
        pnTituloCueto.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 720, 80));

        pnPestañas.setForeground(new java.awt.Color(255, 255, 255));

        VentanaInicio.setBackground(new java.awt.Color(255, 255, 204));
        VentanaInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDocente.setForeground(new java.awt.Color(0, 0, 0));
        btnDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profesor.png"))); // NOI18N
        btnDocente.setText("Docente");
        btnDocente.setContentAreaFilled(false);
        btnDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDocente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });
        VentanaInicio.add(btnDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        btnRegistroCalif.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistroCalif.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistroCalif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RegistroCalificaciones.png"))); // NOI18N
        btnRegistroCalif.setText("Registro de Calificaciones");
        btnRegistroCalif.setContentAreaFilled(false);
        btnRegistroCalif.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistroCalif.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistroCalif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroCalifActionPerformed(evt);
            }
        });
        VentanaInicio.add(btnRegistroCalif, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        btnResultadoNotas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResultadoNotas.setForeground(new java.awt.Color(0, 0, 0));
        btnResultadoNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Resultados.png"))); // NOI18N
        btnResultadoNotas.setText("Resultado de Estudiante");
        btnResultadoNotas.setContentAreaFilled(false);
        btnResultadoNotas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResultadoNotas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnResultadoNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadoNotasActionPerformed(evt);
            }
        });
        VentanaInicio.add(btnResultadoNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, -1, -1));

        btnEstudiante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEstudiante.setForeground(new java.awt.Color(0, 0, 0));
        btnEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Estudiante.png"))); // NOI18N
        btnEstudiante.setText("Estudiante");
        btnEstudiante.setContentAreaFilled(false);
        btnEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstudiante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });
        VentanaInicio.add(btnEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        btnTablaDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTablaDocente.setForeground(new java.awt.Color(0, 0, 0));
        btnTablaDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DatosDocente.png"))); // NOI18N
        btnTablaDocente.setText("Tabla Docentes");
        btnTablaDocente.setContentAreaFilled(false);
        btnTablaDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTablaDocente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTablaDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaDocenteActionPerformed(evt);
            }
        });
        VentanaInicio.add(btnTablaDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 160, 150));

        pnPestañas.addTab("Principal", VentanaInicio);

        pnResultado.setBackground(new java.awt.Color(255, 255, 204));
        pnResultado.setPreferredSize(new java.awt.Dimension(840, 300));
        pnResultado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 0));

        tbEstudiantes.setBackground(new java.awt.Color(255, 255, 255));
        tbEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbEstudiantes);

        pnResultado.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 300));

        btnEliminar.setBackground(new java.awt.Color(51, 51, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar registro");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnResultado.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, 40));

        btnEliminarTodo.setBackground(new java.awt.Color(51, 51, 255));
        btnEliminarTodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarTodo.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTodo.setText("Eliminar todo");
        btnEliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTodoActionPerformed(evt);
            }
        });
        pnResultado.add(btnEliminarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, -1, 40));

        btnModificar1.setBackground(new java.awt.Color(51, 51, 255));
        btnModificar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar1.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonSiguiente.png"))); // NOI18N
        btnModificar1.setBorderPainted(false);
        btnModificar1.setContentAreaFilled(false);
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });
        pnResultado.add(btnModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 330, 40, 40));

        btnAgregarAlum.setBackground(new java.awt.Color(0, 0, 255));
        btnAgregarAlum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAlum.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAlum.setText("Agregar registro");
        btnAgregarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlumActionPerformed(evt);
            }
        });
        pnResultado.add(btnAgregarAlum, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 150, 40));

        pnPestañas.addTab("Resultados", pnResultado);

        pnDatosEstudiante.setBackground(new java.awt.Color(255, 255, 204));
        pnDatosEstudiante.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEti8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEti8.setForeground(new java.awt.Color(0, 0, 0));
        lblEti8.setText("Actitudes");
        pnDatosEstudiante.add(lblEti8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        lblEti10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti10.setForeground(new java.awt.Color(0, 0, 0));
        lblEti10.setText("Nota 1");
        pnDatosEstudiante.add(lblEti10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, 30));

        txtNotaAc1.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaAc1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaAc1.setForeground(new java.awt.Color(0, 0, 0));
        txtNotaAc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaAc1ActionPerformed(evt);
            }
        });
        pnDatosEstudiante.add(txtNotaAc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 80, 30));

        lblEti11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti11.setForeground(new java.awt.Color(0, 0, 0));
        lblEti11.setText("Nota 2");
        pnDatosEstudiante.add(lblEti11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, 30));

        txtNotaAc2.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaAc2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaAc2.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.add(txtNotaAc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 80, 30));

        lblEti13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti13.setForeground(new java.awt.Color(0, 0, 0));
        lblEti13.setText("Nota 3");
        pnDatosEstudiante.add(lblEti13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, 30));

        txtNotaAc3.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaAc3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaAc3.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.add(txtNotaAc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 81, 30));

        lblEti12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti12.setForeground(new java.awt.Color(0, 0, 0));
        lblEti12.setText("Nota 4");
        pnDatosEstudiante.add(lblEti12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, -1, 30));

        txtNotaAc4.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaAc4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaAc4.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.add(txtNotaAc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 80, 30));

        lblEti15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti15.setForeground(new java.awt.Color(0, 0, 0));
        lblEti15.setText("Nota 1");
        pnDatosEstudiante.add(lblEti15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, 30));

        txtNotaCon1.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaCon1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaCon1.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.add(txtNotaCon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 81, 30));

        lblEti16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti16.setForeground(new java.awt.Color(0, 0, 0));
        lblEti16.setText("Nota 2");
        pnDatosEstudiante.add(lblEti16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, 30));

        txtNotaCon2.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaCon2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaCon2.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.add(txtNotaCon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 81, 30));

        lblEti17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEti17.setForeground(new java.awt.Color(0, 0, 0));
        lblEti17.setText("Nota 3");
        pnDatosEstudiante.add(lblEti17, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, -1, 30));

        txtNotaCon3.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaCon3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaCon3.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.add(txtNotaCon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 81, 30));

        lblEti18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEti18.setForeground(new java.awt.Color(0, 0, 0));
        lblEti18.setText("Nota 4");
        pnDatosEstudiante.add(lblEti18, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        txtNotaCon4.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaCon4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaCon4.setForeground(new java.awt.Color(0, 0, 0));
        pnDatosEstudiante.add(txtNotaCon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 81, 30));

        lblEti19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEti19.setForeground(new java.awt.Color(0, 0, 0));
        lblEti19.setText("Semanas");
        pnDatosEstudiante.add(lblEti19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, 30));

        lblEti20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEti20.setForeground(new java.awt.Color(0, 0, 0));
        lblEti20.setText("Conocimientos");
        pnDatosEstudiante.add(lblEti20, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, 20));

        lblEti21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEti21.setForeground(new java.awt.Color(0, 0, 0));
        lblEti21.setText("Procedimental");
        pnDatosEstudiante.add(lblEti21, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, -1, 20));

        txtNotaP1.setBackground(new java.awt.Color(255, 255, 255));
        txtNotaP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNotaP1.setForeground(new java.awt.Color(0, 0, 0));
        txtNotaP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaP1ActionPerformed(evt);
            }
        });
        pnDatosEstudiante.add(txtNotaP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 80, 30));

        btnSiguiente2.setBackground(new java.awt.Color(0, 0, 255));
        btnSiguiente2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSiguiente2.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonSiguiente.png"))); // NOI18N
        btnSiguiente2.setText("Siguiente");
        btnSiguiente2.setHideActionText(true);
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });
        pnDatosEstudiante.add(btnSiguiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 320, -1, -1));

        cboSemanas.setBackground(new java.awt.Color(0, 0, 255));
        cboSemanas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboSemanas.setForeground(new java.awt.Color(255, 255, 255));
        cboSemanas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34" }));
        cboSemanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSemanasActionPerformed(evt);
            }
        });
        pnDatosEstudiante.add(cboSemanas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("REGISTRO DE CALIFICACIONES");
        pnDatosEstudiante.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 390, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calificacion.png"))); // NOI18N
        pnDatosEstudiante.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 370));

        btnGuardarAlum.setBackground(new java.awt.Color(0, 0, 255));
        btnGuardarAlum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardarAlum.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarAlum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonGuardar.png"))); // NOI18N
        btnGuardarAlum.setText("Guardar");
        btnGuardarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlumActionPerformed(evt);
            }
        });
        pnDatosEstudiante.add(btnGuardarAlum, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 130, 40));

        pnPestañas.addTab("Registro de Calificaciones", pnDatosEstudiante);

        pnEstudiantes.setBackground(new java.awt.Color(255, 255, 204));
        pnEstudiantes.setPreferredSize(new java.awt.Dimension(1120, 400));
        pnEstudiantes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEti3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti3.setForeground(new java.awt.Color(0, 0, 0));
        lblEti3.setText("Apellidos");
        pnEstudiantes.add(lblEti3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, 20));

        lblEti4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti4.setForeground(new java.awt.Color(0, 0, 0));
        lblEti4.setText("Nombres");
        pnEstudiantes.add(lblEti4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, 20));

        txtNombres.setBackground(new java.awt.Color(255, 255, 255));
        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        pnEstudiantes.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 220, 30));

        txtApellidos.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        pnEstudiantes.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 220, 30));

        lblEti5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti5.setForeground(new java.awt.Color(0, 0, 0));
        lblEti5.setText("Turno");
        pnEstudiantes.add(lblEti5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 50, 40));

        txtCorreoEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreoEstudiante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorreoEstudiante.setForeground(new java.awt.Color(0, 0, 0));
        pnEstudiantes.add(txtCorreoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 250, 30));

        lblEti6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti6.setForeground(new java.awt.Color(0, 0, 0));
        lblEti6.setText("Correo");
        pnEstudiantes.add(lblEti6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, 20));

        btnSiguiente1.setBackground(new java.awt.Color(0, 0, 255));
        btnSiguiente1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSiguiente1.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonSiguiente.png"))); // NOI18N
        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.setHideActionText(true);
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });
        pnEstudiantes.add(btnSiguiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Estudiante_1.png"))); // NOI18N
        pnEstudiantes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 340));

        cboTurno.setBackground(new java.awt.Color(0, 0, 255));
        cboTurno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTurno.setForeground(new java.awt.Color(255, 255, 255));
        cboTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turno", "Diurno", "Nocturno" }));
        pnEstudiantes.add(cboTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 110, 40));

        lblTituloEstud.setBackground(new java.awt.Color(0, 0, 255));
        lblTituloEstud.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloEstud.setForeground(new java.awt.Color(0, 0, 204));
        lblTituloEstud.setText("Datos del Estudiante");
        pnEstudiantes.add(lblTituloEstud, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        pnPestañas.addTab("Estudiante", pnEstudiantes);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRepo.setBackground(new java.awt.Color(255, 255, 255));
        txtRepo.setColumns(20);
        txtRepo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRepo.setRows(5);
        jScrollPane2.setViewportView(txtRepo);

        jScrollPane4.setViewportView(jScrollPane2);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 300));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Principal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 130, 40));

        jButton3.setBackground(new java.awt.Color(0, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 110, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnPestañas.addTab("Reporte", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbRegistroDocente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbRegistroDocente);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 370));

        jButton5.setText("Principal");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 270, -1, -1));

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, -1, -1));

        pnPestañas.addTab("Tabla Docentes", jPanel3);

        pnDocente.setBackground(new java.awt.Color(255, 255, 204));
        pnDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombresDocente.setBackground(new java.awt.Color(255, 255, 255));
        txtNombresDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombresDocente.setForeground(new java.awt.Color(0, 0, 0));
        txtNombresDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresDocenteActionPerformed(evt);
            }
        });
        pnDocente.add(txtNombresDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 270, 30));

        lblEti1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti1.setForeground(new java.awt.Color(0, 0, 0));
        lblEti1.setText("Nombres del docente");
        pnDocente.add(lblEti1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 17, -1, 30));

        txtFormacionAcademica.setBackground(new java.awt.Color(255, 255, 255));
        txtFormacionAcademica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFormacionAcademica.setForeground(new java.awt.Color(0, 0, 0));
        txtFormacionAcademica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormacionAcademicaActionPerformed(evt);
            }
        });
        pnDocente.add(txtFormacionAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 270, 30));

        lblEti2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti2.setForeground(new java.awt.Color(0, 0, 0));
        lblEti2.setText("Formación académica");
        pnDocente.add(lblEti2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 40));

        lblEti9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti9.setForeground(new java.awt.Color(0, 0, 0));
        lblEti9.setText("Situación Laboral");
        pnDocente.add(lblEti9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 40));

        btnSiguiente.setBackground(new java.awt.Color(0, 0, 255));
        btnSiguiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonSiguiente.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        pnDocente.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        lblEti14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti14.setForeground(new java.awt.Color(0, 0, 0));
        lblEti14.setText("Apellidos del Docente");
        pnDocente.add(lblEti14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 40));

        txtApellidosDocente.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidosDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApellidosDocente.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidosDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosDocenteActionPerformed(evt);
            }
        });
        pnDocente.add(txtApellidosDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 270, 30));

        cboSituacionLaboral.setBackground(new java.awt.Color(0, 0, 255));
        cboSituacionLaboral.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboSituacionLaboral.setForeground(new java.awt.Color(255, 255, 255));
        cboSituacionLaboral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Situación Laboral", "Nombrado", "Contratado", "Por horas" }));
        pnDocente.add(cboSituacionLaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 270, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonGuardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnDocente.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Rondan.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        pnDocente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 410, 370));

        lblEspecialidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEspecialidad1.setForeground(new java.awt.Color(0, 0, 0));
        lblEspecialidad1.setText("Programa de estudio");
        pnDocente.add(lblEspecialidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 30));

        cboProgramEstudio.setBackground(new java.awt.Color(0, 0, 255));
        cboProgramEstudio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboProgramEstudio.setForeground(new java.awt.Color(255, 255, 255));
        cboProgramEstudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Especialidades", "Arquitectura de Plataformas y Servicios de Tecnologías de la Información", "Contabilidad", "Electricidad Industrial", "Electrónica Industrial", "Gestión Administrativa", "Laboratorio Clínico y Anatomía Patológica", "Mecánica Automotriz", "Mecánica de Producción Industrial", "Metalurgia", "Administración de Empresas", " ", " " }));
        pnDocente.add(cboProgramEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 320, 30));

        lblUD1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUD1.setForeground(new java.awt.Color(0, 0, 0));
        lblUD1.setText("Unidad didáctica");
        pnDocente.add(lblUD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, 30));

        txtUnidadDidactica.setBackground(new java.awt.Color(255, 255, 255));
        txtUnidadDidactica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUnidadDidactica.setForeground(new java.awt.Color(0, 0, 0));
        txtUnidadDidactica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadDidacticaActionPerformed(evt);
            }
        });
        pnDocente.add(txtUnidadDidactica, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 320, 30));

        lblCreditos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCreditos1.setForeground(new java.awt.Color(0, 0, 0));
        lblCreditos1.setText("Créditos");
        pnDocente.add(lblCreditos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, 30));

        txtCantCreditos.setBackground(new java.awt.Color(255, 255, 255));
        txtCantCreditos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCantCreditos.setForeground(new java.awt.Color(0, 0, 0));
        pnDocente.add(txtCantCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 50, 30));

        lblEti23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEti23.setForeground(new java.awt.Color(0, 0, 0));
        lblEti23.setText("Laboratorio");
        pnDocente.add(lblEti23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Horas:");
        pnDocente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, 30));

        cboHorasTeoria.setBackground(new java.awt.Color(0, 0, 255));
        cboHorasTeoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboHorasTeoria.setForeground(new java.awt.Color(255, 255, 255));
        cboHorasTeoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));
        pnDocente.add(cboHorasTeoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 50, 30));

        lblLab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLab.setForeground(new java.awt.Color(0, 0, 0));
        lblLab.setText("L");
        pnDocente.add(lblLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, -1, 30));

        cboHorasLab.setBackground(new java.awt.Color(0, 0, 255));
        cboHorasLab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboHorasLab.setForeground(new java.awt.Color(255, 255, 255));
        cboHorasLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));
        pnDocente.add(cboHorasLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 50, 30));

        lblTeoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTeoria.setForeground(new java.awt.Color(0, 0, 0));
        lblTeoria.setText("T");
        pnDocente.add(lblTeoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, 30));

        cboUseLab.setBackground(new java.awt.Color(0, 0, 255));
        cboUseLab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboUseLab.setForeground(new java.awt.Color(255, 255, 255));
        cboUseLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opción", "Si", "No" }));
        cboUseLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUseLabActionPerformed(evt);
            }
        });
        pnDocente.add(cboUseLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 90, 40));

        pnPestañas.addTab("Docente", pnDocente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnTituloCueto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTituloCueto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mostrarTooltipInmediato(JComponent campo) {
    ToolTipManager.sharedInstance().setInitialDelay(0);
    MouseEvent phantom = new MouseEvent(campo, MouseEvent.MOUSE_MOVED,
            System.currentTimeMillis(), 0, 0, 0, 0, false);
    ToolTipManager.sharedInstance().mouseMoved(phantom);
    }

    
    private boolean validarDatosDocente(){
        boolean valido=true;
        
        if(!txtNombresDocente.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            txtNombresDocente.setToolTipText("Error: Solo se permiten letras");
            txtNombresDocente.requestFocus();
            mostrarTooltipInmediato(txtNombresDocente);
            valido=false;        
        }else        
        if(!txtApellidosDocente.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            txtApellidosDocente.setToolTipText("Error: Solo se permiten letras");
            txtApellidosDocente.requestFocus();
            mostrarTooltipInmediato(txtApellidosDocente);
            valido=false;        
        }else 
            if(!txtFormacionAcademica.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            txtFormacionAcademica.setToolTipText("Error: Solo se permiten letras");
            txtFormacionAcademica.requestFocus();
            mostrarTooltipInmediato(txtFormacionAcademica);
            valido=false;        
        }else 
            if (cboSituacionLaboral.getSelectedIndex() == 0) {
        cboSituacionLaboral.setToolTipText("Error: Debe seleccionar una situación laboral");
        cboSituacionLaboral.requestFocus();
        mostrarTooltipInmediato(cboSituacionLaboral);
        valido = false;
        } else 
            if (cboProgramEstudio.getSelectedIndex() == 0) {
        cboProgramEstudio.setToolTipText("Error: Debe seleccionar una especialidad");
        cboProgramEstudio.requestFocus();
        mostrarTooltipInmediato(cboProgramEstudio);
        valido = false;
        } else
            if(!txtUnidadDidactica.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            txtUnidadDidactica.setToolTipText("Error: Solo se permiten letras");
            txtUnidadDidactica.requestFocus();
            mostrarTooltipInmediato(txtUnidadDidactica);
            valido=false;        
        }else  
            if (cboHorasTeoria.getSelectedIndex() == 0) {
        cboHorasTeoria.setToolTipText("Error: Debe seleccionar un número");
        cboHorasTeoria.requestFocus();
        mostrarTooltipInmediato(cboHorasTeoria);
        valido = false;
        }else 
            if(cboUseLab.getSelectedIndex()==0){
               cboUseLab.setToolTipText("Error: Debe seleccionar (Diurno o nocturno)");
               cboUseLab.requestFocus();
               mostrarTooltipInmediato(cboUseLab);
               valido = false; 
            }
        
        
        try {
            double creditos = Double.parseDouble(txtCantCreditos.getText().trim());
            // Puedes agregar validaciones adicionales, como que sea positivo
            if (creditos <= 0) {
                txtCantCreditos.setToolTipText("Error: El número debe ser mayor que cero");
                txtCantCreditos.requestFocus();
                mostrarTooltipInmediato(txtCantCreditos);
                valido = false;
            }
        } catch (NumberFormatException e) {
            txtCantCreditos.setToolTipText("Error: Ingrese un número válido (por ejemplo: 3.5)");
            txtCantCreditos.requestFocus();
            mostrarTooltipInmediato(txtCantCreditos);
            valido = false;
        }        
        return valido;
    }  
    
    
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        validarDatosDocente();              
        mensajeIngresarDatos();
        int filaActual1 = modelo.getRowCount();
        modelo1.addRow(new Object[modelo.getColumnCount()]);

        modelo1.setValueAt(txtNombresDocente.getText(), filaActual1, 0);
        modelo1.setValueAt(txtApellidosDocente.getText(), filaActual1, 1);
        modelo1.setValueAt(txtFormacionAcademica.getText(), filaActual1, 2);
        modelo1.setValueAt(cboSituacionLaboral.getSelectedItem(), filaActual1, 3);
        modelo1.setValueAt(cboProgramEstudio.getSelectedItem(), filaActual1, 4);
        modelo1.setValueAt(txtUnidadDidactica.getText(), filaActual1, 5);
        modelo1.setValueAt(getCreditosUD(), filaActual1, 6);
        modelo1.setValueAt(cboHorasTeoria.getSelectedItem(),filaActual1,7);
        modelo1.setValueAt(cboHorasLab.getSelectedItem(), filaActual1, 8);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtApellidosDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosDocenteActionPerformed
        txtApellidosDocente.setToolTipText("Solo letras permitidas");
    }//GEN-LAST:event_txtApellidosDocenteActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        pnPestañas.setSelectedIndex(0);
        activarBoton2();
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtFormacionAcademicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormacionAcademicaActionPerformed
        txtFormacionAcademica.setToolTipText("Solo letras permitidas");
    }//GEN-LAST:event_txtFormacionAcademicaActionPerformed

    private void txtNombresDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresDocenteActionPerformed
        txtApellidosDocente.setToolTipText("Solo letras permitidas");
    }//GEN-LAST:event_txtNombresDocenteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtRepo.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pnPestañas.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void mostrarTooltipInmediat(JComponent campo) {
    ToolTipManager.sharedInstance().setInitialDelay(0);
    MouseEvent phanto = new MouseEvent(campo, MouseEvent.MOUSE_MOVED,
            System.currentTimeMillis(), 0, 0, 0, 0, false);
    ToolTipManager.sharedInstance().mouseMoved(phanto);
    }
    
    void mensajeIngresarDatos(){
        JOptionPane.showMessageDialog(null,"Ingreso de datos correctos");
    }
    
    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed
        validarDatosEstudiante();
        mensajeIngresarDatos();
        pnPestañas.setSelectedIndex(0);
        activarBoton4();
    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private boolean validarDatosEstudiante(){
        boolean valido=true;
        if(!txtApellidos.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            txtApellidos.setToolTipText("Error: Solo se permiten letras");
            txtApellidos.requestFocus();
            mostrarTooltipInmediat(txtApellidos);
            valido=false;     
        } else if(!txtNombres.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            txtNombres.setToolTipText("Error: Solo se permiten letras");
            txtNombres.requestFocus();
            mostrarTooltipInmediato(txtNombres);
            valido=false;
        } else if(!txtCorreoEstudiante.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            txtCorreoEstudiante.setToolTipText("Error: Solo se permiten letras");
            txtCorreoEstudiante.requestFocus();
            mostrarTooltipInmediato(txtCorreoEstudiante);
            valido=false;
        }   else if (cboUseLab.getSelectedIndex() == 0) {
        cboUseLab.setToolTipText("Error: Debe seleccionar (Si/No)");
        cboUseLab.requestFocus();
        mostrarTooltipInmediato(cboUseLab);
        valido = false;
        } else if (cboTurno.getSelectedIndex() == 0) {
        cboTurno.setToolTipText("Error: Debe seleccionar (Diurno/Nocturno)");
        cboTurno.requestFocus();
        mostrarTooltipInmediato(cboTurno);
        valido = false;
        }
            
        return valido;
    }    
        
        
    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        validarDatosEstudiante();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        
    }//GEN-LAST:event_txtNombresActionPerformed

    private void cboSemanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSemanasActionPerformed

    }//GEN-LAST:event_cboSemanasActionPerformed

    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
        double a = Double.parseDouble(txtNotaAc1.getText());
        double b = Double.parseDouble(txtNotaAc2.getText());
        double c = Double.parseDouble(txtNotaAc3.getText());
        double d = Double.parseDouble(txtNotaAc4.getText());
        double e = Double.parseDouble(txtNotaCon1.getText());
        double f = Double.parseDouble(txtNotaCon2.getText());
        double g = Double.parseDouble(txtNotaCon3.getText());
        double h = Double.parseDouble(txtNotaCon4.getText());
        double i = Double.parseDouble(txtNotaP1.getText());

        int validacion = validacionNotas(a, b, c, d, e, f, g, h, i);

        if (validacion == 1) {
            pnPestañas.setSelectedIndex(0);
            activarBoton5();
        } else {
            JOptionPane.showMessageDialog(this, "Error \nFuera de rango");
        }
        

    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    private void txtNotaP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaP1ActionPerformed

    }//GEN-LAST:event_txtNotaP1ActionPerformed

    private void txtNotaAc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaAc1ActionPerformed
        double x = Double.parseDouble(txtNotaAc1.getText());
        if (x >= 0 && x <= 20) {

        } else {
            JOptionPane.showMessageDialog(this, "Error \nFuera de rango");
            txtNotaAc1.setText("");
            txtNotaAc1.requestFocus();
        }
    }//GEN-LAST:event_txtNotaAc1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        pnPestañas.setSelectedIndex(4);
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTodoActionPerformed
        int fila = tbEstudiantes.getRowCount();
        for (int i = fila - 1; i >= 0; i--)
        modelo.removeRow(i);
    }//GEN-LAST:event_btnEliminarTodoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tbEstudiantes.getSelectedRow();
        if (fila >= 0) {
            modelo.removeRow(fila);
        } else
        JOptionPane.showMessageDialog(this, "Seleccionar la fila");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
        pnPestañas.setSelectedIndex(3);
    }//GEN-LAST:event_btnEstudianteActionPerformed

    private void btnResultadoNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadoNotasActionPerformed
        pnPestañas.setSelectedIndex(1);
    }//GEN-LAST:event_btnResultadoNotasActionPerformed

    private void btnRegistroCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroCalifActionPerformed
        pnPestañas.setSelectedIndex(2);
    }//GEN-LAST:event_btnRegistroCalifActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        String[] usuarios = {"Maximiliano", "Maricielo", "Balarezo"};
        String[] contrasenas = {"Alexus", "Garcia", "Dibujante"};
        boolean accesoConcedido = false;

        for (int intento = 1; intento <= 3; intento++) {
            // Pedir usuario            
            String usuario = JOptionPane.showInputDialog("Intento " + intento + " de 3\nIngrese su usuario:");            
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Ingreso cancelado.");
                break;
            }

            // Crear campo de contraseña con ocultamiento
            JPasswordField passwordField = new JPasswordField();
            Object[] mensaje = {"Ingrese su contraseña:", passwordField};
            int opcion = JOptionPane.showConfirmDialog(null, mensaje,
                "Contraseña", JOptionPane.OK_CANCEL_OPTION);

            if (opcion != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Ingreso cancelado.");
                break;
            }

            String contrasena = new String(passwordField.getPassword());

            // Validar usuario y contraseña
            for (int i = 0; i < usuarios.length; i++) {
                if (usuario.equals(usuarios[i]) && contrasena.equals(contrasenas[i])) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
                    accesoConcedido = true;
                    pnPestañas.setSelectedIndex(6);
                    break;
                }
            }

            if (accesoConcedido) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        }

        if (!accesoConcedido) {
            JOptionPane.showMessageDialog(null, "Acceso bloqueado. Límite de intentos alcanzado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

                
        
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void btnTablaDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaDocenteActionPerformed
        pnPestañas.setSelectedIndex(5);
    }//GEN-LAST:event_btnTablaDocenteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        pnPestañas.setSelectedIndex(0);
        activarBoton3();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnGuardarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlumActionPerformed
        procesar();        
    }//GEN-LAST:event_btnGuardarAlumActionPerformed

    private void btnAgregarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlumActionPerformed
        pnPestañas.setSelectedIndex(3);        
        
        // Borrado datos de estudiante
        txtApellidos.setText("");
        txtNombres.setText("");
        txtCorreoEstudiante.setText("");
        cboUseLab.setSelectedIndex(0);
        cboTurno.setSelectedIndex(0);
        
        // Borrado de notas
        cboSemanas.setSelectedIndex(0);
        txtNotaAc1.setText("");
        txtNotaAc2.setText("");
        txtNotaAc3.setText("");
        txtNotaAc4.setText("");
        txtNotaCon1.setText("");
        txtNotaCon2.setText("");
        txtNotaCon3.setText("");
        txtNotaCon4.setText("");
        txtNotaP1.setText("");
    }//GEN-LAST:event_btnAgregarAlumActionPerformed
    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int fila = tbRegistroDocente.getRowCount();
        for (int i = fila - 1; i >= 0; i--)
        modelo1.removeRow(i);
        
        // Borrado datos de docente
        txtNombresDocente.setText("");
        txtFormacionAcademica.setText("");
        cboSituacionLaboral.setSelectedIndex(0);
        cboProgramEstudio.setSelectedIndex(0);
        txtUnidadDidactica.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtUnidadDidacticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadDidacticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadDidacticaActionPerformed

    
    private void cboUseLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUseLabActionPerformed
         int seleccion = cboUseLab.getSelectedIndex();

        if (seleccion == 1) { // Opción 2 (por índice)
            cboHorasLab.setEnabled(true); // Activar
        } else {
            cboHorasLab.setEnabled(false); // Desactivar
        }
    }//GEN-LAST:event_cboUseLabActionPerformed

    public int validacionNotas(double a, double b, double c, double d, double e, double f, double g, double h, double i) {
        int av, bv, cv, dv, ev, fv, gv, hv, iv, numV;

        if (a < 0 || a > 100) {
            av = 0;
        } else {
            av = 1;
        }

        if (b < 0 || b > 100) {
            bv = 0;
        } else {
            bv = 1;
        }

        if (c < 0 || c > 100) {
            cv = 0;
        } else {
            cv = 1;
        }

        if (d < 0 || d > 100) {
            dv = 0;
        } else {
            dv = 1;
        }

        if (e < 0 || e > 100) {
            ev = 0;
        } else {
            ev = 1;
        }

        if (f < 0 || f > 100) {
            fv = 0;
        } else {
            fv = 1;
        }

        if (g < 0 || g > 100) {
            gv = 0;
        } else {
            gv = 1;
        }

        if (h < 0 || h > 100) {
            hv = 0;
        } else {
            hv = 1;
        }

        if (i < 0 || i > 100) {
            iv = 0;
        } else {
            iv = 1;
        }

        numV = av * bv * cv * dv * ev * fv * gv * hv * iv;
        return numV;

    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaOpciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel VentanaInicio;
    private javax.swing.JButton btnAgregarAlum;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarTodo;
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarAlum;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegistroCalif;
    private javax.swing.JButton btnResultadoNotas;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnSiguiente2;
    private javax.swing.JButton btnTablaDocente;
    private javax.swing.ButtonGroup btnTurno;
    private javax.swing.JComboBox<String> cboHorasLab;
    private javax.swing.JComboBox<String> cboHorasTeoria;
    private javax.swing.JComboBox<String> cboProgramEstudio;
    private javax.swing.JComboBox<String> cboSemanas;
    private javax.swing.JComboBox<String> cboSituacionLaboral;
    private javax.swing.JComboBox<String> cboTurno;
    private javax.swing.JComboBox<String> cboUseLab;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCreditos1;
    private javax.swing.JLabel lblEspecialidad1;
    private javax.swing.JLabel lblEti1;
    private javax.swing.JLabel lblEti10;
    private javax.swing.JLabel lblEti11;
    private javax.swing.JLabel lblEti12;
    private javax.swing.JLabel lblEti13;
    private javax.swing.JLabel lblEti14;
    private javax.swing.JLabel lblEti15;
    private javax.swing.JLabel lblEti16;
    private javax.swing.JLabel lblEti17;
    private javax.swing.JLabel lblEti18;
    private javax.swing.JLabel lblEti19;
    private javax.swing.JLabel lblEti2;
    private javax.swing.JLabel lblEti20;
    private javax.swing.JLabel lblEti21;
    private javax.swing.JLabel lblEti23;
    private javax.swing.JLabel lblEti3;
    private javax.swing.JLabel lblEti4;
    private javax.swing.JLabel lblEti5;
    private javax.swing.JLabel lblEti6;
    private javax.swing.JLabel lblEti8;
    private javax.swing.JLabel lblEti9;
    private javax.swing.JLabel lblLab;
    private javax.swing.JLabel lblTeoria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloEstud;
    private javax.swing.JLabel lblUD1;
    private javax.swing.JPanel pnDatosEstudiante;
    private javax.swing.JPanel pnDocente;
    private javax.swing.JPanel pnEstudiantes;
    private javax.swing.JTabbedPane pnPestañas;
    private javax.swing.JPanel pnResultado;
    private javax.swing.JPanel pnTituloCueto;
    private javax.swing.JTable tbEstudiantes;
    private javax.swing.JTable tbRegistroDocente;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosDocente;
    private javax.swing.JTextField txtCantCreditos;
    private javax.swing.JTextField txtCorreoEstudiante;
    private javax.swing.JTextField txtFormacionAcademica;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombresDocente;
    private javax.swing.JTextField txtNotaAc1;
    private javax.swing.JTextField txtNotaAc2;
    private javax.swing.JTextField txtNotaAc3;
    private javax.swing.JTextField txtNotaAc4;
    private javax.swing.JTextField txtNotaCon1;
    private javax.swing.JTextField txtNotaCon2;
    private javax.swing.JTextField txtNotaCon3;
    private javax.swing.JTextField txtNotaCon4;
    private javax.swing.JTextField txtNotaP1;
    private javax.swing.JTextArea txtRepo;
    private javax.swing.JTextField txtUnidadDidactica;
    // End of variables declaration//GEN-END:variables
}
