package to.lova.flow;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "list", layout = ToolbarLayout.class)
public class MyList extends MyAbstractList implements HasToolbar {

    public MyList() {
        this.add(new Text("I'm the list!"));
        this.add(new RouterLink("Go to the other one.", MyOtherList.class));
        this.tabs.add(new Tab("List"));
    }

    @Override
    public Component getToolbar() {
        return this.toolbar;
    }
}
