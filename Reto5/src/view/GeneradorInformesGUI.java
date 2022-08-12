package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import model.generador.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class GeneradorInformesGUI extends javax.swing.JFrame {

    private static Tabla compra;
    private static Tabla lider;
    private static Tabla materialConstruccion;
    private static Tabla proyecto;
    private static Tabla tipo;

    private ArrayList<String> listaCamposAgregados = new ArrayList<>();
    private ArrayList<Class> listaTipoCamposDisponibles = new ArrayList<>();
    private ArrayList<Class> listaTipoCamposAgregados = new ArrayList<>();
    private ArrayList<String> listaTablasAgregadas = new ArrayList<>();
    private ArrayList<Tabla> listaTablasAgregadasCampos = new ArrayList<>();
    private ArrayList<String> listaFiltros = new ArrayList<>();
                                    

    private void crearTablas() {

        compra = new Tabla();
        compra.setNombreTabla("Compra");
        compra.setTablaRequerida("Proyecto");
        compra.setLlave("ID_Proyecto");
        compra.getListaCampos().add("ID_Compra");
        compra.getListaCampos().add("Cantidad");
        compra.getListaCampos().add("Proveedor");
        compra.getListaCampos().add("Pagado");
        compra.getListaCampos().add("Fecha");
        compra.getListaCampos().add("ID_Proyecto");
        compra.getListaCampos().add("ID_MaterialConstruccion");

        compra.getTipoCampos().add(java.lang.Integer.class);
        compra.getTipoCampos().add(java.lang.Double.class);
        compra.getTipoCampos().add(java.lang.Object.class);
        compra.getTipoCampos().add(java.lang.Object.class);
        compra.getTipoCampos().add(java.time.LocalDate.class);
        compra.getTipoCampos().add(java.lang.Integer.class);
        compra.getTipoCampos().add(java.lang.Integer.class);

        lider = new Tabla();
        lider.setNombreTabla("Lider");
        lider.setTablaRequerida("Proyecto");
        lider.setLlave("ID_Lider");
        lider.getListaCampos().add("ID_Lider");
        lider.getListaCampos().add("Nombre");
        lider.getListaCampos().add("Primer_Apellido");
        lider.getListaCampos().add("Segundo_Apellido");
        lider.getListaCampos().add("Salario");
        lider.getListaCampos().add("Ciudad_Residencia");
        lider.getListaCampos().add("Cargo");
        lider.getListaCampos().add("Clasificacion");
        lider.getListaCampos().add("Documento_Identidad");
        lider.getListaCampos().add("Fecha_Nacimiento");

        lider.getTipoCampos().add(java.lang.Integer.class);
        lider.getTipoCampos().add(java.lang.Object.class);
        lider.getTipoCampos().add(java.lang.Object.class);
        lider.getTipoCampos().add(java.lang.Object.class);
        lider.getTipoCampos().add(java.lang.Integer.class);
        lider.getTipoCampos().add(java.lang.Object.class);
        lider.getTipoCampos().add(java.lang.Object.class);
        lider.getTipoCampos().add(java.lang.Integer.class);
        lider.getTipoCampos().add(java.lang.Object.class);
        lider.getTipoCampos().add(java.time.LocalDate.class);

        materialConstruccion = new Tabla();
        materialConstruccion.setNombreTabla("MaterialConstruccion");
        materialConstruccion.setTablaRequerida("Compra");
        materialConstruccion.setLlave("ID_MaterialConstruccion");
        materialConstruccion.getListaCampos().add("ID_MaterialConstruccion");
        materialConstruccion.getListaCampos().add("Nombre_Material");
        materialConstruccion.getListaCampos().add("Importado");
        materialConstruccion.getListaCampos().add("Precio_Unidad");

        materialConstruccion.getTipoCampos().add(java.lang.Integer.class);
        materialConstruccion.getTipoCampos().add(java.lang.Object.class);
        materialConstruccion.getTipoCampos().add(java.lang.Object.class);
        materialConstruccion.getTipoCampos().add(java.lang.Double.class);

        proyecto = new Tabla();
        proyecto.setNombreTabla("Proyecto");
        proyecto.getListaCampos().add("ID_Proyecto");
        proyecto.getListaCampos().add("Fecha_Inicio");
        proyecto.getListaCampos().add("Constructora");
        proyecto.getListaCampos().add("Numero_Banos");
        proyecto.getListaCampos().add("Numero_Habitaciones");
        proyecto.getListaCampos().add("Banco_Vinculado");
        proyecto.getListaCampos().add("Porcentaje_Cuota_Inicial");
        proyecto.getListaCampos().add("Ciudad");
        proyecto.getListaCampos().add("Clasificacion");
        proyecto.getListaCampos().add("Acabados");
        proyecto.getListaCampos().add("Serial");
        proyecto.getListaCampos().add("ID_Tipo");
        proyecto.getListaCampos().add("ID_Lider");

        proyecto.getTipoCampos().add(java.lang.Integer.class);
        proyecto.getTipoCampos().add(java.time.LocalDate.class);
        proyecto.getTipoCampos().add(java.lang.Object.class);
        proyecto.getTipoCampos().add(java.lang.Integer.class);
        proyecto.getTipoCampos().add(java.lang.Integer.class);
        proyecto.getTipoCampos().add(java.lang.Object.class);
        proyecto.getTipoCampos().add(java.lang.Integer.class);
        proyecto.getTipoCampos().add(java.lang.Object.class);
        proyecto.getTipoCampos().add(java.lang.Object.class);
        proyecto.getTipoCampos().add(java.lang.Object.class);
        proyecto.getTipoCampos().add(java.lang.Object.class);
        proyecto.getTipoCampos().add(java.lang.Integer.class);
        proyecto.getTipoCampos().add(java.lang.Integer.class);

        tipo = new Tabla();
        tipo.setNombreTabla("Tipo");
        tipo.setTablaRequerida("Proyecto");
        tipo.setLlave("ID_Tipo");
        tipo.getListaCampos().add("ID_Tipo");
        tipo.getListaCampos().add("Codigo_Tipo");
        tipo.getListaCampos().add("Area_Max");
        tipo.getListaCampos().add("Financiable");
        tipo.getListaCampos().add("Estrato");

        tipo.getTipoCampos().add(java.lang.Integer.class);
        tipo.getTipoCampos().add(java.lang.Integer.class);
        tipo.getTipoCampos().add(java.lang.Integer.class);
        tipo.getTipoCampos().add(java.lang.Integer.class);
        tipo.getTipoCampos().add(java.lang.Integer.class);

    }

    public GeneradorInformesGUI() {
        initComponents();
        setLocationRelativeTo(null);
        crearTablas();
        actualizarAgregados();
        
        comboListaFiltros.removeAllItems();
               
        comboListaFiltros.addItem(" =  Igual a");
        comboListaFiltros.addItem(" >  Mayor que");
        comboListaFiltros.addItem(" <  Menor que");
        comboListaFiltros.addItem(" >=  Mayor o igual a");
        comboListaFiltros.addItem(" <=  Menor o igual a");
        comboListaFiltros.addItem(" !=  Diferente a");
        comboListaFiltros.addItem("<%>  Entre");
        comboListaFiltros.addItem("(%)  Contiene");

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
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListTablasAgregadas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listListaTablas = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listListaCampos = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListCamposAgregados = new javax.swing.JList<>();
        btnAgregarTabla = new javax.swing.JButton();
        btnQuitarTabla = new javax.swing.JButton();
        btnAgregarColumna = new javax.swing.JButton();
        btnQuitarColumna = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboListaCamposAgregados = new javax.swing.JComboBox<>();
        comboListaFiltros = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListFiltrosAgregados = new javax.swing.JList<>();
        btnAgregarFiltroY = new javax.swing.JButton();
        btnAgregarFiltroO = new javax.swing.JButton();
        btnQuitarFiltro = new javax.swing.JButton();
        btnGenerarInforme = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generador de Informes");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo2.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generador de Informes");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Seleccione las tablas a consultar:");

        ListTablasAgregadas.setBackground(new java.awt.Color(0, 0, 0));
        ListTablasAgregadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ListTablasAgregadas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ListTablasAgregadas.setForeground(new java.awt.Color(255, 255, 255));
        ListTablasAgregadas.setToolTipText("Doble clic para quitar tabla");
        ListTablasAgregadas.setSelectionBackground(new java.awt.Color(153, 153, 153));
        ListTablasAgregadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListTablasAgregadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListTablasAgregadas);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tablas agregadas:");

        listListaTablas.setBackground(new java.awt.Color(0, 0, 0));
        listListaTablas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        listListaTablas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listListaTablas.setForeground(new java.awt.Color(255, 255, 255));
        listListaTablas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Compra", "Lider", "MaterialConstruccion", "Proyecto", "Tipo" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listListaTablas.setToolTipText("Doble clic para agregar tabla");
        listListaTablas.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listListaTablas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listListaTablasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listListaTablas);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Seleccione las columnas a agregar:");

        listListaCampos.setBackground(new java.awt.Color(0, 0, 0));
        listListaCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        listListaCampos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listListaCampos.setForeground(new java.awt.Color(255, 255, 255));
        listListaCampos.setToolTipText("Doble clic para agregar columna");
        listListaCampos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listListaCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listListaCamposMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listListaCampos);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Filtros agregados");

        ListCamposAgregados.setBackground(new java.awt.Color(0, 0, 0));
        ListCamposAgregados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ListCamposAgregados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ListCamposAgregados.setForeground(new java.awt.Color(255, 255, 255));
        ListCamposAgregados.setToolTipText("Doble clic para quitar columna");
        ListCamposAgregados.setSelectionBackground(new java.awt.Color(153, 153, 153));
        ListCamposAgregados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListCamposAgregadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListCamposAgregados);

        btnAgregarTabla.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarTabla.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnAgregarTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarTabla.setText("-->");
        btnAgregarTabla.setToolTipText("Agregar tabla");
        btnAgregarTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgregarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTablaActionPerformed(evt);
            }
        });

        btnQuitarTabla.setBackground(new java.awt.Color(0, 0, 0));
        btnQuitarTabla.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnQuitarTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarTabla.setText("<--");
        btnQuitarTabla.setToolTipText("Quitar tabla");
        btnQuitarTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnQuitarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarTablaActionPerformed(evt);
            }
        });

        btnAgregarColumna.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarColumna.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnAgregarColumna.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarColumna.setText("-->");
        btnAgregarColumna.setToolTipText("Agregar columna");
        btnAgregarColumna.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgregarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColumnaActionPerformed(evt);
            }
        });

        btnQuitarColumna.setBackground(new java.awt.Color(0, 0, 0));
        btnQuitarColumna.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnQuitarColumna.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarColumna.setText("<--");
        btnQuitarColumna.setToolTipText("Quitar columna");
        btnQuitarColumna.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnQuitarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarColumnaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Insertar filtros");

        comboListaCamposAgregados.setBackground(new java.awt.Color(51, 51, 51));
        comboListaCamposAgregados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboListaCamposAgregados.setForeground(new java.awt.Color(255, 255, 255));
        comboListaCamposAgregados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "  ", " " }));
        comboListaCamposAgregados.setToolTipText("Seleccione la columna a filtrar");

        comboListaFiltros.setBackground(new java.awt.Color(51, 51, 51));
        comboListaFiltros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboListaFiltros.setForeground(new java.awt.Color(255, 255, 255));
        comboListaFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboListaFiltros.setToolTipText("Seleccione el tipo de filtro que desea agregar");

        txtFiltro.setBackground(new java.awt.Color(0, 0, 0));
        txtFiltro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFiltro.setForeground(new java.awt.Color(255, 255, 255));
        txtFiltro.setToolTipText("Ingrese la condicion para el filtro");
        txtFiltro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtFiltro.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtFiltro.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Columnas agregadas:");

        ListFiltrosAgregados.setBackground(new java.awt.Color(0, 0, 0));
        ListFiltrosAgregados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ListFiltrosAgregados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ListFiltrosAgregados.setForeground(new java.awt.Color(255, 255, 255));
        ListFiltrosAgregados.setToolTipText("Doble clic para quitar filtro");
        ListFiltrosAgregados.setSelectionBackground(new java.awt.Color(153, 153, 153));
        ListFiltrosAgregados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListFiltrosAgregadosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ListFiltrosAgregados);

        btnAgregarFiltroY.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarFiltroY.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnAgregarFiltroY.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarFiltroY.setText("Y -->");
        btnAgregarFiltroY.setToolTipText("Agregar Filtro");
        btnAgregarFiltroY.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgregarFiltroY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFiltroYActionPerformed(evt);
            }
        });

        btnAgregarFiltroO.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarFiltroO.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnAgregarFiltroO.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarFiltroO.setText("O -->");
        btnAgregarFiltroO.setToolTipText("Agregar Filtro");
        btnAgregarFiltroO.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgregarFiltroO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFiltroOActionPerformed(evt);
            }
        });

        btnQuitarFiltro.setBackground(new java.awt.Color(0, 0, 0));
        btnQuitarFiltro.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnQuitarFiltro.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarFiltro.setText("<--");
        btnQuitarFiltro.setToolTipText("Quitar Filtro");
        btnQuitarFiltro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnQuitarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarFiltroActionPerformed(evt);
            }
        });

        btnGenerarInforme.setBackground(new java.awt.Color(0, 0, 0));
        btnGenerarInforme.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGenerarInforme.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarInforme.setText("Generar Informe");
        btnGenerarInforme.setToolTipText("Generar Informe");
        btnGenerarInforme.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarInformeActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Los textos y las fechas deben ir entre comillas simples ' '");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Los valores 'Entre' deben estar separados por la palabra AND");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Los valores Contiene deben ir entre parentesis separados por comas");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("El formato de la fecha es 'aaaa-mm-dd'  -->   '2020-01-18'");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnQuitarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAgregarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAgregarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnQuitarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboListaCamposAgregados, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboListaFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregarFiltroO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregarFiltroY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnQuitarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGenerarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnAgregarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(btnAgregarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnQuitarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(31, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregarFiltroY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregarFiltroO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboListaFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(btnQuitarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboListaCamposAgregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenerarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listListaTablasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listListaTablasMouseClicked
        if (evt.getClickCount() == 2) {
            btnAgregarTabla.doClick();
        }

    }//GEN-LAST:event_listListaTablasMouseClicked

    private void ListTablasAgregadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListTablasAgregadasMouseClicked

        if (evt.getClickCount() == 2) {
            btnQuitarTabla.doClick();
        }
    }//GEN-LAST:event_ListTablasAgregadasMouseClicked

    private void listListaCamposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listListaCamposMouseClicked

        if (evt.getClickCount() == 2) {
            btnAgregarColumna.doClick();
        }
    }//GEN-LAST:event_listListaCamposMouseClicked

    private void btnAgregarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTablaActionPerformed

        if (!listListaTablas.isSelectionEmpty()) {
            String tbl = listListaTablas.getSelectedValue();
            agregarTabla(tbl);
            actualizarAgregados();
        }

    }//GEN-LAST:event_btnAgregarTablaActionPerformed

    private void btnQuitarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTablaActionPerformed

        if (!ListTablasAgregadas.isSelectionEmpty()) {
            String tbl = ListTablasAgregadas.getSelectedValue();
            quitarTabla(tbl);
            actualizarAgregados();
        }


    }//GEN-LAST:event_btnQuitarTablaActionPerformed

    private void btnAgregarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColumnaActionPerformed

        if (!listListaCampos.isSelectionEmpty()) {
            int idclase = listListaCampos.getSelectedIndex();
            String col = listListaCampos.getSelectedValue();
            agregarColumna(col);
            actualizarAgregados();
            agregarTipoColumna(idclase);
        }

    }//GEN-LAST:event_btnAgregarColumnaActionPerformed

    private void btnQuitarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarColumnaActionPerformed

        if (!ListCamposAgregados.isSelectionEmpty()) {
            int idclase = ListCamposAgregados.getSelectedIndex()-1;
            String col = ListCamposAgregados.getSelectedValue();
            quitarColumna(col);
            quitarTipoColumna(idclase);
            actualizarAgregados();
        }

    }//GEN-LAST:event_btnQuitarColumnaActionPerformed

    private void ListCamposAgregadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCamposAgregadosMouseClicked

        if (evt.getClickCount() == 2) {
            btnQuitarColumna.doClick();
        }
    }//GEN-LAST:event_ListCamposAgregadosMouseClicked

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void ListFiltrosAgregadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListFiltrosAgregadosMouseClicked

        if (evt.getClickCount() == 2) {
        btnQuitarFiltro.doClick();
        }
        
    }//GEN-LAST:event_ListFiltrosAgregadosMouseClicked

    private void btnAgregarFiltroYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFiltroYActionPerformed
   
        if(comboListaCamposAgregados.getSelectedItem() != null && comboListaFiltros.getSelectedItem() != null && txtFiltro.getText() != null){
            if(listaFiltros.isEmpty()){
                String f = String.format("%s %s %s",comboListaCamposAgregados.getSelectedItem(), capturarOperadorFiltro(comboListaFiltros.getSelectedItem().toString()), txtFiltro.getText());
                listaFiltros.add(f);
                txtFiltro.setText(null);
                                
            }else{
                
                if(!listaFiltros.contains(String.format("%s %s %s",comboListaCamposAgregados.getSelectedItem(), capturarOperadorFiltro(comboListaFiltros.getSelectedItem().toString()), txtFiltro.getText()))){
                    String f = String.format("AND %s %s %s",comboListaCamposAgregados.getSelectedItem(), capturarOperadorFiltro(comboListaFiltros.getSelectedItem().toString()), txtFiltro.getText());
                    listaFiltros.add(f);
                    txtFiltro.setText(null);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar los 3 campos", "Advertencia", 2);
        }
        actualizarAgregados();
        
    }//GEN-LAST:event_btnAgregarFiltroYActionPerformed

    private void btnAgregarFiltroOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFiltroOActionPerformed

        if(comboListaCamposAgregados.getSelectedItem() != null && comboListaFiltros.getSelectedItem() != null && txtFiltro.getText() != null){
            if(listaFiltros.isEmpty()){
                String f = String.format("%s %s %s",comboListaCamposAgregados.getSelectedItem(), capturarOperadorFiltro(comboListaFiltros.getSelectedItem().toString()), txtFiltro.getText());
                listaFiltros.add(f);
                txtFiltro.setText(null);
                                
            }else{
                
                if(!listaFiltros.contains(String.format("%s %s %s",comboListaCamposAgregados.getSelectedItem(), capturarOperadorFiltro(comboListaFiltros.getSelectedItem().toString()), txtFiltro.getText()))){
                    String f = String.format("OR %s %s %s",comboListaCamposAgregados.getSelectedItem(), capturarOperadorFiltro(comboListaFiltros.getSelectedItem().toString()), txtFiltro.getText());
                    listaFiltros.add(f);
                    txtFiltro.setText(null);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar los 3 campos", "Advertencia", 2);
        }
        actualizarAgregados();

    }//GEN-LAST:event_btnAgregarFiltroOActionPerformed

    private void btnQuitarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFiltroActionPerformed

        if(ListFiltrosAgregados.getSelectedIndex() == 0 & listaFiltros.size() == 1){
            listaFiltros.remove(ListFiltrosAgregados.getSelectedIndex());
        }else if(ListFiltrosAgregados.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Debe quitar los otros filtros primero", "Advertencia", 2);
        }else{
            listaFiltros.remove(ListFiltrosAgregados.getSelectedIndex());
        }
        actualizarAgregados();
    }//GEN-LAST:event_btnQuitarFiltroActionPerformed

    private void btnGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarInformeActionPerformed
        GeneradorSQL gsql = new GeneradorSQL(listaTablasAgregadasCampos, listaCamposAgregados, listaTipoCamposAgregados, listaFiltros);
//        System.out.println(gsql.generarSQL());
        InformesGUI ig = new InformesGUI(gsql);
        this.dispose();
        ig.setVisible(true);
        
    }//GEN-LAST:event_btnGenerarInformeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        InformesGUI ig = new InformesGUI();
        this.dispose();
        ig.setVisible(true);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void agregarTabla(String tbl) {
        if (!listaTablasAgregadas.contains(tbl)) {
            Boolean agrega = false;

            switch (tbl) {
                case "Compra":
                    if (listaTablasAgregadasCampos.isEmpty()) {
                        listaTablasAgregadasCampos.add(compra);
                        agrega = true;
                    } else if (listaTablasAgregadas.contains(compra.getTablaRequerida())) {
                        listaTablasAgregadasCampos.add(compra);
                        agrega = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe agregar primero la tabla " + compra.getTablaRequerida());
                    }
                    break;

                case "Lider":
                    if (listaTablasAgregadasCampos.isEmpty()) {
                        listaTablasAgregadasCampos.add(lider);
                        agrega = true;
                    } else if (listaTablasAgregadas.contains(lider.getTablaRequerida())) {
                        listaTablasAgregadasCampos.add(lider);
                        agrega = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe agregar primero la tabla " + lider.getTablaRequerida());
                    }
                    break;

                case "MaterialConstruccion":
                    if (listaTablasAgregadasCampos.isEmpty()) {
                        listaTablasAgregadasCampos.add(materialConstruccion);
                        agrega = true;
                    } else if (listaTablasAgregadas.contains(materialConstruccion.getTablaRequerida())) {
                        listaTablasAgregadasCampos.add(materialConstruccion);
                        agrega = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe agregar primero la tabla " + materialConstruccion.getTablaRequerida());
                    }
                    break;

                case "Proyecto":
                    if (listaTablasAgregadasCampos.isEmpty()) {
                        listaTablasAgregadasCampos.add(proyecto);
                        agrega = true;
                    } else if (listaTablasAgregadas.size() == 1 && listaTablasAgregadas.get(0) == "MaterialConstruccion") {
                        JOptionPane.showMessageDialog(null, "Debe agregar primero la tabla " + proyecto.getTablaRequerida());
                    } else {
                        listaTablasAgregadasCampos.add(proyecto);
                        agrega = true;

                    }
                    break;

                case "Tipo":
                    if (listaTablasAgregadasCampos.isEmpty()) {
                        listaTablasAgregadasCampos.add(tipo);
                        agrega = true;
                    } else if (listaTablasAgregadas.contains(tipo.getTablaRequerida())) {
                        listaTablasAgregadasCampos.add(tipo);
                        agrega = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe agregar primero la tabla " + tipo.getTablaRequerida(), "Advertencia", 2);
                    }
                    break;
                default:
                    break;
            }
            if (agrega) {
                listaTablasAgregadas.add(tbl);
            }

        }
    }

    private void quitarTabla(String tbl) {
        if (listaCamposAgregados.isEmpty()) {
            Boolean borra = false;

            if (listaTablasAgregadas.contains(tbl)) {
                switch (tbl) {
                    case "Compra":
                        if (listaTablasAgregadas.size() > 2 && listaTablasAgregadas.contains("MaterialConstruccion")) {
                            JOptionPane.showMessageDialog(null, "Primero debe quitar la tabla MaterialConstruccion", "Advertencia", 2);
                        } else {
                            listaTablasAgregadasCampos.remove(compra);
                            borra = true;
                        }
                        break;

                    case "Lider":
                        listaTablasAgregadasCampos.remove(lider);
                        borra = true;
                        break;
                    case "MaterialConstruccion":
                        listaTablasAgregadasCampos.remove(materialConstruccion);
                        borra = true;
                        break;
                    case "Proyecto":
                        if (listaTablasAgregadas.size() == 3 && (listaTablasAgregadas.contains("MaterialConstruccion") && listaTablasAgregadas.contains("Compra"))) {
                            listaTablasAgregadasCampos.remove(proyecto);
                            borra = true;
                        } else if (listaTablasAgregadas.size() > 2) {
                            JOptionPane.showMessageDialog(null, "Esta es la tabla principal, primero debe quitar las otras tablas", "Advertencia", 2);
                        } else {
                            listaTablasAgregadasCampos.remove(proyecto);
                            borra = true;
                        }
                        break;
                    case "Tipo":
                        listaTablasAgregadasCampos.remove(tipo);
                        borra = true;
                        break;
                    default:
                        break;
                }
                if (borra) {
                    listaTablasAgregadas.remove(tbl);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe quitar todas las columnas agregadas antes de quitar una tabla", "Advertencia", 2);
        }
    }

    private void agregarColumna(String col) {
        if (!listaCamposAgregados.contains(col)) {
            listaCamposAgregados.add(col);
            
        }

    }

    private void agregarTipoColumna(Integer idclase) {
        listaTipoCamposAgregados.add(listaTipoCamposDisponibles.get(idclase));
    }
    
    private void quitarTipoColumna(Integer idclase) {
        listaTipoCamposAgregados.remove(listaTipoCamposDisponibles.get(idclase));

    }

    private void quitarColumna(String col) {
        if (listaCamposAgregados.contains(col)) {
            listaCamposAgregados.remove(col);
        }

    }

    private void actualizarAgregados() {
        DefaultListModel<String> dlm = new DefaultListModel<>();
        DefaultListModel<String> dlm2 = new DefaultListModel<>();
        DefaultListModel<String> dlm3 = new DefaultListModel<>();
        DefaultListModel<String> dlm4 = new DefaultListModel<>();
        
        
        listaTablasAgregadas.forEach(ta -> dlm.addElement(ta));
        ListTablasAgregadas.setModel(dlm);

        listaTablasAgregadasCampos.forEach(tbl -> tbl.getListaCampos().forEach(col -> dlm2.addElement(tbl.getNombreTabla()+"."+col)));
        listListaCampos.setModel(dlm2);

        listaCamposAgregados.forEach(col -> dlm3.addElement(col));
        ListCamposAgregados.setModel(dlm3);

        comboListaCamposAgregados.removeAllItems();
        listaCamposAgregados.forEach(col -> comboListaCamposAgregados.addItem(col));
        
        listaFiltros.forEach(ta -> dlm4.addElement(ta));
        ListFiltrosAgregados.setModel(dlm4);
        
        listaTipoCamposDisponibles.clear();
        listaTablasAgregadasCampos.forEach(tbl -> tbl.getTipoCampos().forEach(col -> listaTipoCamposDisponibles.add(col)));

    }
    
    private String capturarOperadorFiltro(String filtro){
        switch (filtro) {
            case " =  Igual a":
                return "=";
                
            case " >  Mayor que":
                return ">";
                
            case " <  Menor que":
                return "<";
                
            case " >=  Mayor o igual a":
                return ">=";
                
            case " <=  Menor o igual a":
                return "<=";
                
            case " !=  Diferente a":
                return "!=";
                
            case "<%>  Entre":
                return "BETWEEN";
            
            case "(%)  Contiene":
                return "IN";
            default:
                throw new AssertionError();
        }
        
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListCamposAgregados;
    private javax.swing.JList<String> ListFiltrosAgregados;
    private javax.swing.JList<String> ListTablasAgregadas;
    private javax.swing.JButton btnAgregarColumna;
    private javax.swing.JButton btnAgregarFiltroO;
    private javax.swing.JButton btnAgregarFiltroY;
    private javax.swing.JButton btnAgregarTabla;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerarInforme;
    private javax.swing.JButton btnQuitarColumna;
    private javax.swing.JButton btnQuitarFiltro;
    private javax.swing.JButton btnQuitarTabla;
    private javax.swing.JComboBox<String> comboListaCamposAgregados;
    private javax.swing.JComboBox<String> comboListaFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JList<String> listListaCampos;
    private javax.swing.JList<String> listListaTablas;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

     @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/escudoColombia.png"));
        return retValue;
    }
    

}

