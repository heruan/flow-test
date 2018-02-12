package to.lova.flow;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("tabs")
@Theme(Lumo.class)
public class TabsTest extends Div {


    public TabsTest() {
        this.add(new Tabs(new Tab("Foo")));
    }

}
