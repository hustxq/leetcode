package pattern.filter;

public class HtlmFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) throws Exception {
        String req = request.getReq();
        if (req.contains("html")) {
            String res = req.replace("html", "");
            request.setReq(res);
            chain.doFilter(request, response);
            response.setResp(response.getResp() + "h");
        } else {
            System.out.println("Not Contain html.");
        }
    }
}
