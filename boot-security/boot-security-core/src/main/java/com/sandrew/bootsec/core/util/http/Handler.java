package com.sandrew.bootsec.core.util.http;

@FunctionalInterface
public interface Handler<E>
{
    void handle(E var1);
}
