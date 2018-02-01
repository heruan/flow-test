package to.lova.flow;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(Lumo.class)
public class ThemedComponent extends Div {

    public ThemedComponent() {
        this.add(new Button("Themed"));
    }

}
