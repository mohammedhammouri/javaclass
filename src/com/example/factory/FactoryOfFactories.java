package com.example.factory;

public class FactoryOfFactories {

    public static <R> Factory<R> getFactory(Class<R> r){

        switch (r.getSimpleName()){
            case "CreateClas":
                return (Factory<R>) new CreateClasFactory();

        }

        return null;
    }


}
