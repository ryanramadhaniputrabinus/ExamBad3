/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bad;

import com.vaadin.flow.component.orderedLayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 *
 * @author Majoo-1040WTNB-X260
 */
@Route("")
public class MainView extends VerticalLayout {
    
    Grid<Contact> grid = new Grid<>(Contact.class);
    private ContactService contactService;
    
    public MainView(ContactService contactservice) {
        this.contactService = contactService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        
        add(grid);
        updateList();
    }
    
    private void configureGrid() {
        grid.addClassName(contact-grid);
        grid.setsizeFull();
        grid.removeColumnByKey("company");
        grid.setColumns("firstName", "lastName", "email", "status", "company");
        grid.addColumn(contact -> {
            Company company = contract.getCompany();
            
            return company == null ? "-" : company.getName();
        }).setHeader("Company");
        
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    
    private void updateList() {
        grid.setItems(contactServie.findAll());
    }
}
