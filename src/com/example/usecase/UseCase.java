package com.example.usecase;

import com.example.WrongDataException;

/**
 *
 * @param <Req> request data
 * @param <Res> response data
 */
public interface UseCase<Req,Res>{

    Res execute(Req req) throws Exception;

}
