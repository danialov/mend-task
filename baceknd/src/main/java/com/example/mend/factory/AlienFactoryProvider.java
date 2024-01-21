package com.example.mend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AlienFactoryProvider {

    private final Map<String, AlienFactory> factories;

    @Autowired
    public AlienFactoryProvider(List<AlienFactory> factoryList) {
        factories = factoryList
                .stream()
                .collect(Collectors.toMap(this::getType, Function.identity()));
    }

    private String getType(AlienFactory factory) {
        String className = factory.getClass().getSimpleName();
        return className.replace("Factory", "");
    }

    public AlienFactory getFactory(String type) {
        return factories.get(type);
    }
}
