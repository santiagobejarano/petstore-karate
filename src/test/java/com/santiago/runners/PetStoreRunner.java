package com.santiago.runners;

import com.intuit.karate.junit5.Karate;

class PetStoreRunner {

    @Karate.Test
    Karate testPetStore() {
        // Busca el feature en src/test/resources/features con extensión .feature
        return Karate.run("classpath:features/petstore.feature");
    }
}
