package to.lova.flow;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("foo")
public class Foo extends H1 {

    public Foo() {
        super("Foo");
    }

}
