package to.lova.flow;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public abstract class MyAbstractList extends Div {

    protected final Div toolbar = new Div();

    protected final Tabs tabs = new Tabs();

    public MyAbstractList() {
        this.toolbar.add(this.tabs);
        this.addAttachListener(event -> this.tabs.add(new Tab("Home")));
    }

}
