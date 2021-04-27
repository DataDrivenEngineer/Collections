package dbelousov.petprojects.collections.graph;

import java.util.Objects;

public class Vertex<T> {

    private int discoveryTime;
    private int finalizationTime;
    private boolean isFinalized = false;
    private T val;

    public Vertex(T val) {
        this.val = val;
    }

    public int getDiscoveryTime() {
        return discoveryTime;
    }

    public void setDiscoveryTime(int discoveryTime) {
        this.discoveryTime = discoveryTime;
    }

    public int getFinalizationTime() {
        return finalizationTime;
    }

    public void setFinalizationTime(int finalizationTime) {
        this.finalizationTime = finalizationTime;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalized(boolean finalized) {
        isFinalized = finalized;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(val, vertex.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
