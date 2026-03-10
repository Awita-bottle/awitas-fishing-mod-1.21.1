package net.awita.awitafm.Item.custom;

public interface TypedItem<T extends Enum<T>>
{
    T getType();
}