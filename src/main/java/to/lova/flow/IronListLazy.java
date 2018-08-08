package to.lova.flow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.ironlist.IronList;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.Route;

@Route("")
public class IronListLazy extends Div {

    static final List<Person> NAMES;

    static {
        Fairy fairy = Fairy.create();
        NAMES = Stream.generate(fairy::person).limit(1000)
                .collect(Collectors.toList());
    }

    final DataProvider<Person, Void> dataProvider = DataProvider
            .fromCallbacks(query -> {
                long offset = query.getOffset();
                long limit = query.getLimit();
                this.log.add(new ListItem(
                        String.format("Offset: %d, Limit: %d", offset, limit)));
                return NAMES.stream().skip(offset).limit(limit);
            }, query -> NAMES.size());

    final IronList<Person> list = new IronList<>();

    final UnorderedList log = new UnorderedList();

    public IronListLazy() {
        this.list.setDataProvider(this.dataProvider);
        this.list.setRenderer(new TextRenderer<>(Person::getFullName));
        this.list.setHeight("300px");
        this.add(this.list, this.log);
    }

}
