package USECASE;

public  interface UseCase<req,res> {
    /*  @param <res> (response data)
    * @param <req>(request data)
     */
    res execute(req Req) throws Exception;
}

