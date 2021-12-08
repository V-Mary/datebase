package com.martciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.martciv.repository.RouteRepository;
import com.martciv.models.domain.Route;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    public List<Route> getAll() {
        return routeRepository.findAll();
    }

    public Route getById(Integer id) {
        return routeRepository.findById(id).get();
    }

    @Transactional
    public Route create(Route route) {
        return routeRepository.save(route);
    }

    @Transactional
    public void updateById(Route route, Integer id) {
        Route updatedRoute = routeRepository.findById(id).get();
        updatedRoute.setFrom(route.getFrom());
        updatedRoute.setTo(route.getTo());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!routeRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        routeRepository.deleteById(id);
    }
}