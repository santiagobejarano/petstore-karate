function fn() {
    var env = karate.env;
    karate.log('karate.env system property was:', env);

    if (!env) {
        env = 'dev';
    }

    var petstore = 'https://petstore.swagger.io/v2/';

    var config = {
        env: env,
        baseUrl: petstore
    };

    return config;
}
