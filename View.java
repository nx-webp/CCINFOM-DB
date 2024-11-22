import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener /*, DocumentListener, ListSelectionListener */{
    private Model model;
    private JFrame mainFrame;
    private JPanel mainPnl, centerMainPnl;
    private JPanel adminPnl, editEmp, editFlight, genRep;
    private JPanel passPnl, manageAcc, bookFlight;
    private JButton menuAdmin, menuPassenger, menuExit, menuHome;
    private JButton submitOcc, submitRev, submitStats, submitPass;
    private JComboBox monthComboBox, yearComboBox;

    public View(Model model) {
        this.model = new Model();

        this.mainFrame = new JFrame();
        this.mainFrame.setTitle("Airline Database Management System");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(800, 600);
        this.mainFrame.setResizable(false);

        this.mainPnl = new JPanel(new BorderLayout());

        this.mainPnl.add(this.createHeader(), BorderLayout.NORTH);
        this.mainPnl.add(this.createSidebar(), BorderLayout.WEST);
        this.mainPnl.add(this.createCenter(), BorderLayout.CENTER);

        this.mainFrame.add(this.mainPnl);
        this.mainFrame.setVisible(true);

        this.setActionListener(this);
        this.updateView();
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();

        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        header.setPreferredSize(new Dimension(800, 100));
        header.setBackground(Color.decode("#2A9DF4"));
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel viewHeader = new JLabel("Airline Database Management System");
        viewHeader.setForeground(Color.WHITE);
        viewHeader.setFont(new Font("Arial", Font.BOLD, 40));
        viewHeader.setAlignmentY(Component.CENTER_ALIGNMENT);
        viewHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(Box.createVerticalGlue());
        header.add(viewHeader);
        header.add(Box.createVerticalGlue());

        return header;
    }

    /**
     * A method used to create the panel for the sidebar for the main frame
     * of the GUI of the program.
     *
     * @return the panel responsible for the header
     */
    public JPanel createSidebar()
    {
        // menu panel
        JPanel menus = new JPanel();
        menus.setPreferredSize(new Dimension(200, 400));
        menus.setLayout(new GridLayout(5, 1, 10, 0));

        JLabel menuText = new JLabel("MAIN MENU");
        menuText.setHorizontalAlignment(JTextField.CENTER);
        menuText.setFont(new Font("Arial", Font.PLAIN, 13));
        menus.add(menuText);

        // add menu buttons
        this.menuAdmin = new JButton("Admin Menu");
        this.menuPassenger = new JButton("Passenger Menu");
        this.menuExit = new JButton("Exit Program");
        this.menuHome = new JButton("Home");

        // add all buttons to menu sidebar
        menus.add(this.menuHome);
        menus.add(this.menuAdmin);
        menus.add(this.menuPassenger);
        menus.add(this.menuExit);
        return menus;
    }

    /**
     * A method responsible for creation of the center panel in the main frame.
     *
     * @return the center panel to be used in the main frame.
     */
    public JPanel createCenter()
    {
        this.centerMainPnl = new JPanel();
        this.centerMainPnl.setLayout(new CardLayout());

        this.centerMainPnl.add(createHome(), "Home");
        this.centerMainPnl.add(createAdmin(), "Admin Menu");
        this.centerMainPnl.add(createPassenger(), "Passenger Menu");

        return this.centerMainPnl;
    }

    public JPanel createHome() {
        JPanel homePnl = new JPanel();
        homePnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        homePnl.setBackground(Color.WHITE);


        return homePnl;
    }

    public JPanel createAdmin() {
        this.adminPnl = new JPanel();
        this.adminPnl.setLayout(new CardLayout());
        this.adminPnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonsPnl = new JPanel();
        buttonsPnl.setLayout(new BorderLayout());
        buttonsPnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel northPnl = new JPanel();
        northPnl.setBackground(Color.WHITE);
        JLabel label = new JLabel("Administrator's Menu");
        northPnl.add(label);

        JPanel centerPnl = new JPanel();
        centerPnl.setLayout(new GridLayout(3, 1,  5, 5));
        centerPnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPnl.setBackground(Color.WHITE);

        JButton editEmployee = new JButton("Edit Employee Records");
        JButton editFlight = new JButton("Edit Flight Records");
        JButton genReports = new JButton("Generate Reports");

        centerPnl.add(editEmployee);
        centerPnl.add(editFlight);
        centerPnl.add(genReports);

        buttonsPnl.add(northPnl, BorderLayout.NORTH);
        buttonsPnl.add(centerPnl, BorderLayout.CENTER);

        this.adminPnl.add(buttonsPnl, "buttons");

        this.adminPnl.add(editEmployee(editEmployee), "Edit Employee Records");
        this.adminPnl.add(editFlight(editFlight), "Edit Flight Records");
        this.adminPnl.add(generateReport(genReports), "Generate Reports");

        return this.adminPnl;
    }

    public JPanel editEmployee(JButton editEmployee) {
        this.editEmp = new JPanel();
        this.editEmp.setLayout(new BorderLayout());
        this.editEmp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel northEmp = new JPanel();
        northEmp.setBackground(Color.WHITE);
        JLabel empLabel = new JLabel("Edit Employee Records");
        northEmp.add(empLabel);

        JPanel southEmp = new JPanel();
        southEmp.setLayout(new FlowLayout(FlowLayout.LEFT));
        southEmp.setBackground(Color.WHITE);

        JButton backBtn = new JButton("Back");
        southEmp.add(backBtn);

        this.editEmp.add(southEmp, BorderLayout.SOUTH);

        editEmployee.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) this.adminPnl.getLayout();

            cl.show(this.adminPnl, e.getActionCommand());
        });

        backBtn.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) this.adminPnl.getLayout();

            cl.show(this.adminPnl, "buttons");
        });

        return this.editEmp;
    }

    public JPanel editFlight(JButton editFlight) {
        this.editFlight = new JPanel();
        this.editFlight.setLayout(new BorderLayout());
        this.editFlight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel southEmp = new JPanel();
        southEmp.setLayout(new FlowLayout(FlowLayout.LEFT));
        southEmp.setBackground(Color.WHITE);

        JButton backBtn = new JButton("Back");
        southEmp.add(backBtn);

        this.editFlight.add(southEmp, BorderLayout.SOUTH);

        editFlight.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) this.adminPnl.getLayout();

            cl.show(this.adminPnl, e.getActionCommand());
        });

        backBtn.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) this.adminPnl.getLayout();

            cl.show(this.adminPnl, "buttons");
        });

        return this.editFlight;
    }

    public JPanel generateReport(JButton genReport) {
        this.genRep = new JPanel();
        this.genRep.setLayout(new BorderLayout());
        this.genRep.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel northPnl = new JPanel();
        northPnl.setLayout(new GridBagLayout());
        northPnl.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel yearLabel = new JLabel("Select Year");
        JLabel monthLabel = new JLabel("Select Month");

        String[] months = {"January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"};

        this.monthComboBox = new JComboBox<>(months);
        this.monthComboBox.setSelectedIndex(-1);

        gbc.gridx = 0;
        gbc.gridy = 0;
        northPnl.add(yearLabel, gbc);

        gbc.gridx = 1;
        //northPnl.add(this.yearComboBox, gbc);

        gbc.gridx = 2;
        northPnl.add(monthLabel, gbc);

        gbc.gridx = 3;
        northPnl.add(this.monthComboBox, gbc);


        JPanel centerPnl = new JPanel();
        centerPnl.setLayout(new GridLayout(2, 2, 5, 5));
        centerPnl.setBackground(Color.WHITE);
        centerPnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.submitOcc = new JButton("Flight Occupancy Report");
        this.submitRev = new JButton("Revenue Report");
        this.submitPass = new JButton("Passenger Report");
        this.submitStats = new JButton("Employee Statistics Report");

        centerPnl.add(this.submitOcc);
        centerPnl.add(this.submitRev);
        centerPnl.add(this.submitPass);
        centerPnl.add(this.submitStats);

        JPanel southPnl = new JPanel();
        southPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPnl.setBackground(Color.WHITE);

        JButton backBtn = new JButton("Back");
        southPnl.add(backBtn);

        this.genRep.add(northPnl, BorderLayout.NORTH);
        this.genRep.add(centerPnl, BorderLayout.CENTER);
        this.genRep.add(southPnl, BorderLayout.SOUTH);

        genReport.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) this.adminPnl.getLayout();

            cl.show(this.adminPnl, e.getActionCommand());
        });

        backBtn.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) this.adminPnl.getLayout();
            this.monthComboBox.setSelectedIndex(-1);

            cl.show(this.adminPnl, "buttons");
        });

        return this.genRep;
    }

    public JPanel createPassenger() {
        this.passPnl = new JPanel();
        this.passPnl.setLayout(new CardLayout());
        this.passPnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonsPnl = new JPanel();
        buttonsPnl.setLayout(new BorderLayout());
        buttonsPnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel northPnl = new JPanel();
        northPnl.setBackground(Color.WHITE);
        JLabel label = new JLabel("Passenger's Menu");
        northPnl.add(label);

        JPanel centerPnl = new JPanel();
        centerPnl.setLayout(new GridLayout(2, 1,  5, 5));
        centerPnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPnl.setBackground(Color.WHITE);

        JButton bookFlight = new JButton("Book a Flight");
        JButton manageAcc = new JButton("Manage Your Account");

        centerPnl.add(bookFlight);
        centerPnl.add(manageAcc);

        buttonsPnl.add(northPnl, BorderLayout.NORTH);
        buttonsPnl.add(centerPnl, BorderLayout.CENTER);

        this.passPnl.add(buttonsPnl, "buttons");

        this.passPnl.add(bookFlight(bookFlight), "Book a Flight");
        this.passPnl.add(manageAcc(manageAcc), "Manage Your Account");

        return this.passPnl;
    }

    public JPanel bookFlight(JButton bookFlight) {
        this.bookFlight = new JPanel();

        return this.bookFlight;
    }

    public JPanel manageAcc(JButton manageAcc) {
        this.manageAcc = new JPanel();

        return this.manageAcc;
    }

    public void setMenuEnabled(boolean home, boolean admin, boolean passenger, boolean exit) {
        if (this.menuHome != null) {
            this.menuHome.setEnabled(home);
        }
        if (this.menuAdmin != null) {
            this.menuAdmin.setEnabled(admin);
        }
        if (this.menuPassenger != null) {
            this.menuPassenger.setEnabled(passenger);
        }
        if (this.menuExit != null) {
            this.menuExit.setEnabled(exit);
        }
    }

    public void showView(String viewName) {
        ((CardLayout) centerMainPnl.getLayout()).show(centerMainPnl, viewName);
    }

    public void updateView() {
        String currentView = model.getCurrentView();

        // update buttons based on current view
        this.setMenuEnabled(
                !currentView.equals("Home"),
                !currentView.equals("Admin Menu"),
                !currentView.equals("Passenger Menu"),
                !currentView.equals("Exit Program")
        );

        // update view in gui
        this.showView(currentView);
        // update submit buttons based on missing fields
        this.setSubmitEnabled();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // ignore null action commands (from changing selected indexes)
        if (event == null) {
            return;
        }
        String action = event.getActionCommand();

        model.setCurrentView(action);

        // once user clicks exit program button
        if(action.equals("Exit Program")) {
            System.exit(0);
        }

        // show in console action
        System.out.println("ACTION: " + action);

        switch(model.getCurrentView()) {
           // case "Admin Menu" -> this.handleAdmin(event);
            //case "Passenger Menu" -> this.handlePassenger(event);
        }

        // update view after any action
        this.updateView();
    }

    public void setActionListener(ActionListener listener)
    {
        // main menu buttons
        this.menuHome.addActionListener(listener);
        this.menuAdmin.addActionListener(listener);
        this.menuPassenger.addActionListener(listener);
        this.menuExit.addActionListener(listener);

        this.monthComboBox.addActionListener(listener);
    }

    public void setSubmitEnabled() {
        // generate reports
        if(/* this.yearComboBox.getSelectedIndex() == -1 || */ this.monthComboBox.getSelectedIndex() == -1) {
            this.submitStats.setEnabled(false);
            this.submitRev.setEnabled(false);
            this.submitOcc.setEnabled(false);
            this.submitPass.setEnabled(false);
        } else {
            this.submitStats.setEnabled(true);
            this.submitRev.setEnabled(true);
            this.submitOcc.setEnabled(true);
            this.submitPass.setEnabled(true);
        }

    }

    public void clearSelection() {
        this.monthComboBox.setSelectedIndex(-1);
    }

}