package com.rbc.apiassessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Index {

    @NotNull
    private int quarter;

    @NotBlank
    private String stock;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate date;

    @NotBlank
    private String open;

    @NotBlank
    private String high;

    @NotBlank
    private String low;

    @NotBlank
    private String close;

    @NotNull
    private long volume;

    @NotNull
    private double percentChangePrice;

    private double percentChangeVolumeOverLastWeek;

    private long previousWeeksVolume;

    @NotBlank
    private String nextWeeksOpen;

    @NotBlank
    private String nextWeeksClose;

    @NotNull
    private double percentChangeNextWeeksPrice;

    @NotNull
    private int daysToNextDividend;

    @NotNull
    private double percentReturnNextDividend;

}
