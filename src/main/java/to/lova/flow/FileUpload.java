package to.lova.flow;

import java.io.ByteArrayOutputStream;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.Route;

@Route("")
public class FileUpload extends Div {

    public FileUpload() {
        Upload upload = new Upload((name, type) -> {
            return new ByteArrayOutputStream();
        });
        this.add(upload);
    }

}
