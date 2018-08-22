package com.batch;


import com.model.Entry;
import com.listener.CustomItemWriterListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    EntityManagerFactory emf;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private DataSource dataSource;


    @Bean
    public FlatFileItemReader<Entry> reader() {
        FlatFileItemReader<Entry> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("file1.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Entry>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"id", "name", "value"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Entry>() {{
                setTargetType(Entry.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<Entry, Entry> processor() {
        return person -> person;
    }


    @Bean
    public CustomItemWriterListener itemWriterListener() {
        return new CustomItemWriterListener();
    }

    @Bean
    public JdbcBatchItemWriter<Entry> writer() {
        JdbcBatchItemWriter<Entry> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO entry (id, name, value) VALUES (:id, :name, :value)");
        writer.setDataSource(dataSource);
        return writer;
    }


    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Entry, Entry>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .listener(itemWriterListener())
                .build();
    }

    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("EntryJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

}


