package to.lova.flow;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(Lumo.class)
public class DialogFocus extends VerticalLayout {

    public DialogFocus() {
        TextField textField = new TextField();
        Dialog dialog = new Dialog(textField);
        this.add(new Button("Open dialog", event -> {
            textField.focus();
            dialog.open();
        }));
    }

}
