package com.santiago.runners;

import com.intuit.karate.junit5.Karate;

class PetStoreRunner {

    @Karate.Test
    Karate testPetStore() {
        // Busca el feature en src/test/resources/features
        return Karate.run("features/petstore").relativeTo(getClass());
    }
}
