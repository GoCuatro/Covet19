package com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.ValueObjects.RefererenceValueObject;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.ValueObjects.RolValueObject;

public class Index {
    private RefererenceValueObject refererenceValueObject;
    private RolValueObject rolValueObject;

    public Index(RefererenceValueObject refererenceValueObject, RolValueObject rolValueObject) {
        this.refererenceValueObject = refererenceValueObject;
        this.rolValueObject = rolValueObject;
    }

    public static Index create(String referenceId, String rol){
        return new Index(new RefererenceValueObject(referenceId), new RolValueObject(rol));
    }
}
