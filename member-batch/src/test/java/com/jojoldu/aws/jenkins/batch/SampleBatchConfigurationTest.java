package com.jojoldu.aws.jenkins.batch;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "job.name=sampleBatch")
public class SampleBatchConfigurationTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void 샘플_배치() throws Exception {
		//given
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addString("version", LocalDateTime.now().toString());

		//when
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(builder.toJobParameters());

		//then
		Assert.assertThat(jobExecution.getStatus(), Matchers.is(BatchStatus.COMPLETED));
	}
}
