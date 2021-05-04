package com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Ports;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Index;

import java.util.Optional;

public interface IndexRepository {
    Optional<Index> find(String referenceId);
    void save(Index index);
}
