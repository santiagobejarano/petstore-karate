package com.santiago.runners;

import com.intuit.karate.junit5.Karate;

class PetStoreRunner {

    @Karate.Test
    Karate testPetStore() {
        return Karate.run("classpath:features/petstore.feature");
    }
}
