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
                .outputCucumberJson(true)
                .tags("~@ignore")
                .parallel(4);

        generateCucumberReport(results.getReportDir());

        if (results.getFailCount() > 0) {
            throw new RuntimeException("Pruebas fallidas: " + results.getErrorMessages());
        }
    }

    public static void generateCucumberReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(
                new File(karateOutputPath), new String[]{"json"}, true
        );

        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        File reportOutputDirectory = new File("build/cucumber-html-reports");
        String projectName = "Petstore Karate API Tests";

        Configuration config = new Configuration(reportOutputDirectory, projectName);

        config.setBuildNumber("1.0");
        config.addClassifications("Platform", "Windows");
        config.addClassifications("Browser", "API Tests");
        config.addClassifications("Branch", "main");

        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();

        System.out.println("Reporte HTML de Cucumber generado en: build/cucumber-html-reports/");
    }
}
