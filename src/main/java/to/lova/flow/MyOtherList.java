package to.lova.flow;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "other", layout = ToolbarLayout.class)
public class MyOtherList extends MyAbstractList implements HasToolbar {

    public MyOtherList() {
        this.add(new Text("I'm the other list!"));
        this.add(new RouterLink("Go to the other one.", MyList.class));
        this.tabs.add(new Tab("Other"));
    }

    @Override
    public Component getToolbar() {
        return this.toolbar;
    }
}
