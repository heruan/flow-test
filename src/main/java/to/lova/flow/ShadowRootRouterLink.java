package to.lova.flow;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ShadowRoot;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class ShadowRootRouterLink extends Div {

    @Tag("shadow-component")
    public static class ShadowComponent extends Component {

        public ShadowComponent() {
            ShadowRoot shadowRoot = this.getElement().attachShadow();
            Div shadowDiv = new Div();
            shadowDiv.setHeight("100px");
            shadowDiv.setWidth("300px");
            shadowDiv.getStyle().set("background-color", "red");
            shadowRoot.appendChild(shadowDiv.getElement());
            Element slot = new Element("slot");
            shadowRoot.appendChild(slot);
            Div lightDiv = new Div();
            lightDiv.setHeight("100px");
            lightDiv.setWidth("300px");
            lightDiv.getStyle().set("background-color", "green");
            this.getElement().appendChild(lightDiv.getElement());
        }

    }

    public ShadowRootRouterLink() {
        RouterLink link = new RouterLink(null, Foo.class);
        link.add(new ShadowComponent());
        this.add(link);
    }

}
