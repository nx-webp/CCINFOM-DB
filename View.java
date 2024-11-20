import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame mainFrame;
    private JPanel mainPnl, centerMainPnl;
    private JButton menuHome, menuView, menuManage, menuReport, menuBook;
    private JButton viewFlight, viewBook, viewEmployee, viewPassenger;
    private JButton manageFlight, manageBook, manageEmployee, managePassenger;
    private JButton genFlight, genRevenue, genEmployee, genPassenger;

    public View() {
        this.mainFrame = new JFrame();
        this.mainFrame.setTitle("Airline Database Management System");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(1000, 800);
        this.mainFrame.setResizable(false);

        this.mainPnl = new JPanel(new BorderLayout());

        this.mainPnl.add(this.createHeader(), BorderLayout.NORTH);
        this.mainPnl.add(this.createSidebar(), BorderLayout.WEST);
        this.mainPnl.add(this.createCenter(), BorderLayout.CENTER);

        this.mainFrame.add(this.mainPnl);
        this.mainFrame.setVisible(true);
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();

        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        header.setPreferredSize(new Dimension(800, 125));
        header.setBackground(Color.decode("#2A9DF4"));
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel viewHeader = new JLabel("Airline Database Management System");
        viewHeader.setForeground(Color.WHITE);
        viewHeader.setFont(new Font("Arial", Font.BOLD, 50));
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
        menus.setPreferredSize(new Dimension(300, 400));
        menus.setLayout(new GridLayout(6, 1, 10, 0));

        JLabel menuText = new JLabel("MAIN MENU");
        menuText.setHorizontalAlignment(JTextField.CENTER);
        menuText.setFont(new Font("Arial", Font.PLAIN, 13));
        menus.add(menuText);

        // add menu buttons
        this.menuHome = new JButton("Home");
        this.menuView = new JButton("View Records");
        this.menuManage = new JButton("Manage Records");
        this.menuReport = new JButton("Generate Reports");
        this.menuBook = new JButton("Book Flight");

        // add all buttons to menu sidebar
        menus.add(this.menuHome);
        menus.add(this.menuView);
        menus.add(this.menuManage);
        menus.add(this.menuReport);
        menus.add(this.menuBook);
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
        this.centerMainPnl.add(createView(), "View Records");
        this.centerMainPnl.add(createManage(), "Manage Records");
        this.centerMainPnl.add(createReport(), "Generate Reports");
        this.centerMainPnl.add(createBook(), "Book Flight");

        return this.centerMainPnl;
    }

    public JPanel createHome() {
        JPanel homePnl = new JPanel();
        homePnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        homePnl.setBackground(Color.WHITE);


        return homePnl;
    }

    public JPanel createView() {
        JPanel viewPnl = new JPanel();
        viewPnl.setLayout(new CardLayout());
        viewPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel selectionPnl = new JPanel();
        selectionPnl.setBackground(Color.WHITE);
        selectionPnl.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        this.viewBook = new JButton("View Bookings");
        this.viewBook.setPreferredSize(new Dimension(250, 150));

        this.viewFlight = new JButton("View Flights");
        this.viewFlight.setPreferredSize(new Dimension(250, 150));

        this.viewPassenger = new JButton("View Passengers");
        this.viewPassenger.setPreferredSize(new Dimension(250, 150));

        this.viewEmployee = new JButton("View Employees");
        this.viewEmployee.setPreferredSize(new Dimension(250, 150));

        gbc.gridx = 0;
        gbc.gridy = 1;
        selectionPnl.add(this.viewBook, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        selectionPnl.add(this.viewFlight, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        selectionPnl.add(this.viewPassenger, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        selectionPnl.add(this.viewEmployee, gbc);

        viewPnl.add(selectionPnl, "Selection");

        return viewPnl;
    }

    public JPanel createManage() {
        JPanel managePnl = new JPanel();
        managePnl.setLayout(new CardLayout());
        managePnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel selectionPnl = new JPanel();
        selectionPnl.setBackground(Color.WHITE);
        selectionPnl.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        this.manageBook = new JButton("Manage Bookings");
        this.manageBook.setPreferredSize(new Dimension(250, 150));

        this.manageFlight = new JButton("Manage Flights");
        this.manageFlight.setPreferredSize(new Dimension(250, 150));

        this.managePassenger = new JButton("Manage Passengers");
        this.managePassenger.setPreferredSize(new Dimension(250, 150));

        this.manageEmployee = new JButton("Manage Employees");
        this.manageEmployee.setPreferredSize(new Dimension(250, 150));

        gbc.gridx = 0;
        gbc.gridy = 1;
        selectionPnl.add(this.manageBook, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        selectionPnl.add(this.manageFlight, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        selectionPnl.add(this.managePassenger, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        selectionPnl.add(this.manageEmployee, gbc);

        managePnl.add(selectionPnl, "Selection");


        return managePnl;
    }

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


    public void setMenuEnabled(boolean home, boolean view, boolean manage, boolean report, boolean book) {
        if (this.menuHome != null) {
            this.menuHome.setEnabled(home);
        }
        if (this.menuView != null) {
            this.menuView.setEnabled(view);
        }
        if (this.menuManage != null) {
            this.menuManage.setEnabled(manage);
        }
        if (this.menuReport != null) {
            this.menuReport.setEnabled(report);
        }
        if (this.menuBook != null) {
            this.menuBook.setEnabled(book);
        }
    }

    public void showView(String viewName) {
        ((CardLayout) centerMainPnl.getLayout()).show(centerMainPnl, viewName);
    }

    public void setActionListener(ActionListener listener)
    {
        // main menu buttons
        this.menuHome.addActionListener(listener);
        this.menuReport.addActionListener(listener);
        this.menuView.addActionListener(listener);
        this.menuManage.addActionListener(listener);
        this.menuBook.addActionListener(listener);

    }

}