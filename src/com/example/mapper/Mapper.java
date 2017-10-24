package com.example.mapper;

public interface Mapper<From,To> {

    To map(From from);

    From mapTo(To to);

}
