package com.adoption.kittenlove.config;

import com.adoption.kittenlove.data.AbstractEntity;
import com.adoption.kittenlove.dto.AbstractDTO;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.sqids.Sqids;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.adoption.kittenlove")
public class WebConfig {

    @Value("sqids.alphabet")
    private String sqidsAlphabet;

    private Sqids sqids = null;

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        modelMapper
                .typeMap(AbstractEntity.class, AbstractDTO.class)
                .addMappings(mapper -> mapper.using(ctx -> (sqids.encode(List.of((Long) ctx.getSource()))))
                        .map(AbstractEntity::getId, AbstractDTO::setUid));

        modelMapper
                .typeMap(AbstractDTO.class, AbstractEntity.class)
                .addMappings(mapper -> mapper.using(ctx -> sqids.decode((String) ctx.getSource()).get(0))
                        .map(AbstractDTO::getUid, AbstractEntity::setId));

        return modelMapper;
    }

    @Bean
    public Sqids sqids() {
        if (sqids != null) return sqids;

        return Sqids.builder()
                .alphabet(sqidsAlphabet)
                .minLength(10)
                .build();
    }
}
