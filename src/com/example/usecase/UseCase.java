package com.example.usecase;

import com.example.WrongDataException;

public interface UseCase<Req,Res>{

    Res execute(Req req) throws Exception;

}
