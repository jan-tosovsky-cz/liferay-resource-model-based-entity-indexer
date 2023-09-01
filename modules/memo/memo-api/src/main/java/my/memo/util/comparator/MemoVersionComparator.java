package my.memo.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import my.memo.model.Memo;

public class MemoVersionComparator extends OrderByComparator<Memo> {

    public static final String ORDER_BY_ASC = "Memo.version ASC";
    public static final String ORDER_BY_DESC = "Memo.version DESC";
    public static final String[] ORDER_BY_FIELDS = {"version"};

    private final boolean ascending;

    public MemoVersionComparator() {
        this(false);
    }

    public MemoVersionComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Memo memo1, Memo memo2) {
        int value = Integer.compare(memo1.getVersion(), memo2.getVersion());
        return ascending ? value : -value;
    }

    @Override
    public String getOrderBy() {
        return ascending ? ORDER_BY_ASC: ORDER_BY_DESC;
    }

    @Override
    public String[] getOrderByFields() {
        return ORDER_BY_FIELDS;
    }

    @Override
    public boolean isAscending() {
        return ascending;
    }

}
