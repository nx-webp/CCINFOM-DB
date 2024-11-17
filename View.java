import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame mainFrame;
    private JPanel mainPnl, centerMainPnl;
    private JButton menuHome, menuFlights, menuView, menuEmployees, menuPassenger, menuBook;

    public View() {
        this.mainFrame = new JFrame();
        this.mainFrame.setTitle("Airline Database Management System");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(800, 600);
        this.mainFrame.setResizable(false);

        this.mainPnl = new JPanel(new BorderLayout());

        this.mainPnl.add(this.createHeader(), BorderLayout.NORTH);
        this.mainPnl.add(this.createSidebar(), BorderLayout.WEST);
        this.mainPnl.add(this.createCenter(), BorderLayout.CENTER);
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(800, 100));
        header.setBackground(Color.decode("#2A9DF4"));
        header.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel viewHeader = new JLabel("Airline Database Management System");
        viewHeader.setForeground(Color.WHITE);
        viewHeader.setFont(new Font("Arial", Font.BOLD, 45));
        header.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 0));

        header.add(viewHeader);
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
        menus.setLayout(new GridLayout(7, 1, 10, 0));

        JLabel menuText = new JLabel("MAIN MENU");
        menuText.setHorizontalAlignment(JTextField.CENTER);
        menuText.setFont(new Font("Arial", Font.PLAIN, 13));
        menus.add(menuText);

        // add menu buttons
        this.menuHome = new JButton("Home");
        this.menuView = new JButton("View Records");
        this.menuFlights = new JButton("Manage Flights");
        this.menuEmployees = new JButton("Manage Employees");
        this.menuPassenger = new JButton("Manage Passengers");
        this.menuBook = new JButton("Book Flight");

        // add all buttons to menu sidebar
        menus.add(this.menuHome);
        menus.add(this.menuView);
        menus.add(this.menuFlights);
        menus.add(this.menuEmployees);
        menus.add(this.menuPassenger);
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
        this.centerMainPnl.add(createCreate(), "Create Hotel");
        this.centerMainPnl.add(createView(), "View Hotels");
        this.centerMainPnl.add(createManage(), "Manage Hotels");
        this.centerMainPnl.add(createBook(), "Book Reservation");

        return this.centerMainPnl;
    }

}