/**
 * 
 */
package dz.minagri.stat.comp;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author bellal djamel
 *
 */
public class Menu extends HorizontalLayout {

    private static final String VALO_MENUITEMS = "valo-menuitems";
    private static final String VALO_MENU_TOGGLE = "valo-menu-toggle";
    private static final String VALO_MENU_VISIBLE = "valo-menu-visible";
    private Navigator navigator;
    private Map<String, Button> viewButtons = new HashMap<>();

    private HorizontalLayout menuItemsLayout;
    private HorizontalLayout menuPart;

    private Button logout =new Button("Logout", event -> logout());
    public Menu(Navigator navigator) {
        this.navigator = navigator;
        setPrimaryStyleName(ValoTheme.MENU_ROOT);
        menuPart = new HorizontalLayout();
//        menuPart.addStyleName(ValoTheme.MENU_PART);
        menuPart.setWidth("100%");
        menuPart.setSpacing(false);
        menuPart.setMargin(false);
        
//        // header of the menu
//        final HorizontalLayout top = new HorizontalLayout();
//        top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
//        top.addStyleName(ValoTheme.MENU_TITLE);
//        Label title = new Label("My CRUD");
//        title.addStyleName(ValoTheme.LABEL_H3);
//        title.setSizeUndefined();
//        Image image = new Image(null, new ThemeResource("img/table-logo.png"));
//        image.setStyleName("logo");
//        top.addComponent(image);
//        top.addComponent(title);
//        menuPart.addComponent(top);

        // logout menu item
        
     
        logout.addStyleName("user-menu");
        logout.setHeightUndefined();
     
        // button for toggling the visibility of the menu when on a small screen
//        final Button showMenu = new Button("Menu", new ClickListener() {
//            @Override
//            public void buttonClick(final ClickEvent event) {
//                if (menuPart.getStyleName().contains(VALO_MENU_VISIBLE)) {
//                    menuPart.removeStyleName(VALO_MENU_VISIBLE);
//                } else {
//                    menuPart.addStyleName(VALO_MENU_VISIBLE);
//                }
//            }
//        });
//        showMenu.addStyleName(ValoTheme.BUTTON_PRIMARY);
//        showMenu.addStyleName(ValoTheme.BUTTON_SMALL);
//        showMenu.addStyleName(VALO_MENU_TOGGLE);
//        showMenu.setIcon(VaadinIcons.MENU);
//        menuPart.addComponent(showMenu);

        // container for the navigation buttons, which are added by addView()
        menuItemsLayout = new HorizontalLayout();
        menuItemsLayout.setWidth("100%");
        menuItemsLayout.setMargin(false);
        menuItemsLayout.setPrimaryStyleName(VALO_MENUITEMS);
        menuPart.addComponent(menuItemsLayout);
        menuPart.addComponent(logout);
        menuPart.setComponentAlignment(logout, Alignment.TOP_RIGHT);
        addComponent(menuPart);
    }

    /**
     * Creates a navigation button to the view identified by {@code name} using
     * {@code caption} and {@code icon}.
     *
     * @param name
     *            view name
     * @param caption
     *            view caption in the menu
     * @param icon
     *            view icon in the menu
     */
    public void addViewButton(final String name, String caption,
            Resource icon) {
        Button button = new Button(caption, new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                navigator.navigateTo(name);

            }
        });
        button.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        button.setIcon(icon);
        menuItemsLayout.addComponent(button);
        viewButtons.put(name, button);
    }
    public void logout() {
        VaadinSession.getCurrent().getSession().invalidate();
        Page.getCurrent().reload();
    }
    /**
     * Highlights a view navigation button as the currently active view in the
     * menu. This method does not perform the actual navigation.
     *
     * @param viewName
     *            the name of the view to show as active
     */
    public void setActiveView(String viewName) {
        for (Button button : viewButtons.values()) {
            button.removeStyleName("selected");
        }
        Button selected = viewButtons.get(viewName);
        if (selected != null) {
            selected.addStyleName("selected");
        }
        menuPart.removeStyleName(VALO_MENU_VISIBLE);
    }
}