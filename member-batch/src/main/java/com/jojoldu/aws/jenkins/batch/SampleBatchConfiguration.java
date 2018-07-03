package com.jojoldu.aws.jenkins.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class SampleBatchConfiguration {

    public static final String JOB_NAME = "sampleBatch";
    public static final String BEAN_PREFIX = JOB_NAME + "_";

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Value("${chunkSize:1000}")
    private int chunkSize;

    @Bean(BEAN_PREFIX + "job")
    public Job job() {
        return jobBuilderFactory.get(JOB_NAME)
                .start(step())
                .build();
    }

    @Bean(BEAN_PREFIX + "step")
    public Step step() {
        return stepBuilderFactory.get("step")
                .tasklet((contribution, chunkContext) -> {
                    log.info("샘플 배치입니다!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
