package com.kozich.shape.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    boolean add(T element);

    boolean remove(T element);

    boolean addAll(Collection<? extends T> elements);

    boolean removeAll(Collection<? extends T> elements);

    List<T> sort(Comparator<? super T> comparator);
}
