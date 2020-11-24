package com.nirmal.customer.domain.aware;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

  @Value("${customer.service.source.code}")
  private String auditor;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(auditor);
    }
}
