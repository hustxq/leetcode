package pattern.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public FilterChain addFilter(Filter f) {
        this.filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response) throws Exception {
        if (index == filters.size()) {
            return;
        }

        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, this);
    }
}
