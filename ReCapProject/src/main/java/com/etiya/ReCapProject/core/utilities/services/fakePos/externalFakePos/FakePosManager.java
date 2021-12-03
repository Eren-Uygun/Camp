package com.etiya.ReCapProject.core.utilities.services.fakePos.externalFakePos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakePosManager implements FakePosService {

    private FakePos fakePos;

    @Autowired
    public FakePosManager(FakePos fakePos) {
        this.fakePos = fakePos;
    }

    @Override
    public boolean isPaymentDone() {
        return true;
    }


}
