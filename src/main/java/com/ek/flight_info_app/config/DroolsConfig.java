package com.ek.flight_info_app.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    private static final String PRICING_RULES_DRL = "rules/pricing-rules.drl";
    private static final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieSession kieSession() {
        var kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(PRICING_RULES_DRL));
        var kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        var kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId()).newKieSession();
    }
}
