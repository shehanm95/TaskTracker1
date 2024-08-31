package com.easternpearl.tasktracker.medel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ToDo {
    int id;
    String Title;
    int category;
    String Description;
    Boolean finished;
    LocalDate startDate;
    LocalDate endDate;
}
