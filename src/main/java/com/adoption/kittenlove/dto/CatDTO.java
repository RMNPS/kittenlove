package com.adoption.kittenlove.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class CatDTO extends AbstractDTO {
    private String breed;
    private LocalDate birthdate;
    private String description;
}
