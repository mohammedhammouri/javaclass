package com.example.factory;

public class FactoryOfFactories {

    public static <R> Factory<R> getFactory(String factName){
        switch (factName){
            case "createClas":
                return (Factory<R>) new CreateClasFactory();
        }


        return null;
    }


}
