package com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Index;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Ports.IndexRepository;

public class CreateIndex {
    private final IndexRepository indexRepository;

    public CreateIndex(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    public void execute(String referenceId, String rol){
        indexRepository.save(Index.create(referenceId, rol));
    }
}
