package com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Application.Find;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Index;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Ports.IndexRepository;

import java.util.Optional;

public class FindIndex {
    private final IndexRepository indexRepository;

    public FindIndex(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    public Optional<Index> execute(String referenceId) {
        return indexRepository.find(referenceId);
    }
}
