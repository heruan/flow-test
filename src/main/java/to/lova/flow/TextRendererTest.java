package to.lova.flow;

import java.security.Principal;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(Lumo.class)
public class TextRendererTest extends Div {

    public TextRendererTest() {
        Grid<Principal> grid = new Grid<>();
        grid.addColumn(new TextRenderer<>(Principal::getName));
        grid.setDataProvider(new PrincipalProvider());
        this.add(new Button("Refresh",
                event -> grid.getDataProvider().refreshAll()), grid);
    }

    static class PrincipalProvider extends
            AbstractBackEndDataProvider<Principal, Predicate<Principal>> {

        final Supplier<Stream<Principal>> supplier = () -> Stream
                .of(() -> "Foo", () -> "Bar");

        @Override
        protected Stream<Principal> fetchFromBackEnd(
                Query<Principal, Predicate<Principal>> query) {
            int offset = query.getOffset();
            int limit = query.getLimit();
            return this.supplier.get().skip(offset).limit(limit);
        }

        @Override
        protected int sizeInBackEnd(
                Query<Principal, Predicate<Principal>> query) {
            int offset = query.getOffset();
            int limit = query.getLimit();
            return (int) this.supplier.get().skip(offset).limit(limit).count();
        }

    }

}
