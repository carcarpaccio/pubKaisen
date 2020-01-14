package com.example.kaisen_spring.model;

public enum EFieldInfo {
    ship("W"),
    attacked("・"),
    breaked("×"),
    empty("　"),
    enemyShip("　"),
    none("E");

    final private String label;

    EFieldInfo(final String label) {
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
