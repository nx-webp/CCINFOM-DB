import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class Controller implements ActionListener /*, DocumentListener, ListSelectionListener */ {
    private View view;
    private Model model;

    public Controller (View view, Model model) {
        this.view = view;
        this.model = model;

        view.setActionListener(this);
    }

    public void updateView() {
        String currentView = model.getCurrentView();

        // update buttons based on current view
        view.setMenuEnabled(
                !currentView.equals("Home"),
                !currentView.equals("View Records"),
                !currentView.equals("Manage Records"),
                !currentView.equals("Generate Reports"),
                !currentView.equals("Book Flight")
        );

        // update view in gui
        view.showView(currentView);
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


}