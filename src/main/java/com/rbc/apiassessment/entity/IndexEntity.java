package com.rbc.apiassessment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "index")
public class IndexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "quarter", nullable = false)
    private int quarter;

    @Column(name = "stock", nullable = false)
    private String stock;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "open", nullable = false)
    private double open;

    @Column(name = "high", nullable = false)
    private double high;

    @Column(name = "low", nullable = false)
    private double low;

    @Column(name = "close", nullable = false)
    private double close;

    @Column(name = "volume", nullable = false)
    private long volume;

    @Column(name = "percent_change_price", nullable = false)
    private double percentChangePrice;

    @Column(name = "percent_change_volume_over_last_wk", nullable = true)
    private double percentChangeVolumeOverLastWeek;

    @Column(name = "previous_weeks_volume", nullable = true)
    private long previousWeeksVolume;

    @Column(name = "next_weeks_open", nullable = false)
    private double nextWeeksOpen;

    @Column(name = "next_weeks_close", nullable = false)
    private double nextWeeksClose;

    @Column(name = "percent_change_next_weeks_price", nullable = false)
    private double percentChangeNextWeeksPrice;

    @Column(name = "days_to_next_dividend", nullable = false)
    private int daysToNextDividend;

    @Column(name = "percent_return_next_dividend", nullable = false)
    private double percentReturnNextDividend;

    @Column(name = "last_update_date_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
