package to.lova.flow;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.RouterLayout;

public class ToolbarLayout extends Div implements RouterLayout {

    private final Div header = new Div();

    public ToolbarLayout() {
        this.add(this.header);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        Component component = (Component) content;
        this.add(component);
        if (component instanceof HasToolbar) {
            HasToolbar hasToolbar = (HasToolbar) component;
            Component toolbar = hasToolbar.getToolbar();
            this.header.add(toolbar);
            component.addDetachListener(event -> this.header.remove(toolbar));
        }
    }
}
