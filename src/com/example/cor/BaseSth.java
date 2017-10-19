package com.example.cor;

public abstract class BaseSth implements Sth{

    private Sth sth;
    @Override
    public void setNextInChain(Sth sth) {
        this.sth = sth;
    }

    @Override
    public boolean execute() {
        if(sth == null)
            return false;

        return sth.execute();
    }

}
