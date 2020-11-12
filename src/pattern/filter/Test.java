package pattern.filter;

public class Test {
    public static void main(String[] args) throws Exception {
        FilterChain filters = new FilterChain();
        filters.addFilter(new HtlmFilter()).addFilter(new UTF8Filter());
        Response response = new Response().setResp("response==>");
        filters.doFilter(new Request().setReq("htmlutf8666"), response);
        System.out.println(response.getResp());
    }
}
