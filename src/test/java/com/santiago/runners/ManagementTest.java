package com.santiago.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManagementTest {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:features")
                .outputCucumberJson(true)    // genera JSON para el reporte
                .tags("~@ignore")            // ignora escenarios con @ignore
                .parallel(4);                // número de hilos en paralelo

        if (results.getFailCount() > 0) {
            throw new RuntimeException("Pruebas fallidas: " + results.getErrorMessages());
        }

        generateReport(results.getReportDir());
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(
                new File(karateOutputPath), new String[]{"json"}, true
        );

        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        Configuration config = new Configuration(new File("build"), "Petstore-Karate");

        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
