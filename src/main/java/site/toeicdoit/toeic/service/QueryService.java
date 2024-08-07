package site.toeicdoit.toeic.service;

import java.util.List;
import java.util.Optional;

public interface QueryService <T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    Boolean existsById(Long id);
}
