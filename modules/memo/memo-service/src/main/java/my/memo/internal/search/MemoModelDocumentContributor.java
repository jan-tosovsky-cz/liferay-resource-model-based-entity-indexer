package my.memo.internal.search;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import my.memo.model.Memo;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=my.memo.model.Memo",
        service = ModelDocumentContributor.class
)
public class MemoModelDocumentContributor implements ModelDocumentContributor<Memo> {

    @Override
    public void contribute(Document document, Memo memo) {
        document.addText(Field.CONTENT, memo.getText());
        document.addKeyword(Field.STATUS, memo.getStatus());
    }

}
