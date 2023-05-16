package com.expenses.tracker.expensestracker.basicTests.configurationTests;

import com.expenses.tracker.expensestracker.SetupTestContainers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestContainerTests extends SetupTestContainers {
    @Test
    void canStartPostgresDB() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
        assertThat(postgreSQLContainer.isCreated()).isTrue();
    }
}
