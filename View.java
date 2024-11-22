import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener /*, DocumentListener, ListSelectionListener */{
    private Model model;
    private JFrame mainFrame;
    private JPanel mainPnl, centerMainPnl;
    private JButton menuAdmin, menuPassenger, menuExit;
    private JButton menuHome, menuView, menuManage, menuReport, menuBook;
    private JButton viewFlight, viewBook, viewEmployee, viewPassenger;
    private JButton manageFlight, manageBook, manageEmployee, managePassenger;
    private JButton genFlight, genRevenue, genEmployee, genPassenger;

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
        homePnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        homePnl.setBackground(Color.WHITE);


        return homePnl;
    }

    public JPanel createAdmin() {
        JPanel adminPnl = new JPanel();
        adminPnl.setLayout(new BorderLayout());
        adminPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel northPnl = new JPanel();
        northPnl.setBackground(Color.WHITE);
        JLabel label = new JLabel("Administrator's Menu");
        northPnl.add(label);

        JPanel centerPnl = new JPanel();
        centerPnl.setLayout(new GridLayout(3, 1,  5, 5));
        centerPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPnl.setBackground(Color.WHITE);

        JButton editEmployee = new JButton("Edit Employee Records");
        JButton editFlight = new JButton("Edit Employee Records");
        JButton genReports = new JButton("Edit Employee Records");

        centerPnl.add(editEmployee);
        centerPnl.add(editFlight);
        centerPnl.add(genReports);

        adminPnl.add(centerPnl, BorderLayout.CENTER);


        adminPnl.add(northPnl, BorderLayout.NORTH);

        return adminPnl;
    }

    public JPanel createPassenger() {
        JPanel passengerPnl = new JPanel();
        passengerPnl.setLayout(new BorderLayout());
        passengerPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel northPnl = new JPanel();
        northPnl.setBackground(Color.WHITE);
        JLabel label = new JLabel("Passenger's Menu");
        northPnl.add(label);

        passengerPnl.add(northPnl, BorderLayout.NORTH);

        JPanel centerPnl = new JPanel();
        centerPnl.setLayout(new GridLayout(2, 1,  5, 5));
        centerPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPnl.setBackground(Color.WHITE);

        JButton bookFlight = new JButton("Book Flight");
        JButton manageAccount = new JButton("Manage Account");

        centerPnl.add(bookFlight);
        centerPnl.add(manageAccount);

        passengerPnl.add(centerPnl, BorderLayout.CENTER);

        return passengerPnl;
    }

//    public JPanel createView() {
//        JPanel viewPnl = new JPanel();
//        viewPnl.setLayout(new CardLayout());
//        viewPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//        JPanel selectionPnl = new JPanel();
//        selectionPnl.setBackground(Color.WHITE);
//        selectionPnl.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(20, 20, 20, 20);
//
//        this.viewBook = new JButton("View Bookings");
//        this.viewBook.setPreferredSize(new Dimension(250, 150));
//
//        this.viewFlight = new JButton("View Flights");
//        this.viewFlight.setPreferredSize(new Dimension(250, 150));
//
//        this.viewPassenger = new JButton("View Passengers");
//        this.viewPassenger.setPreferredSize(new Dimension(250, 150));
//
//        this.viewEmployee = new JButton("View Employees");
//        this.viewEmployee.setPreferredSize(new Dimension(250, 150));
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        selectionPnl.add(this.viewBook, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        selectionPnl.add(this.viewFlight, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        selectionPnl.add(this.viewPassenger, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        selectionPnl.add(this.viewEmployee, gbc);
//
//        viewPnl.add(selectionPnl, "Selection");
//
//        return viewPnl;
//    }

//    public JPanel createManage() {
//        JPanel managePnl = new JPanel();
//        managePnl.setLayout(new CardLayout());
//        managePnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//        JPanel selectionPnl = new JPanel();
//        selectionPnl.setBackground(Color.WHITE);
//        selectionPnl.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(20, 20, 20, 20);
//
//        this.manageBook = new JButton("Manage Bookings");
//        this.manageBook.setPreferredSize(new Dimension(250, 150));
//
//        this.manageFlight = new JButton("Manage Flights");
//        this.manageFlight.setPreferredSize(new Dimension(250, 150));
//
//        this.managePassenger = new JButton("Manage Passengers");
//        this.managePassenger.setPreferredSize(new Dimension(250, 150));
//
//        this.manageEmployee = new JButton("Manage Employees");
//        this.manageEmployee.setPreferredSize(new Dimension(250, 150));
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        selectionPnl.add(this.manageBook, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        selectionPnl.add(this.manageFlight, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        selectionPnl.add(this.managePassenger, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        selectionPnl.add(this.manageEmployee, gbc);
//
//        managePnl.add(selectionPnl, "Selection");
//
//
//        return managePnl;
//    }

    public JPanel createReport() {
        JPanel reportPnl = new JPanel();
        reportPnl.setLayout(new CardLayout());
        reportPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel selectionPnl = new JPanel();
        selectionPnl.setBackground(Color.WHITE);
        selectionPnl.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        this.genFlight = new JButton("Flight Occupancy Report");
        //this.genFlight.setFont(new Font("Arial", Font.BOLD, 17));
        this.genFlight.setPreferredSize(new Dimension(250, 150));

        this.genRevenue = new JButton("Revenue Report");
        this.genRevenue.setPreferredSize(new Dimension(250, 150));

        this.genPassenger = new JButton("Passenger Report");
        this.genPassenger.setPreferredSize(new Dimension(250, 150));

        this.genEmployee = new JButton("Employee Statistics Report");
        this.genEmployee.setPreferredSize(new Dimension(250, 150));

        gbc.gridx = 0;
        gbc.gridy = 1;
        selectionPnl.add(this.genFlight, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        selectionPnl.add(this.genRevenue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        selectionPnl.add(this.genPassenger, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        selectionPnl.add(this.genEmployee, gbc);

        reportPnl.add(selectionPnl, "Selection");

        return reportPnl;
    }

    public JPanel createBook() {
        JPanel bookPnl = new JPanel();
        bookPnl.setLayout(new BorderLayout());
        bookPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.add(new JLabel("Select Flight Listing:"));

        northPanel.setBackground(Color.WHITE);

        bookPnl.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);

        return bookPnl;
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
        // view.setSubmitEnabled();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // ignore null action commands (from changing selected indexes)
        if (event == null) {
            return;
        }
        String action = event.getActionCommand();

        // clear selections when view changes
        if (model.setCurrentView(action)) {
            //view.clearHotelSelection();
            //view.clearRoomSelection();
        }

        // show in console action (except comboBoxChanged)
        System.out.println("ACTION READ: " + action);

        // handle the event based on current view
//        switch (model.getCurrentView()) {
//            case "Create Hotel" -> this.handleCreate(event);
//            case "View Hotels" -> this.handleView(event);
//            case "Manage Hotels" -> this.handleManage(event);
//            case "Book Reservation" -> this.handleBook(event);
//        }

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
    }

}