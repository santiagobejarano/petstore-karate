function fn() {
    var env = karate.env; // obtiene el valor pasado con -Dkarate.env
    karate.log('karate.env system property was:', env);

    if (!env) {
        env = 'dev'; // por defecto
    }

    var petstore = 'https://petstore.swagger.io/v2/';

    var config = {
        env: env,
        baseUrl: petstore
    };

    if (env == 'dev') {
        // configuración extra para dev
    } else if (env == 'e2e') {
        // configuración extra para e2e
    }

    return config;
}
