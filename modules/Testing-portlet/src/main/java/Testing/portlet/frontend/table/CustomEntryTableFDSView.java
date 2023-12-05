package Testing.portlet.frontend.table;

import com.liferay.frontend.data.set.view.FDSView;
import com.liferay.frontend.data.set.view.table.BaseTableFDSView;
import com.liferay.frontend.data.set.view.table.FDSTableSchema;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilder;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilderFactory;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
        property = "frontend.data.set.name=" +"custom-obejct-entry-table",
        service = FDSView.class
)
public class CustomEntryTableFDSView extends BaseTableFDSView {

    @Override
    public FDSTableSchema getFDSTableSchema(Locale locale) {
        FDSTableSchemaBuilder fdsTableSchemaBuilder =
                _fdsTableSchemaBuilderFactory.create();
        return fdsTableSchemaBuilder.add(
                        "message", "Message"
                ).add(
                        "fileName", "File"
                ).add(
                        "status", "status",
                        fdsTableSchemaField -> fdsTableSchemaField.setContentRenderer(
                                "status")
                ).build();
    }


    @Reference
    private FDSTableSchemaBuilderFactory _fdsTableSchemaBuilderFactory;

}