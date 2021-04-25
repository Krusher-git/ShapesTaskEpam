package com.kozich.shape.repository.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepository implements Repository<EllipseFigure> {
    private static EllipseRepository repository = null;
    private List<EllipseFigure> ellipseFigureList;


    public static EllipseRepository getInstance() {
        if (repository == null) {
            repository = new EllipseRepository();
        }
        return repository;
    }

    private EllipseRepository() {
        ellipseFigureList = new ArrayList<>();
    }

    @Override
    public boolean add(EllipseFigure element) {
        return ellipseFigureList.add(element);
    }

    @Override
    public boolean remove(EllipseFigure element) {
        return ellipseFigureList.remove(element);
    }

    @Override
    public boolean addAll(Collection<? extends EllipseFigure> elements) {
        return ellipseFigureList.addAll(elements);
    }

    @Override
    public boolean removeAll(Collection<? extends EllipseFigure> elements) {
        return ellipseFigureList.removeAll(elements);
    }

    @Override
    public List<EllipseFigure> sort(Comparator<? super EllipseFigure> comparator) {
        return ellipseFigureList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
