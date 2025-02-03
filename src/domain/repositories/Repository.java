package domain.repositories;

public interface Repository<T> {
    T getById(int id);
    T create(T data);
}
