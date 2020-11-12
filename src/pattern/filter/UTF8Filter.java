package pattern.filter;

public class UTF8Filter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) throws Exception {
        String req = request.getReq();
        if (req.contains("utf8")) {
            String res = req.replace("utf8", "");
            request.setReq(res);
//            chain.doFilter(request, response);
            response.setResp(response.getResp() + "8");
        } else {
            System.out.println("Not Contain utf8.");
        }
    }
}
