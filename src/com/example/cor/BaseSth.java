package com.example.cor;

public abstract class BaseSth implements Sth{

    private Sth next;
    @Override
    public void setNextInChain(Sth next) {
        this.next = next;
    }

    @Override
    public boolean execute() {
        if(next == null)
            return false;

        return next.execute();
    }

}
